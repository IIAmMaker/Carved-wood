package net.im_maker.carved_wood.common.block;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.redstone.link.controller.LecternControllerBlock;
import com.simibubi.create.content.schematics.requirement.ItemRequirement;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.function.Supplier;

public class CWLecternControllerBlock extends LecternControllerBlock {
    private final Supplier<Block> block;

    public CWLecternControllerBlock(BlockBehaviour.Properties properties, Supplier<Block> block) {
        super(properties);
        this.block = block;
    }

    public void replaceLectern(BlockState lecternState, Level world, BlockPos pos, ItemStack controller) {
        world.setBlockAndUpdate(pos, defaultBlockState().setValue(FACING, lecternState.getValue(FACING))
                .setValue(POWERED, lecternState.getValue(POWERED)));
        withBlockEntityDo(world, pos, be -> be.setController(controller));
    }


    public void replaceWithLectern(BlockState state, Level world, BlockPos pos) {
        AllSoundEvents.CONTROLLER_TAKE.playOnServer(world, pos);
        world.setBlockAndUpdate(pos, (block.get().defaultBlockState().setValue(FACING, state.getValue(FACING))).setValue(POWERED, state.getValue(POWERED)));
    }

    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return block.get().getCloneItemStack(state, target, level, pos, player);
    }

    public ItemRequirement getRequiredItems(BlockState state, BlockEntity be) {
        ArrayList<ItemStack> requiredItems = new ArrayList();
        requiredItems.add(new ItemStack(block.get()));
        requiredItems.add(new ItemStack(AllItems.LINKED_CONTROLLER.get()));
        return new ItemRequirement(ItemRequirement.ItemUseType.CONSUME, requiredItems);
    }
}
