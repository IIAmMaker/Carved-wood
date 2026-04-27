package net.im_maker.carved_wood.compatibility.WoodGood.ss;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CompatLecternBlock extends LecternBlock {
    private final Boolean isFlammable;

    public CompatLecternBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 30);
    }

    public CompatLecternBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CompatLecternBlockEntity(blockPos, blockState);
    }
}
