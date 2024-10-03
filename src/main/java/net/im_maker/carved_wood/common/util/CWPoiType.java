package net.im_maker.carved_wood.common.util;

import com.google.common.collect.ImmutableSet;
import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.custom.CWBeehiveBlock;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class CWPoiType {
    public static final DeferredRegister<PoiType> POI_TYPES_VANILLA = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, CarvedWood.MOD_ID);

    public static final RegistryObject<PoiType> FISHERMAN = POI_TYPES_VANILLA.register("fisherman", () -> new PoiType(getBlockStates(getBlocks(BarrelBlock.class)), 1, 1));
    public static final RegistryObject<PoiType> LIBRARIAN = POI_TYPES_VANILLA.register("librarian", () -> new PoiType(getBlockStates(getBlocks(LecternBlock.class)), 1, 1));
    public static final RegistryObject<PoiType> BEEHIVE = POI_TYPES.register("beehive", () -> new PoiType(getBlockStates(getBlocks(CWBeehiveBlock.class)), 0, 1));

    private static Block[] getBlocks(Class<? extends Block> blockClass) {  // Changed Class<?> to Class<? extends Block>
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
    }
}
