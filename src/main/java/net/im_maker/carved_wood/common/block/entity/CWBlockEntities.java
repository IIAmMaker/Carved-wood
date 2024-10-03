package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.*;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.CWChiseledBookShelfBlockType1;
import net.im_maker.carved_wood.common.block.entity.custom.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CarvedWood.MOD_ID);

    public static final RegistryObject<BlockEntityType<CWChestBlockEntity>> CHEST = BLOCK_ENTITIES.register("chest", () ->
            BlockEntityType.Builder.of(CWChestBlockEntity::new, getBlocks(CWChestBlock.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWTrappedChestBlockEntity>> TRAPPED_CHEST = BLOCK_ENTITIES.register("trapped_chest", () ->
            BlockEntityType.Builder.of(CWTrappedChestBlockEntity::new, getBlocks(CWTrappedChestBlock.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITIES.register("campfire", () ->
            BlockEntityType.Builder.of(CWCampfireBlockEntity::new, getBlocks(CWCampfireBlock.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWBarrelBlockEntity>> BARREL = BLOCK_ENTITIES.register("barrel", () ->
            BlockEntityType.Builder.of(CWBarrelBlockEntity::new, getBlocks(CWBarrelBlock.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWChiseledBookShelfBlockEntity>> CHISELED_BOOKSHELF = BLOCK_ENTITIES.register("chiseled_bookshelf", () ->
            BlockEntityType.Builder.of(CWChiseledBookShelfBlockEntity::new, getBlocks(CWChiseledBookShelfBlockType1.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWLecternBlockEntity>> LECTERN = BLOCK_ENTITIES.register("lectern", () ->
            BlockEntityType.Builder.of(CWLecternBlockEntity::new, getBlocks(CWLecternBlock.class)).build(null));

    public static final RegistryObject<BlockEntityType<CWBeehiveBlockEntity>> BEEHIVE = BLOCK_ENTITIES.register("beehive", () ->
            BlockEntityType.Builder.of(CWBeehiveBlockEntity::new, getBlocks(CWBeehiveBlock.class)).build(null));

    public static Block[] getBlocks(Class<?> blockClass) {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(blockClass::isInstance)
                .toArray(Block[]::new);
    }

    public static void register(IEventBus eventBus)   {
        BLOCK_ENTITIES.register(eventBus);
    }
}
