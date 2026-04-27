package net.im_maker.carved_wood.things;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.MapCodec;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Unit;
//import net.neoforged.neoforge.registries.NeoForgeRegistries;

public interface ICondition {
    //Codec<ICondition> CODEC = NeoForgeRegistries.CONDITION_SERIALIZERS.byNameCodec().dispatch(ICondition::codec, Function.identity());
    //Codec<List<ICondition>> LIST_CODEC = CODEC.listOf();
    Codec<ICondition> CODEC = ResourceLocation.CODEC.dispatch(
            "type",
            condition -> ConditionRegistry.getId(condition.codec()),
            id -> {
                MapCodec<? extends ICondition> codec = ConditionRegistry.get(id);
                if (codec == null) {
                    throw new IllegalStateException("Unknown condition: " + id);
                }
                return codec;
            }
    );

    Codec<List<ICondition>> LIST_CODEC = CODEC.listOf();

    static <V, T> Optional<T> getConditionally(Codec<T> codec, DynamicOps<V> ops, V element) {
        return getWithConditionalCodec(ConditionalOps.createConditionalCodec(codec), ops, element);
    }

    static <V, T> Optional<T> getWithConditionalCodec(Codec<Optional<T>> codec, DynamicOps<V> ops, V element) {
        return (Optional)codec.parse(ops, element).getOrThrow(JsonParseException::new);
    }

    static <V, T> Optional<T> getWithWithConditionsCodec(Codec<Optional<WithConditions<T>>> codec, DynamicOps<V> ops, V elements) {
        return codec.parse(ops, elements).promotePartial(m -> {
        }).getOrThrow(JsonParseException::new).map(WithConditions::carrier);
    }

    static <V> boolean conditionsMatched(DynamicOps<V> ops, V element) {
        Codec<Unit> codec = Codec.unit(Unit.INSTANCE);
        return getConditionally(codec, ops, element).isPresent();
    }

    static void writeConditions(HolderLookup.Provider registries, JsonObject jsonObject, ICondition... conditions) {
        writeConditions(registries, jsonObject, List.of(conditions));
    }

    static void writeConditions(HolderLookup.Provider registries, JsonObject jsonObject, List<ICondition> conditions) {
        writeConditions((DynamicOps)RegistryOps.create(JsonOps.INSTANCE, registries), jsonObject, (List)conditions);
    }

    static void writeConditions(DynamicOps<JsonElement> jsonOps, JsonObject jsonObject, List<ICondition> conditions) {
        if (!conditions.isEmpty()) {
            DataResult<JsonElement> result = LIST_CODEC.encodeStart(jsonOps, conditions);
            JsonElement serializedConditions = (JsonElement)result.result().orElseThrow(() -> new RuntimeException("Failed to serialize conditions"));
            jsonObject.add("neoforge:conditions", serializedConditions);
        }

    }

    boolean test(IContext var1);

    MapCodec<? extends ICondition> codec();

    public interface IContext {
        IContext EMPTY = new IContext() {
            public <T> Map<ResourceLocation, Collection<Holder<T>>> getAllTags(ResourceKey<? extends Registry<T>> registry) {
                return Collections.emptyMap();
            }
        };
        IContext TAGS_INVALID = new IContext() {
            public <T> Map<ResourceLocation, Collection<Holder<T>>> getAllTags(ResourceKey<? extends Registry<T>> registry) {
                throw new UnsupportedOperationException("Usage of tag-based conditions is not permitted in this context!");
            }
        };

        default <T> Collection<Holder<T>> getTag(TagKey<T> key) {
            return (Collection)this.getAllTags(key.registry()).getOrDefault(key.location(), Set.of());
        }

        <T> Map<ResourceLocation, Collection<Holder<T>>> getAllTags(ResourceKey<? extends Registry<T>> var1);
    }
}
