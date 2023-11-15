package net.im_maker.paint.common.item;

import net.im_maker.paint.Paint;
import net.im_maker.paint.common.item.paint_brushs.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Paint.MOD_ID);
    //Wallpaper Roll Items
    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush",
            () -> new PaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1)));
    public static final RegistryObject<Item> RED_PAINT_BRUSH = ITEMS.register("red_paint_brush",
            () -> new RedPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> ORANGE_PAINT_BRUSH = ITEMS.register("orange_paint_brush",
            () -> new OrangePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> YELLOW_PAINT_BRUSH = ITEMS.register("yellow_paint_brush",
            () -> new YellowPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> LIME_PAINT_BRUSH = ITEMS.register("lime_paint_brush",
            () -> new LimePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> GREEN_PAINT_BRUSH = ITEMS.register("green_paint_brush",
            () -> new GreenPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> CYAN_PAINT_BRUSH = ITEMS.register("cyan_paint_brush",
            () -> new CyanPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> LIGHT_BLUE_PAINT_BRUSH = ITEMS.register("light_blue_paint_brush",
            () -> new LightBluePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> BLUE_PAINT_BRUSH = ITEMS.register("blue_paint_brush",
            () -> new BluePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> PURPLE_PAINT_BRUSH = ITEMS.register("purple_paint_brush",
            () -> new PurplePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> MAGENTA_PAINT_BRUSH = ITEMS.register("magenta_paint_brush",
            () -> new MagentaPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> PINK_PAINT_BRUSH = ITEMS.register("pink_paint_brush",
            () -> new PinkPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> BROWN_PAINT_BRUSH = ITEMS.register("brown_paint_brush",
            () -> new BrownPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> BLACK_PAINT_BRUSH = ITEMS.register("black_paint_brush",
            () -> new BlackPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> GRAY_PAINT_BRUSH = ITEMS.register("gray_paint_brush",
            () -> new GrayPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> LIGHT_GRAY_PAINT_BRUSH = ITEMS.register("light_gray_paint_brush",
            () -> new LightGrayPaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));
    public static final RegistryObject<Item> WHITE_PAINT_BRUSH = ITEMS.register("white_paint_brush",
            () -> new WhitePaintBrushItem(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).stacksTo(1).durability(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}