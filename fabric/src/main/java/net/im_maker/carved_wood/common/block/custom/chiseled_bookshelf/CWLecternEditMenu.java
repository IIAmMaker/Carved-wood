package net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf;

import net.im_maker.carved_wood.CarvedWood;
import net.im_maker.carved_wood.common.block.entity.CWBlockEntities;
import net.im_maker.carved_wood.common.block.entity.custom.CWLecternBlockEntity;
import net.mehvahdjukaar.moonlight.api.misc.TileOrEntityTarget;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.LecternMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CWLecternEditMenu extends LecternMenu {
    private final BlockPos pos;
    private final MenuType<?> type = null;

    public static CWLecternEditMenu of(int id, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
        try {
            TileOrEntityTarget tile = TileOrEntityTarget.read(packetBuffer);

            // Add null check
            if (tile == null) {
                CarvedWood.LOGGER.error("Failed to read TileOrEntityTarget from packet");
                return null;
            }

            BlockPos pos = tile.getPos();
            if (pos == null) {
                CarvedWood.LOGGER.error("TileOrEntityTarget has null position");
                return null;
            }

            BlockEntity be = tile.getBlockEntityOrThrow(playerInventory.player.level(), CWBlockEntities.LECTERN);
            if (!(be instanceof CWLecternBlockEntity lecternBE)) {
                CarvedWood.LOGGER.error("Found block entity at {} is not a CWLecternBlockEntity: {}", pos, be);
                return null;
            }

            return new CWLecternEditMenu(id, lecternBE, new SimpleContainerData(1));
        } catch (Exception e) {
            CarvedWood.LOGGER.error("Failed to create LecternEditMenu", e);
            return null;
        }
    }

    public CWLecternEditMenu(int i, CWLecternBlockEntity container, ContainerData containerData) {
        super(i, (Container) container, containerData);
        this.pos = container.getBlockPos();
        //this.type = CWMenus.LECTERN_EDIT_MENU.get();
    }

    @Override
    public MenuType<?> getType() {
        return type;
    }

    public BlockPos getPos() {
        return this.pos;
    }
}