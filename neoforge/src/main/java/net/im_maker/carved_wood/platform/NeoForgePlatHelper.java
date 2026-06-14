package net.im_maker.carved_wood.platform;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.mixin.PoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NeoForgePlatHelper extends PlatHelper {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CarvedWood.MOD_ID);

    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CarvedWood.MOD_ID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CarvedWood.MOD_ID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CarvedWood.MOD_ID);

    private static final List<FuelEntry> FUEL_ENTRIES = new ArrayList<>();

    public NeoForgePlatHelper(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
        //eventBus.addListener(NeoForgePlatHelper::registerFuels);
        NeoForge.EVENT_BUS.addListener(NeoForgePlatHelper::registerFuels);
    }

    @Override
    protected Supplier<Block> registerBlockImpl(ResourceLocation id, Supplier<Block> supplier) {
        return BLOCKS.register(id.getPath(), supplier);
    }

    @Override
    protected Supplier<Item> registerItemImpl(ResourceLocation id, Supplier<Item> supplier) {
        return ITEMS.register(id.getPath(), supplier);
    }

    @Override
    protected <T extends BlockEntity> Supplier<BlockEntityType<T>> newBlockEntityTypeImpl(
            ResourceLocation id, BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        return BLOCK_ENTITIES.register(id.getPath(), () ->
                BlockEntityType.Builder.of(supplier::create, validBlocksSupplier.get()).build(null)
        );
    }

    @Override
    protected void addPOIImpl(Consumer<Map<BlockState, Holder<PoiType>>> poiRegistrar) {
        poiRegistrar.accept(PoiTypesAccessor.getPoiStatesToType());
    }

    @Override
    protected <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializerImpl(
            ResourceLocation id, Supplier<T> serializer) {
        return RECIPE_SERIALIZERS.register(id.getPath(), serializer);
    }

    @Override
    protected void addFlammableBlockImpl(Block block, int catchChance, int burnChance) {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(block, catchChance, burnChance);
    }

    @Override
    protected void addFuelItemImpl(Supplier<? extends ItemLike> itemSupplier, int burnTime) {
        FUEL_ENTRIES.add(new FuelEntry(itemSupplier, burnTime));
    }

    public static void registerFuels(FurnaceFuelBurnTimeEvent event) {
        for (FuelEntry entry : FUEL_ENTRIES) {
            if (event.getItemStack().is(entry.item.get().asItem())) {  // .get() here, during event
                event.setBurnTime(entry.burnTime);
            }
        }
    }

    @Override
    protected boolean isModLoadedImpl(String modId) {
        return net.neoforged.fml.ModList.get().isLoaded(modId);
    }

    private static class FuelEntry {
        final Supplier<? extends ItemLike> item;  // Changed to Supplier
        final int burnTime;

        FuelEntry(Supplier<? extends ItemLike> item, int burnTime) {
            this.item = item;
            this.burnTime = burnTime;
        }
    }
}