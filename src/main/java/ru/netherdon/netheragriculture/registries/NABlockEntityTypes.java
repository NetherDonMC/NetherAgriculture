package ru.netherdon.netheragriculture.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.netherdon.netheragriculture.NetherAgriculture;
import ru.netherdon.netheragriculture.blocks.entities.BlackFurnaceBlockEntity;

public final class NABlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> REGISTER =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, NetherAgriculture.ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackFurnaceBlockEntity>> BLACK_FURNACE =
        REGISTER.register("black_furnace", () -> BlockEntityType.Builder.of(BlackFurnaceBlockEntity::new, NABlocks.BLACK_FURNACE.get()).build(null));
}
