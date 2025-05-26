package ru.netherdon.netheragriculture.fabric.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Optional;

public class AddTableLootModifier extends LootModifier
{
    public static final MapCodec<AddTableLootModifier> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        codecStart(instance).and(
            ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("table").forGetter((modifier) -> modifier.table)
        ).apply(instance, AddTableLootModifier::new)
    );

    private final ResourceKey<LootTable> table;

    protected AddTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> table)
    {
        super(conditionsIn);
        this.table = table;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        LootContext contextCopy = new LootContext.Builder(context.params).create(Optional.empty());
        contextCopy.setQueriedLootTableId(this.table.location());
        context.getResolver().get(Registries.LOOT_TABLE, this.table).ifPresent((extraTable) ->
            extraTable.value().getRandomItemsRaw(contextCopy, LootTable.createStackSplitter(contextCopy.getLevel(), generatedLoot::add))
        );
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return CODEC;
    }
}
