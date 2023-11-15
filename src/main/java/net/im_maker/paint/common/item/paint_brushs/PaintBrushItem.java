package net.im_maker.paint.common.item.paint_brushs;

import net.im_maker.paint.common.block.ModBlocks;
import net.im_maker.paint.common.block.block_values.ModBlockStateProperties;
import net.im_maker.paint.common.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.is(ModBlocks.RED_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.RED_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.ORANGE_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.ORANGE_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.YELLOW_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.YELLOW_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.LIME_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.LIME_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.GREEN_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.GREEN_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.CYAN_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.CYAN_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.LIGHT_BLUE_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.LIGHT_BLUE_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.BLUE_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.BLUE_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.PURPLE_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.PURPLE_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.MAGENTA_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.MAGENTA_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.PINK_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.PINK_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.BROWN_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.BROWN_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.BLACK_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.BLACK_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.GRAY_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.GRAY_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.LIGHT_GRAY_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.LIGHT_GRAY_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlocks.WHITE_PAINT_BUCKET.get()) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0) {
            player.setItemInHand(player.getUsedItemHand(), new ItemStack(ModItems.WHITE_PAINT_BRUSH.get()));
            world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
            world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
