package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class WoodTypeServiceImpl
{
    public static WoodType register(WoodType type)
    {
        return WoodType.register(type);
    }

    public static BlockSetType registerSetType(BlockSetType type)
    {
        return BlockSetType.register(type);
    }
}
