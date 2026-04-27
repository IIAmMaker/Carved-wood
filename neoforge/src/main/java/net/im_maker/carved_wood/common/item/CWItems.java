package net.im_maker.carved_wood.common.item;

import net.im_maker.carved_wood.CarvedWood;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CWItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CarvedWood.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}