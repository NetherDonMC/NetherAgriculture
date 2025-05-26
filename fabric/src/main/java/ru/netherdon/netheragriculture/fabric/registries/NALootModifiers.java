package ru.netherdon.netheragriculture.fabric.registries;

import com.mojang.serialization.MapCodec;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.PortingLibLoot;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import ru.netherdon.netheragriculture.fabric.loot.AddTableLootModifier;
import ru.netherdon.netheragriculture.fabric.loot.ReplaceItemLootModifier;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;
import ru.netherdon.netheragriculture.services.RegistryManager;

public class NALootModifiers
{
    private static final IRegistryProvider<MapCodec<? extends IGlobalLootModifier>> REGISTER = RegistryManager.getOrCreate(PortingLibLoot.GLOBAL_LOOT_MODIFIER_SERIALIZERS);

    public static final Holder<MapCodec<ReplaceItemLootModifier>> REPLACE_ITEM = REGISTER.register("replace_item", () -> ReplaceItemLootModifier.CODEC);
    public static final Holder<MapCodec<AddTableLootModifier>> ADD_TABLE = REGISTER.register("add_table", () -> AddTableLootModifier.CODEC);

    public static void initialize() {}
}
