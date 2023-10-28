package net.teamsoulcrystal.wallpapers.common.block.block_values;

import net.minecraft.util.StringRepresentable;

public enum Baseboard implements StringRepresentable {
    NONE("none"),
    DRIPSTONE("dripstone"),
    QUARTZ("quartz"),
    GOLD("gold"),
    PRISMARINE("prismarine");


    private final String name;

    Baseboard(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
