package net.im_maker.paintable.common.block.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    public BlockEntityType<?> getType() {
        return ModBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
}