package com.knightlight.bythecharter.client.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

/**
 * Handler for whenever the Client ticks
 * @author Majikguy
 */
public class ClientTickHandler {
	
	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent e) {
//		CharterMod.proxy.generateCharterParticles(CharterMod.proxy.getClientPlayer());
//		CharterMod.proxy.generateCharterParticles(CharterMod.proxy.getClientPlayer());
	}
}
