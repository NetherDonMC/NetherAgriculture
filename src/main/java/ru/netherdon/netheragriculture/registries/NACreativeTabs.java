package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;

public final class NACreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> REGISTRY = NetherAgriculture.registry(Registries.CREATIVE_MODE_TAB);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMMON = REGISTRY.register("common", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup." + NetherAgriculture.ID + ".common"))
        .icon(NAItems.CRIMSON_BERRY::toStack)
        .displayItems((params, output) ->
        {
            output.accept(NAItems.CRIMSON_FARMLAND);
            output.accept(NAItems.WARPED_FARMLAND);
            output.accept(NAItems.DEAD_VINES);
            output.accept(NAItems.MORTOFRUCT);
            output.accept(NAItems.WILD_CRIMSON_BERRY_ROOTS);
            output.accept(NAItems.WILD_WARPED_BERRY_ROOTS);
            output.accept(NAItems.WILD_LOTHUN);

            output.accept(NAItems.CRIMSON_CRATE);
            output.accept(NAItems.SMALL_CRIMSON_CRATE);
            output.accept(NAItems.CRIMSON_CRATE_OF_CRIMSON_BERRIES);
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES);
            output.accept(NAItems.CRIMSON_CRATE_OF_WARPED_BERRIES);
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES);
            output.accept(NAItems.CRIMSON_CRATE_OF_LOTHUN);
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_LOTHUN);
            output.accept(NAItems.WARPED_CRATE);
            output.accept(NAItems.SMALL_WARPED_CRATE);
            output.accept(NAItems.WARPED_CRATE_OF_CRIMSON_BERRIES);
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES);
            output.accept(NAItems.WARPED_CRATE_OF_WARPED_BERRIES);
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_WARPED_BERRIES);
            output.accept(NAItems.WARPED_CRATE_OF_LOTHUN);
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_LOTHUN);

            output.accept(NAItems.CRIMSON_BERRY_SEEDS);
            output.accept(NAItems.CRIMSON_BERRY);
            output.accept(NAItems.WARPED_BERRY_SEEDS);
            output.accept(NAItems.WARPED_BERRY);
            output.accept(NAItems.LOTHUN);
            output.accept(NAItems.MORTOFRUCT_HALF);
            output.accept(NAItems.AZURE_MELON);
            output.accept(NAItems.BLAZE_FRUIT);
            output.accept(NAItems.EXTINGUISHED_BLAZE_FRUIT);
            output.accept(NAItems.HOGLIN_MEAT);
            output.accept(NAItems.COOKED_HOGLIN_MEAT);
            output.accept(NAItems.STRIDER_LEG);
            output.accept(NAItems.COOKED_STRIDER_LEG);

            output.accept(NAItems.NETHER_MUSHROOM_STEW);
            output.accept(NAItems.NETHER_FRUIT_SALAD);
            output.accept(NAItems.AZURE_MELON_SORBET);
            output.accept(NAItems.BLAZE_CREAM_SOUP);
            output.accept(NAItems.GLAZED_HOGLIN_MEAT);
        })
        .build()
    );
}
