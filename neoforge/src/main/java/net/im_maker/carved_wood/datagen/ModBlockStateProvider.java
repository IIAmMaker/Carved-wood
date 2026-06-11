package net.im_maker.carved_wood.datagen;

import com.blackgear.vanillabackport.common.registries.ModBlocks;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.*;
import net.im_maker.carved_wood.common.registers.CWBlocksNeoForge;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.common.block.block_values.WoodenLanternShape;
import net.minecraft.core.Direction;
import net.minecraft.core.FrontAndTop;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ModBlockStateProvider<T> extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarvedWood.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        woodenPanelsBlock(CWBlocks.OAK_PANELS.get());
        woodenPanelsBlock(CWBlocks.SPRUCE_PANELS.get());
        woodenPanelsBlock(CWBlocks.BIRCH_PANELS.get());
        woodenPanelsBlock(CWBlocks.JUNGLE_PANELS.get());
        woodenPanelsBlock(CWBlocks.ACACIA_PANELS.get());
        woodenPanelsBlock(CWBlocks.DARK_OAK_PANELS.get());
        woodenPanelsBlock(CWBlocks.MANGROVE_PANELS.get());
        woodenPanelsBlock(CWBlocks.CHERRY_PANELS.get());
        woodenPanelsBlock(CWBlocks.PALE_OAK_PANELS.get());
        woodenPanelsBlock(CWBlocks.CRIMSON_PANELS.get());
        woodenPanelsBlock(CWBlocks.WARPED_PANELS.get());
        woodenPanelsBlock(CWBlocks.BAMBOO_PANELS.get());

        crafterBlock(CWBlocks.SPRUCE_CRAFTER.get());
        crafterBlock(CWBlocks.BIRCH_CRAFTER.get());
        crafterBlock(CWBlocks.JUNGLE_CRAFTER.get());
        crafterBlock(CWBlocks.ACACIA_CRAFTER.get());
        crafterBlock(CWBlocks.DARK_OAK_CRAFTER.get());
        crafterBlock(CWBlocks.MANGROVE_CRAFTER.get());
        crafterBlock(CWBlocks.CHERRY_CRAFTER.get());
        crafterBlock(CWBlocks.PALE_OAK_CRAFTER.get());
        crafterBlock(CWBlocks.CRIMSON_CRAFTER.get());
        crafterBlock(CWBlocks.WARPED_CRAFTER.get());
        crafterBlock(CWBlocks.BAMBOO_CRAFTER.get());

        carvedPlankBlock(CWBlocks.CARVED_OAK_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_SPRUCE_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_BIRCH_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_JUNGLE_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_ACACIA_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_DARK_OAK_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_MANGROVE_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_CHERRY_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_PALE_OAK_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_CRIMSON_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_WARPED_PLANKS.get());
        carvedPlankBlock(CWBlocks.CARVED_BAMBOO_PLANKS.get());

        carvedPlankBlock(CWBlocks.OAK_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.SPRUCE_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.BIRCH_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.JUNGLE_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.ACACIA_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.DARK_OAK_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.MANGROVE_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.CHERRY_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.PALE_OAK_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.CRIMSON_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.WARPED_LANTERN_BLOCK.get());
        carvedPlankBlock(CWBlocks.BAMBOO_LANTERN_BLOCK.get());

        blockWithItem(CWBlocks.OAK_BOARDS.get());
        blockWithItem(CWBlocks.SPRUCE_BOARDS.get());
        blockWithItem(CWBlocks.BIRCH_BOARDS.get());
        blockWithItem(CWBlocks.JUNGLE_BOARDS.get());
        blockWithItem(CWBlocks.ACACIA_BOARDS.get());
        blockWithItem(CWBlocks.DARK_OAK_BOARDS.get());
        blockWithItem(CWBlocks.MANGROVE_BOARDS.get());
        blockWithItem(CWBlocks.CHERRY_BOARDS.get());
        blockWithItem(CWBlocks.PALE_OAK_BOARDS.get());
        blockWithItem(CWBlocks.CRIMSON_BOARDS.get());
        blockWithItem(CWBlocks.WARPED_BOARDS.get());
        blockWithItem(CWBlocks.BAMBOO_BOARDS.get());

        blockWithItem(CWBlocks.SMOOTH_OAK_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_SPRUCE_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_BIRCH_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_JUNGLE_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_ACACIA_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_DARK_OAK_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_MANGROVE_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_CHERRY_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_PALE_OAK_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_CRIMSON_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_WARPED_BOARDS.get());
        blockWithItem(CWBlocks.SMOOTH_BAMBOO_BOARDS.get());

        blockWithItem(CWBlocks.OAK_TILES.get());
        blockWithItem(CWBlocks.SPRUCE_TILES.get());
        blockWithItem(CWBlocks.BIRCH_TILES.get());
        blockWithItem(CWBlocks.JUNGLE_TILES.get());
        blockWithItem(CWBlocks.ACACIA_TILES.get());
        blockWithItem(CWBlocks.DARK_OAK_TILES.get());
        blockWithItem(CWBlocks.MANGROVE_TILES.get());
        blockWithItem(CWBlocks.CHERRY_TILES.get());
        blockWithItem(CWBlocks.PALE_OAK_TILES.get());
        blockWithItem(CWBlocks.CRIMSON_TILES.get());
        blockWithItem(CWBlocks.WARPED_TILES.get());
        blockWithItem(CWBlocks.BAMBOO_TILES.get());

        stairsBlock((StairBlock) CWBlocks.OAK_TILE_STAIRS.get(), blockTexture(CWBlocks.OAK_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.SPRUCE_TILE_STAIRS.get(), blockTexture(CWBlocks.SPRUCE_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.BIRCH_TILE_STAIRS.get(), blockTexture(CWBlocks.BIRCH_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.JUNGLE_TILE_STAIRS.get(), blockTexture(CWBlocks.JUNGLE_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.ACACIA_TILE_STAIRS.get(), blockTexture(CWBlocks.ACACIA_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.DARK_OAK_TILE_STAIRS.get(), blockTexture(CWBlocks.DARK_OAK_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.MANGROVE_TILE_STAIRS.get(), blockTexture(CWBlocks.MANGROVE_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.CHERRY_TILE_STAIRS.get(), blockTexture(CWBlocks.CHERRY_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.PALE_OAK_TILE_STAIRS.get(), blockTexture(CWBlocks.PALE_OAK_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.CRIMSON_TILE_STAIRS.get(), blockTexture(CWBlocks.CRIMSON_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.WARPED_TILE_STAIRS.get(), blockTexture(CWBlocks.WARPED_TILES.get()));
        stairsBlock((StairBlock) CWBlocks.BAMBOO_TILE_STAIRS.get(), blockTexture(CWBlocks.BAMBOO_TILES.get()));

        slabBlock((SlabBlock) CWBlocks.OAK_TILE_SLAB.get(), blockTexture(CWBlocks.OAK_TILES.get()), blockTexture(CWBlocks.OAK_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.SPRUCE_TILE_SLAB.get(), blockTexture(CWBlocks.SPRUCE_TILES.get()), blockTexture(CWBlocks.SPRUCE_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.BIRCH_TILE_SLAB.get(), blockTexture(CWBlocks.BIRCH_TILES.get()), blockTexture(CWBlocks.BIRCH_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.JUNGLE_TILE_SLAB.get(), blockTexture(CWBlocks.JUNGLE_TILES.get()), blockTexture(CWBlocks.JUNGLE_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.ACACIA_TILE_SLAB.get(), blockTexture(CWBlocks.ACACIA_TILES.get()), blockTexture(CWBlocks.ACACIA_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.DARK_OAK_TILE_SLAB.get(), blockTexture(CWBlocks.DARK_OAK_TILES.get()), blockTexture(CWBlocks.DARK_OAK_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.MANGROVE_TILE_SLAB.get(), blockTexture(CWBlocks.MANGROVE_TILES.get()), blockTexture(CWBlocks.MANGROVE_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.CHERRY_TILE_SLAB.get(), blockTexture(CWBlocks.CHERRY_TILES.get()), blockTexture(CWBlocks.CHERRY_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.PALE_OAK_TILE_SLAB.get(), blockTexture(CWBlocks.PALE_OAK_TILES.get()), blockTexture(CWBlocks.PALE_OAK_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.CRIMSON_TILE_SLAB.get(), blockTexture(CWBlocks.CRIMSON_TILES.get()), blockTexture(CWBlocks.CRIMSON_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.WARPED_TILE_SLAB.get(), blockTexture(CWBlocks.WARPED_TILES.get()), blockTexture(CWBlocks.WARPED_TILES.get()));
        slabBlock((SlabBlock) CWBlocks.BAMBOO_TILE_SLAB.get(), blockTexture(CWBlocks.BAMBOO_TILES.get()), blockTexture(CWBlocks.BAMBOO_TILES.get()));

        blockWithItem(CWBlocks.OAK_MOSAIC.get());
        blockWithItem(CWBlocks.SPRUCE_MOSAIC.get());
        blockWithItem(CWBlocks.BIRCH_MOSAIC.get());
        blockWithItem(CWBlocks.JUNGLE_MOSAIC.get());
        blockWithItem(CWBlocks.ACACIA_MOSAIC.get());
        blockWithItem(CWBlocks.DARK_OAK_MOSAIC.get());
        blockWithItem(CWBlocks.MANGROVE_MOSAIC.get());
        blockWithItem(CWBlocks.CHERRY_MOSAIC.get());
        blockWithItem(CWBlocks.PALE_OAK_MOSAIC.get());
        blockWithItem(CWBlocks.CRIMSON_MOSAIC.get());
        blockWithItem(CWBlocks.WARPED_MOSAIC.get());

        stairsBlock((StairBlock) CWBlocks.OAK_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.OAK_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.SPRUCE_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.SPRUCE_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.BIRCH_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.BIRCH_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.JUNGLE_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.JUNGLE_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.ACACIA_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.ACACIA_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.DARK_OAK_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.DARK_OAK_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.MANGROVE_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.MANGROVE_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.CHERRY_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.CHERRY_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.PALE_OAK_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.PALE_OAK_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.CRIMSON_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.CRIMSON_MOSAIC.get()));
        stairsBlock((StairBlock) CWBlocks.WARPED_MOSAIC_STAIRS.get(), blockTexture(CWBlocks.WARPED_MOSAIC.get()));

        slabBlock((SlabBlock) CWBlocks.OAK_MOSAIC_SLAB.get(), blockTexture(CWBlocks.OAK_MOSAIC.get()), blockTexture(CWBlocks.OAK_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.SPRUCE_MOSAIC_SLAB.get(), blockTexture(CWBlocks.SPRUCE_MOSAIC.get()), blockTexture(CWBlocks.SPRUCE_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.BIRCH_MOSAIC_SLAB.get(), blockTexture(CWBlocks.BIRCH_MOSAIC.get()), blockTexture(CWBlocks.BIRCH_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.JUNGLE_MOSAIC_SLAB.get(), blockTexture(CWBlocks.JUNGLE_MOSAIC.get()), blockTexture(CWBlocks.JUNGLE_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.ACACIA_MOSAIC_SLAB.get(), blockTexture(CWBlocks.ACACIA_MOSAIC.get()), blockTexture(CWBlocks.ACACIA_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.DARK_OAK_MOSAIC_SLAB.get(), blockTexture(CWBlocks.DARK_OAK_MOSAIC.get()), blockTexture(CWBlocks.DARK_OAK_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.MANGROVE_MOSAIC_SLAB.get(), blockTexture(CWBlocks.MANGROVE_MOSAIC.get()), blockTexture(CWBlocks.MANGROVE_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.CHERRY_MOSAIC_SLAB.get(), blockTexture(CWBlocks.CHERRY_MOSAIC.get()), blockTexture(CWBlocks.CHERRY_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.PALE_OAK_MOSAIC_SLAB.get(), blockTexture(CWBlocks.PALE_OAK_MOSAIC.get()), blockTexture(CWBlocks.PALE_OAK_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.CRIMSON_MOSAIC_SLAB.get(), blockTexture(CWBlocks.CRIMSON_MOSAIC.get()), blockTexture(CWBlocks.CRIMSON_MOSAIC.get()));
        slabBlock((SlabBlock) CWBlocks.WARPED_MOSAIC_SLAB.get(), blockTexture(CWBlocks.WARPED_MOSAIC.get()), blockTexture(CWBlocks.WARPED_MOSAIC.get()));

        woodenPillarBlock((RotatedPillarBlock) CWBlocks.OAK_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.SPRUCE_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.BIRCH_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.JUNGLE_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.ACACIA_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.DARK_OAK_PILLAR.get());
        woodenPillarBlockWithCustomHorizontalTexture((RotatedPillarBlock) CWBlocks.MANGROVE_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.CHERRY_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.PALE_OAK_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.CRIMSON_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.WARPED_PILLAR.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.BAMBOO_PILLAR.get());

        woodenPillarBlock((RotatedPillarBlock) CWBlocks.OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.SPRUCE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.BIRCH_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.JUNGLE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.ACACIA_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.DARK_OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.MANGROVE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.CHERRY_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.PALE_OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.CRIMSON_STEM_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.WARPED_STEM_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.BAMBOO_BUNDLE.get());

        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_SPRUCE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_BIRCH_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_JUNGLE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_ACACIA_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_DARK_OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_MANGROVE_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_CHERRY_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_PALE_OAK_LOG_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_CRIMSON_STEM_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_WARPED_STEM_BUNDLE.get());
        woodenPillarBlock((RotatedPillarBlock) CWBlocks.STRIPPED_BAMBOO_BUNDLE.get());

        craftingTableBlock(CWBlocks.SPRUCE_CRAFTING_TABLE.get(), "spruce");
        craftingTableBlock(CWBlocks.BIRCH_CRAFTING_TABLE.get(), "birch");
        craftingTableBlock(CWBlocks.JUNGLE_CRAFTING_TABLE.get(), "jungle");
        craftingTableBlock(CWBlocks.ACACIA_CRAFTING_TABLE.get(), "acacia");
        craftingTableBlock(CWBlocks.DARK_OAK_CRAFTING_TABLE.get(), "dark_oak");
        craftingTableBlock(CWBlocks.MANGROVE_CRAFTING_TABLE.get(), "mangrove");
        craftingTableBlock(CWBlocks.CHERRY_CRAFTING_TABLE.get(), "cherry");
        craftingTableBlock(CWBlocks.PALE_OAK_CRAFTING_TABLE.get(), "pale_oak");
        craftingTableBlock(CWBlocks.CRIMSON_CRAFTING_TABLE.get(), "crimson");
        craftingTableBlock(CWBlocks.WARPED_CRAFTING_TABLE.get(), "warped");
        craftingTableBlock(CWBlocks.BAMBOO_CRAFTING_TABLE.get(), "bamboo");

        craftingTableBlock(Blocks.CRAFTING_TABLE, "oak");

        ladderBlock((LadderBlock) CWBlocks.SPRUCE_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.BIRCH_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.JUNGLE_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.ACACIA_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.DARK_OAK_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.MANGROVE_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.CHERRY_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.PALE_OAK_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.CRIMSON_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.WARPED_LADDER.get());
        ladderBlock((LadderBlock) CWBlocks.BAMBOO_LADDER.get());

        chestBlock(CWBlocks.OAK_CHEST.get(), "oak");
        chestBlock(CWBlocks.TRAPPED_OAK_CHEST.get(), "oak");
        chestBlock(CWBlocks.SPRUCE_CHEST.get(), "spruce");
        chestBlock(CWBlocks.TRAPPED_SPRUCE_CHEST.get(), "spruce");
        chestBlock(CWBlocks.BIRCH_CHEST.get(), "birch");
        chestBlock(CWBlocks.TRAPPED_BIRCH_CHEST.get(), "birch");
        chestBlock(CWBlocks.JUNGLE_CHEST.get(), "jungle");
        chestBlock(CWBlocks.TRAPPED_JUNGLE_CHEST.get(), "jungle");
        chestBlock(CWBlocks.ACACIA_CHEST.get(), "acacia");
        chestBlock(CWBlocks.TRAPPED_ACACIA_CHEST.get(), "acacia");
        chestBlock(CWBlocks.DARK_OAK_CHEST.get(), "dark_oak");
        chestBlock(CWBlocks.TRAPPED_DARK_OAK_CHEST.get(), "dark_oak");
        chestBlock(CWBlocks.MANGROVE_CHEST.get(), "mangrove");
        chestBlock(CWBlocks.TRAPPED_MANGROVE_CHEST.get(), "mangrove");
        chestBlock(CWBlocks.CHERRY_CHEST.get(), "cherry");
        chestBlock(CWBlocks.TRAPPED_CHERRY_CHEST.get(), "cherry");
        chestBlock(CWBlocks.PALE_OAK_CHEST.get(), "pale_oak");
        chestBlock(CWBlocks.TRAPPED_PALE_OAK_CHEST.get(), "pale_oak");
        chestBlock(CWBlocks.CRIMSON_CHEST.get(), "crimson");
        chestBlock(CWBlocks.TRAPPED_CRIMSON_CHEST.get(), "crimson");
        chestBlock(CWBlocks.WARPED_CHEST.get(), "warped");
        chestBlock(CWBlocks.TRAPPED_WARPED_CHEST.get(), "warped");
        chestBlock(CWBlocks.BAMBOO_CHEST.get(), "bamboo");
        chestBlock(CWBlocks.TRAPPED_BAMBOO_CHEST.get(), "bamboo");

        campfireBlock(CWBlocks.SPRUCE_CAMPFIRE, CWBlocks.SOUL_SPRUCE_CAMPFIRE);
        campfireBlock(CWBlocks.BIRCH_CAMPFIRE, CWBlocks.SOUL_BIRCH_CAMPFIRE);
        campfireBlock(CWBlocks.JUNGLE_CAMPFIRE, CWBlocks.SOUL_JUNGLE_CAMPFIRE);
        campfireBlock(CWBlocks.ACACIA_CAMPFIRE, CWBlocks.SOUL_ACACIA_CAMPFIRE);
        campfireBlock(CWBlocks.DARK_OAK_CAMPFIRE, CWBlocks.SOUL_DARK_OAK_CAMPFIRE);
        campfireBlock(CWBlocks.MANGROVE_CAMPFIRE, CWBlocks.SOUL_MANGROVE_CAMPFIRE);
        campfireBlock(CWBlocks.CHERRY_CAMPFIRE, CWBlocks.SOUL_CHERRY_CAMPFIRE);
        campfireBlock(CWBlocks.PALE_OAK_CAMPFIRE, CWBlocks.SOUL_PALE_OAK_CAMPFIRE);
        campfireBlock(CWBlocks.CRIMSON_CAMPFIRE, CWBlocks.SOUL_CRIMSON_CAMPFIRE);
        campfireBlock(CWBlocks.WARPED_CAMPFIRE, CWBlocks.SOUL_WARPED_CAMPFIRE);
        campfireBlock(CWBlocks.BAMBOO_CAMPFIRE, CWBlocks.SOUL_BAMBOO_CAMPFIRE);

        barrelBlock(CWBlocks.OAK_BARREL);
        barrelBlock(CWBlocks.BIRCH_BARREL);
        barrelBlock(CWBlocks.JUNGLE_BARREL);
        barrelBlock(CWBlocks.ACACIA_BARREL);
        barrelBlock(CWBlocks.DARK_OAK_BARREL);
        barrelBlock(CWBlocks.MANGROVE_BARREL);
        barrelBlock(CWBlocks.CHERRY_BARREL);
        barrelBlock(CWBlocks.PALE_OAK_BARREL);
        barrelBlock(CWBlocks.CRIMSON_BARREL);
        barrelBlock(CWBlocks.WARPED_BARREL);
        barrelBlock(CWBlocks.BAMBOO_BARREL);

        bookshelfBlock(CWBlocks.SPRUCE_BOOKSHELF, "spruce");
        bookshelfBlock(CWBlocks.BIRCH_BOOKSHELF, "birch");
        bookshelfBlock(CWBlocks.JUNGLE_BOOKSHELF, "jungle");
        bookshelfBlock(CWBlocks.ACACIA_BOOKSHELF, "acacia");
        bookshelfBlock(CWBlocks.DARK_OAK_BOOKSHELF, "dark_oak");
        bookshelfBlock(CWBlocks.MANGROVE_BOOKSHELF, "mangrove");
        bookshelfBlock(CWBlocks.CHERRY_BOOKSHELF, "cherry");
        bookshelfBlock(CWBlocks.PALE_OAK_BOOKSHELF, "pale_oak");
        bookshelfBlock(CWBlocks.CRIMSON_BOOKSHELF, "crimson");
        bookshelfBlock(CWBlocks.WARPED_BOOKSHELF, "warped");
        bookshelfBlock(CWBlocks.BAMBOO_BOOKSHELF, "bamboo");

        chiseledBookshelfBlock(CWBlocks.CHISELED_SPRUCE_BOOKSHELF, 1);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_BIRCH_BOOKSHELF, 2);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_JUNGLE_BOOKSHELF, 5);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_ACACIA_BOOKSHELF, 3);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_DARK_OAK_BOOKSHELF, 3);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_MANGROVE_BOOKSHELF, 6);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_CHERRY_BOOKSHELF, 7);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_PALE_OAK_BOOKSHELF, 1);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_CRIMSON_BOOKSHELF, 4);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_WARPED_BOOKSHELF, 6);//
        chiseledBookshelfBlock(CWBlocks.CHISELED_BAMBOO_BOOKSHELF, 8);//

        lecternBlock(CWBlocks.SPRUCE_LECTERN, blockTexture(Blocks.SPRUCE_PLANKS));
        lecternBlock(CWBlocks.BIRCH_LECTERN, blockTexture(Blocks.BIRCH_PLANKS));
        lecternBlock(CWBlocks.JUNGLE_LECTERN, blockTexture(Blocks.JUNGLE_PLANKS));
        lecternBlock(CWBlocks.ACACIA_LECTERN, blockTexture(Blocks.ACACIA_PLANKS));
        lecternBlock(CWBlocks.DARK_OAK_LECTERN, blockTexture(Blocks.DARK_OAK_PLANKS));
        lecternBlock(CWBlocks.MANGROVE_LECTERN, blockTexture(Blocks.MANGROVE_PLANKS));
        lecternBlock(CWBlocks.CHERRY_LECTERN, blockTexture(Blocks.CHERRY_PLANKS));
        lecternBlock(CWBlocks.PALE_OAK_LECTERN, blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        lecternBlock(CWBlocks.CRIMSON_LECTERN, blockTexture(Blocks.CRIMSON_PLANKS));
        lecternBlock(CWBlocks.WARPED_LECTERN, blockTexture(Blocks.WARPED_PLANKS));
        lecternBlock(CWBlocks.BAMBOO_LECTERN, blockTexture(Blocks.BAMBOO_PLANKS));

        lecternBlockC(CWBlocksNeoForge.SPRUCE_LECTERN_CONTROLLER, blockTexture(Blocks.SPRUCE_PLANKS));
        lecternBlockC(CWBlocksNeoForge.BIRCH_LECTERN_CONTROLLER, blockTexture(Blocks.BIRCH_PLANKS));
        lecternBlockC(CWBlocksNeoForge.JUNGLE_LECTERN_CONTROLLER, blockTexture(Blocks.JUNGLE_PLANKS));
        lecternBlockC(CWBlocksNeoForge.ACACIA_LECTERN_CONTROLLER, blockTexture(Blocks.ACACIA_PLANKS));
        lecternBlockC(CWBlocksNeoForge.DARK_OAK_LECTERN_CONTROLLER, blockTexture(Blocks.DARK_OAK_PLANKS));
        lecternBlockC(CWBlocksNeoForge.MANGROVE_LECTERN_CONTROLLER, blockTexture(Blocks.MANGROVE_PLANKS));
        lecternBlockC(CWBlocksNeoForge.CHERRY_LECTERN_CONTROLLER, blockTexture(Blocks.CHERRY_PLANKS));
        lecternBlockC(CWBlocksNeoForge.PALE_OAK_LECTERN_CONTROLLER, blockTexture(ModBlocks.PALE_OAK_PLANKS.get()));
        lecternBlockC(CWBlocksNeoForge.CRIMSON_LECTERN_CONTROLLER, blockTexture(Blocks.CRIMSON_PLANKS));
        lecternBlockC(CWBlocksNeoForge.WARPED_LECTERN_CONTROLLER, blockTexture(Blocks.WARPED_PLANKS));
        lecternBlockC(CWBlocksNeoForge.BAMBOO_LECTERN_CONTROLLER, blockTexture(Blocks.BAMBOO_PLANKS));

        beehiveBlock(CWBlocks.SPRUCE_BEEHIVE);
        beehiveBlock(CWBlocks.BIRCH_BEEHIVE, true);
        beehiveBlock(CWBlocks.JUNGLE_BEEHIVE);
        beehiveBlock(CWBlocks.ACACIA_BEEHIVE);
        beehiveBlock(CWBlocks.DARK_OAK_BEEHIVE);
        beehiveBlock(CWBlocks.MANGROVE_BEEHIVE);
        beehiveBlock(CWBlocks.CHERRY_BEEHIVE);
        beehiveBlock(CWBlocks.PALE_OAK_BEEHIVE);
        beehiveBlock(CWBlocks.CRIMSON_BEEHIVE);
        beehiveBlock(CWBlocks.WARPED_BEEHIVE);
        beehiveBlock(CWBlocks.BAMBOO_BEEHIVE);

        woodenLanternBlock(CWBlocks.OAK_LANTERN.get());
        woodenLanternBlock(CWBlocks.SPRUCE_LANTERN.get());
        woodenLanternBlock(CWBlocks.BIRCH_LANTERN.get());
        woodenLanternBlock(CWBlocks.JUNGLE_LANTERN.get());
        woodenLanternBlock(CWBlocks.ACACIA_LANTERN.get());
        woodenLanternBlock(CWBlocks.DARK_OAK_LANTERN.get());
        woodenLanternBlock(CWBlocks.MANGROVE_LANTERN.get());
        woodenLanternBlock(CWBlocks.CHERRY_LANTERN.get());
        woodenLanternBlock(CWBlocks.PALE_OAK_LANTERN.get());
        woodenLanternBlock(CWBlocks.CRIMSON_LANTERN.get());
        woodenLanternBlock(CWBlocks.WARPED_LANTERN.get());
        woodenLanternBlock(CWBlocks.BAMBOO_LANTERN.get());
    }

    public void beehiveBlock(Supplier<Block> block) {
        beehiveBlock(block.get(), false);
    }

    public void beehiveBlock(Supplier<Block> block, Boolean honeyed) {
        beehiveBlock(block.get(), honeyed);
    }

    public void beehiveBlock(Block block, Boolean honeyed) {
        String honey = honeyed ? "_honey" : "" ;
        beehiveBlock(block,
                models().withExistingParent(name(block), "minecraft:block/orientable_with_bottom")
                        .texture("bottom", "block/" + name(block) + "_end")
                        .texture("front", "block/" + name(block) + "_front")
                        .texture("particle", "block/" + name(block) + "_side")
                        .texture("side", "block/" + name(block) + "_side")
                        .texture("top", "block/" + name(block) + "_end"),
                models().withExistingParent(name(block) + "_honey", "minecraft:block/orientable_with_bottom")
                        .texture("bottom", "block/" + name(block) + "_end" + honey)
                        .texture("front", "block/" + name(block) + "_front_honey")
                        .texture("particle", "block/" + name(block) + "_side" + honey)
                        .texture("side", "block/" + name(block) + "_side" + honey)
                        .texture("top", "block/" + name(block) + "_end" + honey));
    }


    public void beehiveBlock(Block block, ModelFile normal, ModelFile honey) {
        getVariantBuilder(block)
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 0)
                .modelForState().modelFile(normal).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 1)
                .modelForState().modelFile(normal).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 2)
                .modelForState().modelFile(normal).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 3)
                .modelForState().modelFile(normal).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 4)
                .modelForState().modelFile(normal).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.EAST).with(BeehiveBlock.HONEY_LEVEL, 5)
                .modelForState().modelFile(honey).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 0)
                .modelForState().modelFile(normal).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 1)
                .modelForState().modelFile(normal).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 2)
                .modelForState().modelFile(normal).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 3)
                .modelForState().modelFile(normal).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 4)
                .modelForState().modelFile(normal).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH).with(BeehiveBlock.HONEY_LEVEL, 5)
                .modelForState().modelFile(honey).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 0)
                .modelForState().modelFile(normal).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 1)
                .modelForState().modelFile(normal).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 2)
                .modelForState().modelFile(normal).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 3)
                .modelForState().modelFile(normal).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 4)
                .modelForState().modelFile(normal).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH).with(BeehiveBlock.HONEY_LEVEL, 5)
                .modelForState().modelFile(honey).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 0)
                .modelForState().modelFile(normal).rotationY(270).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 1)
                .modelForState().modelFile(normal).rotationY(270).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 2)
                .modelForState().modelFile(normal).rotationY(270).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 3)
                .modelForState().modelFile(normal).rotationY(270).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 4)
                .modelForState().modelFile(normal).rotationY(270).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST).with(BeehiveBlock.HONEY_LEVEL, 5)
                .modelForState().modelFile(honey).rotationY(270).addModel();
    }

    public void chiseledBookshelfBlock(Supplier<Block> block, int type) {
        chiseledBookshelfBlock(block.get(), type);
    }

    public void chiseledBookshelfBlock(Block block, int type) {
        chiseledBookshelfBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_chiseled_bookshelf")
                        .texture("top", "block/" + name(block) + "_top")
                        .texture("side", "block/" + name(block) + "_side")
                        .texture("particle", "block/" + name(block) + "_top"),
                models().withExistingParent("block/" + name(block) + "_occupied_top_left", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_left_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_top_left", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_left_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent("block/" + name(block) + "_occupied_top_mid", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_mid_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_top_mid", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_mid_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent("block/" + name(block) + "_occupied_top_right", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_right_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_top_right", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_top_right_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent("block/" + name(block) + "_occupied_bottom_left", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_left_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_bottom_left", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_left_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent("block/" + name(block) + "_occupied_bottom_mid", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_mid_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_bottom_mid", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_mid_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent("block/" + name(block) + "_occupied_bottom_right", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_right_type" + type)
                        .texture("texture", "block/" + name(block) + "_occupied"),
                models().withExistingParent("block/" + name(block) + "_empty_bottom_right", "carved_wood:block/chiseled_bookshelf/type" + type + "/template_chiseled_bookshelf_slot_bottom_right_type" + type)
                        .texture("texture", "block/" + name(block) + "_empty"),
                models().withExistingParent(name(block) + "_inventory", "carved_wood:block/template_chiseled_bookshelf_inventory")
                        .texture("top", "block/" + name(block) + "_top")
                        .texture("side", "block/" + name(block) + "_side")
                        .texture("front", "block/" + name(block) + "_empty")
                        .texture("particle", "block/" + name(block) + "_top"));
    }
    public void chiseledBookshelfBlock(Block block, ModelFile CB, ModelFile occupied_top_left, ModelFile empty_top_left, ModelFile occupied_top_mid, ModelFile empty_top_mid, ModelFile occupied_top_right, ModelFile empty_top_right, ModelFile occupied_bottom_left, ModelFile empty_bottom_left, ModelFile occupied_bottom_mid, ModelFile empty_bottom_mid, ModelFile occupied_bottom_right, ModelFile empty_bottom_right, ModelFile inventory) {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);
        ConfiguredModel.builder().modelFile(inventory).build();
        Direction SOUTH = Direction.SOUTH;
        Direction NORTH = Direction.NORTH;
        Direction EAST = Direction.EAST;
        Direction WEST = Direction.WEST;
        chiseledBookshelfBlock(builder, SOUTH, CB,  occupied_top_left,  empty_top_left,  occupied_top_mid,  empty_top_mid,  occupied_top_right,  empty_top_right,  occupied_bottom_left,  empty_bottom_left,  occupied_bottom_mid,  empty_bottom_mid,  occupied_bottom_right,  empty_bottom_right);
        chiseledBookshelfBlock(builder, NORTH, CB,  occupied_top_left,  empty_top_left,  occupied_top_mid,  empty_top_mid,  occupied_top_right,  empty_top_right,  occupied_bottom_left,  empty_bottom_left,  occupied_bottom_mid,  empty_bottom_mid,  occupied_bottom_right,  empty_bottom_right);
        chiseledBookshelfBlock(builder, EAST, CB,  occupied_top_left,  empty_top_left,  occupied_top_mid,  empty_top_mid,  occupied_top_right,  empty_top_right,  occupied_bottom_left,  empty_bottom_left,  occupied_bottom_mid,  empty_bottom_mid,  occupied_bottom_right,  empty_bottom_right);
        chiseledBookshelfBlock(builder, WEST, CB,  occupied_top_left,  empty_top_left,  occupied_top_mid,  empty_top_mid,  occupied_top_right,  empty_top_right,  occupied_bottom_left,  empty_bottom_left,  occupied_bottom_mid,  empty_bottom_mid,  occupied_bottom_right,  empty_bottom_right);
    }

    private void chiseledBookshelfBlock (MultiPartBlockStateBuilder builder, Direction facing, ModelFile CB, ModelFile occupied_top_left, ModelFile empty_top_left, ModelFile occupied_top_mid, ModelFile empty_top_mid, ModelFile occupied_top_right, ModelFile empty_top_right, ModelFile occupied_bottom_left, ModelFile empty_bottom_left, ModelFile occupied_bottom_mid, ModelFile empty_bottom_mid, ModelFile occupied_bottom_right, ModelFile empty_bottom_right) {
        chiseledBookshelfBlock(builder, CB, facing, null, null);
        chiseledBookshelfBlock(builder, occupied_top_left, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_top_left, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED, false);
        chiseledBookshelfBlock(builder, occupied_top_mid, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_top_mid, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED, false);
        chiseledBookshelfBlock(builder, occupied_top_right, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_top_right, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED, false);
        chiseledBookshelfBlock(builder, occupied_bottom_left, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_bottom_left, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED, false);
        chiseledBookshelfBlock(builder, occupied_bottom_mid, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_bottom_mid, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED, false);
        chiseledBookshelfBlock(builder, occupied_bottom_right, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED, true);
        chiseledBookshelfBlock(builder, empty_bottom_right, facing, BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED, false);
    }

    public void chiseledBookshelfBlock(MultiPartBlockStateBuilder builder, ModelFile model, Direction facing, Property property, Boolean value) {
        int rotationY = 0;
        switch (facing) {
            case SOUTH -> rotationY = 180;
            case NORTH -> rotationY = 0;
            case EAST -> rotationY = 90;
            case WEST -> rotationY = 270;
        }

        MultiPartBlockStateBuilder.PartBuilder partBuilder = builder.part()
                .modelFile(model).uvLock(true).rotationY(rotationY)
                .addModel().condition(HorizontalDirectionalBlock.FACING, facing);

        if (property != null && value != null) {
            partBuilder.condition(property, value);
        }

        partBuilder.end();
    }

    public void lecternBlock(Supplier<Block> block, ResourceLocation planks) {
        lecternBlock(block.get(), planks);
    }

    public void lecternBlock(Block block, ResourceLocation planks) {
        lecternBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_lectern")
                        .texture("bottom", planks)
                        .texture("base", "block/" + name(block) + "_base")
                        .texture("front", "block/" + name(block) + "_front")
                        .texture("sides", "block/" + name(block) + "_sides")
                        .texture("top", "block/" + name(block) + "_top"));
    }

    public void lecternBlockC(Supplier<Block> block, ResourceLocation planks) {
        lecternBlockC(block.get(), planks);
    }

    public void lecternBlockC(Block block, ResourceLocation planks) {
        String name = name(block).replace("_controller","");
        lecternBlock(block,
                models().withExistingParent(name, "carved_wood:block/template_lectern")
                        .texture("bottom", planks)
                        .texture("base", "block/" + name + "_base")
                        .texture("front", "block/" + name + "_front")
                        .texture("sides", "block/" + name + "_sides")
                        .texture("top", "block/" + name + "_top"));
    }

    public void lecternBlock(Block block, ModelFile model) {
        getVariantBuilder(block)
                .partialState().with(LadderBlock.FACING, Direction.EAST)
                .modelForState().modelFile(model).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(model).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(model).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST)
                .modelForState().modelFile(model).rotationY(270).addModel();
    }

    public void bookshelfBlock(Supplier<Block> block, String woodType) {
        bookshelfBlock(block.get(), woodType);
    }

    public void bookshelfBlock(Block block, String woodType) {
        bookshelfBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_bookshelf")
                        .texture("bottom", blockTexture(CarvedWood.getBlockFromString("minecraft", woodType + "_planks")))
                        .texture("side", "block/" + name(block))
                        .texture("top", blockTexture(CarvedWood.getBlockFromString("minecraft", woodType + "_planks"))));
    }

    public void bookshelfBlock(Block block, ModelFile bookshelf) {
        getVariantBuilder(block).partialState().modelForState().modelFile(bookshelf).addModel();
    }

    public void crafterBlock(Supplier<Block> block) {
        crafterBlock(block.get());
    }

    public void crafterBlock(Block block) {
        crafterBlock(block,
                models().withExistingParent(name(block), "minecraft:block/crafter")
                        .texture("bottom", "block/crafter_bottom")
                        .texture("top", "block/crafter_top")
                        .texture("north", "block/" + name(block) + "_north")
                        .texture("south", "block/" + name(block) + "_south")
                        .texture("west", "block/" + name(block) + "_west")
                        .texture("east", "block/" + name(block) + "_east"),
                models().withExistingParent(name(block) + "_triggered", "carved_wood:block/" + name(block))
                        .texture("top", "block/crafter_top_triggered")
                        .texture("south", "block/" + name(block) + "_south_triggered")
                        .texture("west", "block/" + name(block) + "_west_triggered")
                        .texture("east", "block/" + name(block) + "_east_triggered"),
                models().withExistingParent(name(block) + "_crafting", "carved_wood:block/" + name(block) + "_triggered")
                        .texture("top", "block/crafter_top_crafting")
                        .texture("north", "block/" + name(block) + "_north_crafting")
                        .texture("west", "block/" + name(block) + "_west_crafting")
                        .texture("east", "block/" + name(block) + "_east_crafting"),
                models().withExistingParent(name(block) + "_crafting_triggered", "carved_wood:block/" + name(block) + "_crafting")
        );
    }

    public void crafterBlock(Block block, ModelFile crafter, ModelFile crafterTriggered, ModelFile crafterCrafting, ModelFile crafterCraftingTriggered) {
        getVariantBuilder(block)
        // crafting = false
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_EAST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(90).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_EAST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(90).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_NORTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_NORTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_SOUTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(90).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_SOUTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(90).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_WEST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(90).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_WEST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(90).rotationY(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.EAST_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.EAST_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.NORTH_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.NORTH_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.SOUTH_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.SOUTH_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_EAST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(270).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_EAST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(270).rotationY(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_NORTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(270).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_NORTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(270).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_SOUTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_SOUTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_WEST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationX(270).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_WEST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationX(270).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.WEST_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafter).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, false)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.WEST_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterTriggered).rotationY(270).addModel()

        // crafting = true
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_EAST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(90).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_EAST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(90).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_NORTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_NORTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_SOUTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(90).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_SOUTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(90).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_WEST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(90).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.DOWN_WEST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(90).rotationY(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.EAST_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.EAST_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.NORTH_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.NORTH_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.SOUTH_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.SOUTH_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_EAST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(270).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_EAST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(270).rotationY(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_NORTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(270).rotationY(180).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_NORTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(270).rotationY(180).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_SOUTH)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_SOUTH)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(270).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_WEST)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationX(270).rotationY(90).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.UP_WEST)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationX(270).rotationY(90).addModel()

        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.WEST_UP)
            .with(CrafterBlock.TRIGGERED, false)
            .modelForState().modelFile(crafterCrafting).rotationY(270).addModel()
        .partialState()
            .with(CrafterBlock.CRAFTING, true)
            .with(BlockStateProperties.ORIENTATION, FrontAndTop.WEST_UP)
            .with(CrafterBlock.TRIGGERED, true)
            .modelForState().modelFile(crafterCraftingTriggered).rotationY(270).addModel();
    }

    public void barrelBlock(Supplier<Block> block) {
        barrelBlock(block.get());
    }

    public void barrelBlock(Block block) {
        barrelBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_barrel")
                        .texture("bottom", "block/" + name(block) + "_bottom")
                        .texture("side", "block/" + name(block) + "_side")
                        .texture("top", "block/" + name(block) + "_top"),
                models().withExistingParent(name(block) + "_open", "carved_wood:block/template_barrel")
                        .texture("bottom", "block/" + name(block) + "_bottom")
                        .texture("side", "block/" + name(block) + "_side")
                        .texture("top", "block/" + name(block) + "_top_open"));
    }

    public void barrelBlock(Block block, ModelFile barrel, ModelFile barrelOpen) {
        getVariantBuilder(block)
                .partialState().with(CWBarrelBlock.FACING, Direction.DOWN)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).rotationX(180).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.DOWN)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).rotationX(180).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.EAST)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).rotationX(90).rotationY(90).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.EAST)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).rotationX(90).rotationY(90).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.NORTH)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).rotationX(90).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.NORTH)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).rotationX(90).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.SOUTH)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).rotationX(90).rotationY(180).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.SOUTH)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).rotationX(90).rotationY(180).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.UP)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.UP)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.WEST)
                .with(CWBarrelBlock.OPEN, false).modelForState().modelFile(barrel).rotationX(90).rotationY(270).addModel()
                .partialState().with(CWBarrelBlock.FACING, Direction.WEST)
                .with(CWBarrelBlock.OPEN, true).modelForState().modelFile(barrelOpen).rotationX(90).rotationY(270).addModel();
    }

    public void woodenPanelsBlock(Supplier<Block> block) {
        woodenPanelsBlock(block.get());
    }

    public void woodenPanelsBlock(Block block) {
        woodenPanelsBlock(block,
                models().withExistingParent(name(block) + "_even_v", "carved_wood:block/template_big_planks")
                        .texture("end", "block/" + name(block))
                        .texture("side", "block/" + name(block)),
                models().withExistingParent(name(block) + "_odd_v", "carved_wood:block/template_big_planks")
                        .texture("end", "block/" + name(block))
                        .texture("side", "block/" + name(block) + "_odd"),
                models().withExistingParent(name(block) + "_even_e_v", "carved_wood:block/template_big_planks")
                        .texture("end", "block/" + name(block) + "_odd")
                        .texture("side", "block/" + name(block)),
                models().withExistingParent(name(block) + "_odd_e_v", "carved_wood:block/template_big_planks")
                        .texture("end", "block/" + name(block) + "_odd")
                        .texture("side", "block/" + name(block) + "_odd"),
                models().withExistingParent(name(block) + "_even", "minecraft:block/cube_column")
                        .texture("end", "block/" + name(block))
                        .texture("side", "block/" + name(block)),
                models().withExistingParent(name(block) + "_odd", "minecraft:block/cube_column")
                        .texture("end", "block/" + name(block))
                        .texture("side", "block/" + name(block) + "_odd"),
                models().withExistingParent(name(block) + "_even_e", "minecraft:block/cube_column")
                        .texture("end", "block/" + name(block) + "_odd")
                        .texture("side", "block/" + name(block)),
                models().withExistingParent(name(block) + "_odd_e", "minecraft:block/cube_column")
                        .texture("end", "block/" + name(block) + "_odd")
                        .texture("side", "block/" + name(block) + "_odd"));
    }

    public void woodenPanelsBlock(Block block, ModelFile even, ModelFile odd, ModelFile evenEnd, ModelFile oddEnd, ModelFile evenV, ModelFile oddV, ModelFile evenEndV, ModelFile oddEndV) {
        getVariantBuilder(block)
                .partialState().with(BigBlock.AXIS, Direction.Axis.Y).with(BigBlock.ODD, false).with(BigBlock.END_ODD, false).modelForState().modelFile(even).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Y).with(BigBlock.ODD, true).with(BigBlock.END_ODD, false).modelForState().modelFile(odd).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Y).with(BigBlock.ODD, false).with(BigBlock.END_ODD, true).modelForState().modelFile(evenEnd).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Y).with(BigBlock.ODD, true).with(BigBlock.END_ODD, true).modelForState().modelFile(oddEnd).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.X).with(BigBlock.ODD, false).with(BigBlock.END_ODD, false).modelForState().modelFile(evenV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.X).with(BigBlock.ODD, true).with(BigBlock.END_ODD, false).modelForState().modelFile(oddV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.X).with(BigBlock.ODD, false).with(BigBlock.END_ODD, true).modelForState().modelFile(evenEndV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.X).with(BigBlock.ODD, true).with(BigBlock.END_ODD, true).modelForState().modelFile(oddEndV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Z).with(BigBlock.ODD, false).with(BigBlock.END_ODD, false).modelForState().rotationY(90).modelFile(evenV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Z).with(BigBlock.ODD, true).with(BigBlock.END_ODD, false).modelForState().rotationY(90).modelFile(oddV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Z).with(BigBlock.ODD, false).with(BigBlock.END_ODD, true).modelForState().rotationY(90).modelFile(evenEndV).addModel()
                .partialState().with(BigBlock.AXIS, Direction.Axis.Z).with(BigBlock.ODD, true).with(BigBlock.END_ODD, true).modelForState().rotationY(90).modelFile(oddEndV).addModel();
    }

    public void campfireBlock(Supplier<Block> normal, Supplier<Block> soul) {
        campfireBlock(normal.get(), soul.get());
    }

    public void campfireBlock(Block campfire, Block soulCampfire) {
        campfireBlock(campfire,
                models().withExistingParent(name(campfire), "carved_wood:block/template_campfire")
                        .texture("particle", "block/" + name(campfire) + "_log")
                        .texture("log", "block/" + name(campfire) + "_log")
                        .texture("lit_log", "block/" + name(campfire) + "_log_lit")
                        .texture("fire", "minecraft:block/campfire_fire").renderType("cutout"),
                models().withExistingParent(name(campfire) + "_off", "carved_wood:block/template_campfire_off")
                        .texture("particle", "block/" + name(campfire) + "_log")
                        .texture("log", "block/" + name(campfire) + "_log").renderType("cutout"));
        campfireBlock(soulCampfire,
                models().withExistingParent(name(soulCampfire), "carved_wood:block/template_campfire")
                        .texture("particle", "block/" + name(campfire) + "_log")
                        .texture("log", "block/" + name(campfire) + "_log")
                        .texture("lit_log", "block/" + name(soulCampfire) + "_log_lit")
                        .texture("fire", "minecraft:block/soul_campfire_fire").renderType("cutout"),
                models().withExistingParent(name(campfire) + "_off", "carved_wood:block/template_campfire_off")
                        .texture("particle", "block/" + name(campfire) + "_log")
                        .texture("log", "block/" + name(campfire) + "_log").renderType("cutout"));
    }

    public void campfireBlock(Block block, ModelFile campfireOn, ModelFile campfireOff) {
        getVariantBuilder(block)
                .partialState().with(CWCampfireBlock.FACING, Direction.EAST)
                .with(CWCampfireBlock.LIT, true).modelForState().modelFile(campfireOn).rotationY(270).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.EAST)
                .with(CWCampfireBlock.LIT, false).modelForState().modelFile(campfireOff).rotationY(270).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.NORTH)
                .with(CWCampfireBlock.LIT, true).modelForState().modelFile(campfireOn).rotationY(180).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.NORTH)
                .with(CWCampfireBlock.LIT, false).modelForState().modelFile(campfireOff).rotationY(180).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.SOUTH)
                .with(CWCampfireBlock.LIT, true).modelForState().modelFile(campfireOn).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.SOUTH)
                .with(CWCampfireBlock.LIT, false).modelForState().modelFile(campfireOff).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.WEST)
                .with(CWCampfireBlock.LIT, true).modelForState().modelFile(campfireOn).rotationY(90).addModel()
                .partialState().with(CWCampfireBlock.FACING, Direction.WEST)
                .with(CWCampfireBlock.LIT, false).modelForState().modelFile(campfireOff).rotationY(90).addModel();
    }

    public void woodenLanternBlock(Block lantern) {
        woodenLanternBlock(lantern,
                models().withExistingParent(name(lantern), "carved_wood:block/template_wooden_lantern")
                        .texture("particle", "block/" + name(lantern) + "_block")
                        .texture("wooden_lantern", "block/" + name(lantern)),
                models().withExistingParent(name(lantern) + "_hanging", "carved_wood:block/template_hanging_wooden_lantern")
                        .texture("particle", "block/" + name(lantern) + "_block")
                        .texture("wooden_lantern", "block/" + name(lantern)),
                models().withExistingParent(name(lantern) + "_hanging_side", "carved_wood:block/template_hanging_wooden_lantern_side")
                        .texture("particle", "block/" + name(lantern) + "_block")
                        .texture("wooden_lantern", "block/" + name(lantern)),
                models().withExistingParent(name(lantern) + "_hanging_wall", "carved_wood:block/template_hanging_wooden_lantern_wall")
                        .texture("particle", "block/" + name(lantern) + "_block")
                        .texture("wooden_lantern", "block/" + name(lantern)),
                models().withExistingParent(name(lantern) + "_hanging_fence", "carved_wood:block/template_hanging_wooden_lantern_fence")
                        .texture("particle", "block/" + name(lantern) + "_block")
                        .texture("wooden_lantern", "block/" + name(lantern)));
    }

    private void woodenLanternBlock(Block block, ModelFile woodenLantern, ModelFile hangingWoodenLantern, ModelFile hangingSideWoodenLantern, ModelFile hangingWallWoodenLantern, ModelFile hangingFenceWoodenLantern) {
        getVariantBuilder(block).partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.SETTING)
                .with(WoodenLanternBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(woodenLantern).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING)
                .with(WoodenLanternBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(hangingWoodenLantern).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_SIDE)
                .with(WoodenLanternBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(hangingSideWoodenLantern).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_WALL)
                .with(WoodenLanternBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(hangingWallWoodenLantern).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_FENCE)
                .with(WoodenLanternBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(hangingFenceWoodenLantern).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.SETTING)
                .with(WoodenLanternBlock.FACING, Direction.EAST)
                .modelForState().modelFile(woodenLantern).rotationY(90).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING)
                .with(WoodenLanternBlock.FACING, Direction.EAST)
                .modelForState().modelFile(hangingWoodenLantern).rotationY(90).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_SIDE)
                .with(WoodenLanternBlock.FACING, Direction.EAST)
                .modelForState().modelFile(hangingSideWoodenLantern).rotationY(90).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_WALL)
                .with(WoodenLanternBlock.FACING, Direction.EAST)
                .modelForState().modelFile(hangingWallWoodenLantern).rotationY(90).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_FENCE)
                .with(WoodenLanternBlock.FACING, Direction.EAST)
                .modelForState().modelFile(hangingFenceWoodenLantern).rotationY(90).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.SETTING)
                .with(WoodenLanternBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(woodenLantern).rotationY(180).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING)
                .with(WoodenLanternBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(hangingWoodenLantern).rotationY(180).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_SIDE)
                .with(WoodenLanternBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(hangingSideWoodenLantern).rotationY(180).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_WALL)
                .with(WoodenLanternBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(hangingWallWoodenLantern).rotationY(180).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_FENCE)
                .with(WoodenLanternBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(hangingFenceWoodenLantern).rotationY(180).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.SETTING)
                .with(WoodenLanternBlock.FACING, Direction.WEST)
                .modelForState().modelFile(woodenLantern).rotationY(270).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING)
                .with(WoodenLanternBlock.FACING, Direction.WEST)
                .modelForState().modelFile(hangingWoodenLantern).rotationY(270).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_SIDE)
                .with(WoodenLanternBlock.FACING, Direction.WEST)
                .modelForState().modelFile(hangingSideWoodenLantern).rotationY(270).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_WALL)
                .with(WoodenLanternBlock.FACING, Direction.WEST)
                .modelForState().modelFile(hangingWallWoodenLantern).rotationY(270).addModel().partialState()
                .with(WoodenLanternBlock.SHAPE, WoodenLanternShape.HANGING_FENCE)
                .with(WoodenLanternBlock.FACING, Direction.WEST)
                .modelForState().modelFile(hangingFenceWoodenLantern).rotationY(270).addModel();
    }

    public void chestBlock(Block block, String woodType) {
        Block boards = CarvedWood.getBlockFromString("minecraft", woodType + "_planks");
        chestBlock(block, blockTexture(boards));
    }

    public void chestBlock(Block block, ResourceLocation particleTexture) {
        chestBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_chest")
                        .texture("particle", particleTexture));
    }

    public void chestBlock(Block block, ModelFile model) {
        getVariantBuilder(block).partialState()
                .modelForState().modelFile(model).addModel();
    }

    public void ladderBlock(LadderBlock block) {
        ladderBlock(block, blockTexture(block));
    }

    public void ladderBlock(LadderBlock block, ResourceLocation blockTexture) {
        ladderBlock(block,
                models().withExistingParent(name(block), "carved_wood:block/template_ladder")
                        .texture("texture", blockTexture)
                        .texture("particle", blockTexture));
    }

    public void ladderBlock(LadderBlock block, ModelFile model) {
        getVariantBuilder(block)
                .partialState().with(LadderBlock.FACING, Direction.EAST)
                .modelForState().modelFile(model).rotationY(90).addModel()
                .partialState().with(LadderBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(model).addModel()
                .partialState().with(LadderBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(model).rotationY(180).addModel()
                .partialState().with(LadderBlock.FACING, Direction.WEST)
                .modelForState().modelFile(model).rotationY(270).addModel();
    }

    public void woodenPillarBlockWithCustomHorizontalTexture(RotatedPillarBlock block) {
        axisBlock(block, blockTexture(block), extend(blockTexture(block), "_horizontal"), extend(blockTexture(block), "_top"));
    }

    public void woodenPillarBlock(RotatedPillarBlock block) {
        axisBlock(block, blockTexture(block), blockTexture(block), extend(blockTexture(block), "_top"));
    }

    public void axisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation sideH, ResourceLocation end) {
        axisBlock(block,
                models().withExistingParent(name(block), "carved_wood:block" + "/template_wooden_pillar")
                        .texture("side", side)
                        .texture("end", end),
                models().withExistingParent(name(block) + "_horizontal", "carved_wood:block/template_wooden_pillar_horizontal_z")
                        .texture("side", sideH)
                        .texture("end", end),
                models().withExistingParent(name(block) + "_horizontal", "carved_wood:block/template_wooden_pillar_horizontal_x")
                        .texture("side", sideH)
                        .texture("end", end));
    }

    public void axisBlock(RotatedPillarBlock block, ModelFile vertical, ModelFile horizontal_z, ModelFile horizontal_x) {
        getVariantBuilder(block)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(vertical).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(horizontal_z).rotationX(90).rotationY(180).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(horizontal_x).rotationX(90).rotationY(270).addModel();
    }

    public void carvedPlankBlock(Block block) {
        carvedPlankBlock(block, blockTexture(block), extend(blockTexture(block), "_top"));
    }

    public void carvedPlankBlock(Block block, ResourceLocation side, ResourceLocation end) {
        carvedPlankBlock((CarvedPlanksBlock)block, models().cubeColumn(name(block), side, end));
    }

    public void carvedPlankBlock(CarvedPlanksBlock block, ModelFile model) {
        getVariantBuilder(block)
                .partialState().with(CarvedPlanksBlock.FACING, Direction.DOWN)
                .modelForState().modelFile(model).rotationX(180).addModel()
                .partialState().with(CarvedPlanksBlock.FACING, Direction.UP)
                .modelForState().modelFile(model).addModel()
                .partialState().with(CarvedPlanksBlock.FACING, Direction.NORTH)
                .modelForState().modelFile(model).rotationX(90).addModel()
                .partialState().with(CarvedPlanksBlock.FACING, Direction.SOUTH)
                .modelForState().modelFile(model).rotationX(90).rotationY(180).addModel()
                .partialState().with(CarvedPlanksBlock.FACING, Direction.EAST)
                .modelForState().modelFile(model).rotationX(90).rotationY(90).addModel()
                .partialState().with(CarvedPlanksBlock.FACING, Direction.WEST)
                .modelForState().modelFile(model).rotationX(90).rotationY(270).addModel();
    }

    public void craftingTableBlock(Block block, String woodType) {
        craftingTableBlock(block, extend(blockTexture(block), "_front"), extend(blockTexture(block), "_side"), extend(blockTexture(block), "_top"), blockTexture(CarvedWood.getBlockFromString("minecraft", woodType + "_planks")));
    }

    public void craftingTableBlock(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation top, ResourceLocation bottom) {
        craftingTableBlock(block,
                models().withExistingParent(name(block), "minecraft:block/cube")
                        .texture("particle", front)
                        .texture("north", front)
                        .texture("south", front)
                        .texture("east", side)
                        .texture("west", side)
                        .texture("up", top)
                        .texture("down", bottom));
    }

    public void craftingTableBlock(Block block, ModelFile modelFile) {
        getVariantBuilder(block)
                .partialState().modelForState().modelFile(modelFile).addModel();
    }

    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return CarvedWood.newRL(rl.getNamespace(), rl.getPath() + suffix);
    }

    public void columnBlock(Block block) {
        columnBlock(block, blockTexture(block), extend(blockTexture(block), "_top"));
    }

    public void columnBlock(Block block, ResourceLocation side, ResourceLocation end) {
        columnBlock(block, models().cubeColumn(name(block), side, end));
    }

    public void columnBlock(Block block, ModelFile vertical) {
        getVariantBuilder(block)
                .partialState()
                .modelForState().modelFile(vertical).addModel();
    }

    private void blockWithItem(Block blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject, cubeAll(blockRegistryObject));
    }
}