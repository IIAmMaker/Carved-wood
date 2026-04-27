package net.im_maker.carved_wood.compatibility.WoodGood.ss;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.im_maker.carved_wood.client.renderer.block.CWLecternRenderer;
import net.im_maker.carved_wood.common.block.custom.CWLecternBlock;
import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.EnchantTableRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@Environment(EnvType.CLIENT)
public class CompatLecternBlockRenderer extends CWLecternRenderer<CWLecternBlockEntity> {
    private final BookModel bookModel;

    public String shortenedId;

    public CompatLecternBlockRenderer(BlockEntityRendererProvider.Context context, String shortenedId) {
        super(context);
        this.bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }

    public void render(CWLecternBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        BlockState blockstate = blockEntity.getBlockState();
        if (blockstate.getValue(CWLecternBlock.HAS_BOOK)) {
            poseStack.pushPose();
            poseStack.translate(0.5F, 1.0625F, 0.5F);
            float f = blockstate.getValue(CWLecternBlock.FACING).getClockWise().toYRot();
            poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            poseStack.mulPose(Axis.ZP.rotationDegrees(67.5F));
            poseStack.translate(0.0F, -0.125F, 0.0F);
            this.bookModel.setupAnim(0.0F, 0.1F, 0.9F, 1.2F);
            VertexConsumer vertexconsumer = EnchantTableRenderer.BOOK_LOCATION.buffer(buffer, RenderType::entitySolid);
            this.bookModel.render(poseStack, vertexconsumer, packedLight, packedOverlay, -1);
            poseStack.popPose();
        }
    }

    public static void register(ClientHelper.BlockEntityRendererEvent event, BlockEntityType<CWLecternBlockEntity> tile, String s) {
        event.register(tile, (c) -> new CompatLecternBlockRenderer(c, s));
    }
}
