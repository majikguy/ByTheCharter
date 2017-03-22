package knightlight.bythecharter.client.events;

import knightlight.bythecharter.client.KeybindHandler;
import knightlight.bythecharter.client.gui.MagicDiveGUI;
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
			// @TODO Keep experimenting with different options for GUI bases
			mc.displayGuiScreen(new MagicDiveGUI());
		}
	}
}
