package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWBeehiveBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CWBeehiveBlock extends BeehiveBlock {
    private final Boolean isFlammable;

    public CWBeehiveBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 5);
    }

    public CWBeehiveBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, CWBlockEntities.BEEHIVE, CWBeehiveBlockEntity::serverTick);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWBeehiveBlockEntity(blockPos, blockState);
    }
}
