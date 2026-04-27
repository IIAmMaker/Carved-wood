package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlock extends RotatedPillarBlock {
    private final Boolean isFlammable;
    public LogBlock(Properties pProperties, Boolean isFlammable) {
        super(pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 5, 5);
    }
    public LogBlock(Properties pProperties) {
        this(pProperties, true);
    }

}
