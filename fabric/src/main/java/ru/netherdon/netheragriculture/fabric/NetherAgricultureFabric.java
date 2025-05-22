package ru.netherdon.netheragriculture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.items.StriderTreatItem;
import ru.netherdon.netheragriculture.registries.NABlocks;
import ru.netherdon.netheragriculture.registries.NAFeatureKeys;

public final class NetherAgricultureFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        NetherAgriculture.initialize();
        initializeBlockRenderTypes();

        UseEntityCallback.EVENT.register((player, level, hand, entity, hit) ->
        {
            ItemStack stack = player.getItemInHand(hand);
            return StriderTreatItem.mobInteract(stack, level, entity, player);
        });

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.WILD_LOTHUN
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.WARPED_BERRY_SPROUTS
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.TALL_WARPED_ROOTS
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.AZURE_MELON
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.WILD_SINFUL_EYES
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.CRIMSON_BERRY_SPROUTS
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.TALL_CRIMSON_ROOTS
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.MORTOFRUCT
        );

        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.NETHER_WASTES),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            NAFeatureKeys.NETHER_ROOTS
        );
    }

    private static void initializeBlockRenderTypes()
    {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutout(),
            NABlocks.ATTACHED_AZURE_MELON_STEM.value(),
            NABlocks.AZURE_MELON_STEM.value(),
            NABlocks.BLAZE_FRUIT.value(),
            NABlocks.CRIMSON_BERRY_ROOTS.value(),
            NABlocks.CRIMSON_BERRY_SPROUTS.value(),
            NABlocks.DEAD_VINES.value(),
            NABlocks.LOTHUNS.value(),
            NABlocks.NETHER_ROOTS.value(),
            NABlocks.TALL_CRIMSON_ROOTS.value(),
            NABlocks.TALL_WARPED_ROOTS.value(),
            NABlocks.WARPED_BERRY_ROOTS.value(),
            NABlocks.WARPED_BERRY_SPROUTS.value(),
            NABlocks.WILD_LOTHUN.value(),
            NABlocks.AZURE_MELON.value(),
            NABlocks.AZURE_MELON_CROP.value(),
            NABlocks.SINFUL_EYES.value(),
            NABlocks.WILD_SINFUL_EYES.value(),
            NABlocks.WILD_AZURE_MELON.value()
        );
    }
}
