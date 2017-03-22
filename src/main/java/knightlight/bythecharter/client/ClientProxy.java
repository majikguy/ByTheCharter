package knightlight.bythecharter.client;

import knightlight.bythecharter.client.events.ClientTickHandler;
import knightlight.bythecharter.client.events.EventHandlerKeyInput;
import knightlight.bythecharter.client.events.EventHandlerTextureStitch;
import knightlight.bythecharter.client.fx.EntityCharterParticleFX;
import knightlight.bythecharter.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Class that handles Client-Specific code
 * @author Majikguy
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
		// Sets up the keybindings
		KeybindHandler.init();
		
		// Register the texture stitcher so that my textures can be loaded
		MinecraftForge.EVENT_BUS.register(new EventHandlerTextureStitch());
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		// Register EventHandlers
		MinecraftForge.EVENT_BUS.register(new EventHandlerKeyInput());
		MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	/**
	 * Generates a Charter-Mark particle effect surrounding an Entity
	 * @param entity - the Entity to spawn the particle around
	 */
	@Override
	public void generateCharterParticle(Entity entity) {
		
		if(entity == null) return;
		
		double motionX = entity.motionX + entity.world.rand.nextGaussian() + 0.02D;
		double motionY = entity.motionY + entity.world.rand.nextGaussian() + 0.02D;
		double motionZ = entity.motionZ + entity.world.rand.nextGaussian() + 0.02D;
		
		Particle particle = new EntityCharterParticleFX(
													entity.world,
													entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
													entity.posY + entity.world.rand.nextFloat() * entity.height * 2.0F - entity.height,
													entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
													motionX,
													motionY,
													motionZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}
	
	/**
	 * Gets the EntityPlayer object of the client player.
	 * @return EntityPlayer - The EntityPlayer object of the client player
	 */
	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().player;
	}

}
