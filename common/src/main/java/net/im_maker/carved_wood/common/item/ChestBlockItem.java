package net.im_maker.carved_wood.common.item;

import net.im_maker.carved_wood.common.block.CWChestBlock;
import net.im_maker.carved_wood.common.block.CWTrappedChestBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ChestBlockItem extends BlockItem {
    private Block block;
    private final String chestName;
    public ChestBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
        this.block = pBlock;
        chestName = block instanceof CWTrappedChestBlock ? ((CWTrappedChestBlock) block).getChestName() : ((CWChestBlock) block).getChestName();
    }

    public String getChestName() {
        return chestName;
    }
}
