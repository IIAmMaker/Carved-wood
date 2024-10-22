package net.im_maker.carved_wood.common.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CWTags {

    public static class Blocks {
        public static final TagKey<Block> CRAFTING_TABLES = tag("crafting_tables");
        public static final TagKey<Block> CHISELED_BOOKSHELVES = tag("chiseled_bookshelves");
        public static final TagKey<Block> LECTERNS = tag("lecterns");
        public static final TagKey<Block> BEEHIVES = tag("beehives");
        public static final TagKey<Block> LADDERS = tag("ladders");
        public static final TagKey<Block> COMPOSTER = tag("composter");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CRAFTING_TABLES = tag("crafting_tables");
        public static final TagKey<Item> CHISELED_BOOKSHELVES = tag("chiseled_bookshelves");
        public static final TagKey<Item> LECTERNS = tag("lecterns");
        public static final TagKey<Item> BEEHIVES = tag("beehives");
        public static final TagKey<Item> LADDERS = tag("ladders");
        public static final TagKey<Item> COMPOSTER = tag("composter");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}