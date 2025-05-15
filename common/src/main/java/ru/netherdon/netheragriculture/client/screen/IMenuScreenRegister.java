package ru.netherdon.netheragriculture.client.screen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public interface IMenuScreenRegister
{
    public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void register(MenuType<T> menuType, MenuScreens.ScreenConstructor<T, U> constructor);
}
