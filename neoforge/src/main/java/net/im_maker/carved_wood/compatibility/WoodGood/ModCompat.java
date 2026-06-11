package net.im_maker.carved_wood.compatibility.WoodGood;

import net.im_maker.carved_wood.CarvedWood;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class ModCompat {
    public static void init() {
        EveryCompatAPI.registerModule(new CarvedWoodModule(CarvedWood.MOD_ID));
        EveryCompatAPI.registerModule(new CarvedWoodModuleNeoForge(CarvedWood.MOD_ID));
    }
}