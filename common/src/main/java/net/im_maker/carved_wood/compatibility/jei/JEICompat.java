package net.im_maker.carved_wood.compatibility.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.config.CarvedWoodConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;

import java.util.List;

@JeiPlugin
public class JEICompat implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return CarvedWood.newRL(CarvedWood.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        if (CarvedWoodConfig.isEnabled("wooden_crafting_tables")) {
            ItemLike[][] pairs = new ItemLike[][]{
                    {CWBlocks.SPRUCE_CRAFTING_TABLE.get(),   CWBlocks.SPRUCE_CRAFTER.get()},
                    {CWBlocks.BIRCH_CRAFTING_TABLE.get(),    CWBlocks.BIRCH_CRAFTER.get()},
                    {CWBlocks.JUNGLE_CRAFTING_TABLE.get(),   CWBlocks.JUNGLE_CRAFTER.get()},
                    {CWBlocks.ACACIA_CRAFTING_TABLE.get(),   CWBlocks.ACACIA_CRAFTER.get()},
                    {CWBlocks.DARK_OAK_CRAFTING_TABLE.get(), CWBlocks.DARK_OAK_CRAFTER.get()},
                    {CWBlocks.MANGROVE_CRAFTING_TABLE.get(), CWBlocks.MANGROVE_CRAFTER.get()},
                    {CWBlocks.CHERRY_CRAFTING_TABLE.get(),   CWBlocks.CHERRY_CRAFTER.get()},
                    {CWBlocks.PALE_OAK_CRAFTING_TABLE.get(), CWBlocks.PALE_OAK_CRAFTER.get()},
                    {CWBlocks.CRIMSON_CRAFTING_TABLE.get(),  CWBlocks.CRIMSON_CRAFTER.get()},
                    {CWBlocks.WARPED_CRAFTING_TABLE.get(),   CWBlocks.WARPED_CRAFTER.get()},
                    {CWBlocks.BAMBOO_CRAFTING_TABLE.get(),   CWBlocks.BAMBOO_CRAFTER.get()}
            };
            for (ItemLike[] pair : pairs) {
                registration.addRecipeCatalyst(new ItemStack(pair[0]), RecipeTypes.CRAFTING);
                registration.addRecipeCatalyst(new ItemStack(pair[1]), RecipeTypes.CRAFTING);
            }
        }
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<RecipeHolder<CraftingRecipe>> cwRecipes = recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeType.CRAFTING)
                .filter(holder -> holder.value().isSpecial())
                .filter(holder -> holder.id().getNamespace().equals(CarvedWood.MOD_ID))
                .map(holder -> (RecipeHolder<CraftingRecipe>) holder)
                .toList();

        registration.addRecipes(RecipeTypes.CRAFTING, cwRecipes);
    }
}