package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import ru.netherdon.netheragriculture.effects.WarpMobEffect;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NAMobEffects
{
    public static final IRegistryProvider<MobEffect> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.MOB_EFFECT);

    public static final Holder<MobEffect> BLAZE_FLIGHT =
        REGISTER.register("blaze_flight", RegistryManager::createBlazeFlightEffect);

    public static final Holder<MobEffect> WARP =
        REGISTER.register("warp", () -> new WarpMobEffect(MobEffectCategory.HARMFUL, 0x25C4CB));



    public static void initialize() {}
}
