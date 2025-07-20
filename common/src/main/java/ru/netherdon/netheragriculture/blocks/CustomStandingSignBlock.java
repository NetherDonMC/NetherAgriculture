package ru.netherdon.netheragriculture.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.blocks.entities.CustomSignBlockEntity;
import ru.netherdon.netheragriculture.registries.NABlockEntityTypes;

import java.util.function.Function;

public class CustomStandingSignBlock extends StandingSignBlock
{
    public static final MapCodec<CustomStandingSignBlock> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        instance.group(
            WoodType.CODEC.fieldOf("wood_type").forGetter(SignBlock::getWoodType),
            propertiesCodec()
        ).apply(instance, CustomStandingSignBlock::new)
    );

    public CustomStandingSignBlock(WoodType woodType, Properties properties)
    {
        super(woodType, properties);
    }

    @Override
    public MapCodec<StandingSignBlock> codec()
    {
        return CODEC.xmap(
            Function.identity(),
            (block) -> (CustomStandingSignBlock)block
        );
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return new CustomSignBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType)
    {
        return createTickerHelper(blockEntityType, NABlockEntityTypes.CUSTOM_SIGN.value(), SignBlockEntity::tick);
    }
}
