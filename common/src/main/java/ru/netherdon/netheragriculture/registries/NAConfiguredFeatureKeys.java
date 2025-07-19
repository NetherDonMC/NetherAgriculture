package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import ru.netherdon.netheragriculture.NetherAgriculture;

public final class NAConfiguredFeatureKeys
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_FUNGUS = configured("glowing_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROOTS_BONEMEAL = configured("nether_roots_bonemeal");

    private static ResourceKey<ConfiguredFeature<?, ?>> configured(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NetherAgriculture.location(name));
    }
}
