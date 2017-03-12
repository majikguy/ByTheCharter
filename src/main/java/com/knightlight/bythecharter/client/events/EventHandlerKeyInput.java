package com.knightlight.bythecharter.client.events;

import com.knightlight.bythecharter.client.KeybindHandler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

/**
 * Handler for whenever a keyboard key is pressed
 * @author Majikguy
 *
 */
public class EventHandlerKeyInput {

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		
		if(KeybindHandler.castingKeybind.isPressed()) {
			Minecraft mc = Minecraft.getMinecraft();
			// Not doing a GUI like this, will be doing a custom-rendered solution eventually
			//mc.displayGuiScreen(new CastingGUI());
		}
	}
}
