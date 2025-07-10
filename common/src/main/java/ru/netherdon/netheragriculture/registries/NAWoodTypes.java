package ru.netherdon.netheragriculture.registries;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class NAWoodTypes
{
    public static final BlockSetType GLOWING_BLOCK_SET = new BlockSetType(
        "glowing",
        true,
        true,
        true,
        BlockSetType.PressurePlateSensitivity.EVERYTHING,
        SoundType.NETHER_WOOD,
        SoundEvents.NETHER_WOOD_DOOR_CLOSE,
        SoundEvents.NETHER_WOOD_DOOR_OPEN,
        SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE,
        SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN,
        SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
        SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON,
        SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF,
        SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON
    );

    public static final WoodType GLOWING = new WoodType("glowing", GLOWING_BLOCK_SET);
}
