package net.im_maker.carved_wood.common.registers;

import net.im_maker.carved_wood.common.block.CWBarrelBlock;
import net.im_maker.carved_wood.common.block.CWBeehiveBlock;
import net.im_maker.carved_wood.common.block.CWLecternBlock;
import net.im_maker.carved_wood.common.util.CWTags;
import net.im_maker.carved_wood.platform.PlatHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CWPoiType {
    public static void init() {
        PlatHelper.addPOI(poiStatesToType -> {
            PoiType fishermanPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.FISHERMAN.location());
            PoiType librarianPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.LIBRARIAN.location());
            PoiType beehivePoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.BEEHIVE.location());

            for (Block block : BuiltInRegistries.BLOCK) {
                if (isInBarrels(block)) {
                    for (BlockState blockState : block.getStateDefinition().getPossibleStates()) {
                        poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(fishermanPoiType));
                    }
                }
                if (isInLectern(block)) {
                    for (BlockState blockState : block.getStateDefinition().getPossibleStates()) {
                        poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(librarianPoiType));
                    }
                }
                if (isInBeehive(block)) {
                    for (BlockState blockState : block.getStateDefinition().getPossibleStates()) {
                        poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(beehivePoiType));
                    }
                }
            }
        });
    }

    private static boolean isInBarrels(Block block) {
        return block instanceof CWBarrelBlock || block == Blocks.BARREL || block.defaultBlockState().is(CWTags.Blocks.WOODEN_BARRELS);
    }

    private static boolean isInLectern(Block block) {
        return block instanceof CWLecternBlock || block == Blocks.LECTERN || block.defaultBlockState().is(CWTags.Blocks.LECTERNS);
    }

    private static boolean isInBeehive(Block block) {
        return block instanceof CWBeehiveBlock || block == Blocks.BEEHIVE || block.defaultBlockState().is(BlockTags.BEEHIVES);
    }
}