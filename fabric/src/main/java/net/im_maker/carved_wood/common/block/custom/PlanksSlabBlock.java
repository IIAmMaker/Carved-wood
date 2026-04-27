package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.SlabBlock;

public class PlanksSlabBlock extends SlabBlock {
    private final Boolean isFlammable;
    public PlanksSlabBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 5);
    }
    public PlanksSlabBlock(Properties pProperties) {
        this(pProperties, true);
    }
}
