package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CWBlocksNeoForge {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CarvedWood.MOD_ID);
    
    public static final DeferredBlock<Block> SPRUCE_LECTERN_CONTROLLER = BLOCKS.register("spruce_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.SPRUCE);
    public static final DeferredBlock<Block> BIRCH_LECTERN_CONTROLLER = BLOCKS.register("birch_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.BIRCH);
    public static final DeferredBlock<Block> JUNGLE_LECTERN_CONTROLLER = BLOCKS.register("jungle_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.JUNGLE);
    public static final DeferredBlock<Block> ACACIA_LECTERN_CONTROLLER = BLOCKS.register("acacia_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.ACACIA);
    public static final DeferredBlock<Block> DARK_OAK_LECTERN_CONTROLLER = BLOCKS.register("dark_oak_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.DARK_OAK);
    public static final DeferredBlock<Block> MANGROVE_LECTERN_CONTROLLER = BLOCKS.register("mangrove_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.MANGROVE);
    public static final DeferredBlock<Block> CHERRY_LECTERN_CONTROLLER = BLOCKS.register("cherry_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.CHERRY);
    public static final DeferredBlock<Block> PALE_OAK_LECTERN_CONTROLLER = BLOCKS.register("pale_oak_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.PALE_OAK);
    public static final DeferredBlock<Block> CRIMSON_LECTERN_CONTROLLER = BLOCKS.register("crimson_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.CRIMSON);
    public static final DeferredBlock<Block> WARPED_LECTERN_CONTROLLER = BLOCKS.register("warped_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.WARPED);
    public static final DeferredBlock<Block> BAMBOO_LECTERN_CONTROLLER = BLOCKS.register("bamboo_lectern_controller", !ModList.get().isLoaded("create") ? () -> new Block(BlockBehaviour.Properties.of()) : () -> CWCreateBlocks.BAMBOO);

    //public static final List<DeferredBlock<?>> BIRCH_WOOD_SET = registerWoodSet(
    //        "ok",
    //        "your_mod_id",
    //        true,
    //        true,
    //        false,
    //        MapColor.SAND,
    //        MapColor.SAND,
    //        MapColor.SAND
    //);








    //private static <T extends Block> DeferredBlock<T> registryBlock(String name, Supplier<T> block) {
    //    DeferredBlock<T> toReturn = BLOCKS.register(name, block);
    //    registerBlockItem(name, toReturn);
    //    return toReturn;
    //};

    //private static <T extends Block> DeferredBlock<T>registryWoodenFuelBlock(String name, Supplier<T> block) {
    //    return registryWoodenFuelBlock(name, block, false);
    //};
//
    //private static <T extends Block> DeferredBlock<T>registryWoodenFuelBlock(String name, Supplier<T> block, Boolean isSlab) {
    //    DeferredBlock<T> toReturn = BLOCKS.register(name, block);
    //    registryFuelBlockItem(name, toReturn, 300 / (isSlab ? 2 : 1));
    //    return toReturn;
    //};

    //private static <T extends Block> DeferredBlock<T>registryChestBlock(String name, Supplier<T> block, Boolean isTrapped, Boolean isFuel) {
    //    int burnTime = isFuel ? 300 : 0;
    //    DeferredBlock<T> toReturn = BLOCKS.register(name, block);
    //    registerChestBlockItem(name, toReturn, isTrapped , burnTime);
    //    return toReturn;
    //};
//
    //private static <T extends Block> void registerChestBlockItem(String name, DeferredBlock<T> block, Boolean isTrapped, int burnTime){
    //    CWItems.ITEMS.register(name, () -> new ChestBlockItem(block.get(), new Item.Properties(), isTrapped, burnTime));
    //}

    //private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
    //    CWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    //}

    //private static <T extends Block> void registryFuelBlockItem(String name, DeferredBlock<T> block, int burnTime){
    //    CWItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), burnTime));
    //}

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void  registerModBlocks() {
        CarvedWood.LOGGER.info("Registering Mod Blocks for " + CarvedWood.MOD_ID);
    }

}