package ru.netherdon.netheragriculture.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BurningItem extends Item
{
    private final int fireTicks;

    public BurningItem(int fireTicks, Properties properties)
    {
        super(properties);
        this.fireTicks = fireTicks;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected)
    {
        if (
            (isSelected || slotId == Inventory.SLOT_OFFHAND)
            && !isEntityImmuneToFire(entity) && entity.getRemainingFireTicks() <= 0
        )
        {
            entity.igniteForTicks(this.getFireTicks());
        }
    }

    public int getFireTicks()
    {
        return this.fireTicks;
    }

    private static boolean isEntityImmuneToFire(Entity entity)
    {
        return entity instanceof Player player
            && player.getAbilities().invulnerable
            || entity.fireImmune()
            || entity.isInWater();
    }
}
