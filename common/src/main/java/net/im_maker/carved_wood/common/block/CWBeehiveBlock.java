package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.common.block.entity.CWBeehiveBlockEntity;
import net.im_maker.carved_wood.common.registers.CWBlockEntities;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CWBeehiveBlock extends BeehiveBlock {

    public CWBeehiveBlock(Properties pProperties) {
        this(pProperties, true);
    }

    public CWBeehiveBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 20, 5);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
        return level.isClientSide ? null : createTickerHelper(type, CWBlockEntities.BEEHIVE.get(), CWBeehiveBlockEntity::serverTick);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWBeehiveBlockEntity(blockPos, blockState);
    }
}
