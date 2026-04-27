package net.im_maker.carved_wood.common.block.entity.custom;

import net.im_maker.carved_wood.common.block.custom.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWTrappedChestBlockEntity extends TrappedChestBlockEntity {
    public CWTrappedChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.TRAPPED_CHEST;
    }

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }
}