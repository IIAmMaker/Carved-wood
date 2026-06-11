package net.im_maker.carved_wood.common.util;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

public class CWCraftingMenu extends CraftingMenu {

    private final ContainerLevelAccess access;
    private final Block validBlock;

    public CWCraftingMenu(int id, Inventory inv, ContainerLevelAccess access, Block validBlock) {
        super(id, inv, access);
        this.access = access;
        this.validBlock = validBlock;
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(this.access, player, validBlock);
    }
}