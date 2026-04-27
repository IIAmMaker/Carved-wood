package net.im_maker.carved_wood;

import com.blackgear.vanillabackport.common.registries.ModBlocks;
import com.blackgear.vanillabackport.core.VanillaBackport;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.CWMenus;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.item.CWItems;
import net.im_maker.carved_wood.common.recipe.CWRecipes;
import net.im_maker.carved_wood.common.util.CWFuelRegistry;
import net.im_maker.carved_wood.common.util.CWPoiType;
import net.im_maker.carved_wood.common.util.DataPackRegistrar;
import net.im_maker.carved_wood.compatibility.WoodGood.ModCompat;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CarvedWood implements ModInitializer {
    public static final String MOD_ID = "carved_wood";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
        "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
    ));

    @Override
    public void onInitialize() {
        DataPackRegistrar.loadBuiltinResourcePacks();
        CWItems.registerItems();
        CWMenus.register();
        // For NeoForge:
// For Fabric (similar registration method depending on your setup)
        //MenuScreens.register(CWMenus.LECTERN_EDIT_MENU.get(), LecternEditMenu::new);
        CWBlocks.registerBlocks();
        everyCompatModule();
        CWBlockEntities.registerBlockEntities();
        CWFuelRegistry.registerFuel();
        CWPoiType.init();
        CWRecipes.registerRecipeSerializers();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(CarvedWood::addToBuildingBlocksTap);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(CarvedWood::addToFunctionalBlocksTap);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(CarvedWood::addToRedstoneBlocksTap);
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
        ModContainer create = FabricLoader.getInstance().getModContainer(CarvedWood.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("CarvedWood's ModContainer couldn't be found!"));
        ResourceLocation packId = ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "recarved");
        ResourceManagerHelper.registerBuiltinResourcePack(packId, create, "Recarved", ResourcePackActivationType.NORMAL);
    }

    //BUILDING_BLOCKS
    public static void addToBuildingBlocksTap(FabricItemGroupEntries entries) {
        for (String woodType : WOOD_TYPES) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block planks = getBlockFromString("minecraft", woodType + "_planks");
            Block planksTiles = getBlockFromString(woodType + "_tiles");
            Block PlanksP = getBlockFromString(woodType + "_panels");
            Block bPlanks = getBlockFromString(woodType + "_boards");
            Block sPlanks = getBlockFromString("smooth_" + woodType + "_boards");
            Block mPlanks = getBlockFromString(woodType + "_mosaic");
            Block cPlanks = getBlockFromString("carved_" + woodType + "_planks");
            Block lPlanks = getBlockFromString(woodType + "_lantern_block");
            Block pPlanks = getBlockFromString(woodType + "_pillar");
            Block planksStairs = getBlockFromString("minecraft", woodType + "_stairs");
            Block mPlanksStairs = getBlockFromString(woodType + "_mosaic_stairs");
            Block tPlanksStairs = getBlockFromString(woodType + "_tile_stairs");
            Block planksSlab = getBlockFromString("minecraft", woodType + "_slab");
            Block mPlanksSlab = getBlockFromString(woodType + "_mosaic_slab");
            Block tPlanksSlab = getBlockFromString(woodType + "_tile_slab");
            String trunkType;
            switch (woodType) {
                case "crimson", "warped" -> trunkType = "_stem";
                case "bamboo" -> trunkType = "";
                default -> trunkType = "_log";
            }
            Block log = getBlockFromString("minecraft", woodType + trunkType);
            Block strippedLog = getBlockFromString("minecraft", "stripped_" + woodType + trunkType);
            Block logBundle = getBlockFromString(woodType + trunkType + "_bundle");
            Block strippedLogBundle = getBlockFromString("stripped_" + woodType + trunkType + "_bundle");

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
        for (String woodType : WOOD_TYPES.reversed()) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block woodenLantern = getBlockFromString(woodType + "_lantern");
            entries.addAfter(Blocks.SOUL_LANTERN, woodenLantern);
            if (woodType != "oak") {
                Block craftingTable = getBlockFromString(woodType + "_crafting_table");
                Block ladder = getBlockFromString(woodType + "_ladder");
                Block campfire = getBlockFromString(woodType + "_campfire");
                Block soulCampfire = getBlockFromString("soul_" + woodType + "_campfire");
                Block bookshelf = getBlockFromString(woodType + "_bookshelf");
                Block chiseled_bookshelf = getBlockFromString("chiseled_" + woodType + "_bookshelf");
                Block lectern = getBlockFromString(woodType + "_lectern");
                Block beehive = getBlockFromString(woodType + "_beehive");
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
                Block barrel = getBlockFromString(woodType + "_barrel");
                entries.addAfter(Blocks.BARREL, barrel);
            }
            Block chest = getBlockFromString(woodType + "_chest");
            entries.addAfter(Blocks.CHEST, chest);
        }
        entries.addBefore(Blocks.BARREL, CWBlocks.OAK_BARREL);
    }
    //REDSTONE_BLOCKS
    public static void addToRedstoneBlocksTap(FabricItemGroupEntries entries) {
        for (String woodType : WOOD_TYPES.reversed()) {
            if (woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport"))
                continue;
            Block chest = getBlockFromString(woodType + "_chest");
            entries.addAfter(Blocks.CHEST, chest);
            Block trappedChest = getBlockFromString("trapped_" + woodType + "_chest");
            entries.addAfter(Blocks.TRAPPED_CHEST, trappedChest);
            if (!woodType.equals("oak")) {
                Block crafter = getBlockFromString(woodType + "_crafter");
                entries.addAfter(Blocks.CRAFTER, crafter);
            }
        }
    }

    public static Block getBlockFromString (String block) {
        return getBlockFromString(MOD_ID, block);
    }
    public static Block getBlockFromString (String nameSpace, String block) {
        ResourceLocation blockLocation = ResourceLocation.fromNamespaceAndPath(nameSpace, block);
        return BuiltInRegistries.BLOCK.get(blockLocation);
    }

    public static Item getItemFromString (String item) {
        return getItemFromString(MOD_ID, item);
    }
    public static Item getItemFromString (String nameSpace, String item) {
        ResourceLocation itemLocation = ResourceLocation.fromNamespaceAndPath(nameSpace, item);
        return BuiltInRegistries.ITEM.get(itemLocation);
    }

    public static Block[] getBlocks(Class<?>... blockClasses) {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Stream.of(blockClasses).anyMatch(clazz -> clazz.isInstance(block)))
                .toArray(Block[]::new);
    }
}
