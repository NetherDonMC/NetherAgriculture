package ru.netherdon.netheragriculture.recipes.furnace;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import ru.netherdon.netheragriculture.registries.NARecipeSerializers;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

public class NetherCookingRecipe extends AbstractCookingRecipe
{
    public NetherCookingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime)
    {
        super(NARecipeTypes.NETHER_COOKING.value(), group, category, ingredient, result, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return NARecipeSerializers.NETHER_COOKING.value();
    }
}
