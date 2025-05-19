package ru.netherdon.netheragriculture.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import ru.netherdon.netheragriculture.client.particles.FlameEffectParticleProvider;
import ru.netherdon.netheragriculture.client.particles.IParticleProviderRegister;
import ru.netherdon.netheragriculture.client.screen.BlackFurnaceScreen;
import ru.netherdon.netheragriculture.client.screen.IMenuScreenRegister;
import ru.netherdon.netheragriculture.registries.NAMenuTypes;
import ru.netherdon.netheragriculture.registries.NAParticleTypes;

@Environment(EnvType.CLIENT)
public class NetherAgricultureClient
{
    public static void initialize()
    {

    }

    public static void registerScreens(IMenuScreenRegister register)
    {
        register.register(NAMenuTypes.BLACK_FURNACE.value(), BlackFurnaceScreen::new);
    }

    public static void registerParticleProviders(IParticleProviderRegister register)
    {
        register.register(NAParticleTypes.FLAME_EFFECT.value(), FlameEffectParticleProvider::new);
    }
}
