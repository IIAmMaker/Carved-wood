package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class PlanksBlock extends Block {
    private final Boolean isFlammable;
    public PlanksBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 5);
    }
    public PlanksBlock(Properties pProperties) {
        this(pProperties, true);
    }
}
