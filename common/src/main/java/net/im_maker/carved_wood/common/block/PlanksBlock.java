package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.Block;

public class PlanksBlock extends Block {

    public PlanksBlock(Properties pProperties) {
        this(pProperties, true);
    }

    public PlanksBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 20, 5);
    }
}
