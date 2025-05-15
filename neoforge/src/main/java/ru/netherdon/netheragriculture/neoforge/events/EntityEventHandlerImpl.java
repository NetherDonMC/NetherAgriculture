package ru.netherdon.netheragriculture.neoforge.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.events.EntityEventHandler;

@EventBusSubscriber(modid = NetherAgriculture.ID)
public final class EntityEventHandlerImpl
{
    @SubscribeEvent
    private static void spawn(EntityJoinLevelEvent event)
    {
        EntityEventHandler.spawn(event.getEntity());
    }
}
