package ru.netherdon.netheragriculture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.events.BlockEventHandler;
import ru.netherdon.netheragriculture.registries.NABlocks;

public final class NetherAgricultureFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        NetherAgriculture.initialize();
        initializeBlockRenderTypes();
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
            NABlocks.AZURE_MELON_CROP.value()
        );
    }
}
