package net.im_maker.carved_wood.datagen;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.tags.CWTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                               CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, lookupCompletableFuture, CarvedWood.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.STAIRS).add(
                CWBlocks.OAK_TILE_STAIRS.get().asItem(),
                CWBlocks.SPRUCE_TILE_STAIRS.get().asItem(),
                CWBlocks.BIRCH_TILE_STAIRS.get().asItem(),
                CWBlocks.JUNGLE_TILE_STAIRS.get().asItem(),
                CWBlocks.ACACIA_TILE_STAIRS.get().asItem(),
                CWBlocks.DARK_OAK_TILE_STAIRS.get().asItem(),
                CWBlocks.MANGROVE_TILE_STAIRS.get().asItem(),
                CWBlocks.CHERRY_TILE_STAIRS.get().asItem(),
                CWBlocks.CRIMSON_TILE_STAIRS.get().asItem(),
                CWBlocks.WARPED_TILE_STAIRS.get().asItem(),
                CWBlocks.BAMBOO_TILE_STAIRS.get().asItem(),
                CWBlocks.OAK_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.SPRUCE_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.BIRCH_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.JUNGLE_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.ACACIA_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.DARK_OAK_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.MANGROVE_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.CHERRY_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.CRIMSON_MOSAIC_STAIRS.get().asItem(),
                CWBlocks.WARPED_MOSAIC_STAIRS.get().asItem()
        );

        this.tag(ItemTags.SLABS).add(
                CWBlocks.OAK_TILE_SLAB.get().asItem(),
                CWBlocks.SPRUCE_TILE_SLAB.get().asItem(),
                CWBlocks.BIRCH_TILE_SLAB.get().asItem(),
                CWBlocks.JUNGLE_TILE_SLAB.get().asItem(),
                CWBlocks.ACACIA_TILE_SLAB.get().asItem(),
                CWBlocks.DARK_OAK_TILE_SLAB.get().asItem(),
                CWBlocks.MANGROVE_TILE_SLAB.get().asItem(),
                CWBlocks.CHERRY_TILE_SLAB.get().asItem(),
                CWBlocks.CRIMSON_TILE_SLAB.get().asItem(),
                CWBlocks.WARPED_TILE_SLAB.get().asItem(),
                CWBlocks.BAMBOO_TILE_SLAB.get().asItem(),
                CWBlocks.OAK_MOSAIC_SLAB.get().asItem(),
                CWBlocks.SPRUCE_MOSAIC_SLAB.get().asItem(),
                CWBlocks.BIRCH_MOSAIC_SLAB.get().asItem(),
                CWBlocks.JUNGLE_MOSAIC_SLAB.get().asItem(),
                CWBlocks.ACACIA_MOSAIC_SLAB.get().asItem(),
                CWBlocks.DARK_OAK_MOSAIC_SLAB.get().asItem(),
                CWBlocks.MANGROVE_MOSAIC_SLAB.get().asItem(),
                CWBlocks.CHERRY_MOSAIC_SLAB.get().asItem(),
                CWBlocks.CRIMSON_MOSAIC_SLAB.get().asItem(),
                CWBlocks.WARPED_MOSAIC_SLAB.get().asItem()
        );

        this.tag(CWTags.Items.CRAFTING_TABLES).add(
                CWBlocks.SPRUCE_CRAFTING_TABLE.get().asItem(),
                CWBlocks.BIRCH_CRAFTING_TABLE.get().asItem(),
                CWBlocks.JUNGLE_CRAFTING_TABLE.get().asItem(),
                CWBlocks.ACACIA_CRAFTING_TABLE.get().asItem(),
                CWBlocks.DARK_OAK_CRAFTING_TABLE.get().asItem(),
                CWBlocks.MANGROVE_CRAFTING_TABLE.get().asItem(),
                CWBlocks.CHERRY_CRAFTING_TABLE.get().asItem(),
                CWBlocks.CRIMSON_CRAFTING_TABLE.get().asItem(),
                CWBlocks.WARPED_CRAFTING_TABLE.get().asItem(),
                CWBlocks.BAMBOO_CRAFTING_TABLE.get().asItem(),
                Blocks.CRAFTING_TABLE.asItem()
        );

        this.tag(CWTags.Items.LADDERS).add(
                CWBlocks.SPRUCE_LADDER.get().asItem(),
                CWBlocks.BIRCH_LADDER.get().asItem(),
                CWBlocks.JUNGLE_LADDER.get().asItem(),
                CWBlocks.ACACIA_LADDER.get().asItem(),
                CWBlocks.DARK_OAK_LADDER.get().asItem(),
                CWBlocks.MANGROVE_LADDER.get().asItem(),
                CWBlocks.CHERRY_LADDER.get().asItem(),
                CWBlocks.CRIMSON_LADDER.get().asItem(),
                CWBlocks.WARPED_LADDER.get().asItem(),
                CWBlocks.BAMBOO_LADDER.get().asItem(),
                Blocks.LADDER.asItem()
        );

        this.tag(Tags.Items.CHESTS_WOODEN).add(
                CWBlocks.OAK_CHEST.get().asItem(),
                CWBlocks.SPRUCE_CHEST.get().asItem(),
                CWBlocks.BIRCH_CHEST.get().asItem(),
                CWBlocks.JUNGLE_CHEST.get().asItem(),
                CWBlocks.ACACIA_CHEST.get().asItem(),
                CWBlocks.DARK_OAK_CHEST.get().asItem(),
                CWBlocks.MANGROVE_CHEST.get().asItem(),
                CWBlocks.CHERRY_CHEST.get().asItem(),
                CWBlocks.CRIMSON_CHEST.get().asItem(),
                CWBlocks.WARPED_CHEST.get().asItem(),
                CWBlocks.BAMBOO_CHEST.get().asItem()
        );

        this.tag(Tags.Items.CHESTS_TRAPPED).add(
                CWBlocks.OAK_TRAPPED_CHEST.get().asItem(),
                CWBlocks.SPRUCE_TRAPPED_CHEST.get().asItem(),
                CWBlocks.BIRCH_TRAPPED_CHEST.get().asItem(),
                CWBlocks.JUNGLE_TRAPPED_CHEST.get().asItem(),
                CWBlocks.ACACIA_TRAPPED_CHEST.get().asItem(),
                CWBlocks.DARK_OAK_TRAPPED_CHEST.get().asItem(),
                CWBlocks.MANGROVE_TRAPPED_CHEST.get().asItem(),
                CWBlocks.CHERRY_TRAPPED_CHEST.get().asItem(),
                CWBlocks.CRIMSON_TRAPPED_CHEST.get().asItem(),
                CWBlocks.WARPED_TRAPPED_CHEST.get().asItem(),
                CWBlocks.BAMBOO_TRAPPED_CHEST.get().asItem()
        );

        this.tag(Tags.Items.BARRELS_WOODEN).add(
                CWBlocks.OAK_BARREL.get().asItem(),
                CWBlocks.BIRCH_BARREL.get().asItem(),
                CWBlocks.JUNGLE_BARREL.get().asItem(),
                CWBlocks.ACACIA_BARREL.get().asItem(),
                CWBlocks.DARK_OAK_BARREL.get().asItem(),
                CWBlocks.MANGROVE_BARREL.get().asItem(),
                CWBlocks.CHERRY_BARREL.get().asItem(),
                CWBlocks.CRIMSON_BARREL.get().asItem(),
                CWBlocks.WARPED_BARREL.get().asItem(),
                CWBlocks.BAMBOO_BARREL.get().asItem()
        );

        this.tag(Tags.Items.BOOKSHELVES).add(
                CWBlocks.SPRUCE_BOOKSHELF.get().asItem(),
                CWBlocks.BIRCH_BOOKSHELF.get().asItem(),
                CWBlocks.JUNGLE_BOOKSHELF.get().asItem(),
                CWBlocks.ACACIA_BOOKSHELF.get().asItem(),
                CWBlocks.DARK_OAK_BOOKSHELF.get().asItem(),
                CWBlocks.MANGROVE_BOOKSHELF.get().asItem(),
                CWBlocks.CHERRY_BOOKSHELF.get().asItem(),
                CWBlocks.CRIMSON_BOOKSHELF.get().asItem(),
                CWBlocks.WARPED_BOOKSHELF.get().asItem(),
                CWBlocks.BAMBOO_BOOKSHELF.get().asItem()
        );

        this.copy(CWTags.Blocks.CHISELED_BOOKSHELVES, CWTags.Items.CHISELED_BOOKSHELVES);
        this.copy(CWTags.Blocks.CRAFTING_TABLES, CWTags.Items.CRAFTING_TABLES);
        //this.copy(CWTags.Blocks.COMPOSTER, CWTags.Items.COMPOSTER);
        this.copy(CWTags.Blocks.BEEHIVES, CWTags.Items.BEEHIVES);
        this.copy(CWTags.Blocks.LECTERNS, CWTags.Items.LECTERNS);
    }
}