package ru.netherdon.netheragriculture.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.EnderMan;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.registries.NAMobEffects;

@EventBusSubscriber(modid = NetherAgriculture.ID)
public final class EntityEventHandler
{
    @SubscribeEvent
    public static void spawn(EntityJoinLevelEvent event)
    {
        Entity entity = event.getEntity();
        if (entity instanceof EnderMan enderMan)
        {
            enderMan.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(enderMan, LivingEntity.class, 10, true, false, (target) ->
                target instanceof LivingEntity livingTarget && livingTarget.hasEffect(NAMobEffects.WARP))
            );
        }
    }
}
