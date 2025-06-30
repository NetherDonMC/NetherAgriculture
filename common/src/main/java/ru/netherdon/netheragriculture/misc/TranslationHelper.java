package ru.netherdon.netheragriculture.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import ru.netherdon.netheragriculture.NetherAgriculture;

import java.util.Collection;

public final class TranslationHelper
{
    public static String key(String namespace, String... path)
    {
        return "%s.%s.%s".formatted(namespace, NetherAgriculture.ID, String.join(".", path));
    }

    public static String key(String namespace, Collection<String> path)
    {
        return key(namespace, path.toArray(new String[0]));
    }

    public static MutableComponent text(String namespace, String... path)
    {
        return Component.translatable(key(namespace, path));
    }
}
