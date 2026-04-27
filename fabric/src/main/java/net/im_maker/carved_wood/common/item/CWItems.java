package net.im_maker.carved_wood.common.item;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class CWItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, name), item);
    }

    public static void registerItems() {
        CarvedWood.LOGGER.info("Registering Mod Items for " + CarvedWood.MOD_ID);
    }
}