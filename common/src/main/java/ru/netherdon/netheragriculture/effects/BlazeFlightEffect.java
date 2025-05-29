package ru.netherdon.netheragriculture.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import ru.netherdon.netheragriculture.config.NAServerConfig;
import ru.netherdon.netheragriculture.services.EntityService;
import ru.netherdon.netheragriculture.services.MobEffectService;

public class BlazeFlightEffect extends MobEffect
{
    public BlazeFlightEffect(MobEffectCategory mobEffectCategory, int color)
    {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int tick)
    {
        MobEffectService.fireBlazeFlightTick(entity, tick);

        if (
            entity instanceof Player player
            && player.getAbilities().flying
            && !EntityService.isImmuneToFire(player)
            && entity.getRemainingFireTicks() <= 0
            && NAServerConfig.get().entity.isBurningFromBlazeFlightEnabled()
        )
        {
            player.igniteForTicks(20);
        }

        return super.applyEffectTick(entity, tick);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int i, int j)
    {
        return true;
    }
}
