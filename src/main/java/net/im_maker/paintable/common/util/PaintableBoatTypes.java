package net.im_maker.paintable.common.util;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import net.im_maker.paintable.Paintable;
import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class PaintableBoatTypes {
   public static final BoatloadBoatType RED_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("red_painted"), () -> ModBlocks.RED_PAINTED_PLANKS.get().asItem(), () -> ModItems.RED_PAINTED_BOAT.getFirst().get(), () -> ModItems.RED_PAINTED_BOAT.getSecond().get(), () -> ModItems.RED_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_RED_PAINTED_BOAT.get()));
   public static final BoatloadBoatType ORANGE_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("orange_painted"), () -> ModBlocks.ORANGE_PAINTED_PLANKS.get().asItem(), () -> ModItems.ORANGE_PAINTED_BOAT.getFirst().get(), () -> ModItems.ORANGE_PAINTED_BOAT.getSecond().get(), () -> ModItems.ORANGE_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_ORANGE_PAINTED_BOAT.get()));
   public static final BoatloadBoatType YELLOW_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("yellow_painted"), () -> ModBlocks.YELLOW_PAINTED_PLANKS.get().asItem(), () -> ModItems.YELLOW_PAINTED_BOAT.getFirst().get(), () -> ModItems.YELLOW_PAINTED_BOAT.getSecond().get(), () -> ModItems.YELLOW_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_YELLOW_PAINTED_BOAT.get()));
   public static final BoatloadBoatType LIME_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("lime_painted"), () -> ModBlocks.LIME_PAINTED_PLANKS.get().asItem(), () -> ModItems.LIME_PAINTED_BOAT.getFirst().get(), () -> ModItems.LIME_PAINTED_BOAT.getSecond().get(), () -> ModItems.LIME_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_LIME_PAINTED_BOAT.get()));
   public static final BoatloadBoatType GREEN_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("green_painted"), () -> ModBlocks.GREEN_PAINTED_PLANKS.get().asItem(), () -> ModItems.GREEN_PAINTED_BOAT.getFirst().get(), () -> ModItems.GREEN_PAINTED_BOAT.getSecond().get(), () -> ModItems.GREEN_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_GREEN_PAINTED_BOAT.get()));
   public static final BoatloadBoatType CYAN_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("cyan_painted"), () -> ModBlocks.CYAN_PAINTED_PLANKS.get().asItem(), () -> ModItems.CYAN_PAINTED_BOAT.getFirst().get(), () -> ModItems.CYAN_PAINTED_BOAT.getSecond().get(), () -> ModItems.CYAN_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_CYAN_PAINTED_BOAT.get()));
   public static final BoatloadBoatType LIGHT_BLUE_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("light_blue_painted"), () -> ModBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().asItem(), () -> ModItems.LIGHT_BLUE_PAINTED_BOAT.getFirst().get(), () -> ModItems.LIGHT_BLUE_PAINTED_BOAT.getSecond().get(), () -> ModItems.LIGHT_BLUE_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_LIGHT_BLUE_PAINTED_BOAT.get()));
   public static final BoatloadBoatType BLUE_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("blue_painted"), () -> ModBlocks.BLUE_PAINTED_PLANKS.get().asItem(), () -> ModItems.BLUE_PAINTED_BOAT.getFirst().get(), () -> ModItems.BLUE_PAINTED_BOAT.getSecond().get(), () -> ModItems.BLUE_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_BLUE_PAINTED_BOAT.get()));
   public static final BoatloadBoatType PURPLE_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("purple_painted"), () -> ModBlocks.PURPLE_PAINTED_PLANKS.get().asItem(), () -> ModItems.PURPLE_PAINTED_BOAT.getFirst().get(), () -> ModItems.PURPLE_PAINTED_BOAT.getSecond().get(), () -> ModItems.PURPLE_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_PURPLE_PAINTED_BOAT.get()));
   public static final BoatloadBoatType MAGENTA_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("magenta_painted"), () -> ModBlocks.MAGENTA_PAINTED_PLANKS.get().asItem(), () -> ModItems.MAGENTA_PAINTED_BOAT.getFirst().get(), () -> ModItems.MAGENTA_PAINTED_BOAT.getSecond().get(), () -> ModItems.MAGENTA_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_MAGENTA_PAINTED_BOAT.get()));
   public static final BoatloadBoatType PINK_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("pink_painted"), () -> ModBlocks.PINK_PAINTED_PLANKS.get().asItem(), () -> ModItems.PINK_PAINTED_BOAT.getFirst().get(), () -> ModItems.PINK_PAINTED_BOAT.getSecond().get(), () -> ModItems.PINK_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_PINK_PAINTED_BOAT.get()));
   public static final BoatloadBoatType BROWN_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("brown_painted"), () -> ModBlocks.BROWN_PAINTED_PLANKS.get().asItem(), () -> ModItems.BROWN_PAINTED_BOAT.getFirst().get(), () -> ModItems.BROWN_PAINTED_BOAT.getSecond().get(), () -> ModItems.BROWN_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_BROWN_PAINTED_BOAT.get()));
   public static final BoatloadBoatType BLACK_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("black_painted"), () -> ModBlocks.BLACK_PAINTED_PLANKS.get().asItem(), () -> ModItems.BLACK_PAINTED_BOAT.getFirst().get(), () -> ModItems.BLACK_PAINTED_BOAT.getSecond().get(), () -> ModItems.BLACK_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_BLACK_PAINTED_BOAT.get()));
   public static final BoatloadBoatType GRAY_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("gray_painted"), () -> ModBlocks.GRAY_PAINTED_PLANKS.get().asItem(), () -> ModItems.GRAY_PAINTED_BOAT.getFirst().get(), () -> ModItems.GRAY_PAINTED_BOAT.getSecond().get(), () -> ModItems.GRAY_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_GRAY_PAINTED_BOAT.get()));
   public static final BoatloadBoatType LIGHT_GRAY_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("light_gray_painted"), () -> ModBlocks.LIGHT_GRAY_PAINTED_PLANKS.get().asItem(), () -> ModItems.LIGHT_GRAY_PAINTED_BOAT.getFirst().get(), () -> ModItems.LIGHT_GRAY_PAINTED_BOAT.getSecond().get(), () -> ModItems.LIGHT_GRAY_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_LIGHT_GRAY_PAINTED_BOAT.get()));
   public static final BoatloadBoatType WHITE_PAINTED = BoatloadBoatType.register(BoatloadBoatType.create(Paintable.location("white_painted"), () -> ModBlocks.WHITE_PAINTED_PLANKS.get().asItem(), () -> ModItems.WHITE_PAINTED_BOAT.getFirst().get(), () -> ModItems.WHITE_PAINTED_BOAT.getSecond().get(), () -> ModItems.WHITE_PAINTED_FURNACE_BOAT.get(), () -> ModItems.LARGE_WHITE_PAINTED_BOAT.get()));

   public static final Supplier<Item> RED_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(RED_PAINTED);
   public static final Supplier<Item> LARGE_RED_PAINTED_BOAT = () -> new LargeBoatItem(RED_PAINTED);

   public static final Supplier<Item> ORANGE_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(ORANGE_PAINTED);
   public static final Supplier<Item> LARGE_ORANGE_PAINTED_BOAT = () -> new LargeBoatItem(ORANGE_PAINTED);

   public static final Supplier<Item> YELLOW_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(YELLOW_PAINTED);
   public static final Supplier<Item> LARGE_YELLOW_PAINTED_BOAT = () -> new LargeBoatItem(YELLOW_PAINTED);

   public static final Supplier<Item> LIME_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(LIME_PAINTED);
   public static final Supplier<Item> LARGE_LIME_PAINTED_BOAT = () -> new LargeBoatItem(LIME_PAINTED);

   public static final Supplier<Item> GREEN_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(GREEN_PAINTED);
   public static final Supplier<Item> LARGE_GREEN_PAINTED_BOAT = () -> new LargeBoatItem(GREEN_PAINTED);

   public static final Supplier<Item> CYAN_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(CYAN_PAINTED);
   public static final Supplier<Item> LARGE_CYAN_PAINTED_BOAT = () -> new LargeBoatItem(CYAN_PAINTED);

   public static final Supplier<Item> LIGHT_BLUE_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(LIGHT_BLUE_PAINTED);
   public static final Supplier<Item> LARGE_LIGHT_BLUE_PAINTED_BOAT = () -> new LargeBoatItem(LIGHT_BLUE_PAINTED);

   public static final Supplier<Item> BLUE_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(BLUE_PAINTED);
   public static final Supplier<Item> LARGE_BLUE_PAINTED_BOAT = () -> new LargeBoatItem(BLUE_PAINTED);

   public static final Supplier<Item> PURPLE_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(PURPLE_PAINTED);
   public static final Supplier<Item> LARGE_PURPLE_PAINTED_BOAT = () -> new LargeBoatItem(PURPLE_PAINTED);

   public static final Supplier<Item> MAGENTA_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(MAGENTA_PAINTED);
   public static final Supplier<Item> LARGE_MAGENTA_PAINTED_BOAT = () -> new LargeBoatItem(MAGENTA_PAINTED);

   public static final Supplier<Item> PINK_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(PINK_PAINTED);
   public static final Supplier<Item> LARGE_PINK_PAINTED_BOAT = () -> new LargeBoatItem(PINK_PAINTED);

   public static final Supplier<Item> BROWN_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(BROWN_PAINTED);
   public static final Supplier<Item> LARGE_BROWN_PAINTED_BOAT = () -> new LargeBoatItem(BROWN_PAINTED);

   public static final Supplier<Item> BLACK_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(BLACK_PAINTED);
   public static final Supplier<Item> LARGE_BLACK_PAINTED_BOAT = () -> new LargeBoatItem(BLACK_PAINTED);

   public static final Supplier<Item> GRAY_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(GRAY_PAINTED);
   public static final Supplier<Item> LARGE_GRAY_PAINTED_BOAT = () -> new LargeBoatItem(GRAY_PAINTED);

   public static final Supplier<Item> LIGHT_GRAY_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(LIGHT_GRAY_PAINTED);
   public static final Supplier<Item> LARGE_LIGHT_GRAY_PAINTED_BOAT = () -> new LargeBoatItem(LIGHT_GRAY_PAINTED);

   public static final Supplier<Item> WHITE_PAINTED_FURNACE_BOAT = () -> new FurnaceBoatItem(WHITE_PAINTED);
   public static final Supplier<Item> LARGE_WHITE_PAINTED_BOAT = () -> new LargeBoatItem(WHITE_PAINTED);
}