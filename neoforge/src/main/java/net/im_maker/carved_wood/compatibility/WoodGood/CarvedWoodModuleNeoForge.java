package net.im_maker.carved_wood.compatibility.WoodGood;

import com.simibubi.create.AllBlockEntityTypes;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.CarvedWoodNeoForge;
import net.im_maker.carved_wood.common.block.CWLecternControllerBlock;
import net.im_maker.carved_wood.common.registers.CWBlockEntities;
import net.im_maker.carved_wood.common.registers.CWBlocks;
import net.im_maker.carved_wood.common.registers.CWBlocksNeoForge;
import net.im_maker.carved_wood.compatibility.create.CWLecternRegistry;
import net.im_maker.carved_wood.config.CarvedWoodConfig;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModList;

public class CarvedWoodModuleNeoForge extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> lecternsControllers;

    public CarvedWoodModuleNeoForge(String modId) {
        super(modId, "crwo", EveryCompat.MOD_ID);
        ResourceKey<CreativeModeTab> tab = CreativeModeTabs.BUILDING_BLOCKS;

        lecternsControllers = SimpleEntrySet.builder(WoodType.class, "lectern_controller",
                        CWBlocksNeoForge.SPRUCE_LECTERN_CONTROLLER, () -> VanillaWoodTypes.SPRUCE,
                        w -> new CWLecternControllerBlock(Utils.copyPropertySafe(w.log), () -> CarvedWood.getBlockFromString(w.id.getNamespace(), w.id.getPath().replace("_controller", ""))))
                .addTexture(modRes("block/spruce_lectern_sides"))
                .addTexture(modRes("block/spruce_lectern_top"))
                .addTextureM(modRes("block/spruce_lectern_base"), EveryCompat.res("block/crwo/spruce_lectern_base_m"))
                .addTextureM(modRes("block/spruce_lectern_front"), EveryCompat.res("block/crwo/spruce_lectern_front_m"))
                //.addTag(CWTags.Items.LECTERNS, Registries.ITEM)
                //.addTag(Tags.Items.VILLAGER_JOB_SITES, Registries.ITEM)
                //.addTag(Tags.Blocks.VILLAGER_JOB_SITES, Registries.BLOCK)
                //.addTag(CWTags.Blocks.LECTERNS, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTile(AllBlockEntityTypes.LECTERN_CONTROLLER)
                .noTab().noItem().copyParentDrop()
                .build();
        if (CarvedWoodConfig.isEnabled("wooden_bookshelves")) this.addEntry(lecternsControllers);


        //for (Block b : lecternsControllers.blocks.values()) {
        //    CWLecternRegistry.register(((CWLecternControllerBlock) b).getDefaultLectern(), b);
        //}
        //for (Block controllerBlock : CarvedWood.getBlocks(CWLecternControllerBlock.class)) {
        //    if (controllerBlock instanceof CWLecternControllerBlock controller) {
        //        CWLecternRegistry.register(controller.getDefaultLectern(), controllerBlock);
        //    }
        //}
    }

    @Override
    public void onModSetup() {
    }

    @Override
    public void onModInit() {
    }

    // Registry --------------------------------------------------------------------------------------------------------
    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerBlockEntityRenderers(ClientHelper.BlockEntityRendererEvent event) {
        super.registerBlockEntityRenderers(event);
    }

    @Override
    public void onClientInit() {
        super.onClientInit();
    }
}