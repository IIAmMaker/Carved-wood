package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.custom.CWBarrelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWBarrelBlock extends BarrelBlock {
    public CWBarrelBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWBarrelBlockEntity(blockPos, blockState);
    }
}
