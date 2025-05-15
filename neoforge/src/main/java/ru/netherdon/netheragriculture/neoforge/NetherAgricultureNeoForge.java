package ru.netherdon.netheragriculture.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.services.neoforge.RegistryManagerImpl;

@Mod(NetherAgriculture.ID)
public class NetherAgricultureNeoForge
{
    public NetherAgricultureNeoForge(IEventBus modEventBus, ModContainer modContainer)
    {
        NetherAgriculture.initialize();
        RegistryManagerImpl.registerDeferredRegistries(modEventBus);
    }
}
