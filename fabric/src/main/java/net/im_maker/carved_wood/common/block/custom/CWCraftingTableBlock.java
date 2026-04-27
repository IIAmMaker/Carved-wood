package net.im_maker.carved_wood.common.block.custom;

import net.im_maker.carved_wood.common.util.CWCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CWCraftingTableBlock extends CraftingTableBlock {
    private static final Component CONTAINER_TITLE = Component.translatable("container.crafting");

    public CWCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider((i, inventory, player) -> {
            return new CWCraftingMenu(this, i, inventory, ContainerLevelAccess.create(pLevel, pPos));
        }, CONTAINER_TITLE);
    }
}
