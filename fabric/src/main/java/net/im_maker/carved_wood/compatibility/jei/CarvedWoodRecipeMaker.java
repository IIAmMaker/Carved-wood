package net.im_maker.carved_wood.compatibility.jei;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.im_maker.carved_wood.common.util.CWTags;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;

import java.util.ArrayList;
import java.util.List;

public final class CarvedWoodRecipeMaker {
    private static final String BARREL_GROUP = "jei.carved_wood.barrel";
    private static final String BEEHIVE_GROUP = "jei.carved_wood.beehive";
    private static final String BOOKSHELF_GROUP = "jei.carved_wood.bookshelf";
    private static final String CAMPFIRE_GROUP = "jei.carved_wood.campfire";
    private static final String CHEST_GROUP = "jei.carved_wood.chest";
    private static final String CHISELED_BOOKSHELF_GROUP = "jei.carved_wood.chiseled_bookshelf";
    private static final String CRAFTING_TABLE_GROUP = "jei.carved_wood.crafting_table";
    private static final String LADDER_GROUP = "jei.carved_wood.ladder";
    private static final String LECTERN_GROUP = "jei.carved_wood.lectern";
    private static final String SOUL_CAMPFIRE_GROUP = "jei.carved_wood.soul_campfire";

    public static List<RecipeHolder<CraftingRecipe>> createCWRecipes() {
        List<RecipeHolder<CraftingRecipe>> recipes = new ArrayList<>();

        recipes.add(addBarrelRecipe());
        recipes.add(addBeehiveRecipe());
        recipes.add(addBookshelfRecipe());
        recipes.add(addCampfireRecipe());
        recipes.add(addChestRecipe());
        recipes.add(addChiseledBookshelfRecipe());
        recipes.add(addCraftingTableRecipe());
        recipes.add(addLadderRecipe());
        recipes.add(addLecternRecipe());
        recipes.add(addSoulCampfireRecipe());

        return recipes;
    }

    private static RecipeHolder<CraftingRecipe> addBarrelRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();
        Ingredient filteredSlabs = createFilteredSlabsIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredSlabs, filteredPlanks,
                filteredPlanks, Ingredient.EMPTY, filteredPlanks,
                filteredPlanks, filteredSlabs, filteredPlanks
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", BARREL_GROUP + ".barrel");
        ShapelessRecipe recipe = new ShapelessRecipe(BARREL_GROUP + ".barrel", CraftingBookCategory.MISC, new ItemStack(Items.BARREL), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addBeehiveRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, filteredPlanks,
                Ingredient.of(Items.HONEYCOMB), Ingredient.of(Items.HONEYCOMB), Ingredient.of(Items.HONEYCOMB),
                filteredPlanks, filteredPlanks, filteredPlanks
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", BEEHIVE_GROUP + ".beehive");
        ShapelessRecipe recipe = new ShapelessRecipe(BEEHIVE_GROUP + ".beehive", CraftingBookCategory.MISC, new ItemStack(Items.BEEHIVE), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addBookshelfRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, filteredPlanks,
                Ingredient.of(Items.BOOK), Ingredient.of(Items.BOOK), Ingredient.of(Items.BOOK),
                filteredPlanks, filteredPlanks, filteredPlanks
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", BOOKSHELF_GROUP + ".bookshelf");
        ShapelessRecipe recipe = new ShapelessRecipe(BOOKSHELF_GROUP + ".bookshelf", CraftingBookCategory.MISC, new ItemStack(Items.BOOKSHELF), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addCampfireRecipe() {
        Ingredient filteredLogs = createFilteredLogsIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                Ingredient.EMPTY, Ingredient.of(Items.STICK), Ingredient.EMPTY,
                Ingredient.of(Items.STICK), Ingredient.of(ItemTags.COALS), Ingredient.of(Items.STICK),
                filteredLogs, filteredLogs, filteredLogs
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", CAMPFIRE_GROUP + ".campfire");
        ShapelessRecipe recipe = new ShapelessRecipe(CAMPFIRE_GROUP + ".campfire", CraftingBookCategory.MISC, new ItemStack(Items.CAMPFIRE), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addChestRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, filteredPlanks,
                filteredPlanks, Ingredient.EMPTY, filteredPlanks,
                filteredPlanks, filteredPlanks, filteredPlanks
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", CHEST_GROUP + ".chest");
        ShapelessRecipe recipe = new ShapelessRecipe(CHEST_GROUP + ".chest", CraftingBookCategory.MISC, new ItemStack(Items.CHEST), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addChiseledBookshelfRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();
        Ingredient filteredSlabs = createFilteredSlabsIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, filteredPlanks,
                filteredSlabs, filteredSlabs, filteredSlabs,
                filteredPlanks, filteredPlanks, filteredPlanks
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", CHISELED_BOOKSHELF_GROUP + ".chiseled_bookshelf");
        ShapelessRecipe recipe = new ShapelessRecipe(CHISELED_BOOKSHELF_GROUP + ".chiseled_bookshelf", CraftingBookCategory.MISC, new ItemStack(Items.CHISELED_BOOKSHELF), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addCraftingTableRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, Ingredient.EMPTY,
                filteredPlanks, filteredPlanks, Ingredient.EMPTY,
                Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.EMPTY
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", CRAFTING_TABLE_GROUP + ".crafting_table");
        ShapelessRecipe recipe = new ShapelessRecipe(CRAFTING_TABLE_GROUP + ".crafting_table", CraftingBookCategory.MISC, new ItemStack(Items.CRAFTING_TABLE), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addLadderRecipe() {
        Ingredient filteredPlanks = createFilteredPlanksIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                Ingredient.of(Items.STICK), Ingredient.EMPTY, Ingredient.of(Items.STICK),
                Ingredient.of(Items.STICK), filteredPlanks, Ingredient.of(Items.STICK),
                Ingredient.of(Items.STICK), Ingredient.EMPTY, Ingredient.of(Items.STICK)
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", LADDER_GROUP + ".ladder");
        ShapelessRecipe recipe = new ShapelessRecipe(LADDER_GROUP + ".ladder", CraftingBookCategory.MISC, new ItemStack(Items.LADDER), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addLecternRecipe() {
        Ingredient filteredSlabs = createFilteredSlabsIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                filteredSlabs, filteredSlabs, filteredSlabs,
                Ingredient.EMPTY, Ingredient.of(ConventionalItemTags.BOOKSHELVES), Ingredient.EMPTY,
                Ingredient.EMPTY, filteredSlabs, Ingredient.EMPTY
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", LECTERN_GROUP + ".lectern");
        ShapelessRecipe recipe = new ShapelessRecipe(LECTERN_GROUP + ".lectern", CraftingBookCategory.MISC, new ItemStack(Items.LECTERN), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static RecipeHolder<CraftingRecipe> addSoulCampfireRecipe() {
        Ingredient filteredLogs = createFilteredLogsIngredient();

        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY,
                Ingredient.EMPTY, Ingredient.of(Items.STICK), Ingredient.EMPTY,
                Ingredient.of(Items.STICK), Ingredient.of(ItemTags.SOUL_FIRE_BASE_BLOCKS), Ingredient.of(Items.STICK),
                filteredLogs, filteredLogs, filteredLogs
        );
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("carved_wood", SOUL_CAMPFIRE_GROUP + ".soul_campfire");
        ShapelessRecipe recipe = new ShapelessRecipe(SOUL_CAMPFIRE_GROUP + ".soul_campfire", CraftingBookCategory.MISC, new ItemStack(Items.SOUL_CAMPFIRE), inputs);
        return new RecipeHolder<>(id, recipe);
    }

    private static Ingredient createFilteredPlanksIngredient() {
        List<ItemStack> filteredPlanks = new ArrayList<>();
        for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(ItemTags.PLANKS)) {
            if (!holder.is(CWTags.Items.FLAG)) {
                filteredPlanks.add(new ItemStack(holder));
            }
        }
        return Ingredient.of(filteredPlanks.toArray(new ItemStack[0]));
    }

    private static Ingredient createFilteredSlabsIngredient() {
        List<ItemStack> filteredSlabs = new ArrayList<>();
        for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(ItemTags.WOODEN_SLABS)) {
            if (!holder.is(CWTags.Items.FLAG)) {
                filteredSlabs.add(new ItemStack(holder));
            }
        }
        return Ingredient.of(filteredSlabs.toArray(new ItemStack[0]));
    }

    private static Ingredient createFilteredLogsIngredient() {
        List<ItemStack> filteredLogs = new ArrayList<>();
        for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(ItemTags.LOGS)) {
            if (!holder.is(CWTags.Items.FLAG)) {
                filteredLogs.add(new ItemStack(holder));
            }
        }
        return Ingredient.of(filteredLogs.toArray(new ItemStack[0]));
    }

    private CarvedWoodRecipeMaker() {
    }
}