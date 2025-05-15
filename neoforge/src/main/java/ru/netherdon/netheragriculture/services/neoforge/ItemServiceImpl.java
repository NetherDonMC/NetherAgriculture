package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public final class ItemServiceImpl
{
    public static FoodProperties.Builder withEffect(FoodProperties.Builder builder, Supplier<MobEffectInstance> effect, float probability)
    {
        return builder.effect(effect, probability);
    }
}
