package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlock extends RotatedPillarBlock {

    public LogBlock(Properties pProperties) {
        this(pProperties, true);
    }

    public LogBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 5, 5);
    }
}
