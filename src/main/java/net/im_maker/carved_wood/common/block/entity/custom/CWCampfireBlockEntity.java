package net.im_maker.carved_wood.common.block.entity.custom;

import net.im_maker.carved_wood.common.block.custom.CWCampfireBlock;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CWCampfireBlockEntity extends CampfireBlockEntity implements Clearable {
    private final NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public CWCampfireBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    public static void particleTick(Level pLevel, BlockPos pPos, BlockState pState, CWCampfireBlockEntity pBlockEntity) {
        RandomSource randomsource = pLevel.random;
        if (randomsource.nextFloat() < 0.11F) {
            for(int i = 0; i < randomsource.nextInt(2) + 2; ++i) {
                CWCampfireBlock.makeParticles(pLevel, pPos, pState.getValue(CWCampfireBlock.SIGNAL_FIRE), false);
            }
        }

        int l = pState.getValue(CWCampfireBlock.FACING).get2DDataValue();

        for(int j = 0; j < pBlockEntity.items.size(); ++j) {
            if (!pBlockEntity.items.get(j).isEmpty() && randomsource.nextFloat() < 0.2F) {
                Direction direction = Direction.from2DDataValue(Math.floorMod(j + l, 4));
                float f = 0.3125F;
                double d0 = (double)pPos.getX() + 0.5D - (double)((float)direction.getStepX() * 0.3125F) + (double)((float)direction.getClockWise().getStepX() * 0.3125F);
                double d1 = (double)pPos.getY() + 0.5D;
                double d2 = (double)pPos.getZ() + 0.5D - (double)((float)direction.getStepZ() * 0.3125F) + (double)((float)direction.getClockWise().getStepZ() * 0.3125F);

                for(int k = 0; k < 4; ++k) {
                    pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 5.0E-4D, 0.0D);
                }
            }
        }

    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.CAMPFIRE.get();
    }
}