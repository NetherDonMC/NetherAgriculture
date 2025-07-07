package ru.netherdon.netheragriculture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import ru.netherdon.netheragriculture.blocks.entities.CustomHangingSignBlockEntity;

public class CustomWallHangingSignBlock extends WallHangingSignBlock
{
    public CustomWallHangingSignBlock(WoodType woodType, Properties properties)
    {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return new CustomHangingSignBlockEntity(blockPos, blockState);
    }
}
