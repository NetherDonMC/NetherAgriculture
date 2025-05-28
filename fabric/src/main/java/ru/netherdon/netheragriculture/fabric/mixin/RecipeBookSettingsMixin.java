package ru.netherdon.netheragriculture.fabric.mixin;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.netherdon.netheragriculture.fabric.registries.NARecipeBookTypes;

import java.util.Map;

@Mixin(RecipeBookSettings.class)
public abstract class RecipeBookSettingsMixin
{
    @Final
    @Mutable
    @Shadow
    private static Map<RecipeBookType, Pair<String, String>> TAG_FIELDS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyTagFields(CallbackInfo ci)
    {
        ImmutableMap.Builder<RecipeBookType, Pair<String, String>> builder = ImmutableMap.builder();
        builder.putAll(TAG_FIELDS);
        builder.put(NARecipeBookTypes.BLACK_FURNACE, Pair.of(
            "isNetherAgricultureBlackFurnaceGuiOpen",
            "isNetherAgricultureBlackFurnaceFilteringCraftable"
        ));
        TAG_FIELDS = builder.build();
    }
}
