package net.im_maker.carved_wood;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.im_maker.carved_wood.client.renderer.CWModelLayers;
import net.im_maker.carved_wood.client.renderer.inventory.FabricCWItemRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWCampfireRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWChestRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWLecternRenderer;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.im_maker.carved_wood.common.block.CWChestBlock;
import net.im_maker.carved_wood.common.block.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.CWChestBlockEntity;
import net.im_maker.carved_wood.common.block.entity.CWTrappedChestBlockEntity;
import net.im_maker.carved_wood.common.registers.CWBlockEntities;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.HashMap;
import java.util.Map;

public class CarvedWoodClient implements ClientModInitializer {
    public static final Map<Block, Item> ChestBlockItem = new HashMap<>();
    public static final Map<Block, Item> TrappedChestBlockItem = new HashMap<>();
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_LADDER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_SPRUCE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_BIRCH_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_JUNGLE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_ACACIA_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_DARK_OAK_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_MANGROVE_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_CHERRY_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_PALE_OAK_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_CRIMSON_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_WARPED_CAMPFIRE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_BAMBOO_CAMPFIRE.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.OAK_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_LANTERN.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_LANTERN.get(), RenderType.cutout());

        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.DOUBLE_CHEST_LEFT, CWChestRenderer::createDoubleBodyLeftLayer);
        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.DOUBLE_CHEST_RIGHT, CWChestRenderer::createDoubleBodyRightLayer);

        BlockEntityRenderers.register(CWBlockEntities.CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.TRAPPED_CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.CAMPFIRE.get(), CWCampfireRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.LECTERN.get(), CWLecternRenderer::new);

        //MixinEnvironment.getDefaultEnvironment().addConfiguration("carved_wood.fabric.mixins.json");

        for (Block block : CarvedWood.getBlocks(CWChestBlock.class)) {
            BlockEntity be = new CWChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
            CWBlockEntityWithoutLevelRenderer renderer = new CWBlockEntityWithoutLevelRenderer(
                    Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                    Minecraft.getInstance().getEntityModels(), be);

            BuiltinItemRendererRegistry.INSTANCE.register(
                    block.asItem(),
                    new FabricCWItemRenderer(renderer, ItemDisplayContext.GUI)
            );
        }

        for (Block block : CarvedWood.getBlocks(CWTrappedChestBlock.class)) {
            BlockEntity be = new CWTrappedChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
            CWBlockEntityWithoutLevelRenderer renderer = new CWBlockEntityWithoutLevelRenderer(
                    Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                    Minecraft.getInstance().getEntityModels(), be);

            BuiltinItemRendererRegistry.INSTANCE.register(
                    block.asItem(),
                    new FabricCWItemRenderer(renderer, ItemDisplayContext.GUI)
            );
        }
    }
}