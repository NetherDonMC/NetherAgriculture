package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.util.Lazy;

public final class NAFoods
{
    public static final FoodProperties CRIMSON_BERRY = new FoodProperties.Builder()
        .nutrition(3).saturationModifier(0.2f).fast()
        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 0.05f)
        .build();

    public static final FoodProperties WARPED_BERRIES = new FoodProperties.Builder()
        .nutrition(3).saturationModifier(0.2f).fast()
        .effect(() -> new MobEffectInstance(NAMobEffects.WARP, 400), 0.25f)
        .build();

    public static final FoodProperties LOTHUN = new FoodProperties.Builder()
        .nutrition(4).saturationModifier(0.7F)
        .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300), 0.2f)
        .build();

    public static final FoodProperties MORTOFRUCT = new FoodProperties.Builder()
        .nutrition(3).saturationModifier(0.5f).build();

    public static final FoodProperties AZURE_MELON = new FoodProperties.Builder()
        .nutrition(7).saturationModifier(0.8f).build();

    public static final FoodProperties BLAZE_FRUIT = new FoodProperties.Builder()
        .nutrition(1).saturationModifier(0.05f).build();

    public static final FoodProperties HOGLIN_MEAT = new FoodProperties.Builder()
        .nutrition(4).saturationModifier(0.3f).build();

    public static final FoodProperties COOKED_HOGLIN_MEAT = new FoodProperties.Builder()
        .nutrition(9).saturationModifier(0.7f).build();

    public static final FoodProperties STRIDER_LEG = new FoodProperties.Builder()
        .nutrition(2).saturationModifier(0.2f).build();

    public static final FoodProperties COOKED_STRIDER_LEG = new FoodProperties.Builder()
        .nutrition(7).saturationModifier(0.6f).build();

    public static final FoodProperties BLAZE_CREAM_SOUP = new FoodProperties.Builder()
        .nutrition(8).saturationModifier(0.6f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .effect(() -> new MobEffectInstance(NAMobEffects.FLIGHT, 200), 1f)
        .build();

    public static final FoodProperties GLAZED_HOGLIN_MEAT = new FoodProperties.Builder()
        .nutrition(12).saturationModifier(1.05f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200), 0.9f)
        .build();

    public static final FoodProperties AZURE_MELON_SORBET = new FoodProperties.Builder()
        .nutrition(9).saturationModifier(0.7f).alwaysEdible()
        .effect(() -> new MobEffectInstance(MobEffects.LUCK, 200), 1f)
        .build();

    public static final FoodProperties NETHER_MUSHROOM_STEW = new FoodProperties.Builder()
        .nutrition(6).saturationModifier(0.6f).usingConvertsTo(Items.BOWL).build();

    public static final FoodProperties NETHER_FRUIT_SALAD = new FoodProperties.Builder()
        .nutrition(9).saturationModifier(0.3f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 0.9f)
        .build();
}
