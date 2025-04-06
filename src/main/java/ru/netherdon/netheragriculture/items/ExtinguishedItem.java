package ru.netherdon.netheragriculture.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExtinguishedItem extends Item
{
    public final Supplier<Item> burningItem;

    public ExtinguishedItem(Supplier<Item> burningItem, Properties properties)
    {
        super(properties);
        this.burningItem = burningItem;
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity)
    {
        if (entity.isInLava())
        {
            entity.setItem(stack.transmuteCopy(this.burningItem.get()));
        }

        return super.onEntityItemUpdate(stack, entity);
    }
}
