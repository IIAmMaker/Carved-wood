package net.im_maker.carved_wood.datagen;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private Item item (String string){
        return CarvedWood.getItemFromString(string);
    }
    private Block block (String string){
        return CarvedWood.getBlockFromString(string);
    }
    private Item item (String id, String string){
        return CarvedWood.getItemFromString(id, string);
    }
    private Block block (String id, String string){
        return CarvedWood.getBlockFromString(id, string);
    }

    private void woodenBoardsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_boards"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenSmoothBoardsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("smooth_" + woodType + "_boards"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_smooth_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenTilesRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tiles"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_tiles")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenTileStairsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_stairs"), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_stairs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenTileSlabsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_slab"), 6)
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_slab")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenMosaicRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft",woodType + "_planks_slab");
        Item result = woodType == "bamboo" ? item("minecraft","bamboo_mosaic") : item(woodType + "_mosaic");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("wooden_mosaic")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenMosaicStairsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_mosaic");
        Item result = woodType == "bamboo" ? item("minecraft","bamboo_mosaic_stairs") : item(woodType + "_mosaic_stairs");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_mosaic_stairs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenMosaicSlabsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_mosaic");
        Item result = woodType == "bamboo" ? item("minecraft","bamboo_mosaic_slab") : item(woodType + "_mosaic_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_mosaic_slab")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void carvedPlanksRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_tile_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("carved_" + woodType + "_planks"), 1)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("carved_planks")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenLanternRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_lantern"), 2)
                .pattern("#P#")
                .pattern("PGP")
                .pattern("#P#")
                .define('#', ingredient)
                .define('P', Items.PAPER)
                .define('G', Items.GLOWSTONE)
                .group("wooden_lantern")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenPillarsRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_pillar"), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("wooden_pillar")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenCampfiresRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .save(pWriter);
    }

    private void woodenSoulCampfiresRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .save(pWriter);
    }

    private void logBundlesRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .group("log_bundle")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void strippedLogBundlesRecipe (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .group("log_bundle")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void logsFromLogsBundlesRecipes (Consumer<FinishedRecipe> pWriter, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        Item ingredient = item(woodType + trunkType + "_bundle");
        trunkType = trunkType == "_block" ? "" : trunkType;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item("minecraft",woodType + trunkType), 1)
                .requires(ingredient)
                .group("log")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void strippedLogsFromStrippedLogBundlesRecipes (Consumer<FinishedRecipe> pWriter, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "_block";
            default -> trunkType = "_log";
        }
        Item ingredient = item("stripped_" + woodType + trunkType + "_bundle");
        trunkType = trunkType == "_block" ? "" : trunkType;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item("minecraft","stripped_" + woodType + trunkType), 1)
                .requires(ingredient)
                .group("log")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodsFromLogsRecipes (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                    .save(pWriter);
        }
    }

    private void strippedWoodsFromStrippedLogsRecipes (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                    .save(pWriter);
        }
    }

    private void woodenCraftingTables (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_crafting_table");
        result = woodType == "oak" ? Blocks.CRAFTING_TABLE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("crafting_table")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenLadders (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_ladder");
        result = woodType == "oak" ? Blocks.LADDER.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .define('#', ingredient)
                .define('S', Items.STICK)
                .group("ladder")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenChests (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_chest");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ingredient)
                .group("chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenTrappedChests (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item ingredient = item(woodType + "_chest");
        Item result = item(woodType + "_trapped_chest");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .group("trapped_chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void woodenBarrels (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item slab = item("minecraft", woodType + "_slab");
        Item result = item(woodType + "_barrel");
        result = woodType == "spruce" ? Blocks.BARREL.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .define('P', planks)
                .define('S', slab)
                .group("barrel")
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);
    }

    private void woodenBookshelves (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_bookshelf");
        result = woodType == "oak" ? Blocks.BOOKSHELF.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', planks)
                .define('B', Items.BOOK)
                .group("bookshelf")
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);
    }

    private void woodenChiseledBookshelves (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .group("chiseled_bookshelf")
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);
    }

    private void woodenLecterns (Consumer<FinishedRecipe> pWriter, String woodType) {
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
                .group("lectern")
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(pWriter);
    }

    private void woodenBeehives (Consumer<FinishedRecipe> pWriter, String woodType) {
        Item planks = item("minecraft", woodType + "_planks");
        Item honeycomb = Items.HONEYCOMB;
        Item result = item(woodType + "_beehive");
        result = woodType == "oak" ? Blocks.BEEHIVE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("PPP")
                .pattern("###")
                .pattern("PPP")
                .define('P', planks)
                .define('#', honeycomb)
                .group("beehive")
                .unlockedBy(getHasName(honeycomb), has(honeycomb))
                .save(pWriter);
    }

    private void vanillaTrappedChest (Consumer<FinishedRecipe> pWriter) {
        Item ingredient = Items.CHEST;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .group("trapped_chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    private void removingTheChestRecipe (Consumer<FinishedRecipe> pWriter) {
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .unlockedBy(getHasName(result), has(result))
                .save(pWriter);
    }

    private void chestFromTag (Consumer<FinishedRecipe> pWriter) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_WOODEN;
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .group("chest")
                .save(pWriter, "chest_from_chest_tag");
    }

    private void trappedChestFromTag (Consumer<FinishedRecipe> pWriter) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_TRAPPED;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .save(pWriter, "trapped_chest_from_trapped_chest_tag");
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        for (String type : CarvedWood.WOOD_TYPES) {
            woodenBoardsRecipe(pWriter, type);
            woodenSmoothBoardsRecipe(pWriter, type);
            woodenTilesRecipe(pWriter, type);
            woodenTileStairsRecipe(pWriter, type);
            woodenTileSlabsRecipe(pWriter, type);
            woodenMosaicRecipe(pWriter, type);
            woodenMosaicStairsRecipe(pWriter, type);
            woodenMosaicSlabsRecipe(pWriter, type);
            carvedPlanksRecipe(pWriter, type);
            woodenPillarsRecipe(pWriter, type);
            woodenLanternRecipe(pWriter, type);
            woodenCampfiresRecipe(pWriter, type);
            woodenSoulCampfiresRecipe(pWriter, type);
            logBundlesRecipe(pWriter, type);
            strippedLogBundlesRecipe(pWriter, type);
            logsFromLogsBundlesRecipes(pWriter, type);
            strippedLogsFromStrippedLogBundlesRecipes(pWriter, type);
            woodsFromLogsRecipes(pWriter, type);
            strippedWoodsFromStrippedLogsRecipes(pWriter, type);
            woodenCraftingTables(pWriter, type);
            woodenLadders(pWriter, type);
            woodenChests(pWriter, type);
            woodenTrappedChests(pWriter, type);
            woodenBarrels(pWriter, type);
            woodenBookshelves(pWriter, type);
            woodenChiseledBookshelves(pWriter, type);
            woodenLecterns(pWriter, type);
            woodenBeehives(pWriter, type);
        }
        vanillaTrappedChest(pWriter);
        removingTheChestRecipe(pWriter);
        chestFromTag(pWriter);
        trappedChestFromTag(pWriter);
    }
}