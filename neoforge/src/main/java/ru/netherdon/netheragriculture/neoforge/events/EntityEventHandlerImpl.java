package ru.netherdon.netheragriculture.neoforge.events;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.events.EntityEventHandler;
import ru.netherdon.netheragriculture.items.StriderTreatItem;

@EventBusSubscriber(modid = NetherAgriculture.ID)
public final class EntityEventHandlerImpl
{
    @SubscribeEvent
    private static void spawn(EntityJoinLevelEvent event)
    {
        EntityEventHandler.spawn(event.getEntity());
    }

    @SubscribeEvent
    private static void entityInteraction(PlayerInteractEvent.EntityInteract event)
    {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof StriderTreatItem treat && event.getTarget() instanceof Strider strider)
        {
            InteractionResult result = StriderTreatItem.mobInteract(stack, event.getLevel(), strider, event.getEntity());
            event.setCancellationResult(result);
            event.setCanceled(true);
        }
    }
}
