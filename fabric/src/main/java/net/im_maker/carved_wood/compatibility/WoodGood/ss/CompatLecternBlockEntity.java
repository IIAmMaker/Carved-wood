package net.im_maker.carved_wood.compatibility.WoodGood.ss;

import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CompatLecternBlockEntity extends CWLecternBlockEntity {

    public CompatLecternBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntities.LL;
    }

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }
}
