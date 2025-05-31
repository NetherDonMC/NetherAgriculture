package ru.netherdon.netheragriculture.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ru.netherdon.netheragriculture.events.BlockEventHandler;

import java.util.Map;
import java.util.function.Predicate;

@Mixin(HoeItem.class)
public class HoeItemMixin
{
    @Redirect(method = "useOn", at = @At(value = "INVOKE", target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;"))
    public Object tillNylium(Map<Object, Object> instance, Object object, @Local(argsOnly = true) UseOnContext useOnContext)
    {
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        BlockState state = level.getBlockState(pos);
        BlockState newState = BlockEventHandler.hoeTill(state);
        if (newState != null)
        {
            return Pair.of(
                (Predicate<UseOnContext>)(context) -> true,
                HoeItem.changeIntoState(newState)
            );
        }

        return instance.get(object);
    }
}
