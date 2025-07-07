package ru.netherdon.netheragriculture.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.registries.NABlockEntityTypes;

public class CustomSignBlockEntity extends SignBlockEntity
{
    public CustomSignBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType()
    {
        return NABlockEntityTypes.CUSTOM_SIGN.value();
    }
}
