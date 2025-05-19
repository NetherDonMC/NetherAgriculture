package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Contract;

public final class ParticleService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static boolean createType()
    {
        throw new UnsupportedOperationException();
    }
}
