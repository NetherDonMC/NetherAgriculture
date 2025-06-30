package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

public record FabricLootModifierSettings(
    ModConfigSpec.BooleanValue striderEnabled,
    ModConfigSpec.BooleanValue hoglinEnabled,
    ModConfigSpec.BooleanValue bastionHoglinStableEnabled,
    ModConfigSpec.BooleanValue netherBridgeEnabled
)
{
    public static final boolean DEFAULT_LOOT_MODIFIER_STRIDER_LEG_ENABLED = true;
    public static final boolean DEFAULT_LOOT_MODIFIER_HOGLIN_MEAT_ENABLED = true;
    public static final boolean DEFAULT_LOOT_MODIFIER_NETHER_BRIDGE_ENABLED = true;
    public static final boolean DEFAULT_LOOT_MODIFIER_BASTION_HOGLIN_STABLE_ENABLED = true;

    public boolean isStriderEnabled() { return this.striderEnabled.getAsBoolean(); }
    public boolean isHoglinEnabled() { return this.hoglinEnabled.getAsBoolean(); }
    public boolean isBastionHoglinStableEnabled() { return this.bastionHoglinStableEnabled.getAsBoolean(); }
    public boolean isNetherBridgeEnabled() { return this.netherBridgeEnabled.getAsBoolean(); }

    public static FabricLootModifierSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        return new FabricLootModifierSettings(
            builder.translation(translation.build("strider"))
                .define("striderEnabled", DEFAULT_LOOT_MODIFIER_STRIDER_LEG_ENABLED),

            builder.translation(translation.build("hoglin"))
                .define("hoglinEnabled", DEFAULT_LOOT_MODIFIER_HOGLIN_MEAT_ENABLED),

            builder.translation(translation.build("nether_bridge"))
                .define("netherBridgeEnabled", DEFAULT_LOOT_MODIFIER_NETHER_BRIDGE_ENABLED),

            builder.translation(translation.build("bastion_hoglin_stable"))
                .define("bastionHoglinStableEnabled", DEFAULT_LOOT_MODIFIER_BASTION_HOGLIN_STABLE_ENABLED)
        );
    }
}
