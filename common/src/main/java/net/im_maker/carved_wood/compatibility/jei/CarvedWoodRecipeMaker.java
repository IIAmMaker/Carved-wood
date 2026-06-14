package net.im_maker.carved_wood.compatibility.jei;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.util.ConventionalTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CarvedWoodRecipeMaker {

    public static List<RecipeHolder<CraftingRecipe>> createCWRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();

        // BarrelRecipe: isPlanks + isWoodenSlab
        recipes.add(createRecipe("barrel", new ItemStack(Items.BARREL),
                Map.of('P', Ingredient.of(ItemTags.PLANKS), 'S', Ingredient.of(ItemTags.WOODEN_SLABS)),
                "PSP", "P P", "PSP"));

        // BeehiveRecipe: isPlanks + isHoneycomb (Items.HONEYCOMB)
        recipes.add(createRecipe("beehive", new ItemStack(Items.BEEHIVE),
                Map.of('P', Ingredient.of(ItemTags.PLANKS), 'H', Ingredient.of(Items.HONEYCOMB)),
                "PPP", "HHH", "PPP"));

        // BookshelfRecipe: isPlanks + isBook (Items.BOOK)
        recipes.add(createRecipe("bookshelf", new ItemStack(Items.BOOKSHELF),
                Map.of('P', Ingredient.of(ItemTags.PLANKS), 'B', Ingredient.of(Items.BOOK)),
                "PPP", "BBB", "PPP"));

        // CampfireRecipe: isStick (Items.STICK) + isCoal (ItemTags.COALS) + isLog (ItemTags.LOGS)
        recipes.add(createRecipe("campfire", new ItemStack(Items.CAMPFIRE),
                Map.of('S', Ingredient.of(Items.STICK), 'C', Ingredient.of(ItemTags.COALS), 'L', Ingredient.of(ItemTags.LOGS)),
                " S ", "SCS", "LLL"));

        // ChestRecipe: isPlanks, empty center
        recipes.add(createRecipe("chest", new ItemStack(Items.CHEST),
                Map.of('P', Ingredient.of(ItemTags.PLANKS)),
                "PPP", "P P", "PPP"));

        // ChiseledBookshelfRecipe: isPlanks + isWoodenSlab
        recipes.add(createRecipe("chiseled_bookshelf", new ItemStack(Items.CHISELED_BOOKSHELF),
                Map.of('P', Ingredient.of(ItemTags.PLANKS), 'S', Ingredient.of(ItemTags.WOODEN_SLABS)),
                "PPP", "SSS", "PPP"));

        // CraftingTableRecipe: isPlanks, 2x2
        recipes.add(createRecipe("crafting_table", new ItemStack(Items.CRAFTING_TABLE),
                Map.of('P', Ingredient.of(ItemTags.PLANKS)),
                "PP", "PP"));

        // LadderRecipe: isStick (Items.STICK) + isPlanks center, count 1
        recipes.add(createRecipe("ladder", new ItemStack(Items.LADDER),
                Map.of('S', Ingredient.of(Items.STICK), 'P', Ingredient.of(ItemTags.PLANKS)),
                "S S", "SPS", "S S"));

        // LecternRecipe: isWoodenSlab + isBookshelf (ConventionalTags.Items.BOOKSHELVES)
        recipes.add(createRecipe("lectern", new ItemStack(Items.LECTERN),
                Map.of('S', Ingredient.of(ItemTags.WOODEN_SLABS), 'B', Ingredient.of(ConventionalTags.Items.BOOKSHELVES)),
                "SSS", " B ", " S "));

        // SoulCampfireRecipe: isStick (Items.STICK) + isSoulsand (ItemTags.SOUL_FIRE_BASE_BLOCKS) + isLog (ItemTags.LOGS)
        // Note: SoulCampfireRecipe.assemble() returns Items.CAMPFIRE — that is a bug in the recipe class itself
        recipes.add(createRecipe("soul_campfire", new ItemStack(Items.SOUL_CAMPFIRE),
                Map.of('S', Ingredient.of(Items.STICK), 'C', Ingredient.of(ItemTags.SOUL_FIRE_BASE_BLOCKS), 'L', Ingredient.of(ItemTags.LOGS)),
                " S ", "SCS", "LLL"));

        return recipes;
    }

    private static RecipeHolder<CraftingRecipe> createRecipe(String name, ItemStack result, Map<Character, Ingredient> key, String... pattern) {
        ResourceLocation id = CarvedWood.newRL("carved_wood", "" + name);
        ShapedRecipePattern shapedPattern = ShapedRecipePattern.of(key, List.of(pattern));
        ShapedRecipe recipe = new ShapedRecipe("carved_wood." + name, CraftingBookCategory.MISC, shapedPattern, result);
        return new RecipeHolder<>(id, recipe);
    }

    private CarvedWoodRecipeMaker() {
    }
}