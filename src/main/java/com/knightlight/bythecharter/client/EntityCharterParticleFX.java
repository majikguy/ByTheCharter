package com.knightlight.bythecharter.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;

public class EntityCharterParticleFX extends EntityFX {

	protected EntityCharterParticleFX(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double speedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, speedIn);

		this.particleAlpha = 0.3F;
		this.particleRed = 1.0F;
		this.particleGreen = 1.0F;
		this.particleBlue = 0.0F;
		this.noClip = true;
		this.particleScale *= this.rand.nextFloat() * 0.1F + 0.15F;
		this.motionX *= 0.019999999552965164D;
		this.motionY *= 0.019999999552965164D;
		this.motionZ *= 0.019999999552965164D;
		this.particleMaxAge = (int) (10.0D / (Math.random() * 0.4D + 0.1D));

		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks()
				.getAtlasSprite("bythecharter:misc/mark" + (int) (Math.random() * 3));
		setParticleIcon(sprite);
	}

	@Override
	public int getFXLayer() {
		return 1;
	}

	@Override
	public float getAlpha() {
		return 1.0F;
	}

	@Override
	public int getBrightnessForRender(float partialTick) {
		final int FULL_BRIGHTNESS_VALUE = 0xf000f0;
		return FULL_BRIGHTNESS_VALUE;
	}

}
