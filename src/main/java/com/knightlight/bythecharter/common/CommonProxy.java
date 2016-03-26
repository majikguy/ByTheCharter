package com.knightlight.bythecharter.common;

import com.knightlight.bythecharter.client.EntityCharterParticleFX;
import com.knightlight.bythecharter.common.entity.EntityCharterSpellProjectile;
import com.knightlight.bythecharter.events.EventHandlerDeath;
import com.knightlight.bythecharter.gui.CharterGUIHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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
		
		// Register NetworkHandlers
		NetworkRegistry.INSTANCE.registerGuiHandler(CharterMod.instance, new CharterGUIHandler());
		
		EntityRegistry.registerModEntity(EntityCharterSpellProjectile.class, "bythecharter.charterspell", 0, CharterMod.instance, 256, 10, true);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		// Nothing so far
	}
	
	/**
	 * Generates a Charter-Mark particle effect surrounding an Entity
	 * Does not need to do anything on the Server, so it is empty in CommonProxy
	 * @param entity - the Entity to spawn the particle around
	 */
	public void generateCharterSpellParticle(Entity entity) {
		// Does nothing here, only acts on the client
	}
	
	/**
	 * Generates a slow-moving Charter-Mark particle effect surrounding an Entity
	 * @param entity - the Entity to spawn the particle around
	 */
	public void generateLazyCharterParticle(Entity entity) {
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
