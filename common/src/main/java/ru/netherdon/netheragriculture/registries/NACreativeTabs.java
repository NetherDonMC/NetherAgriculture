package ru.netherdon.netheragriculture.registries;

import com.google.common.collect.Maps;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import org.apache.commons.compress.utils.Lists;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.services.RegistryManager;

import java.util.List;
import java.util.Map;

public final class NACreativeTabs
{
    public static final IRegistryProvider<CreativeModeTab> REGISTRY = RegistryManager.getOrCreate(BuiltInRegistries.CREATIVE_MODE_TAB);

    public static final Holder<CreativeModeTab> COMMON = REGISTRY.register("common", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
        .title(Component.translatable("itemGroup." + NetherAgriculture.ID + ".common"))
        .icon(() -> NAItems.CRIMSON_BERRY.value().getDefaultInstance())
        .displayItems((params, output) ->
        {
            output.accept(NAItems.BLACK_FURNACE.value());

            output.accept(NAItems.CRIMSON_FARMLAND.value());
            output.accept(NAItems.WARPED_FARMLAND.value());
            output.accept(NAItems.NETHER_ROOTS.value());
            output.accept(NAItems.TALL_CRIMSON_ROOTS.value());
            output.accept(NAItems.TALL_WARPED_ROOTS.value());

            output.accept(NAItems.CRIMSON_CRATE.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.CRIMSON_CRATE_OF_SINFUL_EYES.value());
            output.accept(NAItems.SMALL_CRIMSON_CRATE_OF_SINFUL_EYES.value());

            output.accept(NAItems.WARPED_CRATE.value());
            output.accept(NAItems.SMALL_WARPED_CRATE.value());
            output.accept(NAItems.WARPED_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.WARPED_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.WARPED_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.WARPED_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.WARPED_CRATE_OF_SINFUL_EYES.value());
            output.accept(NAItems.SMALL_WARPED_CRATE_OF_SINFUL_EYES.value());

            output.accept(NAItems.GLOWING_FUNGUS.value());
            output.accept(NAItems.GLOWING_WART_BLOCK.value());
            output.accept(NAItems.GLOWING_STEM.value());
            output.accept(NAItems.GLOWING_HYPHAE.value());
            output.accept(NAItems.STRIPPED_GLOWING_STEM.value());
            output.accept(NAItems.STRIPPED_GLOWING_HYPHAE.value());
            output.accept(NAItems.GLOWING_PLANKS.value());
            output.accept(NAItems.GLOWING_STAIRS.value());
            output.accept(NAItems.GLOWING_SLAB.value());
            output.accept(NAItems.GLOWING_FENCE.value());
            output.accept(NAItems.GLOWING_FENCE_GATE.value());
            output.accept(NAItems.GLOWING_DOOR.value());
            output.accept(NAItems.GLOWING_TRAPDOOR.value());
            output.accept(NAItems.GLOWING_PRESSURE_PLATE.value());
            output.accept(NAItems.GLOWING_BUTTON.value());
            output.accept(NAItems.GLOWING_SIGN.value());
            output.accept(NAItems.GLOWING_HANGING_SIGN.value());

            output.accept(NAItems.GLOWING_CRATE.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE.value());
            output.accept(NAItems.GLOWING_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_CRIMSON_BERRIES.value());
            output.accept(NAItems.GLOWING_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_WARPED_BERRIES.value());
            output.accept(NAItems.GLOWING_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_LOTHUN.value());
            output.accept(NAItems.GLOWING_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.GLOWING_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_BLAZE_FRUIT.value());
            output.accept(NAItems.GLOWING_CRATE_OF_SINFUL_EYES.value());
            output.accept(NAItems.SMALL_GLOWING_CRATE_OF_SINFUL_EYES.value());

            output.accept(NAItems.CRUSHED_NETHER_ROOTS.value());
            output.accept(NAItems.CRUSHED_CRIMSON_ROOTS.value());
            output.accept(NAItems.CRUSHED_WARPED_ROOTS.value());

            output.accept(NAItems.BLAZING_GOLD_INGOT.value());
            output.accept(NAItems.BLAZING_GOLD_NUGGET.value());

            output.accept(NAItems.CRIMSON_BERRY_SEEDS.value());
            output.accept(NAItems.CRIMSON_BERRY_SPROUTS.value());
            output.accept(NAItems.CRIMSON_BERRY.value());
            output.accept(NAItems.WARPED_BERRY_SEEDS.value());
            output.accept(NAItems.WARPED_BERRY_SPROUTS.value());
            output.accept(NAItems.WARPED_BERRY.value());
            output.accept(NAItems.WILD_LOTHUN.value());
            output.accept(NAItems.LOTHUN.value());
            output.accept(NAItems.BLAZING_GOLDEN_LOTHUN.value());
            output.accept(NAItems.WILD_SINFUL_EYES.value());
            output.accept(NAItems.SINFUL_EYES.value());
            output.accept(NAItems.DEAD_VINES.value());
            output.accept(NAItems.MORTOFRUCT.value());
            output.accept(NAItems.MORTOFRUCT_HALF.value());
            output.accept(NAItems.AZURE_MELON_SEEDS.value());
            output.accept(NAItems.AZURE_MELON.value());
            output.accept(NAItems.AZURE_MELON_SLICE.value());
            output.accept(NAItems.BLAZE_FRUIT_SEED.value());
            output.accept(NAItems.BLAZE_FRUIT.value());
            output.accept(NAItems.HOGLIN_MEAT.value());
            output.accept(NAItems.COOKED_HOGLIN_MEAT.value());
            output.accept(NAItems.STRIDER_LEG.value());
            output.accept(NAItems.COOKED_STRIDER_LEG.value());

            output.accept(NAItems.CRIMSON_BERRY_JAM.value());
            output.accept(NAItems.WARPED_BERRY_JAM.value());
            output.accept(NAItems.BLAZING_BLEND.value());

            output.accept(NAItems.NETHER_BARBECUE_ON_A_STICK.value());
            output.accept(NAItems.NETHER_MUSHROOM_STEW.value());
            output.accept(NAItems.NETHER_FRUIT_SALAD.value());
            output.accept(NAItems.AZURE_MELON_PUREE.value());
            output.accept(NAItems.BLAZE_CREAM_SOUP.value());
            output.accept(NAItems.NETHER_PORK_ROAST.value());
            output.accept(NAItems.STRIDER_WITH_VEGETABLES.value());
            output.accept(NAItems.GLAZED_HOGLIN_MEAT.value());
            output.accept(NAItems.AZURE_MELON_JELLY.value());
            output.accept(NAItems.NETHER_BERRY_JELLY.value());

            output.accept(NAItems.STRIDER_TREAT.value());

            acceptPotionStacks(output, NAPotions.WARP, NAPotions.BLAZE_FLIGHT);
        })
        .build()
    );

    @SafeVarargs
    private static void acceptPotionStacks(CreativeModeTab.Output output, Holder<Potion>... potions)
    {
        Map<Item, List<ItemStack>> potionStacks = Maps.newLinkedHashMap();
        potionStacks.put(Items.POTION, Lists.newArrayList());
        potionStacks.put(Items.SPLASH_POTION, Lists.newArrayList());
        potionStacks.put(Items.LINGERING_POTION, Lists.newArrayList());
        potionStacks.put(Items.TIPPED_ARROW, Lists.newArrayList());

        for (Holder<Potion> potion : potions)
        {
            for (var entry : potionStacks.entrySet())
            {
                entry.getValue().add(
                    PotionContents.createItemStack(entry.getKey(), potion)
                );
            }
        }

        potionStacks.values().forEach(output::acceptAll);
    }

    public static void initialize() {}
}
