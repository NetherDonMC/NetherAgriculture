package ru.netherdon.netheragriculture.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import ru.netherdon.netheragriculture.client.NetherAgricultureClient;
import ru.netherdon.netheragriculture.client.particles.IParticleProviderRegister;

import java.util.function.Function;

public final class NetherAgricultureFabricClient implements ClientModInitializer
{
    private static final IParticleProviderRegister PARTICLE_PROVIDER_REGISTER = new IParticleProviderRegister()
    {
        @Override
        public <T extends ParticleOptions> void register(ParticleType<T> type, Function<SpriteSet, ParticleProvider<T>> factory)
        {
            ParticleFactoryRegistry.getInstance().register(type, factory::apply);
        }
    };

    @Override
    public void onInitializeClient()
    {
        NetherAgricultureClient.initialize();
        NetherAgricultureClient.registerScreens(MenuScreens::register);
        NetherAgricultureClient.registerParticleProviders(PARTICLE_PROVIDER_REGISTER);
    }
}
