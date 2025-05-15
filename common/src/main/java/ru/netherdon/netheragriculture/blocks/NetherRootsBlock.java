package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.netherdon.netheragriculture.registries.NATags;

public class NetherRootsBlock extends BushBlock
{
    public static final MapCodec<NetherRootsBlock> CODEC = Block.simpleCodec(NetherRootsBlock::new);

    public static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 13, 14);

    public NetherRootsBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.is(NATags.Blocks.NETHERRACKS)
            || state.is(BlockTags.NYLIUM)
            || state.is(Blocks.SOUL_SOIL)
            || super.mayPlaceOn(state, level, pos);
    }

    @Override
    protected MapCodec<? extends NetherRootsBlock> codec()
    {
        return CODEC;
    }
}
