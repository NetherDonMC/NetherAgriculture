package ru.netherdon.netheragriculture.blocks.entities.containers;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import ru.netherdon.netheragriculture.registries.NAMenuTypes;
import ru.netherdon.netheragriculture.registries.NARecipeBookTypes;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

public class BlackFurnaceMenu extends AbstractFurnaceMenu
{
    public BlackFurnaceMenu(int containerId, Inventory playerInventory, RegistryFriendlyByteBuf buf)
    {
        super(NAMenuTypes.BLACK_FURNACE.get(), NARecipeTypes.NETHER_COOKING.get(), NARecipeBookTypes.blackFurnace(), containerId, playerInventory);
    }

    public BlackFurnaceMenu(int containerId, Inventory playerInventory, Container container, ContainerData data)
    {
        super(NAMenuTypes.BLACK_FURNACE.get(), NARecipeTypes.NETHER_COOKING.get(), NARecipeBookTypes.blackFurnace(), containerId, playerInventory, container, data);
    }
}
