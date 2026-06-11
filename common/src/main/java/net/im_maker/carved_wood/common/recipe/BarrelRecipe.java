package net.im_maker.carved_wood.common.recipe;

import net.im_maker.carved_wood.common.registers.CWRecipes;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class BarrelRecipe extends CustomRecipe {
    public BarrelRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (craftingInput.width() != 3 || craftingInput.height() != 3)
            return false;

        ItemStack[][] pattern = new ItemStack[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                pattern[y][x] = craftingInput.getItem(x + y * 3);
            }
        }

        return isPlanks(pattern[0][0])
                && isWoodenSlab(pattern[0][1])
                && isPlanks(pattern[0][2])
                && isPlanks(pattern[1][0])
                && isPlanks(pattern[1][2])
                && isPlanks(pattern[2][0])
                && isWoodenSlab(pattern[2][1])
                && isPlanks(pattern[2][2])
                && pattern[1][1].isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return new ItemStack(Items.BARREL);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.BARREL.get();
    }

    private boolean isWoodenSlab(ItemStack stack) {
        return stack.is(ItemTags.WOODEN_SLABS) && !stack.is(CWTags.Items.FLAG);
    }

    private boolean isPlanks(ItemStack stack) {
        return stack.is(ItemTags.PLANKS) && !stack.is(CWTags.Items.FLAG);
    }
}