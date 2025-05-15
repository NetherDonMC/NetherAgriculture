package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeFruitCrateBlock extends Block
{
    public static final MapCodec<BlazeFruitCrateBlock> CODEC = simpleCodec(BlazeFruitCrateBlock::new);

    public BlazeFruitCrateBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity)
    {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity)
        {
            entity.hurt(level.damageSources().hotFloor(), 1.0F);
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    protected MapCodec<? extends BlazeFruitCrateBlock> codec()
    {
        return CODEC;
    }
}
