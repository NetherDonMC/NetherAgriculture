package ru.netherdon.netheragriculture.compat.clothconfig;

import com.google.common.collect.Lists;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.AbstractFieldBuilder;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import me.shedaniel.clothconfig2.impl.builders.IntFieldBuilder;
import me.shedaniel.clothconfig2.impl.builders.IntSliderBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Optional;

import static ru.netherdon.netheragriculture.misc.TranslationHelper.*;
import static ru.netherdon.netheragriculture.misc.TranslationHelper.text;

public final class ConfigScreenHelper
{
    private static final Component INWORLD_CATEGORY_DESCRIPTION = text("config","inworld_category_description").withStyle(ChatFormatting.RED);
    private static final Component ONLINE_MODE_CATEGORY_DESCRIPTION = text("config","online_mode_category_description").withStyle(ChatFormatting.RED);
    private static final Component CHANGE_ALERT = text("config", "server_properties_change_alert").withStyle(ChatFormatting.YELLOW);

    public static BooleanToggleBuilder booleanToggle(ModConfigSpec.BooleanValue configValue, ConfigEntryBuilder builder, ConfigPermission permission)
    {
        return init(
            builder.startBooleanToggle(name(configValue), value(configValue, permission)),
            configValue, permission
        );
    }

    public static IntFieldBuilder intField(ModConfigSpec.ConfigValue<Integer> configValue, ConfigEntryBuilder builder, ConfigPermission permission)
    {
        var result = init(
            builder.startIntField(name(configValue), value(configValue, permission)),
            configValue, permission
        );

        ModConfigSpec.Range<Integer> range = configValue.getSpec().getRange();
        if (range != null)
        {
            result.setMin(range.getMin());
            result.setMax(range.getMax());
        }

        return result;
    }

    public static IntSliderBuilder percentageSlider(ModConfigSpec.ConfigValue<Integer> configValue, ConfigEntryBuilder builder, ConfigPermission permission)
    {
        ModConfigSpec.Range<Integer> range = configValue.getSpec().getRange();
        return init(
            builder.startIntSlider(name(configValue), value(configValue, permission), range.getMin(), range.getMax()),
            configValue, permission
        ).setTextGetter((value) -> Component.literal(value + "%"));
    }

    public static <V, T extends AbstractFieldBuilder<V, ?, ?>> T init(T t, ModConfigSpec.ConfigValue<V> configValue, ConfigPermission permission)
    {
        t.setDefaultValue(configValue.getDefault());
        t.setSaveConsumer(permission.levelLoaded() ? (value) ->
        {
            configValue.set(value);
            configValue.save();
        } : null);
        t.setRequirement(permission::entryAvailable);
        t.setTooltip(tooltip(configValue, permission));
        t.requireRestart(configValue.getSpec().restartType() == ModConfigSpec.RestartType.GAME);
        return t;
    }

    public static <T> T value(ModConfigSpec.ConfigValue<T> configValue, ConfigPermission permission)
    {
        return permission.levelLoaded() ? configValue.getRaw() : configValue.getDefault();
    }

    public static Component name(ModConfigSpec.ConfigValue<?> value)
    {
        String key = value.getSpec().getTranslationKey();
        if (key == null)
        {
            key = String.join(".", value.getPath());
        }
        return Component.translatable(key);
    }

    public static Optional<Component[]> tooltip(ModConfigSpec.ConfigValue<?> value, ConfigPermission permission)
    {
        List<Component> list = Lists.newArrayList();
        String key = value.getSpec().getTranslationKey();
        if (key == null)
        {
            return Optional.empty();
        }

        Component text = Component.translatableWithFallback(key + ".tooltip", "");
        if (!text.getString().isEmpty())
        {
            list.add(text);
        }

        if (!permission.levelLoaded())
        {
            list.add(INWORLD_CATEGORY_DESCRIPTION);
        }
        else if (!permission.isSingleplayer())
        {
            list.add(ONLINE_MODE_CATEGORY_DESCRIPTION);
        }

        if (list.isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(list.toArray(new Component[0]));
    }
}
