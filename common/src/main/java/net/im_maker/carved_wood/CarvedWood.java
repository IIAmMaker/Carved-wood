package net.im_maker.carved_wood;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CarvedWood {
	public static final String MOD_ID = "carved_wood";
	public static final String MOD_NAME = "Carved Wood";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final List<String> WOOD_TYPES  = new ArrayList<>(Arrays.asList(
			"oak","spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "pale_oak", "bamboo", "crimson", "warped"
	));
	public static final com.google.common.base.Supplier<ImmutableBiMap<Object, Object>> ABNORMALS = Suppliers.memoize(() -> ImmutableBiMap.builder().put("a", "b").build());

	public static final Map<String, List<String>> MODDED_WOOD_SETS_WITH_ABNORMALS_COMPAT = Map.ofEntries(
			entry("atmospheric", List.of("morado", "yucca", "laurel", "aspen", "kousa", "grimwood", "rosewood")),
			entry("environmental", List.of("willow", "pine", "plum", "wisteria")),
			entry("upgrade_aquatic", List.of("driftwood", "river")),
			entry("caverns_and_chasms", List.of("azalea")),
			entry("endergetic", List.of("poise")),
			entry("autumanity", List.of("maple")),
			entry("windswept", List.of("holly", "pine", "chestnut")),
			entry("quark", List.of("trumpet", "ashen")),
			entry("alexscaves", List.of("pewen", "thornwood")),
			entry("architects_palette", List.of("twisted")),
			entry("mynethersddelight", List.of("powdery"))
	);

	private static void v () {
		for (Map.Entry<String, List<String>> entry : MODDED_WOOD_SETS_WITH_ABNORMALS_COMPAT.entrySet()) {
			String modID = entry.getKey();
			List<String> woodTypes = entry.getValue();
			for (String woodType : woodTypes) {
				System.out.println("Mod: " + modID + " | Wood: " + woodType);
			}
		}
	}

	//public static void main(String[] args) {
	//    v();
	//}

	public static Block[] getBlocks(Class<?>... blockClasses) {
		return BuiltInRegistries.BLOCK.stream()
				.filter(block -> Stream.of(blockClasses)
						.anyMatch(clazz -> clazz.isInstance(block)))
				.toArray(Block[]::new);
	}

	public static Block getBlockFromString (String block) {
		return getBlockFromString(MOD_ID, block);
	}

	public static Block getBlockFromString (String nameSpace, String block) {
		ResourceLocation blockLocation = ResourceLocation.fromNamespaceAndPath(nameSpace, block);
		return BuiltInRegistries.BLOCK.get(blockLocation);
	}

	public static Item getItemFromString (String item) {
		return getItemFromString(MOD_ID, item);
	}

	public static Item getItemFromString (String nameSpace, String item) {
		ResourceLocation itemLocation = ResourceLocation.fromNamespaceAndPath(nameSpace, item);
		return BuiltInRegistries.ITEM.get(itemLocation);
	}

	public static ResourceLocation newRL(String nameSpace, String path) {
		return ResourceLocation.fromNamespaceAndPath(nameSpace, path);
	}
}