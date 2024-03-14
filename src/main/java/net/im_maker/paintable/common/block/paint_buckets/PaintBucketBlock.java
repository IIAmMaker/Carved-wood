package net.im_maker.paintable.common.block.paint_buckets;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import javax.annotation.Nullable;

public class PaintBucketBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public PaintBucketBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(4, 0, 4, 12, 10, 12);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        return direction == Direction.DOWN && !this.canSurvive(blockState, levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState1, levelAccessor, blockPos, blockPos1);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return canSupportCenter(levelReader, blockPos.below(), Direction.UP);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        Direction[] adirection = blockPlaceContext.getNearestLookingDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(levelreader, blockpos)) {
                    return blockstate;
                }
            }
        }

        return null;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING);
    }
}
