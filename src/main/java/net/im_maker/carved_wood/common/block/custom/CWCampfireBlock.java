package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWCampfireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class CWCampfireBlock extends CampfireBlock {

    public CWCampfireBlock(boolean pSpawnParticles, int pFireDamage, Properties pProperties) {
        super(pSpawnParticles, pFireDamage, pProperties);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide) {
            return pState.getValue(LIT) ? createTickerHelper(pBlockEntityType, CWBlockEntities.CAMPFIRE.get(), CWCampfireBlockEntity::particleTick) : null;
        } else {
            return pState.getValue(LIT) ? createTickerHelper(pBlockEntityType, CWBlockEntities.CAMPFIRE.get(), CWCampfireBlockEntity::cookTick) : createTickerHelper(pBlockEntityType, CWBlockEntities.CAMPFIRE.get(), CWCampfireBlockEntity::cooldownTick);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWCampfireBlockEntity(blockPos, blockState);
    }
}
