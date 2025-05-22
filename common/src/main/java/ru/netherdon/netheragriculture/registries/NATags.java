package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public final class NATags
{
    public static class Blocks
    {
        public static TagKey<Block> NETHERRACKS = c("netherracks");

        private static TagKey<Block> c(String id)
        {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", id));
        }
    }

    public static class Enchantments
    {
        public static TagKey<Enchantment> INCREASE_ENTITY_DROPS = c("increase_entity_drops");

        private static TagKey<Enchantment> c(String id)
        {
            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath("c", id));
        }
    }
}
