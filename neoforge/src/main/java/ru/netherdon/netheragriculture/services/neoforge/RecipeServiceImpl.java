package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.world.inventory.RecipeBookType;
import ru.netherdon.netheragriculture.neoforge.registries.NARecipeBookTypes;

public final class RecipeServiceImpl
{
    public static RecipeBookType getBlackFurnaceRecipeBookType()
    {
        return NARecipeBookTypes.blackFurnace();
    }
}
