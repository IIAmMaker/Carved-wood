package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.recipe.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CarvedWood.MOD_ID);
    
    public static final Supplier<SimpleCraftingRecipeSerializer<LecternRecipe>> LECTERN =
            RECIPES.register("lectern", () ->
                    new SimpleCraftingRecipeSerializer<>(LecternRecipe::new));

    public static final Supplier<RecipeSerializer<CraftingTableRecipe>> CRAFTING_TABLE =
            RECIPES.register("crafting_table", () ->
                    new SimpleCraftingRecipeSerializer<>(CraftingTableRecipe::new));

    public static final Supplier<RecipeSerializer<ChestRecipe>> CHEST =
            RECIPES.register("chest", () ->
                    new SimpleCraftingRecipeSerializer<>(ChestRecipe::new));

    public static final Supplier<RecipeSerializer<BarrelRecipe>> BARREL =
            RECIPES.register("barrel", () ->
                    new SimpleCraftingRecipeSerializer<>(BarrelRecipe::new));

    public static final Supplier<RecipeSerializer<BookshelfRecipe>> BOOKSHELF =
            RECIPES.register("bookshelf", () ->
                    new SimpleCraftingRecipeSerializer<>(BookshelfRecipe::new));

    public static final Supplier<RecipeSerializer<ChiseledBookshelfRecipe>> CHISELED_BOOKSHELF =
            RECIPES.register("chiseled_bookshelf", () ->
                    new SimpleCraftingRecipeSerializer<>(ChiseledBookshelfRecipe::new));

    public static final Supplier<RecipeSerializer<BeehiveRecipe>> BEEHIVE =
            RECIPES.register("beehive", () ->
                    new SimpleCraftingRecipeSerializer<>(BeehiveRecipe::new));

    public static final Supplier<RecipeSerializer<CampfireRecipe>> CAMPFIRE =
            RECIPES.register("campfire", () ->
                    new SimpleCraftingRecipeSerializer<>(CampfireRecipe::new));

    public static final Supplier<RecipeSerializer<SoulCampfireRecipe>> SOUL_CAMPFIRE =
            RECIPES.register("soul_campfire", () ->
                    new SimpleCraftingRecipeSerializer<>(SoulCampfireRecipe::new));

    public static final Supplier<RecipeSerializer<LadderRecipe>> LADDER =
            RECIPES.register("ladder", () ->
                    new SimpleCraftingRecipeSerializer<>(LadderRecipe::new));

    public static void register (IEventBus eventBus) {
        RECIPES.register(eventBus);
    }
}
