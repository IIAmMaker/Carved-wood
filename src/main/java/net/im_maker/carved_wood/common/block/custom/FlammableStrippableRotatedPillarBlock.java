package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class FlammableStrippableRotatedPillarBlock extends RotatedPillarBlock {
    public FlammableStrippableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }


    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            ResourceLocation block = ForgeRegistries.BLOCKS.getKey(state.getBlock());
            String blockName = block.getPath();
            String blockNamespace = block.getNamespace();
            Level level = context.getLevel();
            BlockPos blockpos = context.getClickedPos();
            level.playSound(context.getPlayer(), blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return CarvedWood.getBlockFromString(blockNamespace, "stripped_" + blockName).withPropertiesOf(state);
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
