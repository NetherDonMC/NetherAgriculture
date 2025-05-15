package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Contract;

public final class EntityService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static boolean isImmuneToFire(Entity entity)
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
