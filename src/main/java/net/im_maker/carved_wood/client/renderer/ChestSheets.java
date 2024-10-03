package net.im_maker.carved_wood.client.renderer;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;

public class ChestSheets {

    public static Material chooseMaterial(String type, BlockEntity pBlockEntity, ChestType pChestType, boolean pHoliday) {
        Material CHEST_TRAP_LOCATION = chestMaterial(type + "/trapped");
        Material CHEST_TRAP_LOCATION_LEFT = chestMaterial(type + "/trapped_left");
        Material CHEST_TRAP_LOCATION_RIGHT = chestMaterial( type + "/trapped_right");
        Material CHEST_LOCATION = chestMaterial(type + "/normal");
        Material CHEST_LOCATION_LEFT = chestMaterial(type + "/normal_left");
        Material CHEST_LOCATION_RIGHT = chestMaterial(type + "/normal_right");
        if (pHoliday) {
            return chooseMaterial(pChestType, Sheets.CHEST_XMAS_LOCATION, Sheets.CHEST_XMAS_LOCATION_LEFT, Sheets.CHEST_XMAS_LOCATION_RIGHT);
        } else {
            return pBlockEntity instanceof TrappedChestBlockEntity ? chooseMaterial(pChestType, CHEST_TRAP_LOCATION, CHEST_TRAP_LOCATION_LEFT, CHEST_TRAP_LOCATION_RIGHT) : chooseMaterial(pChestType, CHEST_LOCATION, CHEST_LOCATION_LEFT, CHEST_LOCATION_RIGHT);
        }
    }

    private static Material chestMaterial(String pChestName) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(CarvedWood.MOD_ID, "entity/chest/" + pChestName));
    }


    private static Material chooseMaterial(ChestType pChestType, Material pDoubleMaterial, Material pLeftMaterial, Material pRightMaterial) {
        return switch (pChestType) {
            case LEFT -> pLeftMaterial;
            case RIGHT -> pRightMaterial;
            default -> pDoubleMaterial;
        };
    }
}
