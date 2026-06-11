package net.im_maker.carved_wood;

import net.im_maker.carved_wood.client.renderer.CWModelLayers;
import net.im_maker.carved_wood.client.renderer.block.CWCampfireRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWChestRenderer;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.im_maker.carved_wood.common.block.CWChestBlock;
import net.im_maker.carved_wood.common.block.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.CWChestBlockEntity;
import net.im_maker.carved_wood.common.block.entity.CWTrappedChestBlockEntity;
import net.im_maker.carved_wood.common.registers.CWBlockEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.LecternRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = CarvedWood.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CarvedWoodClient {
    @SubscribeEvent
    public static void registerLayer (EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
        event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_LEFT, CWChestRenderer::createDoubleBodyLeftLayer);
        event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_RIGHT, CWChestRenderer::createDoubleBodyRightLayer);
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(CWBlockEntityTypes.CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntityTypes.TRAPPED_CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntityTypes.CAMPFIRE.get(), CWCampfireRenderer::new);
        BlockEntityRenderers.register(CWBlockEntityTypes.LECTERN.get(), LecternRenderer::new);
        for (String woodType : CarvedWood.WOOD_TYPES) {
            ItemBlockRenderTypes.setRenderLayer(CarvedWood.getBlockFromString(woodType + "_lantern"), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CarvedWood.getBlockFromString(woodType + "_campfire"), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CarvedWood.getBlockFromString("soul_" + woodType + "_campfire"), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(CarvedWood.getBlockFromString(woodType + "_ladder"), RenderType.cutout());
        }
        //MixinEnvironment.getDefaultEnvironment().addConfiguration("carved_wood.mixins.json");
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        for (Block block : CarvedWood.getBlocks(CWChestBlock.class)) {
            BlockEntity be = new CWChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
            event.registerItem(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer renderer =
                        new CWBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                                Minecraft.getInstance().getEntityModels(),be);
                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return renderer;
                }
            }, block.asItem());
        }

        for (Block block : CarvedWood.getBlocks(CWTrappedChestBlock.class)) {
            BlockEntity be = new CWTrappedChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
            event.registerItem(new IClientItemExtensions() {
                private final BlockEntityWithoutLevelRenderer renderer =
                        new CWBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                                Minecraft.getInstance().getEntityModels(), be);
                @Override
                public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                    return renderer;
                }
            }, block.asItem());
        }
    }
}
