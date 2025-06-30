package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record FarmersDelightSettings(
    ModConfigSpec.BooleanValue fullRecipeIntegrationEnabled
)
{
    public static final boolean DEFAULT_FULL_RECIPE_INTEGRATION_ENABLED = true;

    public boolean isFullRecipeIntegrationEnabled()
    {
        return this.fullRecipeIntegrationEnabled.getAsBoolean();
    }

    public static FarmersDelightSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("FarmersDelight");
        translation.push("farmers_delight");
        var settings = new FarmersDelightSettings(
            builder.translation(translation.build("full_recipe_integration"))
                .define("fullRecipeIntegrationEnabled", DEFAULT_FULL_RECIPE_INTEGRATION_ENABLED)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
