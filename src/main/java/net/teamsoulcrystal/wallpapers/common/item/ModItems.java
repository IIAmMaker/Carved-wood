package net.teamsoulcrystal.wallpapers.common.item;

import net.teamsoulcrystal.wallpapers.Wallpapers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.teamsoulcrystal.wallpapers.common.item.wallpaper_rolls.*;
import net.teamsoulcrystal.wallpapers.common.item.baseborde.*;
import net.teamsoulcrystal.wallpapers.common.item.wallpaper_rolls.DripstoneBasebordeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Wallpapers.MOD_ID);
    //Wallpaper Roll Items
    public static final RegistryObject<Item> RED_WALLPAPER_ROLL = ITEMS.register("red_wallpaper_roll",
            () -> new RedWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> ORANGE_WALLPAPER_ROLL = ITEMS.register("orange_wallpaper_roll",
            () -> new OrangeWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> YELLOW_WALLPAPER_ROLL = ITEMS.register("yellow_wallpaper_roll",
            () -> new YellowWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIME_WALLPAPER_ROLL = ITEMS.register("lime_wallpaper_roll",
            () -> new LimeWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GREEN_WALLPAPER_ROLL = ITEMS.register("green_wallpaper_roll",
            () -> new GreenWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CYAN_WALLPAPER_ROLL = ITEMS.register("cyan_wallpaper_roll",
            () -> new CyanWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIGHT_BLUE_WALLPAPER_ROLL = ITEMS.register("light_blue_wallpaper_roll",
            () -> new LightBlueWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> Blue_WALLPAPER_ROLL = ITEMS.register("blue_wallpaper_roll",
            () -> new BlueWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PURPLE_WALLPAPER_ROLL = ITEMS.register("purple_wallpaper_roll",
            () -> new PurpleWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> MAGENTA_WALLPAPER_ROLL = ITEMS.register("magenta_wallpaper_roll",
            () -> new MagentaWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PINK_WALLPAPER_ROLL = ITEMS.register("pink_wallpaper_roll",
            () -> new PinkWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BROWN_WALLPAPER_ROLL = ITEMS.register("brown_wallpaper_roll",
            () -> new BrownWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BLACK_WALLPAPER_ROLL = ITEMS.register("black_wallpaper_roll",
            () -> new BlackWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GRAY_WALLPAPER_ROLL = ITEMS.register("gray_wallpaper_roll",
            () -> new GrayWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> LIGHT_GRAY_WALLPAPER_ROLL = ITEMS.register("light_gray_wallpaper_roll",
            () -> new LightGrayWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> WHITE_WALLPAPER_ROLL = ITEMS.register("white_wallpaper_roll",
            () -> new WhiteWallpaperRollItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    //Baseborde Items
    public static final RegistryObject<Item> DRIPSTONE_BASEBOARD = ITEMS.register("dripstone_baseboard",
            () -> new DripstoneBasebordeItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> QUARTZ_BASEBOARD = ITEMS.register("quartz_baseboard",
            () -> new QuartzBaseboardItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> GOLD_BASEBOARD = ITEMS.register("gold_baseboard",
            () -> new GoldBaseboardItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> PRISMARINE_BASEBOARD = ITEMS.register("prismarine_baseboard",
            () -> new PrismarineBaseboardItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}