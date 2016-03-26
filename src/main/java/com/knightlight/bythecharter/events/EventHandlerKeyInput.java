package com.knightlight.bythecharter.events;

import com.knightlight.bythecharter.client.KeybindHandler;
import com.knightlight.bythecharter.gui.CastingGUI;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventHandlerKeyInput {

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		
		if(KeybindHandler.castingKeybind.isPressed()) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new CastingGUI());
		}
	}
}
