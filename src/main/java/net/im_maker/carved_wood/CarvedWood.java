package net.im_maker.carved_wood;

import net.im_maker.carved_wood.client.renderer.CWModelLayers;
import net.im_maker.carved_wood.client.renderer.block.CWCampfireRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWChestRenderer;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.item.CWItems;
import net.im_maker.carved_wood.common.util.CWPoiType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.LecternRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

@Mod(CarvedWood.MOD_ID)
@Mod.EventBusSubscriber(modid = CarvedWood.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarvedWood {
    public static final String MOD_ID = "carved_wood";
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
        "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped"
    ));
    public static final List<String> VANILLA_WOOD_TYPES  = new ArrayList<>(Arrays.asList(
        "minecraft", "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "crimson", "warped"
    ));
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;

    public CarvedWood() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        CWBlocks.register(modEventBus);
        CWItems.register(modEventBus);
        CWBlockEntities.register(modEventBus);
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::addCreative);
        CWPoiType.register(modEventBus);
    }


    @SubscribeEvent
    public void onMissing(MissingMappingsEvent event) {
        for (String woodType : WOOD_TYPES) {
            for (MissingMappingsEvent.Mapping mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, "carved_wood")) {
                ResourceLocation oldId = mapping.getKey();
                if (oldId.toString().equals(woodType + "_trapped_chest")) {
                    ResourceLocation newId = new ResourceLocation("trapped_" + woodType + "_chest");
                    mapping.remap(ForgeRegistries.BLOCKS.getValue(newId));
                }
                if (oldId.toString().equals(woodType + "_soul_campfire")) {
                    ResourceLocation newId = new ResourceLocation("soul_" + woodType + "_chest");
                    mapping.remap(ForgeRegistries.BLOCKS.getValue(newId));
                }
            }
        }
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike... blocks) {
        for (int i = blocks.length - 1; i >= 0; i--) {
            ItemLike block = blocks[i];
            map.putAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike... blocks) {
        for (ItemLike block : blocks) {
            map.putBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
                for (String woodType : WOOD_TYPES) {
                    Block planks = getBlockFromString("minecraft", woodType + "_planks");
                    Block planksTiles = getBlockFromString(woodType + "_tiles");
                    Block bPlanks = getBlockFromString(woodType + "_boards");
                    Block sPlanks = getBlockFromString("smooth_" + woodType + "_boards");
                    Block mPlanks = getBlockFromString(woodType + "_mosaic");
                    Block cPlanks = getBlockFromString("carved_" + woodType + "_planks");
                    Block lPlanks = getBlockFromString(woodType + "_lantern");
                    Block pPlanks = getBlockFromString(woodType + "_pillar");
                    Block planksStairs = getBlockFromString("minecraft", woodType + "_stairs");
                    Block mPlanksStairs = getBlockFromString(woodType + "_mosaic_stairs");
                    Block tPlanksStairs = getBlockFromString(woodType + "_tile_stairs");
                    Block planksSlab = getBlockFromString("minecraft", woodType + "_slab");
                    Block mPlanksSlab = getBlockFromString(woodType + "_mosaic_slab");
                    Block tPlanksSlab = getBlockFromString(woodType + "_tile_slab");
                    String trunkType;
                    switch (woodType) {
                        case "crimson", "warped" -> trunkType = "_stem";
                        case "bamboo" -> trunkType = "";
                        default -> trunkType = "_log";
                    }
                    Block log = getBlockFromString("minecraft", woodType + trunkType);
                    Block strippedLog = getBlockFromString("minecraft", "stripped_" + woodType + trunkType);
                    Block logBundle = getBlockFromString(woodType + trunkType + "_bundle");
                    Block strippedLogBundle = getBlockFromString("stripped_" + woodType + trunkType + "_bundle");

                    switch (woodType) {
                        case "bamboo" -> {
                            addAfter(entries, Blocks.BAMBOO_BLOCK, logBundle);
                            addAfter(entries, Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                            addAfter(entries, Blocks.BAMBOO_MOSAIC, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                            addAfter(entries, Blocks.BAMBOO_MOSAIC_STAIRS, tPlanksStairs);
                            addAfter(entries, Blocks.BAMBOO_MOSAIC_SLAB, tPlanksSlab);
                        }
                        default -> {
                            addAfter(entries, log, logBundle);
                            addAfter(entries, strippedLog, strippedLogBundle);
                            addAfter(entries, planks, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                            addAfter(entries, planksStairs, mPlanksStairs, tPlanksStairs);
                            addAfter(entries, planksSlab, mPlanksSlab, tPlanksSlab);
                        }
                    }
                }
            }
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
                List<String> woodTypesList = WOOD_TYPES;
                Collections.reverse(woodTypesList);
                for (String woodType : WOOD_TYPES) {
                    if (woodType != "oak") {
                        Block craftingTable = getBlockFromString(woodType + "_crafting_table");
                        Block ladder = getBlockFromString(woodType + "_ladder");
                        Block campfire = getBlockFromString(woodType + "_campfire");
                        Block soulCampfire = getBlockFromString("soul_" + woodType + "_campfire");
                        Block bookshelf = getBlockFromString(woodType + "_bookshelf");
                        Block chiseled_bookshelf = getBlockFromString("chiseled_" + woodType + "_bookshelf");
                        Block lectern = getBlockFromString(woodType + "_lectern");
                        Block beehive = getBlockFromString(woodType + "_beehive");
                        addAfter(entries, Blocks.CRAFTING_TABLE, craftingTable);
                        addAfter(entries, Blocks.LADDER, ladder);
                        addAfter(entries, Blocks.CAMPFIRE, campfire);
                        addAfter(entries, Blocks.SOUL_CAMPFIRE, soulCampfire);
                        addAfter(entries, Blocks.CHISELED_BOOKSHELF, bookshelf);
                        addAfter(entries, bookshelf, chiseled_bookshelf);
                        addAfter(entries, Blocks.LECTERN, lectern);
                        addAfter(entries, Blocks.BEEHIVE, beehive);
                    }
                    if (woodType != "spruce" && woodType != "oak") {
                        Block barrel = getBlockFromString(woodType + "_barrel");
                        addAfter(entries, Blocks.BARREL, barrel);
                    }
                    Block chest = getBlockFromString(woodType + "_chest");
                    addAfter(entries, Blocks.CHEST, chest);
                }
                addBefore(entries, Blocks.BARREL, CWBlocks.OAK_BARREL.get());
            }
            if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
                for (String woodType : WOOD_TYPES) {
                    Block chest = getBlockFromString(woodType + "_chest");
                    addAfter(entries, Blocks.CHEST, chest);
                    Block trappedChest = getBlockFromString("trapped_" + woodType + "_chest");
                    addAfter(entries, Blocks.TRAPPED_CHEST, trappedChest);
                }
            }
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        BlockEntityRenderers.register(CWBlockEntities.CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.TRAPPED_CHEST.get(), CWChestRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.CAMPFIRE.get(), CWCampfireRenderer::new);
        BlockEntityRenderers.register(CWBlockEntities.LECTERN.get(), LecternRenderer::new);
        MixinEnvironment.getDefaultEnvironment().addConfiguration("carved_wood.mixins.json");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerLayer (EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
            event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_LEFT, CWChestRenderer::createDoubleBodyLeftLayer);
            event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_RIGHT, CWChestRenderer::createDoubleBodyRightLayer);
        }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

    public static Block getBlockFromString (String block) {
        return getBlockFromString(MOD_ID, block);
    }
    public static Block getBlockFromString (String nameSpace, String block) {
        ResourceLocation blockLocation = new ResourceLocation(nameSpace, block);
        return ForgeRegistries.BLOCKS.getValue(blockLocation);
    }

    public static Item getItemFromString (String item) {
        return getItemFromString(MOD_ID, item);
    }
    public static Item getItemFromString (String nameSpace, String item) {
        ResourceLocation itemLocation = new ResourceLocation(nameSpace, item);
        return ForgeRegistries.ITEMS.getValue(itemLocation);
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
