package net.im_maker.carved_wood.mixin;

import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChiseledBookShelfBlock.class)
public abstract class MixinChiseledBookShelfBlock {

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
