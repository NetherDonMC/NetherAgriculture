package ru.netherdon.netheragriculture.client.screen;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

import java.util.Set;

public class NetherCookingRecipeBookComponent extends AbstractFurnaceRecipeBookComponent
{
    private static final Component FILTER_NAME = Component.translatable("gui.recipebook.toggleRecipes.smeltable");

    @Override
    protected Component getRecipeFilterName()
    {
        return FILTER_NAME;
    }

    @Override
    protected Set<Item> getFuelItems()
    {
        return AbstractFurnaceBlockEntity.getFuel().keySet();
    }
}
