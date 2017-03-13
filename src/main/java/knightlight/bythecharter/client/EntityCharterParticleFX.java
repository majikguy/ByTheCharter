package knightlight.bythecharter.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;

/**
 * A floating Charter Mark particle
 * @author Majikguy
 */
public class EntityCharterParticleFX extends Particle {

	protected EntityCharterParticleFX(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double speedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, speedIn);

		this.particleAlpha = 0.3F;
		this.particleRed = 1.0F;
		this.particleGreen = 1.0F;
		this.particleBlue = 0.0F;
		this.canCollide = false;
		this.particleScale *= this.rand.nextFloat() * 0.1F + 0.15F;
		this.motionX *= 0.019999999552965164D;
		this.motionY *= 0.019999999552965164D;
		this.motionZ *= 0.019999999552965164D;
		this.particleMaxAge = (int) (10.0D / (Math.random() * 0.4D + 0.1D));

		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks()
				.getAtlasSprite("bythecharter:misc/mark" + (int) (Math.random() * 3));
		setParticleTexture(sprite);
	}

	// Makes sure that the particle does not get hidden behind other rendered objects
	@Override
	public int getFXLayer() {
		return 1;
	}
//
//	// Different than this.particleAlpha, not actually used to draw the particle.
//	// This is set to 1.0F to prevent water or other transparent objects from rendering in front of it
//	@Override
//	public float getAlpha() {
//		return 1.0F;
//	}

	// Set to return the maximum brightness so that the marks are always glowing
	@Override
	public int getBrightnessForRender(float partialTick) {
		final int FULL_BRIGHTNESS_VALUE = 0xf000f0;
		return FULL_BRIGHTNESS_VALUE;
	}

}
