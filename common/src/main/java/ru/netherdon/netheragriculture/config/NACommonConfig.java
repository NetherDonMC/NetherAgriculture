package ru.netherdon.netheragriculture.config;

import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.config.settings.common.FabricLootModifierSettings;
import ru.netherdon.netheragriculture.config.settings.common.LootModifierSettings;
import ru.netherdon.netheragriculture.config.settings.common.ModCompatibilitySettings;
import ru.netherdon.netheragriculture.config.settings.common.OverrideSettings;
import ru.netherdon.netheragriculture.misc.ModLoaderTypes;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;
import ru.netherdon.netheragriculture.services.ModLoaderService;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.key;
import static net.neoforged.neoforge.common.ModConfigSpec.*;

public final class NACommonConfig
{
    public static final String FILE_NAME = NetherAgriculture.ID + "/common.toml";
    private static final Builder BUILDER = new Builder();
    private static final Pair<NACommonConfig, ModConfigSpec> PAIR = BUILDER.configure(NACommonConfig::new);

    public final OverrideSettings overrides;
    public final ModCompatibilitySettings modCompatibility;

    private NACommonConfig(Builder builder)
    {
        TranslationBuilder translation = new TranslationBuilder("config.common");
        this.overrides = OverrideSettings.create(builder, translation);
        this.modCompatibility = ModCompatibilitySettings.create(builder, translation);
    }

    public static NACommonConfig get()
    {
        return PAIR.getLeft();
    }

    public static IConfigSpec getSpec()
    {
        return PAIR.getRight();
    }
}
