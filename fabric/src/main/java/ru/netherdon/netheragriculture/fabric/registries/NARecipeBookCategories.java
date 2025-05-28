package ru.netherdon.netheragriculture.fabric.registries;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.RecipeBookCategories;
import ru.netherdon.netheragriculture.fabric.NetherAgricultureASM;

public final class NARecipeBookCategories
{
    public static final RecipeBookCategories BLACK_FURNACE_SEARCH = ClassTinkerers.getEnum(RecipeBookCategories.class, NetherAgricultureASM.BLACK_FURNACE_SEARCH_CATEGORY);
    public static final RecipeBookCategories BLACK_FURNACE_FOOD = ClassTinkerers.getEnum(RecipeBookCategories.class, NetherAgricultureASM.BLACK_FURNACE_FOOD_CATEGORY);
    public static final RecipeBookCategories BLACK_FURNACE_MISC = ClassTinkerers.getEnum(RecipeBookCategories.class, NetherAgricultureASM.BLACK_FURNACE_MISC_CATEGORY);

}
