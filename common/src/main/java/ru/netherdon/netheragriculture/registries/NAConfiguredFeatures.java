package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.config.NACommonConfig;
import ru.netherdon.netheragriculture.config.settings.common.ConfiguredFeatureSettings;

public final class NAConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_FUNGUS = key("glowing_fungus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROOTS_BONEMEAL = key("nether_roots_bonemeal");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, NetherAgriculture.location(name));
    }

    public static void modify(ResourceLocation name, ConfiguredFeature<?, ?> feature)
    {
        if (name.equals(NetherFeatures.CRIMSON_FOREST_VEGETATION_BONEMEAL.location()))
        {
            if (config().isCrimsonNyliumBonemealEnabled())
            {
                addGlowingFungus(feature, 4);
            }
        }
        else if (name.equals(NetherFeatures.WARPED_FOREST_VEGETATION_BONEMEAL.location()))
        {
            if (config().isWarpedNyliumBonemealEnabled())
            {
                addGlowingFungus(feature, 4);
            }
        }
        else if (name.equals(NetherFeatures.CRIMSON_FOREST_VEGETATION.location()))
        {
            if (config().isCrimsonForestVegetationEnabled())
            {
                addGlowingFungus(feature, 2);
            }
        }
        else if (name.equals(NetherFeatures.WARPED_FOREST_VEGETION.location()))
        {
            if (config().isWarpedForestVegetationEnabled())
            {
                addGlowingFungus(feature, 2);
            }
        }
    }

    private static void addGlowingFungus(ConfiguredFeature<?, ?> feature, int weight)
    {
        if (
            feature.config() instanceof NetherForestVegetationConfig config
            && config.stateProvider instanceof WeightedStateProvider provider
        )
        {
            SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
            for (WeightedEntry.Wrapper<BlockState> wrapper : provider.weightedList.unwrap())
            {
                builder.add(wrapper.data(), wrapper.weight().asInt());
            }
            builder.add(NABlocks.GLOWING_FUNGUS.value().defaultBlockState(), weight);
            provider.weightedList = builder.build();
        }
    }

    private static ConfiguredFeatureSettings config()
    {
        return NACommonConfig.get().overrides.configuredFeature();
    }
}
