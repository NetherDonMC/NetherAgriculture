package ru.netherdon.netheragriculture.services.fabric;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import ru.netherdon.netheragriculture.blocks.entities.containers.BlackFurnaceMenu;
import ru.netherdon.netheragriculture.fabric.registries.RegistryProvider;
import ru.netherdon.netheragriculture.registries.IRegistryProvider;

public final class RegistryManagerImpl
{
    public static <T> IRegistryProvider<T> createProvider(Registry<T> registry)
    {
        return new RegistryProvider<>(registry);
    }

    public static MobEffect createBlazeFlightEffect()
    {
        return new MobEffect(MobEffectCategory.BENEFICIAL, 0xE65F00)
        {
            @Override
            public boolean applyEffectTick(LivingEntity livingEntity, int i)
            {
                if (livingEntity instanceof Player player)
                {
                    player.getAbilities().mayfly = true;
                    player.onUpdateAbilities();
                }

                return super.applyEffectTick(livingEntity, i);
            }

            @Override
            public boolean shouldApplyEffectTickThisTick(int i, int j)
            {
                return true;
            }
        };
    }
}
