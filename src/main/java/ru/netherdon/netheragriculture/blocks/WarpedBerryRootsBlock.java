package ru.netherdon.netheragriculture.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.netherdon.netheragriculture.registries.NABlocks;
import ru.netherdon.netheragriculture.registries.NAItems;

public class WarpedBerryRootsBlock extends NetherCropBlock
{
    private static final VoxelShape SHAPE0 = box(0f, 0f, 0f, 16f, 2f,16f);
    private static final VoxelShape SHAPE1 = box(0f, 0f, 0f, 16f, 6f,16f);
    private static final VoxelShape SHAPE2 = box(0f, 0f, 0f, 16f, 8f,16f);
    private static final VoxelShape SHAPE3 = box(0f, 0f, 0f, 16f, 15f,16f);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]
    {
        SHAPE0, SHAPE0, SHAPE1, SHAPE1, SHAPE2, SHAPE2, SHAPE2, SHAPE3,
    };

    public WarpedBerryRootsBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        int age = this.getAge(state);
        if (age >= this.getMaxAge())
        {
            int count = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(NAItems.WARPED_BERRY.get(), count));
            level.playSound(
                null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F
            );
            BlockState newState = state.setValue(this.getAgeProperty(), age-1);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public boolean isValidFarmland(BlockState state)
    {
        return state.is(NABlocks.WARPED_FARMLAND);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        int age = this.getAge(state);
        return SHAPE_BY_AGE[age];
    }
}
