package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public final class NADamageSources
{
    public static DamageSource mortofruct(Entity entity)
    {
        return mortofruct(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE), entity);
    }

    public static DamageSource mortofruct(Registry<DamageType> damageTypes, Entity entity)
    {
        return new DamageSource(damageTypes.getHolderOrThrow(NADamageTypes.FALLING_MORTOFRUCT), entity);
    }
}
