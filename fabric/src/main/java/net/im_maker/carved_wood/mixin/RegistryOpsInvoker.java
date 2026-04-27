package net.im_maker.carved_wood.mixin;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.serialization.DynamicOps;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RegistryOps.class)
public interface RegistryOpsInvoker<T> {
    @Invoker("<init>")
    static <T> RegistryOps<T> invokeInit(DynamicOps<T> ops, RegistryOps.RegistryInfoLookup lookup) {
        throw new AssertionError();
    }
}