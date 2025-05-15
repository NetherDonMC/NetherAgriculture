package ru.netherdon.netheragriculture.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class JamItem extends DrinkItem
{
    public JamItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public SoundEvent getDrinkingSound()
    {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getEatingSound()
    {
        return SoundEvents.HONEY_DRINK;
    }
}
