package ru.netherdon.netheragriculture.fabric.registries;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import ru.netherdon.netheragriculture.registries.NABlocks;

public final class NABlockRenderTypes
{
    public static void initialize()
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
