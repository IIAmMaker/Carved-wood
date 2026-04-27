package net.im_maker.carved_wood.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.mehvahdjukaar.amendments.configs.CommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LecternBlockEntity.class)
public abstract class MixinLecternBlockEntity extends BlockEntity implements Container {


    public MixinLecternBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    //@Inject(method = "createMenu", at = @At("HEAD"), cancellable = true)
    //public void createCustomMenu(int id, Inventory inventory, Player player, CallbackInfoReturnable<AbstractContainerMenu> cir) {
    //    if (FabricLoader.getInstance().isModLoaded("amendments") &&
    //            this.getBook().getItem() instanceof WritableBookItem &&
    //            CommonConfigs.LECTERN_STUFF.get()) {
//
    //        ContainerData data = ((LecternBlockEntityAccessor) this).getDataAccess();
    //        cir.setReturnValue(new LecternEditMenu(id, (LecternBlockEntity)(Object)this, data));
    //    }
    //}
}