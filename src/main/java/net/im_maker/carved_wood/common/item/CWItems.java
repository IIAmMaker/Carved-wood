package net.im_maker.carved_wood.common.item;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CWItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CarvedWood.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}