package net.im_maker.carved_wood.compatibility.create;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class CWLecternRegistry {

    private static final Map<Block, Block> LECTERN_TO_LECTERN_CONTROLLER = new HashMap<>();
    private static final Map<Block, Block> LECTERN_CONTROLLER_TO_LECTERN = new HashMap<>();

    public static void register(Block lectern, Block controller) {
        LECTERN_TO_LECTERN_CONTROLLER.put(lectern, controller);
        LECTERN_CONTROLLER_TO_LECTERN.put(controller, lectern);
    }

    public static boolean isCWLectern(Block block) {
        return LECTERN_TO_LECTERN_CONTROLLER.containsKey(block);
    }

    public static boolean isCWLecternController(Block block) {
        return LECTERN_CONTROLLER_TO_LECTERN.containsKey(block);
    }

    public static Block getLecternController(Block lectern) {
        return LECTERN_TO_LECTERN_CONTROLLER.get(lectern);
    }

    public static Block getLectern(Block controller) {
        return LECTERN_CONTROLLER_TO_LECTERN.get(controller);
    }
}