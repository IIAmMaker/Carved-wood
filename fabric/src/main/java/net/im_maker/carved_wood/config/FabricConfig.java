package net.im_maker.carved_wood.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.im_maker.carved_wood.CarvedWood;

import java.io.*;
import java.nio.file.Path;

public class FabricConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("carved_wood-common.json");

    public static void load() {
        if (CONFIG_PATH.toFile().exists()) {
            try (Reader reader = new FileReader(CONFIG_PATH.toFile())) {
                ConfigData data = GSON.fromJson(reader, ConfigData.class);
                applyConfig(data);
            } catch (IOException e) {
                CarvedWood.LOGGER.error("Failed to load config", e);
            }
        }
        save(); // Save defaults if file doesn't exist
    }

    public static void save() {
        ConfigData data = ConfigData.fromCurrent();
        try (Writer writer = new FileWriter(CONFIG_PATH.toFile())) {
            GSON.toJson(data, writer);
        } catch (IOException e) {
            CarvedWood.LOGGER.error("Failed to save config", e);
        }
    }

    private static void applyConfig(ConfigData data) {
        CarvedWoodConfig.set("wooden_barrels", data.wooden_barrels);
        CarvedWoodConfig.set("wooden_chests", data.wooden_chests);
        CarvedWoodConfig.set("wooden_crafting_tables", data.wooden_crafting_tables);
        CarvedWoodConfig.set("wooden_ladders", data.wooden_ladders);
        CarvedWoodConfig.set("wooden_bookshelves", data.wooden_bookshelves);
        CarvedWoodConfig.set("wooden_beehives", data.wooden_beehives);
        CarvedWoodConfig.set("wooden_campfires", data.wooden_campfires);
        CarvedWoodConfig.set("log_bundles", data.log_bundles);
        CarvedWoodConfig.set("planks_sets", data.planks_sets);

        CarvedWoodConfig.set("mixed_barrel_crafting", data.mixed_barrel_crafting);
        CarvedWoodConfig.set("mixed_chest_crafting", data.mixed_chest_crafting);
        CarvedWoodConfig.set("mixed_crafting_table_crafting", data.mixed_crafting_table_crafting);
        CarvedWoodConfig.set("mixed_ladder_crafting", data.mixed_ladder_crafting);
        CarvedWoodConfig.set("mixed_bookshelf_crafting", data.mixed_bookshelf_crafting);
        CarvedWoodConfig.set("mixed_chiseled_bookshelf_crafting", data.mixed_chiseled_bookshelf_crafting);
        CarvedWoodConfig.set("mixed_lectern_crafting", data.mixed_lectern_crafting);
        CarvedWoodConfig.set("mixed_beehive_crafting", data.mixed_beehive_crafting);
        CarvedWoodConfig.set("mixed_campfire_crafting", data.mixed_campfire_crafting);
    }

    private static class ConfigData {
        boolean wooden_barrels = true;
        boolean wooden_chests = true;
        boolean wooden_crafting_tables = true;
        boolean wooden_ladders = true;
        boolean wooden_bookshelves = true;
        boolean wooden_beehives = true;
        boolean wooden_campfires = true;
        boolean log_bundles = true;
        boolean planks_sets = true;

        boolean mixed_barrel_crafting = false;
        boolean mixed_chest_crafting = true;
        boolean mixed_crafting_table_crafting = true;
        boolean mixed_ladder_crafting = false;
        boolean mixed_bookshelf_crafting = false;
        boolean mixed_chiseled_bookshelf_crafting = false;
        boolean mixed_lectern_crafting = false;
        boolean mixed_beehive_crafting = false;
        boolean mixed_campfire_crafting = false;

        static ConfigData fromCurrent() {
            ConfigData data = new ConfigData();
            data.wooden_barrels = CarvedWoodConfig.isEnabled("wooden_barrels");
            data.wooden_chests = CarvedWoodConfig.isEnabled("wooden_chests");
            data.wooden_crafting_tables = CarvedWoodConfig.isEnabled("wooden_crafting_tables");
            data.wooden_ladders = CarvedWoodConfig.isEnabled("wooden_ladders");
            data.wooden_bookshelves = CarvedWoodConfig.isEnabled("wooden_bookshelves");
            data.wooden_beehives = CarvedWoodConfig.isEnabled("wooden_beehives");
            data.wooden_campfires = CarvedWoodConfig.isEnabled("wooden_campfires");
            data.log_bundles = CarvedWoodConfig.isEnabled("log_bundles");
            data.planks_sets = CarvedWoodConfig.isEnabled("planks_sets");

            data.mixed_barrel_crafting = CarvedWoodConfig.isEnabled("mixed_barrel_crafting");
            data.mixed_chest_crafting = CarvedWoodConfig.isEnabled("mixed_chest_crafting");
            data.mixed_crafting_table_crafting = CarvedWoodConfig.isEnabled("mixed_crafting_table_crafting");
            data.mixed_ladder_crafting = CarvedWoodConfig.isEnabled("mixed_ladder_crafting");
            data.mixed_bookshelf_crafting = CarvedWoodConfig.isEnabled("mixed_bookshelf_crafting");
            data.mixed_chiseled_bookshelf_crafting = CarvedWoodConfig.isEnabled("mixed_chiseled_bookshelf_crafting");
            data.mixed_lectern_crafting = CarvedWoodConfig.isEnabled("mixed_lectern_crafting");
            data.mixed_beehive_crafting = CarvedWoodConfig.isEnabled("mixed_beehive_crafting");
            data.mixed_campfire_crafting = CarvedWoodConfig.isEnabled("mixed_campfire_crafting");
            return data;
        }
    }
}