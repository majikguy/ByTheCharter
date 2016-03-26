package com.knightlight.bythecharter.client.events;

import com.knightlight.bythecharter.common.CharterMod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientTickHandler {
	
	@SubscribeEvent
	public void onClientTickEvent(ClientTickEvent e) {
		CharterMod.proxy.generateCharterParticles(CharterMod.proxy.getClientPlayer());
		CharterMod.proxy.generateCharterParticles(CharterMod.proxy.getClientPlayer());
	}
}
