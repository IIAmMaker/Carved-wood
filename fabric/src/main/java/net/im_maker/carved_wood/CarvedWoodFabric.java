package net.im_maker.carved_wood;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        //Registry.register(
        //        ConfigValueCondition.TYPE,
        //        ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "config"),
        //        ConfigValueCondition.TYPE
        //);

        CWBlocks.registerBlocks();

        CWBlockEntities.registerBlockEntities();

        DataPackRegistrar.loadBuiltinResourcePacks();
        everyCompatModule();

        CWRecipes.registerRecipeSerializers();
        CWPoi.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(AddToCreativeInv::addBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(AddToCreativeInv::addFunctionalBlocks);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(AddToCreativeInv::addRedstoneBlocks);
        addPackFinders();
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

    public static void addPackFinders() {
        ModContainer create = FabricLoader.getInstance().getModContainer(MOD_ID)
                .orElseThrow(() -> new IllegalStateException("CarvedWood's ModContainer couldn't be found!"));
        ResourceLocation packId = CarvedWood.newRL(MOD_ID, "recarved");
        ResourceManagerHelper.registerBuiltinResourcePack(packId, create, "Recarved", ResourcePackActivationType.NORMAL);
    }

    //BUILDING_BLOCKS
    public static void addToBuildingBlocksTap(FabricItemGroupEntries entries) {
        for (String woodType : CarvedWood.WOOD_TYPES) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block planks = CarvedWood.getBlockFromString("minecraft", woodType + "_planks");
            Block planksTiles = CarvedWood.getBlockFromString(woodType + "_tiles");
            Block PlanksP = CarvedWood.getBlockFromString(woodType + "_panels");
            Block bPlanks = CarvedWood.getBlockFromString(woodType + "_boards");
            Block sPlanks = CarvedWood.getBlockFromString("smooth_" + woodType + "_boards");
            Block mPlanks = CarvedWood.getBlockFromString(woodType + "_mosaic");
            Block cPlanks = CarvedWood.getBlockFromString("carved_" + woodType + "_planks");
            Block lPlanks = CarvedWood.getBlockFromString(woodType + "_lantern_block");
            Block pPlanks = CarvedWood.getBlockFromString(woodType + "_pillar");
            Block planksStairs = CarvedWood.getBlockFromString("minecraft", woodType + "_stairs");
            Block mPlanksStairs = CarvedWood.getBlockFromString(woodType + "_mosaic_stairs");
            Block tPlanksStairs = CarvedWood.getBlockFromString(woodType + "_tile_stairs");
            Block planksSlab = CarvedWood.getBlockFromString("minecraft", woodType + "_slab");
            Block mPlanksSlab = CarvedWood.getBlockFromString(woodType + "_mosaic_slab");
            Block tPlanksSlab = CarvedWood.getBlockFromString(woodType + "_tile_slab");
            String trunkType;
            switch (woodType) {
                case "crimson", "warped" -> trunkType = "_stem";
                case "bamboo" -> trunkType = "";
                default -> trunkType = "_log";
            }
            Block log = CarvedWood.getBlockFromString("minecraft", woodType + trunkType);
            Block strippedLog = CarvedWood.getBlockFromString("minecraft", "stripped_" + woodType + trunkType);
            Block logBundle = CarvedWood.getBlockFromString(woodType + trunkType + "_bundle");
            Block strippedLogBundle = CarvedWood.getBlockFromString("stripped_" + woodType + trunkType + "_bundle");

            switch (woodType) {
                case "bamboo" -> {
                    entries.addAfter(Blocks.BAMBOO_BLOCK, logBundle);
                    entries.addAfter(Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                    entries.addAfter(Blocks.BAMBOO_PLANKS, PlanksP);
                    entries.addAfter(Blocks.BAMBOO_MOSAIC, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                    entries.addAfter(Blocks.BAMBOO_MOSAIC_STAIRS, tPlanksStairs);
                    entries.addAfter(Blocks.BAMBOO_MOSAIC_SLAB, tPlanksSlab);
                }
                default -> {
                    entries.addAfter(log, logBundle);
                    entries.addAfter(strippedLog, strippedLogBundle);
                    entries.addAfter(planks, PlanksP, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                    entries.addAfter(planksStairs, mPlanksStairs, tPlanksStairs);
                    entries.addAfter(planksSlab, mPlanksSlab, tPlanksSlab);
                }
            }
        }
    }
    //FUNCTIONAL_BLOCKS
    public static void addToFunctionalBlocksTap(FabricItemGroupEntries entries) {
        for (String woodType : CarvedWood.WOOD_TYPES.reversed()) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block woodenLantern = CarvedWood.getBlockFromString(woodType + "_lantern");
            entries.addAfter(Blocks.SOUL_LANTERN, woodenLantern);
            if (woodType != "oak") {
                Block craftingTable = CarvedWood.getBlockFromString(woodType + "_crafting_table");
                Block ladder = CarvedWood.getBlockFromString(woodType + "_ladder");
                Block campfire = CarvedWood.getBlockFromString(woodType + "_campfire");
                Block soulCampfire = CarvedWood.getBlockFromString("soul_" + woodType + "_campfire");
                Block bookshelf = CarvedWood.getBlockFromString(woodType + "_bookshelf");
                Block chiseled_bookshelf = CarvedWood.getBlockFromString("chiseled_" + woodType + "_bookshelf");
                Block lectern = CarvedWood.getBlockFromString(woodType + "_lectern");
                Block beehive = CarvedWood.getBlockFromString(woodType + "_beehive");
                entries.addAfter(Blocks.CRAFTING_TABLE, craftingTable);
                entries.addAfter(Blocks.LADDER, ladder);
                entries.addAfter(Blocks.CAMPFIRE, campfire);
                entries.addAfter(Blocks.SOUL_CAMPFIRE, soulCampfire);
                entries.addAfter(Blocks.CHISELED_BOOKSHELF, bookshelf);
                entries.addAfter(bookshelf, chiseled_bookshelf);
                entries.addAfter(Blocks.LECTERN, lectern);
                entries.addAfter(Blocks.BEEHIVE, beehive);
            }
            if (woodType != "spruce" && woodType != "oak") {
                Block barrel = CarvedWood.getBlockFromString(woodType + "_barrel");
                entries.addAfter(Blocks.BARREL, barrel);
            }
            Block chest = CarvedWood.getBlockFromString(woodType + "_chest");
            entries.addAfter(Blocks.CHEST, chest);
        }
        entries.addBefore(Blocks.BARREL, CWBlocks.OAK_BARREL.get());
    }
    //REDSTONE_BLOCKS
    public static void addToRedstoneBlocksTap(FabricItemGroupEntries entries) {
        for (String woodType : CarvedWood.WOOD_TYPES.reversed()) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block chest = CarvedWood.getBlockFromString(woodType + "_chest");
            entries.addAfter(Blocks.CHEST, chest);
            Block trappedChest = CarvedWood.getBlockFromString("trapped_" + woodType + "_chest");
            entries.addAfter(Blocks.TRAPPED_CHEST, trappedChest);
            if (!woodType.equals("oak")) {
                Block crafter = CarvedWood.getBlockFromString(woodType + "_crafter");
                entries.addAfter(Blocks.CRAFTER, crafter);
            }
        }
    }
}
