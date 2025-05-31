package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import ru.netherdon.netheragriculture.effects.BlazeFlightEffect;
import ru.netherdon.netheragriculture.effects.WarpMobEffect;
import ru.netherdon.netheragriculture.services.MobEffectService;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NAMobEffects
{
    public static final IRegistryProvider<MobEffect> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.MOB_EFFECT);

    public static final Holder<MobEffect> BLAZE_FLIGHT =
        REGISTER.register("blaze_flight", () -> MobEffectService.modifyBlazeFlight(new BlazeFlightEffect(MobEffectCategory.BENEFICIAL, 0xE65F00)));

    public static final Holder<MobEffect> INTERNAL_HEAT =
        REGISTER.register("internal_heat", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xFF3C00)
        {
            @Override
            public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance)
            {
                return NAParticleTypes.FLAME_EFFECT.value();
            }
        });

    public static final Holder<MobEffect> WARP =
        REGISTER.register("warp", () -> new WarpMobEffect(MobEffectCategory.HARMFUL, 0x25C4CB));



    public static void initialize() {}
}
