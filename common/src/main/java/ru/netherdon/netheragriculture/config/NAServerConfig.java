package ru.netherdon.netheragriculture.config;

import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import ru.netherdon.netheragriculture.NetherAgriculture;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.key;

public final class NAServerConfig
{
    public static final String FILE_NAME = NetherAgriculture.ID + "/server.toml";
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final Pair<NAServerConfig, ModConfigSpec> PAIR = BUILDER.configure(NAServerConfig::new);

    private static final String CONFIG = "config";
    private static final String ENTITY = "entity";

    public final EntitySettings entity;

    private NAServerConfig(ModConfigSpec.Builder builder)
    {
        this.entity = new EntitySettings(
            builder.push("Entity")
                .worldRestart()
                .translation(key(CONFIG, ENTITY, "burning_from_items"))
                .define("burningFromItemsEnabled", ConfigConstants.IS_BURNING_FROM_ITEMS_ENABLED),
            builder
                .worldRestart()
                .translation(key(CONFIG, ENTITY, "burning_from_blaze_flight"))
                .define("burningFromBlazeFlightEnabled", ConfigConstants.IS_BURNING_FROM_BLAZE_FLIGHT_ENABLED)
        );
        builder.pop();
    }

    public static NAServerConfig get()
    {
        return PAIR.getLeft();
    }

    public static IConfigSpec getSpec()
    {
        return PAIR.getRight();
    }

    public record EntitySettings(
        ModConfigSpec.BooleanValue burningFromItemEnabled,
        ModConfigSpec.BooleanValue burningFromBlazeFlightEnabled
    )
    {
        public boolean isBurningFromItemEnabled() { return this.burningFromItemEnabled.getAsBoolean(); }
        public boolean isBurningFromBlazeFlightEnabled() { return this.burningFromBlazeFlightEnabled.getAsBoolean(); }
    }
}
