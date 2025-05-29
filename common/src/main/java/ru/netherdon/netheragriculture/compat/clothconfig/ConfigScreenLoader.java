package ru.netherdon.netheragriculture.compat.clothconfig;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.compat.OtherModNames;
import ru.netherdon.netheragriculture.services.ModLoaderService;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class ConfigScreenLoader
{
    @Nullable
    public static Function<Screen, Screen> get()
    {
        if (ModLoaderService.anyModLoaded(OtherModNames.CLOTH_CONFIG_FABRIC, OtherModNames.CLOTH_CONFIG_NEOFORGE))
        {
            return ConfigScreenBuilder::build;
        }

        return null;
    }
}
