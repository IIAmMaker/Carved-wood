package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.config.CarvedWoodConfig;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AddToCreativeInv {
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
            "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
    ));


    private static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike after, ItemLike... items) {
        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i] == null || after == null) continue;
            event.insertAfter(FUNCTION.apply(after), FUNCTION.apply(items[i]), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static void addBefore(BuildCreativeModeTabContentsEvent event, ItemLike before, ItemLike... items) {
        for (ItemLike item : items) {
            if (item == null || before == null) continue;
            event.insertBefore(FUNCTION.apply(before), FUNCTION.apply(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static Block getIfEnabled(String configKey, String blockName) {
        if (!CarvedWoodConfig.isEnabled(configKey)) return null;
        Block block = CarvedWood.getBlockFromString(blockName);
        return (block != Blocks.AIR) ? block : null;
    }

    private static boolean isPaleOakLocked(String woodType) {
        return woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport");
    }

    private static String trunkType(String woodType) {
        return switch (woodType) {
            case "crimson", "warped" -> "_stem";
            case "bamboo" -> "";
            default -> "_log";
        };
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) addBuildingBlocks(event);
        else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) addFunctionalBlocks(event);
        else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) addRedstoneBlocks(event);
    }

    private static void addBuildingBlocks(BuildCreativeModeTabContentsEvent event) {
        for (String woodType : WOOD_TYPES) {
            if (isPaleOakLocked(woodType)) continue;

            Block planks       = CarvedWood.getBlockFromString("minecraft", woodType + "_planks");
            Block planksStairs = CarvedWood.getBlockFromString("minecraft", woodType + "_stairs");
            Block planksSlab   = CarvedWood.getBlockFromString("minecraft", woodType + "_slab");
            String t           = trunkType(woodType);
            Block log          = CarvedWood.getBlockFromString("minecraft", woodType + t);
            Block strippedLog  = CarvedWood.getBlockFromString("minecraft", "stripped_" + woodType + t);

            Block logBundle         = getIfEnabled("log_bundles", woodType + t + "_bundle");
            Block strippedLogBundle = getIfEnabled("log_bundles", "stripped_" + woodType + t + "_bundle");

            Block panels       = getIfEnabled("planks_sets", woodType + "_panels");
            Block boards       = getIfEnabled("planks_sets", woodType + "_boards");
            Block smoothBoards = getIfEnabled("planks_sets", "smooth_" + woodType + "_boards");
            Block tiles        = getIfEnabled("planks_sets", woodType + "_tiles");
            Block mosaic       = getIfEnabled("planks_sets", woodType + "_mosaic");
            Block carvedPlanks = getIfEnabled("planks_sets", "carved_" + woodType + "_planks");
            Block lanternBlock = getIfEnabled("planks_sets", woodType + "_lantern_block");
            Block pillar       = getIfEnabled("planks_sets", woodType + "_pillar");
            Block mosaicStairs = getIfEnabled("planks_sets", woodType + "_mosaic_stairs");
            Block tileStairs   = getIfEnabled("planks_sets", woodType + "_tile_stairs");
            Block mosaicSlab   = getIfEnabled("planks_sets", woodType + "_mosaic_slab");
            Block tileSlab     = getIfEnabled("planks_sets", woodType + "_tile_slab");

            switch (woodType) {
                case "bamboo" -> {
                    addAfter(event, Blocks.BAMBOO_BLOCK, logBundle);
                    addAfter(event, Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                    addAfter(event, Blocks.BAMBOO_PLANKS, panels);
                    addAfter(event, Blocks.BAMBOO_MOSAIC, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(event, Blocks.BAMBOO_MOSAIC_STAIRS, tileStairs);
                    addAfter(event, Blocks.BAMBOO_MOSAIC_SLAB, tileSlab);
                }
                case "pale_oak" -> {
                    addAfter(event, Blocks.CHERRY_BUTTON, logBundle, strippedLogBundle);
                    addAfter(event, Blocks.CHERRY_BUTTON, panels, mosaic, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(event, Blocks.CHERRY_BUTTON, mosaicStairs, tileStairs);
                    addAfter(event, Blocks.CHERRY_BUTTON, mosaicSlab, tileSlab);
                }
                default -> {
                    addAfter(event, log, logBundle);
                    addAfter(event, strippedLog, strippedLogBundle);
                    addAfter(event, planks, panels, mosaic, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(event, planksStairs, mosaicStairs, tileStairs);
                    addAfter(event, planksSlab, mosaicSlab, tileSlab);
                }
            }
        }
    }

    private static void addFunctionalBlocks(BuildCreativeModeTabContentsEvent event) {
        for (String woodType : WOOD_TYPES.reversed()) {
            if (isPaleOakLocked(woodType)) continue;

            Block lantern       = getIfEnabled("planks_sets", woodType + "_lantern");
            Block craftingTable = getIfEnabled("wooden_crafting_tables", woodType + "_crafting_table");
            Block ladder        = getIfEnabled("wooden_ladders", woodType + "_ladder");
            Block campfire      = getIfEnabled("wooden_campfires", woodType + "_campfire");
            Block soulCampfire  = getIfEnabled("wooden_campfires", "soul_" + woodType + "_campfire");
            Block bookshelf     = getIfEnabled("wooden_bookshelves", woodType + "_bookshelf");
            Block chiseledShelf = getIfEnabled("wooden_bookshelves", "chiseled_" + woodType + "_bookshelf");
            Block lectern       = getIfEnabled("wooden_bookshelves", woodType + "_lectern");
            Block beehive       = getIfEnabled("wooden_beehives", woodType + "_beehive");
            Block barrel        = getIfEnabled("wooden_barrels", woodType + "_barrel");
            Block chest         = getIfEnabled("wooden_chests", woodType + "_chest");

            addAfter(event, Blocks.SOUL_LANTERN, lantern);

            if (!woodType.equals("oak")) {
                addAfter(event, Blocks.CRAFTING_TABLE, craftingTable);
                addAfter(event, Blocks.LADDER, ladder);
                addAfter(event, Blocks.CAMPFIRE, campfire);
                addAfter(event, Blocks.SOUL_CAMPFIRE, soulCampfire);
                addAfter(event, Blocks.CHISELED_BOOKSHELF, bookshelf);
                addAfter(event, bookshelf, chiseledShelf);
                addAfter(event, Blocks.LECTERN, lectern);
                addAfter(event, Blocks.BEEHIVE, beehive);
            }
            if (!woodType.equals("spruce") && !woodType.equals("oak")) {
                addAfter(event, Blocks.BARREL, barrel);
            }
            addAfter(event, Blocks.CHEST, chest);
        }
        if (CarvedWoodConfig.isEnabled("wooden_barrels"))
            addBefore(event, Blocks.BARREL, CWBlocks.OAK_BARREL.get());
    }

    private static void addRedstoneBlocks(BuildCreativeModeTabContentsEvent event) {
        for (String woodType : WOOD_TYPES.reversed()) {
            if (isPaleOakLocked(woodType)) continue;

            Block chest        = getIfEnabled("wooden_chests", woodType + "_chest");
            Block trappedChest = getIfEnabled("wooden_chests", "trapped_" + woodType + "_chest");
            Block crafter      = getIfEnabled("wooden_crafting_tables", woodType + "_crafter");

            addAfter(event, Blocks.CHEST, chest);
            addAfter(event, Blocks.TRAPPED_CHEST, trappedChest);
            if (!woodType.equals("oak")) addAfter(event, Blocks.CRAFTER, crafter);
        }
    }
}