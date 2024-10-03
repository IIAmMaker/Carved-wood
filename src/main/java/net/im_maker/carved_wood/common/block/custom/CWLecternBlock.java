package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWLecternBlock extends LecternBlock {
    private final Boolean isFlammable;

    public CWLecternBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
    }

    public CWLecternBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 20 : 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 30 : 0;
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWLecternBlockEntity(blockPos, blockState);
    }
}
