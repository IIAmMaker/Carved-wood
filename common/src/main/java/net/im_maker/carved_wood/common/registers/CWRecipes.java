package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.recipe.*;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

import java.util.function.Supplier;

public class CWRecipes {

    public static final Supplier<RecipeSerializer<LecternRecipe>> LECTERN =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "lectern"),
                    () -> new SimpleCraftingRecipeSerializer<>(LecternRecipe::new));

    public static final Supplier<RecipeSerializer<CraftingTableRecipe>> CRAFTING_TABLE =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "crafting_table"),
                    () -> new SimpleCraftingRecipeSerializer<>(CraftingTableRecipe::new));

    public static final Supplier<RecipeSerializer<ChestRecipe>> CHEST =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "chest"),
                    () -> new SimpleCraftingRecipeSerializer<>(ChestRecipe::new));

    public static final Supplier<RecipeSerializer<BarrelRecipe>> BARREL =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "barrel"),
                    () -> new SimpleCraftingRecipeSerializer<>(BarrelRecipe::new));

    public static final Supplier<RecipeSerializer<BookshelfRecipe>> BOOKSHELF =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "bookshelf"),
                    () -> new SimpleCraftingRecipeSerializer<>(BookshelfRecipe::new));

    public static final Supplier<RecipeSerializer<ChiseledBookshelfRecipe>> CHISELED_BOOKSHELF =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "chiseled_bookshelf"),
                    () -> new SimpleCraftingRecipeSerializer<>(ChiseledBookshelfRecipe::new));

    public static final Supplier<RecipeSerializer<BeehiveRecipe>> BEEHIVE =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "beehive"),
                    () -> new SimpleCraftingRecipeSerializer<>(BeehiveRecipe::new));

    public static final Supplier<RecipeSerializer<CampfireRecipe>> CAMPFIRE =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "campfire"),
                    () -> new SimpleCraftingRecipeSerializer<>(CampfireRecipe::new));

    public static final Supplier<RecipeSerializer<SoulCampfireRecipe>> SOUL_CAMPFIRE =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "soul_campfire"),
                    () -> new SimpleCraftingRecipeSerializer<>(SoulCampfireRecipe::new));

    public static final Supplier<RecipeSerializer<LadderRecipe>> LADDER =
            PlatHelper.registerRecipeSerializer(
                    CarvedWood.newRL(CarvedWood.MOD_ID, "ladder"),
                    () -> new SimpleCraftingRecipeSerializer<>(LadderRecipe::new));

    public static void registerRecipeSerializers() {
    }
}
