package net.im_maker.carved_wood.common.block.custom;

import com.mojang.serialization.MapCodec;
import net.im_maker.carved_wood.common.FlammableBlockRegistryCommon;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class CarvedPlanksBlock extends DirectionalBlock {
    public static final MapCodec<CarvedPlanksBlock> CODEC = simpleCodec(CarvedPlanksBlock::new);

    public CarvedPlanksBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) FlammableBlockRegistryCommon.getDefaultInstance().add(this, 20, 5);
    }

    public CarvedPlanksBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getClickedFace());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }
}
