package ru.netherdon.netheragriculture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.items.StriderTreatItem;
import ru.netherdon.netheragriculture.registries.NABlocks;

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
            NABlocks.WILD_SINFUL_EYES.value()
        );
    }
}
