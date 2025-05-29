package ru.netherdon.netheragriculture.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import ru.netherdon.netheragriculture.NetherAgriculture;

public final class TranslationHelper
{
    public static String key(String namespace, String... path)
    {
        return "%s.%s.%s".formatted(namespace, NetherAgriculture.ID, String.join(".", path));
    }

    public static MutableComponent text(String namespace, String... path)
    {
        return Component.translatable(key(namespace, path));
    }
}
