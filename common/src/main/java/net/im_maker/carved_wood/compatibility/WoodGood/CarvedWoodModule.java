package net.im_maker.carved_wood.compatibility.WoodGood;

import com.mojang.blaze3d.platform.NativeImage;
import net.im_maker.carved_wood.common.block.*;
import net.im_maker.carved_wood.common.block.chiseled_bookshelf.CWChiseledBookShelfBlockType1;
import net.im_maker.carved_wood.common.registers.CWBlockEntityTypes;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.common.util.CWTags;
import net.im_maker.carved_wood.common.util.ConventionalTags;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.PaletteStrategies;
import net.mehvahdjukaar.every_compat.api.RenderLayer;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.every_compat.common_classes.*;
import net.mehvahdjukaar.every_compat.misc.CompatSpritesHelper;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.mehvahdjukaar.moonlight.api.resources.BlockTypeResTransformer;
import net.mehvahdjukaar.moonlight.api.resources.RPUtils;
import net.mehvahdjukaar.moonlight.api.resources.pack.ResourceGenTask;
import net.mehvahdjukaar.moonlight.api.resources.pack.ResourceSink;
import net.mehvahdjukaar.moonlight.api.resources.textures.Palette;
import net.mehvahdjukaar.moonlight.api.resources.textures.Respriter;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodChildKeys;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.mehvahdjukaar.moonlight.core.misc.McMetaFile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class CarvedWoodModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> craftingTables;
    public final SimpleEntrySet<WoodType, Block> crafters;
    public final SimpleEntrySet<WoodType, Block> chests;
    public final SimpleEntrySet<WoodType, Block> trappedChests;
    public final SimpleEntrySet<WoodType, Block> barrels;
    public final SimpleEntrySet<WoodType, Block> ladders;
    public final SimpleEntrySet<WoodType, Block> beehives;
    public final SimpleEntrySet<WoodType, Block> lecterns;
    public final SimpleEntrySet<WoodType, Block> bookshelves;
    public final SimpleEntrySet<WoodType, Block> chiseledBookshelves;
    public final SimpleEntrySet<WoodType, Block> campfires;
    public final SimpleEntrySet<WoodType, Block> soulCampfires;
    public final SimpleEntrySet<WoodType, Block> logBundles;
    public final SimpleEntrySet<WoodType, Block> strippedLogBundles;
    //public final SimpleEntrySet<WoodType, Block> bambooBundles;
    //public final SimpleEntrySet<WoodType, Block> strippedBambooBundles;
    public final SimpleEntrySet<WoodType, Block> woodenPanels;
    public final SimpleEntrySet<WoodType, Block> woodenBoards;
    public final SimpleEntrySet<WoodType, Block> woodenSmoothBoards;
    public final SimpleEntrySet<WoodType, Block> woodenTiles;
    public final SimpleEntrySet<WoodType, Block> woodenMosaics;
    public final SimpleEntrySet<WoodType, Block> woodenPillars;
    public final SimpleEntrySet<WoodType, Block> carvedPlanks;
    public final SimpleEntrySet<WoodType, Block> largeWoodenLanterns;
    public final SimpleEntrySet<WoodType, Block> woodenLanterns;
    public final SimpleEntrySet<WoodType, Block> woodenMosaicStairs;
    public final SimpleEntrySet<WoodType, Block> woodenTileStairs;
    public final SimpleEntrySet<WoodType, Block> woodenMosaicSlab;
    public final SimpleEntrySet<WoodType, Block> woodenTileSlab;

    public CarvedWoodModule(String modId) {
        super(modId, "crwo", EveryCompat.MOD_ID);
        ResourceKey<CreativeModeTab> BUILDING_BLOCKS_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("building_blocks"));
        ResourceKey<CreativeModeTab> tab = BUILDING_BLOCKS_TAB;

        //REASON: take a look at their textures, you'll see why.
        //.excludeBlockTypes("natures_spirit", "joshua")
        //.excludeBlockTypes("natures_spirit", "coconut")
        //.excludeBlockTypes("minecraft", "pale_oak")
        //.excludeBlockTypes("terrestria", "yucca_palm")
        //TEXTURE: log

        craftingTables = SimpleEntrySet.builder(WoodType.class, "crafting_table",
                        () -> CWBlocks.SPRUCE_CRAFTING_TABLE.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWCraftingTableBlock(Utils.copyPropertySafe(w.log)))
                .addTextureM(modRes("block/spruce_crafting_table_front"), EveryCompat.res("block/crwo/spruce_crafting_table_front_m"))
                .addTextureM(modRes("block/spruce_crafting_table_side"), EveryCompat.res("block/crwo/spruce_crafting_table_side_m"))
                .addTextureM(modRes("block/spruce_crafting_table_top"), EveryCompat.res("block/crwo/spruce_crafting_table_top_m"))
                .addTag(CWTags.Items.CRAFTING_TABLES, Registries.ITEM)
                .addTag(ConventionalTags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES, Registries.ITEM)
                .addTag(CWTags.Blocks.CRAFTING_TABLES, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.PLAYER_WORKSTATIONS_CRAFTING_TABLES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(craftingTables);

        crafters = SimpleEntrySet.builder(WoodType.class, "crafter",
                        () -> CWBlocks.ACACIA_CRAFTER.get(), () -> VanillaWoodTypes.ACACIA,
                        w -> new CWCrafterBlock(Utils.copyPropertySafe(w.log)))
                .addTextureM(modRes("block/acacia_crafter_east"), EveryCompat.res("block/crwo/acacia_crafter_east_m"))
                .addTextureM(modRes("block/acacia_crafter_east_crafting"), EveryCompat.res("block/crwo/acacia_crafter_east_crafting_m"))
                .addTextureM(modRes("block/acacia_crafter_east_triggered"), EveryCompat.res("block/crwo/acacia_crafter_east_triggered_m"))
                .addTextureM(modRes("block/acacia_crafter_north"), EveryCompat.res("block/crwo/acacia_crafter_north_m"))
                .addTextureM(modRes("block/acacia_crafter_north_crafting"), EveryCompat.res("block/crwo/acacia_crafter_north_crafting_m"))
                .addTextureM(modRes("block/acacia_crafter_south"), EveryCompat.res("block/crwo/acacia_crafter_south_m"))
                .addTextureM(modRes("block/acacia_crafter_south_triggered"), EveryCompat.res("block/crwo/acacia_crafter_south_triggered_m"))
                .addTextureM(modRes("block/acacia_crafter_west"), EveryCompat.res("block/crwo/acacia_crafter_west_m"))
                .addTextureM(modRes("block/acacia_crafter_west_crafting"), EveryCompat.res("block/crwo/acacia_crafter_west_crafting_m"))
                .addTextureM(modRes("block/acacia_crafter_west_triggered"), EveryCompat.res("block/crwo/acacia_crafter_west_triggered_m"))
                .addTag(CWTags.Items.CRAFTERS, Registries.ITEM)
                .addTag(CWTags.Blocks.CRAFTERS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE, Registries.BLOCK)
                .addTag(BlockTags.INCORRECT_FOR_WOODEN_TOOL, Registries.BLOCK)
                .addTag(BlockTags.INCORRECT_FOR_GOLD_TOOL, Registries.BLOCK)
                .addTag(BlockTags.NEEDS_STONE_TOOL, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.CRAFTER.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(crafters);

        chests = SimpleEntrySet.builder(WoodType.class, "chest",
                        getModBlock("oak_chest"), () -> VanillaWoodTypes.OAK,
                        w -> new CompatChestBlock(this::getChestTile, Utils.copyPropertySafe(w.planks)))
                .setTabKey(tab)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.GUARDED_BY_PIGLINS, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.CHESTS, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.WOODEN_CHESTS, Registries.BLOCK)
                .addTag(ConventionalTags.Items.CHESTS, Registries.ITEM)
                .addTag(ConventionalTags.Items.WOODEN_CHESTS, Registries.ITEM)
                .addTile(crwoChestBlockEntity::new)
                .addCustomItem((w, block, properties) -> new CompatChestItem(block, properties))
                .defaultRecipe()
                .build();
        this.addEntry(chests);

        trappedChests = SimpleEntrySet.builder(WoodType.class, "chest", "trapped",
                        getModBlock("trapped_oak_chest"), () -> VanillaWoodTypes.OAK,
                        w -> new CompatTrappedChestBlock(this::getChestTrappedTile, Utils.copyPropertySafe(w.planks)))
                .setTabKey(tab)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.GUARDED_BY_PIGLINS, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.CHESTS, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.WOODEN_CHESTS, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.TRAPPED_CHESTS, Registries.BLOCK)
                .addTag(ConventionalTags.Items.CHESTS, Registries.ITEM)
                .addTag(ConventionalTags.Items.WOODEN_CHESTS, Registries.ITEM)
                .addTag(ConventionalTags.Items.TRAPPED_CHESTS, Registries.ITEM)
                .addTile(crwoChestTrappedBlockEntity::new)
                .addCustomItem((w, block, properties) -> new CompatChestItem(block, properties))
                //.addModelTransform(m -> m.addModifier((s, blockId, woodType) ->
                //                s.replace(
                //                        "\"carved_wood:chest/trapped_oak_chest\"",
                //                        "\"" + woodType.createFullIdWith(EveryCompat.MOD_ID, "chest", shortenedId(), "trapped", "chest") + "\""
                //                )
                //        )
                //)
                .defaultRecipe()
                .build();
        this.addEntry(trappedChests);

        barrels = SimpleEntrySet.builder(WoodType.class, "barrel",
                        () -> CWBlocks.OAK_BARREL.get(), () -> VanillaWoodTypes.OAK,
                        w -> new CWBarrelBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(EveryCompat.res("block/oak_barrel_bottom"))
                .addTexture(EveryCompat.res("block/oak_barrel_top_open"))
                .addTextureM(EveryCompat.res("block/oak_barrel_top"), EveryCompat.res("block/crwo/oak_barrel_top_m"))
                .addTextureM(EveryCompat.res("block/oak_barrel_side"), EveryCompat.res("block/crwo/oak_barrel_side_m"))
                .addTag(ConventionalTags.Items.WOODEN_BARRELS, Registries.ITEM)
                .addTag(ConventionalTags.Items.VILLAGER_JOB_SITES, Registries.ITEM)
                .addTag(ConventionalTags.Blocks.VILLAGER_JOB_SITES, Registries.BLOCK)
                .addTag(BlockTags.GUARDED_BY_PIGLINS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ConventionalTags.Blocks.WOODEN_BARRELS, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.BARREL.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(barrels);

        ladders = SimpleEntrySet.builder(WoodType.class, "ladder",
                        () -> CWBlocks.SPRUCE_LADDER.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWLadderBlock(Utils.copyPropertySafe(Blocks.LADDER)
                                .strength(0.4F)
                                .noOcclusion()
                                .pushReaction(PushReaction.DESTROY)))
                .addTextureM(modRes("block/spruce_ladder"), EveryCompat.res("block/crwo/spruce_ladder_m"))
                .setRenderType(RenderLayer.CUTOUT)
                .addTag(CWTags.Items.LADDERS, Registries.ITEM)
                .addTag(CWTags.Blocks.LADDERS, Registries.BLOCK)
                .addTag(BlockTags.FALL_DAMAGE_RESETTING, Registries.BLOCK)
                .addTag(BlockTags.CLIMBABLE, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(ladders);

        beehives = SimpleEntrySet.builder(WoodType.class, "beehive",
                        () -> CWBlocks.SPRUCE_BEEHIVE.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWBeehiveBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/spruce_beehive_end"))
                .addTextureM(modRes("block/spruce_beehive_front"), EveryCompat.res("block/crwo/spruce_beehive_front_m"))
                .addTextureM(modRes("block/spruce_beehive_front_honey"), EveryCompat.res("block/crwo/spruce_beehive_front_honey_m"))
                .addTextureM(modRes("block/spruce_beehive_side"), EveryCompat.res("block/crwo/spruce_beehive_side_m"))
                .addTag(CWTags.Items.BEEHIVES, Registries.ITEM)
                .addTag(BlockTags.BEEHIVES, Registries.BLOCK)
                .addTag(BlockTags.DOES_NOT_BLOCK_HOPPERS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.BEEHIVE.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(beehives);

        lecterns = SimpleEntrySet.builder(WoodType.class, "lectern",
                        () -> CWBlocks.SPRUCE_LECTERN.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWLecternBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/spruce_lectern_sides"))
                .addTexture(modRes("block/spruce_lectern_top"))
                .addTextureM(modRes("block/spruce_lectern_base"), EveryCompat.res("block/crwo/spruce_lectern_base_m"))
                .addTextureM(modRes("block/spruce_lectern_front"), EveryCompat.res("block/crwo/spruce_lectern_front_m"))
                .addTag(CWTags.Items.LECTERNS, Registries.ITEM)
                .addTag(ConventionalTags.Items.VILLAGER_JOB_SITES, Registries.ITEM)
                .addTag(ConventionalTags.Blocks.VILLAGER_JOB_SITES, Registries.BLOCK)
                .addTag(CWTags.Blocks.LECTERNS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.LECTERN.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(lecterns);

        //if (ModList.get().isLoaded("create")) {
        //    lecternsControllers = SimpleEntrySet.builder(WoodType.class, "lectern_controller",
        //                    CWBlocks.SPRUCE_LECTERN_CONTROLLER, () -> VanillaWoodTypes.SPRUCE,
        //                    w -> new CWLecternControllerBlock(Utils.copyPropertySafe(w.log)))
        //            .addTexture(modRes("block/spruce_lectern_sides"))
        //            .addTexture(modRes("block/spruce_lectern_top"))
        //            .addTextureM(modRes("block/spruce_lectern_base"), EveryCompat.res("block/crwo/spruce_lectern_base_m"))
        //            .addTextureM(modRes("block/spruce_lectern_front"), EveryCompat.res("block/crwo/spruce_lectern_front_m"))
        //            //.addTag(CWTags.Items.LECTERNS, Registries.ITEM)
        //            //.addTag(Tags.Items.VILLAGER_JOB_SITES, Registries.ITEM)
        //            //.addTag(Tags.Blocks.VILLAGER_JOB_SITES, Registries.BLOCK)
        //            //.addTag(CWTags.Blocks.LECTERNS, Registries.BLOCK)
        //            .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
        //            .setTabKey(tab)
        //            .defaultRecipe()
        //            .copyParentDrop()
        //            .build();
        //}else
        //
        //this.addEntry(lecternsControllers);

        bookshelves = SimpleEntrySet.builder(WoodType.class, "bookshelf",
                        () -> CWBlocks.SPRUCE_BOOKSHELF.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new BookshelfBlock(Utils.copyPropertySafe(w.log)))
                .addTextureM(modRes("block/spruce_bookshelf"), EveryCompat.res("block/crwo/spruce_bookshelf_m"), PaletteStrategies.registerCached((blockType, manager) -> PaletteStrategies.makePaletteFromChild(blockType, manager, "planks", (Predicate)null, (p) -> {
                    p.increaseUp();p.reduceDown();
                    p.increaseUp();p.reduceDown();
                    p.increaseUp();p.reduceDown();
                })))
                .addTag(ConventionalTags.Items.BOOKSHELVES, Registries.ITEM)
                .addTag(ConventionalTags.Blocks.BOOKSHELVES, Registries.BLOCK)
                .addTag(BlockTags.ENCHANTMENT_POWER_PROVIDER, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(bookshelves);

        chiseledBookshelves = SimpleEntrySet.builder(WoodType.class, "bookshelf", "chiseled",
                        () -> CWBlocks.CHISELED_SPRUCE_BOOKSHELF.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWChiseledBookShelfBlockType1(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/chiseled_spruce_bookshelf_top"))
                .addTexture(modRes("block/chiseled_spruce_bookshelf_side"))
                .addTexture(modRes("block/chiseled_spruce_bookshelf_empty"), PaletteStrategies.registerCached((blockType, manager) -> PaletteStrategies.makePaletteFromChild(blockType, manager, "planks", (Predicate)null, (p) -> {
                    p.reduceUp();
                    p.increaseDown();
                    p.increaseDown();
                })))
                .addTextureM(modRes("block/chiseled_spruce_bookshelf_occupied"), EveryCompat.res("block/crwo/chiseled_spruce_bookshelf_occupied_m"), PaletteStrategies.registerCached((blockType, manager) -> PaletteStrategies.makePaletteFromChild(blockType, manager, "planks", (Predicate)null, (p) -> {
                    p.increaseDown();
                    p.increaseDown();
                    p.increaseDown();
                })))
                .addTag(CWTags.Items.CHISELED_BOOKSHELVES, Registries.ITEM)
                .addTag(CWTags.Blocks.CHISELED_BOOKSHELVES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.CHISELED_BOOKSHELF.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(chiseledBookshelves);

        logBundles = SimpleEntrySet.builder(WoodType.class, "log_bundle",
                        () -> CWBlocks.OAK_LOG_BUNDLE.get(), () -> VanillaWoodTypes.OAK,
                        w -> new StrippableLogBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .requiresChildren(VanillaWoodChildKeys.LOG)
                .build();
        this.addEntry(logBundles);

        strippedLogBundles = SimpleEntrySet.builder(WoodType.class, "log_bundle", "stripped",
                        () -> CWBlocks.STRIPPED_OAK_LOG_BUNDLE.get(), () -> VanillaWoodTypes.OAK,
                        w -> new LogBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .requiresChildren(VanillaWoodChildKeys.STRIPPED_LOG)
                .build();
        this.addEntry(strippedLogBundles);

        //bambooBundles = SimpleEntrySet.builder(WoodType.class, "bundle",
        //                CWBlocksCommon.BAMBOO_BUNDLE, () -> VanillaWoodTypes.BAMBOO,
        //                w -> new StrippableLogBlock(Utils.copyPropertySafe(w.log)))
        //        .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
        //        //.addTag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(l.get, )), Registries.BLOCK)
        //        .setTabKey(tab)
        //        .defaultRecipe()
        //        .copyParentDrop()
        //        .requiresChildren("block")
        //        .build();
        //this.addEntry(bambooBundles);

        //strippedBambooBundles = SimpleEntrySet.builder(WoodType.class, "bundle", "stripped",
        //                CWBlocksCommon.STRIPPED_BAMBOO_BUNDLE, () -> VanillaWoodTypes.BAMBOO,
        //                w -> new LogBlock(Utils.copyPropertySafe(w.log)))
        //        .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
        //        .setTabKey(tab)
        //        .defaultRecipe()
        //        .copyParentDrop()
        //        .requiresChildren("block")
        //        .build();
        //this.addEntry(strippedBambooBundles);

        campfires = SimpleEntrySet.builder(WoodType.class, "campfire",
                        () -> CWBlocks.SPRUCE_CAMPFIRE.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWCampfireBlock(false, campfireProperties(15)))
                .addTextureM(modRes("item/spruce_campfire"), EveryCompat.res("item/crwo/campfire_m"))
                .addTextureM(modRes("item/soul_spruce_campfire"), EveryCompat.res("item/crwo/campfire_m"))
                .setRenderType(RenderLayer.CUTOUT)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.CAMPFIRES, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.CAMPFIRE.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(campfires);

        soulCampfires = SimpleEntrySet.builder(WoodType.class, "campfire", "soul",
                        () -> CWBlocks.SOUL_SPRUCE_CAMPFIRE.get(), () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWCampfireBlock(true, campfireProperties(10)))
                .addTextureM(modRes("block/spruce_campfire_log_lit"), EveryCompat.res("block/crwo/campfire_log_lit_m"), PaletteStrategies.LOG_SIDE_STANDARD)
                .addTextureM(modRes("block/soul_spruce_campfire_log_lit"), EveryCompat.res("block/crwo/campfire_log_lit_m"), PaletteStrategies.LOG_SIDE_STANDARD)
                .setRenderType(RenderLayer.CUTOUT)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.CAMPFIRES, Registries.BLOCK)
                .addTag(BlockTags.PIGLIN_REPELLENTS, Registries.BLOCK)
                .addTile(() -> CWBlockEntityTypes.CAMPFIRE.get())
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(soulCampfires);

        woodenPanels = SimpleEntrySet.builder(WoodType.class, "panels",
                        () -> CWBlocks.OAK_PANELS.get(), () -> VanillaWoodTypes.OAK,
                        w -> new BigBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/oak_panels"))
                .addTexture(modRes("block/oak_panels_odd"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenPanels);

        woodenBoards = SimpleEntrySet.builder(WoodType.class, "boards",
                        () -> CWBlocks.OAK_BOARDS.get(), () -> VanillaWoodTypes.OAK,
                        w -> new PlanksBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/oak_boards"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenBoards);

        woodenSmoothBoards = SimpleEntrySet.builder(WoodType.class, "boards", "smooth",
                        () -> CWBlocks.SMOOTH_OAK_BOARDS.get(), () -> VanillaWoodTypes.OAK,
                        w -> new PlanksBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/smooth_oak_boards"), PaletteStrategies.registerCached((blockType, manager) -> PaletteStrategies.makePaletteFromChild(blockType, manager, "planks", (Predicate)null, (p) -> {
                    p.reduceDown();
                    p.reduceDown();
                    p.reduceUp();
                })))                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenSmoothBoards);

        woodenTiles = SimpleEntrySet.builder(WoodType.class, "tiles",
                        () -> CWBlocks.OAK_TILES.get(), () -> VanillaWoodTypes.OAK,
                        w -> new PlanksBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/oak_tiles"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenTiles);

        woodenMosaics = SimpleEntrySet.builder(WoodType.class, "mosaic",
                        () -> CWBlocks.DARK_OAK_MOSAIC.get(), () -> VanillaWoodTypes.DARK_OAK,
                        w -> new PlanksBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/dark_oak_mosaic"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenMosaics);

        woodenPillars = SimpleEntrySet.builder(WoodType.class, "pillar",
                        () -> CWBlocks.OAK_PILLAR.get(), () -> VanillaWoodTypes.OAK,
                        w -> new LogBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/oak_pillar"))
                .addTexture(modRes("block/oak_pillar_top"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenPillars);

        carvedPlanks = SimpleEntrySet.builder(WoodType.class, "planks", "carved",
                        () -> CWBlocks.CARVED_OAK_PLANKS.get(), () -> VanillaWoodTypes.OAK,
                        w -> new CarvedPlanksBlock(Utils.copyPropertySafe(w.log)))
                .addTexture(modRes("block/carved_oak_planks"))
                .addTexture(modRes("block/carved_oak_planks_top"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(carvedPlanks);

        largeWoodenLanterns = SimpleEntrySet.builder(WoodType.class, "lantern_block",
                        () -> CWBlocks.OAK_LANTERN_BLOCK.get(), () -> VanillaWoodTypes.OAK,
                        w -> new CarvedPlanksBlock(Utils.copyPropertySafe(w.log).lightLevel(lightValue(15))))
                .addTextureM(modRes("block/oak_lantern_block"), EveryCompat.res("block/crwo/oak_lantern_block_m"))
                .addTextureM(modRes("block/oak_lantern_block_top"), EveryCompat.res("block/crwo/oak_lantern_block_top_m"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(largeWoodenLanterns);

        woodenLanterns = SimpleEntrySet.builder(WoodType.class, "lantern",
                        () -> CWBlocks.OAK_LANTERN.get(), () -> VanillaWoodTypes.OAK,
                        w -> new WoodenLanternBlock(Utils.copyPropertySafe(w.log).forceSolidOn().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel(lightValue(15))))
                .addTextureM(modRes("block/oak_lantern"), EveryCompat.res("block/crwo/oak_lantern_m"))
                .setRenderType(RenderLayer.CUTOUT)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenLanterns);

        woodenMosaicStairs = SimpleEntrySet.builder(WoodType.class, "mosaic_stairs",
                        () -> CWBlocks.DARK_OAK_MOSAIC_STAIRS.get(), () -> VanillaWoodTypes.DARK_OAK,
                        w -> new PlanksStairBlock(w.planks.defaultBlockState(),Utils.copyPropertySafe(w.log)))
                .addTag(ItemTags.WOODEN_STAIRS, Registries.ITEM)
                .addTag(BlockTags.WOODEN_STAIRS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenMosaicStairs);

        woodenTileStairs = SimpleEntrySet.builder(WoodType.class, "tile_stairs",
                        () -> CWBlocks.OAK_TILE_STAIRS.get(), () -> VanillaWoodTypes.OAK,
                        w -> new PlanksStairBlock(w.planks.defaultBlockState(),Utils.copyPropertySafe(w.log)))
                .addTag(ItemTags.WOODEN_STAIRS, Registries.ITEM)
                .addTag(BlockTags.WOODEN_STAIRS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenTileStairs);

        woodenMosaicSlab = SimpleEntrySet.builder(WoodType.class, "mosaic_slab",
                        () -> CWBlocks.DARK_OAK_MOSAIC_SLAB.get(), () -> VanillaWoodTypes.DARK_OAK,
                        w -> new PlanksSlabBlock(Utils.copyPropertySafe(w.log)))
                .addTag(ItemTags.WOODEN_SLABS, Registries.ITEM)
                .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenMosaicSlab);

        woodenTileSlab = SimpleEntrySet.builder(WoodType.class, "tile_slab",
                        () -> CWBlocks.OAK_TILE_SLAB.get(), () -> VanillaWoodTypes.OAK,
                        w -> new PlanksSlabBlock(Utils.copyPropertySafe(w.log)))
                .addTag(ItemTags.WOODEN_SLABS, Registries.ITEM)
                .addTag(BlockTags.WOODEN_SLABS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentDrop()
                .build();
        this.addEntry(woodenTileSlab);

        //if (PlatHelper.isFabric()) {
        //    simpleAddBlocksToPOI(beehives, PoiTypes.BEEHIVE);
        //    simpleAddBlocksToPOI(barrels, PoiTypes.FISHERMAN);
        //    simpleAddBlocksToPOI(lecterns, PoiTypes.LIBRARIAN);
        //}
    }

    public static void simpleAddBlocksToPOI(SimpleEntrySet<WoodType, Block> entrySet, ResourceKey<PoiType> poiType) {
        RegHelper.addExtraPOIStatesRegistration((event) -> entrySet.blocks.values().forEach((block) -> event.addBlockToPoi(poiType, block)));
    }

    // BlockEntity -----------------------------------------------------------------------------------------------------------
    private class crwoChestBlockEntity extends CompatChestBlockEntity {
        public crwoChestBlockEntity(BlockPos pos, BlockState state) {
            super(chests.getTile(), pos, state);
        }
    }

    private class crwoChestTrappedBlockEntity extends CompatChestBlockEntity {
        public crwoChestTrappedBlockEntity(BlockPos pos, BlockState state) {
            super(trappedChests.getTile(), pos, state);
        }
    }

    @Override
    public void addDynamicClientResources(Consumer<ResourceGenTask> executor) {
        super.addDynamicClientResources(executor);
        executor.accept((manager, sink) -> {
        //!! bundled_<type>_posts
            //try (TextureImage BPTopInnerMask = TextureImage.open(manager,
            //        EveryCompat.res("block/crwo/bamboo_block_bundle_top_inner_m"));
            //     TextureImage BPTopOuterMask = TextureImage.open(manager,
            //             EveryCompat.res("block/crwo/bamboo_block_bundle_top_outer_m"));
//
            //     TextureImage logInnerMask = TextureImage.open(manager,
            //             EveryCompat.res("block/crwo/bamboo_block_top_inner_m"));
            //     TextureImage logOuterMask = TextureImage.open(manager,
            //             EveryCompat.res("block/crwo/bamboo_block_top_outer_m"))
            //) {
            //    bambooBundles.blocks.forEach((w, block) -> {
            //        String newPath = "block/" + shortenedId() + "/" + w.getNamespace() + "/"+ w.getTypeName() + "_bundle";
//
            //        createTexture(newPath, w.log, logInnerMask, logOuterMask, BPTopInnerMask, BPTopOuterMask,
            //                modRes("block/bamboo_bundle"),
            //                modRes("block/bamboo_bundle_top"),
            //                sink, manager, block);
            //    });
//
            //    strippedBambooBundles.blocks.forEach((w, block) -> {
            //        String newPath = "block/" + shortenedId() + "/" + w.getNamespace() + "/stripped_" + w.getTypeName() + "_bundle";
//
            //        createTexture(newPath, w.getBlockOfThis("stripped_log"), logInnerMask, logOuterMask, BPTopInnerMask, BPTopOuterMask,
            //                modRes("block/stripped_bamboo_bundle"),
            //                modRes("block/stripped_bamboo_bundle_top"),
            //                sink, manager, block);
            //    });
            //} catch (Exception e) {
            //    EveryCompat.LOGGER.error("Failed to open bamboo_bundle texture: ", e);
            //}
            try (TextureImage BPTopInnerMask = TextureImage.open(manager,
                    EveryCompat.res("block/crwo/log_bundle_top_inner_m"));
                 TextureImage BPTopOuterMask = TextureImage.open(manager,
                         EveryCompat.res("block/crwo/log_bundle_top_outer_m"));

                 TextureImage logInnerMask = TextureImage.open(manager,
                         EveryCompat.res("block/common_log_top_inner_m"));
                 TextureImage logOuterMask = TextureImage.open(manager,
                         EveryCompat.res("block/common_log_top_outer_m"))
            ) {

                logBundles.blocks.forEach((w, block) -> {
                    boolean b = (w.log.builtInRegistryHolder().key().toString().contains("log"));
                    String ss = true ? "oak_log" : "bamboo";

                    String newPath = "block/" + shortenedId() + "/" + w.getNamespace() + "/"+ w.getTypeName() + (true ? "_log" : "") + "_bundle";

                    createTexture(newPath, w.log, logInnerMask, logOuterMask, BPTopInnerMask, BPTopOuterMask,
                            modRes("block/"+ss+"_bundle"),
                            modRes("block/"+ss+"_bundle_top"),
                            sink, manager, block, b);
                });

                strippedLogBundles.blocks.forEach((w, block) -> {
                    boolean b = (w.log.builtInRegistryHolder().key().toString().contains("log"));
                    String ss = true ? "oak_log" : "bamboo";

                    String newPath = "block/" + shortenedId() + "/" + w.getNamespace() + "/stripped_" + w.getTypeName() + (true ? "_log" : "") + "_bundle";

                    createTexture(newPath, w.getBlockOfThis("stripped_log"), logInnerMask, logOuterMask, BPTopInnerMask, BPTopOuterMask,
                            modRes("block/stripped_"+ss+"_bundle"),
                            modRes("block/stripped_"+ss+"_bundle_top"),
                            sink, manager, block, b);
                });
            } catch (Exception e) {
                EveryCompat.LOGGER.error("Failed to open log_bundle texture: ", e);
            }
        });

        executor.accept(this::makeCampfireTextures);

        executor.accept((manager, sink) ->
                trappedChests.blocks.forEach((wood, block) -> {
                    boolean woodOrBamboo = (wood.log.builtInRegistryHolder().key().toString().contains("log"));
                    String woodType = true ? "oak" : "bamboo";
                    // SINGLE
                    CompatChestTexture.generateChestTexture(sink, manager, shortenedId(), wood, block,
                            modRes("entity/chest/"+woodType+"/normal"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_normal_m"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_normal_o"),
                            EveryCompat.res("model/crwo/trapped_chest_normal")
                    );
                    // LEFT
                    CompatChestTexture.generateChestTexture(sink, manager, shortenedId(), wood, block,
                            modRes("entity/chest/"+woodType+"/normal_left"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_left_m"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_left_o"),
                            EveryCompat.res("model/crwo/trapped_chest_left")
                    );
                    // RIGHT
                    CompatChestTexture.generateChestTexture(sink, manager, shortenedId(), wood, block,
                            modRes("entity/chest/"+woodType+"/normal_right"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_right_m"),
                            EveryCompat.res("model/crwo/"+woodType+"_chest_right_o"),
                            EveryCompat.res("model/crwo/trapped_chest_right")
                    );
                })
        );
    }

    private void makeCampfireTextures(ResourceManager manager, ResourceSink sink) {
        String campfirePath = "block/spruce_campfire_log";
        ResourceLocation campfireImage = modRes(campfirePath);
        ResourceLocation targetLogMask = EveryCompat.res("block/crwo/campfire_log_m");
        ResourceLocation targetPlankMask = EveryCompat.res("block/crwo/campfire_plank_m");

        try (
                TextureImage textureImage = TextureImage.open(manager, campfireImage);
             TextureImage targetLogImage = TextureImage.open(manager, targetLogMask);
             TextureImage targetPlankImage = TextureImage.open(manager, targetPlankMask)
        ) {
            Respriter respriterLog = Respriter.masked(textureImage, targetLogImage);

            campfires.blocks.forEach((wood, block) -> {
                ResourceLocation id = Utils.getID(block);

                try (
                        TextureImage plankTexture = TextureImage.open(manager,
                                RPUtils.findFirstBlockTextureLocation(manager, wood.planks));
                        TextureImage logTexture = TextureImage.open(manager,
                                RPUtils.findFirstBlockTextureLocation(manager, wood.log, CompatSpritesHelper.LOOKS_LIKE_SIDE_LOG_TEXTURE))
                ) {
                    String newPath = BlockTypeResTransformer.replaceTypeNoNamespace(campfirePath, wood, id, "spruce");

                    // Adding to the resource
                    sink.addTextureIfNotPresent(manager, newPath, () -> {
                        // Recoloring the plank part
                        try (TextureImage recoloredLog = respriterLog.recolorWithAnimationOf(logTexture)) {
                            Respriter respriterPlank = Respriter.masked(recoloredLog, targetPlankImage);
                            return respriterPlank.recolorWithAnimationOf(plankTexture);
                        }
                    });

                } catch (IOException e) {
                    EveryCompat.LOGGER.error("Failed to open log/plank texture file: ", e);
                }
            });
        } catch (IOException e) {
            EveryCompat.LOGGER.error("Failed to open texture file: ", e);
        }
    }

    private void createTexture(String newPath, Block getLogBlock, TextureImage logInnerMask, TextureImage logOuterMask, TextureImage BPTopInnerMask, TextureImage BPTopOuterMask, ResourceLocation getLogSide, ResourceLocation getLogTop, ResourceSink sink, ResourceManager manager, Block block, boolean b) {
        try (TextureImage logSide_texture = TextureImage.open(manager,
                RPUtils.findFirstBlockTextureLocation(manager, getLogBlock, CompatSpritesHelper.LOOKS_LIKE_SIDE_LOG_TEXTURE));
             TextureImage logTop_texture = TextureImage.open(manager,
                     RPUtils.findFirstBlockTextureLocation(manager, getLogBlock, CompatSpritesHelper.LOOKS_LIKE_TOP_LOG_TEXTURE));
             TextureImage TextureSide = TextureImage.open(manager, getLogSide);
             TextureImage TextureTop = TextureImage.open(manager, getLogTop)
        ) {

            // Side texture ================================================================================================
            {
                McMetaFile metaSide = logSide_texture.getMcMeta();

                TextureImage sideImage; // Creating a 16x16 texture from an animated log's texture
                if (Objects.nonNull(logSide_texture.getMcMeta())) {
                    NativeImage standardSize = new NativeImage(16, 16, false);
                    standardSize.copyFrom(logSide_texture.getImage());
                    sideImage = TextureImage.of(standardSize);
                } else {
                    sideImage = logSide_texture;
                }

                List<Palette> targetSide = Palette.fromAnimatedImage(sideImage);

                Respriter respriterSide = Respriter.of(TextureSide);

                // Recoloring

                // Adding to the Resource
                sink.addTextureIfNotPresent(manager, newPath, () ->
                        respriterSide.recolorWithAnimation(targetSide, metaSide)
                );
            }

            // Top texture =================================================================================================
            {
                McMetaFile metaTop = logTop_texture.getMcMeta();

                TextureImage topImage; // Creating a 16x16 texture from an animated log's texture
                if (Objects.nonNull(logTop_texture.getMcMeta())) {
                    NativeImage standardSize = new NativeImage(16, 16, false);
                    standardSize.copyFrom(logTop_texture.getImage());
                    topImage = TextureImage.of(standardSize);
                } else {
                    topImage = logTop_texture;
                }

                List<Palette> targetTopInner = Palette.fromAnimatedImage(topImage, logOuterMask, 0);
                List<Palette> targetTopOuter = Palette.fromAnimatedImage(topImage, logInnerMask, 0);
                //if (true) {
                //    targetTopInner = Palette.fromAnimatedImage(topImage, logOuterMask, 0);
                //    targetTopOuter = Palette.fromAnimatedImage(topImage, logInnerMask, 0);
                //} else {
                //    targetTopInner = Palette.fromAnimatedImage(topImage);
                //    targetTopOuter = Palette.fromAnimatedImage(topImage);
                //}

                // Inner
                Respriter innerTopResp = Respriter.masked(TextureTop, BPTopOuterMask);
                TextureImage recoloredInner = innerTopResp.recolorWithAnimation(targetTopInner, metaTop);

                // Outer
                Respriter outerTopResp = Respriter.masked(recoloredInner, BPTopInnerMask);
                TextureImage recoloredOuter;

                // stripped_log_top's outer|edge must have 3 color palettes
                while (targetTopOuter.get(0).size() < 3) targetTopOuter.get(0).increaseInner();

                recoloredOuter = outerTopResp.recolorWithAnimation(targetTopOuter, metaTop);

                // Adding to the Resource
                sink.addTextureIfNotPresent(manager, newPath + "_top", () -> recoloredOuter);
                recoloredOuter.close();
            }

        } catch (Exception e) {
            EveryCompat.LOGGER.error("Failed to generate the texture for {} : {}", block, e);
        }
    }

    // GetTile -----------------------------------------------------------------------------------------------------------
    private BlockEntityType<? extends ChestBlockEntity> getChestTile() {
        return chests.getTile(CompatChestBlockEntity.class);
    }

    private BlockEntityType<? extends ChestBlockEntity> getChestTrappedTile() {
        return trappedChests.getTile(CompatChestBlockEntity.class);
    }

    // Registry --------------------------------------------------------------------------------------------------------
    @Override
    public void registerBlockEntityRenderers(ClientHelper.BlockEntityRendererEvent event) {
        super.registerBlockEntityRenderers(event);
        //CompatChestBlockRenderer.CHEST_SHEET(event, chests.getTile(CompatChestBlockEntity.class), shortenedId());
        CompatChestBlockRenderer.register(event, chests.getTile(CompatChestBlockEntity.class), shortenedId());
        CompatChestBlockRenderer.register(event, trappedChests.getTile(CompatChestBlockEntity.class), shortenedId());
        //CompatLecternBlockRenderer.register(event, lecterns.getTile(CWLecternBlockEntity.class), shortenedId());
        //event.register(campfires.getTile(CWCampfireBlockEntity.class), (c) -> new CWCampfireRenderer(c));

    }

    @Override
    public void onClientSetup() {
        super.onClientSetup();
        //for (Block block : chests.blocks.values()) {
        //    BlockEntity be = new CompatChestBlockEntity(chests.getTile(), BlockPos.ZERO, block.defaultBlockState());
//
//
        //    BuiltinItemRendererRegistry.INSTANCE.register(
        //            block.asItem(),
        //            (BuiltinItemRenderer) new CWBlockEntityWithoutLevelRenderer(
        //                    Minecraft.getInstance().getBlockEntityRenderDispatcher(),
        //                    Minecraft.getInstance().getEntityModels(),
        //                    be
        //            )
        //    );
        //
        //}
//
        //for (Block block : trappedChests.blocks.values()) {
//
        //    BlockEntity be = new CompatChestBlockEntity(trappedChests.getTile(), BlockPos.ZERO, block.defaultBlockState());
        //
//
        //    BuiltinItemRendererRegistry.INSTANCE.register(
        //            block.asItem(),
        //            (BuiltinItemRenderer) new CWBlockEntityWithoutLevelRenderer(
        //                    Minecraft.getInstance().getBlockEntityRenderDispatcher(),
        //                    Minecraft.getInstance().getEntityModels(),
        //                    be
        //            )
        //    );
        //}

    }

    @Override
    //@Environment(EnvType.CLIENT)
    public void onClientInit() {
        super.onClientInit();

        //for (Block block : chests.blocks.values()) {
        //    BlockEntity be = new CompatChestBlockEntity(chests.getTile(), new BlockPos(0, 0, 0), block.defaultBlockState());
        //    BuiltinItemRendererRegistry.INSTANCE.register(block.asItem(), new CWBlockEntityWithoutLevelRenderer(be));
        //    System.out.println(be.getBlockState());
        //}
//
        //for (Block block : trappedChests.blocks.values()) {
        //    BlockEntity be = new CompatChestBlockEntity(trappedChests.getTile(), new BlockPos(0, 0, 0), block.defaultBlockState());
        //    BuiltinItemRendererRegistry.INSTANCE.register(block.asItem(), new CWBlockEntityWithoutLevelRenderer(be));
        //    System.out.println(be.getBlockState());
        //}
    }
    //@Override
    //public void onClientInit() {
    //    BlockEntityRenderers.register(CWBlockEntityTypesCommon.CHEST, CWChestRenderer::new);
    //    EntityModelLayerRegistry.registerModelLayer(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
    //}

    public BlockBehaviour.Properties campfireProperties(int i) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PODZOL)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .lightLevel(litBlockEmission(i))
                .noOcclusion()
                .ignitedByLava();
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (blockState) -> blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static ToIntFunction<BlockState> lightValue(int pLightValue) {
        return (blockState) -> pLightValue;
    }
}