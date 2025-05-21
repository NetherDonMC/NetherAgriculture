package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import ru.netherdon.netheragriculture.NetherAgriculture;

public final class NAFeatureKeys
{
    public static final ResourceKey<PlacedFeature> WILD_LOTHUN = key("wild_lothun");
    public static final ResourceKey<PlacedFeature> WARPED_BERRY_SPROUTS = key("warped_berry_sprouts");
    public static final ResourceKey<PlacedFeature> TALL_WARPED_ROOTS = key("tall_warped_roots");
    public static final ResourceKey<PlacedFeature> WILD_SINFUL_EYES = key("wild_sinful_eyes");
    public static final ResourceKey<PlacedFeature> CRIMSON_BERRY_SPROUTS = key("crimson_berry_sprouts");
    public static final ResourceKey<PlacedFeature> TALL_CRIMSON_ROOTS = key("tall_crimson_roots");

    private static ResourceKey<PlacedFeature> key(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, NetherAgriculture.location(name));
    }
}
