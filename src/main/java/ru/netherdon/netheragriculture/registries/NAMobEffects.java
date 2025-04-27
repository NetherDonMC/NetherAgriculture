package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.effects.WarpMobEffect;

public final class NAMobEffects
{
    public static final DeferredRegister<MobEffect> REGISTER = NetherAgriculture.registry(Registries.MOB_EFFECT);

    public static final DeferredHolder<MobEffect, MobEffect> BLAZE_FLIGHT =
        REGISTER.register("blaze_flight", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0xE65F00) {}
            .addAttributeModifier(
                NeoForgeMod.CREATIVE_FLIGHT,
                NetherAgriculture.location("blaze_flight_mob_effect"),
                1,
                AttributeModifier.Operation.ADD_VALUE
            )
        );

    public static final DeferredHolder<MobEffect, MobEffect> WARP =
        REGISTER.register("warp", () -> new WarpMobEffect(MobEffectCategory.HARMFUL, 0x25C4CB) {});
}
