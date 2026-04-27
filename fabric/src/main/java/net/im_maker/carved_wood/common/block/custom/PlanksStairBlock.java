package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PlanksStairBlock extends StairBlock {
    private final Boolean isFlammable;
    public PlanksStairBlock(BlockState pBaseState, Properties pProperties, Boolean isFlammable) {
        super(pBaseState, pProperties);
        this.isFlammable = isFlammable;
        if (isFlammable) FlammableBlockRegistry.getDefaultInstance().add(this, 20, 5);
    }
    public PlanksStairBlock(BlockState pBaseState, Properties pProperties) {
        this(pBaseState, pProperties, true);
    }
}
