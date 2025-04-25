package ru.netherdon.netheragriculture.events;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.recipes.furnace.NetherCookingRecipe;
import ru.netherdon.netheragriculture.registries.NARecipeBookCategories;
import ru.netherdon.netheragriculture.registries.NARecipeBookTypes;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

import java.util.List;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = NetherAgriculture.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RecipeBookEventHandler
{
    @SubscribeEvent
    public static void initCategories(RegisterRecipeBookCategoriesEvent event)
    {
        event.registerRecipeCategoryFinder(NARecipeTypes.NETHER_COOKING.get(), (recipe) ->
            ((NetherCookingRecipe)recipe.value()).category() == CookingBookCategory.FOOD
                ? NARecipeBookCategories.blackFurnaceFood()
                : NARecipeBookCategories.blackFurnaceMisc()
        );

        event.registerBookCategories(NARecipeBookTypes.blackFurnace(), ImmutableList.of(
            NARecipeBookCategories.blackFurnaceSearch(),
            NARecipeBookCategories.blackFurnaceFood(),
            NARecipeBookCategories.blackFurnaceMisc()
        ));

        event.registerAggregateCategory(
            NARecipeBookCategories.blackFurnaceSearch(), List.of(
                NARecipeBookCategories.blackFurnaceFood(),
                NARecipeBookCategories.blackFurnaceMisc()
            )
        );
    }
}
