package net.im_maker.paintable;

import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.im_maker.paintable.common.block.block_entity.ModBlockEntities;
import net.im_maker.paintable.common.sound.ModSounds;
import net.im_maker.paintable.common.util.ModWoodTypes;
import net.im_maker.paintable.common.util.PaintableBlockSubRegistryHelper;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.im_maker.paintable.common.block.ModBlocks;
import net.im_maker.paintable.common.item.ModItems;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Paintable.MOD_ID)
@Mod.EventBusSubscriber(modid = Paintable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Paintable {
    public static final String MOD_ID = "paintable";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.BLOCKS, new PaintableBlockSubRegistryHelper(helper)));

    private static final Logger LOGGER = LogUtils.getLogger();

    public Paintable() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        /*
        RenderType cutout = RenderType.cutout();
        RenderType translucent = RenderType.translucent();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_PAINTED_DOOR.get(), cutout);
        */

        WoodType.register(ModWoodTypes.RED_PAINTED);
        WoodType.register(ModWoodTypes.ORANGE_PAINTED);
        WoodType.register(ModWoodTypes.YELLOW_PAINTED);
        WoodType.register(ModWoodTypes.LIME_PAINTED);
        WoodType.register(ModWoodTypes.GREEN_PAINTED);
        WoodType.register(ModWoodTypes.CYAN_PAINTED);
        WoodType.register(ModWoodTypes.LIGHT_BLUE_PAINTED);
        WoodType.register(ModWoodTypes.BLUE_PAINTED);
        WoodType.register(ModWoodTypes.PURPLE_PAINTED);
        WoodType.register(ModWoodTypes.MAGENTA_PAINTED);
        WoodType.register(ModWoodTypes.PINK_PAINTED);
        WoodType.register(ModWoodTypes.BROWN_PAINTED);
        WoodType.register(ModWoodTypes.BLACK_PAINTED);
        WoodType.register(ModWoodTypes.GRAY_PAINTED);
        WoodType.register(ModWoodTypes.LIGHT_GRAY_PAINTED);
        WoodType.register(ModWoodTypes.WHITE_PAINTED);
        //BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }


    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            Sheets.addWoodType(ModWoodTypes.RED_PAINTED);
            Sheets.addWoodType(ModWoodTypes.ORANGE_PAINTED);
            Sheets.addWoodType(ModWoodTypes.YELLOW_PAINTED);
            Sheets.addWoodType(ModWoodTypes.LIME_PAINTED);
            Sheets.addWoodType(ModWoodTypes.GREEN_PAINTED);
            Sheets.addWoodType(ModWoodTypes.CYAN_PAINTED);
            Sheets.addWoodType(ModWoodTypes.LIGHT_BLUE_PAINTED);
            Sheets.addWoodType(ModWoodTypes.BLUE_PAINTED);
            Sheets.addWoodType(ModWoodTypes.PURPLE_PAINTED);
            Sheets.addWoodType(ModWoodTypes.MAGENTA_PAINTED);
            Sheets.addWoodType(ModWoodTypes.PINK_PAINTED);
            Sheets.addWoodType(ModWoodTypes.BROWN_PAINTED);
            Sheets.addWoodType(ModWoodTypes.BLACK_PAINTED);
            Sheets.addWoodType(ModWoodTypes.GRAY_PAINTED);
            Sheets.addWoodType(ModWoodTypes.LIGHT_GRAY_PAINTED);
            Sheets.addWoodType(ModWoodTypes.WHITE_PAINTED);
        });

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        /*@SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }*/
    }
    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
