package ru.netherdon.netheragriculture.fabric.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import ru.netherdon.netheragriculture.loot.IReplaceItemLootModifier;

public class ReplaceItemLootModifier extends LootModifier implements IReplaceItemLootModifier
{
    public static final MapCodec<ReplaceItemLootModifier> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        codecStart(instance)
            .and(IReplaceItemLootModifier.codecEnd(instance))
            .apply(instance, ReplaceItemLootModifier::new)
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
        return IReplaceItemLootModifier.super.doApply(generatedLoot, context);
    }

    @Override
    public Ingredient getInput()
    {
        return this.input;
    }

    @Override
    public ItemStack getReplacement()
    {
        return this.replacement;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return CODEC;
    }
}
