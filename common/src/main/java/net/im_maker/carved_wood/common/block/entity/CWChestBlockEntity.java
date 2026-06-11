package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.common.registers.CWBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CWChestBlockEntity extends ChestBlockEntity {

    public CWChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(CWBlockEntityTypes.CHEST.get(), pPos, pBlockState);
    }

    public CWChestBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CWBlockEntityTypes.CHEST.get();
    }

    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }

    public Container getContainer() {
        return ChestBlock.getContainer((ChestBlock) this.getBlockState().getBlock(), this.getBlockState(), this.getLevel(), this.getBlockPos(), true);
    }

    public static CWChestBlockEntity create(BlockPos pos, BlockState state) {
        return new CWChestBlockEntity(pos, state);
    }
}