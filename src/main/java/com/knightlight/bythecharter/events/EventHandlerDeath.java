package com.knightlight.bythecharter.events;

import org.apache.logging.log4j.Level;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerDeath {

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent e)
    {
		FMLLog.log("ByTheCharter",Level.INFO, "Entity with ID "+e.entity.getEntityId()+" died");
    }
}
