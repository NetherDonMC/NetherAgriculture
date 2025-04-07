package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.DeadVinesBlock;
import ru.netherdon.netheragriculture.blocks.MortofructBlock;
import ru.netherdon.netheragriculture.blocks.NetherFarmlandBlock;

public final class NABlocks
{
    public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(NetherAgriculture.ID);

    public static final DeferredBlock<NetherFarmlandBlock> CRIMSON_FARMLAND = REGISTER.registerBlock("crimson_farmland", NetherFarmlandBlock::new,
        BlockBehaviour.Properties.of()
            .strength(0.4F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.CRIMSON_NYLIUM)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.NYLIUM)
    );

    public static final DeferredBlock<NetherFarmlandBlock> WARPED_FARMLAND = REGISTER.registerBlock("warped_farmland", NetherFarmlandBlock::new,
        BlockBehaviour.Properties.of()
            .strength(0.4F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.WARPED_NYLIUM)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.NYLIUM)
    );

    public static final DeferredBlock<MortofructBlock> MORTOFRUCT = REGISTER.registerBlock("mortofruct", MortofructBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(1.5f)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<DeadVinesBlock> DEAD_VINES = REGISTER.registerBlock("dead_vines", DeadVinesBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_RED)
            .instabreak()
            .noCollission()
            .randomTicks()
            .sound(SoundType.TWISTING_VINES)
            .pushReaction(PushReaction.DESTROY)
    );
}
