package net.im_maker.carved_wood.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PlanksStairBlock extends StairBlock {
    private final Boolean isFlammable;

    public PlanksStairBlock(BlockState pBaseState, Properties pProperties, Boolean isFlammable) {
        super(pBaseState, pProperties);
        this.isFlammable = isFlammable;
    }

    public PlanksStairBlock(BlockState pBaseState, Properties pProperties) {
        this(pBaseState, pProperties, true);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 20 : super.getFlammability(state, level, pos, direction);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 5 : super.getFlammability(state, level, pos, direction);
    }
}
