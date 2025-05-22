package ru.netherdon.netheragriculture.services.fabric;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import ru.netherdon.netheragriculture.effects.BlazeFlightEffect;

public final class MobEffectServiceImpl
{
    public static void fireBlazeFlightTick(LivingEntity entity, int tick)
    {
        if (entity instanceof Player player && !player.getAbilities().mayfly)
        {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        }
    }

    public static MobEffect modifyBlazeFlight(BlazeFlightEffect effect)
    {
        return effect;
    }
}
