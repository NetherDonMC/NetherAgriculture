package ru.netherdon.netheragriculture.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BlockTypes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.*;

public final class NABlockTypes
{
    public static final DeferredRegister<MapCodec<? extends Block>> REGISTER =
        DeferredRegister.create(Registries.BLOCK_TYPE, NetherAgriculture.ID);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<AttachedAzureMelonStemBlock>> ATTACHED_AZURE_MELON_STEM =
        REGISTER.register("attached_azure_melon_stem", () -> AttachedAzureMelonStemBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<AzureMelonStemBlock>> AZURE_MELON_STEM =
        REGISTER.register("azure_melon_stem", () -> AzureMelonStemBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<AzureMelonBlock>> AZURE_MELON =
        REGISTER.register("azure_melon", () -> AzureMelonBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<AzureMelonCropBlock>> AZURE_MELON_CROP =
        REGISTER.register("azure_melon_crop", () -> AzureMelonCropBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<BlackFurnaceBlock>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> BlackFurnaceBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<BlazeFruitBlock>> BLAZE_FRUIT =
        REGISTER.register("blaze_fruit", () -> BlazeFruitBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<BlazeFruitCrateBlock>> BLAZE_FRUIT_CRATE =
        REGISTER.register("blaze_fruit_crate", () -> BlazeFruitCrateBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<SmallBlazeFruitCrateBlock>> SMALL_BLAZE_FRUIT_CRATE =
        REGISTER.register("small_blaze_fruit_crate", () -> SmallBlazeFruitCrateBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<CrateBlock>> CRATE =
        REGISTER.register("crate", () -> CrateBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<SmallCrateBlock>> SMALL_CRATE =
        REGISTER.register("small_crate", () -> SmallCrateBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<DeadVinesBlock>> DEAD_VINES =
        REGISTER.register("dead_vines", () -> DeadVinesBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<MortofructBlock>> MORTOFRUCT =
        REGISTER.register("mortofruct", () -> MortofructBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<NetherBerrySproutsBlock>> NETHER_BERRY_SPROUTS =
        REGISTER.register("nether_berry_sprouts", () -> NetherBerrySproutsBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<NetherCropBlock>> NETHER_CROP_BLOCK =
        REGISTER.register("nether_crop", () -> NetherCropBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<NetherFarmlandBlock>> NETHER_FARMLAND =
        REGISTER.register("nether_farmland", () -> NetherFarmlandBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<NetherRootsBlock>> NETHER_ROOTS =
        REGISTER.register("nether_roots", () -> NetherRootsBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<TallRootsBlock>> TALL_ROOTS =
        REGISTER.register("tall_roots", () -> TallRootsBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<WarpedBerryRootsBlock>> WARPED_BERRY_ROOTS =
        REGISTER.register("warped_berry_roots", () -> WarpedBerryRootsBlock.CODEC);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<WildLothunBlock>> WILD_LOTHUN =
        REGISTER.register("wild_lothun", () -> WildLothunBlock.CODEC);
}
