package ru.netherdon.netheragriculture.neoforge.registries;

import net.minecraft.world.inventory.RecipeBookType;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public final class NARecipeBookTypes
{
    public static final EnumProxy<RecipeBookType> BLACK_FURNACE = new EnumProxy<>(RecipeBookType.class);

    public static RecipeBookType blackFurnace()
    {
        return BLACK_FURNACE.getValue();
    }
}
