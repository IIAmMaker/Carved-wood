package net.im_maker.carved_wood.common.item.custom;

import net.im_maker.carved_wood.common.block.custom.CWChestBlock;
import net.im_maker.carved_wood.common.block.custom.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.custom.CWChestBlockEntity;
import net.im_maker.carved_wood.common.block.entity.custom.CWTrappedChestBlockEntity;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ChestBlockItem extends BlockItem {
    private Block block;
    private Boolean trapped;
    private final String chestName;
    private int burnTime = 0;
    public ChestBlockItem(Block pBlock, Properties pProperties, Boolean trapped, int burnTime) {
        super(pBlock, pProperties);
        this.block = pBlock;
        this.trapped = trapped;
        chestName = block instanceof CWTrappedChestBlock ? ((CWTrappedChestBlock) block).getChestName() : ((CWChestBlock) block).getChestName();
        this.burnTime = burnTime;
    }

    public String getChestName() {
        return chestName;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                BlockEntity modelToUse;
                if (trapped) {
                    modelToUse = new CWTrappedChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
                } else {
                    modelToUse = new CWChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
                }
                return new CWBlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), modelToUse);
            }
        });
    }
}
