package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class NAWoodTypes
{
    public static final BlockSetType GLOWING_BLOCK_SET = new BlockSetType("glowing");
    public static final WoodType GLOWING = new WoodType("glowing", GLOWING_BLOCK_SET);
}
