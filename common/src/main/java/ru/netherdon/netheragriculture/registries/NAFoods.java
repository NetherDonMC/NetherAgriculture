package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

import static ru.netherdon.netheragriculture.services.ItemService.withEffect;
import static ru.netherdon.netheragriculture.services.ItemService.withEffects;

public final class NAFoods
{
    public static final FoodProperties CRIMSON_BERRY = new FoodProperties.Builder()
        .nutrition(2).saturationModifier(0.2f).fast()
        .build();

    public static final FoodProperties WARPED_BERRY = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(NAMobEffects.WARP, 400), 0.15f
        )
        .nutrition(3).saturationModifier(0.2f).fast()
        .build();

    public static final FoodProperties LOTHUN = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.CONFUSION, 300), 0.2f
        )
        .nutrition(4).saturationModifier(0.7F)
        .build();

    public static final FoodProperties SINFUL_EYES = new FoodProperties.Builder()
        .nutrition(2).saturationModifier(0.4F)
        .build();

    public static final FoodProperties MORTOFRUCT = new FoodProperties.Builder()
        .nutrition(3).saturationModifier(0.5f).build();

    public static final FoodProperties AZURE_MELON_SLICE = new FoodProperties.Builder()
        .nutrition(3).saturationModifier(0.2f).build();

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

    public static final FoodProperties BLAZE_CREAM_SOUP = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(NAMobEffects.BLAZE_FLIGHT, 200), 1f
        )
        .nutrition(11).saturationModifier(0.7f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties GLAZED_HOGLIN_MEAT = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300), 0.9f
        )
        .nutrition(12).saturationModifier(1.05f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties AZURE_MELON_PUREE = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.LUCK, 200), 1f
        )
        .nutrition(9).saturationModifier(0.35f).alwaysEdible()
        .build();

    public static final FoodProperties NETHER_MUSHROOM_STEW = new FoodProperties.Builder()
        .nutrition(6).saturationModifier(0.6f).usingConvertsTo(Items.BOWL).build();

    public static final FoodProperties NETHER_FRUIT_SALAD = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.REGENERATION, 200), 1f
        )
        .nutrition(8).saturationModifier(0.55f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties AZURE_MELON_JELLY = new FoodProperties.Builder()
        .nutrition(8).saturationModifier(0.4f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties NETHER_BERRY_JELLY = new FoodProperties.Builder()
        .nutrition(8).saturationModifier(0.3f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties CRIMSON_BERRY_JAM = new FoodProperties.Builder()
        .nutrition(5).saturationModifier(0.5f).alwaysEdible()
        .build();

    public static final FoodProperties WARPED_BERRY_JAM = new FoodProperties.Builder()
        .nutrition(8).saturationModifier(0.10f).alwaysEdible()
        .build();

    public static final FoodProperties NETHER_PORK_ROAST = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100), 0.7f
        )
        .nutrition(15).saturationModifier(0.7f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties STRIDER_WITH_VEGETABLES = withEffect(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300), 0.85f
        )
        .nutrition(10).saturationModifier(1f).usingConvertsTo(Items.BOWL).alwaysEdible()
        .build();

    public static final FoodProperties NETHER_BARBECUE_ON_A_STICK = new FoodProperties.Builder()
        .nutrition(9).saturationModifier(0.9f).usingConvertsTo(Items.STICK)
        .build();

    public static final FoodProperties BLAZING_BLEND = new FoodProperties.Builder()
        .nutrition(2).saturationModifier(0.2f).alwaysEdible()
        .build();

    public static final FoodProperties BLAZING_GOLDEN_LOTHUN = withEffects(new FoodProperties.Builder(),
            () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600),
            () -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300)
        )
        .nutrition(7).saturationModifier(0.7f).alwaysEdible()
        .build();
}
