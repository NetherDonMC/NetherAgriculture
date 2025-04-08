package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
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

    public static final DeferredBlock<Block> CRIMSON_CRATE = REGISTER.registerSimpleBlock("crimson_crate", NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE = REGISTER.registerBlock("small_crimson_crate", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE = REGISTER.registerSimpleBlock("warped_crate", NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE = REGISTER.registerBlock("small_warped_crate", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final DeferredBlock<Block> CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlock("crimson_crate_of_crimson_berries", NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerBlock("small_crimson_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlock("warped_crate_of_crimson_berries", NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerBlock("small_warped_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.WARPED_CRATE);
}
