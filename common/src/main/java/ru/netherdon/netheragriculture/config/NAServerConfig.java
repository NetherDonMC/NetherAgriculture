package ru.netherdon.netheragriculture.config;

import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.config.settings.server.EntitySettings;
import ru.netherdon.netheragriculture.misc.TranslationBuilder;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.key;

public final class NAServerConfig
{
    public static final String FILE_NAME = NetherAgriculture.ID + "/server.toml";
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final Pair<NAServerConfig, ModConfigSpec> PAIR = BUILDER.configure(NAServerConfig::new);

    public final EntitySettings entity;

    private NAServerConfig(ModConfigSpec.Builder builder)
    {
        TranslationBuilder translation = new TranslationBuilder("config.server");
        this.entity = EntitySettings.create(builder, translation);
    }

    public static NAServerConfig get()
    {
        return PAIR.getLeft();
    }

    public static IConfigSpec getSpec()
    {
        return PAIR.getRight();
    }
}
