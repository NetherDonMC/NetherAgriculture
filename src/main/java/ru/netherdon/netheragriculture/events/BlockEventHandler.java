package ru.netherdon.netheragriculture.events;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.level.BlockEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.registries.NABlocks;

import java.util.Map;

@EventBusSubscriber(modid = NetherAgriculture.ID, bus = EventBusSubscriber.Bus.GAME)
public class BlockEventHandler
{
    private static final Lazy<Map<Block, BlockState>> FARMLANDS = Lazy.of(() -> ImmutableMap.of(
        Blocks.CRIMSON_NYLIUM, NABlocks.CRIMSON_FARMLAND.get().defaultBlockState(),
        Blocks.WARPED_NYLIUM, NABlocks.WARPED_FARMLAND.get().defaultBlockState()
    ));

    @SubscribeEvent
    public static void hoeTillModification(BlockEvent.BlockToolModificationEvent event)
    {
        Block originalBlock = event.getState().getBlock();
        if (event.getItemAbility() == ItemAbilities.HOE_TILL && FARMLANDS.get().containsKey(event.getState().getBlock()))
        {
            event.setFinalState(FARMLANDS.get().get(originalBlock));
        }
    }
}
