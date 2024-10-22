package net.im_maker.carved_wood.common.block;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.*;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.*;
import net.im_maker.carved_wood.common.item.CWItems;
import net.im_maker.carved_wood.common.item.custom.ChestBlockItem;
import net.im_maker.carved_wood.common.item.custom.FuelBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CWBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CarvedWood.MOD_ID);
    //Crafting Tables
    public static final RegistryObject<Block> SPRUCE_CRAFTING_TABLE = registryWoodenFuelBlock("spruce_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> BIRCH_CRAFTING_TABLE = registryWoodenFuelBlock("birch_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> JUNGLE_CRAFTING_TABLE = registryWoodenFuelBlock("jungle_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> ACACIA_CRAFTING_TABLE = registryWoodenFuelBlock("acacia_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> DARK_OAK_CRAFTING_TABLE = registryWoodenFuelBlock("dark_oak_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> MANGROVE_CRAFTING_TABLE = registryWoodenFuelBlock("mangrove_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> CHERRY_CRAFTING_TABLE = registryWoodenFuelBlock("cherry_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> CRIMSON_CRAFTING_TABLE = registryBlock("crimson_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> WARPED_CRAFTING_TABLE = registryBlock("warped_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> BAMBOO_CRAFTING_TABLE = registryWoodenFuelBlock("bamboo_crafting_table", () -> new CWCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(2.5f)));
    //Ladders
    public static final RegistryObject<Block> SPRUCE_LADDER = registryWoodenFuelBlock("spruce_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> BIRCH_LADDER = registryWoodenFuelBlock("birch_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> JUNGLE_LADDER = registryWoodenFuelBlock("jungle_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> ACACIA_LADDER = registryWoodenFuelBlock("acacia_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> DARK_OAK_LADDER = registryWoodenFuelBlock("dark_oak_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> MANGROVE_LADDER = registryWoodenFuelBlock("mangrove_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> CHERRY_LADDER = registryWoodenFuelBlock("cherry_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> CRIMSON_LADDER = registryBlock("crimson_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> WARPED_LADDER = registryBlock("warped_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    public static final RegistryObject<Block> BAMBOO_LADDER = registryWoodenFuelBlock("bamboo_ladder", () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER)));
    //Chests (Normal/Trapped)
    public static final RegistryObject<Block> OAK_CHEST = registryChestBlock("oak_chest", () -> new CWChestBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> SPRUCE_CHEST = registryChestBlock("spruce_chest", () -> new CWChestBlock("spruce", BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> BIRCH_CHEST = registryChestBlock("birch_chest", () -> new CWChestBlock("birch", BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> JUNGLE_CHEST = registryChestBlock("jungle_chest", () -> new CWChestBlock("jungle", BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> ACACIA_CHEST = registryChestBlock("acacia_chest", () -> new CWChestBlock("acacia", BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> DARK_OAK_CHEST = registryChestBlock("dark_oak_chest", () -> new CWChestBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> MANGROVE_CHEST = registryChestBlock("mangrove_chest", () -> new CWChestBlock("mangrove", BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> CHERRY_CHEST = registryChestBlock("cherry_chest", () -> new CWChestBlock("cherry", BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> CRIMSON_CHEST = registryChestBlock("crimson_chest", () -> new CWChestBlock("crimson", BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(2.5f)), false, false);
    public static final RegistryObject<Block> WARPED_CHEST = registryChestBlock("warped_chest", () -> new CWChestBlock("warped", BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(2.5f)), false, false);
    public static final RegistryObject<Block> BAMBOO_CHEST = registryChestBlock("bamboo_chest", () -> new CWChestBlock("bamboo", BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(2.5f)), false, true);
    public static final RegistryObject<Block> TRAPPED_OAK_CHEST = registryChestBlock("trapped_oak_chest", () -> new CWTrappedChestBlock("oak", BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_SPRUCE_CHEST = registryChestBlock("trapped_spruce_chest", () -> new CWTrappedChestBlock("spruce", BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_BIRCH_CHEST = registryChestBlock("trapped_birch_chest", () -> new CWTrappedChestBlock("birch", BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_JUNGLE_CHEST = registryChestBlock("trapped_jungle_chest", () -> new CWTrappedChestBlock("jungle", BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_ACACIA_CHEST = registryChestBlock("trapped_acacia_chest", () -> new CWTrappedChestBlock("acacia", BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_DARK_OAK_CHEST = registryChestBlock("trapped_dark_oak_chest", () -> new CWTrappedChestBlock("dark_oak", BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_MANGROVE_CHEST = registryChestBlock("trapped_mangrove_chest", () -> new CWTrappedChestBlock("mangrove", BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_CHERRY_CHEST = registryChestBlock("trapped_cherry_chest", () -> new CWTrappedChestBlock("cherry", BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(2.5f)), true, true);
    public static final RegistryObject<Block> TRAPPED_CRIMSON_CHEST = registryChestBlock("trapped_crimson_chest", () -> new CWTrappedChestBlock("crimson", BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(2.5f)), true, false);
    public static final RegistryObject<Block> TRAPPED_WARPED_CHEST = registryChestBlock("trapped_warped_chest", () -> new CWTrappedChestBlock("warped", BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(2.5f)), true, false);
    public static final RegistryObject<Block> TRAPPED_BAMBOO_CHEST = registryChestBlock("trapped_bamboo_chest", () -> new CWTrappedChestBlock("bamboo", BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(2.5f)), true, true);
    //Barrels
    public static final RegistryObject<Block> OAK_BARREL = registryWoodenFuelBlock("oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> BIRCH_BARREL = registryWoodenFuelBlock("birch_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> JUNGLE_BARREL = registryWoodenFuelBlock("jungle_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> ACACIA_BARREL = registryWoodenFuelBlock("acacia_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> DARK_OAK_BARREL = registryWoodenFuelBlock("dark_oak_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> MANGROVE_BARREL = registryWoodenFuelBlock("mangrove_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> CHERRY_BARREL = registryWoodenFuelBlock("cherry_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> CRIMSON_BARREL = registryBlock("crimson_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> WARPED_BARREL = registryBlock("warped_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(2.5f)));
    public static final RegistryObject<Block> BAMBOO_BARREL = registryWoodenFuelBlock("bamboo_barrel", () -> new CWBarrelBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(2.5f)));
    //Campfires (Normal/Soul)
    public static final RegistryObject<Block> SPRUCE_CAMPFIRE = registryBlock("spruce_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BIRCH_CAMPFIRE = registryBlock("birch_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<Block> JUNGLE_CAMPFIRE = registryBlock("jungle_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final RegistryObject<Block> ACACIA_CAMPFIRE = registryBlock("acacia_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> DARK_OAK_CAMPFIRE = registryBlock("dark_oak_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> MANGROVE_CAMPFIRE = registryBlock("mangrove_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final RegistryObject<Block> CHERRY_CAMPFIRE = registryBlock("cherry_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> CRIMSON_CAMPFIRE = registryBlock("crimson_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final RegistryObject<Block> BAMBOO_CAMPFIRE = registryBlock("bamboo_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    public static final RegistryObject<Block> WARPED_CAMPFIRE = registryBlock("warped_campfire", () -> new CWCampfireBlock(false, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final RegistryObject<Block> SOUL_SPRUCE_CAMPFIRE = registryBlock("soul_spruce_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> SOUL_BIRCH_CAMPFIRE = registryBlock("soul_birch_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<Block> SOUL_JUNGLE_CAMPFIRE = registryBlock("soul_jungle_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final RegistryObject<Block> SOUL_ACACIA_CAMPFIRE = registryBlock("soul_acacia_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> SOUL_DARK_OAK_CAMPFIRE = registryBlock("soul_dark_oak_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> SOUL_MANGROVE_CAMPFIRE = registryBlock("soul_mangrove_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PODZOL)));
    public static final RegistryObject<Block> SOUL_CHERRY_CAMPFIRE = registryBlock("soul_cherry_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final RegistryObject<Block> SOUL_CRIMSON_CAMPFIRE = registryBlock("soul_crimson_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.CRIMSON_STEM)));
    public static final RegistryObject<Block> SOUL_WARPED_CAMPFIRE = registryBlock("soul_warped_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.WARPED_STEM)));
    public static final RegistryObject<Block> SOUL_BAMBOO_CAMPFIRE = registryBlock("soul_bamboo_campfire", () -> new CWCampfireBlock(true, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE).mapColor(MapColor.PLANT)));
    //Bookshelves
    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = registryWoodenFuelBlock("spruce_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = registryWoodenFuelBlock("birch_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = registryWoodenFuelBlock("jungle_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = registryWoodenFuelBlock("acacia_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = registryWoodenFuelBlock("dark_oak_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> MANGROVE_BOOKSHELF = registryWoodenFuelBlock("mangrove_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> CHERRY_BOOKSHELF = registryWoodenFuelBlock("cherry_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = registryBlock("crimson_bookshelf", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = registryBlock("warped_bookshelf", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(1.5F)));
    public static final RegistryObject<Block> BAMBOO_BOOKSHELF = registryWoodenFuelBlock("bamboo_bookshelf", () -> new BookshelfBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(1.5F)));
    //Chiseled Bookshelves
    public static final RegistryObject<Block> CHISELED_SPRUCE_BOOKSHELF = registryWoodenFuelBlock("chiseled_spruce_bookshelf", () -> new CWChiseledBookShelfBlockType1(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_BIRCH_BOOKSHELF = registryWoodenFuelBlock("chiseled_birch_bookshelf", () -> new CWChiseledBookShelfBlockType2(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_JUNGLE_BOOKSHELF = registryWoodenFuelBlock("chiseled_jungle_bookshelf", () -> new CWChiseledBookShelfBlockType5(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_ACACIA_BOOKSHELF = registryWoodenFuelBlock("chiseled_acacia_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_DARK_OAK_BOOKSHELF = registryWoodenFuelBlock("chiseled_dark_oak_bookshelf", () -> new CWChiseledBookShelfBlockType3(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_MANGROVE_BOOKSHELF = registryWoodenFuelBlock("chiseled_mangrove_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_CHERRY_BOOKSHELF = registryWoodenFuelBlock("chiseled_cherry_bookshelf", () -> new CWChiseledBookShelfBlockType7(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_CRIMSON_BOOKSHELF = registryBlock("chiseled_crimson_bookshelf", () -> new CWChiseledBookShelfBlockType4(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_WARPED_BOOKSHELF = registryBlock("chiseled_warped_bookshelf", () -> new CWChiseledBookShelfBlockType6(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    public static final RegistryObject<Block> CHISELED_BAMBOO_BOOKSHELF = registryWoodenFuelBlock("chiseled_bamboo_bookshelf", () -> new CWChiseledBookShelfBlockType8(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF)));
    //Lecterns
    public static final RegistryObject<Block> SPRUCE_LECTERN = registryWoodenFuelBlock("spruce_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> BIRCH_LECTERN = registryWoodenFuelBlock("birch_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> JUNGLE_LECTERN = registryWoodenFuelBlock("jungle_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> ACACIA_LECTERN = registryWoodenFuelBlock("acacia_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> DARK_OAK_LECTERN = registryWoodenFuelBlock("dark_oak_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> MANGROVE_LECTERN = registryWoodenFuelBlock("mangrove_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> CHERRY_LECTERN = registryWoodenFuelBlock("cherry_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(2.5F)));
    public static final RegistryObject<Block> CRIMSON_LECTERN = registryBlock("crimson_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(2.5F), false));
    public static final RegistryObject<Block> WARPED_LECTERN = registryBlock("warped_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(2.5F), false));
    public static final RegistryObject<Block> BAMBOO_LECTERN = registryWoodenFuelBlock("bamboo_lectern", () -> new CWLecternBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(2.5F)));
    //Beehives
    public static final RegistryObject<Block> SPRUCE_BEEHIVE = registryBlock("spruce_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> BIRCH_BEEHIVE = registryBlock("birch_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> JUNGLE_BEEHIVE = registryBlock("jungle_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> ACACIA_BEEHIVE = registryBlock("acacia_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> DARK_OAK_BEEHIVE = registryBlock("dark_oak_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> MANGROVE_BEEHIVE = registryBlock("mangrove_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> CHERRY_BEEHIVE = registryBlock("cherry_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).strength(0.6F)));
    public static final RegistryObject<Block> CRIMSON_BEEHIVE = registryBlock("crimson_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).strength(0.6F), false));
    public static final RegistryObject<Block> WARPED_BEEHIVE = registryBlock("warped_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).strength(0.6F), false));
    public static final RegistryObject<Block> BAMBOO_BEEHIVE = registryBlock("bamboo_beehive", () -> new CWBeehiveBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).strength(0.6F)));
    //Carved Planks
    public static final RegistryObject<Block> CARVED_OAK_PLANKS = registryWoodenFuelBlock("carved_oak_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CARVED_SPRUCE_PLANKS = registryWoodenFuelBlock("carved_spruce_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> CARVED_BIRCH_PLANKS = registryWoodenFuelBlock("carved_birch_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> CARVED_JUNGLE_PLANKS = registryWoodenFuelBlock("carved_jungle_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> CARVED_ACACIA_PLANKS = registryWoodenFuelBlock("carved_acacia_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> CARVED_DARK_OAK_PLANKS = registryWoodenFuelBlock("carved_dark_oak_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> CARVED_MANGROVE_PLANKS = registryWoodenFuelBlock("carved_mangrove_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CARVED_CHERRY_PLANKS = registryWoodenFuelBlock("carved_cherry_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CARVED_CRIMSON_PLANKS = registryBlock("carved_crimson_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> CARVED_WARPED_PLANKS = registryBlock("carved_warped_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> CARVED_BAMBOO_PLANKS = registryWoodenFuelBlock("carved_bamboo_planks", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    //Smooth Wooden Boards
    public static final RegistryObject<Block> SMOOTH_OAK_BOARDS = registryWoodenFuelBlock("smooth_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_SPRUCE_BOARDS = registryWoodenFuelBlock("smooth_spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_BIRCH_BOARDS = registryWoodenFuelBlock("smooth_birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_JUNGLE_BOARDS = registryWoodenFuelBlock("smooth_jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_ACACIA_BOARDS = registryWoodenFuelBlock("smooth_acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_DARK_OAK_BOARDS = registryWoodenFuelBlock("smooth_dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_MANGROVE_BOARDS = registryWoodenFuelBlock("smooth_mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_CHERRY_BOARDS = registryWoodenFuelBlock("smooth_cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_CRIMSON_BOARDS = registryBlock("smooth_crimson_boards", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_WARPED_BOARDS = registryBlock("smooth_warped_boards", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> SMOOTH_BAMBOO_BOARDS = registryWoodenFuelBlock("smooth_bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    //Wooden Boards
    public static final RegistryObject<Block> OAK_BOARDS = registryWoodenFuelBlock("oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_BOARDS = registryWoodenFuelBlock("spruce_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_BOARDS = registryWoodenFuelBlock("birch_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_BOARDS = registryWoodenFuelBlock("jungle_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_BOARDS = registryWoodenFuelBlock("acacia_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_BOARDS = registryWoodenFuelBlock("dark_oak_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_BOARDS = registryWoodenFuelBlock("mangrove_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CHERRY_BOARDS = registryWoodenFuelBlock("cherry_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_BOARDS = registryBlock("crimson_boards", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_BOARDS = registryBlock("warped_boards", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> BAMBOO_BOARDS = registryWoodenFuelBlock("bamboo_boards", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    //Wooden Lantern
    public static final RegistryObject<Block> OAK_LANTERN = registryWoodenFuelBlock("oak_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> SPRUCE_LANTERN = registryWoodenFuelBlock("spruce_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> BIRCH_LANTERN = registryWoodenFuelBlock("birch_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> JUNGLE_LANTERN = registryWoodenFuelBlock("jungle_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> ACACIA_LANTERN = registryWoodenFuelBlock("acacia_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> DARK_OAK_LANTERN = registryWoodenFuelBlock("dark_oak_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> MANGROVE_LANTERN = registryWoodenFuelBlock("mangrove_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> CHERRY_LANTERN = registryWoodenFuelBlock("cherry_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> CRIMSON_LANTERN = registryBlock("crimson_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> WARPED_LANTERN = registryBlock("warped_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).lightLevel(lightValue(15))));
    public static final RegistryObject<Block> BAMBOO_LANTERN = registryWoodenFuelBlock("bamboo_lantern", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).lightLevel(lightValue(15))));
    //Wooden Tiles
    public static final RegistryObject<Block> OAK_TILES = registryWoodenFuelBlock("oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_TILES = registryWoodenFuelBlock("spruce_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_TILES = registryWoodenFuelBlock("birch_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_TILES = registryWoodenFuelBlock("jungle_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_TILES = registryWoodenFuelBlock("acacia_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_TILES = registryWoodenFuelBlock("dark_oak_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_TILES = registryWoodenFuelBlock("mangrove_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CHERRY_TILES = registryWoodenFuelBlock("cherry_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_TILES = registryBlock("crimson_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_TILES = registryBlock("warped_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> BAMBOO_TILES = registryWoodenFuelBlock("bamboo_tiles", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    //Wooden Tile Stairs
    public static final RegistryObject<Block> OAK_TILE_STAIRS = registryWoodenFuelBlock("oak_tile_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> SPRUCE_TILE_STAIRS = registryWoodenFuelBlock("spruce_tile_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> BIRCH_TILE_STAIRS = registryWoodenFuelBlock("birch_tile_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)));
    public static final RegistryObject<Block> JUNGLE_TILE_STAIRS = registryWoodenFuelBlock("jungle_tile_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_STAIRS)));
    public static final RegistryObject<Block> ACACIA_TILE_STAIRS = registryWoodenFuelBlock("acacia_tile_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ACACIA_STAIRS)));
    public static final RegistryObject<Block> DARK_OAK_TILE_STAIRS = registryWoodenFuelBlock("dark_oak_tile_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_STAIRS)));
    public static final RegistryObject<Block> MANGROVE_TILE_STAIRS = registryWoodenFuelBlock("mangrove_tile_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MANGROVE_STAIRS)));
    public static final RegistryObject<Block> CHERRY_TILE_STAIRS = registryWoodenFuelBlock("cherry_tile_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CHERRY_STAIRS)));
    public static final RegistryObject<Block> CRIMSON_TILE_STAIRS = registryBlock("crimson_tile_stairs", () -> new StairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_STAIRS)));
    public static final RegistryObject<Block> WARPED_TILE_STAIRS = registryBlock("warped_tile_stairs", () -> new StairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WARPED_STAIRS)));
    public static final RegistryObject<Block> BAMBOO_TILE_STAIRS = registryWoodenFuelBlock("bamboo_tile_stairs", () -> new PlanksStairBlock(BAMBOO_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BAMBOO_STAIRS)));
    //Wooden Tile Slabs
    public static final RegistryObject<Block> OAK_TILE_SLAB = registryWoodenFuelBlock("oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), true);
    public static final RegistryObject<Block> SPRUCE_TILE_SLAB = registryWoodenFuelBlock("spruce_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)), true);
    public static final RegistryObject<Block> BIRCH_TILE_SLAB = registryWoodenFuelBlock("birch_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)), true);
    public static final RegistryObject<Block> JUNGLE_TILE_SLAB = registryWoodenFuelBlock("jungle_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_SLAB)), true);
    public static final RegistryObject<Block> ACACIA_TILE_SLAB = registryWoodenFuelBlock("acacia_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_SLAB)), true);
    public static final RegistryObject<Block> DARK_OAK_TILE_SLAB = registryWoodenFuelBlock("dark_oak_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SLAB)), true);
    public static final RegistryObject<Block> MANGROVE_TILE_SLAB = registryWoodenFuelBlock("mangrove_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_SLAB)), true);
    public static final RegistryObject<Block> CHERRY_TILE_SLAB = registryWoodenFuelBlock("cherry_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_SLAB)), true);
    public static final RegistryObject<Block> CRIMSON_TILE_SLAB = registryBlock("crimson_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB)));
    public static final RegistryObject<Block> WARPED_TILE_SLAB = registryBlock("warped_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_SLAB)));
    public static final RegistryObject<Block> BAMBOO_TILE_SLAB = registryWoodenFuelBlock("bamboo_tile_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_SLAB)), true);
    //Wooden Mosaic
    public static final RegistryObject<Block> OAK_MOSAIC = registryWoodenFuelBlock("oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_MOSAIC = registryWoodenFuelBlock("spruce_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_MOSAIC = registryWoodenFuelBlock("birch_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_MOSAIC = registryWoodenFuelBlock("jungle_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_MOSAIC = registryWoodenFuelBlock("acacia_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_MOSAIC = registryWoodenFuelBlock("dark_oak_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_MOSAIC = registryWoodenFuelBlock("mangrove_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CHERRY_MOSAIC = registryWoodenFuelBlock("cherry_mosaic", () -> new PlanksBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_MOSAIC = registryBlock("crimson_mosaic", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_MOSAIC = registryBlock("warped_mosaic", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    //Wooden Mosaic Stairs
    public static final RegistryObject<Block> OAK_MOSAIC_STAIRS = registryWoodenFuelBlock("oak_mosaic_stairs", () -> new PlanksStairBlock(OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> SPRUCE_MOSAIC_STAIRS = registryWoodenFuelBlock("spruce_mosaic_stairs", () -> new PlanksStairBlock(SPRUCE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> BIRCH_MOSAIC_STAIRS = registryWoodenFuelBlock("birch_mosaic_stairs", () -> new PlanksStairBlock(BIRCH_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.BIRCH_STAIRS)));
    public static final RegistryObject<Block> JUNGLE_MOSAIC_STAIRS = registryWoodenFuelBlock("jungle_mosaic_stairs", () -> new PlanksStairBlock(JUNGLE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_STAIRS)));
    public static final RegistryObject<Block> ACACIA_MOSAIC_STAIRS = registryWoodenFuelBlock("acacia_mosaic_stairs", () -> new PlanksStairBlock(ACACIA_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.ACACIA_STAIRS)));
    public static final RegistryObject<Block> DARK_OAK_MOSAIC_STAIRS = registryWoodenFuelBlock("dark_oak_mosaic_stairs", () -> new PlanksStairBlock(DARK_OAK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DARK_OAK_STAIRS)));
    public static final RegistryObject<Block> MANGROVE_MOSAIC_STAIRS = registryWoodenFuelBlock("mangrove_mosaic_stairs", () -> new PlanksStairBlock(MANGROVE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MANGROVE_STAIRS)));
    public static final RegistryObject<Block> CHERRY_MOSAIC_STAIRS = registryWoodenFuelBlock("cherry_mosaic_stairs", () -> new PlanksStairBlock(CHERRY_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CHERRY_STAIRS)));
    public static final RegistryObject<Block> CRIMSON_MOSAIC_STAIRS = registryBlock("crimson_mosaic_stairs", () -> new StairBlock(CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_STAIRS)));
    public static final RegistryObject<Block> WARPED_MOSAIC_STAIRS = registryBlock("warped_mosaic_stairs", () -> new StairBlock(WARPED_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.WARPED_STAIRS)));
    //Wooden Mosaic Slabs
    public static final RegistryObject<Block> OAK_MOSAIC_SLAB = registryWoodenFuelBlock("oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), true);
    public static final RegistryObject<Block> SPRUCE_MOSAIC_SLAB = registryWoodenFuelBlock("spruce_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)), true);
    public static final RegistryObject<Block> BIRCH_MOSAIC_SLAB = registryWoodenFuelBlock("birch_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_SLAB)), true);
    public static final RegistryObject<Block> JUNGLE_MOSAIC_SLAB = registryWoodenFuelBlock("jungle_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_SLAB)), true);
    public static final RegistryObject<Block> ACACIA_MOSAIC_SLAB = registryWoodenFuelBlock("acacia_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_SLAB)), true);
    public static final RegistryObject<Block> DARK_OAK_MOSAIC_SLAB = registryWoodenFuelBlock("dark_oak_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SLAB)), true);
    public static final RegistryObject<Block> MANGROVE_MOSAIC_SLAB = registryWoodenFuelBlock("mangrove_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_SLAB)), true);
    public static final RegistryObject<Block> CHERRY_MOSAIC_SLAB = registryWoodenFuelBlock("cherry_mosaic_slab", () -> new PlanksSlabBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_SLAB)), true);
    public static final RegistryObject<Block> CRIMSON_MOSAIC_SLAB = registryBlock("crimson_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB)));
    public static final RegistryObject<Block> WARPED_MOSAIC_SLAB = registryBlock("warped_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_SLAB)));
    //Pillar Planks
    public static final RegistryObject<Block> OAK_PILLAR = registryWoodenFuelBlock("oak_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_PILLAR = registryWoodenFuelBlock("spruce_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> BIRCH_PILLAR = registryWoodenFuelBlock("birch_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_PILLAR = registryWoodenFuelBlock("jungle_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ACACIA_PILLAR = registryWoodenFuelBlock("acacia_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_PILLAR = registryWoodenFuelBlock("dark_oak_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_PILLAR = registryWoodenFuelBlock("mangrove_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> CHERRY_PILLAR = registryWoodenFuelBlock("cherry_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_PILLAR = registryBlock("crimson_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> WARPED_PILLAR = registryBlock("warped_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> BAMBOO_PILLAR = registryWoodenFuelBlock("bamboo_pillar", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));
    //Log Bundle
    public static final RegistryObject<Block> OAK_LOG_BUNDLE = registryWoodenFuelBlock("oak_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> SPRUCE_LOG_BUNDLE = registryWoodenFuelBlock("spruce_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> BIRCH_LOG_BUNDLE = registryWoodenFuelBlock("birch_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LOG)));
    public static final RegistryObject<Block> JUNGLE_LOG_BUNDLE = registryWoodenFuelBlock("jungle_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> ACACIA_LOG_BUNDLE = registryWoodenFuelBlock("acacia_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LOG)));
    public static final RegistryObject<Block> DARK_OAK_LOG_BUNDLE = registryWoodenFuelBlock("dark_oak_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG)));
    public static final RegistryObject<Block> MANGROVE_LOG_BUNDLE = registryWoodenFuelBlock("mangrove_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LOG)));
    public static final RegistryObject<Block> CHERRY_LOG_BUNDLE = registryWoodenFuelBlock("cherry_log_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_LOG)));
    public static final RegistryObject<Block> CRIMSON_STEM_BUNDLE = registryBlock("crimson_stem_bundle", () -> new StrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> WARPED_STEM_BUNDLE = registryBlock("warped_stem_bundle", () -> new StrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)));
    public static final RegistryObject<Block> BAMBOO_BUNDLE = registryWoodenFuelBlock("bamboo_bundle", () -> new FlammableStrippableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_BLOCK)));

    public static final RegistryObject<Block> STRIPPED_OAK_LOG_BUNDLE = registryWoodenFuelBlock("stripped_oak_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_SPRUCE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_spruce_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> STRIPPED_BIRCH_LOG_BUNDLE = registryWoodenFuelBlock("stripped_birch_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_LOG)));
    public static final RegistryObject<Block> STRIPPED_JUNGLE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_jungle_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_ACACIA_LOG_BUNDLE = registryWoodenFuelBlock("stripped_acacia_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_ACACIA_LOG)));
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_LOG_BUNDLE = registryWoodenFuelBlock("stripped_dark_oak_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MANGROVE_LOG_BUNDLE = registryWoodenFuelBlock("stripped_mangrove_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_MANGROVE_LOG)));
    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG_BUNDLE = registryWoodenFuelBlock("stripped_cherry_log_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CHERRY_LOG)));
    public static final RegistryObject<Block> STRIPPED_CRIMSON_STEM_BUNDLE = registryBlock("stripped_crimson_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final RegistryObject<Block> STRIPPED_WARPED_STEM_BUNDLE = registryBlock("stripped_warped_stem_bundle", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)));
    public static final RegistryObject<Block> STRIPPED_BAMBOO_BUNDLE = registryWoodenFuelBlock("stripped_bamboo_bundle", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BAMBOO_BLOCK)));

    private static ToIntFunction<BlockState> lightValue(int pLightValue) {
        return (p_50763_) -> pLightValue;
    }

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    };

    private static <T extends Block> RegistryObject<T> registryWoodenFuelBlock(String name, Supplier<T> block) {
        return registryWoodenFuelBlock(name, block, false);
    };

    private static <T extends Block> RegistryObject<T> registryWoodenFuelBlock(String name, Supplier<T> block, Boolean isSlab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryFuelBlockItem(name, toReturn, 300 / (isSlab ? 2 : 1));
        return toReturn;
    };

    private static <T extends Block> RegistryObject<T> registryChestBlock(String name, Supplier<T> block, Boolean isTrapped, Boolean isFuel) {
        int burnTime = isFuel ? 300 : 0;
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerChestBlockItem(name, toReturn, isTrapped , burnTime);
        return toReturn;
    };

    private static <T extends Block>  RegistryObject<Item> registerChestBlockItem(String name, RegistryObject<T> block, Boolean isTrapped, int burnTime){
        return CWItems.ITEMS.register(name, () -> new ChestBlockItem(block.get(), new Item.Properties(), isTrapped, burnTime));
    }

    private static <T extends Block>  RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return CWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block>  RegistryObject<Item> registryFuelBlockItem(String name, RegistryObject<T> block, int burnTime){
        return CWItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), burnTime));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}