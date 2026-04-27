package net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf;

import net.im_maker.carved_wood.CarvedWood;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class CWMenus {

    //public static final Supplier<MenuType<LecternEditMenu>> LECTERN_EDIT_MENU =
    //        RegHelper.registerMenuType(
    //                ResourceLocation.fromNamespaceAndPath("carved_wood", "lectern_edit"),
    //                LecternEditMenu::of
    //        );



    public static void register() {
        // Just load the class to trigger static initialization
        CarvedWood.LOGGER.info("Registering menus for " + CarvedWood.MOD_ID);
    }
}