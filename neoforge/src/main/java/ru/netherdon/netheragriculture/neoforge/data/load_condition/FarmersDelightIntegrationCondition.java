package ru.netherdon.netheragriculture.neoforge.data.load_condition;

import com.mojang.serialization.MapCodec;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.conditions.ICondition;
import ru.netherdon.netheragriculture.compat.OtherModNames;
import ru.netherdon.netheragriculture.config.NACommonConfig;

public class FarmersDelightIntegrationCondition implements ICondition
{
    public static final MapCodec<FarmersDelightIntegrationCondition> CODEC =
        MapCodec.unit(new FarmersDelightIntegrationCondition());

    @Override
    public boolean test(IContext context)
    {
        return !ModList.get().isLoaded(OtherModNames.FARMERS_DELIGHT)
            || !NACommonConfig.get().modCompatibility.farmersDelight().isFullRecipeIntegrationEnabled();
    }

    @Override
    public MapCodec<? extends ICondition> codec()
    {
        return CODEC;
    }
}
