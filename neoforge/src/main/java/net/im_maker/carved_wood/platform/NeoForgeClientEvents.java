package net.im_maker.carved_wood.platform;

import net.im_maker.carved_wood.CarvedWood;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;

@EventBusSubscriber(modid = CarvedWood.MOD_ID, value = Dist.CLIENT)
public class NeoForgeClientEvents {

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof TitleScreen titleScreen) {
            Button configButton = Button.builder(
                    Component.translatable("carved_wood.config.title"),
                    button -> event.getScreen().getMinecraft().setScreen(
                            new CarvedWoodConfigScreen(event.getScreen())
                    )
            ).bounds(
                    titleScreen.width / 2 - 100,
                    titleScreen.height / 4 + 100,
                    200,
                    20
            ).build();

            event.addListener(configButton);
        }
    }
}