package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public final class NABlockProperties
{
    public static final Properties CRIMSON_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.CRIMSON_STEM)
        .sound(SoundType.NETHER_WOOD);

    public static final Properties WARPED_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.CRIMSON_STEM)
        .sound(SoundType.NETHER_WOOD);
}
