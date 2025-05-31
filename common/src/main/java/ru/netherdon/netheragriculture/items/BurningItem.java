package ru.netherdon.netheragriculture.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import ru.netherdon.netheragriculture.config.NAServerConfig;
import ru.netherdon.netheragriculture.services.EntityService;

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
            && !EntityService.isImmuneToFire(entity)
            && entity.getRemainingFireTicks() <= 0
            && NAServerConfig.get().entity.isBurningFromItemEnabled()
        )
        {
            entity.igniteForTicks(this.getFireTicks());
        }
    }

    public int getFireTicks()
    {
        return this.fireTicks;
    }
}
