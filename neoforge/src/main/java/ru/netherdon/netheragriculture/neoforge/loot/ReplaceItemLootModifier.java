package ru.netherdon.netheragriculture.neoforge.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class ReplaceItemLootModifier extends LootModifier
{
    public static final MapCodec<ReplaceItemLootModifier> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        codecStart(instance).and(instance.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("from").forGetter(ReplaceItemLootModifier::getInput),
            ItemStack.SINGLE_ITEM_CODEC.fieldOf("to").forGetter(ReplaceItemLootModifier::getReplacement))
        ).apply(instance, ReplaceItemLootModifier::new)
    );

    private final Ingredient input;
    private final ItemStack replacement;

    public ReplaceItemLootModifier(LootItemCondition[] conditionsIn, Ingredient input, ItemStack replacement)
    {
        super(conditionsIn);
        this.input = input;
        this.replacement = replacement;
    }

    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
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

    public Ingredient getInput()
    {
        return this.input;
    }

    public ItemStack getReplacement()
    {
        return this.replacement;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return null;
    }
}
