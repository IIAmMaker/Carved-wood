package net.im_maker.carved_wood.common.util;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ConventionalTags {

    public static class Blocks {
        public static final TagKey<Block> BARRELS = register("barrels");
        public static final TagKey<Block> WOODEN_BARRELS = register("barrels/wooden");
        public static final TagKey<Block> BOOKSHELVES = register("bookshelves");
        public static final TagKey<Block> CHESTS = register("chests");
        public static final TagKey<Block> WOODEN_CHESTS = register("chests/wooden");
        public static final TagKey<Block> TRAPPED_CHESTS = register("chests/trapped");
        public static final TagKey<Block> VILLAGER_JOB_SITES = register("villager_job_sites");
        public static final TagKey<Block> STRIPPED_LOGS = register("stripped_logs");
        public static final TagKey<Block> STRIPPED_WOODS = register("stripped_woods");
        public static final TagKey<Block> PLAYER_WORKSTATIONS_CRAFTING_TABLES = register("player_workstations/crafting_tables");

        public static final TagKey<Block> VILLAGER_FARMLANDS = registerNeo("villager_farmlands");

        public static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registries.BLOCK, name);
        }
        private static TagKey<Block> register(String name) {
            return create(CarvedWood.newRL("c", name));
        }
        private static TagKey<Block> registerNeo(String name) {
            return create(CarvedWood.newRL("neoforge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BARRELS = register("barrels");
        public static final TagKey<Item> WOODEN_BARRELS = register("barrels/wooden");
        public static final TagKey<Item> BOOKSHELVES = register("bookshelves");
        public static final TagKey<Item> CHESTS = register("chests");
        public static final TagKey<Item> WOODEN_CHESTS = register("chests/wooden");
        public static final TagKey<Item> TRAPPED_CHESTS = register("chests/trapped");
        public static final TagKey<Item> VILLAGER_JOB_SITES = register("villager_job_sites");
        public static final TagKey<Item> STRIPPED_LOGS = register("stripped_logs");
        public static final TagKey<Item> STRIPPED_WOODS = register("stripped_woods");
        public static final TagKey<Item> PLAYER_WORKSTATIONS_CRAFTING_TABLES = register("player_workstations/crafting_tables");

        public static final TagKey<Item> VILLAGER_FARMLANDS = registerNeo("villager_farmlands");

        public static TagKey<Item> create(ResourceLocation name) {
            return TagKey.create(Registries.ITEM, name);
        }
        private static TagKey<Item> register(String name) {
            return create(CarvedWood.newRL("c", name));
        }
        private static TagKey<Item> registerNeo(String name) {
            return create(CarvedWood.newRL("neoforge", name));
        }
    }
}