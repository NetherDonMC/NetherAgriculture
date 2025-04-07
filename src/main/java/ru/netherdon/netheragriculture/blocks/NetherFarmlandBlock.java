package ru.netherdon.netheragriculture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Supplier;

public class NetherFarmlandBlock extends Block
{
    public static final VoxelShape SHAPE = box(0, 0, 0, 16, 15, 16);

    public NetherFarmlandBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos)
    {
        if (direction == Direction.UP && !state.canSurvive(level, pos))
        {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        super.tick(state, level, pos, random);
        if (!state.canSurvive(level, pos))
        {
            turnToNetherrack(null, state, level, pos);
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        BlockPos posAbove = pos.above();
        BlockState stateAbove = level.getBlockState(posAbove);
        return !stateAbove.isFaceSturdy(level, posAbove, Direction.DOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos())
            ? super.getStateForPlacement(context)
            : Blocks.NETHERRACK.defaultBlockState();
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance)
    {
        if (!level.isClientSide)
        {
            turnToNetherrack(entity, state, level, pos);
        }

        super.fallOn(level, state, pos, entity, fallDistance);
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state)
    {
        return true;
    }

    public static void turnToNetherrack(@Nullable Entity entity, BlockState state, Level level, BlockPos pos)
    {
        BlockState blockstate = pushEntitiesUp(state, Blocks.NETHERRACK.defaultBlockState(), level, pos);
        level.setBlockAndUpdate(pos, blockstate);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
    }
}
