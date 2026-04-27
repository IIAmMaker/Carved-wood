package net.im_maker.carved_wood.things;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.RecordBuilder;
import java.util.List;
import java.util.Optional;

import net.im_maker.carved_wood.mixin.RegistryOpsInvoker;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.ExtraCodecs;

public class ConditionalOps<T> {
    private final RegistryOps<T> delegate;
    private final ICondition.IContext context;
    public static final String DEFAULT_CONDITIONS_KEY = "neoforge:conditions";
    public static final String CONDITIONAL_VALUE_KEY = "neoforge:value";

    public ConditionalOps(DynamicOps<T> ops,
                          RegistryOps.RegistryInfoLookup lookup,
                          ICondition.IContext context) {
        this.delegate = RegistryOpsInvoker.invokeInit(ops, lookup);
        this.context = context;
    }

    public RegistryOps<T> unwrap() {
        return delegate;
    }

    public static MapCodec<ICondition.IContext> retrieveContext() {
        return ExtraCodecs.retrieveContext((ops) -> {
            if (ops instanceof ConditionalOps<?> conditionalOps) {
                return DataResult.success(conditionalOps.context);
            } else {
                return DataResult.success(ICondition.IContext.EMPTY);
            }
        });
    }

    public static <T> Codec<Optional<T>> createConditionalCodec(Codec<T> ownerCodec) {
        return createConditionalCodec(ownerCodec, "neoforge:conditions");
    }

    public static <T> Codec<Optional<T>> createConditionalCodec(Codec<T> ownerCodec, String conditionalsKey) {
        return createConditionalCodecWithConditions(ownerCodec, conditionalsKey).xmap((r) -> r.map(WithConditions::carrier), (r) -> r.map((i) -> new WithConditions(List.of(), i)));
    }

    public static <T> Codec<List<T>> decodeListWithElementConditions(Codec<T> ownerCodec) {
        return Codec.of(ownerCodec.listOf(), NeoForgeExtraCodecs.listWithOptionalElements(createConditionalCodec(ownerCodec)));
    }

    public static <T> Codec<Optional<WithConditions<T>>> createConditionalCodecWithConditions(Codec<T> ownerCodec) {
        return createConditionalCodecWithConditions(ownerCodec, "neoforge:conditions");
    }

    public static <T> Codec<Optional<WithConditions<T>>> createConditionalCodecWithConditions(Codec<T> ownerCodec, String conditionalsKey) {
        return Codec.of(new ConditionalEncoder(conditionalsKey, ICondition.LIST_CODEC, ownerCodec), new ConditionalDecoder(conditionalsKey, ICondition.LIST_CODEC, retrieveContext().codec(), ownerCodec));
    }

    private static final class ConditionalEncoder<A> implements Encoder<Optional<WithConditions<A>>> {
        private final String conditionalsPropertyKey;
        public final Codec<List<ICondition>> conditionsCodec;
        private final Encoder<A> innerCodec;

        private ConditionalEncoder(String conditionalsPropertyKey, Codec<List<ICondition>> conditionsCodec, Encoder<A> innerCodec) {
            this.conditionalsPropertyKey = conditionalsPropertyKey;
            this.conditionsCodec = conditionsCodec;
            this.innerCodec = innerCodec;
        }

        public <T> DataResult<T> encode(Optional<WithConditions<A>> input, DynamicOps<T> ops, T prefix) {
            if (ops.compressMaps()) {
                return DataResult.error(() -> "Cannot use ConditionalCodec with compressing DynamicOps");
            } else if (input.isEmpty()) {
                return DataResult.error(() -> "Cannot encode empty Optional with a ConditionalEncoder. We don't know what to encode to!");
            } else {
                WithConditions<A> withConditions = (WithConditions)input.get();
                if (withConditions.conditions().isEmpty()) {
                    return this.innerCodec.encode(withConditions.carrier(), ops, prefix);
                } else {
                    RecordBuilder<T> recordBuilder = ops.mapBuilder();
                    recordBuilder.add(this.conditionalsPropertyKey, this.conditionsCodec.encodeStart(ops, withConditions.conditions()));
                    DataResult<T> encodedInner = this.innerCodec.encodeStart(ops, withConditions.carrier());
                    return encodedInner.flatMap((inner) -> (DataResult)ops.getMap(inner).map((innerMap) -> {
                        if (innerMap.get(this.conditionalsPropertyKey) == null && innerMap.get("neoforge:value") == null) {
                            innerMap.entries().forEach((pair) -> recordBuilder.add(pair.getFirst(), pair.getSecond()));
                            return recordBuilder.build(prefix);
                        } else {
                            return DataResult.error(() -> "Cannot wrap a value that already uses the condition or value key with a ConditionalCodec.");
                        }
                    }).result().orElseGet(() -> {
                        recordBuilder.add("neoforge:value", inner);
                        return recordBuilder.build(prefix);
                    }));
                }
            }
        }

        public String toString() {
            return "Conditional[" + String.valueOf(this.innerCodec) + "]";
        }
    }

    private static final class ConditionalDecoder<A> implements Decoder<Optional<WithConditions<A>>> {
        private final String conditionalsPropertyKey;
        public final Codec<List<ICondition>> conditionsCodec;
        private final Codec<ICondition.IContext> contextCodec;
        private final Decoder<A> innerCodec;

        private ConditionalDecoder(String conditionalsPropertyKey, Codec<List<ICondition>> conditionsCodec, Codec<ICondition.IContext> contextCodec, Decoder<A> innerCodec) {
            this.conditionalsPropertyKey = conditionalsPropertyKey;
            this.conditionsCodec = conditionsCodec;
            this.contextCodec = contextCodec;
            this.innerCodec = innerCodec;
        }

        public <T> DataResult<Pair<Optional<WithConditions<A>>, T>> decode(DynamicOps<T> ops, T input) {
            return ops.compressMaps() ? DataResult.error(() -> "Cannot use ConditionalCodec with compressing DynamicOps") : (DataResult)ops.getMap(input).map((inputMap) -> {
                T conditionsDataCarrier = (T)inputMap.get(this.conditionalsPropertyKey);
                return conditionsDataCarrier == null ? this.innerCodec.decode(ops, input).map((result) -> result.mapFirst((carrier) -> Optional.of(new WithConditions(carrier)))) : this.conditionsCodec.decode(ops, conditionsDataCarrier).flatMap((conditionsCarrier) -> {
                    List<ICondition> conditions = (List)conditionsCarrier.getFirst();
                    DataResult<Pair<ICondition.IContext, T>> contextDataResult = this.contextCodec.decode(ops, ops.emptyMap());
                    return contextDataResult.flatMap((contextCarrier) -> {
                        ICondition.IContext context = (ICondition.IContext)contextCarrier.getFirst();
                        boolean conditionsMatch = conditions.stream().allMatch((c) -> c.test(context));
                        if (!conditionsMatch) {
                            return DataResult.success(Pair.of(Optional.empty(), input));
                        } else {
                            T valueDataCarrier = (T)inputMap.get("neoforge:value");
                            DataResult<Pair<A, T>> innerDecodeResult;
                            if (valueDataCarrier != null) {
                                innerDecodeResult = this.innerCodec.decode(ops, valueDataCarrier);
                            } else {
                                T conditionalsKey = (T)ops.createString(this.conditionalsPropertyKey);
                                T mapForDecoding = (T)ops.createMap(inputMap.entries().filter((pair) -> !pair.getFirst().equals(conditionalsKey)));
                                innerDecodeResult = this.innerCodec.decode(ops, mapForDecoding);
                            }

                            DataResult<Pair<Optional<WithConditions<A>>, T>> ret = innerDecodeResult.map((result) -> result.mapFirst((carrier) -> Optional.of(new WithConditions(conditions, carrier))));
                            return ret;
                        }
                    });
                });
            }).result().orElseGet(() -> this.innerCodec.decode(ops, input).map((result) -> result.mapFirst((carrier) -> Optional.of(new WithConditions(carrier)))));
        }
    }
}
