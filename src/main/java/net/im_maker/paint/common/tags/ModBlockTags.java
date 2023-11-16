package net.im_maker.paint.common.tags;


import net.im_maker.paint.Paint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> PAINTABLE_STRIPPED_LOG = tag("paintable_stripped_log");
    public static final TagKey<Block> PAINTABLE_STRIPPED_WOOD = tag("paintable_stripped_wood");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Paint.MOD_ID, name));
    }

}