package net.im_maker.carved_wood.client.renderer.inventory;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CWBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {

    private final BlockEntity be;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    public CWBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet, BlockEntity be) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);

        this.be = be;
        this.blockEntityRenderDispatcher = pBlockEntityRenderDispatcher;
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        this.blockEntityRenderDispatcher.renderItem(this.be, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }
}