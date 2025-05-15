package ru.netherdon.netheragriculture.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import ru.netherdon.netheragriculture.client.NetherAgricultureClient;

public final class NetherAgricultureFabricClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        NetherAgricultureClient.initialize();
        NetherAgricultureClient.registerScreens(MenuScreens::register);
    }
}
