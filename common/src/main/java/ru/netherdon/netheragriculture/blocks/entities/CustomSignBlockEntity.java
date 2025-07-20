package ru.netherdon.netheragriculture.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.registries.NABlockEntityTypes;

public class CustomSignBlockEntity extends SignBlockEntity
{
    public CustomSignBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(NABlockEntityTypes.CUSTOM_SIGN.value(), blockPos, blockState);
    }
}
