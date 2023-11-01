package net.im_maker.wallpapers.common.block;

import net.im_maker.wallpapers.common.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.im_maker.wallpapers.Wallpapers;
import net.im_maker.wallpapers.common.item.ModItems;
import net.im_maker.wallpapers.common.block.wallpaper_blocks.WallpaperBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Wallpapers.MOD_ID);
    //Wallpaper Blocks
    public static final RegistryObject<Block> RED_WALLPAPER_BLOCK = registryBlock("red_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORANGE_WALLPAPER_BLOCK = registryBlock("orange_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> YELLOW_WALLPAPER_BLOCK = registryBlock("yellow_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIME_WALLPAPER_BLOCK = registryBlock("lime_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GREEN_WALLPAPER_BLOCK = registryBlock("green_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYAN_WALLPAPER_BLOCK = registryBlock("cyan_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BLUE_WALLPAPER_BLOCK = registryBlock("light_blue_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLUE_WALLPAPER_BLOCK = registryBlock("blue_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PURPLE_WALLPAPER_BLOCK = registryBlock("purple_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MAGENTA_WALLPAPER_BLOCK = registryBlock("magenta_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_WALLPAPER_BLOCK = registryBlock("pink_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_WALLPAPER_BLOCK = registryBlock("brown_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACK_WALLPAPER_BLOCK = registryBlock("black_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GRAY_WALLPAPER_BLOCK = registryBlock("gray_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_GRAY_WALLPAPER_BLOCK = registryBlock("light_gray_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WHITE_WALLPAPER_BLOCK = registryBlock("white_wallpaper_block",
            () -> new WallpaperBlock (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).strength(2.0F, 3.0F).sound(ModSounds.WALLPAPER_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab ) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    };

    private static <T extends Block>  RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
