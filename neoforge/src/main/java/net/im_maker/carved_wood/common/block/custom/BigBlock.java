package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.block_values.CWBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BigBlock extends RotatedPillarBlock {
    private final Boolean isFlammable;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty ODD = CWBlockStateProperties.ODD;
    public static final BooleanProperty END_ODD = CWBlockStateProperties.END_ODD;
    public BigBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        this.registerDefaultState(this.stateDefinition.any().setValue(ODD, false).setValue(END_ODD, false).setValue(AXIS, Direction.Axis.Y));
    }

    public BigBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 20 : super.getFlammability(state, level, pos, direction);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return isFlammable ? 5 : super.getFlammability(state, level, pos, direction);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Direction.Axis placedAxis = context.getClickedFace().getAxis();
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        Boolean isOdd;
        Boolean isEndOdd;
        if (placedAxis == Direction.Axis.Y) {
            isOdd = (y %2 == 0);
            isEndOdd = (x %2 == 0);
        } else {
            isOdd = ((x %2 == 0) ^ (z %2 == 0));
            if (placedAxis == Direction.Axis.X) {
                isEndOdd = (x %2 == 0);
            } else {
                isEndOdd = (z %2 == 0);
            }
        }
        return this.defaultBlockState().setValue(ODD, isOdd).setValue(END_ODD, isEndOdd).setValue(AXIS, context.getClickedFace().getAxis());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(ODD, END_ODD, AXIS);
    }
}
