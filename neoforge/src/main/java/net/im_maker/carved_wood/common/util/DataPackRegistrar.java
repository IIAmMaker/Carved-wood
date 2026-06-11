package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforgespi.language.IModFileInfo;


import java.nio.file.Path;
import java.util.Optional;

@EventBusSubscriber(modid = CarvedWood.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataPackRegistrar {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            onAddPackFinders(event);
        }
    }

    private static void onAddPackFinders(AddPackFindersEvent event) {
        IModFileInfo mod = ModList.get().getModFileById(CarvedWood.MOD_ID);
        Path vanillabackport_datapack_file = mod.getFile().findResource("resourcepacks/carvedwood_vanillabackport_compat");

        if (ModList.get().isLoaded("vanillabackport")) {
            event.addRepositorySource(packConsumer -> packConsumer.accept(
                    Pack.readMetaAndCreate(
                            new PackLocationInfo(
                                    "carvedwood_vanillabackport_compat",
                                    Component.literal("CarvedWood VanillaBackport Compat"),
                                    PackSource.BUILT_IN,
                                    Optional.empty()
                            ),
                            new PathPackResources.PathResourcesSupplier(vanillabackport_datapack_file),
                            PackType.SERVER_DATA,
                            new PackSelectionConfig(
                                    true,
                                    Pack.Position.TOP,
                                    false)
                    )));
        }
    }
}