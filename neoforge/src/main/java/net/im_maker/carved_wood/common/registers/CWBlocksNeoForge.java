package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class CWBlocksNeoForge {

    public static final Supplier<Block> SPRUCE_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("spruce_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.SPRUCE);
    public static final Supplier<Block> BIRCH_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("birch_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.BIRCH);
    public static final Supplier<Block> JUNGLE_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("jungle_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.JUNGLE);
    public static final Supplier<Block> ACACIA_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("acacia_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.ACACIA);
    public static final Supplier<Block> DARK_OAK_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("dark_oak_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.DARK_OAK);
    public static final Supplier<Block> MANGROVE_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("mangrove_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.MANGROVE);
    public static final Supplier<Block> CHERRY_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("cherry_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.CHERRY);
    public static final Supplier<Block> PALE_OAK_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("pale_oak_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.PALE_OAK);
    public static final Supplier<Block> CRIMSON_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("crimson_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.CRIMSON);
    public static final Supplier<Block> WARPED_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("warped_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.WARPED);
    public static final Supplier<Block> BAMBOO_LECTERN_CONTROLLER = CWBlocks.registerWoodenFuelBlock("bamboo_lectern_controller", !PlatHelper.isModLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of().noLootTable()) : () -> CWCreateBlocks.BAMBOO);

    public static void register() {
        CarvedWood.LOGGER.info("Registering Mod Blocks for " + CarvedWood.MOD_ID);
    }
}