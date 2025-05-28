package ru.netherdon.netheragriculture.fabric.registries;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.world.inventory.RecipeBookType;
import ru.netherdon.netheragriculture.fabric.NetherAgricultureASM;

public final class NARecipeBookTypes
{
    public static final RecipeBookType BLACK_FURNACE = ClassTinkerers.getEnum(RecipeBookType.class, NetherAgricultureASM.BLACK_FURNACE_RECIPE_TYPE);
}
