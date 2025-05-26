package ru.netherdon.netheragriculture.neoforge.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import ru.netherdon.netheragriculture.neoforge.loot.ReplaceItemLootModifier;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;
import ru.netherdon.netheragriculture.services.RegistryManager;

public class NALootModifiers
{
    private static final IRegistryProvider<MapCodec<? extends IGlobalLootModifier>> REGISTER = RegistryManager.getOrCreate(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS);

    public static final Holder<MapCodec<ReplaceItemLootModifier>> REPLACE_ITEM = REGISTER.register("replace_item", () -> ReplaceItemLootModifier.CODEC);

    public static void initialize() {}
}
