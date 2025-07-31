package ru.netherdon.netheragriculture.client.particles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public interface ISourcedParticle
{
    public BlockPos getSourcePos();
    public void sourceChanged(BlockState state);
}
