package ru.netherdon.netheragriculture.services.fabric;

import net.fabricmc.loader.api.FabricLoader;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;

public final class ModLoaderServiceImpl
{
    public static boolean isModLoaded(String modId)
    {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static ModLoaderTypes getModLoaderType()
    {
        return ModLoaderTypes.FABRIC;
    }
}
