package ru.netherdon.netheragriculture.services;

import com.mojang.datafixers.util.Pair;
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

    public static FoodProperties.Builder withEffects(FoodProperties.Builder builder, Supplier<MobEffectInstance>... effects)
    {
        for (var effect : effects)
        {
            builder = withEffect(builder, effect, 1f);
        }

        return builder;
    }
}
