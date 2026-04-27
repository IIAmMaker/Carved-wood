package net.im_maker.carved_wood.common.item.custom;

import net.im_maker.carved_wood.common.util.CWFuelRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class FuelBlockItem extends BlockItem {
    private final int burnTime;

    public FuelBlockItem(Block pBlock, Properties pProperties, int burnTime) {
        super(pBlock, pProperties);
        this.burnTime = burnTime;

        // Register in the fuel registry
        CWFuelRegistry.registerFuel(this, burnTime);
    }
}
