package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.mehvahdjukaar.amendments.configs.CommonConfigs;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WritableBookItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CWLecternBlock extends LecternBlock {
    private final Boolean isFlammable;

    public CWLecternBlock(Properties properties, Boolean isFlammable) {
        super(properties);
        this.isFlammable = isFlammable;
        if (isFlammable) {
            FlammableBlockRegistry.getDefaultInstance().add(this, 20, 30);
        }
    }

    public CWLecternBlock(Properties properties) {
        this(properties, true);
    }

    //@Override
    //protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos,
    //                                           Player player, BlockHitResult blockHitResult) {
    //    if (blockState.getValue(HAS_BOOK)) {
    //        if (!level.isClientSide) {
    //            this.openScreen(level, blockPos, player);
    //        }
    //        return InteractionResult.sidedSuccess(level.isClientSide);
    //    }
    //    return InteractionResult.CONSUME;
    //}
//
    //private void openScreen(Level level, BlockPos blockPos, Player player) {
    //    BlockEntity blockEntity = level.getBlockEntity(blockPos);
//
    //    if (blockEntity instanceof CWLecternBlockEntity be) { // Use your specific block entity type
    //        ItemStack book = be.getBook();
//
    //        // Check for Amendments mod compatibility
    //        if (FabricLoader.getInstance().isModLoaded("amendments") &&
    //                book.getItem() instanceof WritableBookItem &&
    //                CommonConfigs.LECTERN_STUFF.get() &&
    //                !player.isSpectator()) {
//
    //            // Use Amendments' custom menu opening
    //            if (player instanceof ServerPlayer serverPlayer) {
    //                // Make sure to pass the block position
    //                PlatHelper.openCustomMenu(serverPlayer, be, blockPos);
    //                player.awardStat(Stats.INTERACT_WITH_LECTERN);
    //            }
    //        } else {
    //            // Fall back to vanilla behavior
    //            if (player instanceof ServerPlayer serverPlayer) {
    //                serverPlayer.openMenu(be);
    //                player.awardStat(Stats.INTERACT_WITH_LECTERN);
    //            }
    //        }
    //    }
    //}

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWLecternBlockEntity(blockPos, blockState);
    }
}