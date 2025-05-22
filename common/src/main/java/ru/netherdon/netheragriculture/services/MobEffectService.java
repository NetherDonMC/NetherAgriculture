package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Contract;
import ru.netherdon.netheragriculture.effects.BlazeFlightEffect;

public final class MobEffectService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static void fireBlazeFlightTick(LivingEntity entity, int tick)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static MobEffect modifyBlazeFlight(BlazeFlightEffect effect)
    {
        throw new UnsupportedOperationException();
    }
}
