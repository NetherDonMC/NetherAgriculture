package ru.netherdon.netheragriculture.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.client.NetherAgricultureClient;

@OnlyIn(Dist.CLIENT)
@Mod(NetherAgriculture.ID)
public class NetherAgricultureNeoForgeClient
{
    public NetherAgricultureNeoForgeClient(IEventBus modEventBus)
    {
        modEventBus.register(this);
        NetherAgricultureClient.initialize();
    }

    @SubscribeEvent
    public void registerScreens(RegisterMenuScreensEvent event)
    {
        NetherAgricultureClient.registerScreens(event::register);
    }
}
