package net.im_maker.carved_wood.datagen.loot;

import net.im_maker.carved_wood.common.block.CWBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(CWBlocks.SPRUCE_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.BIRCH_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.JUNGLE_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.ACACIA_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.DARK_OAK_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.MANGROVE_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.CHERRY_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.CRIMSON_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.WARPED_CRAFTING_TABLE.get());
        this.dropSelf(CWBlocks.BAMBOO_CRAFTING_TABLE.get());

        this.dropSelf(CWBlocks.SPRUCE_LADDER.get());
        this.dropSelf(CWBlocks.BIRCH_LADDER.get());
        this.dropSelf(CWBlocks.JUNGLE_LADDER.get());
        this.dropSelf(CWBlocks.ACACIA_LADDER.get());
        this.dropSelf(CWBlocks.DARK_OAK_LADDER.get());
        this.dropSelf(CWBlocks.MANGROVE_LADDER.get());
        this.dropSelf(CWBlocks.CHERRY_LADDER.get());
        this.dropSelf(CWBlocks.CRIMSON_LADDER.get());
        this.dropSelf(CWBlocks.WARPED_LADDER.get());
        this.dropSelf(CWBlocks.BAMBOO_LADDER.get());

        this.dropSelf(CWBlocks.OAK_CHEST.get());
        this.dropSelf(CWBlocks.OAK_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.SPRUCE_CHEST.get());
        this.dropSelf(CWBlocks.SPRUCE_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.BIRCH_CHEST.get());
        this.dropSelf(CWBlocks.BIRCH_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.JUNGLE_CHEST.get());
        this.dropSelf(CWBlocks.JUNGLE_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.ACACIA_CHEST.get());
        this.dropSelf(CWBlocks.ACACIA_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.DARK_OAK_CHEST.get());
        this.dropSelf(CWBlocks.DARK_OAK_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.MANGROVE_CHEST.get());
        this.dropSelf(CWBlocks.MANGROVE_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.CHERRY_CHEST.get());
        this.dropSelf(CWBlocks.CHERRY_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.CRIMSON_CHEST.get());
        this.dropSelf(CWBlocks.CRIMSON_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.WARPED_CHEST.get());
        this.dropSelf(CWBlocks.WARPED_TRAPPED_CHEST.get());
        this.dropSelf(CWBlocks.BAMBOO_CHEST.get());
        this.dropSelf(CWBlocks.BAMBOO_TRAPPED_CHEST.get());

        this.dropSelf(CWBlocks.OAK_BARREL.get());
        this.dropSelf(CWBlocks.BIRCH_BARREL.get());
        this.dropSelf(CWBlocks.JUNGLE_BARREL.get());
        this.dropSelf(CWBlocks.ACACIA_BARREL.get());
        this.dropSelf(CWBlocks.DARK_OAK_BARREL.get());
        this.dropSelf(CWBlocks.MANGROVE_BARREL.get());
        this.dropSelf(CWBlocks.CHERRY_BARREL.get());
        this.dropSelf(CWBlocks.CRIMSON_BARREL.get());
        this.dropSelf(CWBlocks.WARPED_BARREL.get());
        this.dropSelf(CWBlocks.BAMBOO_BARREL.get());

        this.dropSelf(CWBlocks.SPRUCE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.BIRCH_BOOKSHELF.get());
        this.dropSelf(CWBlocks.JUNGLE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.ACACIA_BOOKSHELF.get());
        this.dropSelf(CWBlocks.DARK_OAK_BOOKSHELF.get());
        this.dropSelf(CWBlocks.MANGROVE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHERRY_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CRIMSON_BOOKSHELF.get());
        this.dropSelf(CWBlocks.WARPED_BOOKSHELF.get());
        this.dropSelf(CWBlocks.BAMBOO_BOOKSHELF.get());

        this.dropSelf(CWBlocks.CHISELED_SPRUCE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_BIRCH_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_JUNGLE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_ACACIA_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_DARK_OAK_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_MANGROVE_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_CHERRY_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_CRIMSON_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_WARPED_BOOKSHELF.get());
        this.dropSelf(CWBlocks.CHISELED_BAMBOO_BOOKSHELF.get());

        this.dropSelf(CWBlocks.SPRUCE_LECTERN.get());
        this.dropSelf(CWBlocks.BIRCH_LECTERN.get());
        this.dropSelf(CWBlocks.JUNGLE_LECTERN.get());
        this.dropSelf(CWBlocks.ACACIA_LECTERN.get());
        this.dropSelf(CWBlocks.DARK_OAK_LECTERN.get());
        this.dropSelf(CWBlocks.MANGROVE_LECTERN.get());
        this.dropSelf(CWBlocks.CHERRY_LECTERN.get());
        this.dropSelf(CWBlocks.CRIMSON_LECTERN.get());
        this.dropSelf(CWBlocks.WARPED_LECTERN.get());
        this.dropSelf(CWBlocks.BAMBOO_LECTERN.get());

        this.dropSelf(CWBlocks.SPRUCE_BEEHIVE.get());
        this.dropSelf(CWBlocks.BIRCH_BEEHIVE.get());
        this.dropSelf(CWBlocks.JUNGLE_BEEHIVE.get());
        this.dropSelf(CWBlocks.ACACIA_BEEHIVE.get());
        this.dropSelf(CWBlocks.DARK_OAK_BEEHIVE.get());
        this.dropSelf(CWBlocks.MANGROVE_BEEHIVE.get());
        this.dropSelf(CWBlocks.CHERRY_BEEHIVE.get());
        this.dropSelf(CWBlocks.CRIMSON_BEEHIVE.get());
        this.dropSelf(CWBlocks.WARPED_BEEHIVE.get());
        this.dropSelf(CWBlocks.BAMBOO_BEEHIVE.get());

        this.dropSelf(CWBlocks.SPRUCE_CAMPFIRE.get());
        this.dropSelf(CWBlocks.BIRCH_CAMPFIRE.get());
        this.dropSelf(CWBlocks.JUNGLE_CAMPFIRE.get());
        this.dropSelf(CWBlocks.ACACIA_CAMPFIRE.get());
        this.dropSelf(CWBlocks.DARK_OAK_CAMPFIRE.get());
        this.dropSelf(CWBlocks.MANGROVE_CAMPFIRE.get());
        this.dropSelf(CWBlocks.CHERRY_CAMPFIRE.get());
        this.dropSelf(CWBlocks.CRIMSON_CAMPFIRE.get());
        this.dropSelf(CWBlocks.WARPED_CAMPFIRE.get());
        this.dropSelf(CWBlocks.BAMBOO_CAMPFIRE.get());

        this.dropSelf(CWBlocks.SPRUCE_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.BIRCH_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.JUNGLE_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.ACACIA_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.DARK_OAK_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.MANGROVE_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.CHERRY_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.CRIMSON_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.WARPED_SOUL_CAMPFIRE.get());
        this.dropSelf(CWBlocks.BAMBOO_SOUL_CAMPFIRE.get());

        this.dropSelf(CWBlocks.CARVED_OAK_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_SPRUCE_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_BIRCH_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_JUNGLE_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_ACACIA_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_DARK_OAK_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_MANGROVE_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_CHERRY_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_CRIMSON_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_WARPED_PLANKS.get());
        this.dropSelf(CWBlocks.CARVED_BAMBOO_PLANKS.get());

        this.dropSelf(CWBlocks.OAK_LANTERN.get());
        this.dropSelf(CWBlocks.SPRUCE_LANTERN.get());
        this.dropSelf(CWBlocks.BIRCH_LANTERN.get());
        this.dropSelf(CWBlocks.JUNGLE_LANTERN.get());
        this.dropSelf(CWBlocks.ACACIA_LANTERN.get());
        this.dropSelf(CWBlocks.DARK_OAK_LANTERN.get());
        this.dropSelf(CWBlocks.MANGROVE_LANTERN.get());
        this.dropSelf(CWBlocks.CHERRY_LANTERN.get());
        this.dropSelf(CWBlocks.CRIMSON_LANTERN.get());
        this.dropSelf(CWBlocks.WARPED_LANTERN.get());
        this.dropSelf(CWBlocks.BAMBOO_LANTERN.get());

        this.dropSelf(CWBlocks.OAK_BOARDS.get());
        this.dropSelf(CWBlocks.SPRUCE_BOARDS.get());
        this.dropSelf(CWBlocks.BIRCH_BOARDS.get());
        this.dropSelf(CWBlocks.JUNGLE_BOARDS.get());
        this.dropSelf(CWBlocks.ACACIA_BOARDS.get());
        this.dropSelf(CWBlocks.DARK_OAK_BOARDS.get());
        this.dropSelf(CWBlocks.MANGROVE_BOARDS.get());
        this.dropSelf(CWBlocks.CHERRY_BOARDS.get());
        this.dropSelf(CWBlocks.CRIMSON_BOARDS.get());
        this.dropSelf(CWBlocks.WARPED_BOARDS.get());
        this.dropSelf(CWBlocks.BAMBOO_BOARDS.get());

        this.dropSelf(CWBlocks.SMOOTH_OAK_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_SPRUCE_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_BIRCH_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_JUNGLE_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_ACACIA_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_DARK_OAK_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_MANGROVE_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_CHERRY_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_CRIMSON_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_WARPED_BOARDS.get());
        this.dropSelf(CWBlocks.SMOOTH_BAMBOO_BOARDS.get());

        this.dropSelf(CWBlocks.OAK_TILES.get());
        this.dropSelf(CWBlocks.SPRUCE_TILES.get());
        this.dropSelf(CWBlocks.BIRCH_TILES.get());
        this.dropSelf(CWBlocks.JUNGLE_TILES.get());
        this.dropSelf(CWBlocks.ACACIA_TILES.get());
        this.dropSelf(CWBlocks.DARK_OAK_TILES.get());
        this.dropSelf(CWBlocks.MANGROVE_TILES.get());
        this.dropSelf(CWBlocks.CHERRY_TILES.get());
        this.dropSelf(CWBlocks.CRIMSON_TILES.get());
        this.dropSelf(CWBlocks.WARPED_TILES.get());
        this.dropSelf(CWBlocks.BAMBOO_TILES.get());

        this.dropSelf(CWBlocks.OAK_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.SPRUCE_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.BIRCH_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.JUNGLE_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.ACACIA_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.DARK_OAK_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.MANGROVE_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.CHERRY_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.CRIMSON_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.WARPED_TILE_STAIRS.get());
        this.dropSelf(CWBlocks.BAMBOO_TILE_STAIRS.get());

        this.add(CWBlocks.OAK_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.OAK_TILE_SLAB.get()));
        this.add(CWBlocks.SPRUCE_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.SPRUCE_TILE_SLAB.get()));
        this.add(CWBlocks.BIRCH_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.BIRCH_TILE_SLAB.get()));
        this.add(CWBlocks.JUNGLE_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.JUNGLE_TILE_SLAB.get()));
        this.add(CWBlocks.ACACIA_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.ACACIA_TILE_SLAB.get()));
        this.add(CWBlocks.DARK_OAK_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.DARK_OAK_TILE_SLAB.get()));
        this.add(CWBlocks.MANGROVE_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.MANGROVE_TILE_SLAB.get()));
        this.add(CWBlocks.CHERRY_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.CHERRY_TILE_SLAB.get()));
        this.add(CWBlocks.CRIMSON_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.CRIMSON_TILE_SLAB.get()));
        this.add(CWBlocks.WARPED_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.WARPED_TILE_SLAB.get()));
        this.add(CWBlocks.BAMBOO_TILE_SLAB.get(), block -> createSlabItemTable(CWBlocks.BAMBOO_TILE_SLAB.get()));

        this.dropSelf(CWBlocks.OAK_MOSAIC.get());
        this.dropSelf(CWBlocks.SPRUCE_MOSAIC.get());
        this.dropSelf(CWBlocks.BIRCH_MOSAIC.get());
        this.dropSelf(CWBlocks.JUNGLE_MOSAIC.get());
        this.dropSelf(CWBlocks.ACACIA_MOSAIC.get());
        this.dropSelf(CWBlocks.DARK_OAK_MOSAIC.get());
        this.dropSelf(CWBlocks.MANGROVE_MOSAIC.get());
        this.dropSelf(CWBlocks.CHERRY_MOSAIC.get());
        this.dropSelf(CWBlocks.CRIMSON_MOSAIC.get());
        this.dropSelf(CWBlocks.WARPED_MOSAIC.get());

        this.dropSelf(CWBlocks.OAK_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.SPRUCE_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.BIRCH_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.JUNGLE_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.ACACIA_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.DARK_OAK_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.MANGROVE_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.CHERRY_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.CRIMSON_MOSAIC_STAIRS.get());
        this.dropSelf(CWBlocks.WARPED_MOSAIC_STAIRS.get());

        this.add(CWBlocks.OAK_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.OAK_MOSAIC_SLAB.get()));
        this.add(CWBlocks.SPRUCE_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.SPRUCE_MOSAIC_SLAB.get()));
        this.add(CWBlocks.BIRCH_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.BIRCH_MOSAIC_SLAB.get()));
        this.add(CWBlocks.JUNGLE_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.JUNGLE_MOSAIC_SLAB.get()));
        this.add(CWBlocks.ACACIA_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.ACACIA_MOSAIC_SLAB.get()));
        this.add(CWBlocks.DARK_OAK_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.DARK_OAK_MOSAIC_SLAB.get()));
        this.add(CWBlocks.MANGROVE_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.MANGROVE_MOSAIC_SLAB.get()));
        this.add(CWBlocks.CHERRY_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.CHERRY_MOSAIC_SLAB.get()));
        this.add(CWBlocks.CRIMSON_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.CRIMSON_MOSAIC_SLAB.get()));
        this.add(CWBlocks.WARPED_MOSAIC_SLAB.get(), block -> createSlabItemTable(CWBlocks.WARPED_MOSAIC_SLAB.get()));

        this.dropSelf(CWBlocks.OAK_PILLAR.get());
        this.dropSelf(CWBlocks.SPRUCE_PILLAR.get());
        this.dropSelf(CWBlocks.BIRCH_PILLAR.get());
        this.dropSelf(CWBlocks.JUNGLE_PILLAR.get());
        this.dropSelf(CWBlocks.ACACIA_PILLAR.get());
        this.dropSelf(CWBlocks.DARK_OAK_PILLAR.get());
        this.dropSelf(CWBlocks.MANGROVE_PILLAR.get());
        this.dropSelf(CWBlocks.CHERRY_PILLAR.get());
        this.dropSelf(CWBlocks.CRIMSON_PILLAR.get());
        this.dropSelf(CWBlocks.WARPED_PILLAR.get());
        this.dropSelf(CWBlocks.BAMBOO_PILLAR.get());

        this.dropSelf(CWBlocks.OAK_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.SPRUCE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.BIRCH_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.JUNGLE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.ACACIA_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.DARK_OAK_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.MANGROVE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.CHERRY_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.CRIMSON_STEM_BUNDLE.get());
        this.dropSelf(CWBlocks.WARPED_STEM_BUNDLE.get());
        this.dropSelf(CWBlocks.BAMBOO_BUNDLE.get());

        this.dropSelf(CWBlocks.STRIPPED_OAK_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_SPRUCE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_BIRCH_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_JUNGLE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_ACACIA_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_DARK_OAK_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_MANGROVE_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_CHERRY_LOG_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_CRIMSON_STEM_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_WARPED_STEM_BUNDLE.get());
        this.dropSelf(CWBlocks.STRIPPED_BAMBOO_BUNDLE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CWBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}