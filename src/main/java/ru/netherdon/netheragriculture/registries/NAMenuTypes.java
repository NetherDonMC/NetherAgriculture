package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.entities.containers.BlackFurnaceMenu;

public final class NAMenuTypes
{
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(Registries.MENU, NetherAgriculture.ID);

    public static final DeferredHolder<MenuType<?>, MenuType<BlackFurnaceMenu>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> IMenuTypeExtension.create(BlackFurnaceMenu::new));
}
