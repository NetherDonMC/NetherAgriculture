package ru.netherdon.netheragriculture.config;

import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;
import ru.netherdon.netheragriculture.services.ModLoaderService;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.key;

public final class NACommonConfig
{
    public static final String FILE_NAME = NetherAgriculture.ID + "/common.toml";
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final Pair<NACommonConfig, ModConfigSpec> PAIR = BUILDER.configure(NACommonConfig::new);

    private static final String CONFIG = "config";
    private static final String OVERRIDES = "overrides";
    private static final String LOOT = "loot";

    public final OverrideSettings overrides;

    private NACommonConfig(ModConfigSpec.Builder builder)
    {
        this.overrides = new OverrideSettings(
            builder.push("Overrides")
                .worldRestart()
                .translation(key(CONFIG, OVERRIDES, "removing_recipes"))
                .define("removingRecipesEnabled", ConfigConstants.IS_REMOVING_RECIPES_ENABLED),

            loadLoot(builder)
        );
        builder.pop();
    }

    @Nullable
    private static LootModifierSettings loadLoot(ModConfigSpec.Builder builder)
    {
        if (ModLoaderService.getModLoaderType() != ModLoaderTypes.FABRIC)
        {
            return null;
        }

        var result = new LootModifierSettings(
            builder.push("Loot Modifiers")
                .worldRestart()
                .translation(key(CONFIG, OVERRIDES, LOOT, "strider"))
                .define("striderEnabled", ConfigConstants.IS_LOOT_MODIFIER_STRIDER_LEG_ENABLED),

            builder
                .worldRestart()
                .translation(key(CONFIG, OVERRIDES, LOOT, "hoglin"))
                .define("hoglinEnabled", ConfigConstants.IS_LOOT_MODIFIER_HOGLIN_MEAT_ENABLED),

            builder
                .worldRestart()
                .translation(key(CONFIG, OVERRIDES, LOOT, "nether_bridge"))
                .define("netherBridgeEnabled", ConfigConstants.IS_LOOT_MODIFIER_NETHER_BRIDGE_ENABLED),

            builder
                .worldRestart()
                .translation(key(CONFIG, OVERRIDES, LOOT, "bastion_hoglin_stable"))
                .define("bastionHoglinStableEnabled", ConfigConstants.IS_LOOT_MODIFIER_BASTION_HOGLIN_STABLE_ENABLED)
        );
        builder.pop();
        return result;
    }

    public static NACommonConfig get()
    {
        return PAIR.getLeft();
    }

    public static IConfigSpec getSpec()
    {
        return PAIR.getRight();
    }

    public record OverrideSettings(
        ModConfigSpec.BooleanValue removingRecipeEnabled,
        @Nullable LootModifierSettings lootModifier
    )
    {
        public boolean isRemovingRecipeEnabled() { return this.removingRecipeEnabled.getAsBoolean(); }
    }

    public record LootModifierSettings(
        ModConfigSpec.BooleanValue striderEnabled,
        ModConfigSpec.BooleanValue hoglinEnabled,
        ModConfigSpec.BooleanValue bastionHoglinStableEnabled,
        ModConfigSpec.BooleanValue netherBridgeEnabled
    )
    {
        public boolean isStriderEnabled() { return this.striderEnabled.getAsBoolean(); }
        public boolean isHoglinEnabled() { return this.hoglinEnabled.getAsBoolean(); }
        public boolean isBastionHoglinStableEnabled() { return this.bastionHoglinStableEnabled.getAsBoolean(); }
        public boolean isNetherBridgeEnabled() { return this.netherBridgeEnabled.getAsBoolean(); }
    }
}
