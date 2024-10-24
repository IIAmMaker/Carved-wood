package net.im_maker.carved_wood.datagen;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CarvedWood.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                CWBlocks.CARVED_OAK_PLANKS.get(),
                CWBlocks.CARVED_SPRUCE_PLANKS.get(),
                CWBlocks.CARVED_BIRCH_PLANKS.get(),
                CWBlocks.CARVED_JUNGLE_PLANKS.get(),
                CWBlocks.CARVED_ACACIA_PLANKS.get(),
                CWBlocks.CARVED_DARK_OAK_PLANKS.get(),
                CWBlocks.CARVED_MANGROVE_PLANKS.get(),
                CWBlocks.CARVED_CHERRY_PLANKS.get(),
                CWBlocks.CARVED_CRIMSON_PLANKS.get(),
                CWBlocks.CARVED_WARPED_PLANKS.get(),
                CWBlocks.CARVED_BAMBOO_PLANKS.get(),
                CWBlocks.SMOOTH_OAK_BOARDS.get(),
                CWBlocks.SMOOTH_SPRUCE_BOARDS.get(),
                CWBlocks.SMOOTH_BIRCH_BOARDS.get(),
                CWBlocks.SMOOTH_JUNGLE_BOARDS.get(),
                CWBlocks.SMOOTH_ACACIA_BOARDS.get(),
                CWBlocks.SMOOTH_DARK_OAK_BOARDS.get(),
                CWBlocks.SMOOTH_MANGROVE_BOARDS.get(),
                CWBlocks.SMOOTH_CHERRY_BOARDS.get(),
                CWBlocks.SMOOTH_CRIMSON_BOARDS.get(),
                CWBlocks.SMOOTH_WARPED_BOARDS.get(),
                CWBlocks.SMOOTH_BAMBOO_BOARDS.get(),
                CWBlocks.OAK_BOARDS.get(),
                CWBlocks.SPRUCE_BOARDS.get(),
                CWBlocks.BIRCH_BOARDS.get(),
                CWBlocks.JUNGLE_BOARDS.get(),
                CWBlocks.ACACIA_BOARDS.get(),
                CWBlocks.DARK_OAK_BOARDS.get(),
                CWBlocks.MANGROVE_BOARDS.get(),
                CWBlocks.CHERRY_BOARDS.get(),
                CWBlocks.CRIMSON_BOARDS.get(),
                CWBlocks.WARPED_BOARDS.get(),
                CWBlocks.BAMBOO_BOARDS.get(),
                CWBlocks.OAK_LANTERN.get(),
                CWBlocks.SPRUCE_LANTERN.get(),
                CWBlocks.BIRCH_LANTERN.get(),
                CWBlocks.JUNGLE_LANTERN.get(),
                CWBlocks.ACACIA_LANTERN.get(),
                CWBlocks.DARK_OAK_LANTERN.get(),
                CWBlocks.MANGROVE_LANTERN.get(),
                CWBlocks.CHERRY_LANTERN.get(),
                CWBlocks.CRIMSON_LANTERN.get(),
                CWBlocks.WARPED_LANTERN.get(),
                CWBlocks.BAMBOO_LANTERN.get(),
                CWBlocks.OAK_TILES.get(),
                CWBlocks.SPRUCE_TILES.get(),
                CWBlocks.BIRCH_TILES.get(),
                CWBlocks.JUNGLE_TILES.get(),
                CWBlocks.ACACIA_TILES.get(),
                CWBlocks.DARK_OAK_TILES.get(),
                CWBlocks.MANGROVE_TILES.get(),
                CWBlocks.CHERRY_TILES.get(),
                CWBlocks.CRIMSON_TILES.get(),
                CWBlocks.WARPED_TILES.get(),
                CWBlocks.BAMBOO_TILES.get(),
                CWBlocks.OAK_TILE_STAIRS.get(),
                CWBlocks.SPRUCE_TILE_STAIRS.get(),
                CWBlocks.BIRCH_TILE_STAIRS.get(),
                CWBlocks.JUNGLE_TILE_STAIRS.get(),
                CWBlocks.ACACIA_TILE_STAIRS.get(),
                CWBlocks.DARK_OAK_TILE_STAIRS.get(),
                CWBlocks.MANGROVE_TILE_STAIRS.get(),
                CWBlocks.CHERRY_TILE_STAIRS.get(),
                CWBlocks.CRIMSON_TILE_STAIRS.get(),
                CWBlocks.WARPED_TILE_STAIRS.get(),
                CWBlocks.BAMBOO_TILE_STAIRS.get(),
                CWBlocks.OAK_TILE_SLAB.get(),
                CWBlocks.SPRUCE_TILE_SLAB.get(),
                CWBlocks.BIRCH_TILE_SLAB.get(),
                CWBlocks.JUNGLE_TILE_SLAB.get(),
                CWBlocks.ACACIA_TILE_SLAB.get(),
                CWBlocks.DARK_OAK_TILE_SLAB.get(),
                CWBlocks.MANGROVE_TILE_SLAB.get(),
                CWBlocks.CHERRY_TILE_SLAB.get(),
                CWBlocks.CRIMSON_TILE_SLAB.get(),
                CWBlocks.WARPED_TILE_SLAB.get(),
                CWBlocks.OAK_MOSAIC.get(),
                CWBlocks.SPRUCE_MOSAIC.get(),
                CWBlocks.BIRCH_MOSAIC.get(),
                CWBlocks.JUNGLE_MOSAIC.get(),
                CWBlocks.ACACIA_MOSAIC.get(),
                CWBlocks.DARK_OAK_MOSAIC.get(),
                CWBlocks.MANGROVE_MOSAIC.get(),
                CWBlocks.CHERRY_MOSAIC.get(),
                CWBlocks.CRIMSON_MOSAIC.get(),
                CWBlocks.WARPED_MOSAIC.get(),
                CWBlocks.OAK_MOSAIC_STAIRS.get(),
                CWBlocks.SPRUCE_MOSAIC_STAIRS.get(),
                CWBlocks.BIRCH_MOSAIC_STAIRS.get(),
                CWBlocks.JUNGLE_MOSAIC_STAIRS.get(),
                CWBlocks.ACACIA_MOSAIC_STAIRS.get(),
                CWBlocks.DARK_OAK_MOSAIC_STAIRS.get(),
                CWBlocks.MANGROVE_MOSAIC_STAIRS.get(),
                CWBlocks.CHERRY_MOSAIC_STAIRS.get(),
                CWBlocks.CRIMSON_MOSAIC_STAIRS.get(),
                CWBlocks.WARPED_MOSAIC_STAIRS.get(),
                CWBlocks.OAK_MOSAIC_SLAB.get(),
                CWBlocks.SPRUCE_MOSAIC_SLAB.get(),
                CWBlocks.BIRCH_MOSAIC_SLAB.get(),
                CWBlocks.JUNGLE_MOSAIC_SLAB.get(),
                CWBlocks.ACACIA_MOSAIC_SLAB.get(),
                CWBlocks.DARK_OAK_MOSAIC_SLAB.get(),
                CWBlocks.MANGROVE_MOSAIC_SLAB.get(),
                CWBlocks.CHERRY_MOSAIC_SLAB.get(),
                CWBlocks.CRIMSON_MOSAIC_SLAB.get(),
                CWBlocks.WARPED_MOSAIC_SLAB.get(),
                CWBlocks.OAK_PILLAR.get(),
                CWBlocks.SPRUCE_PILLAR.get(),
                CWBlocks.BIRCH_PILLAR.get(),
                CWBlocks.JUNGLE_PILLAR.get(),
                CWBlocks.ACACIA_PILLAR.get(),
                CWBlocks.DARK_OAK_PILLAR.get(),
                CWBlocks.MANGROVE_PILLAR.get(),
                CWBlocks.CHERRY_PILLAR.get(),
                CWBlocks.CRIMSON_PILLAR.get(),
                CWBlocks.WARPED_PILLAR.get(),
                CWBlocks.BAMBOO_PILLAR.get(),
                CWBlocks.OAK_LOG_BUNDLE.get(),
                CWBlocks.SPRUCE_LOG_BUNDLE.get(),
                CWBlocks.BIRCH_LOG_BUNDLE.get(),
                CWBlocks.JUNGLE_LOG_BUNDLE.get(),
                CWBlocks.ACACIA_LOG_BUNDLE.get(),
                CWBlocks.DARK_OAK_LOG_BUNDLE.get(),
                CWBlocks.MANGROVE_LOG_BUNDLE.get(),
                CWBlocks.CHERRY_LOG_BUNDLE.get(),
                CWBlocks.CRIMSON_STEM_BUNDLE.get(),
                CWBlocks.WARPED_STEM_BUNDLE.get(),
                CWBlocks.BAMBOO_BUNDLE.get(),
                CWBlocks.STRIPPED_OAK_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_SPRUCE_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_BIRCH_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_JUNGLE_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_ACACIA_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_DARK_OAK_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_MANGROVE_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_CHERRY_LOG_BUNDLE.get(),
                CWBlocks.STRIPPED_CRIMSON_STEM_BUNDLE.get(),
                CWBlocks.STRIPPED_WARPED_STEM_BUNDLE.get(),
                CWBlocks.STRIPPED_BAMBOO_BUNDLE.get(),
                CWBlocks.SPRUCE_CRAFTING_TABLE.get(),
                CWBlocks.BIRCH_CRAFTING_TABLE.get(),
                CWBlocks.JUNGLE_CRAFTING_TABLE.get(),
                CWBlocks.ACACIA_CRAFTING_TABLE.get(),
                CWBlocks.DARK_OAK_CRAFTING_TABLE.get(),
                CWBlocks.MANGROVE_CRAFTING_TABLE.get(),
                CWBlocks.CHERRY_CRAFTING_TABLE.get(),
                CWBlocks.CRIMSON_CRAFTING_TABLE.get(),
                CWBlocks.WARPED_CRAFTING_TABLE.get(),
                CWBlocks.BAMBOO_CRAFTING_TABLE.get(),
                CWBlocks.SPRUCE_LADDER.get(),
                CWBlocks.BIRCH_LADDER.get(),
                CWBlocks.JUNGLE_LADDER.get(),
                CWBlocks.ACACIA_LADDER.get(),
                CWBlocks.DARK_OAK_LADDER.get(),
                CWBlocks.MANGROVE_LADDER.get(),
                CWBlocks.CHERRY_LADDER.get(),
                CWBlocks.CRIMSON_LADDER.get(),
                CWBlocks.WARPED_LADDER.get(),
                CWBlocks.BAMBOO_LADDER.get(),
                CWBlocks.OAK_CHEST.get(),
                CWBlocks.TRAPPED_OAK_CHEST.get(),
                CWBlocks.SPRUCE_CHEST.get(),
                CWBlocks.TRAPPED_SPRUCE_CHEST.get(),
                CWBlocks.BIRCH_CHEST.get(),
                CWBlocks.TRAPPED_BIRCH_CHEST.get(),
                CWBlocks.JUNGLE_CHEST.get(),
                CWBlocks.TRAPPED_JUNGLE_CHEST.get(),
                CWBlocks.ACACIA_CHEST.get(),
                CWBlocks.TRAPPED_ACACIA_CHEST.get(),
                CWBlocks.DARK_OAK_CHEST.get(),
                CWBlocks.TRAPPED_DARK_OAK_CHEST.get(),
                CWBlocks.MANGROVE_CHEST.get(),
                CWBlocks.TRAPPED_MANGROVE_CHEST.get(),
                CWBlocks.CHERRY_CHEST.get(),
                CWBlocks.TRAPPED_CHERRY_CHEST.get(),
                CWBlocks.CRIMSON_CHEST.get(),
                CWBlocks.TRAPPED_CRIMSON_CHEST.get(),
                CWBlocks.WARPED_CHEST.get(),
                CWBlocks.TRAPPED_WARPED_CHEST.get(),
                CWBlocks.BAMBOO_CHEST.get(),
                CWBlocks.TRAPPED_BAMBOO_CHEST.get(),
                Blocks.CAMPFIRE,
                CWBlocks.SPRUCE_CAMPFIRE.get(),
                CWBlocks.BIRCH_CAMPFIRE.get(),
                CWBlocks.JUNGLE_CAMPFIRE.get(),
                CWBlocks.ACACIA_CAMPFIRE.get(),
                CWBlocks.DARK_OAK_CAMPFIRE.get(),
                CWBlocks.MANGROVE_CAMPFIRE.get(),
                CWBlocks.CHERRY_CAMPFIRE.get(),
                CWBlocks.CRIMSON_CAMPFIRE.get(),
                CWBlocks.WARPED_CAMPFIRE.get(),
                CWBlocks.BAMBOO_CAMPFIRE.get(),
                Blocks.SOUL_CAMPFIRE,
                CWBlocks.SOUL_SPRUCE_CAMPFIRE.get(),
                CWBlocks.SOUL_BIRCH_CAMPFIRE.get(),
                CWBlocks.SOUL_JUNGLE_CAMPFIRE.get(),
                CWBlocks.SOUL_ACACIA_CAMPFIRE.get(),
                CWBlocks.SOUL_DARK_OAK_CAMPFIRE.get(),
                CWBlocks.SOUL_MANGROVE_CAMPFIRE.get(),
                CWBlocks.SOUL_CHERRY_CAMPFIRE.get(),
                CWBlocks.SOUL_CRIMSON_CAMPFIRE.get(),
                CWBlocks.SOUL_WARPED_CAMPFIRE.get(),
                CWBlocks.SOUL_BAMBOO_CAMPFIRE.get(),
                CWBlocks.OAK_BARREL.get(),
                CWBlocks.BIRCH_BARREL.get(),
                CWBlocks.JUNGLE_BARREL.get(),
                CWBlocks.ACACIA_BARREL.get(),
                CWBlocks.DARK_OAK_BARREL.get(),
                CWBlocks.MANGROVE_BARREL.get(),
                CWBlocks.CHERRY_BARREL.get(),
                CWBlocks.CRIMSON_BARREL.get(),
                CWBlocks.WARPED_BARREL.get(),
                CWBlocks.BAMBOO_BARREL.get(),
                CWBlocks.SPRUCE_BOOKSHELF.get(),
                CWBlocks.BIRCH_BOOKSHELF.get(),
                CWBlocks.JUNGLE_BOOKSHELF.get(),
                CWBlocks.ACACIA_BOOKSHELF.get(),
                CWBlocks.DARK_OAK_BOOKSHELF.get(),
                CWBlocks.MANGROVE_BOOKSHELF.get(),
                CWBlocks.CHERRY_BOOKSHELF.get(),
                CWBlocks.CRIMSON_BOOKSHELF.get(),
                CWBlocks.WARPED_BOOKSHELF.get(),
                CWBlocks.BAMBOO_BOOKSHELF.get()
        );

        this.tag(BlockTags.STAIRS).add(
                CWBlocks.OAK_TILE_STAIRS.get(),
                CWBlocks.SPRUCE_TILE_STAIRS.get(),
                CWBlocks.BIRCH_TILE_STAIRS.get(),
                CWBlocks.JUNGLE_TILE_STAIRS.get(),
                CWBlocks.ACACIA_TILE_STAIRS.get(),
                CWBlocks.DARK_OAK_TILE_STAIRS.get(),
                CWBlocks.MANGROVE_TILE_STAIRS.get(),
                CWBlocks.CHERRY_TILE_STAIRS.get(),
                CWBlocks.CRIMSON_TILE_STAIRS.get(),
                CWBlocks.WARPED_TILE_STAIRS.get(),
                CWBlocks.BAMBOO_TILE_STAIRS.get(),
                CWBlocks.OAK_MOSAIC_STAIRS.get(),
                CWBlocks.SPRUCE_MOSAIC_STAIRS.get(),
                CWBlocks.BIRCH_MOSAIC_STAIRS.get(),
                CWBlocks.JUNGLE_MOSAIC_STAIRS.get(),
                CWBlocks.ACACIA_MOSAIC_STAIRS.get(),
                CWBlocks.DARK_OAK_MOSAIC_STAIRS.get(),
                CWBlocks.MANGROVE_MOSAIC_STAIRS.get(),
                CWBlocks.CHERRY_MOSAIC_STAIRS.get(),
                CWBlocks.CRIMSON_MOSAIC_STAIRS.get(),
                CWBlocks.WARPED_MOSAIC_STAIRS.get()
        );

        this.tag(BlockTags.SLABS).add(
                CWBlocks.OAK_TILE_SLAB.get(),
                CWBlocks.SPRUCE_TILE_SLAB.get(),
                CWBlocks.BIRCH_TILE_SLAB.get(),
                CWBlocks.JUNGLE_TILE_SLAB.get(),
                CWBlocks.ACACIA_TILE_SLAB.get(),
                CWBlocks.DARK_OAK_TILE_SLAB.get(),
                CWBlocks.MANGROVE_TILE_SLAB.get(),
                CWBlocks.CHERRY_TILE_SLAB.get(),
                CWBlocks.CRIMSON_TILE_SLAB.get(),
                CWBlocks.WARPED_TILE_SLAB.get(),
                CWBlocks.BAMBOO_TILE_SLAB.get(),
                CWBlocks.OAK_MOSAIC_SLAB.get(),
                CWBlocks.SPRUCE_MOSAIC_SLAB.get(),
                CWBlocks.BIRCH_MOSAIC_SLAB.get(),
                CWBlocks.JUNGLE_MOSAIC_SLAB.get(),
                CWBlocks.ACACIA_MOSAIC_SLAB.get(),
                CWBlocks.DARK_OAK_MOSAIC_SLAB.get(),
                CWBlocks.MANGROVE_MOSAIC_SLAB.get(),
                CWBlocks.CHERRY_MOSAIC_SLAB.get(),
                CWBlocks.CRIMSON_MOSAIC_SLAB.get(),
                CWBlocks.WARPED_MOSAIC_SLAB.get()
        );

        this.tag(Tags.Blocks.BOOKSHELVES).add(
                CWBlocks.SPRUCE_BOOKSHELF.get(),
                CWBlocks.BIRCH_BOOKSHELF.get(),
                CWBlocks.JUNGLE_BOOKSHELF.get(),
                CWBlocks.ACACIA_BOOKSHELF.get(),
                CWBlocks.DARK_OAK_BOOKSHELF.get(),
                CWBlocks.MANGROVE_BOOKSHELF.get(),
                CWBlocks.CHERRY_BOOKSHELF.get(),
                CWBlocks.CRIMSON_BOOKSHELF.get(),
                CWBlocks.WARPED_BOOKSHELF.get(),
                CWBlocks.BAMBOO_BOOKSHELF.get()
        );

        this.tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(
                CWBlocks.SPRUCE_BOOKSHELF.get(),
                CWBlocks.BIRCH_BOOKSHELF.get(),
                CWBlocks.JUNGLE_BOOKSHELF.get(),
                CWBlocks.ACACIA_BOOKSHELF.get(),
                CWBlocks.DARK_OAK_BOOKSHELF.get(),
                CWBlocks.MANGROVE_BOOKSHELF.get(),
                CWBlocks.CHERRY_BOOKSHELF.get(),
                CWBlocks.CRIMSON_BOOKSHELF.get(),
                CWBlocks.WARPED_BOOKSHELF.get(),
                CWBlocks.BAMBOO_BOOKSHELF.get()
        );

        this.tag(CWTags.Blocks.CRAFTING_TABLES).add(
                CWBlocks.SPRUCE_CRAFTING_TABLE.get(),
                CWBlocks.BIRCH_CRAFTING_TABLE.get(),
                CWBlocks.JUNGLE_CRAFTING_TABLE.get(),
                CWBlocks.ACACIA_CRAFTING_TABLE.get(),
                CWBlocks.DARK_OAK_CRAFTING_TABLE.get(),
                CWBlocks.MANGROVE_CRAFTING_TABLE.get(),
                CWBlocks.CHERRY_CRAFTING_TABLE.get(),
                CWBlocks.CRIMSON_CRAFTING_TABLE.get(),
                CWBlocks.WARPED_CRAFTING_TABLE.get(),
                CWBlocks.BAMBOO_CRAFTING_TABLE.get(),
                Blocks.CRAFTING_TABLE
        );

        this.tag(BlockTags.CLIMBABLE).add(
                CWBlocks.SPRUCE_LADDER.get(),
                CWBlocks.BIRCH_LADDER.get(),
                CWBlocks.JUNGLE_LADDER.get(),
                CWBlocks.ACACIA_LADDER.get(),
                CWBlocks.DARK_OAK_LADDER.get(),
                CWBlocks.MANGROVE_LADDER.get(),
                CWBlocks.CHERRY_LADDER.get(),
                CWBlocks.CRIMSON_LADDER.get(),
                CWBlocks.WARPED_LADDER.get(),
                CWBlocks.BAMBOO_LADDER.get()
        );

        this.tag(CWTags.Blocks.CHISELED_BOOKSHELVES).add(
                CWBlocks.CHISELED_SPRUCE_BOOKSHELF.get(),
                CWBlocks.CHISELED_BIRCH_BOOKSHELF.get(),
                CWBlocks.CHISELED_JUNGLE_BOOKSHELF.get(),
                CWBlocks.CHISELED_ACACIA_BOOKSHELF.get(),
                CWBlocks.CHISELED_DARK_OAK_BOOKSHELF.get(),
                CWBlocks.CHISELED_MANGROVE_BOOKSHELF.get(),
                CWBlocks.CHISELED_CHERRY_BOOKSHELF.get(),
                CWBlocks.CHISELED_CRIMSON_BOOKSHELF.get(),
                CWBlocks.CHISELED_WARPED_BOOKSHELF.get(),
                CWBlocks.CHISELED_BAMBOO_BOOKSHELF.get(),
                Blocks.CHISELED_BOOKSHELF
        );

        this.tag(CWTags.Blocks.LECTERNS).add(
                CWBlocks.SPRUCE_LECTERN.get(),
                CWBlocks.BIRCH_LECTERN.get(),
                CWBlocks.JUNGLE_LECTERN.get(),
                CWBlocks.ACACIA_LECTERN.get(),
                CWBlocks.DARK_OAK_LECTERN.get(),
                CWBlocks.MANGROVE_LECTERN.get(),
                CWBlocks.CHERRY_LECTERN.get(),
                CWBlocks.CRIMSON_LECTERN.get(),
                CWBlocks.WARPED_LECTERN.get(),
                CWBlocks.BAMBOO_LECTERN.get(),
                Blocks.LECTERN
        );

        this.tag(CWTags.Blocks.BEEHIVES).add(
                CWBlocks.SPRUCE_BEEHIVE.get(),
                CWBlocks.BIRCH_BEEHIVE.get(),
                CWBlocks.JUNGLE_BEEHIVE.get(),
                CWBlocks.ACACIA_BEEHIVE.get(),
                CWBlocks.DARK_OAK_BEEHIVE.get(),
                CWBlocks.MANGROVE_BEEHIVE.get(),
                CWBlocks.CHERRY_BEEHIVE.get(),
                CWBlocks.CRIMSON_BEEHIVE.get(),
                CWBlocks.WARPED_BEEHIVE.get(),
                CWBlocks.BAMBOO_BEEHIVE.get(),
                Blocks.BEEHIVE
        );

        this.tag(BlockTags.CAMPFIRES).add(
                CWBlocks.SPRUCE_CAMPFIRE.get(),
                CWBlocks.BIRCH_CAMPFIRE.get(),
                CWBlocks.JUNGLE_CAMPFIRE.get(),
                CWBlocks.ACACIA_CAMPFIRE.get(),
                CWBlocks.DARK_OAK_CAMPFIRE.get(),
                CWBlocks.MANGROVE_CAMPFIRE.get(),
                CWBlocks.CHERRY_CAMPFIRE.get(),
                CWBlocks.CRIMSON_CAMPFIRE.get(),
                CWBlocks.WARPED_CAMPFIRE.get(),
                CWBlocks.BAMBOO_CAMPFIRE.get(),
                CWBlocks.SOUL_SPRUCE_CAMPFIRE.get(),
                CWBlocks.SOUL_BIRCH_CAMPFIRE.get(),
                CWBlocks.SOUL_JUNGLE_CAMPFIRE.get(),
                CWBlocks.SOUL_ACACIA_CAMPFIRE.get(),
                CWBlocks.SOUL_DARK_OAK_CAMPFIRE.get(),
                CWBlocks.SOUL_MANGROVE_CAMPFIRE.get(),
                CWBlocks.SOUL_CHERRY_CAMPFIRE.get(),
                CWBlocks.SOUL_CRIMSON_CAMPFIRE.get(),
                CWBlocks.SOUL_WARPED_CAMPFIRE.get(),
                CWBlocks.SOUL_BAMBOO_CAMPFIRE.get()
        );

        this.tag(BlockTags.PIGLIN_REPELLENTS).add(
                CWBlocks.SOUL_SPRUCE_CAMPFIRE.get(),
                CWBlocks.SOUL_BIRCH_CAMPFIRE.get(),
                CWBlocks.SOUL_JUNGLE_CAMPFIRE.get(),
                CWBlocks.SOUL_ACACIA_CAMPFIRE.get(),
                CWBlocks.SOUL_DARK_OAK_CAMPFIRE.get(),
                CWBlocks.SOUL_MANGROVE_CAMPFIRE.get(),
                CWBlocks.SOUL_CHERRY_CAMPFIRE.get(),
                CWBlocks.SOUL_CRIMSON_CAMPFIRE.get(),
                CWBlocks.SOUL_WARPED_CAMPFIRE.get(),
                CWBlocks.SOUL_BAMBOO_CAMPFIRE.get()
        );

        this.tag(BlockTags.GUARDED_BY_PIGLINS).add(
                CWBlocks.OAK_CHEST.get(),
                CWBlocks.SPRUCE_CHEST.get(),
                CWBlocks.BIRCH_CHEST.get(),
                CWBlocks.JUNGLE_CHEST.get(),
                CWBlocks.ACACIA_CHEST.get(),
                CWBlocks.DARK_OAK_CHEST.get(),
                CWBlocks.MANGROVE_CHEST.get(),
                CWBlocks.CHERRY_CHEST.get(),
                CWBlocks.CRIMSON_CHEST.get(),
                CWBlocks.WARPED_CHEST.get(),
                CWBlocks.BAMBOO_CHEST.get(),
                CWBlocks.TRAPPED_OAK_CHEST.get(),
                CWBlocks.TRAPPED_SPRUCE_CHEST.get(),
                CWBlocks.TRAPPED_BIRCH_CHEST.get(),
                CWBlocks.TRAPPED_JUNGLE_CHEST.get(),
                CWBlocks.TRAPPED_ACACIA_CHEST.get(),
                CWBlocks.TRAPPED_DARK_OAK_CHEST.get(),
                CWBlocks.TRAPPED_MANGROVE_CHEST.get(),
                CWBlocks.TRAPPED_CHERRY_CHEST.get(),
                CWBlocks.TRAPPED_CRIMSON_CHEST.get(),
                CWBlocks.TRAPPED_WARPED_CHEST.get(),
                CWBlocks.TRAPPED_BAMBOO_CHEST.get(),
                CWBlocks.OAK_BARREL.get(),
                CWBlocks.BIRCH_BARREL.get(),
                CWBlocks.JUNGLE_BARREL.get(),
                CWBlocks.ACACIA_BARREL.get(),
                CWBlocks.DARK_OAK_BARREL.get(),
                CWBlocks.MANGROVE_BARREL.get(),
                CWBlocks.CHERRY_BARREL.get(),
                CWBlocks.CRIMSON_BARREL.get(),
                CWBlocks.WARPED_BARREL.get(),
                CWBlocks.BAMBOO_BARREL.get()
        );

        this.tag(BlockTags.FEATURES_CANNOT_REPLACE).add(
                CWBlocks.OAK_CHEST.get(),
                CWBlocks.SPRUCE_CHEST.get(),
                CWBlocks.BIRCH_CHEST.get(),
                CWBlocks.JUNGLE_CHEST.get(),
                CWBlocks.ACACIA_CHEST.get(),
                CWBlocks.DARK_OAK_CHEST.get(),
                CWBlocks.MANGROVE_CHEST.get(),
                CWBlocks.CHERRY_CHEST.get(),
                CWBlocks.CRIMSON_CHEST.get(),
                CWBlocks.WARPED_CHEST.get(),
                CWBlocks.BAMBOO_CHEST.get(),
                CWBlocks.TRAPPED_OAK_CHEST.get(),
                CWBlocks.TRAPPED_SPRUCE_CHEST.get(),
                CWBlocks.TRAPPED_BIRCH_CHEST.get(),
                CWBlocks.TRAPPED_JUNGLE_CHEST.get(),
                CWBlocks.TRAPPED_ACACIA_CHEST.get(),
                CWBlocks.TRAPPED_DARK_OAK_CHEST.get(),
                CWBlocks.TRAPPED_MANGROVE_CHEST.get(),
                CWBlocks.TRAPPED_CHERRY_CHEST.get(),
                CWBlocks.TRAPPED_CRIMSON_CHEST.get(),
                CWBlocks.TRAPPED_WARPED_CHEST.get(),
                CWBlocks.TRAPPED_BAMBOO_CHEST.get()
        );

        this.tag(Tags.Blocks.CHESTS_WOODEN).add(
                CWBlocks.OAK_CHEST.get(),
                CWBlocks.SPRUCE_CHEST.get(),
                CWBlocks.BIRCH_CHEST.get(),
                CWBlocks.JUNGLE_CHEST.get(),
                CWBlocks.ACACIA_CHEST.get(),
                CWBlocks.DARK_OAK_CHEST.get(),
                CWBlocks.MANGROVE_CHEST.get(),
                CWBlocks.CHERRY_CHEST.get(),
                CWBlocks.CRIMSON_CHEST.get(),
                CWBlocks.WARPED_CHEST.get(),
                CWBlocks.BAMBOO_CHEST.get()
        );

        this.tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).add(
                CWBlocks.OAK_CHEST.get(),
                CWBlocks.SPRUCE_CHEST.get(),
                CWBlocks.BIRCH_CHEST.get(),
                CWBlocks.JUNGLE_CHEST.get(),
                CWBlocks.ACACIA_CHEST.get(),
                CWBlocks.DARK_OAK_CHEST.get(),
                CWBlocks.MANGROVE_CHEST.get(),
                CWBlocks.CHERRY_CHEST.get(),
                CWBlocks.CRIMSON_CHEST.get(),
                CWBlocks.WARPED_CHEST.get(),
                CWBlocks.BAMBOO_CHEST.get()
        );

        this.tag(Tags.Blocks.CHESTS_TRAPPED).add(
                CWBlocks.TRAPPED_OAK_CHEST.get(),
                CWBlocks.TRAPPED_SPRUCE_CHEST.get(),
                CWBlocks.TRAPPED_BIRCH_CHEST.get(),
                CWBlocks.TRAPPED_JUNGLE_CHEST.get(),
                CWBlocks.TRAPPED_ACACIA_CHEST.get(),
                CWBlocks.TRAPPED_DARK_OAK_CHEST.get(),
                CWBlocks.TRAPPED_MANGROVE_CHEST.get(),
                CWBlocks.TRAPPED_CHERRY_CHEST.get(),
                CWBlocks.TRAPPED_CRIMSON_CHEST.get(),
                CWBlocks.TRAPPED_WARPED_CHEST.get(),
                CWBlocks.TRAPPED_BAMBOO_CHEST.get()
        );

        this.tag(Tags.Blocks.BARRELS_WOODEN).add(
                CWBlocks.OAK_BARREL.get(),
                CWBlocks.BIRCH_BARREL.get(),
                CWBlocks.JUNGLE_BARREL.get(),
                CWBlocks.ACACIA_BARREL.get(),
                CWBlocks.DARK_OAK_BARREL.get(),
                CWBlocks.MANGROVE_BARREL.get(),
                CWBlocks.CHERRY_BARREL.get(),
                CWBlocks.CRIMSON_BARREL.get(),
                CWBlocks.WARPED_BARREL.get(),
                CWBlocks.BAMBOO_BARREL.get()
        );

        this.tag(CWTags.Blocks.LADDERS).add(
                CWBlocks.SPRUCE_LADDER.get(),
                CWBlocks.BIRCH_LADDER.get(),
                CWBlocks.JUNGLE_LADDER.get(),
                CWBlocks.ACACIA_LADDER.get(),
                CWBlocks.DARK_OAK_LADDER.get(),
                CWBlocks.MANGROVE_LADDER.get(),
                CWBlocks.CHERRY_LADDER.get(),
                CWBlocks.CRIMSON_LADDER.get(),
                CWBlocks.WARPED_LADDER.get(),
                CWBlocks.BAMBOO_LADDER.get(),
                Blocks.LADDER
        );
    }
}