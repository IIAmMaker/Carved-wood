package net.im_maker.carved_wood.common.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.Item;

public class CWFuelRegistry {
    public static void registerFuel() {
    }
    public static void registerFuel(Item item, int burnTime) {
        FuelRegistry.INSTANCE.add(item, burnTime);
    }
}