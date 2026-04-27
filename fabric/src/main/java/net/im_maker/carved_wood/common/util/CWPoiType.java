package net.im_maker.carved_wood.common.util;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.im_maker.carved_wood.common.block.custom.CWBarrelBlock;
import net.im_maker.carved_wood.common.block.custom.CWBeehiveBlock;
import net.im_maker.carved_wood.common.block.custom.CWLecternBlock;
import net.im_maker.carved_wood.mixin.MixinPoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CollectionTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class CWPoiType {
    public static void init() {
        Map<BlockState, Holder<PoiType>> poiStatesToType = MixinPoiTypesAccessor.getPoiStatesToType();
        PoiType fishermanPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.FISHERMAN.location());
        PoiType librarianPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.LIBRARIAN.location());
        PoiType beehivePoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.BEEHIVE.location());
        List<BlockState> fishermanBlockStates = new ArrayList<>(fishermanPoiType.matchingStates());
        List<BlockState> librarianBlockStates = new ArrayList<>(librarianPoiType.matchingStates());
        List<BlockState> beehiveBlockStates = new ArrayList<>(beehivePoiType.matchingStates());

        for (Block block : BuiltInRegistries.BLOCK) {
            if (isInBarrels(block)) {
                List<BlockState> blockStates = new ArrayList<>(getPOIFisherman());

                for (BlockState blockState : blockStates) {
                    poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(fishermanPoiType));
                }
                fishermanBlockStates.addAll(blockStates);
            }
            if (isInLectern(block)) {
                List<BlockState> blockStates = new ArrayList<>(getPOILibrarian());

                for (BlockState blockState : blockStates) {
                    poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(librarianPoiType));
                }
                librarianBlockStates.addAll(blockStates);
            }
            if (isInBeehive(block)) {
                List<BlockState> blockStates = new ArrayList<>(getPOIBeehive());

                for (BlockState blockState : blockStates) {
                    poiStatesToType.putIfAbsent(blockState, BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(beehivePoiType));
                }
                beehiveBlockStates.addAll(blockStates);
            }
        }
    }

    private static Set<BlockState> getPOILibrarian() {
        Set<BlockState> states = new HashSet<>();
        BuiltInRegistries.BLOCK.stream()
                .filter(CWPoiType::isInLectern)
                .forEach(addAllBlockStates(states));
        return states;
    }

    private static Set<BlockState> getPOIFisherman() {
        Set<BlockState> states = new HashSet<>();
        BuiltInRegistries.BLOCK.stream()
                .filter(CWPoiType::isInBarrels)
                .forEach(addAllBlockStates(states));
        return states;
    }

    private static Set<BlockState> getPOIBeehive() {
        Set<BlockState> states = new HashSet<>();
        BuiltInRegistries.BLOCK.stream()
                .filter(CWPoiType::isInBeehive)
                .forEach(addAllBlockStates(states));
        return states;
    }

    private static boolean isInBarrels(Block block) {
        return block instanceof CWBarrelBlock || block.defaultBlockState().is(CWTags.Blocks.WOODEN_BARRELS);
    }

    private static boolean isInLectern(Block block) {
        return block instanceof CWLecternBlock || block == Blocks.LECTERN || block.defaultBlockState().is(CWTags.Blocks.LECTERNS);
    }

    private static boolean isInBeehive(Block block) {
        return block instanceof CWBeehiveBlock || block == Blocks.BEEHIVE || block.defaultBlockState().is(BlockTags.BEEHIVES);
    }

    @NotNull
    private static Consumer<Block> addAllBlockStates(Set<BlockState> states) {
        return block -> states.addAll(block.getStateDefinition().getPossibleStates());
    }
}