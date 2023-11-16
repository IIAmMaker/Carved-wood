package net.im_maker.paint.common.block;

import net.im_maker.paint.common.block.paint_buckets.ColoredPaintBucketBlock;
import net.im_maker.paint.common.block.paint_buckets.PaintBucketBlock;
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
import net.im_maker.paint.Paint;
import net.im_maker.paint.common.item.ModItems;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Paint.MOD_ID);
    //Painted Planks
    public static final RegistryObject<Block> RED_PAINTED_PLANKS = registryBlock("red_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORANGE_PAINTED_PLANKS = registryBlock("orange_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> YELLOW_PAINTED_PLANKS = registryBlock("yellow_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIME_PAINTED_PLANKS = registryBlock("lime_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GREEN_PAINTED_PLANKS = registryBlock("green_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GREEN).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYAN_PAINTED_PLANKS = registryBlock("cyan_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BLUE_PAINTED_PLANKS = registryBlock("light_blue_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLUE_PAINTED_PLANKS = registryBlock("blue_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PURPLE_PAINTED_PLANKS = registryBlock("purple_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PURPLE).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MAGENTA_PAINTED_PLANKS = registryBlock("magenta_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_PAINTED_PLANKS = registryBlock("pink_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_PAINTED_PLANKS = registryBlock("brown_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACK_PAINTED_PLANKS = registryBlock("black_painted_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GRAY_PAINTED_PLANKS = registryBlock("gray_painted_planks",
            () -> new Block (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_GRAY_PAINTED_PLANKS = registryBlock("light_gray_painted_planks",
            () -> new Block (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WHITE_PAINTED_PLANKS = registryBlock("white_painted_planks",
            () -> new Block (BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.SNOW).strength(2.0F, 3.0F).sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    //Painted Bricks
    public static final RegistryObject<Block> RED_PAINTED_BRICKS = registryBlock("red_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORANGE_PAINTED_BRICKS = registryBlock("orange_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> YELLOW_PAINTED_BRICKS = registryBlock("yellow_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_YELLOW).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIME_PAINTED_BRICKS = registryBlock("lime_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GREEN).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GREEN_PAINTED_BRICKS = registryBlock("green_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYAN_PAINTED_BRICKS = registryBlock("cyan_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BLUE_PAINTED_BRICKS = registryBlock("light_blue_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLUE_PAINTED_BRICKS = registryBlock("blue_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PURPLE_PAINTED_BRICKS = registryBlock("purple_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PURPLE).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MAGENTA_PAINTED_BRICKS = registryBlock("magenta_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PINK_PAINTED_BRICKS = registryBlock("pink_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_PAINTED_BRICKS = registryBlock("brown_painted_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLACK_PAINTED_BRICKS = registryBlock("black_painted_bricks",
            () -> new Block (BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GRAY_PAINTED_BRICKS = registryBlock("gray_painted_bricks",
            () -> new Block (BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_GRAY_PAINTED_BRICKS = registryBlock("light_gray_painted_bricks",
            () -> new Block (BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WHITE_PAINTED_BRICKS = registryBlock("white_painted_bricks",
            () -> new Block (BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).strength(2.0F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    //Paint Bucket
    public static final RegistryObject<Block> PAINT_BUCKET = registryBlock("paint_bucket",
            () -> new PaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(1.0F, 3.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> RED_PAINT_BUCKET = registryBlock("red_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ORANGE_PAINT_BUCKET = registryBlock("orange_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> YELLOW_PAINT_BUCKET = registryBlock("yellow_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LIME_PAINT_BUCKET = registryBlock("lime_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GREEN).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GREEN_PAINT_BUCKET = registryBlock("green_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYAN_PAINT_BUCKET = registryBlock("cyan_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LIGHT_BLUE_PAINT_BUCKET = registryBlock("light_blue_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_PAINT_BUCKET = registryBlock("blue_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PURPLE_PAINT_BUCKET = registryBlock("purple_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MAGENTA_PAINT_BUCKET = registryBlock("magenta_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PINK_PAINT_BUCKET = registryBlock("pink_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PINK).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BROWN_PAINT_BUCKET = registryBlock("brown_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLACK_PAINT_BUCKET = registryBlock("black_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GRAY_PAINT_BUCKET = registryBlock("gray_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LIGHT_GRAY_PAINT_BUCKET = registryBlock("light_gray_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> WHITE_PAINT_BUCKET = registryBlock("white_paint_bucket",
            () -> new ColoredPaintBucketBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.SNOW).strength(1.0F, 4.0F).sound(SoundType.LANTERN)), CreativeModeTab.TAB_DECORATIONS);

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
