package ru.netherdon.netheragriculture;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.registries.*;

@Mod(NetherAgriculture.ID)
public class NetherAgriculture
{
    public static final String ID = "netheragriculture";

    public NetherAgriculture(IEventBus modEventBus, ModContainer modContainer)
    {
        NABlocks.REGISTER.register(modEventBus);
        NABlockTypes.REGISTER.register(modEventBus);
        NAItems.REGISTER.register(modEventBus);
        NACreativeTabs.REGISTRY.register(modEventBus);
        NAMobEffects.REGISTER.register(modEventBus);
        NARecipeSerializers.REGISTER.register(modEventBus);
        NABlockEntityTypes.REGISTER.register(modEventBus);
        NAMenuTypes.REGISTER.register(modEventBus);
        NARecipeTypes.REGISTER.register(modEventBus);
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
