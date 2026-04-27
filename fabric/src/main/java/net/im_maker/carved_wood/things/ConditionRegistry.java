package net.im_maker.carved_wood.things;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public final class ConditionRegistry {
    private static final Map<ResourceLocation, MapCodec<? extends ICondition>> REGISTRY = new HashMap<>();
    private static final Map<MapCodec<? extends ICondition>, ResourceLocation> REVERSE = new HashMap<>();

    public static void register(ResourceLocation id, MapCodec<? extends ICondition> codec) {
        REGISTRY.put(id, codec);
        REVERSE.put(codec, id);
    }

    public static MapCodec<? extends ICondition> get(ResourceLocation id) {
        return REGISTRY.get(id);
    }

    public static ResourceLocation getId(MapCodec<? extends ICondition> codec) {
        return REVERSE.get(codec);
    }
}