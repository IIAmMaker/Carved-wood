package net.im_maker.carved_wood.compatibility.create;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.im_maker.carved_wood.common.registers.CWBlocksNeoForge;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.minecraft.world.level.block.Block;

public class CWCreateCompat {

    public static void registerLecterns() {
        //CWLecternRegistry.register(CWBlocks.SPRUCE_LECTERN.get(), CWBlocksNeoForge.SPRUCE_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.BIRCH_LECTERN.get(), CWBlocksNeoForge.BIRCH_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.JUNGLE_LECTERN.get(), CWBlocksNeoForge.JUNGLE_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.ACACIA_LECTERN.get(), CWBlocksNeoForge.ACACIA_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.DARK_OAK_LECTERN.get(), CWBlocksNeoForge.DARK_OAK_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.MANGROVE_LECTERN.get(), CWBlocksNeoForge.MANGROVE_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.CHERRY_LECTERN.get(), CWBlocksNeoForge.CHERRY_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.PALE_OAK_LECTERN.get(), CWBlocksNeoForge.PALE_OAK_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.CRIMSON_LECTERN.get(), CWBlocksNeoForge.CRIMSON_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.WARPED_LECTERN.get(), CWBlocksNeoForge.WARPED_LECTERN_CONTROLLER.get());
        //CWLecternRegistry.register(CWBlocks.BAMBOO_LECTERN.get(), CWBlocksNeoForge.BAMBOO_LECTERN_CONTROLLER.get());
        for (Block controllerBlock : CarvedWood.getBlocks(CWLecternControllerBlock.class)) {
            if (controllerBlock instanceof CWLecternControllerBlock controller) {
                CWLecternRegistry.register(controller.getDefaultLectern(), controllerBlock);
            }
        }
    }
}