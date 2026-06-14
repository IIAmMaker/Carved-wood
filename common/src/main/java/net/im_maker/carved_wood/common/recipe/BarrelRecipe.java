package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class BarrelRecipe extends CustomRecipe {
    public BarrelRecipe(CraftingBookCategory category) {
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

        boolean patternMatches = isPlanks(pattern[0][0]) && isWoodenSlab(pattern[0][1]) && isPlanks(pattern[0][2])
                              && isPlanks(pattern[1][0]) && pattern[1][1].isEmpty() && isPlanks(pattern[1][2])
                              && isPlanks(pattern[2][0]) && isWoodenSlab(pattern[2][1]) && isPlanks(pattern[2][2]);

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
        return new ItemStack(Items.BARREL);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width == 3 && height == 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.BARREL.get();
    }

    private boolean isWoodenSlab(ItemStack stack) {
        return stack.is(ItemTags.WOODEN_SLABS);
    }

    private boolean isPlanks(ItemStack stack) {
        return stack.is(ItemTags.PLANKS);
    }
}