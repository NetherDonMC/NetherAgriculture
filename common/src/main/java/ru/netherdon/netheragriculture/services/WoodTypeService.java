package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.Contract;

public final class WoodTypeService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static WoodType register(WoodType type)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static BlockSetType registerSetType(BlockSetType type)
    {
        throw new UnsupportedOperationException();
    }
}
