package net.im_maker.paintable.common.item.paint_brushs;

import net.im_maker.paintable.common.item.ModItems;
import net.im_maker.paintable.common.tags.ModBlockTags;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;

public class DippedPaintBrushItem extends Item {
    private final Block paintedPlanks;
    private final Block paintedPlanksStairs;
    private final Block paintedPlanksSlab;
    private final Block paintedFence;
    private final Block paintedFenceGate;
    private final Block paintedButton;
    private final Block paintedPressurePlate;
    private final Block paintedLog;
    private final Block paintedWood;
    private final Block paintedBricks;
    private final Block paintedBrickStairs;
    private final Block paintedBrickSlab;
    private final Block paintedBrickWall;

    public DippedPaintBrushItem(Block planks, Block planksStairs , Block planksSlab , Block fence, Block fenceGate, Block button, Block pressurePlate, Block log, Block wood, Block bricks, Block brickStairs, Block brickSlab, Block brickWall, Properties properties) {
        super(properties);
        this.paintedPlanks = planks;
        this.paintedPlanksStairs = planksStairs;
        this.paintedPlanksSlab = planksSlab;
        this.paintedFence = fence;
        this.paintedFenceGate = fenceGate;
        this.paintedButton = button;
        this.paintedPressurePlate = pressurePlate;
        this.paintedLog = log;
        this.paintedWood = wood;
        this.paintedBricks = bricks;
        this.paintedBrickStairs = brickStairs;
        this.paintedBrickSlab = brickSlab;
        this.paintedBrickWall = brickWall;
    }

    private void paint (ItemStack itemStack, Player player, UseOnContext context, Level world, BlockPos blockPos) {
        if (itemStack.getDamageValue() != 15) {
            if (player != null) {
                itemStack.hurtAndBreak(1, player, (player1) -> {
                    player1.broadcastBreakEvent(context.getHand());
                });
            }
        } else {
            context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
            world.playSound((Player)null, blockPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        world.playSound((Player)null, blockPos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = world.getBlockState(blockPos);
        
        if (blockstate.is(BlockTags.PLANKS) && !blockstate.is(paintedPlanks)) {
            this.paint(itemstack, player, context, world, blockPos);
            world.setBlockAndUpdate(blockPos, paintedPlanks.defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_STAIRS) && !blockstate.is(paintedPlanksStairs)) {
            this.paint(itemstack, player, context, world, blockPos);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            Half half = blockstate.getValue(BlockStateProperties.HALF);
            StairsShape stairs_shape = blockstate.getValue(BlockStateProperties.STAIRS_SHAPE);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);

            world.setBlockAndUpdate(blockPos, paintedPlanksStairs.defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.HALF, half)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, stairs_shape)
                    .setValue(HorizontalDirectionalBlock.FACING, facing));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_SLABS) && !blockstate.is(paintedPlanksSlab)) {
            this.paint(itemstack, player, context, world, blockPos);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            SlabType slab_type = blockstate.getValue(BlockStateProperties.SLAB_TYPE);

            world.setBlockAndUpdate(blockPos, paintedPlanksSlab.defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.SLAB_TYPE, slab_type));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_FENCES) && !blockstate.is(paintedFence)) {
            this.paint(itemstack, player, context, world, blockPos);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            boolean north = blockstate.getValue(BlockStateProperties.NORTH);
            boolean east = blockstate.getValue(BlockStateProperties.EAST);
            boolean south = blockstate.getValue(BlockStateProperties.SOUTH);
            boolean west = blockstate.getValue(BlockStateProperties.WEST);

            world.setBlockAndUpdate(blockPos, paintedFence.defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.NORTH, north)
                    .setValue(BlockStateProperties.EAST, east)
                    .setValue(BlockStateProperties.SOUTH, south)
                    .setValue(BlockStateProperties.WEST, west));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.FENCE_GATES) && !blockstate.is(paintedFenceGate)) {
            this.paint(itemstack, player, context, world, blockPos);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);
            boolean in_wall = blockstate.getValue(BlockStateProperties.IN_WALL);
            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);
            boolean open = blockstate.getValue(BlockStateProperties.OPEN);

            world.setBlockAndUpdate(blockPos, paintedFenceGate.defaultBlockState()
                    .setValue(HorizontalDirectionalBlock.FACING, facing)
                    .setValue(BlockStateProperties.IN_WALL, in_wall)
                    .setValue(BlockStateProperties.POWERED, powered)
                    .setValue(BlockStateProperties.OPEN, open));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_BUTTONS) && !blockstate.is(paintedButton)) {
            this.paint(itemstack, player, context, world, blockPos);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);
            AttachFace face = blockstate.getValue(BlockStateProperties.ATTACH_FACE);
            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);

            world.setBlockAndUpdate(blockPos, paintedButton.defaultBlockState()
                    .setValue(HorizontalDirectionalBlock.FACING, facing)
                    .setValue(BlockStateProperties.ATTACH_FACE, face)
                    .setValue(BlockStateProperties.POWERED, powered));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(BlockTags.WOODEN_PRESSURE_PLATES) && !blockstate.is(paintedPressurePlate)) {
            this.paint(itemstack, player, context, world, blockPos);

            boolean powered = blockstate.getValue(BlockStateProperties.POWERED);
            world.setBlockAndUpdate(blockPos, paintedPressurePlate.defaultBlockState().setValue(BlockStateProperties.POWERED, powered));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlockTags.PAINTABLE_STRIPPED_LOGS) && !blockstate.is(paintedLog)) {
            this.paint(itemstack, player, context, world, blockPos);

            Direction.Axis axis = blockstate.getValue(BlockStateProperties.AXIS);
            world.setBlockAndUpdate(blockPos, paintedLog.defaultBlockState().setValue(BlockStateProperties.AXIS, axis));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlockTags.PAINTABLE_STRIPPED_WOODS) && !blockstate.is(paintedWood)) {
            this.paint(itemstack, player, context, world, blockPos);

            Direction.Axis axis = blockstate.getValue(BlockStateProperties.AXIS);
            world.setBlockAndUpdate(blockPos, paintedWood.defaultBlockState().setValue(BlockStateProperties.AXIS, axis));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlockTags.PAINTABLE_BRICKS) && !blockstate.is(paintedBricks)) {
            this.paint(itemstack, player, context, world, blockPos);
            world.setBlockAndUpdate(blockPos, paintedBricks.defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlockTags.PAINTABLE_BRICK_STAIRS) && !blockstate.is(paintedBrickStairs)) {
            this.paint(itemstack, player, context, world, blockPos);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            Half half = blockstate.getValue(BlockStateProperties.HALF);
            StairsShape stairs_shape = blockstate.getValue(BlockStateProperties.STAIRS_SHAPE);
            Direction facing = blockstate.getValue(HorizontalDirectionalBlock.FACING);

            world.setBlockAndUpdate(blockPos, paintedBrickStairs.defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.HALF, half)
                    .setValue(BlockStateProperties.STAIRS_SHAPE, stairs_shape)
                    .setValue(HorizontalDirectionalBlock.FACING, facing));

            return InteractionResult.sidedSuccess(world.isClientSide);
        } else if (blockstate.is(ModBlockTags.PAINTABLE_BRICK_SLABS) && !blockstate.is(paintedBrickSlab)) {
            if (itemstack.getDamageValue() != 15) {
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(context.getHand());
                    });
                }
            } else {
                context.getPlayer().setItemInHand(context.getHand(), new ItemStack(ModItems.PAINT_BRUSH.get()));
                world.playSound((Player) null, blockPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);
            SlabType slab_type = blockstate.getValue(BlockStateProperties.SLAB_TYPE);

            world.playSound((Player) null, blockPos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlockAndUpdate(blockPos, paintedBrickSlab.defaultBlockState()
                    .setValue(BlockStateProperties.WATERLOGGED, waterlogged)
                    .setValue(BlockStateProperties.SLAB_TYPE, slab_type));

            return InteractionResult.sidedSuccess(world.isClientSide);
        }else if (blockstate.is(ModBlockTags.PAINTABLE_BRICK_WALLS) && !blockstate.is(paintedBrickWall)) {
            this.paint(itemstack, player, context, world, blockPos);
            boolean up = blockstate.getValue(BlockStateProperties.UP);
            WallSide east = blockstate.getValue(BlockStateProperties.EAST_WALL);
            WallSide north = blockstate.getValue(BlockStateProperties.NORTH_WALL);
            WallSide south = blockstate.getValue(BlockStateProperties.SOUTH_WALL);
            WallSide west = blockstate.getValue(BlockStateProperties.WEST_WALL);
            boolean waterlogged = blockstate.getValue(BlockStateProperties.WATERLOGGED);

            world.setBlockAndUpdate(blockPos, paintedBrickWall.defaultBlockState()
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