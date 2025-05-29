package ru.netherdon.netheragriculture.compat.clothconfig;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class ConfigPermission
{
    public static final ConfigPermission ALL = new ConfigPermission(null);

    @Nullable
    private final Minecraft minecraft;

    private ConfigPermission(@Nullable Minecraft minecraft)
    {
        this.minecraft = minecraft;
    }

    public boolean levelLoaded()
    {
        return minecraft == null || minecraft.level != null;
    }

    public boolean isSingleplayer()
    {
        return minecraft == null || minecraft.isSingleplayer();
    }

    public boolean entryAvailable()
    {
        return this.levelLoaded() && this.isSingleplayer();
    }

    public static ConfigPermission server(@NotNull Minecraft minecraft)
    {
        return new ConfigPermission(Objects.requireNonNull(minecraft));
    }
}
