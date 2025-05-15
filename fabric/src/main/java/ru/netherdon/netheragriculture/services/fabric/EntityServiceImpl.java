package ru.netherdon.netheragriculture.services.fabric;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public final class EntityServiceImpl
{
    public static boolean isImmuneToFire(Entity entity)
    {
        return false;
    }

    public static boolean canTrample(Entity entity, BlockState state, BlockPos pos, float fallDistance)
    {
        Level level = entity.level();
        return level.random.nextFloat() < fallDistance - 0.5F
            && entity instanceof LivingEntity
            && (entity instanceof Player || level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING))
            && entity.getBbWidth() * entity.getBbWidth() * entity.getBbHeight() > 0.512F;
    }
}
