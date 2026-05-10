package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.common.FlammableBlockRegistryCommon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;

public class FlammableBlockRegistryForge implements FlammableBlockRegistryCommon {
    @Override
    public void add(Block block, int catchChance, int burnChance) {
        // Forge-specific code
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(block, catchChance, burnChance);
    }
}