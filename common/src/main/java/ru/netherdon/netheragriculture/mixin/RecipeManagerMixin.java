package ru.netherdon.netheragriculture.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.netherdon.netheragriculture.compat.OtherModNames;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin
{
    @Unique
    private static final Set<String> NA$MYNETHERSDELIGHT_RECIPES = ImmutableSet.of(
        "hoglin_loin_cooking", "hoglin_loin_from_campfire_cooking", "hoglin_loin_from_smoking",
        "hoglin_sausage_cooking", "hoglin_sausage_from_campfire_cooking", "hoglin_sausage_from_smoking",
        "boiled_egg_cooking", "boiled_egg_from_campfire_cooking", "boiled_egg_from_smoking"
    );

    @Inject(
        method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
        at = @At("HEAD")
    )
    public void removeRecipes(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfo ci)
    {
        na$removeRecipesFor(OtherModNames.MY_NETHERS_DELIGHT, map, NA$MYNETHERSDELIGHT_RECIPES);
    }
    @Unique
    private static void na$removeRecipesFor(String modId, Map<ResourceLocation, JsonElement> map, Collection<String> recipeIds)
    {
        for (String recipeId : recipeIds)
        {
            map.remove(ResourceLocation.fromNamespaceAndPath(modId,recipeId));
        }
    }
}
