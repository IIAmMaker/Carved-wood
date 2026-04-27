package net.im_maker.carved_wood.common.block.entity;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.*;
import net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf.*;
import net.im_maker.carved_wood.common.block.entity.custom.*;
import net.im_maker.carved_wood.compatibility.WoodGood.ss.CompatLecternBlock;
import net.im_maker.carved_wood.compatibility.WoodGood.ss.CompatLecternBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.stream.Stream;

public class CWBlockEntities {

    public static BlockEntityType<CWChestBlockEntity> CHEST;
    public static BlockEntityType<CWTrappedChestBlockEntity> TRAPPED_CHEST;
    public static BlockEntityType<CWCampfireBlockEntity> CAMPFIRE;
    public static BlockEntityType<CWBarrelBlockEntity> BARREL;
    public static BlockEntityType<CWChiseledBookShelfBlockEntity> CHISELED_BOOKSHELF;
    public static BlockEntityType<CWLecternBlockEntity> LECTERN;
    public static BlockEntityType<CompatLecternBlockEntity> LL;
    public static BlockEntityType<CWBeehiveBlockEntity> BEEHIVE;
    public static BlockEntityType<CWCrafterBlockEntity> CRAFTER;

    public static void  registerBlockEntities() {
        CHEST = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "chest"),
                BlockEntityType.Builder.of(CWChestBlockEntity::new,
                        CarvedWood.getBlocks(CWChestBlock.class)).build());

        TRAPPED_CHEST = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "trapped_chest"),
                BlockEntityType.Builder.of(CWTrappedChestBlockEntity::new,
                        CarvedWood.getBlocks(CWTrappedChestBlock.class)).build());

        CAMPFIRE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "campfire"),
                BlockEntityType.Builder.of(CWCampfireBlockEntity::new,
                        CarvedWood.getBlocks(CWCampfireBlock.class)).build());

        BARREL = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "barrel"),
                BlockEntityType.Builder.of(CWBarrelBlockEntity::new,
                        CarvedWood.getBlocks(CWBarrelBlock.class)).build());

        CHISELED_BOOKSHELF = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "chiseled_bookshelf"),
                BlockEntityType.Builder.of(CWChiseledBookShelfBlockEntity::new,
                        CarvedWood.getBlocks(
                                CWChiseledBookShelfBlockType1.class,
                                CWChiseledBookShelfBlockType2.class,
                                CWChiseledBookShelfBlockType3.class,
                                CWChiseledBookShelfBlockType4.class,
                                CWChiseledBookShelfBlockType5.class,
                                CWChiseledBookShelfBlockType6.class,
                                CWChiseledBookShelfBlockType7.class,
                                CWChiseledBookShelfBlockType8.class
                        )).build());

        LECTERN = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "lectern"),
                BlockEntityType.Builder.of(CWLecternBlockEntity::new,
                        CarvedWood.getBlocks(CWLecternBlock.class/*, CWLecternBlock.class*/)).build());

        LL = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "lecternn"),
                BlockEntityType.Builder.of(CompatLecternBlockEntity::new,
                        //CompatLecternBlocks.ALL_COMPAT_LECTERNS
                        CarvedWood.getBlocks(CompatLecternBlock.class/*, CWLecternBlock.class*/)).build());

        BEEHIVE = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "beehive"),
                BlockEntityType.Builder.of(CWBeehiveBlockEntity::new,
                        CarvedWood.getBlocks(CWBeehiveBlock.class)).build());

        CRAFTER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(CarvedWood.MOD_ID, "crafter"),
                BlockEntityType.Builder.of
                        (CWCrafterBlockEntity::new,
                                CarvedWood.getBlocks(CWCrafterBlock.class)).build());
    }

    public static Block[] getBlocks(Class<?>... blockClasses) {
        var i =  BuiltInRegistries.BLOCK.stream()
                .filter(block -> Stream.of(blockClasses).anyMatch(clazz -> clazz.isInstance(block)))
                .toArray(Block[]::new);
        return i;
    }
}
