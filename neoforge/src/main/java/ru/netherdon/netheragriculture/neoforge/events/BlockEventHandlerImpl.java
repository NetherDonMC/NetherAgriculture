package ru.netherdon.netheragriculture.neoforge.events;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.events.BlockEventHandler;

@EventBusSubscriber(modid = NetherAgriculture.ID, bus = EventBusSubscriber.Bus.GAME)
public final class BlockEventHandlerImpl
{
    @SubscribeEvent
    private static void hoeTillModification(BlockEvent.BlockToolModificationEvent event)
    {
        if (event.getItemAbility() == ItemAbilities.HOE_TILL)
        {
            BlockState state = BlockEventHandler.hoeTill(event.getState());
            if (state != null)
            {
                event.setFinalState(state);
            }
        }
    }

    @SubscribeEvent
    private static void applyBoneMeal(BonemealEvent event)
    {
        if (BlockEventHandler.applyBoneMeal(event.getState(), event.getLevel(), event.getPos(), event.getStack()))
        {
            event.setSuccessful(true);
        }
    }
}
