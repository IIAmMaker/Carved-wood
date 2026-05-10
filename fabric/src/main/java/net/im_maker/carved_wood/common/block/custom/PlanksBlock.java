package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class PlanksBlock extends Block {
    public PlanksBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 5);
    }
    public PlanksBlock(Properties pProperties) {
        this(pProperties, true);
    }
}
