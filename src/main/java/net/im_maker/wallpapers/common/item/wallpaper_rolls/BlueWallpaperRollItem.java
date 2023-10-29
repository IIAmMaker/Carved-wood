package net.im_maker.wallpapers.common.item.wallpaper_rolls;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockState;
import net.im_maker.wallpapers.common.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class BlueWallpaperRollItem extends Item {
    public BlueWallpaperRollItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockState blockstate = level.getBlockState(blockpos);
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
        }
        if (context.getClickedFace() != Direction.DOWN && blockstate.is(BlockTags.PLANKS)) {
            level.playSound((Player)null, blockpos, SoundEvents.BOOK_PAGE_TURN, SoundSource.BLOCKS, 1.0F, 1.0F);
            itemstack.shrink(1);
            level.setBlockAndUpdate(blockpos, ModBlocks.BLUE_WALLPAPER_BLOCK.get().defaultBlockState());
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltips, TooltipFlag tooltipFlag) {
        if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), Minecraft.getInstance().options.keyShift.getKey().getValue())) {
            tooltips.add(Component.translatable("tooltip.wallpapers.wallpapering_line0"));
            tooltips.add(Component.translatable("tooltip.wallpapers.wallpapering_line1"));
        } else {
            tooltips.add(Component.translatable("tooltip.wallpapers.shift"));
        }
        super.appendHoverText(itemStack, level, tooltips, tooltipFlag);
    }
}