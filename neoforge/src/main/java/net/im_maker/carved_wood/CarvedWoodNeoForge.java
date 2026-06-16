package net.im_maker.carved_wood;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import com.simibubi.create.AllBlockEntityTypes;
import net.im_maker.carved_wood.common.registers.*;
import net.im_maker.carved_wood.config.ConfigValueCondition;
import net.im_maker.carved_wood.common.util.AddToCreativeInv;
import net.im_maker.carved_wood.config.NeoForgeConfig;
import net.im_maker.carved_wood.platform.*;
import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.im_maker.carved_wood.compatibility.WoodGood.ModCompat;
import net.im_maker.carved_wood.compatibility.create.CWCreateCompat;
import net.im_maker.carved_wood.mixin.BlockEntityTypeAccessor;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.slf4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.*;

@Mod(CarvedWoodNeoForge.MOD_ID)
public class CarvedWoodNeoForge {
    public static final String MOD_ID = CarvedWood.MOD_ID;

    public static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, CarvedWood.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigValueCondition>> CONFIG_CONDITION =
            CONDITION_CODECS.register("config", () -> ConfigValueCondition.CODEC);

    public CarvedWoodNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        PlatHelper.setInstance(new NeoForgePlatHelper(modEventBus));
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfig.SPEC, "carved_wood-common.toml");
        CONDITION_CODECS.register(modEventBus);

        CWBlocks.register();
        CWBlocksNeoForge.register();
        CWBlockEntities.register();
        CWRecipes.register();
        CWPoi.register();

        modEventBus.addListener(AddToCreativeInv::addCreative);
        modEventBus.addListener(this::registerCapabilities);
        everyCompatModule();
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.TRAPPED_CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.BARREL.get(), (container, side) -> new InvWrapper(container));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntities.CHISELED_BOOKSHELF.get(), (container, side) -> new InvWrapper(container));
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            if (ModList.get().isLoaded("create")) {
                event.enqueueWork(() -> { //Adding the CW Lectern Controllers to Create LECTERN_CONTROLLER block entity type
                    BlockEntityType<?> type = AllBlockEntityTypes.LECTERN_CONTROLLER.get();
                    BlockEntityTypeAccessor accessor = (BlockEntityTypeAccessor) type;
                    Set<Block> newSet = new HashSet<>(accessor.carvedwood$getValidBlocks());
                    newSet.addAll(Set.of(CarvedWood.getBlocks(CWLecternControllerBlock.class)));
                    accessor.carvedwood$setValidBlocks(newSet);
                });
                event.enqueueWork(() -> { //Mixin for Create LinkedControllerItem
                    CWCreateCompat.registerLecterns();
                });
            }
        }
    }

    private static void everyCompatModule() {
        try {
            if (PlatHelper.isModLoaded("everycomp")) {
                ModCompat.init();
            } else {
                LOGGER.info("EveryCompat module is not loaded");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to start EveryComp module", e);
        }
    }
}
