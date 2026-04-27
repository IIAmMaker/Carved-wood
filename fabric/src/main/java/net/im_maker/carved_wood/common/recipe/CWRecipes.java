package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.recipe.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class CWRecipes {
    public static final RecipeSerializer<LecternRecipe> LECTERN =
            registerRecipeSerializer("lectern", new SimpleCraftingRecipeSerializer<>(LecternRecipe::new));

    public static final RecipeSerializer<CraftingTableRecipe> CRAFTING_TABLE =
            registerRecipeSerializer("crafting_table", new SimpleCraftingRecipeSerializer<>(CraftingTableRecipe::new));

    public static final RecipeSerializer<ChestRecipe> CHEST =
            registerRecipeSerializer("chest", new SimpleCraftingRecipeSerializer<>(ChestRecipe::new));

    public static final RecipeSerializer<BarrelRecipe> BARREL =
            registerRecipeSerializer("barrel", new SimpleCraftingRecipeSerializer<>(BarrelRecipe::new));

    public static final RecipeSerializer<BookshelfRecipe> BOOKSHELF =
            registerRecipeSerializer("bookshelf", new SimpleCraftingRecipeSerializer<>(BookshelfRecipe::new));

    public static final RecipeSerializer<ChiseledBookshelfRecipe> CHISELED_BOOKSHELF =
            registerRecipeSerializer("chiseled_bookshelf", new SimpleCraftingRecipeSerializer<>(ChiseledBookshelfRecipe::new));

    public static final RecipeSerializer<BeehiveRecipe> BEEHIVE =
            registerRecipeSerializer("beehive", new SimpleCraftingRecipeSerializer<>(BeehiveRecipe::new));

    public static final RecipeSerializer<CampfireRecipe> CAMPFIRE =
            registerRecipeSerializer("campfire", new SimpleCraftingRecipeSerializer<>(CampfireRecipe::new));

    public static final RecipeSerializer<SoulCampfireRecipe> SOUL_CAMPFIRE =
            registerRecipeSerializer("soul_campfire", new SimpleCraftingRecipeSerializer<>(SoulCampfireRecipe::new));

    public static final RecipeSerializer<LadderRecipe> LADDER =
            registerRecipeSerializer("ladder", new SimpleCraftingRecipeSerializer<>(LadderRecipe::new));

    private static <T extends RecipeSerializer<?>> T registerRecipeSerializer(String name, T serializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, name), serializer);
    }

    public static void registerRecipeSerializers() {
        CarvedWood.LOGGER.info("Registering Recipe Serializers for " + CarvedWood.MOD_ID);
    }
}
