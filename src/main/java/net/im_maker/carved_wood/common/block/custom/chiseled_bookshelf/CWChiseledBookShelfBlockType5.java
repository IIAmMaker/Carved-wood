package net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf;

import net.im_maker.carved_wood.common.block.entity.custom.CWChiseledBookShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class CWChiseledBookShelfBlockType5 extends ChiseledBookShelfBlock {
    public CWChiseledBookShelfBlockType5(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof ChiseledBookShelfBlockEntity chiseledbookshelfblockentity) {
            Optional<Vec2> optional = getRelativeHitCoordinatesForBlockFace(pHit, pState.getValue(HorizontalDirectionalBlock.FACING));
            if (optional.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                int i = getHitSlot(optional.get());
                if (pState.getValue(SLOT_OCCUPIED_PROPERTIES.get(i))) {
                    removeBook(pLevel, pPos, pPlayer, chiseledbookshelfblockentity, i);
                    return InteractionResult.sidedSuccess(pLevel.isClientSide);
                } else {
                    ItemStack itemstack = pPlayer.getItemInHand(pHand);
                    if (itemstack.is(ItemTags.BOOKSHELF_BOOKS)) {
                        addBook(pLevel, pPos, pPlayer, chiseledbookshelfblockentity, itemstack, i);
                        return InteractionResult.sidedSuccess(pLevel.isClientSide);
                    } else {
                        return InteractionResult.CONSUME;
                    }
                }
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private static Optional<Vec2> getRelativeHitCoordinatesForBlockFace(BlockHitResult pHitResult, Direction pFace) {
        Direction direction = pHitResult.getDirection();
        if (pFace != direction) {
            return Optional.empty();
        } else {
            BlockPos blockpos = pHitResult.getBlockPos().relative(direction);
            Vec3 vec3 = pHitResult.getLocation().subtract((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
            double d0 = vec3.x();
            double d1 = vec3.y();
            double d2 = vec3.z();
            Optional optional;
            switch (direction) {
                case NORTH:
                    optional = Optional.of(new Vec2((float)(1.0D - d0), (float)d1));
                    break;
                case SOUTH:
                    optional = Optional.of(new Vec2((float)d0, (float)d1));
                    break;
                case WEST:
                    optional = Optional.of(new Vec2((float)d2, (float)d1));
                    break;
                case EAST:
                    optional = Optional.of(new Vec2((float)(1.0D - d2), (float)d1));
                    break;
                case DOWN:
                case UP:
                    optional = Optional.empty();
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return optional;
        }
    }

    private static void removeBook(Level pLevel, BlockPos pPos, Player pPlayer, ChiseledBookShelfBlockEntity pBlockEntity, int pSlot) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pBlockEntity.removeItem(pSlot, 1);
            SoundEvent soundevent = itemstack.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_PICKUP_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_PICKUP;
            pLevel.playSound((Player)null, pPos, soundevent, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!pPlayer.getInventory().add(itemstack)) {
                pPlayer.drop(itemstack, false);
            }

            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    private static void addBook(Level pLevel, BlockPos pPos, Player pPlayer, ChiseledBookShelfBlockEntity pBlockEntity, ItemStack pBookStack, int pSlot) {
        if (!pLevel.isClientSide) {
            pPlayer.awardStat(Stats.ITEM_USED.get(pBookStack.getItem()));
            SoundEvent soundevent = pBookStack.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_INSERT;
            pBlockEntity.setItem(pSlot, pBookStack.split(1));
            pLevel.playSound((Player)null, pPos, soundevent, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (pPlayer.isCreative()) {
                pBookStack.grow(1);
            }

            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    private static int getHitSlot(Vec2 pHitPos) {
        int i = pHitPos.x >= getBlockPixel(8f) ? 1 : 0;
        int j = getSection(pHitPos.y, i);
        return j + i;
    }

    private static int getSection(float pY, float pX) {
        if (pX == 0 && pY < getBlockPixel(9f)) {//3
            return 3;
        } else if (pX == 0 && pY < getBlockPixel(13f)) {//1
            return 1;
        } else if (pX == 1 && pY < getBlockPixel(5f)) {//5
            return 4;
        } else if (pX == 1 && pY < getBlockPixel(9f)) {//4
            return 3;
        }else {
            return pX == 1 ? 1 : 0;//2-0
        }

    }

    private static Float getBlockPixel(Float f) {
        return f / 16 ;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CWChiseledBookShelfBlockEntity(blockPos, blockState);
    }
}
