package ru.netherdon.netheragriculture.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.client.screen.BlackFurnaceScreen;
import ru.netherdon.netheragriculture.registries.NAMenuTypes;

@OnlyIn(Dist.CLIENT)
@Mod(value = NetherAgriculture.ID, dist = Dist.CLIENT)
public class NetherAgricultureClient
{
    public NetherAgricultureClient(IEventBus modEventBus)
    {
        modEventBus.register(this);
    }

    @SubscribeEvent
    public void registerScreens(RegisterMenuScreensEvent event)
    {
        event.register(NAMenuTypes.BLACK_FURNACE.get(), BlackFurnaceScreen::new);
    }
}
