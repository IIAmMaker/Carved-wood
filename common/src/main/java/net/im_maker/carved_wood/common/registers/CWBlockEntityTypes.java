package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.*;
import net.im_maker.carved_wood.common.block.chiseled_bookshelf.*;
import net.im_maker.carved_wood.common.block.entity.*;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CWBlockEntityTypes {
    public static Supplier<BlockEntityType<CWChestBlockEntity>> CHEST;
    public static Supplier<BlockEntityType<CWTrappedChestBlockEntity>> TRAPPED_CHEST;
    public static Supplier<BlockEntityType<CWCampfireBlockEntity>> CAMPFIRE;
    public static Supplier<BlockEntityType<CWBarrelBlockEntity>> BARREL;
    public static Supplier<BlockEntityType<CWChiseledBookShelfBlockEntity>> CHISELED_BOOKSHELF;
    public static Supplier<BlockEntityType<CWLecternBlockEntity>> LECTERN;
    public static Supplier<BlockEntityType<CWBeehiveBlockEntity>> BEEHIVE;
    public static Supplier<BlockEntityType<CWCrafterBlockEntity>> CRAFTER;

    public static void registerBlockEntities() {
        CarvedWood.LOGGER.info("Registering Mod Block Entities for " + CarvedWood.MOD_ID);

        CHEST = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "chest"),
                CWChestBlockEntity::new,
                () -> CarvedWood.getBlocks(CWChestBlock.class));

        TRAPPED_CHEST = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "trapped_chest"),
                CWTrappedChestBlockEntity::new,
                () -> CarvedWood.getBlocks(CWTrappedChestBlock.class));

        CAMPFIRE = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "campfire"),
                CWCampfireBlockEntity::new,
                () -> CarvedWood.getBlocks(CWCampfireBlock.class));

        BARREL = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "barrel"),
                CWBarrelBlockEntity::new,
                () -> CarvedWood.getBlocks(CWBarrelBlock.class));

        CHISELED_BOOKSHELF = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "chiseled_bookshelf"),
                CWChiseledBookShelfBlockEntity::new,
                () -> CarvedWood.getBlocks(CWChiseledBookShelfBlockType1.class, CWChiseledBookShelfBlockType2.class,
                        CWChiseledBookShelfBlockType3.class, CWChiseledBookShelfBlockType4.class,
                        CWChiseledBookShelfBlockType5.class, CWChiseledBookShelfBlockType6.class,
                        CWChiseledBookShelfBlockType7.class, CWChiseledBookShelfBlockType8.class));

        LECTERN = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "lectern"),
                CWLecternBlockEntity::new,
                () -> CarvedWood.getBlocks(CWLecternBlock.class));

        BEEHIVE = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "beehive"),
                CWBeehiveBlockEntity::new,
                () -> CarvedWood.getBlocks(CWBeehiveBlock.class));

        CRAFTER = PlatHelper.newBlockEntityType(
                CarvedWood.newRL(CarvedWood.MOD_ID, "crafter"),
                CWCrafterBlockEntity::new,
                () -> CarvedWood.getBlocks(CWCrafterBlock.class));
    }
}