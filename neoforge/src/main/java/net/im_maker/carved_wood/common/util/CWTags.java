package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
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
        public static final TagKey<Block> LADDERS = tag("ladders");
        public static final TagKey<Block> COMPOSTERS = tag("composter");
        public static final TagKey<Block> CRAFTERS = tag("crafters");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CRAFTING_TABLES = tag("crafting_tables");
        public static final TagKey<Item> CHISELED_BOOKSHELVES = tag("chiseled_bookshelves");
        public static final TagKey<Item> LECTERNS = tag("lecterns");
        public static final TagKey<Item> BEEHIVES = tag("beehives");
        public static final TagKey<Item> LADDERS = tag("ladders");
        public static final TagKey<Item> COMPOSTERS = tag("composter");
        public static final TagKey<Item> CRAFTERS = tag("crafters");
        public static final TagKey<Item> FLAG = CWtag("carved_wood_compatible");

        private static TagKey<Item> CWtag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, name));
        }

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}