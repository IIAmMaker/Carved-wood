package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWChestBlock extends ChestBlock {
    private final String chestName;
    public CWChestBlock(String name, Properties properties) {
        super(properties, CWBlockEntities.CHEST::get);
        this.chestName = name;
    }

    public String getChestName() {
        return chestName;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWChestBlockEntity(blockPos, blockState);
    }
}
