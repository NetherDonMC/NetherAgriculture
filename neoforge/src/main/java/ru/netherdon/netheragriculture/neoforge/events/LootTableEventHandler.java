package ru.netherdon.netheragriculture.neoforge.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.config.NACommonConfig;
import ru.netherdon.netheragriculture.misc.LootTableHelper;
import ru.netherdon.netheragriculture.registries.NAPiglinBartering;

import static ru.netherdon.netheragriculture.registries.LootTableNames.*;

@EventBusSubscriber(modid = NetherAgriculture.ID)
public class LootTableEventHandler
{
    @SubscribeEvent
    public static void modify(LootTableLoadEvent event)
    {
        if (event.getName().equals(PIGLIN_BARTERING) && NACommonConfig.get().overrides.lootModifier().isPiglinBarteringEnabled())
        {
            LootTableHelper.extendLootPool(event.getTable().pools.getFirst(), NAPiglinBartering.getAdditionalEntries());
        }
    }
}
