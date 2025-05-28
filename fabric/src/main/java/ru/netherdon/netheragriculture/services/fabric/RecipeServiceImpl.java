package ru.netherdon.netheragriculture.services.fabric;

import net.minecraft.world.inventory.RecipeBookType;
import ru.netherdon.netheragriculture.fabric.registries.NARecipeBookTypes;

public final class RecipeServiceImpl
{
    public static RecipeBookType getBlackFurnaceRecipeBookType()
    {
        return NARecipeBookTypes.BLACK_FURNACE;
    }
}
