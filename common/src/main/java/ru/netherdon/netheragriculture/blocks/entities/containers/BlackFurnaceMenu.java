package ru.netherdon.netheragriculture.blocks.entities.containers;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import ru.netherdon.netheragriculture.registries.NAMenuTypes;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;
import ru.netherdon.netheragriculture.services.RecipeService;

public class BlackFurnaceMenu extends AbstractFurnaceMenu
{
    public BlackFurnaceMenu(int containerId, Inventory playerInventory)
    {
        super(NAMenuTypes.BLACK_FURNACE.value(), NARecipeTypes.NETHER_COOKING.value(), RecipeService.getBlackFurnaceRecipeBookType(), containerId, playerInventory);
    }

    public BlackFurnaceMenu(int containerId, Inventory playerInventory, Container container, ContainerData data)
    {
        super(NAMenuTypes.BLACK_FURNACE.value(), NARecipeTypes.NETHER_COOKING.value(), RecipeService.getBlackFurnaceRecipeBookType(), containerId, playerInventory, container, data);
    }
}
