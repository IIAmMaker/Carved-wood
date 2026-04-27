package net.im_maker.carved_wood.common.block.entity.custom;

import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.mixin.LecternBlockEntityAccessor;
import net.mehvahdjukaar.amendments.configs.CommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWLecternBlockEntity extends LecternBlockEntity {

    public CWLecternBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.LECTERN;
    }

    //@Override
    //public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
    //    ItemStack book = this.getBook();
//
    //    // Check for Amendments mod compatibility
    //    if (FabricLoader.getInstance().isModLoaded("amendments") &&
    //        book.getItem() instanceof WritableBookItem &&
    //        CommonConfigs.LECTERN_STUFF.get()) {
//
    //        ContainerData data = ((LecternBlockEntityAccessor) this).getDataAccess();
    //        return new LecternEditMenu(id, this, data);
    //    }
//
    //    // Fall back to vanilla behavior
    //    return super.createMenu(id, inventory, player);
    //}

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }
}