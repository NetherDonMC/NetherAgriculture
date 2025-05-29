package ru.netherdon.netheragriculture.services.neoforge;

import net.neoforged.fml.ModList;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;

public final class ModLoaderServiceImpl
{
    public static boolean isModLoaded(String modId)
    {
        return ModList.get().isLoaded(modId);
    }

    public static ModLoaderTypes getModLoaderType()
    {
        return ModLoaderTypes.NEOFORGE;
    }
}
