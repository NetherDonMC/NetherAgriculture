package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.recipes.crafting.EmptyingStorageRecipe;

public final class NARecipeSerializers
{
    public static final DeferredRegister<RecipeSerializer<?>> REGISTER =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, NetherAgriculture.ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> EMPTYING_STORAGE =
        REGISTER.register("emptying_storage", EmptyingStorageRecipe.Serializer::new);
}
