package ru.netherdon.netheragriculture.services.neoforge;

import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.neoforge.registries.RegistryProvider;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;

import java.util.ArrayList;
import java.util.List;

public class RegistryManagerImpl
{
    private static final List<DeferredRegister<?>> DEFERRED_REGISTERS = new ArrayList<>();

    public static <T> IRegistryProvider<T> createProvider(Registry<T> registry)
    {
        DeferredRegister<T> deferredRegister = DeferredRegister.create(registry, NetherAgriculture.ID);
        DEFERRED_REGISTERS.add(deferredRegister);
        return new RegistryProvider<>(deferredRegister);
    }

    public static void registerDeferredRegistries(IEventBus modEventBus)
    {
        DEFERRED_REGISTERS.forEach((register) -> register.register(modEventBus));
    }

    public static MobEffect createBlazeFlightEffect()
    {
        return new MobEffect(MobEffectCategory.BENEFICIAL, 0xE65F00) {}
            .addAttributeModifier(
                NeoForgeMod.CREATIVE_FLIGHT,
                NetherAgriculture.location("blaze_flight_mob_effect"),
                1,
                AttributeModifier.Operation.ADD_VALUE
            );
    }
}
