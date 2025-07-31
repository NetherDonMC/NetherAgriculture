package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class NAItemKeys
{
    public static final ResourceKey<Item> GLASS_BOTTLE = minecraft("glass_bottle");

    private static ResourceKey<Item> minecraft(String name)
    {
        return key(ResourceLocation.withDefaultNamespace(name));
    }

    private static ResourceKey<Item> key(ResourceLocation name)
    {
        return ResourceKey.create(Registries.ITEM, name);
    }
}
