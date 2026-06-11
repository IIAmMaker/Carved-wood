package net.im_maker.carved_wood.mixin.create;

import com.simibubi.create.content.redstone.link.controller.LinkedControllerItem;
import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.im_maker.carved_wood.compatibility.create.CWLecternRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.LecternBlock;

@Mixin(LinkedControllerItem.class)
public class LinkedControllerItemMixin {

    @Inject(method = "onItemUseFirst", at = @At("HEAD"), cancellable = true)
    private void cw$customLecterns(ItemStack stack, UseOnContext ctx, CallbackInfoReturnable<InteractionResult> cir) {
        Player player = ctx.getPlayer();
        if (player == null)
            return;
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        BlockState hitState = world.getBlockState(pos);
        Block block = hitState.getBlock();

        if (player.mayBuild()) {
            if (player.isShiftKeyDown()) {
                if (CWLecternRegistry.isCWLecternController(block)) {
                    CWLecternControllerBlock controllerBlock = ((CWLecternControllerBlock) block);
                    if (!world.isClientSide)
                        controllerBlock.withBlockEntityDo(world, pos, be ->
                                be.swapControllers(stack, player, ctx.getHand(), hitState));
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            } else {
                if (CWLecternRegistry.isCWLectern(block) && !hitState.getValue(LecternBlock.HAS_BOOK)) {
                    if (!world.isClientSide) {
                        CWLecternControllerBlock controllerBlock = (CWLecternControllerBlock)CWLecternRegistry.getLecternController(block);
                        ItemStack lecternStack = player.isCreative() ? stack.copy() : stack.split(1);
                        controllerBlock.replaceLectern(hitState, world, pos, lecternStack);
                    }
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }

                if (CWLecternRegistry.isCWLecternController(block))
                    cir.setReturnValue(InteractionResult.PASS);
            }
        }
    }
}