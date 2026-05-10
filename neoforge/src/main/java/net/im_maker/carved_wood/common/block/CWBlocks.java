package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.*;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.*;
import net.im_maker.carved_wood.common.item.CWItems;
import net.im_maker.carved_wood.common.item.custom.ChestBlockItem;
import net.im_maker.carved_wood.common.item.custom.FuelBlockItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CWBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CarvedWood.MOD_ID);

    //Crafting Tables
    public static final DeferredBlock<Block> SPRUCE_CRAFTING_TABLE = registryWoodenFuelBlock("spruce_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).mapColor(MapColor.SAND).strength(2.5f)));
    public static final DeferredBlock<Block> BIRCH_CRAFTING_TABLE = registryWoodenFuelBlock("birch_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).mapColor(MapColor.SAND).strength(2.5f)));
    public static final DeferredBlock<Block> JUNGLE_CRAFTING_TABLE = registryWoodenFuelBlock("jungle_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).mapColor(MapColor.COLOR_YELLOW).strength(2.5f)));
    public static final DeferredBlock<Block> ACACIA_CRAFTING_TABLE = registryWoodenFuelBlock("acacia_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).mapColor(MapColor.DIAMOND).strength(2.5f)));
    public static final DeferredBlock<Block> DARK_OAK_CRAFTING_TABLE = registryWoodenFuelBlock("dark_oak_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).mapColor(MapColor.COLOR_BLUE).strength(2.5f)));
    public static final DeferredBlock<Block> MANGROVE_CRAFTING_TABLE = registryWoodenFuelBlock("mangrove_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).mapColor(MapColor.WARPED_NYLIUM).strength(2.5f)));
    public static final DeferredBlock<Block> CHERRY_CRAFTING_TABLE = registryWoodenFuelBlock("cherry_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.COLOR_RED).strength(2.5f)));
    public static final DeferredBlock<Block> PALE_OAK_CRAFTING_TABLE = registryWoodenFuelBlock("pale_oak_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)));
    public static final DeferredBlock<Block> CRIMSON_CRAFTING_TABLE = registryBlock("crimson_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.WOOD).strength(2.5f)));
    public static final DeferredBlock<Block> WARPED_CRAFTING_TABLE = registryBlock("warped_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.WARPED_STEM).strength(2.5f)));
    public static final DeferredBlock<Block> BAMBOO_CRAFTING_TABLE = registryWoodenFuelBlock("bamboo_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).mapColor(MapColor.COLOR_YELLOW).strength(2.5f)));
    //Crafting Tables
    public static final DeferredBlock<Block> SPRUCE_CRAFTER = registryWoodenFuelBlock("spruce_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> BIRCH_CRAFTER = registryWoodenFuelBlock("birch_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> JUNGLE_CRAFTER = registryWoodenFuelBlock("jungle_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> ACACIA_CRAFTER = registryWoodenFuelBlock("acacia_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> DARK_OAK_CRAFTER = registryWoodenFuelBlock("dark_oak_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> MANGROVE_CRAFTER = registryWoodenFuelBlock("mangrove_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> CHERRY_CRAFTER = registryWoodenFuelBlock("cherry_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> PALE_OAK_CRAFTER = registryWoodenFuelBlock("pale_oak_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> CRIMSON_CRAFTER = registryBlock("crimson_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> WARPED_CRAFTER = registryBlock("warped_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    public static final DeferredBlock<Block> BAMBOO_CRAFTER = registryWoodenFuelBlock("bamboo_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER)));
    //Ladders
    public static final DeferredBlock<Block> SPRUCE_LADDER = registryWoodenFuelBlock("spruce_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> BIRCH_LADDER = registryWoodenFuelBlock("birch_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> JUNGLE_LADDER = registryWoodenFuelBlock("jungle_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> ACACIA_LADDER = registryWoodenFuelBlock("acacia_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> DARK_OAK_LADDER = registryWoodenFuelBlock("dark_oak_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> MANGROVE_LADDER = registryWoodenFuelBlock("mangrove_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> CHERRY_LADDER = registryWoodenFuelBlock("cherry_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> PALE_OAK_LADDER = registryWoodenFuelBlock("pale_oak_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> CRIMSON_LADDER = registryBlock("crimson_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> WARPED_LADDER = registryBlock("warped_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    public static final DeferredBlock<Block> BAMBOO_LADDER = registryWoodenFuelBlock("bamboo_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));
    //Chests (Normal/Trapped)
    public static final DeferredBlock<Block> OAK_CHEST = registryChestBlock("oak_chest", () -> new CWChestBlock("oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> SPRUCE_CHEST = registryChestBlock("spruce_chest", () -> new CWChestBlock("spruce", BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> BIRCH_CHEST = registryChestBlock("birch_chest", () -> new CWChestBlock("birch", BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> JUNGLE_CHEST = registryChestBlock("jungle_chest", () -> new CWChestBlock("jungle", BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> ACACIA_CHEST = registryChestBlock("acacia_chest", () -> new CWChestBlock("acacia", BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> DARK_OAK_CHEST = registryChestBlock("dark_oak_chest", () -> new CWChestBlock("dark_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> MANGROVE_CHEST = registryChestBlock("mangrove_chest", () -> new CWChestBlock("mangrove", BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> CHERRY_CHEST = registryChestBlock("cherry_chest", () -> new CWChestBlock("cherry", BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> PALE_OAK_CHEST = registryChestBlock("pale_oak_chest", () -> new CWChestBlock("pale_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> CRIMSON_CHEST = registryChestBlock("crimson_chest", () -> new CWChestBlock("crimson", BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)), false, false);
    public static final DeferredBlock<Block> WARPED_CHEST = registryChestBlock("warped_chest", () -> new CWChestBlock("warped", BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)), false, false);
    public static final DeferredBlock<Block> BAMBOO_CHEST = registryChestBlock("bamboo_chest", () -> new CWChestBlock("bamboo", BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)), false, true);
    public static final DeferredBlock<Block> TRAPPED_OAK_CHEST = registryChestBlock("trapped_oak_chest", () -> new CWTrappedChestBlock("oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_SPRUCE_CHEST = registryChestBlock("trapped_spruce_chest", () -> new CWTrappedChestBlock("spruce", BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_BIRCH_CHEST = registryChestBlock("trapped_birch_chest", () -> new CWTrappedChestBlock("birch", BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_JUNGLE_CHEST = registryChestBlock("trapped_jungle_chest", () -> new CWTrappedChestBlock("jungle", BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_ACACIA_CHEST = registryChestBlock("trapped_acacia_chest", () -> new CWTrappedChestBlock("acacia", BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_DARK_OAK_CHEST = registryChestBlock("trapped_dark_oak_chest", () -> new CWTrappedChestBlock("dark_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_MANGROVE_CHEST = registryChestBlock("trapped_mangrove_chest", () -> new CWTrappedChestBlock("mangrove", BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_CHERRY_CHEST = registryChestBlock("trapped_cherry_chest", () -> new CWTrappedChestBlock("cherry", BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_PALE_OAK_CHEST = registryChestBlock("trapped_pale_oak_chest", () -> new CWTrappedChestBlock("pale_oak", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)), true, true);
    public static final DeferredBlock<Block> TRAPPED_CRIMSON_CHEST = registryChestBlock("trapped_crimson_chest", () -> new CWTrappedChestBlock("crimson", BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)), true, false);
    public static final DeferredBlock<Block> TRAPPED_WARPED_CHEST = registryChestBlock("trapped_warped_chest", () -> new CWTrappedChestBlock("warped", BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)), true, false);
    public static final DeferredBlock<Block> TRAPPED_BAMBOO_CHEST = registryChestBlock("trapped_bamboo_chest", () -> new CWTrappedChestBlock("bamboo", BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)), true, true);
    //Barrels
    public static final DeferredBlock<Block> OAK_BARREL = registryWoodenFuelBlock("oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> BIRCH_BARREL = registryWoodenFuelBlock("birch_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> JUNGLE_BARREL = registryWoodenFuelBlock("jungle_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> ACACIA_BARREL = registryWoodenFuelBlock("acacia_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> DARK_OAK_BARREL = registryWoodenFuelBlock("dark_oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> MANGROVE_BARREL = registryWoodenFuelBlock("mangrove_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> CHERRY_BARREL = registryWoodenFuelBlock("cherry_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> PALE_OAK_BARREL = registryWoodenFuelBlock("pale_oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5f)));
    public static final DeferredBlock<Block> CRIMSON_BARREL = registryBlock("crimson_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> WARPED_BARREL = registryBlock("warped_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5f)));
    public static final DeferredBlock<Block> BAMBOO_BARREL = registryWoodenFuelBlock("bamboo_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5f)));
    //Campfires (Normal/Soul)
    public static final DeferredBlock<Block> SPRUCE_CAMPFIRE = registryBlock("spruce_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final DeferredBlock<Block> BIRCH_CAMPFIRE = registryBlock("birch_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> JUNGLE_CAMPFIRE = registryBlock("jungle_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> ACACIA_CAMPFIRE = registryBlock("acacia_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> DARK_OAK_CAMPFIRE = registryBlock("dark_oak_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final DeferredBlock<Block> MANGROVE_CAMPFIRE = registryBlock("mangrove_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> CHERRY_CAMPFIRE = registryBlock("cherry_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final DeferredBlock<Block> PALE_OAK_CAMPFIRE = registryBlock("pale_oak_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> CRIMSON_CAMPFIRE = registryBlock("crimson_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final DeferredBlock<Block> BAMBOO_CAMPFIRE = registryBlock("bamboo_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    public static final DeferredBlock<Block> WARPED_CAMPFIRE = registryBlock("warped_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final DeferredBlock<Block> SOUL_SPRUCE_CAMPFIRE = registryBlock("soul_spruce_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final DeferredBlock<Block> SOUL_BIRCH_CAMPFIRE = registryBlock("soul_birch_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> SOUL_JUNGLE_CAMPFIRE = registryBlock("soul_jungle_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> SOUL_ACACIA_CAMPFIRE = registryBlock("soul_acacia_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final DeferredBlock<Block> SOUL_DARK_OAK_CAMPFIRE = registryBlock("soul_dark_oak_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final DeferredBlock<Block> SOUL_MANGROVE_CAMPFIRE = registryBlock("soul_mangrove_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final DeferredBlock<Block> SOUL_CHERRY_CAMPFIRE = registryBlock("soul_cherry_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final DeferredBlock<Block> SOUL_PALE_OAK_CAMPFIRE = registryBlock("soul_pale_oak_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.METAL)));
    public static final DeferredBlock<Block> SOUL_CRIMSON_CAMPFIRE = registryBlock("soul_crimson_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final DeferredBlock<Block> SOUL_WARPED_CAMPFIRE = registryBlock("soul_warped_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final DeferredBlock<Block> SOUL_BAMBOO_CAMPFIRE = registryBlock("soul_bamboo_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    //Bookshelves
    public static final DeferredBlock<Block> SPRUCE_BOOKSHELF = registryWoodenFuelBlock("spruce_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> BIRCH_BOOKSHELF = registryWoodenFuelBlock("birch_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> JUNGLE_BOOKSHELF = registryWoodenFuelBlock("jungle_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> ACACIA_BOOKSHELF = registryWoodenFuelBlock("acacia_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> DARK_OAK_BOOKSHELF = registryWoodenFuelBlock("dark_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> MANGROVE_BOOKSHELF = registryWoodenFuelBlock("mangrove_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> CHERRY_BOOKSHELF = registryWoodenFuelBlock("cherry_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> PALE_OAK_BOOKSHELF = registryWoodenFuelBlock("pale_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(1.5F)));
    public static final DeferredBlock<Block> CRIMSON_BOOKSHELF = registryBlock("crimson_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> WARPED_BOOKSHELF = registryBlock("warped_bookshelf", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(1.5F)));
    public static final DeferredBlock<Block> BAMBOO_BOOKSHELF = registryWoodenFuelBlock("bamboo_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(1.5F)));
    //Chiseled Bookshelves
    public static final DeferredBlock<Block> CHISELED_SPRUCE_BOOKSHELF = registryWoodenFuelBlock("chiseled_spruce_bookshelf", () -> new CWChiseledBookShelfBlockType1(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_BIRCH_BOOKSHELF = registryWoodenFuelBlock("chiseled_birch_bookshelf", () -> new CWChiseledBookShelfBlockType2(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_JUNGLE_BOOKSHELF = registryWoodenFuelBlock("chiseled_jungle_bookshelf", () -> new CWChiseledBookShelfBlockType5(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_ACACIA_BOOKSHELF = registryWoodenFuelBlock("chiseled_acacia_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_DARK_OAK_BOOKSHELF = registryWoodenFuelBlock("chiseled_dark_oak_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_MANGROVE_BOOKSHELF = registryWoodenFuelBlock("chiseled_mangrove_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_CHERRY_BOOKSHELF = registryWoodenFuelBlock("chiseled_cherry_bookshelf", () -> new CWChiseledBookShelfBlockType7(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_PALE_OAK_BOOKSHELF = registryWoodenFuelBlock("chiseled_pale_oak_bookshelf", () -> new CWChiseledBookShelfBlockType1(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_CRIMSON_BOOKSHELF = registryBlock("chiseled_crimson_bookshelf", () -> new CWChiseledBookShelfBlockType4(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_WARPED_BOOKSHELF = registryBlock("chiseled_warped_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final DeferredBlock<Block> CHISELED_BAMBOO_BOOKSHELF = registryWoodenFuelBlock("chiseled_bamboo_bookshelf", () -> new CWChiseledBookShelfBlockType8(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    //Lecterns
    public static final DeferredBlock<Block> SPRUCE_LECTERN = registryWoodenFuelBlock("spruce_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> BIRCH_LECTERN = registryWoodenFuelBlock("birch_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> JUNGLE_LECTERN = registryWoodenFuelBlock("jungle_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> ACACIA_LECTERN = registryWoodenFuelBlock("acacia_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> DARK_OAK_LECTERN = registryWoodenFuelBlock("dark_oak_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> MANGROVE_LECTERN = registryWoodenFuelBlock("mangrove_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> CHERRY_LECTERN = registryWoodenFuelBlock("cherry_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(2.5F)));
    public static final DeferredBlock<Block> PALE_OAK_LECTERN = registryWoodenFuelBlock("pale_oak_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(2.5F)));
    public static final DeferredBlock<Block> CRIMSON_LECTERN = registryBlock("crimson_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(2.5F), false));
    public static final DeferredBlock<Block> WARPED_LECTERN = registryBlock("warped_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(2.5F), false));
    public static final DeferredBlock<Block> BAMBOO_LECTERN = registryWoodenFuelBlock("bamboo_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(2.5F)));
    //Beehives
    public static final DeferredBlock<Block> SPRUCE_BEEHIVE = registryBlock("spruce_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> BIRCH_BEEHIVE = registryBlock("birch_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> JUNGLE_BEEHIVE = registryBlock("jungle_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> ACACIA_BEEHIVE = registryBlock("acacia_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> DARK_OAK_BEEHIVE = registryBlock("dark_oak_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> MANGROVE_BEEHIVE = registryBlock("mangrove_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> CHERRY_BEEHIVE = registryBlock("cherry_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).strength(0.6F)));
    public static final DeferredBlock<Block> PALE_OAK_BEEHIVE = registryBlock("pale_oak_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).strength(0.6F)));
    public static final DeferredBlock<Block> CRIMSON_BEEHIVE = registryBlock("crimson_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).strength(0.6F), false));
    public static final DeferredBlock<Block> WARPED_BEEHIVE = registryBlock("warped_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).strength(0.6F), false));
    public static final DeferredBlock<Block> BAMBOO_BEEHIVE = registryBlock("bamboo_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).strength(0.6F)));
    //Carved Planks
    public static final DeferredBlock<Block> CARVED_OAK_PLANKS = registryWoodenFuelBlock("carved_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> CARVED_SPRUCE_PLANKS = registryWoodenFuelBlock("carved_spruce_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> CARVED_BIRCH_PLANKS = registryWoodenFuelBlock("carved_birch_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> CARVED_JUNGLE_PLANKS = registryWoodenFuelBlock("carved_jungle_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> CARVED_ACACIA_PLANKS = registryWoodenFuelBlock("carved_acacia_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> CARVED_DARK_OAK_PLANKS = registryWoodenFuelBlock("carved_dark_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> CARVED_MANGROVE_PLANKS = registryWoodenFuelBlock("carved_mangrove_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CARVED_CHERRY_PLANKS = registryWoodenFuelBlock("carved_cherry_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CARVED_PALE_OAK_PLANKS = registryWoodenFuelBlock("carved_pale_oak_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CARVED_CRIMSON_PLANKS = registryBlock("carved_crimson_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final DeferredBlock<Block> CARVED_WARPED_PLANKS = registryBlock("carved_warped_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final DeferredBlock<Block> CARVED_BAMBOO_PLANKS = registryWoodenFuelBlock("carved_bamboo_planks", () -> new CarvedPlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Panels
    public static final DeferredBlock<Block> OAK_PANELS = registryWoodenFuelBlock("oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_PANELS = registryWoodenFuelBlock("spruce_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PANELS = registryWoodenFuelBlock("birch_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_PANELS = registryWoodenFuelBlock("jungle_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_PANELS = registryWoodenFuelBlock("acacia_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PANELS = registryWoodenFuelBlock("dark_oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PANELS = registryWoodenFuelBlock("mangrove_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_PANELS = registryWoodenFuelBlock("cherry_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PALE_OAK_PANELS = registryWoodenFuelBlock("pale_oak_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_PANELS = registryBlock("crimson_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final DeferredBlock<Block> WARPED_PANELS = registryBlock("warped_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final DeferredBlock<Block> BAMBOO_PANELS = registryWoodenFuelBlock("bamboo_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Boards
    public static final DeferredBlock<Block> OAK_BOARDS = registryWoodenFuelBlock("oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_BOARDS = registryWoodenFuelBlock("spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_BOARDS = registryWoodenFuelBlock("birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_BOARDS = registryWoodenFuelBlock("jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_BOARDS = registryWoodenFuelBlock("acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_BOARDS = registryWoodenFuelBlock("dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_BOARDS = registryWoodenFuelBlock("mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_BOARDS = registryWoodenFuelBlock("cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PALE_OAK_BOARDS = registryWoodenFuelBlock("pale_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_BOARDS = registryBlock("crimson_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final DeferredBlock<Block> WARPED_BOARDS = registryBlock("warped_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final DeferredBlock<Block> BAMBOO_BOARDS = registryWoodenFuelBlock("bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Smooth Wooden Boards
    public static final DeferredBlock<Block> SMOOTH_OAK_BOARDS = registryWoodenFuelBlock("smooth_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_SPRUCE_BOARDS = registryWoodenFuelBlock("smooth_spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_BIRCH_BOARDS = registryWoodenFuelBlock("smooth_birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_JUNGLE_BOARDS = registryWoodenFuelBlock("smooth_jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_ACACIA_BOARDS = registryWoodenFuelBlock("smooth_acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_DARK_OAK_BOARDS = registryWoodenFuelBlock("smooth_dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_MANGROVE_BOARDS = registryWoodenFuelBlock("smooth_mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_CHERRY_BOARDS = registryWoodenFuelBlock("smooth_cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> SMOOTH_PALE_OAK_BOARDS = registryWoodenFuelBlock("smooth_pale_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> SMOOTH_CRIMSON_BOARDS = registryBlock("smooth_crimson_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS), false));
    public static final DeferredBlock<Block> SMOOTH_WARPED_BOARDS = registryBlock("smooth_warped_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS), false));
    public static final DeferredBlock<Block> SMOOTH_BAMBOO_BOARDS = registryWoodenFuelBlock("smooth_bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Lantern
    public static final DeferredBlock<Block> OAK_LANTERN = registryWoodenFuelBlock("oak_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> SPRUCE_LANTERN = registryWoodenFuelBlock("spruce_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> BIRCH_LANTERN = registryWoodenFuelBlock("birch_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> JUNGLE_LANTERN = registryWoodenFuelBlock("jungle_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> ACACIA_LANTERN = registryWoodenFuelBlock("acacia_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> DARK_OAK_LANTERN = registryWoodenFuelBlock("dark_oak_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> MANGROVE_LANTERN = registryWoodenFuelBlock("mangrove_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> CHERRY_LANTERN = registryWoodenFuelBlock("cherry_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> PALE_OAK_LANTERN = registryWoodenFuelBlock("pale_oak_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> CRIMSON_LANTERN = registryBlock("crimson_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> WARPED_LANTERN = registryBlock("warped_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> BAMBOO_LANTERN = registryWoodenFuelBlock("bamboo_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))));
    //Wooden Lantern
    public static final DeferredBlock<Block> OAK_LANTERN_BLOCK  = registryWoodenFuelBlock("oak_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> SPRUCE_LANTERN_BLOCK  = registryWoodenFuelBlock("spruce_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> BIRCH_LANTERN_BLOCK  = registryWoodenFuelBlock("birch_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> JUNGLE_LANTERN_BLOCK  = registryWoodenFuelBlock("jungle_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> ACACIA_LANTERN_BLOCK  = registryWoodenFuelBlock("acacia_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> DARK_OAK_LANTERN_BLOCK  = registryWoodenFuelBlock("dark_oak_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> MANGROVE_LANTERN_BLOCK  = registryWoodenFuelBlock("mangrove_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> CHERRY_LANTERN_BLOCK  = registryWoodenFuelBlock("cherry_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> PALE_OAK_LANTERN_BLOCK  = registryWoodenFuelBlock("pale_oak_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> CRIMSON_LANTERN_BLOCK  = registryBlock("crimson_lantern_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> WARPED_LANTERN_BLOCK  = registryBlock("warped_lantern_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).lightLevel(lightValue(15))));
    public static final DeferredBlock<Block> BAMBOO_LANTERN_BLOCK  = registryWoodenFuelBlock("bamboo_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).lightLevel(lightValue(15))));
    //Wooden Tiles
    public static final DeferredBlock<Block> OAK_TILES = registryWoodenFuelBlock("oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_TILES = registryWoodenFuelBlock("spruce_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_TILES = registryWoodenFuelBlock("birch_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_TILES = registryWoodenFuelBlock("jungle_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_TILES = registryWoodenFuelBlock("acacia_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_TILES = registryWoodenFuelBlock("dark_oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_TILES = registryWoodenFuelBlock("mangrove_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_TILES = registryWoodenFuelBlock("cherry_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PALE_OAK_TILES = registryWoodenFuelBlock("pale_oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_TILES = registryBlock("crimson_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_TILES = registryBlock("warped_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> BAMBOO_TILES = registryWoodenFuelBlock("bamboo_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Wooden Tile Stairs
    public static final DeferredBlock<Block> OAK_TILE_STAIRS = registryWoodenFuelBlock("oak_tile_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> SPRUCE_TILE_STAIRS = registryWoodenFuelBlock("spruce_tile_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS)));
    public static final DeferredBlock<Block> BIRCH_TILE_STAIRS = registryWoodenFuelBlock("birch_tile_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final DeferredBlock<Block> JUNGLE_TILE_STAIRS = registryWoodenFuelBlock("jungle_tile_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS)));
    public static final DeferredBlock<Block> ACACIA_TILE_STAIRS = registryWoodenFuelBlock("acacia_tile_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)));
    public static final DeferredBlock<Block> DARK_OAK_TILE_STAIRS = registryWoodenFuelBlock("dark_oak_tile_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)));
    public static final DeferredBlock<Block> MANGROVE_TILE_STAIRS = registryWoodenFuelBlock("mangrove_tile_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS)));
    public static final DeferredBlock<Block> CHERRY_TILE_STAIRS = registryWoodenFuelBlock("cherry_tile_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)));
    public static final DeferredBlock<Block> PALE_OAK_TILE_STAIRS = registryWoodenFuelBlock("pale_oak_tile_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_TILE_STAIRS = registryBlock("crimson_tile_stairs", () -> new StairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));
    public static final DeferredBlock<Block> WARPED_TILE_STAIRS = registryBlock("warped_tile_stairs", () -> new StairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    public static final DeferredBlock<Block> BAMBOO_TILE_STAIRS = registryWoodenFuelBlock("bamboo_tile_stairs", () -> new PlanksStairBlock(BAMBOO_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_STAIRS)));
    //Wooden Tile Slabs
    public static final DeferredBlock<Block> OAK_TILE_SLAB = registryWoodenFuelBlock("oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)), true);
    public static final DeferredBlock<Block> SPRUCE_TILE_SLAB = registryWoodenFuelBlock("spruce_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)), true);
    public static final DeferredBlock<Block> BIRCH_TILE_SLAB = registryWoodenFuelBlock("birch_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)), true);
    public static final DeferredBlock<Block> JUNGLE_TILE_SLAB = registryWoodenFuelBlock("jungle_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)), true);
    public static final DeferredBlock<Block> ACACIA_TILE_SLAB = registryWoodenFuelBlock("acacia_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)), true);
    public static final DeferredBlock<Block> DARK_OAK_TILE_SLAB = registryWoodenFuelBlock("dark_oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)), true);
    public static final DeferredBlock<Block> MANGROVE_TILE_SLAB = registryWoodenFuelBlock("mangrove_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB)), true);
    public static final DeferredBlock<Block> CHERRY_TILE_SLAB = registryWoodenFuelBlock("cherry_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)), true);
    public static final DeferredBlock<Block> PALE_OAK_TILE_SLAB = registryWoodenFuelBlock("pale_oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.QUARTZ)), true);
    public static final DeferredBlock<Block> CRIMSON_TILE_SLAB = registryBlock("crimson_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));
    public static final DeferredBlock<Block> WARPED_TILE_SLAB = registryBlock("warped_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));
    public static final DeferredBlock<Block> BAMBOO_TILE_SLAB = registryWoodenFuelBlock("bamboo_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_SLAB)), true);
    //Wooden Mosaic
    public static final DeferredBlock<Block> OAK_MOSAIC = registryWoodenFuelBlock("oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_MOSAIC = registryWoodenFuelBlock("spruce_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_MOSAIC = registryWoodenFuelBlock("birch_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_MOSAIC = registryWoodenFuelBlock("jungle_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_MOSAIC = registryWoodenFuelBlock("acacia_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_MOSAIC = registryWoodenFuelBlock("dark_oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_MOSAIC = registryWoodenFuelBlock("mangrove_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_MOSAIC = registryWoodenFuelBlock("cherry_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PALE_OAK_MOSAIC = registryWoodenFuelBlock("pale_oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_MOSAIC = registryBlock("crimson_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_MOSAIC = registryBlock("warped_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    //Wooden Mosaic Stairs
    public static final DeferredBlock<Block> OAK_MOSAIC_STAIRS = registryWoodenFuelBlock("oak_mosaic_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> SPRUCE_MOSAIC_STAIRS = registryWoodenFuelBlock("spruce_mosaic_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS)));
    public static final DeferredBlock<Block> BIRCH_MOSAIC_STAIRS = registryWoodenFuelBlock("birch_mosaic_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_STAIRS)));
    public static final DeferredBlock<Block> JUNGLE_MOSAIC_STAIRS = registryWoodenFuelBlock("jungle_mosaic_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_STAIRS)));
    public static final DeferredBlock<Block> ACACIA_MOSAIC_STAIRS = registryWoodenFuelBlock("acacia_mosaic_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)));
    public static final DeferredBlock<Block> DARK_OAK_MOSAIC_STAIRS = registryWoodenFuelBlock("dark_oak_mosaic_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_STAIRS)));
    public static final DeferredBlock<Block> MANGROVE_MOSAIC_STAIRS = registryWoodenFuelBlock("mangrove_mosaic_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS)));
    public static final DeferredBlock<Block> CHERRY_MOSAIC_STAIRS = registryWoodenFuelBlock("cherry_mosaic_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_STAIRS)));
    public static final DeferredBlock<Block> PALE_OAK_MOSAIC_STAIRS = registryWoodenFuelBlock("pale_oak_mosaic_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_MOSAIC_STAIRS = registryBlock("crimson_mosaic_stairs", () -> new StairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));
    public static final DeferredBlock<Block> WARPED_MOSAIC_STAIRS = registryBlock("warped_mosaic_stairs", () -> new StairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STAIRS)));
    //Wooden Mosaic Slabs
    public static final DeferredBlock<Block> OAK_MOSAIC_SLAB = registryWoodenFuelBlock("oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)), true);
    public static final DeferredBlock<Block> SPRUCE_MOSAIC_SLAB = registryWoodenFuelBlock("spruce_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB)), true);
    public static final DeferredBlock<Block> BIRCH_MOSAIC_SLAB = registryWoodenFuelBlock("birch_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_SLAB)), true);
    public static final DeferredBlock<Block> JUNGLE_MOSAIC_SLAB = registryWoodenFuelBlock("jungle_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SLAB)), true);
    public static final DeferredBlock<Block> ACACIA_MOSAIC_SLAB = registryWoodenFuelBlock("acacia_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)), true);
    public static final DeferredBlock<Block> DARK_OAK_MOSAIC_SLAB = registryWoodenFuelBlock("dark_oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SLAB)), true);
    public static final DeferredBlock<Block> MANGROVE_MOSAIC_SLAB = registryWoodenFuelBlock("mangrove_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB)), true);
    public static final DeferredBlock<Block> CHERRY_MOSAIC_SLAB = registryWoodenFuelBlock("cherry_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SLAB)), true);
    public static final DeferredBlock<Block> PALE_OAK_MOSAIC_SLAB = registryWoodenFuelBlock("pale_oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.QUARTZ)), true);
    public static final DeferredBlock<Block> CRIMSON_MOSAIC_SLAB = registryBlock("crimson_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));
    public static final DeferredBlock<Block> WARPED_MOSAIC_SLAB = registryBlock("warped_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SLAB)));
    //Pillar Planks
    public static final DeferredBlock<Block> OAK_PILLAR = registryWoodenFuelBlock("oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_PILLAR = registryWoodenFuelBlock("spruce_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_PILLAR = registryWoodenFuelBlock("birch_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_PILLAR = registryWoodenFuelBlock("jungle_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_PILLAR = registryWoodenFuelBlock("acacia_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_PILLAR = registryWoodenFuelBlock("dark_oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_PILLAR = registryWoodenFuelBlock("mangrove_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_PILLAR = registryWoodenFuelBlock("cherry_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> PALE_OAK_PILLAR = registryWoodenFuelBlock("pale_oak_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> CRIMSON_PILLAR = registryBlock("crimson_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_PILLAR = registryBlock("warped_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
    public static final DeferredBlock<Block> BAMBOO_PILLAR = registryWoodenFuelBlock("bamboo_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));
    //Log Bundle
    public static final DeferredBlock<Block> OAK_LOG_BUNDLE = registryWoodenFuelBlock("oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> SPRUCE_LOG_BUNDLE = registryWoodenFuelBlock("spruce_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)));
    public static final DeferredBlock<Block> BIRCH_LOG_BUNDLE = registryWoodenFuelBlock("birch_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LOG)));
    public static final DeferredBlock<Block> JUNGLE_LOG_BUNDLE = registryWoodenFuelBlock("jungle_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));
    public static final DeferredBlock<Block> ACACIA_LOG_BUNDLE = registryWoodenFuelBlock("acacia_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)));
    public static final DeferredBlock<Block> DARK_OAK_LOG_BUNDLE = registryWoodenFuelBlock("dark_oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LOG)));
    public static final DeferredBlock<Block> MANGROVE_LOG_BUNDLE = registryWoodenFuelBlock("mangrove_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG)));
    public static final DeferredBlock<Block> CHERRY_LOG_BUNDLE = registryWoodenFuelBlock("cherry_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LOG)));
    public static final DeferredBlock<Block> PALE_OAK_LOG_BUNDLE = registryWoodenFuelBlock("pale_oak_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.QUARTZ : MapColor.METAL)));
    public static final DeferredBlock<Block> CRIMSON_STEM_BUNDLE = registryBlock("crimson_stem_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM), false));
    public static final DeferredBlock<Block> WARPED_STEM_BUNDLE = registryBlock("warped_stem_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM), false));
    public static final DeferredBlock<Block> BAMBOO_BUNDLE = registryWoodenFuelBlock("bamboo_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_BLOCK)));

    public static final DeferredBlock<Block> STRIPPED_OAK_LOG_BUNDLE = registryWoodenFuelBlock("stripped_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_spruce_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_LOG_BUNDLE = registryWoodenFuelBlock("stripped_birch_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_jungle_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_LOG_BUNDLE = registryWoodenFuelBlock("stripped_acacia_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_LOG_BUNDLE = registryWoodenFuelBlock("stripped_dark_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_mangrove_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_LOG)));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_LOG_BUNDLE = registryWoodenFuelBlock("stripped_cherry_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PALE_OAK_LOG_BUNDLE = registryWoodenFuelBlock("stripped_pale_oak_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_STEM_BUNDLE = registryBlock("stripped_crimson_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final DeferredBlock<Block> STRIPPED_WARPED_STEM_BUNDLE = registryBlock("stripped_warped_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final DeferredBlock<Block> STRIPPED_BAMBOO_BUNDLE = registryWoodenFuelBlock("stripped_bamboo_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK)));

    //public static final List<DeferredBlock<?>> BIRCH_WOOD_SET = registerWoodSet(
    //        "ok",
    //        "your_mod_id",
    //        true,
    //        true,
    //        false,
    //        MapColor.SAND,
    //        MapColor.SAND,
    //        MapColor.SAND
    //);

    private static List<DeferredBlock<?>> registerWoodSet(String woodName, String modID, boolean isFlammable, boolean isBamboo, boolean withAbnormalsBlocksCompat, MapColor woodColor, MapColor barkColor, MapColor craftingTableTopColor) {
        List<DeferredBlock<?>> woodenBlocks = new ArrayList<>();
        Block planks = CarvedWood.getBlockFromString(modID,woodName + "_planks");
        Block stairs = CarvedWood.getBlockFromString(modID,woodName + "_stairs");
        Block slab = CarvedWood.getBlockFromString(modID,woodName + "_slab");
        Block log = CarvedWood.getBlockFromString(modID,woodName + "_log");
        Block strippedLog = CarvedWood.getBlockFromString(modID,"stripped_" + woodName + "_log");
        Block BambooBlock = CarvedWood.getBlockFromString(modID,woodName + "_block");
        Block strippedBambooBlock = CarvedWood.getBlockFromString(modID,"stripped_" + woodName + "_block");
        if (!withAbnormalsBlocksCompat) {
            // Chest
            woodenBlocks.add(registryChestBlock(woodName + "_chest", () -> new CWChestBlock(woodName, BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f)), false, isFlammable));
            // Trapped Chest
            woodenBlocks.add(registryChestBlock("trapped_" + woodName + "_chest", () -> new CWTrappedChestBlock(woodName, BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f)), true, isFlammable));
            // Ladder
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER))));
            // Bookshelf
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(1.5F))));
            // Chiseled Bookshelf
            woodenBlocks.add(registryWoodenFuelBlock("chiseled_" + woodName + "_bookshelf", () -> new CWChiseledBookShelfBlockType2(BlockBehaviour.Properties.ofFullCopy(planks).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF))));
            // Beehive
            woodenBlocks.add(registryBlock(woodName + "_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(0.6F))));
        }
        
        // Crafting Table
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(planks).mapColor(craftingTableTopColor).strength(2.5f))));
        // Crafter
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_crafter", () -> new CWCrafterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTER))));
        // Barrel
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5f))));
        // Campfire
        woodenBlocks.add(registryBlock(woodName + "_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(woodColor))));
        // Soul Campfire
        woodenBlocks.add(registryBlock("soul_" + woodName + "_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE).mapColor(woodColor))));
        // Lectern
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.ofFullCopy(planks).strength(2.5F))));
         // Carved Planks
        woodenBlocks.add(registryWoodenFuelBlock("carved_" + woodName + "_planks", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Panels
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_panels", () -> new BigBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Boards
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Smooth Wooden Boards
        woodenBlocks.add(registryWoodenFuelBlock("smooth_" + woodName + "_boards", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        // Wooden Lantern
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_lantern", () -> new WoodenLantern(BlockBehaviour.Properties.ofFullCopy(planks).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15)))));
        // Wooden Lantern Block
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_lantern_block", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks).lightLevel(lightValue(15)), isFlammable)));
        // Wooden Tiles
        DeferredBlock<Block> tilesBlock = registryWoodenFuelBlock(woodName + "_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable));
        woodenBlocks.add(tilesBlock);
        // Wooden Tile Stairs
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_tile_stairs", () -> new PlanksStairBlock(tilesBlock.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(stairs), isFlammable)));
        // Wooden Tile Slabs
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(slab), isFlammable), true));
        // Pillar Planks
        woodenBlocks.add(registryWoodenFuelBlock(woodName + "_pillar", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable)));
        if (!isBamboo) {
            // Wooden Mosaic
            DeferredBlock<Block> mosaicBlock = registryWoodenFuelBlock(woodName + "_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.ofFullCopy(planks), isFlammable));
            woodenBlocks.add(mosaicBlock);
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_mosaic_stairs", () -> new PlanksStairBlock(mosaicBlock.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(stairs), isFlammable)));
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.ofFullCopy(slab), isFlammable), true));
            // Log Bundle
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_log_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(log), isFlammable)));
            // Stripped Log Bundle
            woodenBlocks.add(registryWoodenFuelBlock("stripped_" + woodName + "_log_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(strippedLog), isFlammable)));
        } else {
            // Bundle
            woodenBlocks.add(registryWoodenFuelBlock(woodName + "_bundle", () -> new StrippableLogBlock(BlockBehaviour.Properties.ofFullCopy(BambooBlock), isFlammable)));
            //Stripped Bundle
            woodenBlocks.add(registryWoodenFuelBlock("stripped_" + woodName + "_bundle", () -> new LogBlock(BlockBehaviour.Properties.ofFullCopy(strippedBambooBlock), isFlammable)));
        }
        return woodenBlocks;
    }





    private static ToIntFunction<BlockState> lightValue(int pLightValue) {
        return (blockState) -> pLightValue;
    }

    private static <T extends Block> DeferredBlock<T> registryBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    };

    private static <T extends Block> DeferredBlock<T>registryWoodenFuelBlock(String name, Supplier<T> block) {
        return registryWoodenFuelBlock(name, block, false);
    };

    private static <T extends Block> DeferredBlock<T>registryWoodenFuelBlock(String name, Supplier<T> block, Boolean isSlab) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registryFuelBlockItem(name, toReturn, 300 / (isSlab ? 2 : 1));
        return toReturn;
    };

    private static <T extends Block> DeferredBlock<T>registryChestBlock(String name, Supplier<T> block, Boolean isTrapped, Boolean isFuel) {
        int burnTime = isFuel ? 300 : 0;
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerChestBlockItem(name, toReturn, isTrapped , burnTime);
        return toReturn;
    };

    private static <T extends Block> void registerChestBlockItem(String name, DeferredBlock<T> block, Boolean isTrapped, int burnTime){
        CWItems.ITEMS.register(name, () -> new ChestBlockItem(block.get(), new Item.Properties(), isTrapped, burnTime));
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        CWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> void registryFuelBlockItem(String name, DeferredBlock<T> block, int burnTime){
        CWItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), burnTime));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void  registerModBlocks() {
        CarvedWood.LOGGER.info("Registering Mod Blocks for " + CarvedWood.MOD_ID);
    }

}