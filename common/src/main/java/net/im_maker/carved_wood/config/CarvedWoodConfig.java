package net.im_maker.carved_wood.config;

import java.util.HashMap;
import java.util.Map;

public class CarvedWoodConfig {

    private static final Map<String, Boolean> CONFIG = new HashMap<>();

    // Define all config keys with defaults
    static {
        // Block type toggles
        CONFIG.put("wooden_barrels", true);
        CONFIG.put("wooden_chests", true);
        CONFIG.put("wooden_crafting_tables", true);
        CONFIG.put("wooden_ladders", true);
        CONFIG.put("wooden_bookshelves", true);
        CONFIG.put("wooden_beehives", true);
        CONFIG.put("wooden_campfires", true);
        CONFIG.put("planks_sets", true);
        CONFIG.put("log_bundles", true);

        CONFIG.put("mixed_barrel_crafting", false);
        CONFIG.put("mixed_chest_crafting", true);
        CONFIG.put("mixed_crafting_table_crafting", true);
        CONFIG.put("mixed_ladder_crafting", false);
        CONFIG.put("mixed_bookshelf_crafting", false);
        CONFIG.put("mixed_chiseled_bookshelf_crafting", false);
        CONFIG.put("mixed_lectern_crafting", false);
        CONFIG.put("mixed_beehive_crafting", false);
        CONFIG.put("mixed_campfire_crafting", false);
    }

    public static boolean isEnabled(String key) {
        return CONFIG.getOrDefault(key, true);
    }

    public static void set(String key, boolean value) {
        CONFIG.put(key, value);
    }

    public static Map<String, Boolean> getAll() {
        return new HashMap<>(CONFIG);
    }

    public static void load(){}

    public static void save() {
        // Fabric: write to JSON file
        // NeoForge: config is auto-saved by the system
    }
}