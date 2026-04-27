package net.im_maker.carved_wood.common.block.custom.chiseled_bookshelf;

import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.lang.reflect.Method;
import java.util.function.Supplier;

public class AmendmentsCompat {

    public static void openLecternEdit(ServerPlayer player, BlockEntity be) {
        try {

            Class<?> clazz = Class.forName(
                    "net.mehvahdjukaar.amendments.common.menu.LecternEditMenu");

            Method open = clazz.getMethod(
                    "open", ServerPlayer.class, BlockEntity.class);

            open.invoke(null, player, be);

        } catch (Exception ignored) {
        }
    }
}