package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record NethersDelightSettings(
    ModConfigSpec.BooleanValue useOnlyBlackFurnace
)
{
    public static final boolean DEFAULT_REMOVING_RECIPE_ENABLED = true;

    public boolean isOnlyBlackFurnaceUsed() { return this.useOnlyBlackFurnace.getAsBoolean(); }

    public static NethersDelightSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("NethersDelight");
        translation.push("nethers_delight");
        var settings = new NethersDelightSettings(
            builder.translation(translation.build("use_only_black_furnace"))
                .define("useOnlyBlackFurnace", DEFAULT_REMOVING_RECIPE_ENABLED)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
