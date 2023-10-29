package net.im_maker.wallpapers.common.tags;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.im_maker.wallpapers.Wallpapers;

public class ModItemTags {
    public static final TagKey<Item> WALLPAPER_ROLLS = tag("wallpaper_rolls");

    private static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation(Wallpapers.MOD_ID, name));
    }

}
