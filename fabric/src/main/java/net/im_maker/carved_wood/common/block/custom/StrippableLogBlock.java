package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class StrippableLogBlock extends RotatedPillarBlock {
    private final Boolean isFlammable;
    public StrippableLogBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 5, 5);
    }
    public StrippableLogBlock(Properties pProperties) {
        this(pProperties, true);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!(player.getItemInHand(interactionHand).getItem() instanceof AxeItem)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        Block block = blockState.getBlock();
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);

        String namespace = blockId.getNamespace();
        String path = blockId.getPath(); // crwo/would/azalea_log_bundle

        String[] parts = path.split("/");
        parts[parts.length - 1] = "stripped_" + parts[parts.length - 1];
        String strippedPath = String.join("/", parts);

        Block strippedBlock = BuiltInRegistries.BLOCK.get(
                ResourceLocation.fromNamespaceAndPath(namespace, strippedPath)
        );

        level.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
        player.getItemInHand(interactionHand).hurtAndBreak(1, player, player.getSlotForHand(interactionHand));
        level.setBlockAndUpdate(blockPos, strippedBlock.withPropertiesOf(blockState));

        return ItemInteractionResult.SUCCESS;
    }
}