package ru.netherdon.netheragriculture.fabric.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import ru.netherdon.netheragriculture.compat.clothconfig.ConfigScreenLoader;

public class NAModMenuPlugin implements ModMenuApi
{
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        final var configScreenLoader = ConfigScreenLoader.get();
        if (configScreenLoader == null)
        {
            return null;
        }
        return configScreenLoader::apply;
    }
}
