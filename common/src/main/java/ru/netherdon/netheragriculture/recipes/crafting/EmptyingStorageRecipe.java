package ru.netherdon.netheragriculture.recipes.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import ru.netherdon.netheragriculture.registries.NARecipeSerializers;

public class EmptyingStorageRecipe implements CraftingRecipe
{
    private final Ingredient input;
    private final ItemStack storage;
    private final ItemStack result;

    public EmptyingStorageRecipe(Ingredient input, ItemStack storage, ItemStack result)
    {
        this.input = input;
        this.storage = storage;
        this.result = result;
    }

    @Override
    public boolean matches(CraftingInput input, Level level)
    {
        int inputCount = 0;
        for (int i = 0; i < input.size(); i++)
        {
            ItemStack stack = input.getItem(i);
            if (stack.isEmpty())
            {
                continue;
            }

            if (this.input.test(stack))
            {
                inputCount++;
                continue;
            }

            return false;
        }

        return inputCount == 1;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries)
    {
        return this.result.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries)
    {
        return this.result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients()
    {
        return NonNullList.of(Ingredient.EMPTY, this.input);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input)
    {
        NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
        for (int i = 0; i < input.size(); i++)
        {
            ItemStack stack = input.getItem(i);
            if (this.input.test(stack))
            {
                ItemStack remainingStack = this.storage.copy();
                remaining.set(i, remainingStack);
            }
        }

        return remaining;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height)
    {
        return width >= 1 && height >= 1;
    }

    @Override
    public CraftingBookCategory category()
    {
        return CraftingBookCategory.MISC;
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return NARecipeSerializers.EMPTYING_STORAGE.value();
    }

    public static class Serializer implements RecipeSerializer<EmptyingStorageRecipe>
    {
        public static final MapCodec<EmptyingStorageRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("input").forGetter((recipe) -> recipe.input),
                ItemStack.SINGLE_ITEM_CODEC.fieldOf("storage").forGetter((recipe) -> recipe.storage),
                ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> recipe.result)
            ).apply(instance, EmptyingStorageRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf,EmptyingStorageRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC,
            (recipe) -> recipe.input,
            ItemStack.STREAM_CODEC,
            (recipe) -> recipe.storage,
            ItemStack.STREAM_CODEC,
            (recipe) -> recipe.result,
            EmptyingStorageRecipe::new
        );

        @Override
        public MapCodec<EmptyingStorageRecipe> codec()
        {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, EmptyingStorageRecipe> streamCodec()
        {
            return STREAM_CODEC;
        }
    }
}
