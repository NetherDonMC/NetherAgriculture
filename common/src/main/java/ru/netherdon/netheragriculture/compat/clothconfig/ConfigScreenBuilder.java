package ru.netherdon.netheragriculture.compat.clothconfig;

import com.google.common.collect.Lists;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
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

    @SuppressWarnings("rawtypes")
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

        NACommonConfig.LootModifierSettings modifier = overrides.lootModifier();
        List<AbstractConfigListEntry> subEntries = Lists.newArrayList();
        subEntries.add(ConfigScreenHelper.booleanToggle(modifier.piglinBarteringEnabled(), entryBuilder, permission).build());

        if (modifier.fabric() != null)
        {
            NACommonConfig.FabricLootModifierSettings fabricModifiers = modifier.fabric();
            subEntries.add(ConfigScreenHelper.booleanToggle(fabricModifiers.hoglinEnabled(), entryBuilder, permission).build());
            subEntries.add(ConfigScreenHelper.booleanToggle(fabricModifiers.striderEnabled(), entryBuilder, permission).build());
            subEntries.add(ConfigScreenHelper.booleanToggle(fabricModifiers.netherBridgeEnabled(), entryBuilder, permission).build());
            subEntries.add(ConfigScreenHelper.booleanToggle(fabricModifiers.bastionHoglinStableEnabled(), entryBuilder, permission).build());
        }

        category.addEntry(
            entryBuilder.startSubCategory(text("config", "overrides", "loot"), subEntries).build()
        );
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
