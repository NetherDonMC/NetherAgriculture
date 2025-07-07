package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import ru.netherdon.netheragriculture.items.*;
import ru.netherdon.netheragriculture.services.RegistryManager;

import java.util.function.BiFunction;
import java.util.function.Function;

public final class NAItems
{
    public static final IRegistryProvider<Item> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.ITEM);

    public static final Holder<Item> CRUSHED_NETHER_ROOTS = registerSimpleItem("crushed_nether_roots");
    public static final Holder<Item> CRUSHED_CRIMSON_ROOTS = registerSimpleItem("crushed_crimson_roots");
    public static final Holder<Item> CRUSHED_WARPED_ROOTS = registerSimpleItem("crushed_warped_roots");

    public static final Holder<Item> BLAZING_GOLD_INGOT = REGISTER.register("blazing_gold_ingot", () -> new BurningItem(
        60, new Item.Properties().fireResistant()
    ));
    public static final Holder<Item> BLAZING_GOLD_NUGGET = REGISTER.register("blazing_gold_nugget", () -> new BurningItem(
        20, new Item.Properties().fireResistant()
    ));
    public static final Holder<Item> BLAZING_GOLDEN_LOTHUN = REGISTER.register("blazing_golden_lothun", () -> new BurningFoodItem(
        60, new Item.Properties().food(NAFoods.BLAZING_GOLDEN_LOTHUN).fireResistant()
    ));

    public static final Holder<Item> CRIMSON_BERRY = registerSimpleItem("crimson_berry", new Item.Properties().food(NAFoods.CRIMSON_BERRY));
    public static final Holder<Item> WARPED_BERRY = registerSimpleItem("warped_berry", new Item.Properties().food(NAFoods.WARPED_BERRY));
    public static final Holder<Item> LOTHUN = REGISTER.register("lothun", () -> new ItemNameBlockItem(NABlocks.LOTHUNS.value(), new Item.Properties().food(NAFoods.LOTHUN)));
    public static final Holder<Item> SINFUL_EYES = REGISTER.register("sinful_eyes", () -> new ItemNameBlockItem(NABlocks.SINFUL_EYES.value(), new Item.Properties().food(NAFoods.SINFUL_EYES)));
    public static final Holder<Item> MORTOFRUCT_HALF = REGISTER.register("mortofruct_half", () -> new FoodItem(new Item.Properties().food(NAFoods.MORTOFRUCT)));
    public static final Holder<BlockItem> AZURE_MELON = registerSimpleBlockItem(NABlocks.AZURE_MELON);
    public static final Holder<Item> AZURE_MELON_SLICE = registerSimpleItem("azure_melon_slice", new Item.Properties().food(NAFoods.AZURE_MELON_SLICE));

    public static final Holder<Item> BLAZE_FRUIT = REGISTER.register("blaze_fruit", () -> new BurningItem(
        60, new Item.Properties().food(NAFoods.BLAZE_FRUIT).fireResistant()
    ));

    public static final Holder<Item> HOGLIN_MEAT = registerItem("hoglin_meat", FoodItem::new, new Item.Properties().food(NAFoods.HOGLIN_MEAT));
    public static final Holder<Item> COOKED_HOGLIN_MEAT = registerItem("cooked_hoglin_meat", FoodItem::new, new Item.Properties().food(NAFoods.COOKED_HOGLIN_MEAT));
    public static final Holder<Item> STRIDER_LEG = registerItem("strider_leg", FoodItem::new, new Item.Properties().food(NAFoods.STRIDER_LEG).fireResistant());
    public static final Holder<Item> COOKED_STRIDER_LEG = registerItem("cooked_strider_leg", FoodItem::new, new Item.Properties().food(NAFoods.COOKED_STRIDER_LEG).fireResistant());

    public static final Holder<Item> NETHER_BARBECUE_ON_A_STICK = REGISTER.register("nether_barbecue_on_a_stick", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_BARBECUE_ON_A_STICK)
    ));

    public static final Holder<Item> BLAZE_CREAM_SOUP = REGISTER.register("blaze_cream_soup", () -> new BurningFoodItem(
        100,
        new Item.Properties().stacksTo(16).food(NAFoods.BLAZE_CREAM_SOUP).fireResistant()
    ));
    public static final Holder<Item> NETHER_MUSHROOM_STEW = REGISTER.register("nether_mushroom_stew", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_MUSHROOM_STEW)
    ));
    public static final Holder<Item> NETHER_FRUIT_SALAD = REGISTER.register("nether_fruit_salad", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_FRUIT_SALAD)
    ));
    public static final Holder<Item> GLAZED_HOGLIN_MEAT = REGISTER.register("glazed_hoglin_meat", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.GLAZED_HOGLIN_MEAT)
    ));
    public static final Holder<Item> NETHER_PORK_ROAST = REGISTER.register("nether_pork_roast", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_PORK_ROAST)
    ));
    public static final Holder<Item> STRIDER_WITH_VEGETABLES = REGISTER.register("strider_with_vegetables", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.STRIDER_WITH_VEGETABLES)
    ));
    public static final Holder<Item> AZURE_MELON_PUREE = REGISTER.register("azure_melon_puree", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.AZURE_MELON_PUREE)
    ));
    public static final Holder<Item> AZURE_MELON_JELLY = REGISTER.register("azure_melon_jelly", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.AZURE_MELON_JELLY)
    ));
    public static final Holder<Item> NETHER_BERRY_JELLY = REGISTER.register("nether_berry_jelly", () -> new FoodItem(
        new Item.Properties().stacksTo(16).food(NAFoods.NETHER_BERRY_JELLY)
    ));

    public static final Holder<Item> CRIMSON_BERRY_JAM = REGISTER.register("crimson_berry_jam", () -> new JamItem(
        new Item.Properties().stacksTo(16).food(NAFoods.CRIMSON_BERRY_JAM).craftRemainder(Items.GLASS_BOTTLE)
    ));
    public static final Holder<Item> WARPED_BERRY_JAM = REGISTER.register("warped_berry_jam", () -> new JamItem(
        new Item.Properties().stacksTo(16).food(NAFoods.WARPED_BERRY_JAM).craftRemainder(Items.GLASS_BOTTLE)
    ));
    public static final Holder<Item> BLAZING_BLEND = REGISTER.register("blazing_blend", () -> new JamItem(
        new Item.Properties().stacksTo(16).food(NAFoods.BLAZING_BLEND).craftRemainder(Items.GLASS_BOTTLE)
    ));
    public static final Holder<StriderTreatItem> STRIDER_TREAT = REGISTER.register("strider_treat", () -> new StriderTreatItem(
        new Item.Properties().stacksTo(16)
    ));

    public static final Holder<BlockItem> CRIMSON_FARMLAND = registerSimpleBlockItem(NABlocks.CRIMSON_FARMLAND);
    public static final Holder<BlockItem> WARPED_FARMLAND = registerSimpleBlockItem(NABlocks.WARPED_FARMLAND);
    public static final Holder<BlockItem> BLACK_FURNACE = registerSimpleBlockItem(NABlocks.BLACK_FURNACE);
    public static final Holder<BlockItem> DEAD_VINES = registerSimpleBlockItem(NABlocks.DEAD_VINES);
    public static final Holder<BlockItem> MORTOFRUCT = registerSimpleBlockItem(NABlocks.MORTOFRUCT);
    public static final Holder<BlockItem> CRIMSON_BERRY_SPROUTS = registerSimpleBlockItem(NABlocks.CRIMSON_BERRY_SPROUTS);
    public static final Holder<BlockItem> WARPED_BERRY_SPROUTS = registerSimpleBlockItem(NABlocks.WARPED_BERRY_SPROUTS);
    public static final Holder<BlockItem> WILD_LOTHUN = registerSimpleBlockItem(NABlocks.WILD_LOTHUN);
    public static final Holder<BlockItem> WILD_SINFUL_EYES = registerSimpleBlockItem(NABlocks.WILD_SINFUL_EYES);

    public static final Holder<BlockItem> CRIMSON_BERRY_SEEDS = REGISTER.register("crimson_berry_seeds", () -> new ItemNameBlockItem(NABlocks.CRIMSON_BERRY_ROOTS.value(), new Item.Properties()));
    public static final Holder<BlockItem> WARPED_BERRY_SEEDS = REGISTER.register("warped_berry_seeds", () -> new ItemNameBlockItem(NABlocks.WARPED_BERRY_ROOTS.value(), new Item.Properties()));
    public static final Holder<BlockItem> BLAZE_FRUIT_SEED = REGISTER.register("blaze_fruit_seed", () -> new ItemNameBlockItem(NABlocks.BLAZE_FRUIT.value(), new Item.Properties().fireResistant()));
    public static final Holder<BlockItem> AZURE_MELON_SEEDS = REGISTER.register("azure_melon_seeds", () -> new ItemNameBlockItem(NABlocks.AZURE_MELON_STEM.value(), new Item.Properties()));

    public static final Holder<BlockItem> NETHER_ROOTS = registerSimpleBlockItem(NABlocks.NETHER_ROOTS);
    public static final Holder<BlockItem> TALL_CRIMSON_ROOTS = registerBlockItem(NABlocks.TALL_CRIMSON_ROOTS, DoubleHighBlockItem::new);
    public static final Holder<BlockItem> TALL_WARPED_ROOTS = registerBlockItem(NABlocks.TALL_WARPED_ROOTS, DoubleHighBlockItem::new);

    public static final Holder<BlockItem> GLOWING_FUNGUS = registerSimpleBlockItem(NABlocks.GLOWING_FUNGUS);

    public static final Holder<BlockItem> CRIMSON_CRATE = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE);
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE);
    public static final Holder<BlockItem> WARPED_CRATE = registerSimpleBlockItem(NABlocks.WARPED_CRATE);
    public static final Holder<BlockItem> SMALL_WARPED_CRATE = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE);
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_CRIMSON_BERRIES);
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES);
    public static final Holder<BlockItem> WARPED_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_CRIMSON_BERRIES);
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES);
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_WARPED_BERRIES = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_WARPED_BERRIES);
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES);
    public static final Holder<BlockItem> WARPED_CRATE_OF_WARPED_BERRIES = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_WARPED_BERRIES);
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_WARPED_BERRIES = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_WARPED_BERRIES);
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_LOTHUN = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_LOTHUN);
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_LOTHUN = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_LOTHUN);
    public static final Holder<BlockItem> WARPED_CRATE_OF_LOTHUN = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_LOTHUN);
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_LOTHUN = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_LOTHUN);
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_BLAZE_FRUIT = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_BLAZE_FRUIT, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> WARPED_CRATE_OF_BLAZE_FRUIT = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_BLAZE_FRUIT, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_BLAZE_FRUIT = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_BLAZE_FRUIT, new Item.Properties().fireResistant());
    public static final Holder<BlockItem> CRIMSON_CRATE_OF_SINFUL_EYES = registerSimpleBlockItem(NABlocks.CRIMSON_CRATE_OF_SINFUL_EYES);
    public static final Holder<BlockItem> SMALL_CRIMSON_CRATE_OF_SINFUL_EYES = registerSimpleBlockItem(NABlocks.SMALL_CRIMSON_CRATE_OF_SINFUL_EYES);
    public static final Holder<BlockItem> WARPED_CRATE_OF_SINFUL_EYES = registerSimpleBlockItem(NABlocks.WARPED_CRATE_OF_SINFUL_EYES);
    public static final Holder<BlockItem> SMALL_WARPED_CRATE_OF_SINFUL_EYES = registerSimpleBlockItem(NABlocks.SMALL_WARPED_CRATE_OF_SINFUL_EYES);



    public static Holder<Item> registerSimpleItem(String name, Item.Properties properties)
    {
        return registerItem(name, Item::new, properties);
    }
    
    public static Holder<Item> registerSimpleItem(String name)
    {
        return registerItem(name, Item::new, new Item.Properties());
    }

    public static Holder<BlockItem> registerSimpleBlockItem(Holder<? extends Block> block)
    {
        return registerSimpleBlockItem(block, new Item.Properties());
    }

    public static Holder<BlockItem> registerSimpleBlockItem(Holder<? extends Block> block, Item.Properties properties)
    {
        return registerBlockItem(block, BlockItem::new, properties);
    }

    public static <T extends BlockItem, B extends Block> Holder<T> registerBlockItem(Holder<B> block, BiFunction<B, Item.Properties, T> constructor)
    {
        return registerBlockItem(block, constructor, new Item.Properties());
    }

    public static <T extends BlockItem, B extends Block> Holder<T> registerBlockItem(Holder<B> block, BiFunction<B, Item.Properties, T> constructor, Item.Properties properties)
    {
        return registerItem(blockName(block), (propertiesIn) -> constructor.apply(block.value(), propertiesIn), properties);
    }

    public static String blockName(Holder<? extends Block> block)
    {
        return block.unwrapKey().orElseThrow().location().getPath();
    }

    public static <T extends Item> Holder<T> registerItem(String name, Function<Item.Properties, T> constructor)
    {
        return registerItem(name, constructor, new Item.Properties());
    }

    public static <T extends Item> Holder<T> registerItem(String name, Function<Item.Properties, T> constructor, Item.Properties properties)
    {
        return REGISTER.register(name, () -> constructor.apply(properties));
    }

    public static void initialize() {}
}
