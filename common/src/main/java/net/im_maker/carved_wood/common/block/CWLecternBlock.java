package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.common.block.entity.CWLecternBlockEntity;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWLecternBlock extends LecternBlock {

    public CWLecternBlock(Properties pProperties) {
        this(pProperties, true);
    }

    public CWLecternBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 20, 30);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWLecternBlockEntity(blockPos, blockState);
    }
}
