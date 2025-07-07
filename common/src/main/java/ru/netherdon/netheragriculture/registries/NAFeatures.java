package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusFeature;
import ru.netherdon.netheragriculture.services.RegistryManager;
import ru.netherdon.netheragriculture.world.*;

public final class NAFeatures
{
    private static final IRegistryProvider<Feature<?>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.FEATURE);

    public static final Holder<TallNetherVegetationFeature> TALL_NETHER_VEGETATION = REGISTER.register("tall_nether_vegetation", () -> new TallNetherVegetationFeature(TallNetherVegetationConfig.CODEC));
    public static final Holder<MortofructFeature> MORTOFRUCT = REGISTER.register("mortofruct", () -> new MortofructFeature(MortofructFeatureConfiguration.CODEC));
    public static final Holder<NAHugeFungusFeature> HUGE_FUNGUS = REGISTER.register("huge_fungus", () -> new NAHugeFungusFeature(NAHugeFungusConfiguration.CODEC));

    public static void initialize() {}
}
