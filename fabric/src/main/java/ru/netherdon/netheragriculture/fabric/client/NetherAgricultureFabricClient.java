package ru.netherdon.netheragriculture.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import ru.netherdon.netheragriculture.blocks.entities.IBlockEntityRendererRegister;
import ru.netherdon.netheragriculture.client.NetherAgricultureClient;
import ru.netherdon.netheragriculture.client.particles.IParticleProviderRegister;
import ru.netherdon.netheragriculture.fabric.registries.NABlockRenderTypes;
import ru.netherdon.netheragriculture.registries.NAWoodTypes;

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
        NABlockRenderTypes.initialize();
        NetherAgricultureClient.registerScreens(MenuScreens::register);
        NetherAgricultureClient.registerParticleProviders(PARTICLE_PROVIDER_REGISTER);
        NetherAgricultureClient.registerBlockEntityRenderers(BlockEntityRenderers::register);

        Sheets.SIGN_MATERIALS.put(NAWoodTypes.GLOWING, Sheets.createSignMaterial(NAWoodTypes.GLOWING));
        Sheets.HANGING_SIGN_MATERIALS.put(NAWoodTypes.GLOWING, Sheets.createHangingSignMaterial(NAWoodTypes.GLOWING));
    }
}
