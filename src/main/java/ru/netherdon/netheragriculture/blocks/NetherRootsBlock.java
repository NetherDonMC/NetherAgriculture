package ru.netherdon.netheragriculture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

public class NetherRootsBlock extends RootsBlock
{
    public NetherRootsBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.is(Tags.Blocks.NETHERRACKS) || super.mayPlaceOn(state, level, pos);
    }
}
