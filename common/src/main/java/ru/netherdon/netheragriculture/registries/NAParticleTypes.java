package ru.netherdon.netheragriculture.registries;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import ru.netherdon.netheragriculture.client.particles.options.GlowingSporeAirParticleOptions;
import ru.netherdon.netheragriculture.services.RegistryManager;

import java.util.function.Supplier;

public final class NAParticleTypes
{
    public static final IRegistryProvider<ParticleType<?>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.PARTICLE_TYPE);

    public static final Holder<SimpleParticleType> FLAME_EFFECT = REGISTER.register("flame_effect", () -> new SimpleParticleType(false));
    public static final Holder<ParticleType<GlowingSporeAirParticleOptions>> GLOWING_SPORE_AIR = REGISTER.register("glowing_spore_air",
        () -> of(GlowingSporeAirParticleOptions.CODEC, GlowingSporeAirParticleOptions.STREAM_CODEC)
    );
    public static final Holder<SimpleParticleType> GLOWING_SPORES_MARKER = REGISTER.register("glowing_spores_marker", () -> new SimpleParticleType(false));

    private static <T extends ParticleOptions> ParticleType<T> of(MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec)
    {
        return new ParticleType<T>(false)
        {
            @Override
            public MapCodec<T> codec()
            {
                return codec;
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec()
            {
                return streamCodec;
            }
        };
    }

    public static void initialize() {}
}
