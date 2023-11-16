package net.im_maker.paint.common.sound;

import net.im_maker.paint.Paint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Paint.MOD_ID);

    public static final RegistryObject<SoundEvent> DIPPING_PAINT_BRUSH = registerSoundEvents("item.paint_brush.dipping");
    public static final RegistryObject<SoundEvent> PAINT_BRUSH_PAINT = registerSoundEvents("item.paint_brush.paint");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(Paint.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
