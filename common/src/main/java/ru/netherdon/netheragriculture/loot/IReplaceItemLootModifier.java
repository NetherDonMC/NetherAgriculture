package ru.netherdon.netheragriculture.loot;

import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootContext;

public interface IReplaceItemLootModifier
{
    public Ingredient getInput();
    public ItemStack getReplacement();

    public default ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        for (int i = 0; i < generatedLoot.size(); i++)
        {
            ItemStack stack = generatedLoot.get(i);
            if (this.getInput().test(stack))
            {
                ItemStack newStack = this.getReplacement().copyWithCount(stack.getCount());
                generatedLoot.set(i, newStack);
            }
        }

        return generatedLoot;
    }

    public static <T extends IReplaceItemLootModifier> Products.P2<RecordCodecBuilder.Mu<T>, Ingredient, ItemStack> codecEnd(RecordCodecBuilder.Instance<T> instance)
    {
        return instance.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("from").forGetter(IReplaceItemLootModifier::getInput),
            ItemStack.SINGLE_ITEM_CODEC.fieldOf("to").forGetter(IReplaceItemLootModifier::getReplacement)
        );
    }
}
