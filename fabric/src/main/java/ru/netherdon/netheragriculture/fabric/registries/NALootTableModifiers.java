package ru.netherdon.netheragriculture.fabric.registries;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntries;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import ru.netherdon.netheragriculture.registries.NAItems;
import ru.netherdon.netheragriculture.registries.NATags;

import java.util.List;

public final class NALootTableModifiers
{
    private static final ResourceLocation STRIDER = ResourceLocation.withDefaultNamespace("entities/strider");

    public static void initialize()
    {
        LootTableEvents.MODIFY.register(NALootTableModifiers::modify);
    }

    private static void modify(ResourceKey<LootTable> key, LootTable.Builder builder, LootTableSource source, HolderLookup.Provider registries)
    {
        if (source.isBuiltin() && key.location().equals(STRIDER))
        {
            addStriderLegsDrop(builder, registries);
        }
    }

    private static void addStriderLegsDrop(LootTable.Builder builder, HolderLookup.Provider registries)
    {
        var enchantments = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(NATags.Enchantments.INCREASE_ENTITY_DROPS);
        builder.pool(
            LootPool.lootPool().add(
                LootItem.lootTableItem(NAItems.STRIDER_LEG.value())
                    .apply(
                        SetItemCountFunction.setCount(UniformGenerator.between(1, 2))
                    ).apply(
                        SetItemCountFunction.setCount(ConstantValue.exactly(2))
                            .when(
                                LootItemEntityPropertyCondition.hasProperties(
                                    LootContext.EntityTarget.DIRECT_ATTACKER,
                                    new EntityPredicate.Builder()
                                        .equipment(new EntityEquipmentPredicate.Builder().mainhand(
                                            ItemPredicate.Builder.item().withSubPredicate(
                                                ItemSubPredicates.ENCHANTMENTS,
                                                ItemEnchantmentsPredicate.enchantments(List.of(
                                                    new EnchantmentPredicate(enchantments, MinMaxBounds.Ints.ANY)
                                                ))
                                            )
                                        ))
                                )
                            )
                    )
            ).build()
        );
    }
}
