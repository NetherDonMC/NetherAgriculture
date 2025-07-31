package ru.netherdon.netheragriculture.client.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import ru.netherdon.netheragriculture.blocks.GlowingSporesBlock;
import ru.netherdon.netheragriculture.registries.NABlocks;

@Environment(EnvType.CLIENT)
public class GlowingSporesBlockMarker extends TextureSheetParticle implements ISourcedParticle
{
    private final BlockPos sourcePos;
    private final GlowingSporesBlock sourceBlock;

    protected GlowingSporesBlockMarker(ClientLevel level, GlowingSporesBlock sourceBlock, SpriteSet sprites, double x, double y, double z)
    {
        super(level, x, y, z);
        this.pickSprite(sprites);
        this.sourceBlock = sourceBlock;
        this.gravity = 0f;
        this.lifetime = 80;
        this.hasPhysics = false;
        this.sourcePos = BlockPos.containing(x, y, z);
    }

    @Override
    public BlockPos getSourcePos()
    {
        return this.sourcePos;
    }

    @Override
    public void sourceChanged(BlockState newState)
    {
        if (!newState.is(NABlocks.GLOWING_SPORES.value()))
        {
            this.remove();
        }
    }

    @Override
    public void tick()
    {
        if (this.isAlive())
        {
            ItemStack stack = Minecraft.getInstance().player.getMainHandItem();
            if (!this.sourceBlock.canInteractWith(stack))
            {
                this.remove();
            }
        }
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public float getQuadSize(float f)
    {
        return 0.5f;
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites)
        {
            this.sprites = sprites;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType options, ClientLevel level, double x, double y, double z, double dx, double dy, double dz)
        {
            return new GlowingSporesBlockMarker(level, NABlocks.GLOWING_SPORES.value(), this.sprites, x, y, z);
        }
    }
}
