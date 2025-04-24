package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.items.*;

public final class NAItems
{
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(NetherAgriculture.ID);

    public static final DeferredItem<Item> CRIMSON_BERRY = REGISTER.registerSimpleItem("crimson_berry", new Item.Properties().food(NAFoods.CRIMSON_BERRY));
    public static final DeferredItem<Item> WARPED_BERRY = REGISTER.registerSimpleItem("warped_berry", new Item.Properties().food(NAFoods.WARPED_BERRY));
    public static final DeferredItem<Item> LOTHUN = REGISTER.register("lothun", () -> new ItemNameBlockItem(NABlocks.LOTHUNS.get(), new Item.Properties().food(NAFoods.LOTHUN)));
    public static final DeferredItem<Item> MORTOFRUCT_HALF = REGISTER.register("mortofruct_half", () -> new FoodItem(new Item.Properties().food(NAFoods.MORTOFRUCT)));
    public static final DeferredItem<BlockItem> AZURE_MELON = REGISTER.registerSimpleBlockItem(NABlocks.AZURE_MELON);
    public static final DeferredItem<Item> AZURE_MELON_SLICE = REGISTER.registerSimpleItem("azure_melon_slice", new Item.Properties().food(NAFoods.AZURE_MELON_SLICE));

    public static final DeferredItem<Item> BLAZE_FRUIT = REGISTER.register("blaze_fruit", () -> new BlazeFruitItem(
        new Item.Properties().food(NAFoods.BLAZE_FRUIT).fireResistant()
    ));

    public static final DeferredItem<Item> HOGLIN_MEAT = REGISTER.registerItem("hoglin_meat", FoodItem::new, new Item.Properties().food(NAFoods.HOGLIN_MEAT));
    public static final DeferredItem<Item> COOKED_HOGLIN_MEAT = REGISTER.registerItem("cooked_hoglin_meat", FoodItem::new, new Item.Properties().food(NAFoods.COOKED_HOGLIN_MEAT));
    public static final DeferredItem<Item> STRIDER_LEG = REGISTER.registerItem("strider_leg", FoodItem::new, new Item.Properties().food(NAFoods.STRIDER_LEG).fireResistant());
    public static final DeferredItem<Item> COOKED_STRIDER_LEG = REGISTER.registerItem("cooked_strider_leg", FoodItem::new, new Item.Properties().food(NAFoods.COOKED_STRIDER_LEG).fireResistant());

    public static final DeferredItem<Item> BLAZE_CREAM_SOUP = REGISTER.register("blaze_cream_soup", () -> new BurningFoodItem(
        100,
        new Item.Properties().stacksTo(16).food(NAFoods.BLAZE_CREAM_SOUP).fireResistant()
    ));
    public static final DeferredItem<Item> NETHER_MUSHROOM_STEW = REGISTER.register("nether_mushroom_stew", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_MUSHROOM_STEW)
    ));
    public static final DeferredItem<Item> NETHER_FRUIT_SALAD = REGISTER.register("nether_fruit_salad", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_FRUIT_SALAD)
    ));
    public static final DeferredItem<Item> GLAZED_HOGLIN_MEAT = REGISTER.register("glazed_hoglin_meat", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.GLAZED_HOGLIN_MEAT)
    ));
    public static final DeferredItem<Item> AZURE_MELON_SORBET = REGISTER.register("azure_melon_sorbet", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.AZURE_MELON_SORBET)
    ));

    public static final DeferredItem<BlockItem> CRIMSON_FARMLAND = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_FARMLAND);
    public static final DeferredItem<BlockItem> WARPED_FARMLAND = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_FARMLAND);
    public static final DeferredItem<BlockItem> DEAD_VINES = REGISTER.registerSimpleBlockItem(NABlocks.DEAD_VINES);
    public static final DeferredItem<BlockItem> MORTOFRUCT = REGISTER.registerSimpleBlockItem(NABlocks.MORTOFRUCT);
    public static final DeferredItem<BlockItem> CRIMSON_BERRY_SPROUTS = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_BERRY_SPROUTS);
    public static final DeferredItem<BlockItem> WARPED_BERRY_SPROUTS = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_BERRY_SPROUTS);
    public static final DeferredItem<BlockItem> WILD_LOTHUN = REGISTER.registerSimpleBlockItem(NABlocks.WILD_LOTHUN);

    public static final DeferredItem<BlockItem> CRIMSON_BERRY_SEEDS = REGISTER.register("crimson_berry_seeds", () -> new ItemNameBlockItem(NABlocks.CRIMSON_BERRY_ROOTS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> WARPED_BERRY_SEEDS = REGISTER.register("warped_berry_seeds", () -> new ItemNameBlockItem(NABlocks.WARPED_BERRY_ROOTS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> BLAZE_FRUIT_SEED = REGISTER.register("blaze_fruit_seed", () -> new ItemNameBlockItem(NABlocks.BLAZE_FRUIT.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> AZURE_MELON_SEEDS = REGISTER.register("azure_melon_seeds", () -> new ItemNameBlockItem(NABlocks.AZURE_MELON_STEM.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CRIMSON_CRATE = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_CRATE);
    public static final DeferredItem<BlockItem> SMALL_CRIMSON_CRATE = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE);
    public static final DeferredItem<BlockItem> WARPED_CRATE = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_CRATE);
    public static final DeferredItem<BlockItem> SMALL_WARPED_CRATE = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE);
    public static final DeferredItem<BlockItem> CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_CRIMSON_BERRIES);
    public static final DeferredItem<BlockItem> SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES);
    public static final DeferredItem<BlockItem> WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_CRIMSON_BERRIES);
    public static final DeferredItem<BlockItem> SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES);
    public static final DeferredItem<BlockItem> CRIMSON_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_WARPED_BERRIES);
    public static final DeferredItem<BlockItem> SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES);
    public static final DeferredItem<BlockItem> WARPED_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_WARPED_BERRIES);
    public static final DeferredItem<BlockItem> SMALL_WARPED_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_WARPED_BERRIES);
    public static final DeferredItem<BlockItem> CRIMSON_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_LOTHUN);
    public static final DeferredItem<BlockItem> SMALL_CRIMSON_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_LOTHUN);
    public static final DeferredItem<BlockItem> WARPED_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_LOTHUN);
    public static final DeferredItem<BlockItem> SMALL_WARPED_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_LOTHUN);
    public static final DeferredItem<BlockItem> CRIMSON_CRATE_OF_BLAZE_FRUIT = REGISTER.registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_BLAZE_FRUIT);
    public static final DeferredItem<BlockItem> SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT);
    public static final DeferredItem<BlockItem> WARPED_CRATE_OF_BLAZE_FRUIT = REGISTER.registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_BLAZE_FRUIT);
    public static final DeferredItem<BlockItem> SMALL_WARPED_CRATE_OF_BLAZE_FRUIT = REGISTER.registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_BLAZE_FRUIT);
}
