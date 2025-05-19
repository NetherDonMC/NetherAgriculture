package ru.netherdon.netheragriculture.items.properties;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class FoodHelper
{
    public static void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        FoodProperties food = stack.get(DataComponents.FOOD);
        if (food != null)
        {
            appendTooltip(food, context, tooltipComponents, tooltipFlag);
        }
    }

    public static void appendTooltip(FoodProperties food, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        for (FoodProperties.PossibleEffect effect : food.effects())
        {
            Component text = createEffectTooltip(effect.effect(), effect.probability(), context, tooltipFlag);
            tooltipComponents.add(text);
        }
    }

    public static Component createEffectTooltip(MobEffectInstance effectInstance, float probability, Item.TooltipContext context, TooltipFlag tooltipFlag)
    {
        MutableComponent prefix = Component.empty();
        if (probability != 1f)
        {
            prefix = Component.literal("*");
        }

        ChatFormatting formatting = effectInstance.getEffect().value().getCategory().getTooltipFormatting();

        MutableComponent name = Component.translatable(effectInstance.getDescriptionId());
        if (effectInstance.getAmplifier() > 0)
        {
            name = Component.translatable(
                "potion.withAmplifier", name, Component.translatable("potion.potency." + effectInstance.getAmplifier())
            );
        }

        if (!effectInstance.endsWithin(20))
        {
            name = Component.translatable(
                "potion.withDuration", name, MobEffectUtil.formatDuration(effectInstance, 1f, context.tickRate())
            );
        }

        MutableComponent component = prefix.append(name).withStyle(formatting);
        if (tooltipFlag.isAdvanced())
        {
            int i = Math.round(probability * 100);
            MutableComponent probabilityText = Component.literal(" [" + i + "%]").withStyle(ChatFormatting.DARK_GRAY);
            component.append(probabilityText);
        }

        return component;
    }
}
