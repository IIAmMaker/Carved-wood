package net.im_maker.carved_wood.common.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.im_maker.carved_wood.common.FlammableBlockRegistryCommon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FlammableBlockRegistryFabric implements FlammableBlockRegistryCommon {
    @Override
    public void add(Block block, int catchChance, int burnChance) {
        FlammableBlockRegistry.getInstance(Blocks.FIRE).add(block, catchChance, burnChance);
    }
}