package net.im_maker.carved_wood.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
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

    private void Testh(RecipeOutput output) {
        Item ingredient = Items.APPLE;
        String modId = "modhere";

        // First, generate the recipe to get the JSON
        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BOOK, 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient));

        // Create a temporary holder for the recipe
        final Recipe<?>[] tempRecipe = new Recipe<?>[1];

        // Capture the recipe using a dummy output
        RecipeOutput dummyOutput = new RecipeOutput() {
            @Override
            public void accept(ResourceLocation id, Recipe<?> recipe, AdvancementHolder advancement, ICondition... conditions) {
                tempRecipe[0] = recipe;
            }

            @Override
            public Advancement.Builder advancement() {
                return output.advancement();
            }
        };

        builder.save(dummyOutput, "aaatest");

        // Now convert the captured recipe to JSON
        if (tempRecipe[0] != null) {
            JsonObject recipeJson = Recipe.CODEC.encodeStart(JsonOps.INSTANCE, tempRecipe[0])
                    .result().get().getAsJsonObject();

            // Add NeoForge conditions
            JsonObject neoforgeCond = new JsonObject();
            neoforgeCond.addProperty("type", "neoforge:mod_loaded");
            neoforgeCond.addProperty("modid", modId);
            JsonArray neoforgeConditions = new JsonArray();
            neoforgeConditions.add(neoforgeCond);
            recipeJson.add("neoforge:conditions", neoforgeConditions);

            // Add Fabric conditions
            JsonObject fabricCond = new JsonObject();
            fabricCond.addProperty("condition", "fabric:mod_loaded");
            fabricCond.addProperty("modid", modId);
            JsonArray fabricConditions = new JsonArray();
            fabricConditions.add(fabricCond);
            recipeJson.add("fabric:load_conditions", fabricConditions);

            // Now you need to write this JSON to the output
            // Since RecipeOutput doesn't accept JSON, you'll need to use a custom writer
            // Or use the original output's internal file writer via reflection
            writeRecipeToFile(output, CarvedWood.newRL("modid", "aaatest"), recipeJson);
        }
    }

    private void writeRecipeToFile(RecipeOutput output, ResourceLocation id, JsonObject recipeJson) {
        try {
            // The RecipeOutput implementation in NeoForge is usually ConditionallyIgnoringRecipeOutput
            // It contains a 'delegate' or 'original' RecipeOutput

            Field delegateField = output.getClass().getDeclaredField("delegate");
            delegateField.setAccessible(true);
            Object delegate = delegateField.get(output);

            // Look for PackOutput or Path field
            File outputFolder = null;

            // Try to get the output folder from the delegate
            if (delegate.getClass().getName().contains("RecipeOutputImpl")) {
                Field outputField = delegate.getClass().getDeclaredField("output");
                outputField.setAccessible(true);
                PackOutput packOutput = (PackOutput) outputField.get(delegate);

                // Get the recipe output folder
                Path recipePath = packOutput.getOutputFolder()
                        .resolve("data")
                        .resolve(id.getNamespace())
                        .resolve("recipe");

                // Create directories if needed
                Files.createDirectories(recipePath);

                // Write the JSON file
                Path outputPath = recipePath.resolve(id.getPath() + ".json");
                try (FileWriter writer = new FileWriter(outputPath.toFile())) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    gson.toJson(recipeJson, writer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void Test(RecipeOutput output) {
        Item ingredient = Items.APPLE;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BOOK, 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(new CustomDataOutput(output)
                                .withConditions(new ModLoadedCondition("modvv"))
                                .requireFabricMods("modvv"), "aaatessssssssssssssssssssssssssst");
    }

    private void LargePlanksRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_panels"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_panels")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenBoardsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_panels");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_boards"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenSmoothBoardsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("smooth_" + woodType + "_boards"), 9)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_smooth_boards")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenTilesRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tiles"), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("wooden_tiles")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenTileStairsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_stairs"), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_stairs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenTileSlabsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tiles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_tile_slab"), 6)
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_tile_slab")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenMosaicRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft",woodType + "_slab");
        Item result = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC.asItem() : item(woodType + "_mosaic");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("wooden_mosaic")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenMosaicStairsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC.asItem() : item(woodType + "_mosaic");
        Item result = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC_STAIRS.asItem() : item(woodType + "_mosaic_stairs");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_mosaic_stairs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenMosaicSlabsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC.asItem() : item(woodType + "_mosaic");
        Item result = woodType == "bamboo" ? Blocks.BAMBOO_MOSAIC_SLAB.asItem() : item(woodType + "_mosaic_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("###")
                .define('#', ingredient)
                .group("wooden_mosaic_slab")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void carvedPlanksRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_tile_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item("carved_" + woodType + "_planks"), 1)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("carved_planks")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenLanternRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenLanternBlockRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenLanternFromWoodenLanternBlockRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_lantern_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, item(woodType + "_lantern"), 2)
                .requires(ingredient)
                .group("wooden_lantern_from_wooden_lantern_block")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, CarvedWood.MOD_ID + ":" + (woodType + "_lantern_from_" + woodType + "_lantern_block"));
    }

    private void woodenLanternBlockFromWoodenLanternRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_lantern");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_lantern_block"), 1)
                .requires(ingredient)
                .requires(ingredient)
                .group("wooden_lantern_block_from_wooden_lantern")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, CarvedWood.MOD_ID + ":" + (woodType + "_lantern_block_from_" + woodType + "_lantern"));
    }

    private void woodenPillarsRecipe (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_boards");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item(woodType + "_pillar"), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ingredient)
                .group("wooden_pillar")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenCampfiresRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenSoulCampfiresRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void logBundlesRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void strippedLogBundlesRecipe (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void logsFromLogsBundlesRecipes (RecipeOutput output, String woodType) {
        String trunkType;
        switch (woodType) {
            case "crimson", "warped" -> trunkType = "_stem";
            case "bamboo" -> trunkType = "";
            default -> trunkType = "_log";
        }
        Item ingredient = item(woodType + trunkType + "_bundle");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item("minecraft",woodType + (trunkType == "" ? "_block" : trunkType)), 1)
                .requires(ingredient)
                .group("logs")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output, CarvedWood.MOD_ID + ":" + woodType + trunkType + "_from_" + woodType + trunkType + "_bundle");
    }

    private void strippedLogsFromStrippedLogBundlesRecipes (RecipeOutput output, String woodType) {
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
                .save(output, CarvedWood.MOD_ID + ":" + "stripped_" + woodType + trunkType + "_from_" + "stripped_" + woodType + trunkType + "_bundle");
    }

    private void woodsFromLogsRecipes (RecipeOutput output, String woodType) {
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
                    .save(output);
        }
    }

    private void strippedWoodsFromStrippedLogsRecipes (RecipeOutput output, String woodType) {
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
                    .save(output);
        }
    }

    private void woodenCraftingTables (RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_crafting_table");
        result = woodType == "oak" ? Blocks.CRAFTING_TABLE.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("##")
                .pattern("##")
                .define('#', ingredient)
                .group("crafting_table")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenLadders (RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_ladder");
        result = woodType == "oak" ? Blocks.LADDER.asItem() : result;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 3)
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .define('#', ingredient)
                .define('S', Items.STICK)
                .group("ladder")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenChests (RecipeOutput output, String woodType) {
        Item ingredient = item("minecraft", woodType + "_planks");
        Item result = item(woodType + "_chest");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .define('#', ingredient)
                .group("chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenTrappedChests (RecipeOutput output, String woodType) {
        Item ingredient = item(woodType + "_chest");
        Item result = item("trapped_" + woodType + "_chest");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .group("trapped_chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void woodenBarrels (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenBookshelves (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenChiseledBookshelves (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenLecterns (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenBeehives (RecipeOutput output, String woodType) {
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
                .save(output);
    }

    private void woodenCrafters (RecipeOutput output, String woodType) {
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
                .group("beehive")
                .unlockedBy(getHasName(dropper), has(dropper))
                .save(output);
    }

    private void vanillaTrappedChest (RecipeOutput output) {
        Item ingredient = Items.CHEST;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .requires(Items.TRIPWIRE_HOOK)
                .group("trapped_chest")
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(output);
    }

    private void removingTheChestRecipe (RecipeOutput output) {
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .unlockedBy(getHasName(result), has(result))
                .save(output);
    }

    private void chestFromTag (RecipeOutput output) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_WOODEN;
        Item result = Items.CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .group("chest")
                .save(output, "chest_from_chest_tag");
    }

    private void trappedChestFromTag (RecipeOutput output) {
        TagKey<Item> ingredient = Tags.Items.CHESTS_TRAPPED;
        Item result = Items.TRAPPED_CHEST;
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result, 1)
                .requires(ingredient)
                .unlockedBy(getHasName(result), has(ingredient))
                .save(output, "trapped_chest_from_trapped_chest_tag");
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        //Test(output);
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
            woodenCampfiresRecipe(output, type);
            woodenSoulCampfiresRecipe(output, type);
            logBundlesRecipe(output, type);
            strippedLogBundlesRecipe(output, type);
            logsFromLogsBundlesRecipes(output, type);
            strippedLogsFromStrippedLogBundlesRecipes(output, type);
            woodsFromLogsRecipes(output, type);
            strippedWoodsFromStrippedLogsRecipes(output, type);
            woodenCraftingTables(output, type);
            woodenLadders(output, type);
            woodenChests(output, type);
            woodenTrappedChests(output, type);
            woodenBarrels(output, type);
            woodenBookshelves(output, type);
            woodenChiseledBookshelves(output, type);
            woodenLecterns(output, type);
            woodenBeehives(output, type);
            woodenCrafters(output, type);
        }
        vanillaTrappedChest(output);
        //removingTheChestRecipe(output);
        //chestFromTag(output);
        trappedChestFromTag(output);
    }
}