package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import org.jetbrains.annotations.Contract;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;

import java.util.HashMap;
import java.util.Map;

public final class RegistryManager
{
    private static final Map<Registry<?>, IRegistryProvider<?>> PROVIDERS = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> IRegistryProvider<T> getOrCreate(Registry<T> registry)
    {
        if (!PROVIDERS.containsKey(registry))
        {
            IRegistryProvider<T> provider = createProvider(registry);
            PROVIDERS.put(registry, provider);
            return provider;
        }

        return (IRegistryProvider<T>) PROVIDERS.get(registry);
    }

    @ExpectPlatform
    @Contract(pure = true)
    private static <T> IRegistryProvider<T> createProvider(Registry<T> registry)
    {
        throw new UnsupportedOperationException();
    }

    @ExpectPlatform
    @Contract(pure = true)
    public static MobEffect createBlazeFlightEffect()
    {
        throw new UnsupportedOperationException();
    }
}
