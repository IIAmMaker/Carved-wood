package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CWTags {

    public static class Blocks {
        public static final TagKey<Block> CRAFTING_TABLES = tag("crafting_tables");
        public static final TagKey<Block> CRAFTERS = tag("crafters");
        public static final TagKey<Block> CHISELED_BOOKSHELVES = tag("chiseled_bookshelves");
        public static final TagKey<Block> LECTERNS = tag("lecterns");
        public static final TagKey<Block> BEEHIVES = tag("beehives");
        public static final TagKey<Block> LADDERS = tag("ladders");
        public static final TagKey<Block> COMPOSTER = tag("composter");
        public static final TagKey<Block> WOODEN_BARRELS = tag("wooden_barrels");
        public static final TagKey<Block> CHESTS = tag("chests");
        public static final TagKey<Block> TRAPPED_CHESTS = tag("trapped_chests");

        public static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }
        private static TagKey<Block> tag(String name) {
            return create(CarvedWood.newRL("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CRAFTING_TABLES = tag("crafting_tables");
        public static final TagKey<Item> CRAFTERS = tag("crafters");
        public static final TagKey<Item> CHISELED_BOOKSHELVES = tag("chiseled_bookshelves");
        public static final TagKey<Item> LECTERNS = tag("lecterns");
        public static final TagKey<Item> BEEHIVES = tag("beehives");
        public static final TagKey<Item> LADDERS = tag("ladders");
        public static final TagKey<Item> COMPOSTER = tag("composter");
        public static final TagKey<Item> WOODEN_BARRELS = tag("wooden_barrels");
        public static final TagKey<Item> CHESTS = tag("chests");
        public static final TagKey<Item> TRAPPED_CHESTS = tag("trapped_chests");
        public static final TagKey<Item> FLAG = tagCW("carved_wood_compatible");

        public static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
        private static TagKey<Item> tag(String name) {
            return create(CarvedWood.newRL("c", name));
        }
        private static TagKey<Item> tagCW(String name) {
            return create(CarvedWood.newRL(CarvedWood.MOD_ID, name));
        }
    }
}