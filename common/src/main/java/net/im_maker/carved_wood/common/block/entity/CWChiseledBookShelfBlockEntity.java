package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.common.block.chiseled_bookshelf.CWChiseledBookShelfBlockType1;
import net.im_maker.carved_wood.common.registers.CWBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWChiseledBookShelfBlockEntity extends ChiseledBookShelfBlockEntity {
    public CWChiseledBookShelfBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntityTypes.CHISELED_BOOKSHELF.get();
    }

    public boolean isValidBlockState(BlockState state) {
        return state.getBlock() instanceof CWChiseledBookShelfBlockType1;
    }
}