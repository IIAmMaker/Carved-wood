package net.im_maker.carved_wood.common.block.block_values;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class CWBlockStateProperties {
    public static final BooleanProperty ODD = BooleanProperty.create("odd");
    public static final BooleanProperty END_ODD = BooleanProperty.create("end_odd");
    public static final EnumProperty<WoodenLanternShape> WOODEN_LANTERN_SHAPE = EnumProperty.create("shape", WoodenLanternShape.class);
}