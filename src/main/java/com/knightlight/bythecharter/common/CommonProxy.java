package com.knightlight.bythecharter.common;

import com.knightlight.bythecharter.events.EventHandlerDeath;
import com.knightlight.bythecharter.gui.CharterGUIHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		
	}
	
	public void init(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new EventHandlerDeath());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CharterMod.instance, new CharterGUIHandler());
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	public void generateCharterParticles(Entity entity) {
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
