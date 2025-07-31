package ru.netherdon.netheragriculture.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class GlowingSporesInBottleItem extends BlockItem
{
    private final Item container;

    public GlowingSporesInBottleItem(Block block, Item container, Properties properties)
    {
        super(block, properties);
        this.container = container;
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        InteractionResult interactionResult = super.useOn(context);
        Player player = context.getPlayer();
        if (interactionResult.consumesAction() && player != null && !player.hasInfiniteMaterials())
        {
            ItemStack emptyStack = new ItemStack(this.container);
            if (player.getItemInHand(context.getHand()).isEmpty())
            {
                player.setItemInHand(context.getHand(), emptyStack);
            }
            else if (!player.getInventory().add(emptyStack))
            {
                player.drop(emptyStack, true);
            }
        }

        return interactionResult;
    }

    @Override
    public String getDescriptionId()
    {
        return this.getOrCreateDescriptionId();
    }
}
