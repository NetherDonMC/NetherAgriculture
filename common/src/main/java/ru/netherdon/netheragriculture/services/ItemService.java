package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.Contract;

import java.util.function.Supplier;

public final class ItemService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static FoodProperties.Builder withEffect(FoodProperties.Builder builder, Supplier<MobEffectInstance> effect, float probability)
    {
        throw new UnsupportedOperationException();
    }
}
