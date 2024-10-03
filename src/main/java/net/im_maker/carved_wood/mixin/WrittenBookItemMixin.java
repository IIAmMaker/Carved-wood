package net.im_maker.carved_wood.mixin;

import net.im_maker.carved_wood.common.tags.CWTags;
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


    ///**
    // * Inject code after the original useOn method.
    // * This can be used to perform actions after the original method executes.
    // */
    //@Inject(method = "useOn", at = @At("RETURN"))
    //public void afterUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
    //    Level level = context.getLevel();
    //    BlockPos blockPos = context.getClickedPos();
    //    Player player = context.getPlayer();
    //    ItemStack itemStack = context.getItemInHand();
    //    InteractionResult result = cir.getReturnValue();
//
    //    // Example: Log the result of the useOn method
    //    // For simplicity, using System.out. For real mods, consider using a logger.
    //    System.out.println("useOn method executed with result: " + result);
    //}
}