package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.netherdon.netheragriculture.registries.NABlocks;

public class SinfulEyesBlock extends NetherCropBlock
{
    public static final MapCodec<SinfulEyesBlock> CODEC = simpleCodec(SinfulEyesBlock::new);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]
    {
        box(0f, 0f, 0f, 16f, 2f,16f),
        box(0f, 0f, 0f, 16f, 3f,16f),
        box(0f, 0f, 0f, 16f, 4f,16f),
        box(0f, 0f, 0f, 16f, 5f,16f),
        box(0f, 0f, 0f, 16f, 6f,16f),
        box(0f, 0f, 0f, 16f, 7f,16f),
        box(0f, 0f, 0f, 16f, 8f,16f),
        box(0f, 0f, 0f, 16f, 9f,16f)
    };

    public SinfulEyesBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isValidFarmland(BlockState state)
    {
        return state.is(NABlocks.CRIMSON_FARMLAND.value());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        int age = this.getAge(state);
        return SHAPE_BY_AGE[age];
    }

    @Override
    public MapCodec<? extends SinfulEyesBlock> codec()
    {
        return CODEC;
    }
}
