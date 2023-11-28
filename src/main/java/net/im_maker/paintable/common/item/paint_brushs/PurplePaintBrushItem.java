package net.im_maker.paintable.common.item.paint_brushs;

import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;

public class PurplePaintBrushItem extends Item {
    public PurplePaintBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.is(BlockTags.PLANKS) && !blockstate.is(ModBlocks.PURPLE_PAINTED_PLANKS.get())) {
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
            world.setBlockAndUpdate(blockpos, ModBlocks.PURPLE_PAINTED_PLANKS.get().defaultBlockState());
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
            world.setBlockAndUpdate(blockpos, ModBlocks.PURPLE_PAINTED_BRICKS.get().defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
