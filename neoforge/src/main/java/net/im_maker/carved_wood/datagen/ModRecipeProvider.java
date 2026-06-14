package net.im_maker.carved_wood.datagen;

import com.google.common.hash.HashCode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.recipe.*;
import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.im_maker.carved_wood.common.util.ConventionalTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private final PackOutput packOutput;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
        this.packOutput = pOutput;
    }

    private Item item (String string){
        return CarvedWood.getItemFromString(string);
    }
    private Item item (String id, String string){
        return CarvedWood.getItemFromString(id, string);
    }

    private void LargePlanksRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_panels"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_panels")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenBoardsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_panels");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_boards"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenSmoothBoardsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("smooth_" + woodType + "_boards"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_smooth_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenTilesRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tiles"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_tiles")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenTileStairsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_stairs"), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_stairs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenTileSlabsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_slab"), 6)
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_slab")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenMosaicRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft",woodType + "_slab");
        if (woodType != "bamboo") {
            Item result = item(woodType + "_mosaic");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                    .pattern("#")
                    .pattern("#")
                    .define('#', ingredient)
                    .group("wooden_mosaic")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(withDualConditions(output, "planks_sets"));
        }
    }

    private void woodenMosaicStairsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC.asItem() : item(woodType + "_mosaic");
        if (woodType != "bamboo") {
            Item result = item(woodType + "_mosaic_stairs");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .define('#', ingredient)
                    .group("wooden_mosaic_stairs")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(withDualConditions(output, "planks_sets"));
        }
    }

    private void woodenMosaicSlabsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC.asItem() : item(woodType + "_mosaic");
        if (woodType != "bamboo") {
            Item result = item(woodType + "_mosaic_slab");
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                    .pattern("###")
                    .define('#', ingredient)
                    .group("wooden_mosaic_slab")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(withDualConditions(output, "planks_sets"));
        }
    }

    private void carvedPlanksRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tile_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("carved_" + woodType + "_planks"), 1)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("carved_planks")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenLanternRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, item(woodType + "_lantern"), 2)
                .pattern(" # ")
                .pattern("PSP")
                .pattern(" # ")
                .define('#', ingredient)
                .define('P', Items.PAPER)
                .define('S', Items.SHROOMLIGHT)
                .group("wooden_lantern")
                .unlockedBy(getHasName(Items.SHROOMLIGHT), has(Items.SHROOMLIGHT))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenLanternBlockRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_lantern_block"), 2)
                .pattern("#P#")
                .pattern("PSP")
                .pattern("#P#")
                .define('#', ingredient)
                .define('P', Items.PAPER)
                .define('S', Items.SHROOMLIGHT)
                .group("wooden_lantern_block")
                .unlockedBy(getHasName(Items.SHROOMLIGHT), has(Items.SHROOMLIGHT))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenLanternFromWoodenLanternBlockRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_lantern_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, item(woodType + "_lantern"), 2)
                .requires(ingredient)
                .group("wooden_lantern_from_wooden_lantern_block")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"), CarvedWood.MOD_ID + ":" + (woodType + "_lantern_from_" + woodType + "_lantern_block"));
    }

    private void woodenLanternBlockFromWoodenLanternRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_lantern");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_lantern_block"), 1)
                .requires(ingredient)
                .requires(ingredient)
                .group("wooden_lantern_block_from_wooden_lantern")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"), CarvedWood.MOD_ID + ":" + (woodType + "_lantern_block_from_" + woodType + "_lantern"));
    }

    private void woodenPillarsRecipe(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_pillar"), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("wooden_pillars")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "planks_sets"));
    }

    private void woodenCampfiresRecipe(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        String trunkWoodType;
        switch (woodType) {
            case "crimson", "warped" -> trunkWoodType = "_hyphae";
            case "bamboo" -> trunkWoodType = "_block";
            default -> trunkWoodType = "_wood";
        }
        Item ingredient0 = item("minecraft", woodType + trunkType);
        Item ingredient1 = item("minecraft", woodType + trunkWoodType);
        Item result = item(woodType + "_campfire");
        result = woodType == "oak" ? Blocks.CAMPFIRE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("###")
                .define('S', Tags.Items.RODS_WOODEN)
                .define('C', ItemTags.COALS)
                .define('#', Ingredient.of(ingredient0,ingredient1))
                .group("campfires")
                .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS))
                .unlockedBy(getHasName(Items.COAL), has(ItemTags.COALS))
                .save(withDualConditions(output, "wooden_campfires"), CarvedWood.newRL(woodType + "_campfire"));
    }

    private void woodenSoulCampfiresRecipe(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        String trunkWoodType;
        switch (woodType) {
            case "crimson", "warped" -> trunkWoodType = "_hyphae";
            case "bamboo" -> trunkWoodType = "_block";
            default -> trunkWoodType = "_wood";
        }
        Item ingredient0 = item("minecraft", woodType + trunkType);
        Item ingredient1 = item("minecraft", woodType + trunkWoodType);
        Item result = item("soul_" + woodType + "_campfire");
        result = woodType == "oak" ? Blocks.SOUL_CAMPFIRE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("###")
                .define('S', Tags.Items.RODS_WOODEN)
                .define('C', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .define('#', Ingredient.of(ingredient0,ingredient1))
                .group("campfires")
                .unlockedBy(getHasName(Items.STICK), has(Tags.Items.RODS))
                .unlockedBy(getHasName(Items.COAL), has(ItemTags.COALS))
                .save(withDualConditions(output, "wooden_campfires"), CarvedWood.newRL("soul_" + woodType + "_campfire"));
    }

    private void logBundlesRecipe(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        Item ingredient = item("minecraft",woodType + trunkType);
        trunkType = trunkType == "_block" ? "" : trunkType;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + trunkType + "_bundle"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("log_bundles")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "log_bundles"));
    }

    private void strippedLogBundlesRecipe(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        Item ingredient = item("minecraft","stripped_" + woodType + trunkType);
        trunkType = trunkType == "_block" ? "" : trunkType;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("stripped_" + woodType + trunkType + "_bundle"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("log_bundles")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "log_bundles"));
    }

    private void logsFromLogsBundlesRecipes(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "";
            default -> trunkType = "_log";
        }
        Item ingredient = item(woodType + trunkType + "_bundle");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item("minecraft",woodType + (trunkType == "" ? "_block" : trunkType)), 1)
                .requires(ingredient)
                .group("log")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "log_bundles"), CarvedWood.MOD_ID + ":" + woodType + trunkType + "_from_" + woodType + trunkType + "_bundle");
    }

    private void strippedLogsFromStrippedLogBundlesRecipes(RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "";
            default -> trunkType = "_log";
        }
        Item ingredient = item("stripped_" + woodType + trunkType + "_bundle");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item("minecraft","stripped_" + woodType + (trunkType == "" ? "_block" : trunkType)), 1)
                .requires(ingredient)
                .group("log")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "log_bundles"), CarvedWood.MOD_ID + ":" + "stripped_" + woodType + trunkType + "_from_" + "stripped_" + woodType + trunkType + "_bundle");
    }

    private void woodsFromLogsRecipes(RecipeOutput output, String woodType) {
        if (woodType != "bamboo") {
            String trunkType;
            switch (woodType) {
                case "crimson", "warped" -> trunkType = "_stem";
                default -> trunkType = "_log";
            }
            String barkType;
            switch (woodType) {
                case "crimson", "warped" -> barkType = "_hyphae";
                default -> barkType = "_wood";
            }
            Item ingredient = item("minecraft", woodType + trunkType);
            Item result = item("minecraft", woodType + barkType);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 5)
                    .pattern(" # ")
                    .pattern("###")
                    .pattern(" # ")
                    .define('#', ingredient)
                    .group("bark")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(withDualConditions(output, "log_bundles"));
        }
    }

    private void strippedWoodsFromStrippedLogsRecipes(RecipeOutput output, String woodType) {
        if (woodType != "bamboo") {
            String trunkType;
            switch (woodType) {
                case "crimson", "warped" -> trunkType = "_stem";
                default -> trunkType = "_log";
            }
            String barkType;
            switch (woodType) {
                case "crimson", "warped" -> barkType = "_hyphae";
                default -> barkType = "_wood";
            }
                Item ingredient = item("minecraft", "stripped_" + woodType + trunkType);
            Item result = item("minecraft", "stripped_" + woodType + barkType);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 5)
                    .pattern(" # ")
                    .pattern("###")
                    .pattern(" # ")
                    .define('#', ingredient)
                    .group("bark")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(withDualConditions(output, "log_bundles"));
        }
    }

    private void woodenCraftingTables(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_crafting_table");
        result = woodType == "oak" ? Blocks.CRAFTING_TABLE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_crafting_tables")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "wooden_crafting_tables"), CarvedWood.newRL(woodType + "_crafting_table"));
    }

    private void woodenLadders(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_ladder");
        result = woodType == "oak" ? Blocks.LADDER.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 3)
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .define('#', ingredient)
                .define('S', Items.STICK)
                .group("wooden_ladders")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "wooden_ladders"), CarvedWood.newRL(woodType + "_ladder"));
    }

    private void woodenChests(RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_chest");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_chests")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "wooden_chests"), CarvedWood.newRL(woodType + "_chest"));
    }

    private void woodenTrappedChests(RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_chest");
        Item result = item("trapped_" + woodType + "_chest");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .group("wooden_trapped_chests")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "wooden_chests"), CarvedWood.newRL("trapped_" + woodType + "_chest"));
    }

    private void woodenBarrels(RecipeOutput output, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item slab = item("minecraft", woodType + "_slab");
        Item result = item(woodType + "_barrel");
        result = woodType.equals("spruce") ? Blocks.BARREL.asItem() : result;

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .define('P', planks)
                .define('S', slab)
                .group("wooden_barrels")
                .unlockedBy(getHasName(planks), has(planks))
                .save(withDualConditions(output, "wooden_barrels"), CarvedWood.newRL(woodType + "_barrel"));
    }

    private void woodenBookshelves(RecipeOutput output, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_bookshelf");
        result = woodType == "oak" ? Blocks.BOOKSHELF.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', planks)
                .define('B', Items.BOOK)
                .group("wooden_bookshelves")
                .unlockedBy(getHasName(planks), has(planks))
                .save(withDualConditions(output, "wooden_bookshelves"), CarvedWood.newRL(woodType + "_bookshelf"));
    }

    private void woodenChiseledBookshelves(RecipeOutput output, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item slab = item("minecraft", woodType + "_slab");
        Item result = item("chiseled_" + woodType + "_bookshelf");
        result = woodType == "oak" ? Blocks.CHISELED_BOOKSHELF.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .pattern("PPP")
                .pattern("SSS")
                .pattern("PPP")
                .define('P', planks)
                .define('S', slab)
                .group("wooden_chiseled_bookshelves")
                .unlockedBy(getHasName(planks), has(planks))
                .save(withDualConditions(output, "wooden_bookshelves"), CarvedWood.newRL("chiseled_" + woodType + "_bookshelf"));
    }

    private void woodenLecterns(RecipeOutput output, String woodType) {
        Item slab = item("minecraft", woodType + "_slab");
        Item bookshelf = item(woodType + "_bookshelf");
        Item result = item(woodType + "_lectern");
        result = woodType == "oak" ? Blocks.LECTERN.asItem() : result;
        bookshelf = woodType == "oak" ? Blocks.BOOKSHELF.asItem() : bookshelf;
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result, 1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern(" S ")
                .define('S', slab)
                .define('B', bookshelf)
                .group("wooden_lecterns")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(withDualConditions(output, "wooden_bookshelves"), CarvedWood.newRL(woodType + "_lectern"));
    }

    private void woodenBeehives(RecipeOutput output, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item honeycomb = Items.HONEYCOMB;
        Item result = item(woodType + "_beehive");
        result = woodType == "oak" ? Blocks.BEEHIVE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("PPP")
                .pattern("###")
                .pattern("PPP")
                .define('P', planks)
                .define('#', honeycomb)
                .group("wooden_beehives")
                .unlockedBy(getHasName(honeycomb), has(honeycomb))
                .save(withDualConditions(output, "wooden_beehives"), CarvedWood.newRL(woodType + "_beehive"));
    }

    private void woodenCrafters(RecipeOutput output, String woodType) {
        if (woodType.equals("oak")) return;
        Item crafting_table = item(woodType + "_crafting_table");
        Item iron = Items.IRON_INGOT;
        Item redstone = Items.REDSTONE;
        Item dropper = Items.DROPPER;
        Item result =  item(woodType + "_crafter");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, result, 1)
                .pattern("III")
                .pattern("ICI")
                .pattern("RDR")
                .define('I', iron)
                .define('R', redstone)
                .define('C', crafting_table)
                .define('D', dropper)
                .group("wooden_crafters")
                .unlockedBy(getHasName(dropper), has(dropper))
                .save(withDualConditions(output, "wooden_crafting_tables"), CarvedWood.newRL(woodType + "_crafter"));
    }

    private void vanillaChest(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CHEST, 1)
                .pattern("PPP")
                .pattern("P P")
                .pattern("PPP")
                .define('P', planks)
                .group("wooden_chests")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(withDualConditions(output, "wooden_chests", true));
    }

    private void vanillaBarrel(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        TagKey<Item> slabs = ItemTags.WOODEN_SLABS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.BARREL, 1)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .define('P', planks)
                .define('S', slabs)
                .group("wooden_barrels")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(withDualConditions(output, "wooden_barrels", true));
    }

    private void vanillaBookshelf(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.BOOKSHELF, 1)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', planks)
                .define('B', Items.BOOK)
                .group("wooden_bookshelves")
                .unlockedBy("has_book", has(Items.BOOK))
                .save(withDualConditions(output, "wooden_bookshelves", true));
    }

    private void vanillaChiseledBookshelf(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        TagKey<Item> slabs = ItemTags.WOODEN_SLABS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CHISELED_BOOKSHELF, 1)
                .pattern("PPP")
                .pattern("SSS")
                .pattern("PPP")
                .define('P', planks)
                .define('S', slabs)
                .group("wooden_chiseled_bookshelves")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(withDualConditions(output, "wooden_chiseled_bookshelves", true));
    }

    private void vanillaLectern(RecipeOutput output) {
        TagKey<Item> slabs = ItemTags.WOODEN_SLABS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.LECTERN, 1)
                .pattern("SSS")
                .pattern(" B ")
                .pattern(" S ")
                .define('S', slabs)
                .define('B', Items.BOOKSHELF)
                .group("wooden_lecterns")
                .unlockedBy("has_book", has(Items.BOOK))
                .save(withDualConditions(output, "wooden_lecterns", true));
    }

    private void vanillaCraftingTable(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CRAFTING_TABLE, 1)
                .pattern("PP")
                .pattern("PP")
                .define('P', planks)
                .group("wooden_crafting_tables")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(withDualConditions(output, "wooden_crafting_tables", true));
    }

    private void vanillaLadder(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.LADDER, 3)
                .pattern("S S")
                .pattern("SPS")
                .pattern("S S")
                .define('P', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .group("wooden_ladders")
                .unlockedBy("has_stick", has(Items.STICK))
                .save(withDualConditions(output, "wooden_ladders", true));
    }

    private void vanillaBeehive(RecipeOutput output) {
        TagKey<Item> planks = ItemTags.PLANKS;
        Item honeycomb = Items.HONEYCOMB;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.BEEHIVE, 1)
                .pattern("PPP")
                .pattern("HHH")
                .pattern("PPP")
                .define('P', planks)
                .define('H', honeycomb)
                .group("wooden_beehives")
                .unlockedBy("has_honeycomb", has(honeycomb))
                .save(withDualConditions(output, "wooden_beehives", true));
    }

    private void vanillaCampfire(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CAMPFIRE, 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .define('S', Items.STICK)
                .define('C', ItemTags.COALS)
                .define('L', ItemTags.LOGS)
                .group("wooden_campfires")
                .unlockedBy("has_coal", has(ItemTags.COALS))
                .save(withDualConditions(output, "wooden_campfires", true));
    }

    private void vanillaSoulCampfire(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.SOUL_CAMPFIRE, 1)
                .pattern(" S ")
                .pattern("SCS")
                .pattern("LLL")
                .define('S', Items.STICK)
                .define('C', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .define('L', ItemTags.LOGS)
                .group("wooden_soul_campfires")
                .unlockedBy("has_soul_sand", has(Items.SOUL_SAND))
                .save(withDualConditions(output, "wooden_soul_campfires", true));
    }

    // Special recipes - written directly to JSON
    private void writeSpecialRecipe(String recipeType, String configKey, String recipeName) {
        ResourceLocation id = CarvedWood.newRL(CarvedWood.MOD_ID, recipeName);

        JsonObject json = new JsonObject();
        json.addProperty("type", CarvedWood.MOD_ID + ":" + recipeType);
        json.addProperty("category", "misc");

        JsonArray neoConditions = new JsonArray();
        JsonObject neoCond = new JsonObject();
        neoCond.addProperty("type", "carved_wood:config");
        neoCond.addProperty("value", configKey);
        neoConditions.add(neoCond);
        json.add("neoforge:conditions", neoConditions);

        JsonArray fabricConditions = new JsonArray();
        JsonObject fabricCond = new JsonObject();
        fabricCond.addProperty("condition", "carved_wood:config");
        fabricCond.addProperty("value", configKey);
        fabricConditions.add(fabricCond);
        json.add("fabric:load_conditions", fabricConditions);

        Path recipePath = packOutput.getOutputFolder(PackOutput.Target.DATA_PACK)
                .resolve(id.getNamespace())
                .resolve("recipe")
                .resolve(id.getPath() + ".json");

        try {
            Files.createDirectories(recipePath.getParent());
            Files.writeString(recipePath, GSON.toJson(json));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save recipe: " + id, e);
        }
    }

    private void woodenChest(RecipeOutput output) {
        SpecialRecipeBuilder.special(ChestRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_chest",
                        "mixed_chest_crafting"), "wooden_chest");
    }

    private void woodenBarrel(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_barrel",
                        "mixed_barrel_crafting"), "wooden_barrel");
    }

    private void woodenBookshelf(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_bookshelf",
                        "mixed_bookshelf_crafting"), "wooden_bookshelf");
    }

    private void woodenChiseledBookshelf(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_chiseled_bookshelf",
                        "mixed_chiseled_bookshelf_crafting"), "wooden_chiseled_bookshelf");
    }

    private void woodenLectern(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_lectern",
                        "mixed_lectern_crafting"), "wooden_lectern");
    }

    private void woodenCraftingTable(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_crafting_table",
                        "mixed_crafting_table_crafting"), "wooden_crafting_table");
    }

    private void woodenLadder(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_ladder",
                        "mixed_ladder_crafting"), "wooden_ladder");
    }

    private void woodenBeehive(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_beehive",
                        "mixed_beehive_crafting"), "wooden_beehive");
    }

    private void woodenCampfire(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_campfire",
                        "mixed_campfire_crafting"), "wooden_campfire");
    }

    private void woodenSoulCampfire(RecipeOutput output) {
        SpecialRecipeBuilder.special(BarrelRecipe::new)
                .save(writeSpecialRecipe1(output, "crafting_special_soul_campfire",
                        "mixed_soul_campfire_crafting"), "wooden_soul_campfire");
    }

    private void woodenChestFromWoodenChests(RecipeOutput output) {
        TagKey<Item> ingredient = ConventionalTags.Items.WOODEN_CHESTS;
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .save(withDualConditions(output, "wooden_chests"), CarvedWood.MOD_ID + ":wooden_chest_from_wooden_chests");
    }

    private void woodenTrappedChest(RecipeOutput output) {
        Item ingredient = Items.CHEST;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(withDualConditions(output, "wooden_chests"),CarvedWood.MOD_ID + ":trapped_chest");
    }

    private void removingTheChestRecipe(RecipeOutput output) {
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .unlockedBy(getHasName(result), has(result))
                .save(output);
    }

    private void chestFromTag(RecipeOutput output) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_WOODEN;
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .group("chest")
                .save(output, "chest_from_chest_tag");
    }

    private void trappedChestFromTag(RecipeOutput output) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_TRAPPED;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .save(output, "trapped_chest_from_trapped_chest_tag");
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        for (String type : CarvedWood.WOOD_TYPES) {
            //if (type.equals("pale_oak")) continue;
            LargePlanksRecipe(output, type);
            woodenBoardsRecipe(output, type);
            woodenSmoothBoardsRecipe(output, type);
            woodenTilesRecipe(output, type);
            woodenTileStairsRecipe(output, type);
            woodenTileSlabsRecipe(output, type);
            woodenMosaicRecipe(output, type);
            woodenMosaicStairsRecipe(output, type);
            woodenMosaicSlabsRecipe(output, type);
            carvedPlanksRecipe(output, type);
            woodenPillarsRecipe(output, type);
            woodenLanternRecipe(output, type);
            woodenLanternBlockRecipe(output, type);
            woodenLanternFromWoodenLanternBlockRecipe(output, type);
            woodenLanternBlockFromWoodenLanternRecipe(output, type);
            logBundlesRecipe(output, type);
            logsFromLogsBundlesRecipes(output, type);
            strippedLogsFromStrippedLogBundlesRecipes(output, type);
            strippedWoodsFromStrippedLogsRecipes(output, type);

            woodsFromLogsRecipes(output, type);
            strippedLogBundlesRecipe(output, type);

            woodenCampfiresRecipe(output, type);
            woodenSoulCampfiresRecipe(output, type);
            woodenCraftingTables(output, type);
            woodenCrafters(output, type);
            woodenLadders(output, type);
            woodenChests(output, type);
            woodenTrappedChests(output, type);
            woodenBarrels(output, type);
            woodenBookshelves(output, type);
            woodenChiseledBookshelves(output, type);
            woodenLecterns(output, type);
            woodenBeehives(output, type);
        }
        //woodenBeehive(output);
        //woodenBarrel(output);
        //woodenChest(output);
        //woodenBookshelf(output);
        //woodenChiseledBookshelf(output);
        //woodenLectern(output);
        //woodenCampfire(output);
        //woodenSoulCampfire(output);
        //woodenCraftingTable(output);
        //woodenLadder(output);

        vanillaBeehive(output);
        vanillaBarrel(output);
        vanillaChest(output);
        vanillaBookshelf(output);
        vanillaChiseledBookshelf(output);
        vanillaLectern(output);
        vanillaCampfire(output);
        vanillaSoulCampfire(output);
        vanillaCraftingTable(output);
        vanillaLadder(output);

        //woodenChestFromWoodenChests(output);
        //woodenTrappedChest(output);

        //removingTheChestRecipe(output);
        //chestFromTag(output);
        //trappedChestFromTag(output);
    }

    private RecipeOutput withDualConditions(RecipeOutput output, String value) {
        return withDualConditions(output, "carved_wood:config", value, false);
    }

    private RecipeOutput withDualConditions(RecipeOutput output, String value, boolean inverted) {
        return withDualConditions(output, "carved_wood:config", value, inverted);
    }

    private RecipeOutput withDualConditions(RecipeOutput output, String conditionType, String value, boolean inverted) {
        return new RecipeOutput() {
            @Override
            public Advancement.Builder advancement() {
                return output.advancement();
            }

            @Override
            public void accept(ResourceLocation id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition... conditions) {
                JsonObject json = Recipe.CODEC.encodeStart(JsonOps.INSTANCE, recipe).getOrThrow().getAsJsonObject();

                JsonArray neoConditions = new JsonArray();
                JsonObject neoCond = new JsonObject();
                neoCond.addProperty("type", conditionType);
                neoCond.addProperty("value", value);
                if (inverted) neoCond.addProperty("inverted", true);
                neoConditions.add(neoCond);

                JsonArray fabricConditions = new JsonArray();
                JsonObject fabricCond = new JsonObject();
                fabricCond.addProperty("condition", conditionType);
                fabricCond.addProperty("value", value);
                if (inverted) fabricCond.addProperty("inverted", true);
                fabricConditions.add(fabricCond);

                JsonObject ordered = new JsonObject();
                ordered.addProperty("type", json.get("type").getAsString());
                ordered.addProperty("category", json.get("category").getAsString());
                if (json.has("group")) ordered.addProperty("group", json.get("group").getAsString());
                ordered.add("key", json.get("key"));
                ordered.add("pattern", json.get("pattern"));
                ordered.add("result", json.get("result"));
                ordered.add("neoforge:conditions", neoConditions);
                ordered.add("fabric:load_conditions", fabricConditions);

                Path recipePath = packOutput.getOutputFolder(PackOutput.Target.DATA_PACK)
                        .resolve(id.getNamespace())
                        .resolve("recipe")
                        .resolve(id.getPath() + ".json");

                output.accept(id, recipe, advancement, conditions);
                try {
                    Files.createDirectories(recipePath.getParent());
                    Files.writeString(recipePath, GSON.toJson(ordered));
                } catch (IOException e) {
                    throw new RuntimeException("Failed to save recipe: " + id, e);
                }
            }
        };
    }

    // Helper method
    private RecipeOutput writeSpecialRecipe1(RecipeOutput output, String recipeType, String configKey) {
        return new RecipeOutput() {
            @Override
            public Advancement.Builder advancement() {
                return output.advancement();
            }

            @Override
            public void accept(ResourceLocation id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, ICondition... conditions) {
                JsonObject json = new JsonObject();
                json.addProperty("type", CarvedWood.MOD_ID + ":" + recipeType + recipe);
                json.addProperty("category", "misc");

                // NeoForge condition
                JsonArray neoConditions = new JsonArray();
                JsonObject neoCond = new JsonObject();
                neoCond.addProperty("type", "carved_wood:config");
                neoCond.addProperty("value", configKey);
                neoConditions.add(neoCond);
                json.add("neoforge:conditions", neoConditions);

                // Fabric condition
                JsonArray fabricConditions = new JsonArray();
                JsonObject fabricCond = new JsonObject();
                fabricCond.addProperty("condition", "carved_wood:config");
                fabricCond.addProperty("value", configKey);
                fabricConditions.add(fabricCond);
                json.add("fabric:load_conditions", fabricConditions);

                Path recipePath = packOutput.getOutputFolder(PackOutput.Target.DATA_PACK)
                        .resolve(id.getNamespace())
                        .resolve("recipe")
                        .resolve(id.getPath() + ".json");

                output.accept(id, recipe, advancement, conditions);
                try {
                    Files.createDirectories(recipePath.getParent());
                    Files.writeString(recipePath, GSON.toJson(json));
                } catch (IOException e) {
                    throw new RuntimeException("Failed to save recipe: " + id, e);
                }
            }
        };
    }
}