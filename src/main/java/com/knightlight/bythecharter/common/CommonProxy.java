package com.knightlight.bythecharter.common;

import com.knightlight.bythecharter.common.events.EventHandlerDeath;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Class that handles anything that needs to be done on both the client and server
 * ClientProxy and ServerProxy extend this class in order to handle things specific to their sides of the mod
 * @author Majikguy
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		// Nothing so far
	}
	
	public void init(FMLInitializationEvent e) {
		// Register Common EventHandlers 
		MinecraftForge.EVENT_BUS.register(new EventHandlerDeath());
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		// Nothing so far
	}
	
	/**
	 * Generates a Charter-Mark particle effect surrounding an Entity
	 * Does not need to do anything on the Server, so it is empty in CommonProxy
	 * @param entity - the Entity to spawn the particle around
	 */
	public void generateCharterParticle(Entity entity) {
		// Does nothing here, only acts on the client
	}
	
	/**
	 * Gets the EntityPlayer object of the client player.
	 * Returns null in the CommonProxy since there is no one player to get
	 * @return null
	 */
	public EntityPlayer getClientPlayer() {
		return null;
	}
}
