package net.im_maker.carved_wood.common.block.custom;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.Block;

public class BookshelfBlock extends Block {
    public BookshelfBlock(Properties properties) {
        super(properties);
        FlammableBlockRegistry.getDefaultInstance().add(this, 20, 30);
    }
}
