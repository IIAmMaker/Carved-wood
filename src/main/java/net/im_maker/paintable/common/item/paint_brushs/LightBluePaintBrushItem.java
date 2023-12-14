package net.im_maker.paintable.common.item.paint_brushs;

import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;

public class LightBluePaintBrushItem extends Item {
    public LightBluePaintBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = world.getBlockState(blockpos);

        if (blockstate.is(BlockTags.PLANKS) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_PLANKS.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_STAIRS) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_PLANKS_STAIRS.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            Half half = blockstate.getValue(BlockStateProperties.HALF);
            StairsShape stairs_shape = blockstate.getValue(BlockStateProperties.STAIRS_SHAPE);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_PLANKS_STAIRS.get().defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.HALF, half)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, stairs_shape)
                    .setValue(HorizontalDirectionalBlock.FACING, facing));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_SLABS) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_PLANKS_SLAB.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            SlabType slab_type = blockstate.getValue(BlockStateProperties.SLAB_TYPE);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_PLANKS_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.SLAB_TYPE, slab_type));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_FENCES) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_FENCE.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            boolean north = blockstate.getValue(BlockStateProperties.NORTH);
            boolean east = blockstate.getValue(BlockStateProperties.EAST);
            boolean south = blockstate.getValue(BlockStateProperties.SOUTH);
            boolean west = blockstate.getValue(BlockStateProperties.WEST);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_FENCE.get().defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.NORTH, north)
                    .setValue(BlockStateProperties.EAST, east)
                    .setValue(BlockStateProperties.SOUTH, south)
                    .setValue(BlockStateProperties.WEST, west));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.FENCE_GATES) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_FENCE_GATE.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);
            boolean in_wall = blockstate.getValue(BlockStateProperties.IN_WALL);
            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);
            boolean open = blockstate.getValue(BlockStateProperties.OPEN);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_FENCE_GATE.get().defaultBlockState()
                    .setValue(HorizontalDirectionalBlock.FACING, facing)
                    .setValue(BlockStateProperties.IN_WALL, in_wall)
                    .setValue(BlockStateProperties.POWERED, powered)
                    .setValue(BlockStateProperties.OPEN, open));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_BUTTONS) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_BUTTON.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);
            AttachFace face = blockstate.getValue(BlockStateProperties.ATTACH_FACE);
            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_BUTTON.get().defaultBlockState()
                    .setValue(HorizontalDirectionalBlock.FACING, facing)
                    .setValue(BlockStateProperties.ATTACH_FACE, face)
                    .setValue(BlockStateProperties.POWERED, powered));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_PRESSURE_PLATES) && !blockstate.is(ModBlocks.LIGHT_BLUE_PAINTED_PRESSURE_PLATE.get())) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_PRESSURE_PLATE.get().defaultBlockState()
                    .setValue(BlockStateProperties.POWERED, powered));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(Blocks.BRICKS)) {

            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_BRICKS.get().defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(Blocks.BRICK_STAIRS)) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            Half half = blockstate.getValue(BlockStateProperties.HALF);
            StairsShape stairs_shape = blockstate.getValue(BlockStateProperties.STAIRS_SHAPE);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_BRICK_STAIRS.get().defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.HALF, half)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, stairs_shape)
                    .setValue(HorizontalDirectionalBlock.FACING, facing));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(Blocks.BRICK_SLAB)) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player) null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            SlabType slab_type = blockstate.getValue(BlockStateProperties.SLAB_TYPE);

            world.playSound((Player) null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_BRICK_SLAB.get().defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.SLAB_TYPE, slab_type));

            return InteractionResult.sidedSuccess(world.isClientSide);
        }else if (blockstate.is(Blocks.BRICK_WALL)) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player)null, blockpos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean up = blockstate.getValue(BlockStateProperties.UP);
            WallSide east = blockstate.getValue(BlockStateProperties.EAST_WALL);
            WallSide north = blockstate.getValue(BlockStateProperties.NORTH_WALL);
            WallSide south = blockstate.getValue(BlockStateProperties.SOUTH_WALL);
            WallSide west = blockstate.getValue(BlockStateProperties.WEST_WALL);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);

            world.playSound((Player)null, blockpos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockpos, ModBlocks.LIGHT_BLUE_PAINTED_BRICK_WALL.get().defaultBlockState()
                    .setValue(BlockStateProperties.UP, up)
                    .setValue(BlockStateProperties.EAST_WALL, east)
                    .setValue(BlockStateProperties.NORTH_WALL, north)
                    .setValue(BlockStateProperties.SOUTH_WALL, south)
                    .setValue(BlockStateProperties.WEST_WALL, west)
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}