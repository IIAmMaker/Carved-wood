package net.im_maker.carved_wood.compatibility.jei;//package net.im_maker.carved_wood.compatibility.jei;
//
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.constants.RecipeTypes;
//import mezz.jei.api.registration.IRecipeCatalystRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.im_maker.carved_wood.CarvedWood;
//import net.im_maker.carved_wood.common.block.CWBlocks;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.CraftingRecipe;
//import net.minecraft.world.item.crafting.RecipeHolder;
//import net.minecraft.world.level.block.Block;
//import net.neoforged.neoforge.registries.DeferredBlock;
//
//import java.util.List;
//
//@JeiPlugin
//public class JEICompat implements IModPlugin {
//    @Override
//    public ResourceLocation getPluginUid() {
//        return ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "jei_plugin");
//    }
//
//    private static Block[] getBlocks(Class<?> blockClass) {
//        return BuiltInRegistries.BLOCK.stream()
//                .filter(blockClass::isInstance)
//                .toArray(Block[]::new);
//    }
//
//    @Override
//    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        DeferredBlock<Block>[][] pairs = new DeferredBlock[][]{
//                { CWBlocks.SPRUCE_CRAFTING_TABLE,  CWBlocks.SPRUCE_CRAFTER },
//                { CWBlocks.BIRCH_CRAFTING_TABLE,   CWBlocks.BIRCH_CRAFTER },
//                { CWBlocks.JUNGLE_CRAFTING_TABLE,  CWBlocks.JUNGLE_CRAFTER },
//                { CWBlocks.ACACIA_CRAFTING_TABLE, CWBlocks.ACACIA_CRAFTER },
//                { CWBlocks.DARK_OAK_CRAFTING_TABLE,CWBlocks.DARK_OAK_CRAFTER },
//                { CWBlocks.MANGROVE_CRAFTING_TABLE,CWBlocks.MANGROVE_CRAFTER },
//                { CWBlocks.CHERRY_CRAFTING_TABLE, CWBlocks.CHERRY_CRAFTER },
//                { CWBlocks.PALE_OAK_CRAFTING_TABLE,CWBlocks.PALE_OAK_CRAFTER },
//                { CWBlocks.CRIMSON_CRAFTING_TABLE, CWBlocks.CRIMSON_CRAFTER },
//                { CWBlocks.WARPED_CRAFTING_TABLE,  CWBlocks.WARPED_CRAFTER },
//                { CWBlocks.BAMBOO_CRAFTING_TABLE,  CWBlocks.BAMBOO_CRAFTER }
//        };
//
//        for (DeferredBlock<Block>[] pair : pairs) {
//            registration.addRecipeCatalyst(new ItemStack(pair[0].get()), RecipeTypes.CRAFTING);
//            registration.addRecipeCatalyst(new ItemStack(pair[1].get()), RecipeTypes.CRAFTING);
//        }
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        List<RecipeHolder<CraftingRecipe>> CWRecipes = CarvedWoodRecipeMaker.createCWRecipes();
//        registration.addRecipes(RecipeTypes.CRAFTING, CWRecipes);
//    }
//}