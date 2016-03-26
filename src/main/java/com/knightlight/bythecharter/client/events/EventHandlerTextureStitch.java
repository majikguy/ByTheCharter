package com.knightlight.bythecharter.client.events;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerTextureStitch {

	@SubscribeEvent
	public void onPreStitcherEvent(TextureStitchEvent.Pre event) {
		
		ResourceLocation charterMarks;
		for(int i = 0; i < 3; i++) {
			charterMarks = new ResourceLocation("bythecharter:misc/mark"+i);
			event.map.registerSprite(charterMarks);
		}
	}
}
