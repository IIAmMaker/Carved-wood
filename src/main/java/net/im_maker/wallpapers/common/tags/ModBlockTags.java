package net.im_maker.wallpapers.common.tags;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.im_maker.wallpapers.Wallpapers;

public class ModBlockTags {
    public static final TagKey<Block> WALLPAPER_BLOCKS = tag("wallpaper_blocks");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Wallpapers.MOD_ID, name));
    }

}