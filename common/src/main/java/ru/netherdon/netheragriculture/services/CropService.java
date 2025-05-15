package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public final class CropService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static boolean canGrow(ServerLevel level, BlockPos pos, BlockState state, boolean grown)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static void onGrowPost(ServerLevel level, BlockPos pos, BlockState state)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    @Nullable
    public static Boolean canSustainPlant(BlockState state, BlockGetter level, BlockPos pos, Direction direction, BlockState plantState)
    {
        throw new UnsupportedOperationException();
    }
}
