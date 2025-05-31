package ru.netherdon.netheragriculture.fabric.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.netherdon.netheragriculture.registries.NAMobEffects;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player
{
    public ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile)
    {
        super(level, blockPos, f, gameProfile);
    }

    @Inject(method = "onEffectRemoved", at = @At("HEAD"))
    public void blazeFlightRemoved(MobEffectInstance mobEffectInstance, CallbackInfo ci)
    {
        if (!this.isSpectator() && !this.isCreative() && mobEffectInstance.is(NAMobEffects.BLAZE_FLIGHT))
        {
            Abilities abilities = this.getAbilities();
            abilities.mayfly = false;
            abilities.flying = false;
            this.onUpdateAbilities();
        }
    }

    @Shadow
    public abstract void onUpdateAbilities();
    @Shadow
    public abstract boolean isCreative();
    @Shadow
    public abstract boolean isSpectator();
}
