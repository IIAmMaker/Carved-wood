package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PlanksStairBlock extends StairBlock {

    public PlanksStairBlock(BlockState pBaseState, Properties pProperties, Boolean isFlammable) {
        super(pBaseState, pProperties);
        if (isFlammable) PlatHelper.addFlammableBlock(this, 20, 5);
    }

    public PlanksStairBlock(BlockState pBaseState, Properties pProperties) {
        this(pBaseState, pProperties, true);
    }
}
