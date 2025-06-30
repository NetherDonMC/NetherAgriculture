package ru.netherdon.netheragriculture.config.settings.common;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;
import ru.netherdon.netheragriculture.services.ModLoaderService;

public record LootModifierSettings(
    ModConfigSpec.BooleanValue piglinBarteringEnabled,
    @Nullable FabricLootModifierSettings fabric
)
{
    public static final boolean DEFAULT_LOOT_MODIFIER_PIGLIN_BARTERING_ENABLED = true;

    public boolean isPiglinBarteringEnabled() { return this.piglinBarteringEnabled.getAsBoolean(); }

    public static LootModifierSettings create(ModConfigSpec.Builder builder, TranslationBuilder translation)
    {
        builder.push("LootModifiers");
        translation.push("loot");
        var settings = new LootModifierSettings(
            builder.translation(translation.build("piglin_bartering"))
                .define("piglinBarteringEnabled", DEFAULT_LOOT_MODIFIER_PIGLIN_BARTERING_ENABLED),

            ModLoaderService.getModLoaderType() == ModLoaderTypes.FABRIC
                ? FabricLootModifierSettings.create(builder, translation)
                : null
        );
        translation.pop();
        builder.pop();
        return settings;
    }
}
