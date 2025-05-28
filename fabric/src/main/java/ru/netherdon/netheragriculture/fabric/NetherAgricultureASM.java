package ru.netherdon.netheragriculture.fabric;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import ru.netherdon.netheragriculture.registries.NAItems;

import java.util.function.Supplier;

public final class NetherAgricultureASM implements Runnable
{
    public static final String BLACK_FURNACE_RECIPE_TYPE = "NETHERAGRICULTURE_BLACK_FURNACE";
    public static final String BLACK_FURNACE_SEARCH_CATEGORY = "NETHERAGRICULTURE_BLACK_FURNACE_SEARCH";
    public static final String BLACK_FURNACE_FOOD_CATEGORY = "NETHERAGRICULTURE_BLACK_FURNACE_FOOD";
    public static final String BLACK_FURNACE_MISC_CATEGORY = "NETHERAGRICULTURE_BLACK_FURNACE_MISC";

    private static final String NAMESPACE = "intermediary";
    private static final MappingResolver REMAPPER = FabricLoader.getInstance().getMappingResolver();

    @Override
    public void run()
    {
        String recipeBookTypeClassName = map("5421");
        ClassTinkerers.enumBuilder(recipeBookTypeClassName).addEnum(BLACK_FURNACE_RECIPE_TYPE).build();

        String recipeBookCategoriesClassName = map("314");
        String itemStackArrayType = "[L" + map("1799") + ";";
        ClassTinkerers.enumBuilder(recipeBookCategoriesClassName, itemStackArrayType)
            .addEnum(BLACK_FURNACE_SEARCH_CATEGORY, searchCategoryIcons())
            .addEnum(BLACK_FURNACE_FOOD_CATEGORY, foodCategoryIcons())
            .addEnum(BLACK_FURNACE_MISC_CATEGORY, miscCategoryIcons())
            .build();
    }

    private static Supplier<Object[]> searchCategoryIcons()
    {
        return () -> new Object[] { new ItemStack[] { Items.COMPASS.getDefaultInstance() } };
    }

    private static Supplier<Object[]> foodCategoryIcons()
    {
        return () -> new Object[] { new ItemStack[] { NAItems.HOGLIN_MEAT.value().getDefaultInstance() } };
    }

    private static Supplier<Object[]> miscCategoryIcons()
    {
        return () -> new Object[] { new ItemStack[] { Items.LAVA_BUCKET.getDefaultInstance() } };
    }

    private static String map(String postfix)
    {
        return REMAPPER.mapClassName(NAMESPACE, "net.minecraft.class_" + postfix);
    }
}
