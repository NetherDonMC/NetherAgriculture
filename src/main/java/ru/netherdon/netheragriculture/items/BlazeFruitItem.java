package ru.netherdon.netheragriculture.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlazeFruitItem extends BurningFoodItem
{
    private final Supplier<Item> extinguishItem;

    public BlazeFruitItem(Supplier<Item> extinguishItem, Properties properties)
    {
        super(60, properties);
        this.extinguishItem = extinguishItem;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType)
    {
        return 2000;
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity)
    {
        if (entity.isInWater())
        {
            ItemStack newStack = stack.transmuteCopy(this.extinguishItem.get());
            entity.setItem(newStack);
            entity.level().playSound(
                null, entity.getOnPos(),
                SoundEvents.FIRE_EXTINGUISH, SoundSource.HOSTILE,
                0.7f, 1.0f
            );
        }

        return super.onEntityItemUpdate(stack, entity);
    }
}
