package net.im_maker.carved_wood.common.block.block_values;

import net.minecraft.util.StringRepresentable;

public enum WoodenLanternShape implements StringRepresentable {
    SETTING("setting"),
    HANGING("hanging"),
    HANGING_SIDE("hanging_side"),
    HANGING_WALL("hanging_wall"),
    HANGING_FENCE("hanging_fence");

    private final String name;

    private WoodenLanternShape(final String s) {
        this.name = s;
    }

    public boolean isHanging() {
        return this != SETTING;
    }

    public boolean isWallHanging() {
        return this != SETTING && this != HANGING;
    }

    public boolean isHangingOnWall() {
        return this == HANGING_WALL;
    }

    public boolean isHangingOnFence() {
        return this == HANGING_FENCE;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}