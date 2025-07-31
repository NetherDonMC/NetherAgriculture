package ru.netherdon.netheragriculture.client.particles.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.client.particles.ISourcedParticle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SourcedParticleManager
{
    private static final Map<BlockPos, List<ISourcedParticle>> LISTENERS = new HashMap<>();

    public static ISourcedParticle add(ISourcedParticle particle)
    {
        LISTENERS.computeIfAbsent(
            particle.getSourcePos().immutable(),
            (posIn) -> new ArrayList<>()
        ).add(particle);

        return particle;
    }

    public static void remove(ISourcedParticle particle)
    {
        BlockPos pos = particle.getSourcePos();
        if (LISTENERS.containsKey(pos))
        {
            LISTENERS.get(pos).remove(particle);
        }
    }

    public static void fireBlockChange(BlockPos pos, BlockState newState)
    {
        if (LISTENERS.containsKey(pos))
        {
            LISTENERS.get(pos).forEach(
                (listener) -> listener.sourceChanged(newState)
            );
        }
    }
}
