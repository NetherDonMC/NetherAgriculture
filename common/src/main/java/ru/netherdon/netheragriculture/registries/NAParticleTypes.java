package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NAParticleTypes
{
    public static final IRegistryProvider<ParticleType<?>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.PARTICLE_TYPE);

    public static final Holder<SimpleParticleType> FLAME_EFFECT = REGISTER.register("flame_effect", () -> new SimpleParticleType(false));

    public static void initialize() {}
}
