package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.NeoForgeMod;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.effects.BlazeFlightEffect;

public final class MobEffectServiceImpl
{
    public static void fireBlazeFlightTick(LivingEntity entity, int tick)
    {

    }

    public static MobEffect modifyBlazeFlight(BlazeFlightEffect effect)
    {
        return effect.addAttributeModifier(
            NeoForgeMod.CREATIVE_FLIGHT,
            NetherAgriculture.location("blaze_flight_mob_effect"),
            1,
            AttributeModifier.Operation.ADD_VALUE
        );
    }
}
