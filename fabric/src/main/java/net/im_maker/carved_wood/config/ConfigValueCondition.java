package net.im_maker.carved_wood.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigValueCondition implements ResourceCondition {

    public static final MapCodec<ConfigValueCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.STRING.fieldOf("value").forGetter(c -> c.value),
                    Codec.BOOL.optionalFieldOf("inverted", false).forGetter(c -> c.inverted)
            ).apply(instance, ConfigValueCondition::new)
    );

    public static final ResourceConditionType<ConfigValueCondition> TYPE =
            ResourceConditionType.create(
                    ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "config"),
                    CODEC  // Now CODEC is initialized before this line
            );

    private final String value;
    private final boolean inverted;

    public ConfigValueCondition(String value) {
        this(value, false);
    }

    public ConfigValueCondition(String value, boolean inverted) {
        this.value = value;
        this.inverted = inverted;
    }

    @Override
    public boolean test(HolderLookup.@Nullable Provider provider) {
        String key = value.contains(":") ? value.split(":")[1] : value;
        boolean result = CarvedWoodConfig.isEnabled(key);
        return inverted ? !result : result;
    }

    @Override
    public @NotNull ResourceConditionType<?> getType() {
        return TYPE;
    }

    public static ConfigValueCondition config(String key) {
        return new ConfigValueCondition(CarvedWood.MOD_ID + ":" + key);
    }

    public static ConfigValueCondition configInverted(String key) {
        return new ConfigValueCondition(CarvedWood.MOD_ID + ":" + key, true);
    }

    // Predefined conditions
    public static final ConfigValueCondition BARRELS_ENABLED = config("wooden_barrels");
    public static final ConfigValueCondition CHESTS_ENABLED = config("wooden_chests");
    public static final ConfigValueCondition TRAPPED_CHESTS_ENABLED = config("wooden_trapped_chests");
    public static final ConfigValueCondition CRAFTING_TABLES_ENABLED = config("wooden_crafting_tables");
    public static final ConfigValueCondition LADDERS_ENABLED = config("wooden_ladders");
    public static final ConfigValueCondition BOOKSHELVES_ENABLED = config("wooden_bookshelves");
    public static final ConfigValueCondition BEEHIVES_ENABLED = config("wooden_beehives");
    public static final ConfigValueCondition CAMPFIRES_ENABLED = config("wooden_campfires");
    public static final ConfigValueCondition LOG_BUNDLES_ENABLED = config("log_bundles");

    public static final ConfigValueCondition MIXED_BARREL_CRAFTING = config("mixed_barrel_crafting");
    public static final ConfigValueCondition MIXED_CHEST_CRAFTING = config("mixed_chest_crafting");
    public static final ConfigValueCondition MIXED_CRAFTING_TABLE_CRAFTING = config("mixed_crafting_table_crafting");
    public static final ConfigValueCondition MIXED_LADDER_CRAFTING = config("mixed_ladder_crafting");
    public static final ConfigValueCondition MIXED_BOOKSHELF_CRAFTING = config("mixed_bookshelf_crafting");
    public static final ConfigValueCondition MIXED_CHISELED_BOOKSHELF_CRAFTING = config("mixed_chiseled_bookshelf_crafting");
    public static final ConfigValueCondition MIXED_LECTERN_CRAFTING = config("mixed_lectern_crafting");
    public static final ConfigValueCondition MIXED_BEEHIVE_CRAFTING = config("mixed_beehive_crafting");
    public static final ConfigValueCondition MIXED_CAMPFIRE_CRAFTING = config("mixed_campfire_crafting");
}