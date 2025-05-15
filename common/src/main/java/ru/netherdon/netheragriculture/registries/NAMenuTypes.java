package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import ru.netherdon.netheragriculture.blocks.entities.containers.BlackFurnaceMenu;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NAMenuTypes
{
    public static final IRegistryProvider<MenuType<?>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.MENU);

    public static final Holder<MenuType<BlackFurnaceMenu>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> new MenuType<>(BlackFurnaceMenu::new, FeatureFlags.DEFAULT_FLAGS));



    public static void initialize() {}
}
