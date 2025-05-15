package ru.netherdon.netheragriculture.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ru.netherdon.netheragriculture.blocks.entities.containers.BlackFurnaceMenu;
import ru.netherdon.netheragriculture.registries.NABlockEntityTypes;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

public class BlackFurnaceBlockEntity extends AbstractFurnaceBlockEntity
{
    public BlackFurnaceBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(NABlockEntityTypes.BLACK_FURNACE.value(), pos, blockState, NARecipeTypes.NETHER_COOKING.value());
    }

    @Override
    protected Component getDefaultName()
    {
        return this.getBlockState().getBlock().getName();
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return new BlackFurnaceMenu(containerId, inventory, this, this.dataAccess);
    }
}
