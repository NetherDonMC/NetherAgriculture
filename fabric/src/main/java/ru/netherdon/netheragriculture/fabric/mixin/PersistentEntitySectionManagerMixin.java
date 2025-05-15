package ru.netherdon.netheragriculture.fabric.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.netherdon.netheragriculture.events.EntityEventHandler;

@Mixin(PersistentEntitySectionManager.class)
public class PersistentEntitySectionManagerMixin<T extends EntityAccess>
{
    @Inject(method = "addEntity", at = @At("HEAD"))
    private void spawn(T entityAccess, boolean bl, CallbackInfoReturnable<Boolean> cir)
    {
        if (entityAccess instanceof Entity entity)
        {
            EntityEventHandler.spawn(entity);
        }
    }
}
