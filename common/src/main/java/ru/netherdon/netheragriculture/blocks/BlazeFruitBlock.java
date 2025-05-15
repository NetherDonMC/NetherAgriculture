package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlazeFruitBlock extends NetherCropBlock
{
    public static final MapCodec<BlazeFruitBlock> CODEC = simpleCodec(BlazeFruitBlock::new);

    public static final BooleanProperty SOUL = BooleanProperty.create("soul");

    private static final VoxelShape SHAPE0 = box(5f, 0f, 5f, 11f, 2f,11f);
    private static final VoxelShape SHAPE1 = box(4f, 0f, 4f, 12f, 2f,12f);
    private static final VoxelShape SHAPE2 = box(3f, 0f, 3f, 13f, 3f,13f);
    private static final VoxelShape SHAPE3 = box(2f, 0f, 2f, 14f, 5f,14f);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]
    {
        SHAPE0, SHAPE0, SHAPE1, SHAPE1, SHAPE2, SHAPE2, SHAPE2, SHAPE3,
    };

    public BlazeFruitBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SOUL, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos posBelow = context.getClickedPos().below();
        BlockState stateBelow = context.getLevel().getBlockState(posBelow);
        return this.defaultBlockState()
            .setValue(SOUL, stateBelow.is(BlockTags.SOUL_FIRE_BASE_BLOCKS));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.is(BlockTags.SOUL_FIRE_BASE_BLOCKS) || super.mayPlaceOn(state, level, pos);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
    {
        if (this.isMaxAge(state))
        {
            if (!entity.fireImmune())
            {
                entity.setRemainingFireTicks(entity.getRemainingFireTicks() + 1);
                if (entity.getRemainingFireTicks() == 0)
                {
                    entity.igniteForSeconds(3.0F);
                }
            }

            entity.hurt(level.damageSources().inFire(), 1f);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    public boolean isValidFarmland(BlockState state)
    {
        return state.is(BlockTags.SOUL_FIRE_BASE_BLOCKS);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        int age = this.getAge(state);
        return SHAPE_BY_AGE[age];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(SOUL);
    }

    @Override
    public MapCodec<? extends BlazeFruitBlock> codec()
    {
        return CODEC;
    }
}
