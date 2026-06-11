package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.Block;

public class BookshelfBlock extends Block {

    public BookshelfBlock(Properties properties) {
        super(properties);
        PlatHelper.addFlammableBlock(this, 20, 30);
    }
}
