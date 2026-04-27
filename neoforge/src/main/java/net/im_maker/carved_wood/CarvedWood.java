package net.im_maker.carved_wood;

import com.mojang.logging.LogUtils;
import net.im_maker.carved_wood.client.renderer.CWModelLayers;
import net.im_maker.carved_wood.client.renderer.block.CWCampfireRenderer;
import net.im_maker.carved_wood.client.renderer.block.CWChestRenderer;
import net.im_maker.carved_wood.common.block.CWBlocks;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.item.CWItems;
import net.im_maker.carved_wood.common.recipe.CWRecipes;
import net.im_maker.carved_wood.common.util.CWPoiType;
import net.im_maker.carved_wood.compatibility.WoodGood.ModCompat;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.LecternRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.conditions.ConditionalOps;
import net.neoforged.neoforge.common.util.NeoForgeExtraCodecs;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.slf4j.Logger;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Mod(CarvedWood.MOD_ID)
public class CarvedWood {
    public static final String MOD_ID = "carved_wood";
    public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
        "oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
    ));
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;
    public static final Logger LOGGER = LogUtils.getLogger();

    public CarvedWood(IEventBus modEventBus, ModContainer modContainer) {
        CWBlocks.register(modEventBus);
        CWItems.register(modEventBus);
        CWRecipes.register(modEventBus);
        CWBlockEntities.register(modEventBus);
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerCapabilities);
        everyCompatModule();
    }

    private static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike after, ItemLike... blocks) {
        for (int i = blocks.length - 1; i >= 0; i--) {
            ItemLike block = blocks[i];
            if (block != Blocks.AIR && after != Blocks.AIR) {
                event.insertAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    private static void addBefore(BuildCreativeModeTabContentsEvent event, ItemLike before, ItemLike... blocks) {
        for (ItemLike block : blocks) {
            if (block != Blocks.AIR && before != Blocks.AIR) {
                event.insertBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (String woodType : WOOD_TYPES) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block planks = getBlockFromString("minecraft", woodType + "_planks");
                Block PlanksP = getBlockFromString(woodType + "_panels");
                Block bPlanks = getBlockFromString(woodType + "_boards");
                Block sPlanks = getBlockFromString("smooth_" + woodType + "_boards");
                Block planksTiles = getBlockFromString(woodType + "_tiles");
                Block mPlanks = getBlockFromString(woodType + "_mosaic");
                Block cPlanks = getBlockFromString("carved_" + woodType + "_planks");
                Block lPlanks = getBlockFromString(woodType + "_lantern_block");
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
                        addAfter(event, Blocks.BAMBOO_BLOCK, logBundle);
                        addAfter(event, Blocks.STRIPPED_BAMBOO_BLOCK, strippedLogBundle);
                        addAfter(event, Blocks.BAMBOO_PLANKS, PlanksP);
                        addAfter(event, Blocks.BAMBOO_MOSAIC, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, Blocks.BAMBOO_MOSAIC_STAIRS, tPlanksStairs);
                        addAfter(event, Blocks.BAMBOO_MOSAIC_SLAB, tPlanksSlab);
                    }
                    case "pale_oak" -> {
                        addAfter(event, Blocks.CHERRY_BUTTON, logBundle);
                        addAfter(event, Blocks.CHERRY_BUTTON, strippedLogBundle);
                        addAfter(event, Blocks.CHERRY_BUTTON, PlanksP, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, Blocks.CHERRY_BUTTON, mPlanksStairs, tPlanksStairs);
                        addAfter(event, Blocks.CHERRY_BUTTON, mPlanksSlab, tPlanksSlab);
                    }
                    default -> {
                        addAfter(event, log, logBundle);
                        addAfter(event, strippedLog, strippedLogBundle);
                        addAfter(event, planks, PlanksP, mPlanks, planksTiles, bPlanks, sPlanks, cPlanks, lPlanks, pPlanks);
                        addAfter(event, planksStairs, mPlanksStairs, tPlanksStairs);
                        addAfter(event, planksSlab, mPlanksSlab, tPlanksSlab);
                    }
                }
            }
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (String woodType : WOOD_TYPES.reversed()) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block woodenLantern = getBlockFromString(woodType + "_lantern");
                addAfter(event, Blocks.SOUL_LANTERN, woodenLantern);
                if (woodType != "oak") {
                    Block craftingTable = getBlockFromString(woodType + "_crafting_table");
                    Block ladder = getBlockFromString(woodType + "_ladder");
                    Block campfire = getBlockFromString(woodType + "_campfire");
                    Block soulCampfire = getBlockFromString("soul_" + woodType + "_campfire");
                    Block bookshelf = getBlockFromString(woodType + "_bookshelf");
                    Block chiseled_bookshelf = getBlockFromString("chiseled_" + woodType + "_bookshelf");
                    Block lectern = getBlockFromString(woodType + "_lectern");
                    Block beehive = getBlockFromString(woodType + "_beehive");
                    addAfter(event, Blocks.CRAFTING_TABLE, craftingTable);
                    addAfter(event, Blocks.LADDER, ladder);
                    addAfter(event, Blocks.CAMPFIRE, campfire);
                    addAfter(event, Blocks.SOUL_CAMPFIRE, soulCampfire);
                    addAfter(event, Blocks.CHISELED_BOOKSHELF, bookshelf);
                    addAfter(event, bookshelf, chiseled_bookshelf);
                    addAfter(event, Blocks.LECTERN, lectern);
                    addAfter(event, Blocks.BEEHIVE, beehive);
                }
                if (woodType != "spruce" && woodType != "oak") {
                    Block barrel = getBlockFromString(woodType + "_barrel");
                    addAfter(event, Blocks.BARREL, barrel);
                }
                Block chest = getBlockFromString(woodType + "_chest");
                addAfter(event, Blocks.CHEST, chest);
            }
            addBefore(event, Blocks.BARREL, CWBlocks.OAK_BARREL.get());
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (String woodType : WOOD_TYPES.reversed()) {
                if (woodType.equals("pale_oak") && !ModList.get().isLoaded("vanillabackport"))
                    continue;
                Block chest = getBlockFromString(woodType + "_chest");
                addAfter(event, Blocks.CHEST, chest);
                Block trappedChest = getBlockFromString("trapped_" + woodType + "_chest");
                addAfter(event, Blocks.TRAPPED_CHEST, trappedChest);
                if (!woodType.equals("oak")) {
                    Block crafter = getBlockFromString(woodType + "_crafter");
                    addAfter(event, Blocks.CRAFTER, crafter);
                }
            }
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CWPoiType.init();
        });
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.TRAPPED_CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.BARREL.get(), (container, side) -> new InvWrapper(container));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.CHISELED_BOOKSHELF.get(), (container, side) -> new InvWrapper(container));
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerLayer (EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CWModelLayers.CHEST, CWChestRenderer::createSingleBodyLayer);
            event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_LEFT, CWChestRenderer::createDoubleBodyLeftLayer);
            event.registerLayerDefinition(CWModelLayers.DOUBLE_CHEST_RIGHT, CWChestRenderer::createDoubleBodyRightLayer);
        }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            BlockEntityRenderers.register(CWBlockEntities.CHEST.get(), CWChestRenderer::new);
            BlockEntityRenderers.register(CWBlockEntities.TRAPPED_CHEST.get(), CWChestRenderer::new);
            BlockEntityRenderers.register(CWBlockEntities.CAMPFIRE.get(), CWCampfireRenderer::new);
            BlockEntityRenderers.register(CWBlockEntities.LECTERN.get(), LecternRenderer::new);
            for (String woodType : WOOD_TYPES) {
                ItemBlockRenderTypes.setRenderLayer(getBlockFromString(woodType + "_lantern"), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(getBlockFromString(woodType + "_campfire"), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(getBlockFromString("soul_" + woodType + "_campfire"), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(getBlockFromString(woodType + "_ladder"), RenderType.cutout());
            }
            //MixinEnvironment.getDefaultEnvironment().addConfiguration("carved_wood.mixins.json");
        }
    }

    private static void everyCompatModule() {
        try {
            if (ModList.get().isLoaded("everycomp")) {
                ModCompat.init();
            } else {
                LOGGER.info("EveryCompat module is not loaded");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to start EveryComp module", e);
        }
    }

    public static Block getBlockFromString (String block) {
        return getBlockFromString(MOD_ID, block);
    }
    public static Block getBlockFromString (String nameSpace, String block) {
        ResourceLocation blockLocation =  ResourceLocation.fromNamespaceAndPath(nameSpace, block);
        return BuiltInRegistries.BLOCK.get(blockLocation);
    }

    public static Item getItemFromString (String item) {
        return getItemFromString(MOD_ID, item);
    }
    public static Item getItemFromString (String nameSpace, String item) {
        ResourceLocation itemLocation = ResourceLocation.fromNamespaceAndPath(nameSpace, item);
        return BuiltInRegistries.ITEM.get(itemLocation);
    }
}
