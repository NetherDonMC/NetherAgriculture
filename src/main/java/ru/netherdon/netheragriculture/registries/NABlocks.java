package ru.netherdon.netheragriculture.registries;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.*;

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

    public static final DeferredBlock<BlackFurnaceBlock> BLACK_FURNACE = REGISTER.registerBlock("black_furnace", BlackFurnaceBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(3.5F)
            .lightLevel(Blocks.litBlockEmission(13))
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

    public static final DeferredBlock<NetherCropBlock> CRIMSON_BERRY_ROOTS = REGISTER.registerBlock("crimson_berry_roots", CrimsonBerryRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<RootsBlock> CRIMSON_BERRY_SPROUTS = REGISTER.registerBlock("crimson_berry_sprouts", NetherBerrySproutsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<NetherCropBlock> WARPED_BERRY_ROOTS = REGISTER.registerBlock("warped_berry_roots", WarpedBerryRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<RootsBlock> WARPED_BERRY_SPROUTS = REGISTER.registerBlock("warped_berry_sprouts", NetherBerrySproutsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<NetherCropBlock> LOTHUNS = REGISTER.registerBlock("lothuns", LothunBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<RootsBlock> WILD_LOTHUN = REGISTER.registerBlock("wild_lothun", WildLothunBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<NetherCropBlock> BLAZE_FRUIT = REGISTER.registerBlock("blaze_fruit", BlazeFruitBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<AzureMelonBlock> AZURE_MELON = REGISTER.registerBlock("azure_melon", AzureMelonBlock::new, NABlockProperties.AZURE_MELON);
    public static final DeferredBlock<AzureMelonCropBlock> AZURE_MELON_CROP = REGISTER.registerBlock("azure_melon_crop", AzureMelonCropBlock::new, NABlockProperties.AZURE_MELON);
    public static final DeferredBlock<AzureMelonStemBlock> AZURE_MELON_STEM = REGISTER.registerBlock("azure_melon_stem", AzureMelonStemBlock::new, NABlockProperties.AZURE_MELON_STEM);
    public static final DeferredBlock<AttachedAzureMelonStemBlock> ATTACHED_AZURE_MELON_STEM = REGISTER.registerBlock("attached_azure_melon_stem", AttachedAzureMelonStemBlock::new, NABlockProperties.AZURE_MELON_STEM);

    public static final DeferredBlock<Block> CRIMSON_CRATE = REGISTER.registerBlock("crimson_crate", CrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE = REGISTER.registerBlock("small_crimson_crate", SmallCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE = REGISTER.registerBlock("warped_crate", CrateBlock::new, NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE = REGISTER.registerBlock("small_warped_crate", SmallCrateBlock::new, NABlockProperties.WARPED_CRATE);

    public static final DeferredBlock<Block> CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlock("crimson_crate_of_crimson_berries", NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerBlock("small_crimson_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerSimpleBlock("warped_crate_of_crimson_berries", NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES = REGISTER.registerBlock("small_warped_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final DeferredBlock<Block> CRIMSON_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlock("crimson_crate_of_warped_berries", NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES = REGISTER.registerBlock("small_crimson_crate_of_warped_berries", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE_OF_WARPED_BERRIES = REGISTER.registerSimpleBlock("warped_crate_of_warped_berries", NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE_OF_WARPED_BERRIES = REGISTER.registerBlock("small_warped_crate_of_warped_berries", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final DeferredBlock<Block> CRIMSON_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlock("crimson_crate_of_lothun", NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE_OF_LOTHUN = REGISTER.registerBlock("small_crimson_crate_of_lothun", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE_OF_LOTHUN = REGISTER.registerSimpleBlock("warped_crate_of_lothun", NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE_OF_LOTHUN = REGISTER.registerBlock("small_warped_crate_of_lothun", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final DeferredBlock<Block> CRIMSON_CRATE_OF_BLAZE_FRUIT = REGISTER.registerBlock("crimson_crate_of_blaze_fruit", BlazeFruitCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT = REGISTER.registerBlock("small_crimson_crate_of_blaze_fruit", SmallBlazeFruitCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final DeferredBlock<Block> WARPED_CRATE_OF_BLAZE_FRUIT = REGISTER.registerBlock("warped_crate_of_blaze_fruit", BlazeFruitCrateBlock::new, NABlockProperties.WARPED_CRATE);
    public static final DeferredBlock<SlabBlock> SMALL_WARPED_CRATE_OF_BLAZE_FRUIT = REGISTER.registerBlock("small_warped_crate_of_blaze_fruit", SmallBlazeFruitCrateBlock::new, NABlockProperties.WARPED_CRATE);
}
