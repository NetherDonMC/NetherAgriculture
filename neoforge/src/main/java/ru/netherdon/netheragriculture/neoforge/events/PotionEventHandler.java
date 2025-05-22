package ru.netherdon.netheragriculture.neoforge.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.registries.NAPotions;

@EventBusSubscriber(modid = NetherAgriculture.ID)
public final class PotionEventHandler
{
    @SubscribeEvent
    public static void registerRecipes(RegisterBrewingRecipesEvent event)
    {
        NAPotions.registerRecipes(event.getBuilder());
    }
}
