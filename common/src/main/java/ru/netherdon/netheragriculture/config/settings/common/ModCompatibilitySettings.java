package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record ModCompatibilitySettings(
    FarmersDelightSettings farmersDelight,
    NethersDelightSettings nethersDelight
)
{
    public static ModCompatibilitySettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("ModCompatibility");
        translation.push("mod_compatibility");
        var settings = new ModCompatibilitySettings(
            FarmersDelightSettings.create(builder, translation),
            NethersDelightSettings.create(builder, translation)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
