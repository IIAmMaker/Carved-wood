package net.im_maker.paintable.common.block.paint_buckets;

import net.im_maker.paintable.common.block.block_values.ModBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FilledPaintBucketBlock extends PaintBucketBlock {
    public static final IntegerProperty LEVEL_PAINT = ModBlockStateProperties.LEVEL_PAINT;

    public FilledPaintBucketBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL_PAINT, 4));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(LEVEL_PAINT);
        blockStateBuilder.add(FACING);
    }
}
