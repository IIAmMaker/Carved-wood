package net.im_maker.carved_wood.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ChiseledBookShelfBlock.class)
public abstract class ChiseledBookShelfBlockMixin {

    //@Inject(method = "getSection", at = @At("HEAD"), cancellable = true)
    //private static void getSectionMixin(float pX, CallbackInfoReturnable<Integer> cir) {
    //    if (pX < 0.375F) {
    //        cir.setReturnValue(0);
    //    } else if (pX < 0.75F) {
    //        cir.setReturnValue(1);
    //    } else {
    //        cir.setReturnValue(2);
    //    }
    //}

    @Inject(method = "getHitSlot", at = @At("HEAD"), cancellable = true)
    private static void getHitSlotMixin(Vec2 pHitPos, CallbackInfoReturnable<Integer> cir) {
        int i = pHitPos.y >= 0.5F ? 0 : 1;
        int j = getSectionMixin(pHitPos.x);
        cir.setReturnValue(j + i * 3);
    }

    private static int getSectionMixin(float pX) {
        if (pX < 0.375F) {
            return 0;
        } else {
            return pX < 0.75F ? 1 : 2;
        }
    }
}
