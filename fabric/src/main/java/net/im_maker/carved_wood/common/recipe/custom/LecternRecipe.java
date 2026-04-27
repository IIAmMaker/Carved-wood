package net.im_maker.carved_wood.common.recipe.custom;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.im_maker.carved_wood.common.recipe.CWRecipes;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class LecternRecipe extends CustomRecipe {
    public LecternRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput container, Level level) {
        if (container.width() != 3 || container.height() != 3)
            return false;

        ItemStack[][] pattern = new ItemStack[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                pattern[y][x] = container.getItem(x + y * 3);
            }
        }

        return isWoodenSlab(pattern[0][0])
                && isWoodenSlab(pattern[0][1])
                && isWoodenSlab(pattern[0][2])
                && isBookshelf(pattern[1][1])
                && isWoodenSlab(pattern[2][1])
                && pattern[1][0].isEmpty()
                && pattern[1][2].isEmpty()
                && pattern[2][0].isEmpty()
                && pattern[2][2].isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return new ItemStack(Items.LECTERN);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.LECTERN;
    }

    private boolean isBookshelf(ItemStack stack) {
        return stack.is(ConventionalItemTags.BOOKSHELVES);
    }

    private boolean isWoodenSlab(ItemStack stack) {
        return stack.is(ItemTags.WOODEN_SLABS) && ! stack.is(CWTags.Items.FLAG);
    }
}