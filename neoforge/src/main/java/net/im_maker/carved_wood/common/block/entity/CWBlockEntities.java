package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.*;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.CWChiseledBookShelfBlockType1;
import net.im_maker.carved_wood.common.block.entity.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CarvedWood.MOD_ID);

    public static final Supplier<BlockEntityType<CWChestBlockEntity>> CHEST = BLOCK_ENTITIES.register("chest", () ->
            BlockEntityType.Builder.of(CWChestBlockEntity::new, getBlocks(CWChestBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWTrappedChestBlockEntity>> TRAPPED_CHEST = BLOCK_ENTITIES.register("trapped_chest", () ->
            BlockEntityType.Builder.of(CWTrappedChestBlockEntity::new, getBlocks(CWTrappedChestBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITIES.register("campfire", () ->
            BlockEntityType.Builder.of(CWCampfireBlockEntity::new, getBlocks(CWCampfireBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWBarrelBlockEntity>> BARREL = BLOCK_ENTITIES.register("barrel", () ->
            BlockEntityType.Builder.of(CWBarrelBlockEntity::new, getBlocks(CWBarrelBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWChiseledBookShelfBlockEntity>> CHISELED_BOOKSHELF = BLOCK_ENTITIES.register("chiseled_bookshelf", () ->
            BlockEntityType.Builder.of(CWChiseledBookShelfBlockEntity::new, getBlocks(CWChiseledBookShelfBlockType1.class)).build(null));

    public static final Supplier<BlockEntityType<CWLecternBlockEntity>> LECTERN = BLOCK_ENTITIES.register("lectern", () ->
            BlockEntityType.Builder.of(CWLecternBlockEntity::new, getBlocks(CWLecternBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWBeehiveBlockEntity>> BEEHIVE = BLOCK_ENTITIES.register("beehive", () ->
            BlockEntityType.Builder.of(CWBeehiveBlockEntity::new, getBlocks(CWBeehiveBlock.class)).build(null));

    public static final Supplier<BlockEntityType<CWCrafterBlockEntity>> CRAFTER = BLOCK_ENTITIES.register("crafter", () ->
            BlockEntityType.Builder.of(CWCrafterBlockEntity::new, getBlocks(CWCrafterBlock.class)).build(null));

    public static Block[] getBlocks(Class<?> blockClass) {
        return BuiltInRegistries.BLOCK.stream()
                .filter(blockClass::isInstance)
                .toArray(Block[]::new);
    }

    public static void register(IEventBus eventBus)   {
        BLOCK_ENTITIES.register(eventBus);
    }
}
