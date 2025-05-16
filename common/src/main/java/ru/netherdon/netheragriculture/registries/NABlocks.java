package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import ru.netherdon.netheragriculture.blocks.*;
import ru.netherdon.netheragriculture.services.RegistryManager;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public final class NABlocks
{
    public static final IRegistryProvider<Block> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.BLOCK);

    public static final Holder<NetherFarmlandBlock> CRIMSON_FARMLAND = registerBlock("crimson_farmland", NetherFarmlandBlock::new,
        BlockBehaviour.Properties.of()
            .strength(0.4F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.CRIMSON_NYLIUM)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.NYLIUM)
    );

    public static final Holder<NetherFarmlandBlock> WARPED_FARMLAND = registerBlock("warped_farmland", NetherFarmlandBlock::new,
        BlockBehaviour.Properties.of()
            .strength(0.4F)
            .requiresCorrectToolForDrops()
            .mapColor(MapColor.WARPED_NYLIUM)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.NYLIUM)
    );

    public static final Holder<BlackFurnaceBlock> BLACK_FURNACE = registerBlock("black_furnace", BlackFurnaceBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(3.5F)
            .lightLevel(lit(13))
    );

    public static final Holder<MortofructBlock> MORTOFRUCT = registerBlock("mortofruct", MortofructBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .strength(1.5f)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<DeadVinesBlock> DEAD_VINES = registerBlock("dead_vines", DeadVinesBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_RED)
            .instabreak()
            .noCollission()
            .randomTicks()
            .sound(SoundType.TWISTING_VINES)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherCropBlock> CRIMSON_BERRY_ROOTS = registerBlock("crimson_berry_roots", CrimsonBerryRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherBerrySproutsBlock> CRIMSON_BERRY_SPROUTS = registerBlock("crimson_berry_sprouts", NetherBerrySproutsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherCropBlock> WARPED_BERRY_ROOTS = registerBlock("warped_berry_roots", WarpedBerryRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherBerrySproutsBlock> WARPED_BERRY_SPROUTS = registerBlock("warped_berry_sprouts", NetherBerrySproutsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherCropBlock> LOTHUNS = registerBlock("lothuns", LothunBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<WildLothunBlock> WILD_LOTHUN = registerBlock("wild_lothun", WildLothunBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherCropBlock> BLAZE_FRUIT = registerBlock("blaze_fruit", BlazeFruitBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_CYAN)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> ((NetherCropBlock)state.getBlock()).isMaxAge(state) ? 10 : 0)
    );

    public static final Holder<SinfulEyesBlock> SINFUL_EYES = registerBlock("sinful_eyes", SinfulEyesBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.GOLD)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<WildSinfulEyesBlock> WILD_SINFUL_EYES = registerBlock("wild_sinful_eyes", WildSinfulEyesBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.GOLD)
            .noCollission()
            .instabreak()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<NetherRootsBlock> NETHER_ROOTS = registerBlock("nether_roots", NetherRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .instabreak()
            .noCollission()
            .replaceable()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<TallRootsBlock> TALL_CRIMSON_ROOTS = registerBlock("tall_crimson_roots", TallRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .instabreak()
            .noCollission()
            .replaceable()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<TallRootsBlock> TALL_WARPED_ROOTS = registerBlock("tall_warped_roots", TallRootsBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.NETHER)
            .instabreak()
            .noCollission()
            .replaceable()
            .sound(SoundType.ROOTS)
            .offsetType(BlockBehaviour.OffsetType.XZ)
            .pushReaction(PushReaction.DESTROY)
    );

    public static final Holder<AzureMelonBlock> AZURE_MELON = registerBlock("azure_melon", AzureMelonBlock::new, NABlockProperties.AZURE_MELON);
    public static final Holder<AzureMelonCropBlock> AZURE_MELON_CROP = registerBlock("azure_melon_crop", AzureMelonCropBlock::new, NABlockProperties.AZURE_MELON);
    public static final Holder<AzureMelonStemBlock> AZURE_MELON_STEM = registerBlock("azure_melon_stem", AzureMelonStemBlock::new, NABlockProperties.AZURE_MELON_STEM);
    public static final Holder<AttachedAzureMelonStemBlock> ATTACHED_AZURE_MELON_STEM = registerBlock("attached_azure_melon_stem", AttachedAzureMelonStemBlock::new, NABlockProperties.AZURE_MELON_STEM);

    public static final Holder<Block> CRIMSON_CRATE = registerBlock("crimson_crate", CrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE = registerBlock("small_crimson_crate", SmallCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE = registerBlock("warped_crate", CrateBlock::new, NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE = registerBlock("small_warped_crate", SmallCrateBlock::new, NABlockProperties.WARPED_CRATE);

    public static final Holder<Block> CRIMSON_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlock("crimson_crate_of_crimson_berries", NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES = registerBlock("small_crimson_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlock("warped_crate_of_crimson_berries", NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES = registerBlock("small_warped_crate_of_crimson_berries", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final Holder<Block> CRIMSON_CRATE_OF_WARPED_BERRIES = registerSimpleBlock("crimson_crate_of_warped_berries", NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES = registerBlock("small_crimson_crate_of_warped_berries", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE_OF_WARPED_BERRIES = registerSimpleBlock("warped_crate_of_warped_berries", NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE_OF_WARPED_BERRIES = registerBlock("small_warped_crate_of_warped_berries", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final Holder<Block> CRIMSON_CRATE_OF_LOTHUN = registerSimpleBlock("crimson_crate_of_lothun", NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE_OF_LOTHUN = registerBlock("small_crimson_crate_of_lothun", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE_OF_LOTHUN = registerSimpleBlock("warped_crate_of_lothun", NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE_OF_LOTHUN = registerBlock("small_warped_crate_of_lothun", SlabBlock::new, NABlockProperties.WARPED_CRATE);

    public static final Holder<Block> CRIMSON_CRATE_OF_BLAZE_FRUIT = registerBlock("crimson_crate_of_blaze_fruit", BlazeFruitCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT = registerBlock("small_crimson_crate_of_blaze_fruit", SmallBlazeFruitCrateBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE_OF_BLAZE_FRUIT = registerBlock("warped_crate_of_blaze_fruit", BlazeFruitCrateBlock::new, NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE_OF_BLAZE_FRUIT = registerBlock("small_warped_crate_of_blaze_fruit", SmallBlazeFruitCrateBlock::new, NABlockProperties.WARPED_CRATE);

    public static final Holder<Block> CRIMSON_CRATE_OF_SINFUL_EYES = registerSimpleBlock("crimson_crate_of_sinful_eyes", NABlockProperties.CRIMSON_CRATE);
    public static final Holder<SlabBlock> SMALL_CRIMSON_CRATE_OF_SINFUL_EYES = registerBlock("small_crimson_crate_of_sinful_eyes", SlabBlock::new, NABlockProperties.CRIMSON_CRATE);
    public static final Holder<Block> WARPED_CRATE_OF_SINFUL_EYES = registerSimpleBlock("warped_crate_of_sinful_eyes", NABlockProperties.WARPED_CRATE);
    public static final Holder<SlabBlock> SMALL_WARPED_CRATE_OF_SINFUL_EYES = registerBlock("small_warped_crate_of_sinful_eyes", SlabBlock::new, NABlockProperties.WARPED_CRATE);



    private static ToIntFunction<BlockState> lit(int lightLevel)
    {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
    }

    private static Holder<Block> registerSimpleBlock(String name, BlockBehaviour.Properties properties)
    {
        return registerBlock(name, Block::new, properties);
    }

    private static <T extends Block> Holder<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> constructor, BlockBehaviour.Properties properties)
    {
        return REGISTER.register(name, () -> constructor.apply(properties));
    }

    public static void initialize() {}
}
