package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.registers.CWBlocks;
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
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
            "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
    ));

    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;

    private static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike after, ItemLike... blocks) {
        for (int i = blocks.length - 1; i >= 0; i--) {
            ItemLike block = blocks[i];
            if (block != Blocks.AIR && after != Blocks.AIR) {
                event.insertAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    private static void addBefore(BuildCreativeModeTabContentsEvent event, ItemLike before, ItemLike... blocks) {
        for (ItemLike block : blocks) {
            if (block != Blocks.AIR && before != Blocks.AIR) {
                event.insertBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (String woodType : WOOD_TYPES) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block planks = CarvedWood.getBlockFromString("minecraft", woodType + "_planks");
                Block PlanksP = CarvedWood.getBlockFromString(woodType + "_panels");
                Block bPlanks = CarvedWood.getBlockFromString(woodType + "_boards");
                Block sPlanks = CarvedWood.getBlockFromString("smooth_" + woodType + "_boards");
                Block planksTiles = CarvedWood.getBlockFromString(woodType + "_tiles");
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
                        addAfter(event, Blocks.BAMBOO_BLOCK, logBundle);
                        addAfter(event, Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                        addAfter(event, Blocks.BAMBOO_PLANKS, PlanksP);
                        addAfter(event, Blocks.BAMBOO_MOSAIC, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, Blocks.BAMBOO_MOSAIC_STAIRS, tPlanksStairs);
                        addAfter(event, Blocks.BAMBOO_MOSAIC_SLAB, tPlanksSlab);
                    }
                    case "pale_oak" -> {
                        addAfter(event, Blocks.CHERRY_BUTTON, logBundle);
                        addAfter(event, Blocks.CHERRY_BUTTON, strippedLogBundle);
                        addAfter(event, Blocks.CHERRY_BUTTON, PlanksP, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, Blocks.CHERRY_BUTTON, mPlanksStairs, tPlanksStairs);
                        addAfter(event, Blocks.CHERRY_BUTTON, mPlanksSlab, tPlanksSlab);
                    }
                    default -> {
                        addAfter(event, log, logBundle);
                        addAfter(event, strippedLog, strippedLogBundle);
                        addAfter(event, planks, PlanksP, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, planksStairs, mPlanksStairs, tPlanksStairs);
                        addAfter(event, planksSlab, mPlanksSlab, tPlanksSlab);
                    }
                }
            }
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (String woodType : WOOD_TYPES.reversed()) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block woodenLantern = CarvedWood.getBlockFromString(woodType + "_lantern");
                addAfter(event, Blocks.SOUL_LANTERN, woodenLantern);
                if (woodType != "oak") {
                    Block craftingTable = CarvedWood.getBlockFromString(woodType + "_crafting_table");
                    Block ladder = CarvedWood.getBlockFromString(woodType + "_ladder");
                    Block campfire = CarvedWood.getBlockFromString(woodType + "_campfire");
                    Block soulCampfire = CarvedWood.getBlockFromString("soul_" + woodType + "_campfire");
                    Block bookshelf = CarvedWood.getBlockFromString(woodType + "_bookshelf");
                    Block chiseled_bookshelf = CarvedWood.getBlockFromString("chiseled_" + woodType + "_bookshelf");
                    Block lectern = CarvedWood.getBlockFromString(woodType + "_lectern");
                    Block beehive = CarvedWood.getBlockFromString(woodType + "_beehive");
                    addAfter(event, Blocks.CRAFTING_TABLE, craftingTable);
                    addAfter(event, Blocks.LADDER, ladder);
                    addAfter(event, Blocks.CAMPFIRE, campfire);
                    addAfter(event, Blocks.SOUL_CAMPFIRE, soulCampfire);
                    addAfter(event, Blocks.CHISELED_BOOKSHELF, bookshelf);
                    addAfter(event, bookshelf, chiseled_bookshelf);
                    addAfter(event, Blocks.LECTERN, lectern);
                    addAfter(event, Blocks.BEEHIVE, beehive);
                }
                if (woodType != "spruce" && woodType != "oak") {
                    Block barrel = CarvedWood.getBlockFromString(woodType + "_barrel");
                    addAfter(event, Blocks.BARREL, barrel);
                }
                Block chest = CarvedWood.getBlockFromString(woodType + "_chest");
                addAfter(event, Blocks.CHEST, chest);
            }
            addBefore(event, Blocks.BARREL, CWBlocks.OAK_BARREL.get());
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (String woodType : WOOD_TYPES.reversed()) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block chest = CarvedWood.getBlockFromString(woodType + "_chest");
                addAfter(event, Blocks.CHEST, chest);
                Block trappedChest = CarvedWood.getBlockFromString("trapped_" + woodType + "_chest");
                addAfter(event, Blocks.TRAPPED_CHEST, trappedChest);
                if (!woodType.equals("oak")) {
                    Block crafter = CarvedWood.getBlockFromString(woodType + "_crafter");
                    addAfter(event, Blocks.CRAFTER, crafter);
                }
            }
        }
    }
}
