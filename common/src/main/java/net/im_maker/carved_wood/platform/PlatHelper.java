package net.im_maker.carved_wood.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlatHelper {

    private static PlatHelper INSTANCE;

    public static void setInstance(PlatHelper instance) {
        INSTANCE = instance;
    }

    @FunctionalInterface
    public interface BlockEntitySupplier<T extends BlockEntity> {
        @NotNull T create(BlockPos pos, BlockState state);
    }

    // Block registration
    public static Supplier<Block> registerBlock(ResourceLocation id, Supplier<Block> supplier) {
        return INSTANCE.registerBlockImpl(id, supplier);
    }

    protected Supplier<Block> registerBlockImpl(ResourceLocation id, Supplier<Block> supplier) {
        throw new AssertionError("Platform implementation not set!");
    }

    // Item registration
    public static Supplier<Item> registerItem(ResourceLocation id, Supplier<Item> supplier) {
        return INSTANCE.registerItemImpl(id, supplier);
    }

    protected Supplier<Item> registerItemImpl(ResourceLocation id, Supplier<Item> supplier) {
        throw new AssertionError("Platform implementation not set!");
    }

    // Block Entity Type registration
    public static <T extends BlockEntity> Supplier<BlockEntityType<T>> newBlockEntityType(
            ResourceLocation id, BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        return INSTANCE.newBlockEntityTypeImpl(id, supplier, validBlocksSupplier);
    }

    protected <T extends BlockEntity> Supplier<BlockEntityType<T>> newBlockEntityTypeImpl(
            ResourceLocation id, BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier) {
        throw new AssertionError("Platform implementation not set!");
    }

    // POI registration
    public static void addPOI(Consumer<Map<BlockState, Holder<PoiType>>> poiRegistrar) {
        INSTANCE.addPOIImpl(poiRegistrar);
    }

    protected void addPOIImpl(Consumer<Map<BlockState, Holder<PoiType>>> poiRegistrar) {
        throw new AssertionError("Platform implementation not set!");
    }

    // Recipe Serializer registration
    public static <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(
            ResourceLocation id, Supplier<T> serializer) {
        return INSTANCE.registerRecipeSerializerImpl(id, serializer);
    }

    protected <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializerImpl(
            ResourceLocation id, Supplier<T> serializer) {
        throw new AssertionError("Platform implementation not set!");
    }

    public static void addFlammableBlock(Block block, int catchChance, int burnChance) {
        INSTANCE.addFlammableBlockImpl(block, catchChance, burnChance);
    }

    protected void addFlammableBlockImpl(Block block, int catchChance, int burnChance) {
        throw new AssertionError("Platform implementation not set!");
    }

    public static void addFuelItem(Supplier<? extends ItemLike> itemSupplier, int burnTime) {
        INSTANCE.addFuelItemImpl(itemSupplier, burnTime);
    }

    protected void addFuelItemImpl(Supplier<? extends ItemLike> itemSupplier, int burnTime) {
        throw new AssertionError("Platform implementation not set!");
    }

    public static boolean isModLoaded(String modId) {
        return INSTANCE.isModLoadedImpl(modId);
    }

    public static boolean isFabric() {
        return isModLoaded("fabric");
    }

    public static boolean isNeoForge() {
        return isModLoaded("neoforge");
    }

    protected boolean isModLoadedImpl(String modId) {
        throw new AssertionError("Platform implementation not set!");
    }
}