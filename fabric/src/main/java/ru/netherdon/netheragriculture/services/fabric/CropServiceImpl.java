package ru.netherdon.netheragriculture.services.fabric;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public final class CropServiceImpl
{
    public static boolean canGrow(ServerLevel level, BlockPos pos, BlockState state, boolean grown)
    {
        return grown;
    }

    public static void onGrowPost(ServerLevel level, BlockPos pos, BlockState state)
    {

    }

    @Nullable
    public static Boolean canSustainPlant(BlockState state, BlockGetter level, BlockPos pos, Direction direction, BlockState plantState)
    {
        return null;
    }
}
