package ru.netherdon.netheragriculture.compat.emi;

import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.handler.CookingRecipeHandler;
import dev.emi.emi.recipe.EmiCookingRecipe;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.registries.NAItems;
import ru.netherdon.netheragriculture.registries.NAMenuTypes;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

@EmiEntrypoint
public class NAEmiPlugin implements EmiPlugin
{
    private static final EmiRecipeCategory NETHER_COOKING = new EmiRecipeCategory(
        NetherAgriculture.location("nether_cooking"),
        EmiStack.of(NAItems.BLACK_FURNACE.value())
    );

    @Override
    public void register(EmiRegistry registry)
    {
        registry.addCategory(NETHER_COOKING);

        registry.addWorkstation(NETHER_COOKING, EmiStack.of(NAItems.BLACK_FURNACE.value()));

        registry.addRecipeHandler(NAMenuTypes.BLACK_FURNACE.value(), new CookingRecipeHandler<>(NETHER_COOKING));

        for (var recipe : registry.getRecipeManager().getAllRecipesFor(NARecipeTypes.NETHER_COOKING.value()))
        {
            registry.addRecipe(new EmiCookingRecipe(recipe.value(), NETHER_COOKING, 1, false));
        }
    }
}
