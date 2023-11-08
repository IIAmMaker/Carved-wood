package net.im_maker.wallpapers.common.tags;


import net.im_maker.paint.Paint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> WALLPAPER_BLOCKS = tag("wallpaper_blocks");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Paint.MOD_ID, name));
    }

}