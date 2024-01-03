package net.im_maker.paintable.common.item.paint_brushs;

import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.block.block_values.ModBlockStateProperties;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PaintBrushItem extends Item {
    public PaintBrushItem(Properties properties) {
        super(properties);
    }

    private void paintBrushDip (Level world,BlockPos blockpos,BlockState blockstate, UseOnContext context, Item item) {
        context.getPlayer().setItemInHand(context.getHand(), new ItemStack(item));
        world.playSound((Player)null, blockpos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
        Integer a = blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT);
        world.setBlockAndUpdate(blockpos, blockstate.setValue(ModBlockStateProperties.LEVEL_PAINT, a-1));
    }

    private boolean canDip (BlockState blockstate, Block block) {
        return blockstate.is(block) && blockstate.getValue(ModBlockStateProperties.LEVEL_PAINT) != 0;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (this.canDip(blockstate, ModBlocks.RED_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.RED_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.ORANGE_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.ORANGE_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.YELLOW_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.YELLOW_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.LIME_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.LIME_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.GREEN_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.GREEN_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.CYAN_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.CYAN_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.LIGHT_BLUE_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.LIGHT_BLUE_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.BLUE_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.BLUE_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.PURPLE_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.PURPLE_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.MAGENTA_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.MAGENTA_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.PINK_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.PINK_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.BROWN_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.BROWN_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.BLACK_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.BLACK_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.GRAY_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.GRAY_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.LIGHT_GRAY_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.LIGHT_GRAY_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (this.canDip(blockstate, ModBlocks.WHITE_PAINT_BUCKET.get())) {
            this.paintBrushDip(world, blockpos, blockstate, context, ModItems.WHITE_PAINT_BRUSH.get());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}