package ru.netherdon.netheragriculture;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.registries.NACreativeTabs;
import ru.netherdon.netheragriculture.registries.NAItems;
import ru.netherdon.netheragriculture.registries.NAMobEffects;

@Mod(NetherAgriculture.ID)
public class NetherAgriculture
{
    public static final String ID = "netheragriculture";

    public NetherAgriculture(IEventBus modEventBus, ModContainer modContainer)
    {
        NAItems.REGISTER.register(modEventBus);
        NACreativeTabs.REGISTRY.register(modEventBus);
        NAMobEffects.REGISTER.register(modEventBus);
    }

    public static ResourceLocation location(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(ID, name);
    }

    public static <T> DeferredRegister<T> registry(ResourceKey<Registry<T>> registryKey)
    {
        return DeferredRegister.create(registryKey, ID);
    }
}
