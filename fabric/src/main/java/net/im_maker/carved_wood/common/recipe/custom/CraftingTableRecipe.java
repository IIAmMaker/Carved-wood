package net.im_maker.carved_wood.common.recipe.custom;

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

public class CraftingTableRecipe extends CustomRecipe {
    public CraftingTableRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (craftingInput.width() == 2 && craftingInput.height() == 2) {
            return isPlanks(craftingInput.getItem(0)) &&
                   isPlanks(craftingInput.getItem(1)) &&
                   isPlanks(craftingInput.getItem(2)) &&
                   isPlanks(craftingInput.getItem(3));
        }

        if (craftingInput.width() == 3 && craftingInput.height() == 3) {
            return checkQuadrant(craftingInput, 0, 1, 3, 4) ||
                    checkQuadrant(craftingInput, 1, 2, 4, 5) ||
                    checkQuadrant(craftingInput, 3, 4, 6, 7) ||
                    checkQuadrant(craftingInput, 4, 5, 7, 8);
        }

        return false;
    }

    private boolean checkQuadrant(CraftingInput craftingInput, int slot1, int slot2, int slot3, int slot4) {
        if (!allSlotsArePlanks(craftingInput, slot1, slot2, slot3, slot4)) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i != slot1 && i != slot2 && i != slot3 && i != slot4) {
                if (!craftingInput.getItem(i).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean allSlotsArePlanks(CraftingInput craftingInput, int... slots) {
        for (int slot : slots) {
            if (!isPlanks(craftingInput.getItem(slot))) {
                return false;
            }
        }
        return true;
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
        return CWRecipes.CRAFTING_TABLE;
    }

    private boolean isPlanks(ItemStack stack) {
        return stack.is(ItemTags.PLANKS) && !stack.is(CWTags.Items.FLAG);
    }
}