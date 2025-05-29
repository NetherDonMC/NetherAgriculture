package ru.netherdon.netheragriculture.fabric.registries;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.compat.OtherModNames;
import ru.netherdon.netheragriculture.config.NACommonConfig;
import ru.netherdon.netheragriculture.registries.NAItems;

import java.util.Map;

public final class NALootTableModifiers
{
    private static final ResourceLocation STRIDER = ResourceLocation.withDefaultNamespace("entities/strider");
    private static final ResourceLocation HOGLIN = ResourceLocation.withDefaultNamespace("entities/hoglin");

    private static final ResourceLocation NETHER_BRIDGE = ResourceLocation.withDefaultNamespace("chests/nether_bridge");
    private static final ResourceLocation BASTION_HOGLIN_STABLE = ResourceLocation.withDefaultNamespace("chests/bastion_hoglin_stable");


    public static void initialize()
    {
        LootTableEvents.MODIFY.register(NALootTableModifiers::modify);
    }

    private static void modify(ResourceKey<LootTable> key, LootTable.Builder builder, LootTableSource source, HolderLookup.Provider registries)
    {
        if (!source.isBuiltin())
        {
            return;
        }

        ResourceLocation tableId = key.location();
        if (tableId.equals(NETHER_BRIDGE))
        {
            if (config().isNetherBridgeEnabled())
            {
                builder.withPool(LootPool.lootPool().add(reference("modifiers/chests/nether_bridge")));
            }
        }
        else if (tableId.equals(STRIDER))
        {
            if (config().isStriderEnabled())
            {
                builder.withPool(LootPool.lootPool().add(reference("modifiers/strider_leg")));
            }
        }
        else if (!FabricLoader.getInstance().isModLoaded(OtherModNames.MY_NETHERS_DELIGHT))
        {
            if (tableId.equals(BASTION_HOGLIN_STABLE))
            {
                if (config().isBastionHoglinStableEnabled())
                {
                    replaceItem(builder, Map.of(
                        Items.PORKCHOP, toItem(NAItems.HOGLIN_MEAT),
                        Items.COOKED_PORKCHOP, toItem(NAItems.COOKED_HOGLIN_MEAT)
                    ));
                }
            }
            else if (tableId.equals(HOGLIN))
            {
                if (config().isHoglinEnabled())
                {
                    replaceItem(builder, Map.of(
                        Items.PORKCHOP, all(toItem(NAItems.HOGLIN_MEAT), removeSmelting())
                    ));
                }
            }
        }
    }

    private static Modifier all(Modifier... modifiers)
    {
        return (loot) ->
        {
            for (Modifier modifier : modifiers)
            {
                loot = modifier.modify(loot);
            }
            return loot;
        };
    }

    private static Modifier toItem(Holder<Item> item)
    {
        return (loot) ->
        {
            loot.item = item;
            return loot;
        };
    }

    private static Modifier removeSmelting()
    {
        return (loot) ->
        {
            ImmutableList.Builder<LootItemFunction> newFunctions = ImmutableList.builder();
            for (LootItemFunction function : loot.functions)
            {
                if (!(function instanceof SmeltItemFunction))
                {
                    newFunctions.add(function);
                }
            }
            loot.functions = newFunctions.build();
            return loot;
        };
    }

    private static void replaceItem(LootTable.Builder tableBuilder, Map<Item, Modifier> modifiers)
    {
        tableBuilder.modifyPools((poolBuilder) ->
        {
            ImmutableList<LootPoolEntryContainer> oldEntries = poolBuilder.entries.build();
            poolBuilder.entries = ImmutableList.builder();

            for (LootPoolEntryContainer container : oldEntries)
            {
                poolBuilder.with(container);
                if (container instanceof LootItem lootItem && modifiers.containsKey(lootItem.item.value()))
                {
                    poolBuilder.with(modifiers.get(lootItem.item.value()).modify(lootItem));
                }
                else
                {
                    poolBuilder.with(container);
                }
            }
        });
    }

    private static ResourceKey<LootTable> key(String name)
    {
        return ResourceKey.create(Registries.LOOT_TABLE, NetherAgriculture.location(name));
    }

    private static NACommonConfig.LootModifierSettings config()
    {
        return NACommonConfig.get().overrides.lootModifier();
    }

    private static LootPoolSingletonContainer.Builder<?> reference(String name)
    {
        return NestedLootTable.lootTableReference(key(name));
    }

    private interface Modifier
    {
        public LootItem modify(LootItem loot);
    }
}
