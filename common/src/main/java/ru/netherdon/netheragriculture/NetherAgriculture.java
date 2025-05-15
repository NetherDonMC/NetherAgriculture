package ru.netherdon.netheragriculture;

import net.minecraft.resources.ResourceLocation;
import ru.netherdon.netheragriculture.registries.*;

public class NetherAgriculture
{
    public static final String ID = "netheragriculture";

    public static void initialize()
    {
        NABlocks.initialize();
        NABlockTypes.initialize();
        NAMobEffects.initialize();
        NAItems.initialize();
        NACreativeTabs.initialize();
        NARecipeSerializers.initialize();
        NABlockEntityTypes.initialize();
        NAMenuTypes.initialize();
        NARecipeTypes.initialize();
    }

    public static ResourceLocation location(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

}
