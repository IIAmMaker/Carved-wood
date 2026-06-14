package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CraftingTableRecipe extends CustomRecipe {
    public CraftingTableRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (!canCraftInDimensions(craftingInput.width(), craftingInput.height()))
            return false;

        ItemStack[][] pattern = new ItemStack[2][2];
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                pattern[y][x] = craftingInput.getItem(x + y * 2);
            }
        }

        boolean patternMatches = isPlanks(pattern[0][0]) && isPlanks(pattern[0][1])
                && isPlanks(pattern[1][0]) && isPlanks(pattern[1][1]);

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
        return new ItemStack(Items.CRAFTING_TABLE);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.CRAFTING_TABLE.get();
    }

    private boolean isPlanks(ItemStack stack) {
        return stack.is(ItemTags.PLANKS);
    }
}