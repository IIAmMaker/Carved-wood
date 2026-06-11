package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.SlabBlock;

public class PlanksSlabBlock extends SlabBlock {

    public PlanksSlabBlock(Properties pProperties) {
        this(pProperties, true);
    }

    public PlanksSlabBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 20, 5);
    }
}
