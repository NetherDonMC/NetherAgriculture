package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import ru.netherdon.netheragriculture.blocks.entities.BlackFurnaceBlockEntity;
import ru.netherdon.netheragriculture.blocks.entities.CustomHangingSignBlockEntity;
import ru.netherdon.netheragriculture.blocks.entities.CustomSignBlockEntity;
import ru.netherdon.netheragriculture.services.RegistryManager;

public final class NABlockEntityTypes
{
    public static final IRegistryProvider<BlockEntityType<?>> REGISTER = RegistryManager.getOrCreate(BuiltInRegistries.BLOCK_ENTITY_TYPE);

    public static final Holder<BlockEntityType<BlackFurnaceBlockEntity>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> BlockEntityType.Builder.of(BlackFurnaceBlockEntity::new, NABlocks.BLACK_FURNACE.value()).build(null));

    public static final Holder<BlockEntityType<CustomSignBlockEntity>> CUSTOM_SIGN =
        REGISTER.register("sign", () ->
            BlockEntityType.Builder.of(
                CustomSignBlockEntity::new,
                NABlocks.GLOWING_SIGN.value(),
                NABlocks.GLOWING_WALL_SIGN.value()
            ).build(null)
        );

    public static final Holder<BlockEntityType<CustomHangingSignBlockEntity>> HANGING_CUSTOM_SIGN =
        REGISTER.register("hanging_sign", () ->
            BlockEntityType.Builder.of(
                CustomHangingSignBlockEntity::new,
                NABlocks.GLOWING_HANGING_SIGN.value(),
                NABlocks.GLOWING_WALL_HANGING_SIGN.value()
            ).build(null)
        );



    public static void initialize() {}
}
