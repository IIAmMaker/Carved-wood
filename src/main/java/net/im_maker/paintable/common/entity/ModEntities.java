/*
package net.im_maker.paintable.common.entity;

import net.im_maker.paintable.Paintable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Paintable.MOD_ID);

    public static final RegistryObject<EntityType<ModBoatEntity>> Mod_Boat =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));

    public static final RegistryObject<EntityType<ModChestBoatEntity>> Mod_Chest_Boat =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

 */
