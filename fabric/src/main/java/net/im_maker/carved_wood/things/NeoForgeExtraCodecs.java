package net.im_maker.carved_wood.things;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapLike;
import com.mojang.serialization.RecordBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class NeoForgeExtraCodecs {
    public static <T> MapCodec<T> aliasedFieldOf(Codec<T> codec, String... names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("Must have at least one name!");
        } else {
            MapCodec<T> mapCodec = codec.fieldOf(names[0]);

            for(int i = 1; i < names.length; ++i) {
                mapCodec = mapWithAlternative(mapCodec, codec.fieldOf(names[i]));
            }

            return mapCodec;
        }
    }

    public static <T> MapCodec<T> optionalFieldAlwaysWrite(Codec<T> codec, String name, T defaultValue) {
        return codec.optionalFieldOf(name).xmap((o) -> o.orElse(defaultValue), Optional::of);
    }

    public static <T> MapCodec<T> mapWithAlternative(MapCodec<T> mapCodec, MapCodec<? extends T> alternative) {
        return Codec.mapEither(mapCodec, alternative).xmap((either) -> either.map(Function.identity(), Function.identity()), Either::left);
    }

    public static <T> MapCodec<Set<T>> singularOrPluralCodec(Codec<T> codec, String singularName) {
        return singularOrPluralCodec(codec, singularName, "%ss".formatted(singularName));
    }

    public static <T> MapCodec<Set<T>> singularOrPluralCodec(Codec<T> codec, String singularName, String pluralName) {
        return Codec.mapEither(codec.fieldOf(singularName), setOf(codec).fieldOf(pluralName)).xmap((either) -> (Set)either.map(ImmutableSet::of, ImmutableSet::copyOf), (set) -> set.size() == 1 ? Either.left(set.iterator().next()) : Either.right(set));
    }

    //public static <T> MapCodec<Set<T>> singularOrPluralCodecNotEmpty(Codec<T> codec, String singularName) {
    //    return singularOrPluralCodecNotEmpty(codec, singularName, "%ss".formatted(singularName));
    //}
//
    //public static <T> MapCodec<Set<T>> singularOrPluralCodecNotEmpty(Codec<T> codec, String singularName, String pluralName) {
    //    return Codec.mapEither(codec.fieldOf(singularName), setOf(codec).fieldOf(pluralName)).xmap((either) -> (ImmutableSet)either.map(ImmutableSet::of, ImmutableSet::copyOf), (set) -> set.size() == 1 ? Either.left(set.iterator().next()) : Either.right(set)).flatXmap((ts) -> ts.isEmpty() ? DataResult.error(() -> "The set for: %s can not be empty!".formatted(singularName)) : DataResult.success(ts), (ts) -> ts.isEmpty() ? DataResult.error(() -> "The set for: %s can not be empty!".formatted(singularName)) : DataResult.success(ImmutableSet.copyOf(ts)));
    //}

    public static <T> Codec<Set<T>> setOf(Codec<T> codec) {
        return Codec.list(codec).xmap(ImmutableSet::copyOf, ImmutableList::copyOf);
    }

    public static <A> Codec<A> decodeOnly(Decoder<A> decoder) {
        return Codec.of(Codec.unit(() -> {
            throw new UnsupportedOperationException("Cannot encode with decode-only codec! Decoder:" + String.valueOf(decoder));
        }), decoder, "DecodeOnly[" + String.valueOf(decoder) + "]");
    }

    public static <A> Codec<List<A>> listWithOptionalElements(Codec<Optional<A>> elementCodec) {
        return listWithoutEmpty(elementCodec.listOf());
    }

    public static <A> Codec<List<A>> listWithoutEmpty(Codec<List<Optional<A>>> codec) {
        return codec.xmap((list) -> list.stream().filter(Optional::isPresent).map(Optional::get).toList(), (list) -> list.stream().map(Optional::of).toList());
    }

    public static <T> Codec<T> withAlternative(Codec<T> codec, Codec<T> alternative) {
        return new AlternativeCodec<T>(codec, alternative);
    }

    public static <T> MapCodec<T> withAlternative(MapCodec<T> codec, MapCodec<T> alternative) {
        return new AlternativeMapCodec<T>(codec, alternative);
    }

    public static <A, E, B> MapCodec<Either<E, B>> dispatchMapOrElse(Codec<A> typeCodec, Function<? super E, ? extends A> type, Function<? super A, ? extends MapCodec<? extends E>> codec, final MapCodec<B> fallbackCodec) {
        final MapCodec<E> dispatchCodec = typeCodec.dispatchMap(type, codec);
        return new MapCodec<Either<E, B>>() {
            public <T> Stream<T> keys(DynamicOps<T> ops) {
                return Stream.concat(dispatchCodec.keys(ops), fallbackCodec.keys(ops)).distinct();
            }

            public <T> DataResult<Either<E, B>> decode(DynamicOps<T> ops, MapLike<T> input) {
                return input.get("type") != null ? dispatchCodec.decode(ops, input).map(Either::left) : fallbackCodec.decode(ops, input).map(Either::right);
            }

            public <T> RecordBuilder<T> encode(Either<E, B> input, DynamicOps<T> ops, RecordBuilder<T> prefix) {
                return (RecordBuilder)input.map((dispatched) -> dispatchCodec.encode(dispatched, ops, prefix), (fallback) -> fallbackCodec.encode(fallback, ops, prefix));
            }

            public String toString() {
                String var10000 = String.valueOf(dispatchCodec);
                return "DispatchOrElse[" + var10000 + ", " + String.valueOf(fallbackCodec) + "]";
            }
        };
    }

    public static <F, S> MapCodec<Either<F, S>> xor(MapCodec<F> first, MapCodec<S> second) {
        return new XorMapCodec(first, second);
    }

    private static record AlternativeCodec<T>(Codec<T> codec, Codec<T> alternative) implements Codec<T> {
        public <T1> DataResult<Pair<T, T1>> decode(DynamicOps<T1> ops, T1 input) {
            DataResult<Pair<T, T1>> result = this.codec.decode(ops, input);
            return result.error().isEmpty() ? result : this.alternative.decode(ops, input);
        }

        public <T1> DataResult<T1> encode(T input, DynamicOps<T1> ops, T1 prefix) {
            DataResult<T1> result = this.codec.encode(input, ops, prefix);
            return result.error().isEmpty() ? result : this.alternative.encode(input, ops, prefix);
        }

        public String toString() {
            String var10000 = String.valueOf(this.codec);
            return "Alternative[" + var10000 + ", " + String.valueOf(this.alternative) + "]";
        }
    }

    private static class AlternativeMapCodec<T> extends MapCodec<T> {
        private final MapCodec<T> codec;
        private final MapCodec<T> alternative;

        private AlternativeMapCodec(MapCodec<T> codec, MapCodec<T> alternative) {
            this.codec = codec;
            this.alternative = alternative;
        }

        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.concat(this.codec.keys(ops), this.alternative.keys(ops)).distinct();
        }

        public <T1> DataResult<T> decode(DynamicOps<T1> ops, MapLike<T1> input) {
            DataResult<T> result = this.codec.decode(ops, input);
            return result.error().isEmpty() ? result : this.alternative.decode(ops, input);
        }

        public <T1> RecordBuilder<T1> encode(T input, DynamicOps<T1> ops, RecordBuilder<T1> prefix) {
            DataResult<T1> result = this.codec.encode(input, ops, prefix).build(ops.empty());
            return result.error().isEmpty() ? this.codec.encode(input, ops, prefix) : this.alternative.encode(input, ops, prefix);
        }

        public String toString() {
            String var10000 = String.valueOf(this.codec);
            return "AlternativeMapCodec[" + var10000 + ", " + String.valueOf(this.alternative) + "]";
        }
    }

    private static final class XorMapCodec<F, S> extends MapCodec<Either<F, S>> {
        private final MapCodec<F> first;
        private final MapCodec<S> second;

        private XorMapCodec(MapCodec<F> first, MapCodec<S> second) {
            this.first = first;
            this.second = second;
        }

        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.concat(this.first.keys(ops), this.second.keys(ops)).distinct();
        }

        public <T> DataResult<Either<F, S>> decode(DynamicOps<T> ops, MapLike<T> input) {
            DataResult<Either<F, S>> firstResult = this.first.decode(ops, input).map(Either::left);
            DataResult<Either<F, S>> secondResult = this.second.decode(ops, input).map(Either::right);
            Optional<Either<F, S>> firstValue = firstResult.result();
            Optional<Either<F, S>> secondValue = secondResult.result();
            if (firstValue.isPresent() && secondValue.isPresent()) {
                return DataResult.error(() -> {
                    String var10000 = String.valueOf(firstValue.get());
                    return "Both alternatives read successfully, cannot pick the correct one; first: " + var10000 + " second: " + String.valueOf(secondValue.get());
                }, (Either)firstValue.get());
            } else if (firstValue.isPresent()) {
                return firstResult;
            } else {
                return secondValue.isPresent() ? secondResult : firstResult.apply2((x, y) -> y, secondResult);
            }
        }

        public <T> RecordBuilder<T> encode(Either<F, S> input, DynamicOps<T> ops, RecordBuilder<T> prefix) {
            return (RecordBuilder)input.map((x) -> this.first.encode(x, ops, prefix), (x) -> this.second.encode(x, ops, prefix));
        }

        public String toString() {
            String var10000 = String.valueOf(this.first);
            return "XorMapCodec[" + var10000 + ", " + String.valueOf(this.second) + "]";
        }
    }
}
