package ru.netherdon.netheragriculture.fabric.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.netherdon.netheragriculture.events.BlockEventHandler;

@Mixin(BoneMealItem.class)
public class BoneMealItemMixin
{
    @Inject(method = "growCrop", at = @At("HEAD"), cancellable = true)
    private static void growNetherRoots(ItemStack stack, Level level, BlockPos pos, CallbackInfoReturnable<Boolean> cir)
    {
        BlockState state = level.getBlockState(pos);
        if (BlockEventHandler.applyBoneMeal(state, level, pos, stack))
        {
            cir.setReturnValue(true);
        }
    }
}
