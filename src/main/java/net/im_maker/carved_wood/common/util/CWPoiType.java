package net.im_maker.carved_wood.common.util;

import com.google.common.collect.ImmutableSet;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.CWBarrelBlock;
import net.im_maker.carved_wood.common.block.custom.CWBeehiveBlock;
import net.im_maker.carved_wood.common.block.custom.CWLecternBlock;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class CWPoiType {
    public static final DeferredRegister<PoiType> CW_POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, CarvedWood.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
    public static final RegistryObject<PoiType> BEEHIVE = CW_POI_TYPES.register("beehive", () -> new PoiType(getBlockStates(getBlocks(CWBeehiveBlock.class)), 0, 1));
    public static final RegistryObject<PoiType> FISHERMAN = POI_TYPES.register("fisherman", () -> new PoiType(ImmutableSet.copyOf(getPOIFisherman()), 1, 1));
    public static final RegistryObject<PoiType> LIBRARIAN = POI_TYPES.register("librarian", () -> new PoiType(ImmutableSet.copyOf(getPOILibrarian()), 1, 1));

    @NotNull
    private static Consumer<Block> addAllBlockStates(Set<BlockState> states) {
        return block -> states.addAll(block.getStateDefinition().getPossibleStates());
    }

    private static Set<BlockState> getPOIFisherman() {
        Set<BlockState> states = new HashSet<>();
        ForgeRegistries.BLOCKS.getValues().stream()
                .filter(CWPoiType::isInBarrelsTag)
                .forEach(addAllBlockStates(states));
        return states;
    }

    private static Set<BlockState> getPOILibrarian() {
        Set<BlockState> states = new HashSet<>();
        ForgeRegistries.BLOCKS.getValues().stream()
                .filter(CWPoiType::isInLecternTag)
                .forEach(addAllBlockStates(states));
        return states;
    }

    private static boolean isInBarrelsTag(Block block) {
        return block instanceof CWBarrelBlock || block == Blocks.BARREL;
    }

    private static boolean isInLecternTag(Block block) {
        return block instanceof CWLecternBlock || block == Blocks.LECTERN;
    }

    private static Block[] getBlocks(Class<? extends Block> blockClass) {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(blockClass::isInstance)
                .toArray(Block[]::new);
    }

    private static Set<BlockState> getBlockStates(Block... blocks) {
        ImmutableSet.Builder<BlockState> builder = ImmutableSet.builder();
        for (Block block : blocks) {
            builder.addAll(block.getStateDefinition().getPossibleStates());
        }
        return builder.build();
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        CW_POI_TYPES.register(eventBus);
    }
}
