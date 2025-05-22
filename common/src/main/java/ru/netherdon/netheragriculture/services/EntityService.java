package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Contract;

public final class EntityService
{
    public static boolean isImmuneToFire(Entity entity)
    {
        return entity instanceof Player player
            && player.getAbilities().invulnerable
            || entity.fireImmune()
            || entity.isInWaterRainOrBubble()
            || entity.isInPowderSnow
            || EntityService.isLocalImmuneToFire(entity);
    }

    @ExpectPlatform
    @Contract(pure = true)
    private static boolean isLocalImmuneToFire(Entity entity)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static boolean canTrample(Entity entity, BlockState state, BlockPos pos, float fallDistance)
    {
        throw new UnsupportedOperationException();
    }
}
