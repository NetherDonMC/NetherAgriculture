package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public final class NABlockProperties
{
    public static final Properties CRIMSON_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.CRIMSON_STEM)
        .sound(SoundType.NETHER_WOOD);

    public static final Properties GLOWING_CRIMSON_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.CRIMSON_STEM)
        .sound(SoundType.NETHER_WOOD)
        .lightLevel((state) -> 12);

    public static final Properties WARPED_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.WARPED_STEM)
        .sound(SoundType.NETHER_WOOD);

    public static final Properties GLOWING_WARPED_CRATE = Properties.of()
        .strength(1.5f, 3f)
        .instrument(NoteBlockInstrument.BASS)
        .mapColor(MapColor.WARPED_STEM)
        .sound(SoundType.NETHER_WOOD)
        .lightLevel((state) -> 12);;

    public static final Properties AZURE_MELON = BlockBehaviour.Properties.of()
        .mapColor(MapColor.COLOR_CYAN)
        .strength(0.5f)
        .sound(SoundType.ROOTS)
        .pushReaction(PushReaction.DESTROY);

    public static final Properties WILD_AZURE_MELON = BlockBehaviour.Properties.of()
        .mapColor(MapColor.COLOR_CYAN)
        .strength(0.5f)
        .sound(SoundType.ROOTS)
        .pushReaction(PushReaction.DESTROY)
        .offsetType(BlockBehaviour.OffsetType.XZ)
        .dynamicShape();

    public static final Properties AZURE_MELON_STEM = BlockBehaviour.Properties.of()
        .mapColor(MapColor.COLOR_CYAN)
        .noCollission()
        .instabreak()
        .sound(SoundType.ROOTS)
        .pushReaction(PushReaction.DESTROY);
}
