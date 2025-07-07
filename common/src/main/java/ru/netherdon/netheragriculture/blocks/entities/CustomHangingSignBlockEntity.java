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
    public BlockEntityType<?> getType()
    {
        return NABlockEntityTypes.HANGING_CUSTOM_SIGN.value();
    }
}
