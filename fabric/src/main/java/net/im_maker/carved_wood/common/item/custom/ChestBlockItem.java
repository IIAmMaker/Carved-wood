package net.im_maker.carved_wood.common.item.custom;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.im_maker.carved_wood.client.renderer.inventory.CWBlockEntityWithoutLevelRenderer;
import net.im_maker.carved_wood.common.block.custom.CWChestBlock;
import net.im_maker.carved_wood.common.block.custom.CWTrappedChestBlock;
import net.im_maker.carved_wood.common.block.entity.custom.CWChestBlockEntity;
import net.im_maker.carved_wood.common.block.entity.custom.CWTrappedChestBlockEntity;
import net.im_maker.carved_wood.common.util.CWFuelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ChestBlockItem extends BlockItem {
    private Block block;
    private Boolean trapped;
    private final String chestName;
    private final int burnTime;
    public ChestBlockItem(Block pBlock, Properties pProperties, Boolean trapped, int burnTime) {
        super(pBlock, pProperties);
        this.block = pBlock;
        this.trapped = trapped;
        chestName = block instanceof CWTrappedChestBlock ? ((CWTrappedChestBlock) block).getChestName() : ((CWChestBlock) block).getChestName();
        this.burnTime = burnTime;
        CWFuelRegistry.registerFuel(this, burnTime);
        //registerItemRenderer();
    }

    public String getChestName() {
        return chestName;
    }

    public void registerItemRenderer() {
        BlockEntity be = trapped
                ? new CWTrappedChestBlockEntity(BlockPos.ZERO, block.defaultBlockState())
                : new CWChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());

        //BuiltinItemRendererRegistry.INSTANCE.register(this, new CWBlockEntityWithoutLevelRenderer(be));
    }

}
