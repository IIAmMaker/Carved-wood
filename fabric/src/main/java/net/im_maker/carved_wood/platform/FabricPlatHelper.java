package net.im_maker.carved_wood.platform;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.im_maker.carved_wood.mixin.PoiTypesAccessor;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FabricPlatHelper extends PlatHelper {

    @Override
    protected Supplier<Block> registerBlockImpl(ResourceLocation id, Supplier<Block> supplier) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, id, supplier.get());
        return () -> block;
    }

    @Override
    protected Supplier<Item> registerItemImpl(ResourceLocation id, Supplier<Item> supplier) {
        Item item = Registry.register(BuiltInRegistries.ITEM, id, supplier.get());
        return () -> item;
    }

    @Override
    protected <T extends BlockEntity> Supplier<BlockEntityType<T>> newBlockEntityTypeImpl(
            ResourceLocation id, BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        BlockEntityType<T> type = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                id,
                BlockEntityType.Builder.of(supplier::create, validBlocksSupplier.get()).build(null)
        );
        return () -> type;
    }

    @Override
    protected void addPOIImpl(Consumer<Map<BlockState, Holder<PoiType>>> poiRegistrar) {
        poiRegistrar.accept(PoiTypesAccessor.getPoiStatesToType());
    }

    @Override
    protected <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializerImpl(
            ResourceLocation id, Supplier<T> serializer) {
        T type = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                id,
                serializer.get()
        );
        return () -> type;
    }

    @Override
    protected void addFlammableBlockImpl(Block block, int catchChance, int burnChance) {
        FlammableBlockRegistry.getInstance(Blocks.FIRE).add(block, catchChance, burnChance);
    }

    @Override
    protected void addFuelItemImpl(Supplier<? extends ItemLike> itemSupplier, int burnTime) {
        FuelRegistry.INSTANCE.add(itemSupplier.get().asItem(), burnTime);
    }

    @Override
    protected boolean isModLoadedImpl(String modId) {
        return net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    protected void registerItemRendererImpl(ItemLike item, CWBlockEntityWithoutLevelRenderer renderer) {
        BuiltinItemRendererRegistry.INSTANCE.register(item.asItem(), (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderer.renderByItem(stack, mode, matrices, vertexConsumers, light, overlay);
        });
    }
}