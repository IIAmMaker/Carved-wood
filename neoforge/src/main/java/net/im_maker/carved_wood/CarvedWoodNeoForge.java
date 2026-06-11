package net.im_maker.carved_wood;

import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlockEntityTypes;
import net.im_maker.carved_wood.common.registers.CWBlocksNeoForge;
import net.im_maker.carved_wood.common.registers.CWPoiType;
import net.im_maker.carved_wood.common.util.AddToCreativeInv;
import net.im_maker.carved_wood.platform.*;
import net.im_maker.carved_wood.common.registers.CWBlockEntityTypes;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.im_maker.carved_wood.compatibility.WoodGood.ModCompat;
import net.im_maker.carved_wood.compatibility.create.CWCreateCompat;
import net.im_maker.carved_wood.mixin.BlockEntityTypeAccessor;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
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

    public CarvedWoodNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        PlatHelper.setInstance(new NeoForgePlatHelper(modEventBus));

        CWBlocks.registerBlocks();
        CWBlocksNeoForge.register(modEventBus); //neo Only
        CWBlockEntityTypes.registerBlockEntities();
        CWPoiType.init();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(AddToCreativeInv::addCreative);
        modEventBus.addListener(this::registerCapabilities);
        everyCompatModule();
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntityTypes.CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntityTypes.TRAPPED_CHEST.get(), (container, side) -> new InvWrapper(container.getContainer()));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntityTypes.BARREL.get(), (container, side) -> new InvWrapper(container));
        event.registerBlockEntity(ItemHandler.BLOCK, CWBlockEntityTypes.CHISELED_BOOKSHELF.get(), (container, side) -> new InvWrapper(container));
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
