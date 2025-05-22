package ru.netherdon.netheragriculture.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.world.item.ItemStack;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.fabric.registries.NABiomeModifiers;
import ru.netherdon.netheragriculture.fabric.registries.NABlockRenderTypes;
import ru.netherdon.netheragriculture.fabric.registries.NALootTableModifiers;
import ru.netherdon.netheragriculture.items.StriderTreatItem;
import ru.netherdon.netheragriculture.registries.NAPotions;

public final class NetherAgricultureFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        NetherAgriculture.initialize();
        NABlockRenderTypes.initialize();
        NABiomeModifiers.initialize();
        NALootTableModifiers.initialize();

        FabricBrewingRecipeRegistryBuilder.BUILD.register(NAPotions::registerRecipes);

        UseEntityCallback.EVENT.register((player, level, hand, entity, hit) ->
        {
            ItemStack stack = player.getItemInHand(hand);
            return StriderTreatItem.mobInteract(stack, level, entity, player);
        });
    }
}
