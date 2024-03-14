package net.im_maker.paintable.common.block.sign;

import net.im_maker.paintable.common.block.block_entity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallSignBlock extends WallSignBlock {
    public ModWallSignBlock(Properties properties, WoodType woodType) {
        super(properties, woodType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ModSignBlockEntity(blockPos, blockState);
    }
}
