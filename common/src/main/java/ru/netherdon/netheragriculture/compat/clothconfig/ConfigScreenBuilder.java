package ru.netherdon.netheragriculture.compat.clothconfig;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import ru.netherdon.netheragriculture.config.NACommonConfig;
import ru.netherdon.netheragriculture.config.NAServerConfig;

import java.util.List;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.text;

@Environment(EnvType.CLIENT)
public class ConfigScreenBuilder
{
    private static final Component OVERRIDES_CATEGORY = text("config","overrides");
    private static final Component ENTITY_CATEGORY = text("config","entity");
    private static final Component TITLE = Component.literal("Nether Agriculture");

    public static Screen build(Screen lastScreen)
    {
        NAServerConfig server = NAServerConfig.get();
        NACommonConfig common = NACommonConfig.get();
        Minecraft minecraft = Minecraft.getInstance();

        ConfigBuilder builder = ConfigBuilder.create();
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.setParentScreen(lastScreen);
        builder.setTitle(TITLE);
        builder.alwaysShowTabs();

        ConfigPermission serverPermission = ConfigPermission.server(minecraft);
        buildEntityCategory(server.entity, builder, entryBuilder, serverPermission);
        buildOverridesCategory(common.overrides, builder, entryBuilder, ConfigPermission.ALL);

        return builder.build();
    }

    private static void buildOverridesCategory(
        NACommonConfig.OverrideSettings overrides,
        ConfigBuilder builder,
        ConfigEntryBuilder entryBuilder,
        ConfigPermission permission
    )
    {
        ConfigCategory category = builder.getOrCreateCategory(OVERRIDES_CATEGORY);

        category.addEntry(
            ConfigScreenHelper.booleanToggle(overrides.removingRecipeEnabled(), entryBuilder, permission).build()
        );

        if (overrides.lootModifier() != null)
        {
            NACommonConfig.LootModifierSettings modifier = overrides.lootModifier();

            category.addEntry(
                entryBuilder.startSubCategory(
                    text("config", "overrides", "loot"),
                    List.of(
                        ConfigScreenHelper.booleanToggle(modifier.hoglinEnabled(), entryBuilder, permission).build(),
                        ConfigScreenHelper.booleanToggle(modifier.striderEnabled(), entryBuilder, permission).build(),
                        ConfigScreenHelper.booleanToggle(modifier.netherBridgeEnabled(), entryBuilder, permission).build(),
                        ConfigScreenHelper.booleanToggle(modifier.bastionHoglinStableEnabled(), entryBuilder, permission).build()
                    )
                ).build()
            );
        }
    }

    private static void buildEntityCategory(
        NAServerConfig.EntitySettings worldSettings,
        ConfigBuilder builder,
        ConfigEntryBuilder entryBuilder,
        ConfigPermission permission
    )
    {
        ConfigCategory category = builder.getOrCreateCategory(ENTITY_CATEGORY);

        category.addEntry(
            ConfigScreenHelper.booleanToggle(worldSettings.burningFromItemEnabled(), entryBuilder, permission).build()
        );

        category.addEntry(
            ConfigScreenHelper.booleanToggle(worldSettings.burningFromBlazeFlightEnabled(), entryBuilder, permission).build()
        );
    }
}
