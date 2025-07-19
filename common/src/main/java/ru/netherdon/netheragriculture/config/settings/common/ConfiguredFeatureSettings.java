package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record ConfiguredFeatureSettings(
    ModConfigSpec.BooleanValue crimsonForestVegetationEnabled,
    ModConfigSpec.BooleanValue crimsonNyliumBonemealEnabled,
    ModConfigSpec.BooleanValue warpedForestVegetationEnabled,
    ModConfigSpec.BooleanValue warpedNyliumBonemealEnabled
)
{
    public boolean isCrimsonForestVegetationEnabled()
    {
        return this.crimsonForestVegetationEnabled.getAsBoolean();
    }

    public boolean isCrimsonNyliumBonemealEnabled()
    {
        return this.crimsonNyliumBonemealEnabled.getAsBoolean();
    }

    public boolean isWarpedForestVegetationEnabled()
    {
        return this.warpedForestVegetationEnabled.getAsBoolean();
    }

    public boolean isWarpedNyliumBonemealEnabled()
    {
        return this.warpedNyliumBonemealEnabled.getAsBoolean();
    }

    public static ConfiguredFeatureSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("ConfiguredFeatureModifiers");
        translation.push("configured_feature");
        var settings = new ConfiguredFeatureSettings(
            builder.worldRestart()
                .translation(translation.build("crimson_forest_vegetation"))
                .define("crimsonForestVegetationEnabled", true),
            builder.worldRestart()
                .translation(translation.build("crimson_nylium_bonemeal"))
                .define("crimsonNyliumBonemealEnabled", true),
            builder.worldRestart()
                .translation(translation.build("warped_forest_vegetation"))
                .define("warpedForestVegetationEnabled", true),
            builder.worldRestart()
                .translation(translation.build("warped_nylium_bonemeal"))
                .define("warpedNyliumBonemealEnabled", true)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
