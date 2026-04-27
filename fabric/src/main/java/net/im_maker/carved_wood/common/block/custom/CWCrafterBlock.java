package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.custom.CWBeehiveBlockEntity;
import net.im_maker.carved_wood.common.block.entity.custom.CWCrafterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CrafterBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWCrafterBlock extends CrafterBlock {
    public CWCrafterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWCrafterBlockEntity(blockPos, blockState);
    }
}
