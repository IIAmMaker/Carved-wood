package net.im_maker.carved_wood.common.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.config.CarvedWoodConfig;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToCreativeInv {
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
            "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
    ));

    private static void addAfter(FabricItemGroupEntries entries, Block after, Block... items) {
        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i] == null || after == null) continue;
            entries.addAfter(after, items[i]);
        }
    }

    private static void addBefore(FabricItemGroupEntries entries, Block before, Block... items) {
        for (Block item : items) {
            if (item == null || before == null) continue;
            entries.addBefore(before, item);
        }
    }

    private static Block getIfEnabled(String configKey, String blockName) {
        if (!CarvedWoodConfig.isEnabled(configKey)) return null;
        Block block = CarvedWood.getBlockFromString(blockName);
        return (block != Blocks.AIR) ? block : null;
    }

    private static boolean isPaleOakLocked(String woodType) {
        return woodType.equals("pale_oak") && !FabricLoader.getInstance().isModLoaded("vanillabackport");
    }

    private static String trunkType(String woodType) {
        return switch (woodType) {
            case "crimson", "warped" -> "_stem";
            case "bamboo" -> "";
            default -> "_log";
        };
    }
    
    public static void addBuildingBlocks(FabricItemGroupEntries entries) {
        for (String woodType : WOOD_TYPES) {
            if (isPaleOakLocked(woodType)) continue;

            Block planks       = CarvedWood.getBlockFromString("minecraft", woodType + "_planks");
            Block planksStairs = CarvedWood.getBlockFromString("minecraft", woodType + "_stairs");
            Block planksSlab   = CarvedWood.getBlockFromString("minecraft", woodType + "_slab");
            String t           = trunkType(woodType);
            Block log          = CarvedWood.getBlockFromString("minecraft", woodType + t);
            Block strippedLog  = CarvedWood.getBlockFromString("minecraft", "stripped_" + woodType + t);

            Block logBundle = getIfEnabled("log_bundles", woodType + t + "_bundle");
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
                    addAfter(entries, Blocks.BAMBOO_BLOCK, logBundle);
                    addAfter(entries, Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                    addAfter(entries, Blocks.BAMBOO_PLANKS, panels);
                    addAfter(entries, Blocks.BAMBOO_MOSAIC, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(entries, Blocks.BAMBOO_MOSAIC_STAIRS, tileStairs);
                    addAfter(entries, Blocks.BAMBOO_MOSAIC_SLAB, tileSlab);
                }
                case "pale_oak" -> {
                    addAfter(entries, Blocks.CHERRY_BUTTON, logBundle);
                    addAfter(entries, Blocks.CHERRY_BUTTON, strippedLogBundle);
                    addAfter(entries, Blocks.CHERRY_BUTTON, panels, mosaic, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(entries, Blocks.CHERRY_BUTTON, mosaicStairs, tileStairs);
                    addAfter(entries, Blocks.CHERRY_BUTTON, mosaicSlab, tileSlab);
                }
                default -> {
                    addAfter(entries, log, logBundle);
                    addAfter(entries, strippedLog, strippedLogBundle);
                    addAfter(entries, planks, panels, mosaic, tiles, boards, smoothBoards, carvedPlanks, lanternBlock, pillar);
                    addAfter(entries, planksStairs, mosaicStairs, tileStairs);
                    addAfter(entries, planksSlab, mosaicSlab, tileSlab);
                }
            }
        }
    }

    public static void addFunctionalBlocks(FabricItemGroupEntries entries) {
        for (String woodType : WOOD_TYPES.reversed()) {
            if (isPaleOakLocked(woodType)) continue;

            Block woodenLantern      = getIfEnabled("planks_sets", woodType + "_lantern");
            Block craftingTable      = getIfEnabled("wooden_crafting_tables", woodType + "_crafting_table");
            Block ladder             = getIfEnabled("wooden_ladders", woodType + "_ladder");
            Block campfire           = getIfEnabled("wooden_campfires", woodType + "_campfire");
            Block soulCampfire       = getIfEnabled("wooden_campfires", "soul_" + woodType + "_campfire");
            Block bookshelf          = getIfEnabled("wooden_bookshelves", woodType + "_bookshelf");
            Block chiseled_bookshelf = getIfEnabled("wooden_bookshelves", "chiseled_" + woodType + "_bookshelf");
            Block lectern            = getIfEnabled("wooden_bookshelves", woodType + "_lectern");
            Block beehive            = getIfEnabled("wooden_beehives", woodType + "_beehive");
            Block barrel             = getIfEnabled("wooden_barrels", woodType + "_barrel");
            Block chest              = getIfEnabled("wooden_chests", woodType + "_chest");

            addAfter(entries, Blocks.SOUL_LANTERN, woodenLantern);
            if (!woodType.equals("oak")) {
                addAfter(entries, Blocks.CRAFTING_TABLE, craftingTable);
                addAfter(entries, Blocks.LADDER, ladder);
                addAfter(entries, Blocks.CAMPFIRE, campfire);
                addAfter(entries, Blocks.SOUL_CAMPFIRE, soulCampfire);
                addAfter(entries, Blocks.CHISELED_BOOKSHELF, bookshelf);
                addAfter(entries, bookshelf, chiseled_bookshelf);
                addAfter(entries, Blocks.LECTERN, lectern);
                addAfter(entries, Blocks.BEEHIVE, beehive);
            }
            if (!woodType.equals("spruce") && !woodType.equals("oak")) {
                addAfter(entries, Blocks.BARREL, barrel);
            }
            addAfter(entries, Blocks.CHEST, chest);
        }
        addBefore(entries, Blocks.BARREL, CWBlocks.OAK_BARREL.get());
    }

    public static void addRedstoneBlocks(FabricItemGroupEntries entries) {
        for (String woodType : WOOD_TYPES.reversed()) {
            if (isPaleOakLocked(woodType)) continue;

            Block chest        = getIfEnabled("wooden_chests", woodType + "_chest");
            Block trappedChest = getIfEnabled("wooden_chests", "trapped_" + woodType + "_chest");
            Block crafter      = getIfEnabled("wooden_crafting_tables", woodType + "_crafter");

            addAfter(entries, Blocks.CHEST, chest);
            addAfter(entries, Blocks.TRAPPED_CHEST, trappedChest);
            if (!woodType.equals("oak")) {
                addAfter(entries, Blocks.CRAFTER, crafter);
            }
        }
    }
}