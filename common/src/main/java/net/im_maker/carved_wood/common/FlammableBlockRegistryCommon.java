package net.im_maker.carved_wood.common;

import net.minecraft.world.level.block.Block;
import java.util.ServiceLoader;

public interface FlammableBlockRegistryCommon {
    void add(Block block, int catchChance, int burnChance);

    // Add a setter for manual override
    static void setInstance(FlammableBlockRegistryCommon instance) {
        Holder.INSTANCE = instance;
    }

    static FlammableBlockRegistryCommon getDefaultInstance() {
        return Holder.INSTANCE;
    }

    class Holder {
        static FlammableBlockRegistryCommon INSTANCE;
    }
}