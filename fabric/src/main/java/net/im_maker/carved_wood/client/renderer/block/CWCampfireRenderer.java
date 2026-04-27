package net.im_maker.carved_wood.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.im_maker.carved_wood.common.block.entity.custom.CWCampfireBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CampfireBlock;

public class CWCampfireRenderer implements BlockEntityRenderer<CWCampfireBlockEntity> {
    private static final float SIZE = 0.375F;

    public CWCampfireRenderer(BlockEntityRendererProvider.Context context) {
    }

    public void render(CWCampfireBlockEntity campfireBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Direction direction = (Direction)campfireBlockEntity.getBlockState().getValue(CampfireBlock.FACING);
        NonNullList<ItemStack> nonNullList = campfireBlockEntity.getItems();
        int k = (int)campfireBlockEntity.getBlockPos().asLong();
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        for(int l = 0; l < nonNullList.size(); ++l) {
            ItemStack itemStack = (ItemStack)nonNullList.get(l);
            if (itemStack != ItemStack.EMPTY) {
                poseStack.pushPose();
                poseStack.translate(0.5F, 0.44921875F, 0.5F);
                Direction direction2 = Direction.from2DDataValue((l + direction.get2DDataValue()) % 4);
                float g = -direction2.toYRot();
                poseStack.mulPose(Axis.YP.rotationDegrees(g));
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                poseStack.translate(-0.3125F, -0.3125F, 0.0F);
                poseStack.scale(0.375F, 0.375F, 0.375F);
                itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, poseStack, multiBufferSource, campfireBlockEntity.getLevel(), k + l);
                poseStack.popPose();
            }
        }
    }
}