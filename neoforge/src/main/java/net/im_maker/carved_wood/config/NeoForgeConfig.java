package net.im_maker.carved_wood.config;

import net.im_maker.carved_wood.CarvedWood;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = CarvedWood.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class NeoForgeConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue BARRELS_ENABLED = BUILDER
            .comment("Enable/disable all wooden barrels").define("wooden_barrels", true);
    public static final ModConfigSpec.BooleanValue CHESTS_ENABLED = BUILDER
            .comment("Enable/disable all wooden chests").define("wooden_chests", true);
    public static final ModConfigSpec.BooleanValue CRAFTING_TABLES_ENABLED = BUILDER
            .comment("Enable/disable all wooden crafting tables").define("wooden_crafting_tables", true);
    public static final ModConfigSpec.BooleanValue LADDERS_ENABLED = BUILDER
            .comment("Enable/disable all wooden ladders").define("wooden_ladders", true);
    public static final ModConfigSpec.BooleanValue BOOKSHELVES_ENABLED = BUILDER
            .comment("Enable/disable all wooden bookshelves").define("wooden_bookshelves", true);
    public static final ModConfigSpec.BooleanValue BEEHIVES_ENABLED = BUILDER
            .comment("Enable/disable all wooden beehives").define("wooden_beehives", true);
    public static final ModConfigSpec.BooleanValue CAMPFIRES_ENABLED = BUILDER
            .comment("Enable/disable all wooden campfires").define("wooden_campfires", true);
    public static final ModConfigSpec.BooleanValue LOG_BUNDLES_ENABLED = BUILDER
            .comment("Enable/disable all log bundles").define("log_bundles", true);
    public static final ModConfigSpec.BooleanValue CARVED_PLANKS_ENABLED = BUILDER
            .comment("Enable/disable all planks sets").define("planks_sets", true);

    public static final ModConfigSpec.BooleanValue MIXED_BARREL_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks barrel crafting").define("mixed_barrel_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_CHEST_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks chest crafting").define("mixed_chest_crafting", true);
    public static final ModConfigSpec.BooleanValue MIXED_CRAFTING_TABLE_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks crafting table crafting").define("mixed_crafting_table_crafting", true);
    public static final ModConfigSpec.BooleanValue MIXED_LADDER_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks ladder crafting").define("mixed_ladder_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_BOOKSHELF_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks bookshelf crafting").define("mixed_bookshelf_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_CHISELED_BOOKSHELF_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks chiseled bookshelf crafting").define("mixed_chiseled_bookshelf_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_LECTERN_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks lectern crafting").define("mixed_lectern_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_BEEHIVE_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks beehive crafting").define("mixed_beehive_crafting", false);
    public static final ModConfigSpec.BooleanValue MIXED_CAMPFIRE_CRAFTING = BUILDER
            .comment("Enable/disable mixed planks campfire crafting").define("mixed_campfire_crafting", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            updateConfig();
        }
    }

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            updateConfig();
        }
    }

    private static void updateConfig() {
        CarvedWoodConfig.set("wooden_barrels", BARRELS_ENABLED.get());
        CarvedWoodConfig.set("wooden_chests", CHESTS_ENABLED.get());
        CarvedWoodConfig.set("wooden_crafting_tables", CRAFTING_TABLES_ENABLED.get());
        CarvedWoodConfig.set("wooden_ladders", LADDERS_ENABLED.get());
        CarvedWoodConfig.set("wooden_bookshelves", BOOKSHELVES_ENABLED.get());
        CarvedWoodConfig.set("wooden_beehives", BEEHIVES_ENABLED.get());
        CarvedWoodConfig.set("wooden_campfires", CAMPFIRES_ENABLED.get());
        CarvedWoodConfig.set("log_bundles", LOG_BUNDLES_ENABLED.get());
        CarvedWoodConfig.set("planks_sets", CARVED_PLANKS_ENABLED.get());

        CarvedWoodConfig.set("mixed_barrel_crafting", MIXED_BARREL_CRAFTING.get());
        CarvedWoodConfig.set("mixed_chest_crafting", MIXED_CHEST_CRAFTING.get());
        CarvedWoodConfig.set("mixed_crafting_table_crafting", MIXED_CRAFTING_TABLE_CRAFTING.get());
        CarvedWoodConfig.set("mixed_ladder_crafting", MIXED_LADDER_CRAFTING.get());
        CarvedWoodConfig.set("mixed_bookshelf_crafting", MIXED_BOOKSHELF_CRAFTING.get());
        CarvedWoodConfig.set("mixed_chiseled_bookshelf_crafting", MIXED_CHISELED_BOOKSHELF_CRAFTING.get());
        CarvedWoodConfig.set("mixed_lectern_crafting", MIXED_LECTERN_CRAFTING.get());
        CarvedWoodConfig.set("mixed_beehive_crafting", MIXED_BEEHIVE_CRAFTING.get());
        CarvedWoodConfig.set("mixed_campfire_crafting", MIXED_CAMPFIRE_CRAFTING.get());
    }
}