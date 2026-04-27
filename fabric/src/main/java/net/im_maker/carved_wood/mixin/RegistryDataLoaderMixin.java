package net.im_maker.carved_wood.mixin;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import net.im_maker.carved_wood.things.ConditionalOps;
import net.im_maker.carved_wood.things.ICondition;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.*;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.Reader;
import java.rmi.registry.Registry;
import java.util.Map;

@Mixin(RegistryDataLoader.class)
public class RegistryDataLoaderMixin {

    @WrapOperation(
            method = "loadContentsFromManager",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/core/RegistryOps;create(Lcom/mojang/serialization/DynamicOps;Lnet/minecraft/core/RegistryOps$RegistryInfoLookup;)Lnet/minecraft/core/RegistryOps;"

            )
    )
    private static RegistryOps<JsonElement> wrapWithConditions(
            DynamicOps<JsonElement> ops,
            RegistryOps.RegistryInfoLookup lookup,
            Operation<RegistryOps<JsonElement>> original
    ) {
        RegistryOps<JsonElement> base = original.call(ops, lookup);

        // NeoForge equivalent behavior
        return new ConditionalOps<>(ops, lookup, ICondition.IContext.TAGS_INVALID).unwrap();
    }
}