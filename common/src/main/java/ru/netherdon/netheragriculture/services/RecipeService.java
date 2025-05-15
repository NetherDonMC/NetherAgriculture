package ru.netherdon.netheragriculture.services;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.inventory.RecipeBookType;
import org.jetbrains.annotations.Contract;

public final class RecipeService
{
    @ExpectPlatform
    @Contract(pure = true)
    public static RecipeBookType getBlackFurnaceRecipeBookType()
    {
        throw new UnsupportedOperationException();
    }
}
