package ru.netherdon.netheragriculture.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.entities.containers.BlackFurnaceMenu;

@Environment(EnvType.CLIENT)
public class BlackFurnaceScreen extends AbstractFurnaceScreen<BlackFurnaceMenu>
{
    private static final ResourceLocation LIT_PROGRESS_SPRITE = NetherAgriculture.location("container/black_furnace/lit_progress");
    private static final ResourceLocation BURN_PROGRESS_SPRITE = NetherAgriculture.location("container/black_furnace/burn_progress");
    private static final ResourceLocation TEXTURE = NetherAgriculture.location("textures/gui/container/black_furnace.png");

    public BlackFurnaceScreen(BlackFurnaceMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, new NetherCookingRecipeBookComponent(), playerInventory, title, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE);
    }
}
