package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.custom.CWBeehiveBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWBeehiveBlock extends BeehiveBlock {
    private final Boolean isFlammable;

    public CWBeehiveBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
    }

    public CWBeehiveBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 20 : 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 5 : 0;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWBeehiveBlockEntity(blockPos, blockState);
    }
}
