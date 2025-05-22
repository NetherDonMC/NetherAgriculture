package ru.netherdon.netheragriculture.fabric.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import ru.netherdon.netheragriculture.registries.NAFeatureKeys;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public final class NABiomeModifiers
{
    public static void initialize()
    {
        addVegetation(
            BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
            List.of(
                NAFeatureKeys.WILD_LOTHUN,
                NAFeatureKeys.WARPED_BERRY_SPROUTS,
                NAFeatureKeys.TALL_WARPED_ROOTS,
                NAFeatureKeys.AZURE_MELON
            )
        );

        addVegetation(
            BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST),
            List.of(
                NAFeatureKeys.WILD_SINFUL_EYES,
                NAFeatureKeys.CRIMSON_BERRY_SPROUTS,
                NAFeatureKeys.TALL_CRIMSON_ROOTS,
                NAFeatureKeys.MORTOFRUCT
            )
        );

        addVegetation(
            BiomeSelectors.includeByKey(Biomes.NETHER_WASTES),
            List.of(
                NAFeatureKeys.NETHER_ROOTS
            )
        );
    }

    private static void addVegetation(Predicate<BiomeSelectionContext> biome, Collection<ResourceKey<PlacedFeature>> features)
    {
        addAll(biome, GenerationStep.Decoration.VEGETAL_DECORATION, features);
    }

    private static void addAll(Predicate<BiomeSelectionContext> biome, GenerationStep.Decoration step, Collection<ResourceKey<PlacedFeature>> features)
    {
        for (var feature : features)
        {
            BiomeModifications.addFeature(biome, step, feature);
        }
    }
}
