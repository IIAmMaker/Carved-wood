package net.im_maker.paintable.common.item.paint_brushs;

import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.block.block_values.ModBlockStateProperties;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PaintBrushItem extends Item {
    public PaintBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        InteractionHand hand = context.getPlayer().getUsedItemHand();
        BlockState blockState = world.getBlockState(blockPos);

        if (isMatchingPaintBucketBlock(blockState)) {
            int paintLevel = getPaintLevel(blockState);

            if (paintLevel > 0) {
                ItemStack newPaintBrush = createNewPaintBrush();
                player.setItemInHand(hand, newPaintBrush); //itemStack -> Provided: itemtack
                playSoundEffect(world);
                updatePaintLevel(world, blockPos, paintLevel - 1);
                return InteractionResult.sidedSuccess(world.isClientSide());
            }
        }

        return InteractionResult.PASS;
    }

    private boolean isMatchingPaintBucketBlock(BlockState blockState) {
        return blockState.is(ModBlocks.PAINT_BUCKET.get()) && blockState.getValue(ModBlockStateProperties.LEVEL_PAINT) > 0;
    }

    private int getPaintLevel(BlockState blockState) {
        return blockState.getValue(ModBlockStateProperties.LEVEL_PAINT);
    }

    private ItemStack createNewPaintBrush() {
        return new ItemStack(ModItems.PAINT_BRUSH.get());
    }

    private void playSoundEffect(Level world) {
        // Code to play the sound effect
    }

    private void updatePaintLevel(Level world, BlockPos blockPos, int newPaintLevel) {
        BlockState updatedBlockState = world.getBlockState(blockPos).setValue(ModBlockStateProperties.LEVEL_PAINT, newPaintLevel);
        world.setBlockAndUpdate(blockPos, updatedBlockState);
    }
}