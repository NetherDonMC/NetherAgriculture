package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record OverrideSettings(
    LootModifierSettings lootModifier
)
{
    public static OverrideSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("Overrides");
        translation.push("overrides");
        var settings = new OverrideSettings(
            LootModifierSettings.create(builder, translation)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
