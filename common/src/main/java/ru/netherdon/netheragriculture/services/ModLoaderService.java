package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.jetbrains.annotations.Contract;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;

import java.util.Arrays;

public final class ModLoaderService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static boolean isModLoaded(String modId)
    {
        throw new UnsupportedOperationException();
    }

    public static boolean anyModLoaded(String... modIds)
    {
        return Arrays.stream(modIds).anyMatch(ModLoaderService::isModLoaded);
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static ModLoaderTypes getModLoaderType()
    {
        throw new UnsupportedOperationException();
    }
}
