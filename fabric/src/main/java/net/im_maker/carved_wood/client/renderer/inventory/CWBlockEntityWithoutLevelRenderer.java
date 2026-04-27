package net.im_maker.carved_wood.client.renderer.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CWBlockEntityWithoutLevelRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    private final BlockEntity blockEntity;

    public CWBlockEntityWithoutLevelRenderer(BlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public void render(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        BlockEntityRenderDispatcher dispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        dispatcher.renderItem(blockEntity, matrices, vertexConsumers, light, overlay);
    }
}