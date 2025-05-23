package ru.netherdon.netheragriculture.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.client.screen.BlackFurnaceScreen;
import ru.netherdon.netheragriculture.registries.NAItems;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

@JeiPlugin
public class NAJeiPlugin implements IModPlugin
{
    private static final ResourceLocation UID = NetherAgriculture.location("jei_plugin");

    @Override
    public ResourceLocation getPluginUid()
    {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IModPlugin.super.registerCategories(registration);
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new NetherCookingCategory(guiHelper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(NAItems.BLACK_FURNACE.value().getDefaultInstance(), NetherCookingCategory.TYPE);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        IModPlugin.super.registerGuiHandlers(registration);
        registration.addRecipeClickArea(BlackFurnaceScreen.class, 78, 32, 28, 23, NetherCookingCategory.TYPE, RecipeTypes.FUELING);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        IModPlugin.super.registerRecipes(registration);
        registration.addRecipes(NetherCookingCategory.TYPE,
            Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(NARecipeTypes.NETHER_COOKING.value())
        );
    }
}
