package net.im_maker.carved_wood.mixin;

import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LecternBlockEntity.class)
public interface LecternBlockEntityAccessor {
    @Accessor("dataAccess")
    ContainerData getDataAccess();
}