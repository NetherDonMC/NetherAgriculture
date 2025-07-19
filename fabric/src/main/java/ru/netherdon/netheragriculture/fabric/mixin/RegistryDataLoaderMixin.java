package ru.netherdon.netheragriculture.fabric.mixin;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.serialization.Decoder;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.netherdon.netheragriculture.registries.NAConfiguredFeatures;

@Mixin(RegistryDataLoader.class)
public class RegistryDataLoaderMixin
{
    @Inject(
        method = "loadElementFromResource",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/core/WritableRegistry;register(Lnet/minecraft/resources/ResourceKey;Ljava/lang/Object;Lnet/minecraft/core/RegistrationInfo;)Lnet/minecraft/core/Holder$Reference;"
        )
    )
    private static <E> void b(
        WritableRegistry<E> writableRegistry,
        Decoder<E> decoder,
        RegistryOps<JsonElement> registryOps,
        ResourceKey<E> resourceKey,
        Resource resource,
        RegistrationInfo registrationInfo,
        CallbackInfo ci,
        @Local E object
    )
    {
        if (resourceKey.registry().equals(Registries.CONFIGURED_FEATURE.location()))
        {
            NAConfiguredFeatures.modify(resourceKey.location(), (ConfiguredFeature<?, ?>)object);
        }
    }
}
