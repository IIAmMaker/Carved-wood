package net.im_maker.carved_wood.datagen;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CarvedWood.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        evenSimplerBlockItem(CWBlocks.CARVED_OAK_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_SPRUCE_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_BIRCH_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_JUNGLE_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_ACACIA_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_DARK_OAK_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_MANGROVE_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_CHERRY_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_CRIMSON_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_WARPED_PLANKS);
        evenSimplerBlockItem(CWBlocks.CARVED_BAMBOO_PLANKS);

        evenSimplerBlockItem(CWBlocks.OAK_LANTERN);
        evenSimplerBlockItem(CWBlocks.SPRUCE_LANTERN);
        evenSimplerBlockItem(CWBlocks.BIRCH_LANTERN);
        evenSimplerBlockItem(CWBlocks.JUNGLE_LANTERN);
        evenSimplerBlockItem(CWBlocks.ACACIA_LANTERN);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_LANTERN);
        evenSimplerBlockItem(CWBlocks.MANGROVE_LANTERN);
        evenSimplerBlockItem(CWBlocks.CHERRY_LANTERN);
        evenSimplerBlockItem(CWBlocks.CRIMSON_LANTERN);
        evenSimplerBlockItem(CWBlocks.WARPED_LANTERN);
        evenSimplerBlockItem(CWBlocks.BAMBOO_LANTERN);

        evenSimplerBlockItem(CWBlocks.OAK_BOARDS);
        evenSimplerBlockItem(CWBlocks.SPRUCE_BOARDS);
        evenSimplerBlockItem(CWBlocks.BIRCH_BOARDS);
        evenSimplerBlockItem(CWBlocks.JUNGLE_BOARDS);
        evenSimplerBlockItem(CWBlocks.ACACIA_BOARDS);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_BOARDS);
        evenSimplerBlockItem(CWBlocks.MANGROVE_BOARDS);
        evenSimplerBlockItem(CWBlocks.CHERRY_BOARDS);
        evenSimplerBlockItem(CWBlocks.CRIMSON_BOARDS);
        evenSimplerBlockItem(CWBlocks.WARPED_BOARDS);
        evenSimplerBlockItem(CWBlocks.BAMBOO_BOARDS);

        evenSimplerBlockItem(CWBlocks.SMOOTH_OAK_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_SPRUCE_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_BIRCH_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_JUNGLE_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_ACACIA_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_DARK_OAK_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_MANGROVE_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_CHERRY_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_CRIMSON_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_WARPED_BOARDS);
        evenSimplerBlockItem(CWBlocks.SMOOTH_BAMBOO_BOARDS);

        evenSimplerBlockItem(CWBlocks.OAK_TILES);
        evenSimplerBlockItem(CWBlocks.SPRUCE_TILES);
        evenSimplerBlockItem(CWBlocks.BIRCH_TILES);
        evenSimplerBlockItem(CWBlocks.JUNGLE_TILES);
        evenSimplerBlockItem(CWBlocks.ACACIA_TILES);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_TILES);
        evenSimplerBlockItem(CWBlocks.MANGROVE_TILES);
        evenSimplerBlockItem(CWBlocks.CHERRY_TILES);
        evenSimplerBlockItem(CWBlocks.CRIMSON_TILES);

        evenSimplerBlockItem(CWBlocks.OAK_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.SPRUCE_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.BIRCH_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.JUNGLE_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.ACACIA_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.MANGROVE_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.CHERRY_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.CRIMSON_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.WARPED_TILE_STAIRS);
        evenSimplerBlockItem(CWBlocks.BAMBOO_TILE_STAIRS);

        evenSimplerBlockItem(CWBlocks.OAK_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.SPRUCE_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.BIRCH_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.JUNGLE_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.ACACIA_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.MANGROVE_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.CHERRY_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.CRIMSON_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.WARPED_TILE_SLAB);
        evenSimplerBlockItem(CWBlocks.BAMBOO_TILE_SLAB);

        evenSimplerBlockItem(CWBlocks.OAK_MOSAIC);
        evenSimplerBlockItem(CWBlocks.SPRUCE_MOSAIC);
        evenSimplerBlockItem(CWBlocks.BIRCH_MOSAIC);
        evenSimplerBlockItem(CWBlocks.JUNGLE_MOSAIC);
        evenSimplerBlockItem(CWBlocks.ACACIA_MOSAIC);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_MOSAIC);
        evenSimplerBlockItem(CWBlocks.MANGROVE_MOSAIC);
        evenSimplerBlockItem(CWBlocks.CHERRY_MOSAIC);
        evenSimplerBlockItem(CWBlocks.CRIMSON_MOSAIC);
        evenSimplerBlockItem(CWBlocks.WARPED_MOSAIC);

        evenSimplerBlockItem(CWBlocks.OAK_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.SPRUCE_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.BIRCH_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.JUNGLE_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.ACACIA_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.MANGROVE_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.CHERRY_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.CRIMSON_MOSAIC_STAIRS);
        evenSimplerBlockItem(CWBlocks.WARPED_MOSAIC_STAIRS);

        evenSimplerBlockItem(CWBlocks.OAK_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.SPRUCE_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.BIRCH_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.JUNGLE_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.ACACIA_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.MANGROVE_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.CHERRY_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.CRIMSON_MOSAIC_SLAB);
        evenSimplerBlockItem(CWBlocks.WARPED_MOSAIC_SLAB);

        evenSimplerBlockItem(CWBlocks.OAK_PILLAR);
        evenSimplerBlockItem(CWBlocks.SPRUCE_PILLAR);
        evenSimplerBlockItem(CWBlocks.BIRCH_PILLAR);
        evenSimplerBlockItem(CWBlocks.JUNGLE_PILLAR);
        evenSimplerBlockItem(CWBlocks.ACACIA_PILLAR);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_PILLAR);
        evenSimplerBlockItem(CWBlocks.MANGROVE_PILLAR);
        evenSimplerBlockItem(CWBlocks.CHERRY_PILLAR);
        evenSimplerBlockItem(CWBlocks.CRIMSON_PILLAR);
        evenSimplerBlockItem(CWBlocks.WARPED_PILLAR);
        evenSimplerBlockItem(CWBlocks.BAMBOO_PILLAR);

        evenSimplerBlockItem(CWBlocks.OAK_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.SPRUCE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.BIRCH_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.JUNGLE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.ACACIA_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.MANGROVE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.CHERRY_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.CRIMSON_STEM_BUNDLE);
        evenSimplerBlockItem(CWBlocks.WARPED_STEM_BUNDLE);
        evenSimplerBlockItem(CWBlocks.BAMBOO_BUNDLE);

        evenSimplerBlockItem(CWBlocks.STRIPPED_OAK_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_SPRUCE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_BIRCH_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_JUNGLE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_ACACIA_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_DARK_OAK_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_MANGROVE_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_CHERRY_LOG_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_CRIMSON_STEM_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_WARPED_STEM_BUNDLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_BAMBOO_BUNDLE);

        evenSimplerBlockItem(CWBlocks.SPRUCE_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.BIRCH_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.JUNGLE_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.ACACIA_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.MANGROVE_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.CHERRY_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.CRIMSON_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.WARPED_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.BAMBOO_CRAFTING_TABLE);
        evenSimplerBlockItem(CWBlocks.STRIPPED_BAMBOO_BUNDLE);

        simplerBlockItem(CWBlocks.SPRUCE_LADDER);
        simplerBlockItem(CWBlocks.BIRCH_LADDER);
        simplerBlockItem(CWBlocks.JUNGLE_LADDER);
        simplerBlockItem(CWBlocks.ACACIA_LADDER);
        simplerBlockItem(CWBlocks.DARK_OAK_LADDER);
        simplerBlockItem(CWBlocks.MANGROVE_LADDER);
        simplerBlockItem(CWBlocks.CHERRY_LADDER);
        simplerBlockItem(CWBlocks.CRIMSON_LADDER);
        simplerBlockItem(CWBlocks.WARPED_LADDER);
        simplerBlockItem(CWBlocks.BAMBOO_LADDER);

        chestBlockItem(CWBlocks.OAK_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_OAK_CHEST);
        chestBlockItem(CWBlocks.SPRUCE_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_SPRUCE_CHEST);
        chestBlockItem(CWBlocks.BIRCH_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_BIRCH_CHEST);
        chestBlockItem(CWBlocks.JUNGLE_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_JUNGLE_CHEST);
        chestBlockItem(CWBlocks.ACACIA_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_ACACIA_CHEST);
        chestBlockItem(CWBlocks.DARK_OAK_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_DARK_OAK_CHEST);
        chestBlockItem(CWBlocks.MANGROVE_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_MANGROVE_CHEST);
        chestBlockItem(CWBlocks.CHERRY_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_CHERRY_CHEST);
        chestBlockItem(CWBlocks.CRIMSON_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_CRIMSON_CHEST);
        chestBlockItem(CWBlocks.WARPED_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_WARPED_CHEST);
        chestBlockItem(CWBlocks.BAMBOO_CHEST);
        chestBlockItem(CWBlocks.TRAPPED_BAMBOO_CHEST);

        BlockItem(CWBlocks.SPRUCE_CAMPFIRE);
        BlockItem(CWBlocks.BIRCH_CAMPFIRE);
        BlockItem(CWBlocks.JUNGLE_CAMPFIRE);
        BlockItem(CWBlocks.ACACIA_CAMPFIRE);
        BlockItem(CWBlocks.DARK_OAK_CAMPFIRE);
        BlockItem(CWBlocks.MANGROVE_CAMPFIRE);
        BlockItem(CWBlocks.CHERRY_CAMPFIRE);
        BlockItem(CWBlocks.CRIMSON_CAMPFIRE);
        BlockItem(CWBlocks.WARPED_CAMPFIRE);
        BlockItem(CWBlocks.BAMBOO_CAMPFIRE);

        BlockItem(CWBlocks.SOUL_SPRUCE_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_BIRCH_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_JUNGLE_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_ACACIA_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_DARK_OAK_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_MANGROVE_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_CHERRY_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_CRIMSON_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_WARPED_CAMPFIRE);
        BlockItem(CWBlocks.SOUL_BAMBOO_CAMPFIRE);

        evenSimplerBlockItem(CWBlocks.OAK_BARREL);
        evenSimplerBlockItem(CWBlocks.BIRCH_BARREL);
        evenSimplerBlockItem(CWBlocks.JUNGLE_BARREL);
        evenSimplerBlockItem(CWBlocks.ACACIA_BARREL);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_BARREL);
        evenSimplerBlockItem(CWBlocks.MANGROVE_BARREL);
        evenSimplerBlockItem(CWBlocks.CHERRY_BARREL);
        evenSimplerBlockItem(CWBlocks.CRIMSON_BARREL);
        evenSimplerBlockItem(CWBlocks.WARPED_BARREL);
        evenSimplerBlockItem(CWBlocks.BAMBOO_BARREL);

        evenSimplerBlockItem(CWBlocks.SPRUCE_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.BIRCH_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.JUNGLE_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.ACACIA_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.MANGROVE_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.CHERRY_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.CRIMSON_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.WARPED_BOOKSHELF);
        evenSimplerBlockItem(CWBlocks.BAMBOO_BOOKSHELF);

        chiseledBookshelfBlockItem(CWBlocks.CHISELED_SPRUCE_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_BIRCH_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_JUNGLE_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_ACACIA_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_DARK_OAK_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_MANGROVE_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_CHERRY_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_CRIMSON_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_WARPED_BOOKSHELF);
        chiseledBookshelfBlockItem(CWBlocks.CHISELED_BAMBOO_BOOKSHELF);

        evenSimplerBlockItem(CWBlocks.SPRUCE_LECTERN);
        evenSimplerBlockItem(CWBlocks.BIRCH_LECTERN);
        evenSimplerBlockItem(CWBlocks.JUNGLE_LECTERN);
        evenSimplerBlockItem(CWBlocks.ACACIA_LECTERN);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_LECTERN);
        evenSimplerBlockItem(CWBlocks.MANGROVE_LECTERN);
        evenSimplerBlockItem(CWBlocks.CHERRY_LECTERN);
        evenSimplerBlockItem(CWBlocks.CRIMSON_LECTERN);
        evenSimplerBlockItem(CWBlocks.WARPED_LECTERN);
        evenSimplerBlockItem(CWBlocks.BAMBOO_LECTERN);

        evenSimplerBlockItem(CWBlocks.SPRUCE_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.BIRCH_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.JUNGLE_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.ACACIA_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.DARK_OAK_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.MANGROVE_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.CHERRY_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.CRIMSON_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.WARPED_BEEHIVE);
        evenSimplerBlockItem(CWBlocks.BAMBOO_BEEHIVE);
    }

    public void chestBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(), "carved_wood:item/template_chest");
    }

    public void simplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(), "minecraft:item/generated")
                .texture("layer0", "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    public void chiseledBookshelfBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(), "carved_wood:block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_inventory");
    }

    public void BlockItem(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(), "minecraft:item/generated")
                .texture("layer0", "item/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CarvedWood.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}