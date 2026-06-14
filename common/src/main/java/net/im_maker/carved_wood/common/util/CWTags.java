package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CWTags {

    public static class Blocks {
        public static final TagKey<Block> CRAFTING_TABLES = tagC("crafting_tables");
        public static final TagKey<Block> CRAFTERS = tagC("crafters");
        public static final TagKey<Block> CHISELED_BOOKSHELVES = tagC("chiseled_bookshelves");
        public static final TagKey<Block> LECTERNS = tagC("lecterns");
        public static final TagKey<Block> BEEHIVES = tagV("beehives");
        public static final TagKey<Block> LADDERS = tagC("ladders");
        public static final TagKey<Block> COMPOSTER = tagC("composter");

        public static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }
        private static TagKey<Block> tag(String id, String name) {
            return create(CarvedWood.newRL(id, name));
        }
        private static TagKey<Block> tagC(String name) {
            return tag("c", name);
        }
        private static TagKey<Block> tagV(String name) {
            return tag("minecraft", name);
        }
    }

    public static class Items {
        public static final TagKey<Item> CRAFTING_TABLES = tagC("crafting_tables");
        public static final TagKey<Item> CRAFTERS = tagC("crafters");
        public static final TagKey<Item> CHISELED_BOOKSHELVES = tagC("chiseled_bookshelves");
        public static final TagKey<Item> LECTERNS = tagC("lecterns");
        public static final TagKey<Item> BEEHIVES = tagV("beehives");
        public static final TagKey<Item> LADDERS = tagC("ladders");
        public static final TagKey<Item> COMPOSTER = tagC("composter");
        public static final TagKey<Item> FLAG = tagCW("carved_wood_compatible");

        public static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
        private static TagKey<Item> tag(String id, String name) {
            return create(CarvedWood.newRL(id, name));
        }
        private static TagKey<Item> tagC(String name) {
            return tag("c", name);
        }
        private static TagKey<Item> tagCW(String name) {
            return tag(CarvedWood.MOD_ID, name);
        }
        private static TagKey<Item> tagV(String name) {
            return tag("minecraft", name);
        }
    }
}