package ru.netherdon.netheragriculture.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.netherdon.netheragriculture.fabric.registries.NARecipeBookCategories;
import ru.netherdon.netheragriculture.registries.NARecipeTypes;

@Mixin(ClientRecipeBook.class)
public abstract class ClientRecipeBookMixin
{
    @Inject(method = "getCategory", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/AbstractCookingRecipe;category()Lnet/minecraft/world/item/crafting/CookingBookCategory;"), cancellable = true)
    private static void getBlackFurnaceCategory(RecipeHolder<?> recipeHolder, CallbackInfoReturnable<RecipeBookCategories> cir, @Local RecipeType<?> recipetype, @Local AbstractCookingRecipe abstractcookingrecipe)
    {
        if (recipetype == NARecipeTypes.NETHER_COOKING.value())
        {
            cir.setReturnValue(
                abstractcookingrecipe.category() == CookingBookCategory.FOOD
                    ? NARecipeBookCategories.BLACK_FURNACE_FOOD
                    : NARecipeBookCategories.BLACK_FURNACE_MISC
            );
        }
    }
}
