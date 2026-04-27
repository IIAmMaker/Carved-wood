package net.im_maker.carved_wood.common.block.custom;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;

import net.im_maker.carved_wood.common.block.block_values.CWBlockStateProperties;
import net.im_maker.carved_wood.common.block.block_values.WoodenLanternShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodenLantern extends Block implements SimpleWaterloggedBlock {
    public static final MapCodec<WoodenLantern> CODEC = simpleCodec(WoodenLantern::new);
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final EnumProperty<WoodenLanternShape> SHAPE = CWBlockStateProperties.WOODEN_LANTERN_SHAPE;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape AABB = Block.box(4.0, 2.0, 4.0, 12.0, 12.0, 12.0);
    protected static final VoxelShape AA = Block.box(3.0, 0.0, 3.0, 13.0, 2.0, 13.0);
    protected static final VoxelShape BB = Block.box(3.0, 12.0, 3.0, 13.0, 14.0, 13.0);
    protected static final VoxelShape AB = Block.box(6.0, 14.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HS_N = Block.box(6.0, 14.0, 6.0, 10.0, 16.0, 16.0);
    protected static final VoxelShape HW_N = Block.box(6.0, 14.0, 6.0, 10.0, 16.0, 20.0);
    protected static final VoxelShape HF_N = Block.box(6.0, 14.0, 6.0, 10.0, 16.0, 22.0);
    protected static final VoxelShape HS_S = Block.box(6.0, 14.0, 0.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HW_S = Block.box(6.0, 14.0, -4.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HF_S = Block.box(6.0, 14.0, -6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HS_E = Block.box(0.0, 14.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HW_E = Block.box(-4.0, 14.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HF_E = Block.box(-6.0, 14.0, 6.0, 10.0, 16.0, 10.0);
    protected static final VoxelShape HS_W = Block.box(6.0, 14.0, 6.0, 16.0, 16.0, 10.0);
    protected static final VoxelShape HW_W = Block.box(6.0, 14.0, 6.0, 20.0, 16.0, 10.0);
    protected static final VoxelShape HF_W = Block.box(6.0, 14.0, 6.0, 22.0, 16.0, 10.0);
    protected static final VoxelShape UNHANGING_SHAPE = Shapes.or(AABB, AA, BB);
    protected static final VoxelShape HANGING_SHAPE = Shapes.or(AABB, AA, BB, AB);

    @Override
    public MapCodec<WoodenLantern> codec() {
        return CODEC;
    }

    public WoodenLantern(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HANGING, Boolean.valueOf(false)).setValue(SHAPE, WoodenLanternShape.SETTING).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        LevelReader level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        FluidState fluid = level.getFluidState(pos);

        Direction clickedFace = ctx.getClickedFace();
        Direction horizontalFacing = ctx.getHorizontalDirection().getOpposite();

        boolean supportAbove = Block.canSupportCenter(level, pos.above(), Direction.DOWN);
        boolean supportBelow = Block.canSupportCenter(level, pos.below(), Direction.UP) || (level.getBlockState(pos.below()).getBlock() instanceof WoodenLantern);

        BlockState state = defaultBlockState()
                .setValue(FACING, horizontalFacing)
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        if (level.getBlockState(pos.above()).getBlock() instanceof WoodenLantern && state.getValue(SHAPE) == WoodenLanternShape.SETTING) {
            return state.setValue(SHAPE, WoodenLanternShape.HANGING);
        }

        if (clickedFace.getAxis().isHorizontal()) {
            BlockPos supportPos = pos.relative(clickedFace.getOpposite());
            BlockState supportState = level.getBlockState(supportPos);

            if (Block.canSupportCenter(level, supportPos, clickedFace)) {
                WoodenLanternShape shape = WoodenLanternShape.HANGING_SIDE;

                return state
                        .setValue(HANGING, true)
                        .setValue(FACING, clickedFace)
                        .setValue(SHAPE, shape);
            }

            if (supportState.getBlock() instanceof FenceBlock) {
                WoodenLanternShape shape = WoodenLanternShape.HANGING_FENCE;
                return state
                        .setValue(HANGING, true)
                        .setValue(FACING, clickedFace)
                        .setValue(SHAPE, shape);
            }

            if (supportState.getBlock() instanceof WallBlock) {
                WoodenLanternShape shape = WoodenLanternShape.HANGING_WALL;
                return state
                        .setValue(HANGING, true)
                        .setValue(FACING, clickedFace)
                        .setValue(SHAPE, shape);
            }
        }

        // Ceiling hanging
        if ((clickedFace == Direction.DOWN && supportAbove) || (!supportBelow && supportAbove)) {
            return state
                    .setValue(HANGING, true)
                    .setValue(SHAPE, WoodenLanternShape.HANGING);
        }
        // Floor placement
        if (supportBelow) {
            return state.setValue(HANGING, false).setValue(SHAPE, WoodenLanternShape.SETTING);
        }
        return null;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        VoxelShape boxShape = UNHANGING_SHAPE;

        if (state.getValue(SHAPE).isHanging()) {
            boxShape = HANGING_SHAPE;
            if (state.getValue(SHAPE)==WoodenLanternShape.HANGING_SIDE) {
                switch (state.getValue(FACING)) {
                    case Direction.NORTH: boxShape = Shapes.or(AABB, AA, BB, HS_N); break;
                    case Direction.SOUTH: boxShape = Shapes.or(AABB, AA, BB, HS_S); break;
                    case Direction.EAST: boxShape = Shapes.or(AABB, AA, BB, HS_E); break;
                    case Direction.WEST: boxShape = Shapes.or(AABB, AA, BB, HS_W); break;
                }
            } else if (state.getValue(SHAPE)==WoodenLanternShape.HANGING_WALL) {
                switch (state.getValue(FACING)) {
                    case Direction.NORTH: boxShape = Shapes.or(AABB, AA, BB, HW_N); break;
                    case Direction.SOUTH: boxShape = Shapes.or(AABB, AA, BB, HW_S); break;
                    case Direction.EAST: boxShape = Shapes.or(AABB, AA, BB, HW_E); break;
                    case Direction.WEST: boxShape = Shapes.or(AABB, AA, BB, HW_W); break;
                }
            } else if (state.getValue(SHAPE)==WoodenLanternShape.HANGING_FENCE) {
                switch (state.getValue(FACING)) {
                    case Direction.NORTH: boxShape = Shapes.or(AABB, AA, BB, HF_N); break;
                    case Direction.SOUTH: boxShape = Shapes.or(AABB, AA, BB, HF_S); break;
                    case Direction.EAST: boxShape = Shapes.or(AABB, AA, BB, HF_E); break;
                    case Direction.WEST: boxShape = Shapes.or(AABB, AA, BB, HF_W); break;
                }
            }
        }
        return boxShape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(HANGING, SHAPE, WATERLOGGED, FACING);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        WoodenLanternShape shape = state.getValue(SHAPE);
        Direction facing = state.getValue(FACING);
        BlockPos supportPos = pos.relative(facing.getOpposite());
        switch (shape) {
            case WoodenLanternShape.SETTING: return
                    Block.canSupportCenter(level, pos.below(), Direction.UP)
                    || (level.getBlockState(pos.below()).getBlock() instanceof WoodenLantern);
            case WoodenLanternShape.HANGING: return
                    Block.canSupportCenter(level, pos.above(), Direction.DOWN)
                    || Block.canSupportCenter(level, pos.below(), Direction.UP);
            case WoodenLanternShape.HANGING_FENCE: {
                for (Direction dir : Direction.Plane.HORIZONTAL) {
                    if (facing == dir) {
                        if (level.getBlockState(pos.relative(dir.getOpposite())).getBlock() instanceof FenceBlock) {
                            return true;
                        }
                    }
                }
            } break;
            case WoodenLanternShape.HANGING_WALL: {
                for (Direction dir : Direction.Plane.HORIZONTAL) {
                    if (facing == dir) {
                        if (level.getBlockState(pos.relative(dir.getOpposite())).getBlock() instanceof WallBlock) {
                            return true;
                        }
                    }
                }
            } break;
        }
        return Block.canSupportCenter(level, supportPos, facing);
    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            Direction dir,
            BlockState neighbor,
            LevelAccessor level,
            BlockPos pos,
            BlockPos neighborPos) {

        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        if (level.getBlockState(pos.above()).getBlock() instanceof WoodenLantern && state.getValue(SHAPE) == WoodenLanternShape.SETTING) {
            return state.setValue(SHAPE, WoodenLanternShape.HANGING);
        }

        return !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, dir, neighbor, level, pos, neighborPos);
    }


    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }
}