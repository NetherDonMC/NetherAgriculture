package ru.netherdon.netheragriculture.fabric.registries;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import ru.netherdon.netheragriculture.fabric.data.resource_condition.FarmersDelightIntegrationResourceCondition;

public final class NAResourceConditions
{
    public static void initialize()
    {
        ResourceConditions.register(FarmersDelightIntegrationResourceCondition.TYPE);
    }
}
