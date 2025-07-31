package ru.netherdon.netheragriculture.client.particles.options;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.Block;
import ru.netherdon.netheragriculture.registries.NAParticleTypes;

public record GlowingSporeAirParticleOptions(Block block, BlockPos pos) implements ParticleOptions
{
    public static final MapCodec<GlowingSporeAirParticleOptions> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        instance.group(
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(GlowingSporeAirParticleOptions::block),
            BlockPos.CODEC.fieldOf("pos").forGetter(GlowingSporeAirParticleOptions::pos)
        ).apply(instance, GlowingSporeAirParticleOptions::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, GlowingSporeAirParticleOptions> STREAM_CODEC = StreamCodec.composite(
        ByteBufCodecs.registry(Registries.BLOCK),
        GlowingSporeAirParticleOptions::block,
        BlockPos.STREAM_CODEC,
        GlowingSporeAirParticleOptions::pos,
        GlowingSporeAirParticleOptions::new
    );

    @Override
    public ParticleType<?> getType()
    {
        return NAParticleTypes.GLOWING_SPORE_AIR.value();
    }
}
