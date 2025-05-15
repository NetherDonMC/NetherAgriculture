package ru.netherdon.netheragriculture.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class DrinkItem extends Item
{
    public DrinkItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        super.finishUsingItem(stack, level, entityLiving);
        if (entityLiving instanceof ServerPlayer serverplayer)
        {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        this.onDrank(stack, level, entityLiving);

        if (stack.isEmpty())
        {
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        else
        {
            if (entityLiving instanceof Player player && !player.hasInfiniteMaterials())
            {
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemstack))
                {
                    player.drop(itemstack, false);
                }
            }
            return stack;
        }
    }

    protected void onDrank(ItemStack stack, Level level, LivingEntity entity)
    {

    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity)
    {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound()
    {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound()
    {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
