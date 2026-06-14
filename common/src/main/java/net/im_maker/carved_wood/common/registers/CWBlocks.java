package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.*;
import net.im_maker.carved_wood.common.block.chiseled_bookshelf.*;
import net.im_maker.carved_wood.common.item.ChestBlockItem;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CWBlocks {

    //Crafting Tables
    public static final Supplier<Block> SPRUCE_CRAFTING_TABLE = registerWoodenFuelBlock("spruce_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).mapColor(MapColor.SAND).strength(2.5f)));
    public static final Supplier<Block> BIRCH_CRAFTING_TABLE = registerWoodenFuelBlock("birch_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).mapColor(MapColor.SAND).strength(2.5f)));
    public static final Supplier<Block> JUNGLE_CRAFTING_TABLE = registerWoodenFuelBlock("jungle_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).mapColor(MapColor.COLOR_YELLOW).strength(2.5f)));
    public static final Supplier<Block> ACACIA_CRAFTING_TABLE = registerWoodenFuelBlock("acacia_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).mapColor(MapColor.DIAMOND).strength(2.5f)));
    public static final Supplier<Block> DARK_OAK_CRAFTING_TABLE = registerWoodenFuelBlock("dark_oak_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).mapColor(MapColor.COLOR_BLUE).strength(2.5f)));
    public static final Supplier<Block> MANGROVE_CRAFTING_TABLE = registerWoodenFuelBlock("mangrove_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).mapColor(MapColor.WARPED_NYLIUM).strength(2.5f)));
    public static final Supplier<Block> CHERRY_CRAFTING_TABLE = registerWoodenFuelBlock("cherry_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.COLOR_RED).strength(2.5f)));
    public static final Supplier<Block> PALE_OAK_CRAFTING_TABLE = registerWoodenFuelBlock("pale_oak_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)));
    public static final Supplier<Block> CRIMSON_CRAFTING_TABLE = registerBlock("crimson_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.WOOD).strength(2.5f)));
    public static final Supplier<Block> WARPED_CRAFTING_TABLE = registerBlock("warped_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.WARPED_STEM).strength(2.5f)));
    public static final Supplier<Block> BAMBOO_CRAFTING_TABLE = registerWoodenFuelBlock("bamboo_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).mapColor(MapColor.COLOR_YELLOW).strength(2.5f)));
    //Crafters
    public static final Supplier<Block> SPRUCE_CRAFTER = registerWoodenFuelBlock("spruce_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> BIRCH_CRAFTER = registerWoodenFuelBlock("birch_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> JUNGLE_CRAFTER = registerWoodenFuelBlock("jungle_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> ACACIA_CRAFTER = registerWoodenFuelBlock("acacia_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> DARK_OAK_CRAFTER = registerWoodenFuelBlock("dark_oak_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> MANGROVE_CRAFTER = registerWoodenFuelBlock("mangrove_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> CHERRY_CRAFTER = registerWoodenFuelBlock("cherry_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> PALE_OAK_CRAFTER = registerWoodenFuelBlock("pale_oak_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> CRIMSON_CRAFTER = registerBlock("crimson_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> WARPED_CRAFTER = registerBlock("warped_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final Supplier<Block> BAMBOO_CRAFTER = registerWoodenFuelBlock("bamboo_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    //Ladders
    public static final Supplier<Block> SPRUCE_LADDER = registerWoodenFuelBlock("spruce_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> BIRCH_LADDER = registerWoodenFuelBlock("birch_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> JUNGLE_LADDER = registerWoodenFuelBlock("jungle_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> ACACIA_LADDER = registerWoodenFuelBlock("acacia_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> DARK_OAK_LADDER = registerWoodenFuelBlock("dark_oak_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> MANGROVE_LADDER = registerWoodenFuelBlock("mangrove_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> CHERRY_LADDER = registerWoodenFuelBlock("cherry_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> PALE_OAK_LADDER = registerWoodenFuelBlock("pale_oak_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> CRIMSON_LADDER = registerBlock("crimson_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> WARPED_LADDER = registerBlock("warped_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final Supplier<Block> BAMBOO_LADDER = registerWoodenFuelBlock("bamboo_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    //Chests (Normal/Trapped)
    public static final Supplier<Block> OAK_CHEST = registerChestBlock("oak_chest", () -> new CWChestBlock("oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> SPRUCE_CHEST = registerChestBlock("spruce_chest", () -> new CWChestBlock("spruce", BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> BIRCH_CHEST = registerChestBlock("birch_chest", () -> new CWChestBlock("birch", BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> JUNGLE_CHEST = registerChestBlock("jungle_chest", () -> new CWChestBlock("jungle", BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> ACACIA_CHEST = registerChestBlock("acacia_chest", () -> new CWChestBlock("acacia", BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> DARK_OAK_CHEST = registerChestBlock("dark_oak_chest", () -> new CWChestBlock("dark_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> MANGROVE_CHEST = registerChestBlock("mangrove_chest", () -> new CWChestBlock("mangrove", BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> CHERRY_CHEST = registerChestBlock("cherry_chest", () -> new CWChestBlock("cherry", BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> PALE_OAK_CHEST = registerChestBlock("pale_oak_chest", () -> new CWChestBlock("pale_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)), false, true);
    public static final Supplier<Block> CRIMSON_CHEST = registerChestBlock("crimson_chest", () -> new CWChestBlock("crimson", BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)), false, false);
    public static final Supplier<Block> WARPED_CHEST = registerChestBlock("warped_chest", () -> new CWChestBlock("warped", BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)), false, false);
    public static final Supplier<Block> BAMBOO_CHEST = registerChestBlock("bamboo_chest", () -> new CWChestBlock("bamboo", BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)), false, true);
    public static final Supplier<Block> TRAPPED_OAK_CHEST = registerChestBlock("trapped_oak_chest", () -> new CWTrappedChestBlock("oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_SPRUCE_CHEST = registerChestBlock("trapped_spruce_chest", () -> new CWTrappedChestBlock("spruce", BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_BIRCH_CHEST = registerChestBlock("trapped_birch_chest", () -> new CWTrappedChestBlock("birch", BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_JUNGLE_CHEST = registerChestBlock("trapped_jungle_chest", () -> new CWTrappedChestBlock("jungle", BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_ACACIA_CHEST = registerChestBlock("trapped_acacia_chest", () -> new CWTrappedChestBlock("acacia", BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_DARK_OAK_CHEST = registerChestBlock("trapped_dark_oak_chest", () -> new CWTrappedChestBlock("dark_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_MANGROVE_CHEST = registerChestBlock("trapped_mangrove_chest", () -> new CWTrappedChestBlock("mangrove", BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_CHERRY_CHEST = registerChestBlock("trapped_cherry_chest", () -> new CWTrappedChestBlock("cherry", BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_PALE_OAK_CHEST = registerChestBlock("trapped_pale_oak_chest", () -> new CWTrappedChestBlock("pale_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)), true, true);
    public static final Supplier<Block> TRAPPED_CRIMSON_CHEST = registerChestBlock("trapped_crimson_chest", () -> new CWTrappedChestBlock("crimson", BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)), true, false);
    public static final Supplier<Block> TRAPPED_WARPED_CHEST = registerChestBlock("trapped_warped_chest", () -> new CWTrappedChestBlock("warped", BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)), true, false);
    public static final Supplier<Block> TRAPPED_BAMBOO_CHEST = registerChestBlock("trapped_bamboo_chest", () -> new CWTrappedChestBlock("bamboo", BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)), true, true);
    //Barrels
    public static final Supplier<Block> OAK_BARREL = registerWoodenFuelBlock("oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)));
    public static final Supplier<Block> BIRCH_BARREL = registerWoodenFuelBlock("birch_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)));
    public static final Supplier<Block> JUNGLE_BARREL = registerWoodenFuelBlock("jungle_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)));
    public static final Supplier<Block> ACACIA_BARREL = registerWoodenFuelBlock("acacia_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)));
    public static final Supplier<Block> DARK_OAK_BARREL = registerWoodenFuelBlock("dark_oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)));
    public static final Supplier<Block> MANGROVE_BARREL = registerWoodenFuelBlock("mangrove_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)));
    public static final Supplier<Block> CHERRY_BARREL = registerWoodenFuelBlock("cherry_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)));
    public static final Supplier<Block> PALE_OAK_BARREL = registerWoodenFuelBlock("pale_oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)));
    public static final Supplier<Block> CRIMSON_BARREL = registerBlock("crimson_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)));
    public static final Supplier<Block> WARPED_BARREL = registerBlock("warped_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)));
    public static final Supplier<Block> BAMBOO_BARREL = registerWoodenFuelBlock("bamboo_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)));
    //Campfires (Normal/Soul)
    public static final Supplier<Block> SPRUCE_CAMPFIRE = registerBlock("spruce_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> BIRCH_CAMPFIRE = registerBlock("birch_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> JUNGLE_CAMPFIRE = registerBlock("jungle_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final Supplier<Block> ACACIA_CAMPFIRE = registerBlock("acacia_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final Supplier<Block> DARK_OAK_CAMPFIRE = registerBlock("dark_oak_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> MANGROVE_CAMPFIRE = registerBlock("mangrove_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final Supplier<Block> CHERRY_CAMPFIRE = registerBlock("cherry_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Supplier<Block> PALE_OAK_CAMPFIRE = registerBlock("pale_oak_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.METAL)));
    public static final Supplier<Block> CRIMSON_CAMPFIRE = registerBlock("crimson_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final Supplier<Block> BAMBOO_CAMPFIRE = registerBlock("bamboo_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    public static final Supplier<Block> WARPED_CAMPFIRE = registerBlock("warped_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final Supplier<Block> SOUL_SPRUCE_CAMPFIRE = registerBlock("soul_spruce_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> SOUL_BIRCH_CAMPFIRE = registerBlock("soul_birch_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> SOUL_JUNGLE_CAMPFIRE = registerBlock("soul_jungle_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final Supplier<Block> SOUL_ACACIA_CAMPFIRE = registerBlock("soul_acacia_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final Supplier<Block> SOUL_DARK_OAK_CAMPFIRE = registerBlock("soul_dark_oak_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> SOUL_MANGROVE_CAMPFIRE = registerBlock("soul_mangrove_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final Supplier<Block> SOUL_CHERRY_CAMPFIRE = registerBlock("soul_cherry_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Supplier<Block> SOUL_PALE_OAK_CAMPFIRE = registerBlock("soul_pale_oak_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.METAL)));
    public static final Supplier<Block> SOUL_CRIMSON_CAMPFIRE = registerBlock("soul_crimson_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final Supplier<Block> SOUL_WARPED_CAMPFIRE = registerBlock("soul_warped_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final Supplier<Block> SOUL_BAMBOO_CAMPFIRE = registerBlock("soul_bamboo_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    //Bookshelves
    public static final Supplier<Block> SPRUCE_BOOKSHELF = registerWoodenFuelBlock("spruce_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(1.5F)));
    public static final Supplier<Block> BIRCH_BOOKSHELF = registerWoodenFuelBlock("birch_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(1.5F)));
    public static final Supplier<Block> JUNGLE_BOOKSHELF = registerWoodenFuelBlock("jungle_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(1.5F)));
    public static final Supplier<Block> ACACIA_BOOKSHELF = registerWoodenFuelBlock("acacia_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(1.5F)));
    public static final Supplier<Block> DARK_OAK_BOOKSHELF = registerWoodenFuelBlock("dark_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(1.5F)));
    public static final Supplier<Block> MANGROVE_BOOKSHELF = registerWoodenFuelBlock("mangrove_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(1.5F)));
    public static final Supplier<Block> CHERRY_BOOKSHELF = registerWoodenFuelBlock("cherry_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(1.5F)));
    public static final Supplier<Block> PALE_OAK_BOOKSHELF = registerWoodenFuelBlock("pale_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(1.5F)));
    public static final Supplier<Block> CRIMSON_BOOKSHELF = registerBlock("crimson_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(1.5F)));
    public static final Supplier<Block> WARPED_BOOKSHELF = registerBlock("warped_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(1.5F)));
    public static final Supplier<Block> BAMBOO_BOOKSHELF = registerWoodenFuelBlock("bamboo_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(1.5F)));
    //Chiseled Bookshelves
    public static final Supplier<Block> CHISELED_SPRUCE_BOOKSHELF = registerWoodenFuelBlock("chiseled_spruce_bookshelf", () -> new CWChiseledBookShelfBlockType1(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_BIRCH_BOOKSHELF = registerWoodenFuelBlock("chiseled_birch_bookshelf", () -> new CWChiseledBookShelfBlockType2(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_JUNGLE_BOOKSHELF = registerWoodenFuelBlock("chiseled_jungle_bookshelf", () -> new CWChiseledBookShelfBlockType5(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_ACACIA_BOOKSHELF = registerWoodenFuelBlock("chiseled_acacia_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_DARK_OAK_BOOKSHELF = registerWoodenFuelBlock("chiseled_dark_oak_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_MANGROVE_BOOKSHELF = registerWoodenFuelBlock("chiseled_mangrove_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_CHERRY_BOOKSHELF = registerWoodenFuelBlock("chiseled_cherry_bookshelf", () -> new CWChiseledBookShelfBlockType7(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_PALE_OAK_BOOKSHELF = registerWoodenFuelBlock("chiseled_pale_oak_bookshelf", () -> new CWChiseledBookShelfBlockType1(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_CRIMSON_BOOKSHELF = registerBlock("chiseled_crimson_bookshelf", () -> new CWChiseledBookShelfBlockType4(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_WARPED_BOOKSHELF = registerBlock("chiseled_warped_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final Supplier<Block> CHISELED_BAMBOO_BOOKSHELF = registerWoodenFuelBlock("chiseled_bamboo_bookshelf", () -> new CWChiseledBookShelfBlockType8(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    //Lecterns
    public static final Supplier<Block> SPRUCE_LECTERN = registerWoodenFuelBlock("spruce_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5F)));
    public static final Supplier<Block> BIRCH_LECTERN = registerWoodenFuelBlock("birch_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5F)));
    public static final Supplier<Block> JUNGLE_LECTERN = registerWoodenFuelBlock("jungle_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5F)));
    public static final Supplier<Block> ACACIA_LECTERN = registerWoodenFuelBlock("acacia_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5F)));
    public static final Supplier<Block> DARK_OAK_LECTERN = registerWoodenFuelBlock("dark_oak_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5F)));
    public static final Supplier<Block> MANGROVE_LECTERN = registerWoodenFuelBlock("mangrove_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5F)));
    public static final Supplier<Block> CHERRY_LECTERN = registerWoodenFuelBlock("cherry_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5F)));
    public static final Supplier<Block> PALE_OAK_LECTERN = registerWoodenFuelBlock("pale_oak_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5F)));
    public static final Supplier<Block> CRIMSON_LECTERN = registerBlock("crimson_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5F), false));
    public static final Supplier<Block> WARPED_LECTERN = registerBlock("warped_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5F), false));
    public static final Supplier<Block> BAMBOO_LECTERN = registerWoodenFuelBlock("bamboo_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5F)));
    //Beehives
    public static final Supplier<Block> SPRUCE_BEEHIVE = registerBlock("spruce_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(0.6F)));
    public static final Supplier<Block> BIRCH_BEEHIVE = registerBlock("birch_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(0.6F)));
    public static final Supplier<Block> JUNGLE_BEEHIVE = registerBlock("jungle_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(0.6F)));
    public static final Supplier<Block> ACACIA_BEEHIVE = registerBlock("acacia_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(0.6F)));
    public static final Supplier<Block> DARK_OAK_BEEHIVE = registerBlock("dark_oak_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(0.6F)));
    public static final Supplier<Block> MANGROVE_BEEHIVE = registerBlock("mangrove_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(0.6F)));
    public static final Supplier<Block> CHERRY_BEEHIVE = registerBlock("cherry_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(0.6F)));
    public static final Supplier<Block> PALE_OAK_BEEHIVE = registerBlock("pale_oak_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(0.6F)));
    public static final Supplier<Block> CRIMSON_BEEHIVE = registerBlock("crimson_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(0.6F), false));
    public static final Supplier<Block> WARPED_BEEHIVE = registerBlock("warped_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(0.6F), false));
    public static final Supplier<Block> BAMBOO_BEEHIVE = registerBlock("bamboo_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(0.6F)));
    //Carved Planks
    public static final Supplier<Block> CARVED_OAK_PLANKS = registerWoodenFuelBlock("carved_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> CARVED_SPRUCE_PLANKS = registerWoodenFuelBlock("carved_spruce_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> CARVED_BIRCH_PLANKS = registerWoodenFuelBlock("carved_birch_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> CARVED_JUNGLE_PLANKS = registerWoodenFuelBlock("carved_jungle_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> CARVED_ACACIA_PLANKS = registerWoodenFuelBlock("carved_acacia_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> CARVED_DARK_OAK_PLANKS = registerWoodenFuelBlock("carved_dark_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> CARVED_MANGROVE_PLANKS = registerWoodenFuelBlock("carved_mangrove_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CARVED_CHERRY_PLANKS = registerWoodenFuelBlock("carved_cherry_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CARVED_PALE_OAK_PLANKS = registerWoodenFuelBlock("carved_pale_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CARVED_CRIMSON_PLANKS = registerBlock("carved_crimson_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final Supplier<Block> CARVED_WARPED_PLANKS = registerBlock("carved_warped_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final Supplier<Block> CARVED_BAMBOO_PLANKS = registerWoodenFuelBlock("carved_bamboo_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Panels
    public static final Supplier<Block> OAK_PANELS = registerWoodenFuelBlock("oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_PANELS = registerWoodenFuelBlock("spruce_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_PANELS = registerWoodenFuelBlock("birch_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_PANELS = registerWoodenFuelBlock("jungle_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_PANELS = registerWoodenFuelBlock("acacia_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_PANELS = registerWoodenFuelBlock("dark_oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_PANELS = registerWoodenFuelBlock("mangrove_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_PANELS = registerWoodenFuelBlock("cherry_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> PALE_OAK_PANELS = registerWoodenFuelBlock("pale_oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_PANELS = registerBlock("crimson_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final Supplier<Block> WARPED_PANELS = registerBlock("warped_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final Supplier<Block> BAMBOO_PANELS = registerWoodenFuelBlock("bamboo_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Boards
    public static final Supplier<Block> OAK_BOARDS = registerWoodenFuelBlock("oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_BOARDS = registerWoodenFuelBlock("spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_BOARDS = registerWoodenFuelBlock("birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_BOARDS = registerWoodenFuelBlock("jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_BOARDS = registerWoodenFuelBlock("acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_BOARDS = registerWoodenFuelBlock("dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_BOARDS = registerWoodenFuelBlock("mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_BOARDS = registerWoodenFuelBlock("cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> PALE_OAK_BOARDS = registerWoodenFuelBlock("pale_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_BOARDS = registerBlock("crimson_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final Supplier<Block> WARPED_BOARDS = registerBlock("warped_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final Supplier<Block> BAMBOO_BOARDS = registerWoodenFuelBlock("bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Smooth Wooden Boards
    public static final Supplier<Block> SMOOTH_OAK_BOARDS = registerWoodenFuelBlock("smooth_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SMOOTH_SPRUCE_BOARDS = registerWoodenFuelBlock("smooth_spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> SMOOTH_BIRCH_BOARDS = registerWoodenFuelBlock("smooth_birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> SMOOTH_JUNGLE_BOARDS = registerWoodenFuelBlock("smooth_jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> SMOOTH_ACACIA_BOARDS = registerWoodenFuelBlock("smooth_acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> SMOOTH_DARK_OAK_BOARDS = registerWoodenFuelBlock("smooth_dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> SMOOTH_MANGROVE_BOARDS = registerWoodenFuelBlock("smooth_mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> SMOOTH_CHERRY_BOARDS = registerWoodenFuelBlock("smooth_cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> SMOOTH_PALE_OAK_BOARDS = registerWoodenFuelBlock("smooth_pale_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> SMOOTH_CRIMSON_BOARDS = registerBlock("smooth_crimson_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final Supplier<Block> SMOOTH_WARPED_BOARDS = registerBlock("smooth_warped_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final Supplier<Block> SMOOTH_BAMBOO_BOARDS = registerWoodenFuelBlock("smooth_bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Lantern
    public static final Supplier<Block> OAK_LANTERN = registerWoodenFuelBlock("oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> SPRUCE_LANTERN = registerWoodenFuelBlock("spruce_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> BIRCH_LANTERN = registerWoodenFuelBlock("birch_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> JUNGLE_LANTERN = registerWoodenFuelBlock("jungle_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> ACACIA_LANTERN = registerWoodenFuelBlock("acacia_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> DARK_OAK_LANTERN = registerWoodenFuelBlock("dark_oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> MANGROVE_LANTERN = registerWoodenFuelBlock("mangrove_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> CHERRY_LANTERN = registerWoodenFuelBlock("cherry_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> PALE_OAK_LANTERN = registerWoodenFuelBlock("pale_oak_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> CRIMSON_LANTERN = registerBlock("crimson_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> WARPED_LANTERN = registerBlock("warped_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final Supplier<Block> BAMBOO_LANTERN = registerWoodenFuelBlock("bamboo_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    //Wooden Lantern
    public static final Supplier<Block> OAK_LANTERN_BLOCK  = registerWoodenFuelBlock("oak_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> SPRUCE_LANTERN_BLOCK  = registerWoodenFuelBlock("spruce_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> BIRCH_LANTERN_BLOCK  = registerWoodenFuelBlock("birch_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> JUNGLE_LANTERN_BLOCK  = registerWoodenFuelBlock("jungle_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> ACACIA_LANTERN_BLOCK  = registerWoodenFuelBlock("acacia_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> DARK_OAK_LANTERN_BLOCK  = registerWoodenFuelBlock("dark_oak_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> MANGROVE_LANTERN_BLOCK  = registerWoodenFuelBlock("mangrove_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> CHERRY_LANTERN_BLOCK  = registerWoodenFuelBlock("cherry_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).lightLevel(lightValue(15))));
    public static final Supplier<Block> PALE_OAK_LANTERN_BLOCK  = registerWoodenFuelBlock("pale_oak_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).lightLevel(lightValue(15))));
    public static final Supplier<Block> CRIMSON_LANTERN_BLOCK  = registerBlock("crimson_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).lightLevel(lightValue(15)),false));
    public static final Supplier<Block> WARPED_LANTERN_BLOCK  = registerBlock("warped_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).lightLevel(lightValue(15)),false));
    public static final Supplier<Block> BAMBOO_LANTERN_BLOCK  = registerWoodenFuelBlock("bamboo_lantern_block", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).lightLevel(lightValue(15))));
    //Wooden Tiles
    public static final Supplier<Block> OAK_TILES = registerWoodenFuelBlock("oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_TILES = registerWoodenFuelBlock("spruce_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_TILES = registerWoodenFuelBlock("birch_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_TILES = registerWoodenFuelBlock("jungle_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_TILES = registerWoodenFuelBlock("acacia_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_TILES = registerWoodenFuelBlock("dark_oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_TILES = registerWoodenFuelBlock("mangrove_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_TILES = registerWoodenFuelBlock("cherry_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> PALE_OAK_TILES = registerWoodenFuelBlock("pale_oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_TILES = registerBlock("crimson_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_TILES = registerBlock("warped_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> BAMBOO_TILES = registerWoodenFuelBlock("bamboo_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Tile Stairs
    public static final Supplier<Block> OAK_TILE_STAIRS = registerWoodenFuelBlock("oak_tile_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final Supplier<Block> SPRUCE_TILE_STAIRS = registerWoodenFuelBlock("spruce_tile_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS)));
    public static final Supplier<Block> BIRCH_TILE_STAIRS = registerWoodenFuelBlock("birch_tile_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final Supplier<Block> JUNGLE_TILE_STAIRS = registerWoodenFuelBlock("jungle_tile_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS)));
    public static final Supplier<Block> ACACIA_TILE_STAIRS = registerWoodenFuelBlock("acacia_tile_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)));
    public static final Supplier<Block> DARK_OAK_TILE_STAIRS = registerWoodenFuelBlock("dark_oak_tile_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)));
    public static final Supplier<Block> MANGROVE_TILE_STAIRS = registerWoodenFuelBlock("mangrove_tile_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS)));
    public static final Supplier<Block> CHERRY_TILE_STAIRS = registerWoodenFuelBlock("cherry_tile_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)));
    public static final Supplier<Block> PALE_OAK_TILE_STAIRS = registerWoodenFuelBlock("pale_oak_tile_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_TILE_STAIRS = registerBlock("crimson_tile_stairs", () -> new CWStairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));
    public static final Supplier<Block> WARPED_TILE_STAIRS = registerBlock("warped_tile_stairs", () -> new CWStairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final Supplier<Block> BAMBOO_TILE_STAIRS = registerWoodenFuelBlock("bamboo_tile_stairs", () -> new PlanksStairBlock(BAMBOO_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_STAIRS)));
    //Wooden Tile Slabs
    public static final Supplier<Block> OAK_TILE_SLAB = registerWoodenFuelBlock("oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)), true);
    public static final Supplier<Block> SPRUCE_TILE_SLAB = registerWoodenFuelBlock("spruce_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)), true);
    public static final Supplier<Block> BIRCH_TILE_SLAB = registerWoodenFuelBlock("birch_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)), true);
    public static final Supplier<Block> JUNGLE_TILE_SLAB = registerWoodenFuelBlock("jungle_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)), true);
    public static final Supplier<Block> ACACIA_TILE_SLAB = registerWoodenFuelBlock("acacia_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)), true);
    public static final Supplier<Block> DARK_OAK_TILE_SLAB = registerWoodenFuelBlock("dark_oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)), true);
    public static final Supplier<Block> MANGROVE_TILE_SLAB = registerWoodenFuelBlock("mangrove_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB)), true);
    public static final Supplier<Block> CHERRY_TILE_SLAB = registerWoodenFuelBlock("cherry_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)), true);
    public static final Supplier<Block> PALE_OAK_TILE_SLAB = registerWoodenFuelBlock("pale_oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.QUARTZ)), true);
    public static final Supplier<Block> CRIMSON_TILE_SLAB = registerBlock("crimson_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));
    public static final Supplier<Block> WARPED_TILE_SLAB = registerBlock("warped_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));
    public static final Supplier<Block> BAMBOO_TILE_SLAB = registerWoodenFuelBlock("bamboo_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_SLAB)), true);
    //Wooden Mosaic
    public static final Supplier<Block> OAK_MOSAIC = registerWoodenFuelBlock("oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_MOSAIC = registerWoodenFuelBlock("spruce_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_MOSAIC = registerWoodenFuelBlock("birch_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_MOSAIC = registerWoodenFuelBlock("jungle_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_MOSAIC = registerWoodenFuelBlock("acacia_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_MOSAIC = registerWoodenFuelBlock("dark_oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_MOSAIC = registerWoodenFuelBlock("mangrove_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_MOSAIC = registerWoodenFuelBlock("cherry_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> PALE_OAK_MOSAIC = registerWoodenFuelBlock("pale_oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_MOSAIC = registerBlock("crimson_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_MOSAIC = registerBlock("warped_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    //Wooden Mosaic Stairs
    public static final Supplier<Block> OAK_MOSAIC_STAIRS = registerWoodenFuelBlock("oak_mosaic_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final Supplier<Block> SPRUCE_MOSAIC_STAIRS = registerWoodenFuelBlock("spruce_mosaic_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS)));
    public static final Supplier<Block> BIRCH_MOSAIC_STAIRS = registerWoodenFuelBlock("birch_mosaic_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final Supplier<Block> JUNGLE_MOSAIC_STAIRS = registerWoodenFuelBlock("jungle_mosaic_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS)));
    public static final Supplier<Block> ACACIA_MOSAIC_STAIRS = registerWoodenFuelBlock("acacia_mosaic_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)));
    public static final Supplier<Block> DARK_OAK_MOSAIC_STAIRS = registerWoodenFuelBlock("dark_oak_mosaic_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)));
    public static final Supplier<Block> MANGROVE_MOSAIC_STAIRS = registerWoodenFuelBlock("mangrove_mosaic_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS)));
    public static final Supplier<Block> CHERRY_MOSAIC_STAIRS = registerWoodenFuelBlock("cherry_mosaic_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)));
    public static final Supplier<Block> PALE_OAK_MOSAIC_STAIRS = registerWoodenFuelBlock("pale_oak_mosaic_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_MOSAIC_STAIRS = registerBlock("crimson_mosaic_stairs", () -> new CWStairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));
    public static final Supplier<Block> WARPED_MOSAIC_STAIRS = registerBlock("warped_mosaic_stairs", () -> new CWStairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    //Wooden Mosaic Slabs
    public static final Supplier<Block> OAK_MOSAIC_SLAB = registerWoodenFuelBlock("oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)), true);
    public static final Supplier<Block> SPRUCE_MOSAIC_SLAB = registerWoodenFuelBlock("spruce_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)), true);
    public static final Supplier<Block> BIRCH_MOSAIC_SLAB = registerWoodenFuelBlock("birch_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)), true);
    public static final Supplier<Block> JUNGLE_MOSAIC_SLAB = registerWoodenFuelBlock("jungle_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)), true);
    public static final Supplier<Block> ACACIA_MOSAIC_SLAB = registerWoodenFuelBlock("acacia_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)), true);
    public static final Supplier<Block> DARK_OAK_MOSAIC_SLAB = registerWoodenFuelBlock("dark_oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)), true);
    public static final Supplier<Block> MANGROVE_MOSAIC_SLAB = registerWoodenFuelBlock("mangrove_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB)), true);
    public static final Supplier<Block> CHERRY_MOSAIC_SLAB = registerWoodenFuelBlock("cherry_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)), true);
    public static final Supplier<Block> PALE_OAK_MOSAIC_SLAB = registerWoodenFuelBlock("pale_oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.QUARTZ)), true);
    public static final Supplier<Block> CRIMSON_MOSAIC_SLAB = registerBlock("crimson_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));
    public static final Supplier<Block> WARPED_MOSAIC_SLAB = registerBlock("warped_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));
    //Pillar Planks
    public static final Supplier<Block> OAK_PILLAR = registerWoodenFuelBlock("oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_PILLAR = registerWoodenFuelBlock("spruce_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_PILLAR = registerWoodenFuelBlock("birch_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_PILLAR = registerWoodenFuelBlock("jungle_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_PILLAR = registerWoodenFuelBlock("acacia_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_PILLAR = registerWoodenFuelBlock("dark_oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_PILLAR = registerWoodenFuelBlock("mangrove_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_PILLAR = registerWoodenFuelBlock("cherry_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> PALE_OAK_PILLAR = registerWoodenFuelBlock("pale_oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> CRIMSON_PILLAR = registerBlock("crimson_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_PILLAR = registerBlock("warped_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final Supplier<Block> BAMBOO_PILLAR = registerWoodenFuelBlock("bamboo_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Log Bundle
    public static final Supplier<Block> OAK_LOG_BUNDLE = registerWoodenFuelBlock("oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final Supplier<Block> SPRUCE_LOG_BUNDLE = registerWoodenFuelBlock("spruce_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)));
    public static final Supplier<Block> BIRCH_LOG_BUNDLE = registerWoodenFuelBlock("birch_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));
    public static final Supplier<Block> JUNGLE_LOG_BUNDLE = registerWoodenFuelBlock("jungle_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));
    public static final Supplier<Block> ACACIA_LOG_BUNDLE = registerWoodenFuelBlock("acacia_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)));
    public static final Supplier<Block> DARK_OAK_LOG_BUNDLE = registerWoodenFuelBlock("dark_oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LOG)));
    public static final Supplier<Block> MANGROVE_LOG_BUNDLE = registerWoodenFuelBlock("mangrove_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG)));
    public static final Supplier<Block> CHERRY_LOG_BUNDLE = registerWoodenFuelBlock("cherry_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)));
    public static final Supplier<Block> PALE_OAK_LOG_BUNDLE = registerWoodenFuelBlock("pale_oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.QUARTZ : MapColor.METAL)));
    public static final Supplier<Block> CRIMSON_STEM_BUNDLE = registerBlock("crimson_stem_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM), false));
    public static final Supplier<Block> WARPED_STEM_BUNDLE = registerBlock("warped_stem_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM), false));
    public static final Supplier<Block> BAMBOO_BUNDLE = registerWoodenFuelBlock("bamboo_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK)));

    public static final Supplier<Block> STRIPPED_OAK_LOG_BUNDLE = registerWoodenFuelBlock("stripped_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final Supplier<Block> STRIPPED_SPRUCE_LOG_BUNDLE = registerWoodenFuelBlock("stripped_spruce_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final Supplier<Block> STRIPPED_BIRCH_LOG_BUNDLE = registerWoodenFuelBlock("stripped_birch_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final Supplier<Block> STRIPPED_JUNGLE_LOG_BUNDLE = registerWoodenFuelBlock("stripped_jungle_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final Supplier<Block> STRIPPED_ACACIA_LOG_BUNDLE = registerWoodenFuelBlock("stripped_acacia_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)));
    public static final Supplier<Block> STRIPPED_DARK_OAK_LOG_BUNDLE = registerWoodenFuelBlock("stripped_dark_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final Supplier<Block> STRIPPED_MANGROVE_LOG_BUNDLE = registerWoodenFuelBlock("stripped_mangrove_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_LOG)));
    public static final Supplier<Block> STRIPPED_CHERRY_LOG_BUNDLE = registerWoodenFuelBlock("stripped_cherry_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final Supplier<Block> STRIPPED_PALE_OAK_LOG_BUNDLE = registerWoodenFuelBlock("stripped_pale_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.QUARTZ)));
    public static final Supplier<Block> STRIPPED_CRIMSON_STEM_BUNDLE = registerBlock("stripped_crimson_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final Supplier<Block> STRIPPED_WARPED_STEM_BUNDLE = registerBlock("stripped_warped_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final Supplier<Block> STRIPPED_BAMBOO_BUNDLE = registerWoodenFuelBlock("stripped_bamboo_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK)));


    private static List<Supplier<?>> registerWoodSet(String woodName, String modID, boolean isFlammable, boolean isBamboo, boolean withAbnormalsBlocksCompat, MapColor woodColor, MapColor barkColor, MapColor craftingTableTopColor) {
        List<Supplier<?>> woodenBlocks = new ArrayList<>();
        Block planks = CarvedWood.getBlockFromString(modID,woodName + "_planks");
        Block stairs = CarvedWood.getBlockFromString(modID,woodName + "_stairs");
        Block slab = CarvedWood.getBlockFromString(modID,woodName + "_slab");
        Block log = CarvedWood.getBlockFromString(modID,woodName + "_log");
        Block strippedLog = CarvedWood.getBlockFromString(modID,"stripped_" + woodName + "_log");
        Block BambooBlock = CarvedWood.getBlockFromString(modID,woodName + "_block");
        Block strippedBambooBlock = CarvedWood.getBlockFromString(modID,"stripped_" + woodName + "_block");
        if (!withAbnormalsBlocksCompat) {
            // Chest
            woodenBlocks.add(registerChestBlock(woodName + "_chest", () -> new CWChestBlock(woodName, BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f)), false, isFlammable));
            // Trapped Chest
            woodenBlocks.add(registerChestBlock("trapped_" + woodName + "_chest", () -> new CWTrappedChestBlock(woodName, BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f)), true, isFlammable));
            // Ladder
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_ladder", () -> new CWLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER))));
            // Bookshelf
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(1.5F))));
            // Chiseled Bookshelf
            woodenBlocks.add(registerWoodenFuelBlock("chiseled_" + woodName + "_bookshelf", () -> new CWChiseledBookShelfBlockType2(BlockBehaviour.Properties.ofFullCopy(planks).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF))));
            // Beehive
            woodenBlocks.add(registerBlock(woodName + "_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(0.6F))));
        }

        // Crafting Table
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(planks).mapColor(craftingTableTopColor).strength(2.5f))));
        // Crafter
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER))));
        // Barrel
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f))));
        // Campfire
        woodenBlocks.add(registerBlock(woodName + "_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(woodColor))));
        // Soul Campfire
        woodenBlocks.add(registerBlock("soul_" + woodName + "_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(woodColor))));
        // Lectern
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5F))));
        // Carved Planks
        woodenBlocks.add(registerWoodenFuelBlock("carved_" + woodName + "_planks", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Panels
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Boards
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Smooth Wooden Boards
        woodenBlocks.add(registerWoodenFuelBlock("smooth_" + woodName + "_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Lantern
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_lantern", () -> new WoodenLanternBlock(BlockBehaviour.Properties.ofFullCopy(planks).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15)))));
        // Wooden Lantern Block
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks).lightLevel(lightValue(15)), isFlammable)));
        // Wooden Tiles
        Supplier<Block> tilesBlock = registerWoodenFuelBlock(woodName + "_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable));
        woodenBlocks.add(tilesBlock);
        // Wooden Tile Stairs
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_tile_stairs", () -> new PlanksStairBlock(tilesBlock.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(stairs), isFlammable)));
        // Wooden Tile Slabs
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(slab), isFlammable), true));
        // Pillar Planks
        woodenBlocks.add(registerWoodenFuelBlock(woodName + "_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        if (!isBamboo) {
            // Wooden Mosaic
            Supplier<Block> mosaicBlock = registerWoodenFuelBlock(woodName + "_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable));
            woodenBlocks.add(mosaicBlock);
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_mosaic_stairs", () -> new PlanksStairBlock(mosaicBlock.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(stairs), isFlammable)));
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(slab), isFlammable), true));
            // Log Bundle
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(log), isFlammable)));
            // Stripped Log Bundle
            woodenBlocks.add(registerWoodenFuelBlock("stripped_" + woodName + "_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(strippedLog), isFlammable)));
        } else {
            // Bundle
            woodenBlocks.add(registerWoodenFuelBlock(woodName + "_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(BambooBlock), isFlammable)));
            //Stripped Bundle
            woodenBlocks.add(registerWoodenFuelBlock("stripped_" + woodName + "_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(strippedBambooBlock), isFlammable)));
        }
        return woodenBlocks;
    }


    private static ToIntFunction<BlockState> lightValue(int pLightValue) {
        return (blockState) -> pLightValue;
    }

    public static Supplier<Block> registerWoodenFuelBlock(String name, Supplier<Block> block) {
        return registerWoodenFuelBlock(name, block, false);
    };

    private static Supplier<Block> registerWoodenFuelBlock(String name, Supplier<Block> block, Boolean isSlab) {
        Supplier<Block> toReturn = PlatHelper.registerBlock(CarvedWood.newRL(CarvedWood.MOD_ID, name), block);
        registerFuelBlockItem(name, toReturn, 300 / (isSlab ? 2 : 1));
        return toReturn;
    };

    private static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        Supplier<Block> toReturn =  registerBlockWithNoItem(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    };

    private static Supplier<Block> registerBlockWithNoItem(String name, Supplier<Block> block) {
        Supplier<Block> toReturn = PlatHelper.registerBlock(CarvedWood.newRL(CarvedWood.MOD_ID, name), block);
        return toReturn;
    };

    private static Supplier<Block> registerChestBlock(String name, Supplier<Block> block, Boolean isTrapped, Boolean isFuel) {
        int burnTime = isFuel ? 300 : 0;
        Supplier<Block> toReturn = registerBlockWithNoItem(name, block);
        registerChestBlockItem(name, toReturn, isTrapped , burnTime);
        return toReturn;
    };

    private static Supplier<Item> registerBlockItem(String name, Supplier<Block> block){
        return PlatHelper.registerItem(CarvedWood.newRL(CarvedWood.MOD_ID, name), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static Supplier<Item> registerFuelBlockItem(String name, Supplier<Block> block, int burnTime){
        Supplier<Item> toReturn = PlatHelper.registerItem(CarvedWood.newRL(CarvedWood.MOD_ID, name), () -> new BlockItem(block.get(), new Item.Properties()));
        PlatHelper.addFuelItem(toReturn, burnTime);
        return toReturn;
    }

    private static Supplier<Item> registerChestBlockItem(String name, Supplier<Block> block, Boolean isTrapped, int burnTime) {
        Supplier<Item> toReturn = PlatHelper.registerItem(CarvedWood.newRL(CarvedWood.MOD_ID, name), () -> new ChestBlockItem(block.get(), new Item.Properties()));
        PlatHelper.addFuelItem(toReturn, burnTime);
        return toReturn;
    }

    public static void  registerBlocks() {
        CarvedWood.LOGGER.info("Registering Mod Blocks for " + CarvedWood.MOD_ID);
    }
}