package ru.netherdon.netheragriculture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.util.TriState;

public class NetherCropBlock extends CropBlock implements INetherCrop
{
    public NetherCropBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (!level.isAreaLoaded(pos, 1))
        {
            return;
        }

        if (this.canGrow(state, level, pos))
        {
            float growthSpeed = getNetherGrowthSpeed(state, level, pos);
            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int)(20f / growthSpeed) + 1) == 0))
            {
                this.grow(state, level, pos, random);
                CommonHooks.fireCropGrowPost(level, pos, state);
            }
        }
    }

    protected boolean canGrow(BlockState state, ServerLevel level, BlockPos pos)
    {
        return !this.isMaxAge(state);
    }

    protected void grow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        int age = this.getAge(state);
        level.setBlock(pos, this.withAge(state, age + 1), 2);
    }

    protected BlockState withAge(BlockState state, int age)
    {
        return state.setValue(this.getAgeProperty(), age);
    }

    public boolean isValidFarmland(BlockState state)
    {
        return false;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.getBlock() instanceof NetherFarmlandBlock;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        BlockPos blockpos = pos.below();
        BlockState belowBlockState = level.getBlockState(blockpos);
        TriState soilDecision = belowBlockState.canSustainPlant(level, blockpos, Direction.UP, state);
        if (!soilDecision.isDefault())
        {
            return soilDecision.isTrue();
        }

        return this.mayPlaceOn(belowBlockState, level, blockpos);
    }

    @Override
    protected ItemLike getBaseSeedId()
    {
        ItemLike item = this.asItem();
        if (item != Items.AIR)
        {
            return item;
        }

        return super.getBaseSeedId();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(this.getAgeProperty());
    }

    protected static float getNetherGrowthSpeed(BlockState blockState, BlockGetter level, BlockPos pos)
    {
        Block block = blockState.getBlock();
        float speed = 1f;
        BlockPos posBelow = pos.below();

        BlockState stateBelow = level.getBlockState(posBelow);
        TriState soilDecision = stateBelow.canSustainPlant(level, posBelow, net.minecraft.core.Direction.UP, blockState);
        if (soilDecision.isDefault() ? stateBelow.getBlock() instanceof NetherCropBlock : soilDecision.isTrue())
        {
            if (blockState.getBlock() instanceof INetherCrop netherCropBlock && netherCropBlock.isValidFarmland(stateBelow))
            {
                speed += 3f;
            }
            else
            {
                speed += 1f;
            }
        }

        BlockPos posNorth = pos.north();
        BlockPos posSouth = pos.south();
        BlockPos posWest = pos.west();
        BlockPos posEast = pos.east();
        boolean flag = level.getBlockState(posWest).is(block) || level.getBlockState(posEast).is(block);
        boolean flag1 = level.getBlockState(posNorth).is(block) || level.getBlockState(posSouth).is(block);
        if (flag && flag1)
        {
            speed /= 2.0F;
        }
        else
        {
            boolean flag2 = level.getBlockState(posWest.north()).is(block)
                || level.getBlockState(posEast.north()).is(block)
                || level.getBlockState(posEast.south()).is(block)
                || level.getBlockState(posWest.south()).is(block);
            if (flag2)
            {
                speed /= 2.0F;
            }
        }

        return speed;
    }
}
