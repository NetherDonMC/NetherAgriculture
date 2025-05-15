package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;

public final class EntityServiceImpl
{
    public static boolean isImmuneToFire(Entity entity)
    {
        return entity.isInFluidType((fluidType, height) -> entity.canFluidExtinguish(fluidType));
    }

    public static boolean canTrample(Entity entity, BlockState state, BlockPos pos, float fallDistance)
    {
        return entity.canTrample(state, pos, fallDistance);
    }
}
