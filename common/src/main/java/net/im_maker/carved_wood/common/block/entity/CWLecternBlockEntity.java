package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.common.registers.CWBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWLecternBlockEntity extends LecternBlockEntity {
    public CWLecternBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.LECTERN.get();
    }

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }
}