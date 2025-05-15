package ru.netherdon.netheragriculture.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import ru.netherdon.netheragriculture.items.properties.FoodHelper;

import java.util.List;

public class BurningFoodItem extends BurningItem
{
    public BurningFoodItem(int fireTicks, Properties properties)
    {
        super(fireTicks, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        FoodHelper.appendTooltip(stack, context, tooltipComponents, tooltipFlag);
    }
}
