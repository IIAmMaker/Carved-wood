package net.im_maker.carved_wood;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.common.registers.CWBlockEntities;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.common.util.AddToCreativeInv;
import net.im_maker.carved_wood.config.ConfigValueCondition;
import net.im_maker.carved_wood.config.FabricConfig;
import net.im_maker.carved_wood.platform.*;
import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.im_maker.carved_wood.common.registers.CWPoi;
import net.im_maker.carved_wood.common.util.DataPackRegistrar;
import net.im_maker.carved_wood.compatibility.WoodGood.ModCompat;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarvedWoodFabric implements ModInitializer {
    public static final String MOD_ID = CarvedWood.MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        PlatHelper.setInstance(new FabricPlatHelper());

        FabricConfig.load();
        ResourceConditions.register(ConfigValueCondition.TYPE);

        CWBlocks.register();
        CWBlockEntities.register();
        CWRecipes.register();
        CWPoi.register();

        DataPackRegistrar.register();

        everyCompatModule();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(AddToCreativeInv::addBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(AddToCreativeInv::addFunctionalBlocks);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(AddToCreativeInv::addRedstoneBlocks);
    }

    private static void everyCompatModule() {
        try {
            if (FabricLoader.getInstance().isModLoaded("everycomp")) {
                ModCompat.init();
            } else {
                LOGGER.info("EveryCompat module is not loaded");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to start EveryComp module", e);
        }
    }
}
