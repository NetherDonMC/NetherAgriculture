package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
}
