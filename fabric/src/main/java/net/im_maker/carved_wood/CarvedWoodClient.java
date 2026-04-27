package net.im_maker.carved_wood;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.client.renderer.CWModelLayers;
import net.im_maker.carved_wood.client.renderer.block.CWCampfireRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWChestRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWLecternRenderer;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.block.custom.CWChestBlock;
import net.im_maker.carved_wood.common.block.custom.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWChestBlockEntity;
import net.im_maker.carved_wood.common.block.entity.custom.CWTrappedChestBlockEntity;
import net.mehvahdjukaar.every_compat.common_classes.CompatChestBlockEntity;
import net.mehvahdjukaar.every_compat.common_classes.CompatChestBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CarvedWoodClient implements ClientModInitializer {
    public static final Map<Block, Item> ChestBlockItem = new HashMap<>();
    public static final Map<Block, Item> TrappedChestBlockItem = new HashMap<>();
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_LADDER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_SPRUCE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_BIRCH_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_JUNGLE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_ACACIA_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_DARK_OAK_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_MANGROVE_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_CHERRY_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_PALE_OAK_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_CRIMSON_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_WARPED_CAMPFIRE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SOUL_BAMBOO_CAMPFIRE, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.OAK_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.SPRUCE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BIRCH_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.JUNGLE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.ACACIA_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.DARK_OAK_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.MANGROVE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CHERRY_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.PALE_OAK_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.CRIMSON_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.WARPED_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CWBlocks.BAMBOO_LANTERN, RenderType.cutout());

        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.DOUBLE_CHEST_LEFT, CWChestRenderer::createDoubleBodyLeftLayer);
        EntityModelLayerRegistry.registerModelLayer(CWModelLayers.DOUBLE_CHEST_RIGHT, CWChestRenderer::createDoubleBodyRightLayer);

        BlockEntityRenderers.register(CWBlockEntities.CHEST, CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.TRAPPED_CHEST, CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.CAMPFIRE, CWCampfireRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.LECTERN, CWLecternRenderer::new);

        //MixinEnvironment.getDefaultEnvironment().addConfiguration("carved_wood.fabric.mixins.json");

        for (Block block : CarvedWood.getBlocks(CWChestBlock.class)) {
            BlockEntity be = new CWChestBlockEntity(new BlockPos(0, 0, 0), block.defaultBlockState());
            BuiltinItemRendererRegistry.INSTANCE.register(block.asItem(), new CWBlockEntityWithoutLevelRenderer(be));
        }

        for (Block block : CarvedWood.getBlocks(CWTrappedChestBlock.class)) {
            BlockEntity be = new CWTrappedChestBlockEntity(new BlockPos(0, 0, 0), block.defaultBlockState());
            BuiltinItemRendererRegistry.INSTANCE.register(block.asItem(), new CWBlockEntityWithoutLevelRenderer(be));
        }
    }
}