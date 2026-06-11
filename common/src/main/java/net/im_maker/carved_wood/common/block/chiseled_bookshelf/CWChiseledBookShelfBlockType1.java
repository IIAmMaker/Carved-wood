package net.im_maker.carved_wood.common.block.chiseled_bookshelf;

import net.im_maker.carved_wood.common.block.entity.CWChiseledBookShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWChiseledBookShelfBlockType1 extends ChiseledBookShelfBlock {
    public CWChiseledBookShelfBlockType1(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWChiseledBookShelfBlockEntity(blockPos, blockState);
    }
}