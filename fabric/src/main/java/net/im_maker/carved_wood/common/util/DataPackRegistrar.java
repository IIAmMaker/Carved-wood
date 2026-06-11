package net.im_maker.carved_wood.common.util;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.im_maker.carved_wood.CarvedWood;

import java.util.Optional;

public class DataPackRegistrar {

    private static void registerBuiltinVanillaBackportDataPack(ModContainer modContainer, String packId) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                CarvedWood.newRL(CarvedWood.MOD_ID, packId),
                modContainer,
                "CarvedWood VanillaBackport Compat",
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static void loadBuiltinResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(CarvedWood.MOD_ID);
        if (modContainer.isPresent()) {
            if (FabricLoader.getInstance().isModLoaded("vanillabackport")) {
                registerBuiltinVanillaBackportDataPack(modContainer.get(), "carvedwood_vanillabackport_compat");
            }
        }
    }
}