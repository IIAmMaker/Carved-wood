package net.im_maker.carved_wood.client.renderer.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRenderer;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class FabricCWItemRenderer implements BuiltinItemRenderer {

    private final CWBlockEntityWithoutLevelRenderer renderer;
    private final ItemDisplayContext context;

    public FabricCWItemRenderer(CWBlockEntityWithoutLevelRenderer renderer, ItemDisplayContext context) {
        this.renderer = renderer;
        this.context = context;
    }

    @Override
    public void render(ItemStack stack, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        renderer.renderByItem(stack, context, matrices, vertexConsumers, light, overlay);
    }
}