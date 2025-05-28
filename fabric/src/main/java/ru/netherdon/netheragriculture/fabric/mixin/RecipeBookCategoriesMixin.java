package ru.netherdon.netheragriculture.fabric.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import org.apache.logging.log4j.util.Lazy;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.netherdon.netheragriculture.fabric.registries.NARecipeBookCategories;
import ru.netherdon.netheragriculture.fabric.registries.NARecipeBookTypes;

import java.util.List;
import java.util.Map;

@Mixin(RecipeBookCategories.class)
public abstract class RecipeBookCategoriesMixin
{
    @Unique
    private static final Lazy<List<RecipeBookCategories>> NA$BLACK_FURNACE_CATEGORIES = Lazy.lazy(() -> List.of(
        NARecipeBookCategories.BLACK_FURNACE_SEARCH,
        NARecipeBookCategories.BLACK_FURNACE_FOOD,
        NARecipeBookCategories.BLACK_FURNACE_MISC
    ));

    @Final
    @Mutable
    @Shadow
    public static Map<RecipeBookCategories, List<RecipeBookCategories>> AGGREGATE_CATEGORIES;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyAggregateCategories(CallbackInfo ci)
    {
        ImmutableMap.Builder<RecipeBookCategories, List<RecipeBookCategories>> builder = ImmutableMap.builder();
        builder.putAll(AGGREGATE_CATEGORIES);
        builder.put(NARecipeBookCategories.BLACK_FURNACE_SEARCH, List.of(
            NARecipeBookCategories.BLACK_FURNACE_FOOD,
            NARecipeBookCategories.BLACK_FURNACE_MISC
        ));
        AGGREGATE_CATEGORIES = builder.build();
    }

    @Inject(method = "getCategories", at = @At("HEAD"), cancellable = true)
    private static void getBlackFurnaceCategories(RecipeBookType recipeBookType, CallbackInfoReturnable<List<RecipeBookCategories>> cir)
    {
        if (recipeBookType == NARecipeBookTypes.BLACK_FURNACE)
        {
            cir.setReturnValue(NA$BLACK_FURNACE_CATEGORIES.get());
        }
    }
}
