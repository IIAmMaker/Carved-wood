package net.im_maker.carved_wood.mixin;

import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WrittenBookItem.class)
public abstract class WrittenBookItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    public void onUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (blockState.is(CWTags.Blocks.LECTERNS)) {
            if (LecternBlock.tryPlaceBook(context.getPlayer(), level, blockPos, blockState, context.getItemInHand())) {
                cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
            } else {
                cir.setReturnValue(InteractionResult.PASS);
            }
        } else {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }
}