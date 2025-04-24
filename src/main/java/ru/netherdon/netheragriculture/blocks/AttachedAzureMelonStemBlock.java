package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.netherdon.netheragriculture.registries.NABlocks;
import ru.netherdon.netheragriculture.registries.NAItems;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class AttachedAzureMelonStemBlock extends BushBlock
{
    public static final MapCodec<AttachedAzureMelonStemBlock> CODEC = simpleCodec(AttachedAzureMelonStemBlock::new);

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final VoxelShape SHAPE_NORTH = box(5, 0, 0, 11, 13, 11);
    public static final VoxelShape SHAPE_SOUTH = box(5, 0, 5, 11, 13, 16);
    public static final VoxelShape SHAPE_WEST = box(0, 0, 5, 11, 13, 11);
    public static final VoxelShape SHAPE_EAST = box(5, 0, 5, 16, 13, 11);

    public static final Map<Direction, VoxelShape> SHAPE_BY_FACING = new EnumMap<>(Map.of(
        Direction.NORTH, SHAPE_NORTH,
        Direction.SOUTH, SHAPE_SOUTH,
        Direction.WEST, SHAPE_WEST,
        Direction.EAST, SHAPE_EAST
    ));

    public AttachedAzureMelonStemBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos)
    {
        if (!facingState.is(NABlocks.AZURE_MELON_CROP) && facing == state.getValue(FACING))
        {
            return NABlocks.AZURE_MELON_STEM.get().defaultBlockState().trySetValue(NetherCropBlock.AGE, 7);
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        Direction facing = state.getValue(FACING);
        return SHAPE_BY_FACING.get(facing);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.getBlock() instanceof NetherFarmlandBlock;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player)
    {
        return NAItems.AZURE_MELON_SEEDS.toStack();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation rotation)
    {
        Direction facing = state.getValue(FACING);
        return state.setValue(FACING, rotation.rotate(facing));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror)
    {
        Direction facing = state.getValue(FACING);
        return state.setValue(FACING, mirror.mirror(facing));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec()
    {
        return CODEC;
    }
}
