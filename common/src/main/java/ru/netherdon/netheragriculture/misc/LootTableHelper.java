package ru.netherdon.netheragriculture.misc;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;

import java.util.List;

public final class LootTableHelper
{
    public static void extendLootPool(LootPool pool, List<LootPoolEntryContainer> newEntries)
    {
        var entriesBuilder = ImmutableList.<LootPoolEntryContainer>builder();
        entriesBuilder.addAll(pool.entries);
        entriesBuilder.addAll(newEntries);
        pool.entries = entriesBuilder.build();
    }
}
