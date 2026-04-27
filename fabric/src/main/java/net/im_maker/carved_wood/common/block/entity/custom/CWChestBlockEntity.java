package net.im_maker.carved_wood.common.block.entity.custom;

import net.im_maker.carved_wood.common.block.custom.CWChestBlock;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWChestBlockEntity extends ChestBlockEntity {
    public CWChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(CWBlockEntities.CHEST, pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.CHEST;
    }

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }
}