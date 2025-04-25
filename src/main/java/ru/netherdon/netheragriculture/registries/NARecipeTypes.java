package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.recipes.furnace.NetherCookingRecipe;

public final class NARecipeTypes
{
    public static final DeferredRegister<RecipeType<?>> REGISTER =
        DeferredRegister.create(Registries.RECIPE_TYPE, NetherAgriculture.ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<NetherCookingRecipe>> NETHER_COOKING =
        REGISTER.register("nether_cooking", RecipeType::simple);
}
