package net.im_maker.paintable.common.block.block_entity;

import net.im_maker.paintable.Paintable;
import net.im_maker.paintable.common.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Paintable.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.RED_PAINTED_WALL_SIGN.get(),
                            ModBlocks.RED_PAINTED_SIGN.get(),
                            ModBlocks.ORANGE_PAINTED_WALL_SIGN.get(),
                            ModBlocks.ORANGE_PAINTED_SIGN.get(),
                            ModBlocks.YELLOW_PAINTED_WALL_SIGN.get(),
                            ModBlocks.YELLOW_PAINTED_SIGN.get(),
                            ModBlocks.LIME_PAINTED_WALL_SIGN.get(),
                            ModBlocks.LIME_PAINTED_SIGN.get(),
                            ModBlocks.GREEN_PAINTED_WALL_SIGN.get(),
                            ModBlocks.GREEN_PAINTED_SIGN.get(),
                            ModBlocks.CYAN_PAINTED_WALL_SIGN.get(),
                            ModBlocks.CYAN_PAINTED_SIGN.get(),
                            ModBlocks.LIGHT_BLUE_PAINTED_WALL_SIGN.get(),
                            ModBlocks.LIGHT_BLUE_PAINTED_SIGN.get(),
                            ModBlocks.BLUE_PAINTED_WALL_SIGN.get(),
                            ModBlocks.BLUE_PAINTED_SIGN.get(),
                            ModBlocks.PURPLE_PAINTED_WALL_SIGN.get(),
                            ModBlocks.PURPLE_PAINTED_SIGN.get(),
                            ModBlocks.MAGENTA_PAINTED_WALL_SIGN.get(),
                            ModBlocks.MAGENTA_PAINTED_SIGN.get(),
                            ModBlocks.PINK_PAINTED_WALL_SIGN.get(),
                            ModBlocks.PINK_PAINTED_SIGN.get(),
                            ModBlocks.BROWN_PAINTED_WALL_SIGN.get(),
                            ModBlocks.BROWN_PAINTED_SIGN.get(),
                            ModBlocks.BLACK_PAINTED_WALL_SIGN.get(),
                            ModBlocks.BLACK_PAINTED_SIGN.get(),
                            ModBlocks.GRAY_PAINTED_WALL_SIGN.get(),
                            ModBlocks.GRAY_PAINTED_SIGN.get(),
                            ModBlocks.LIGHT_GRAY_PAINTED_WALL_SIGN.get(),
                            ModBlocks.LIGHT_GRAY_PAINTED_SIGN.get(),
                            ModBlocks.WHITE_PAINTED_WALL_SIGN.get(),
                            ModBlocks.WHITE_PAINTED_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
