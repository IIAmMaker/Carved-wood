package net.im_maker.carved_wood.platform;

import net.im_maker.carved_wood.config.CarvedWoodConfig;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import java.util.*;

public class CarvedWoodConfigScreen extends Screen {

    private final Screen parent;
    private final List<Checkbox> checkboxes = new ArrayList<>();
    private final Map<String, Boolean> configSnapshot;

    public CarvedWoodConfigScreen(Screen parent) {
        super(Component.translatable("carved_wood.config.title"));
        this.parent = parent;
        this.configSnapshot = new LinkedHashMap<>(CarvedWoodConfig.getAll());
    }

    @Override
    protected void init() {
        checkboxes.clear();
        int y = 30;
        int leftColumn = this.width / 2 - 160;
        int rightColumn = this.width / 2 + 10;

        List<String> sortedKeys = new ArrayList<>(configSnapshot.keySet());
        int half = (sortedKeys.size() + 1) / 2;

        for (int i = 0; i < sortedKeys.size(); i++) {
            String key = sortedKeys.get(i);
            int x = i < half ? leftColumn : rightColumn;
            int row = i < half ? i : i - half;

            Checkbox checkbox = Checkbox.builder(
                    Component.literal(formatKey(key)),
                    this.font
            ).selected(configSnapshot.get(key)).onValueChange((cb, value) -> {
                configSnapshot.put(key, value);
            }).pos(x, y + row * 24).build();

            checkboxes.add(checkbox);
            this.addRenderableWidget(checkbox);
        }

        // Save button
        this.addRenderableWidget(Button.builder(
                Component.translatable("carved_wood.config.save"),
                button -> {
                    configSnapshot.forEach(CarvedWoodConfig::set);
                    CarvedWoodConfig.save();
                    this.minecraft.setScreen(parent);
                }
        ).bounds(this.width / 2 - 105, this.height - 30, 100, 20).build());

        // Cancel button
        this.addRenderableWidget(Button.builder(
                Component.translatable("gui.cancel"),
                button -> this.minecraft.setScreen(parent)
        ).bounds(this.width / 2 + 5, this.height - 30, 100, 20).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 10, 0xFFFFFF);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }

    private String formatKey(String key) {
        // Convert "wooden_barrels" → "Wooden Barrels"
        String[] words = key.replace("_", " ").split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
}