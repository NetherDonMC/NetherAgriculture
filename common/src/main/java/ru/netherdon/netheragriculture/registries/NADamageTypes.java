package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import ru.netherdon.netheragriculture.NetherAgriculture;

public final class NADamageTypes
{
    public static final ResourceKey<DamageType> FALLING_MORTOFRUCT =
        ResourceKey.create(Registries.DAMAGE_TYPE, NetherAgriculture.location("falling_mortofruct"));
}
