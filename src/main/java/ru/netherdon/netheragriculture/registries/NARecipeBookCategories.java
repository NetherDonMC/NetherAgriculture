package ru.netherdon.netheragriculture.registries;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.List;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public final class NARecipeBookCategories
{
    public static final EnumProxy<RecipeBookCategories> BLACK_FURNACE_SEARCH = create(
        () -> List.of(Items.COMPASS.getDefaultInstance())
    );

    public static final EnumProxy<RecipeBookCategories> BLACK_FURNACE_FOOD = create(
        () -> List.of(NAItems.HOGLIN_MEAT.toStack())
    );

    public static final EnumProxy<RecipeBookCategories> BLACK_FURNACE_MISC = create(
        () -> List.of(Items.LAVA_BUCKET.getDefaultInstance())
    );

    public static RecipeBookCategories blackFurnaceSearch()
    {
        return BLACK_FURNACE_SEARCH.getValue();
    }

    public static RecipeBookCategories blackFurnaceFood()
    {
        return BLACK_FURNACE_FOOD.getValue();
    }

    public static RecipeBookCategories blackFurnaceMisc()
    {
        return BLACK_FURNACE_MISC.getValue();
    }

    private static EnumProxy<RecipeBookCategories> create(Supplier<List<ItemStack>> icons)
    {
        return new EnumProxy<>(RecipeBookCategories.class, icons);
    }
}
