package net.im_maker.carved_wood.common.recipe.custom;

import com.blackgear.vanillabackport.core.data.tags.ModItemTags;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.common.recipe.CWRecipes;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class CampfireRecipe extends CustomRecipe {
    public CampfireRecipe(CraftingBookCategory category) {
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

        return isStick(pattern[0][1])
                && isStick(pattern[1][0])
                && isCoal(pattern[1][1])
                && isStick(pattern[1][2])
                && isLog(pattern[2][0])
                && isLog(pattern[2][1])
                && isLog(pattern[2][2])
                && pattern[0][0].isEmpty()
                && pattern[0][2].isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        return new ItemStack(Items.CAMPFIRE);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CWRecipes.CAMPFIRE;
    }

    private boolean isStick(ItemStack stack) {
        return stack.is(Items.STICK);
    }

    private boolean isCoal(ItemStack stack) {
        return stack.is(ItemTags.COALS);
    }

    private boolean isLog(ItemStack stack) {
        return stack.is(ItemTags.LOGS)
                && !stack.is(ItemTags.OAK_LOGS)
                && !stack.is(ItemTags.SPRUCE_LOGS)
                && !stack.is(ItemTags.BIRCH_LOGS)
                && !stack.is(ItemTags.JUNGLE_LOGS)
                && !stack.is(ItemTags.ACACIA_LOGS)
                && !stack.is(ItemTags.DARK_OAK_LOGS)
                && !stack.is(ItemTags.MANGROVE_LOGS)
                && !stack.is(ItemTags.CHERRY_LOGS)
                && !stack.is(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("vanillabackport", "pale_oak_logs")))
                && !stack.is(ItemTags.CRIMSON_STEMS)
                && !stack.is(ItemTags.WARPED_STEMS);
    }
}