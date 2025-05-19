package ru.netherdon.netheragriculture.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.util.Lazy;
import ru.netherdon.netheragriculture.items.properties.FoodHelper;
import ru.netherdon.netheragriculture.registries.NAMobEffects;

import java.util.List;

public class StriderTreatItem extends Item
{
    private static final Lazy<List<MobEffectInstance>> EFFECTS = Lazy.lazy(() -> List.of(
        new MobEffectInstance(NAMobEffects.INTERNAL_HEAT, 6000, 0),
        new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0),
        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0)
    ));

    public StriderTreatItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag tooltipFlag)
    {
        super.appendHoverText(itemStack, tooltipContext, tooltip, tooltipFlag);
        tooltip.add(Component.translatable(this.getDescriptionId() + ".description").withStyle(ChatFormatting.GRAY));
        for (var effect : EFFECTS.get())
        {
            Component effectText = Component.literal(" ").append(
                FoodHelper.createEffectTooltip(effect, 1f, tooltipContext, tooltipFlag)
            );
            tooltip.add(effectText);
        }
    }

    public void feedStrider(ItemStack stack, Level level, Strider strider, Player player)
    {
        if (!level.isClientSide)
        {
            for (var effect : EFFECTS.get())
            {
                MobEffectInstance effectCopy = new MobEffectInstance(effect);
                strider.addEffect(effectCopy);
            }
        }

        stack.consume(1, player);
    }

    public static InteractionResult mobInteract(ItemStack stack, Level level, Entity entity, Player player)
    {
        if (stack.getItem() instanceof StriderTreatItem treatItem && entity instanceof Strider strider)
        {
            treatItem.feedStrider(stack, level, strider, player);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
