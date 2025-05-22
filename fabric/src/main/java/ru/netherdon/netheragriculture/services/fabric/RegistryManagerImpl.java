package ru.netherdon.netheragriculture.services.fabric;

import net.minecraft.core.Registry;
import ru.netherdon.netheragriculture.fabric.registries.RegistryProvider;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;

public final class RegistryManagerImpl
{
    public static <T> IRegistryProvider<T> createProvider(Registry<T> registry)
    {
        return new RegistryProvider<>(registry);
    }
}
