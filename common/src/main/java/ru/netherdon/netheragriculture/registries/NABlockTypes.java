package ru.netherdon.netheragriculture.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import ru.netherdon.netheragriculture.blocks.*;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NABlockTypes
{
    public static final IRegistryProvider<MapCodec<? extends Block>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.BLOCK_TYPE);

    public static final Holder<MapCodec<AttachedAzureMelonStemBlock>> ATTACHED_AZURE_MELON_STEM =
        REGISTER.register("attached_azure_melon_stem", () -> AttachedAzureMelonStemBlock.CODEC);

    public static final Holder<MapCodec<AzureMelonStemBlock>> AZURE_MELON_STEM =
        REGISTER.register("azure_melon_stem", () -> AzureMelonStemBlock.CODEC);

    public static final Holder<MapCodec<AzureMelonBlock>> AZURE_MELON =
        REGISTER.register("azure_melon", () -> AzureMelonBlock.CODEC);

    public static final Holder<MapCodec<AzureMelonCropBlock>> AZURE_MELON_CROP =
        REGISTER.register("azure_melon_crop", () -> AzureMelonCropBlock.CODEC);

    public static final Holder<MapCodec<WildAzureMelonBlock>> WILD_AZURE_MELON =
        REGISTER.register("wild_azure_melon", () -> WildAzureMelonBlock.CODEC);

    public static final Holder<MapCodec<BlackFurnaceBlock>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> BlackFurnaceBlock.CODEC);

    public static final Holder<MapCodec<BlazeFruitBlock>> BLAZE_FRUIT =
        REGISTER.register("blaze_fruit", () -> BlazeFruitBlock.CODEC);

    public static final Holder<MapCodec<BurningCrateBlock>> BLAZE_FRUIT_CRATE =
        REGISTER.register("blaze_fruit_crate", () -> BurningCrateBlock.CODEC);

    public static final Holder<MapCodec<SmallBurningCrateBlock>> SMALL_BLAZE_FRUIT_CRATE =
        REGISTER.register("small_blaze_fruit_crate", () -> SmallBurningCrateBlock.CODEC);

    public static final Holder<MapCodec<CrateBlock>> CRATE =
        REGISTER.register("crate", () -> CrateBlock.CODEC);

    public static final Holder<MapCodec<SmallCrateBlock>> SMALL_CRATE =
        REGISTER.register("small_crate", () -> SmallCrateBlock.CODEC);

    public static final Holder<MapCodec<DeadVinesBlock>> DEAD_VINES =
        REGISTER.register("dead_vines", () -> DeadVinesBlock.CODEC);

    public static final Holder<MapCodec<MortofructBlock>> MORTOFRUCT =
        REGISTER.register("mortofruct", () -> MortofructBlock.CODEC);

    public static final Holder<MapCodec<NetherBerrySproutsBlock>> NETHER_BERRY_SPROUTS =
        REGISTER.register("nether_berry_sprouts", () -> NetherBerrySproutsBlock.CODEC);

    public static final Holder<MapCodec<NetherCropBlock>> NETHER_CROP_BLOCK =
        REGISTER.register("nether_crop", () -> NetherCropBlock.CODEC);

    public static final Holder<MapCodec<NetherFarmlandBlock>> NETHER_FARMLAND =
        REGISTER.register("nether_farmland", () -> NetherFarmlandBlock.CODEC);

    public static final Holder<MapCodec<NetherRootsBlock>> NETHER_ROOTS =
        REGISTER.register("nether_roots", () -> NetherRootsBlock.CODEC);

    public static final Holder<MapCodec<TallRootsBlock>> TALL_ROOTS =
        REGISTER.register("tall_roots", () -> TallRootsBlock.CODEC);

    public static final Holder<MapCodec<WarpedBerryRootsBlock>> WARPED_BERRY_ROOTS =
        REGISTER.register("warped_berry_roots", () -> WarpedBerryRootsBlock.CODEC);

    public static final Holder<MapCodec<WildLothunBlock>> WILD_LOTHUN =
        REGISTER.register("wild_lothun", () -> WildLothunBlock.CODEC);



    public static void initialize() {}
}
