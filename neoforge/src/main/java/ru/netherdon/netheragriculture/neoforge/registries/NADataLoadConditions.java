package ru.netherdon.netheragriculture.neoforge.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import ru.netherdon.netheragriculture.neoforge.data.load_condition.FarmersDelightIntegrationCondition;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NADataLoadConditions
{
    private static final IRegistryProvider<MapCodec<? extends ICondition>> REGISTER =
        RegistryManager.getOrCreate(NeoForgeRegistries.CONDITION_SERIALIZERS);

    public static final Holder<MapCodec<FarmersDelightIntegrationCondition>> FARMERS_DELIGHT_INTEGRATION =
        REGISTER.register("farmers_delight_integration", () -> FarmersDelightIntegrationCondition.CODEC);

    public static void initialize() {}
}
