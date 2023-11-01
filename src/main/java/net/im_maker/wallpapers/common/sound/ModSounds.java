package net.im_maker.wallpapers.common.sound;

import net.im_maker.wallpapers.Wallpapers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Wallpapers.MOD_ID);

    public static final RegistryObject<SoundEvent> WALLPAPER_BLOCK_BREAK = registerSoundEvents("block.wallpaper_block.break");
    public static final RegistryObject<SoundEvent> WALLPAPER_BLOCK_STEP = registerSoundEvents("block.wallpaper_block.step");
    public static final RegistryObject<SoundEvent> WALLPAPER_BLOCK_PLACE = registerSoundEvents("block.wallpaper_block.place");
    public static final RegistryObject<SoundEvent> WALLPAPER_BLOCK_HIT = registerSoundEvents("block.wallpaper_block.hit");
    public static final RegistryObject<SoundEvent> WALLPAPER_BLOCK_FALL = registerSoundEvents("block.wallpaper_block.fall");

    public static final RegistryObject<SoundEvent> WALLPAPER_ROLL_WALLPAPERING = registerSoundEvents("item.wallpaper_roll.wallpapering");
    public static final RegistryObject<SoundEvent> BASEBOARD_PLACE = registerSoundEvents("item.baseboard.place");

    public static final ForgeSoundType WALLPAPER_BLOCK = new ForgeSoundType(1f, 1f,
            ModSounds.WALLPAPER_BLOCK_BREAK,
            ModSounds.WALLPAPER_BLOCK_STEP,
            ModSounds.WALLPAPER_BLOCK_PLACE,
            ModSounds.WALLPAPER_BLOCK_HIT,
            ModSounds.WALLPAPER_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(Wallpapers.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Wallpapers.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
