package ru.netherdon.netheragriculture.events;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
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

    private static final Lazy<Map<Block, DoublePlantBlock>> DOUBLE_PLANTS = Lazy.of(() -> ImmutableMap.of(
        Blocks.CRIMSON_ROOTS, NABlocks.TALL_CRIMSON_ROOTS.get(),
        Blocks.WARPED_ROOTS, NABlocks.TALL_WARPED_ROOTS.get()
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

    @SubscribeEvent
    public static void applyBoneMeal(BonemealEvent event)
    {
        Block originalBlock = event.getState().getBlock();
        if (DOUBLE_PLANTS.get().containsKey(originalBlock))
        {
            Level level = event.getLevel();
            BlockPos pos = event.getPos();
            if (level.isClientSide)
            {
                ParticleUtils.spawnParticleInBlock(level, pos, 15, ParticleTypes.HAPPY_VILLAGER);
            }
            else
            {
                DoublePlantBlock doublePlant = DOUBLE_PLANTS.get().get(originalBlock);
                BlockState doublePlantState = doublePlant.defaultBlockState();
                if (doublePlantState.canSurvive(level, pos) && level.isEmptyBlock(pos.above()))
                {
                    DoublePlantBlock.placeAt(level, doublePlantState, pos, 2);
                }
                event.getStack().shrink(1);
            }

            event.setSuccessful(true);
        }
    }
}
