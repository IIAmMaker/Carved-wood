package net.im_maker.carved_wood.combapility.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.CWCraftingTableBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

@JeiPlugin
public class JEICmp implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CarvedWood.MOD_ID, "jei_plugin");
    }

    private static Block[] getBlocks(Class<?> blockClass) {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(blockClass::isInstance)
                .toArray(Block[]::new);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        for (ItemLike craftingTables :getBlocks(CWCraftingTableBlock.class)) {
            registration.addRecipeCatalyst(new ItemStack(craftingTables), RecipeTypes.CRAFTING);

        }
    }
}
