package net.im_maker.paintable.common.tags;


import net.im_maker.paintable.Paintable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> PAINTABLE_STRIPPED_LOGS = tag("paintable_stripped_log");
    public static final TagKey<Block> PAINTABLE_STRIPPED_WOODS = tag("paintable_stripped_wood");
    public static final TagKey<Block> PAINTABLE_BRICKS = tag("paintable_bricks");
    public static final TagKey<Block> PAINTABLE_BRICK_STAIRS = tag("paintable_brick_stairs");
    public static final TagKey<Block> PAINTABLE_BRICK_SLABS = tag("paintable_brick_slabs");
    public static final TagKey<Block> PAINTABLE_BRICK_WALLS = tag("paintable_brick_walls");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Paintable.MOD_ID, name));
    }
}