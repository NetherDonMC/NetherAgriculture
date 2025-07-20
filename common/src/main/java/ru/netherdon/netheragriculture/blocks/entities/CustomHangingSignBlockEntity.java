package ru.netherdon.netheragriculture.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.registries.NABlockEntityTypes;

public class CustomHangingSignBlockEntity extends HangingSignBlockEntity
{
    public CustomHangingSignBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(blockPos, blockState);
    }

    @Override
    public boolean isValidBlockState(BlockState blockState)
    {
        return this.getType().isValid(blockState);
    }

    @Override
    public BlockEntityType<?> getType()
    {
        return NABlockEntityTypes.CUSTOM_HANGING_SIGN.value();
    }
}
