package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CampfireRecipe extends CustomRecipe {
    public CampfireRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (!canCraftInDimensions(craftingInput.width(), craftingInput.height()))
            return false;

        ItemStack[][] pattern = new ItemStack[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                pattern[y][x] = craftingInput.getItem(x + y * 3);
            }
        }

        boolean patternMatches = pattern[0][0].isEmpty() && isStick(pattern[0][1]) && pattern[0][2].isEmpty()
                              && isStick(pattern[1][0]) && isCoal(pattern[1][1]) && isStick(pattern[1][2])
                              && isLog(pattern[2][0]) && isLog(pattern[2][1]) && isLog(pattern[2][2]);

        if (!patternMatches) return false;

        return level.getRecipeManager().getRecipes().stream()
                .map(RecipeHolder::value)
                .filter(recipe -> recipe.getType() == RecipeType.CRAFTING)
                .filter(recipe -> !recipe.isSpecial())
                .map(recipe -> (CraftingRecipe) recipe)
                .noneMatch(recipe -> recipe.matches(craftingInput, level));
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return new ItemStack(Items.CAMPFIRE);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width == 3 && height == 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.CAMPFIRE.get();
    }

    private boolean isStick(ItemStack stack) {
        return stack.is(Items.STICK);
    }

    private boolean isCoal(ItemStack stack) {
        return stack.is(ItemTags.COALS);
    }

    private boolean isLog(ItemStack stack) {
        return stack.is(ItemTags.LOGS);
    }
}