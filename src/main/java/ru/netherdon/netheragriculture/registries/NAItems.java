package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.items.*;

public final class NAItems
{
    public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(NetherAgriculture.ID);

    public static final DeferredItem<Item> CRIMSON_BERRY = REGISTER.register("crimson_berry", () -> new FoodItem(new Item.Properties().food(NAFoods.CRIMSON_BERRY)));
    public static final DeferredItem<Item> WARPED_BERRIES = REGISTER.register("warped_berries", () -> new FoodItem(new Item.Properties().food(NAFoods.WARPED_BERRIES)));
    public static final DeferredItem<Item> LOTHUN = REGISTER.register("lothun", () -> new FoodItem(new Item.Properties().food(NAFoods.LOTHUN)));
    public static final DeferredItem<Item> MORTOFRUCT = REGISTER.register("mortofruct", () -> new FoodItem(new Item.Properties().food(NAFoods.MORTOFRUCT)));
    public static final DeferredItem<Item> AZURE_MELON = REGISTER.register("azure_melon", () -> new FoodItem(new Item.Properties().food(NAFoods.AZURE_MELON)));
    public static final DeferredItem<Item> EXTINGUISHED_BLAZE_FRUIT = REGISTER.register("extinguished_blaze_fruit", () -> new ExtinguishedItem(
        NAItems.BLAZE_FRUIT,
        new Item.Properties().food(NAFoods.BLAZE_FRUIT).fireResistant()
    ));
    public static final DeferredItem<Item> BLAZE_FRUIT = REGISTER.register("blaze_fruit", () -> new BlazeFruitItem(
        EXTINGUISHED_BLAZE_FRUIT,
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
}
