package ru.netherdon.netheragriculture.config.settings.server;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record EntitySettings(
    ModConfigSpec.BooleanValue burningFromItemEnabled,
    ModConfigSpec.BooleanValue burningFromBlazeFlightEnabled
)
{
    public static final boolean DEFAULT_BURNING_FROM_ITEMS_ENABLED = true;
    public static final boolean DEFAULT_BURNING_FROM_BLAZE_FLIGHT_ENABLED = true;

    public boolean isBurningFromItemEnabled() { return this.burningFromItemEnabled.getAsBoolean(); }
    public boolean isBurningFromBlazeFlightEnabled() { return this.burningFromBlazeFlightEnabled.getAsBoolean(); }

    public static EntitySettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("Entity");
        translation.push("entity");
        var settings = new EntitySettings(
            builder.worldRestart()
                .translation(translation.build("burning_from_items"))
                .define("burningFromItemsEnabled", DEFAULT_BURNING_FROM_ITEMS_ENABLED),
            builder.worldRestart()
                .translation(translation.build("burning_from_blaze_flight"))
                .define("burningFromBlazeFlightEnabled", DEFAULT_BURNING_FROM_BLAZE_FLIGHT_ENABLED)
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
