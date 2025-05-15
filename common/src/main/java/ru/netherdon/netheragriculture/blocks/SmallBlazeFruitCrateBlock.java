package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SmallBlazeFruitCrateBlock extends SlabBlock
{
    public static final MapCodec<SmallBlazeFruitCrateBlock> CODEC = Block.simpleCodec(SmallBlazeFruitCrateBlock::new);

    public SmallBlazeFruitCrateBlock(Properties properties)
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
    public MapCodec<? extends SmallBlazeFruitCrateBlock> codec()
    {
        return CODEC;
    }
}
