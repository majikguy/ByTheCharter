package knightlight.bythecharter.client.events;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/**
 * Handler that runs when the textures are loaded by Forge.
 * Registers my textures to be loaded
 * @author Majikguy
 *
 */
public class EventHandlerTextureStitch {

	@SubscribeEvent
	public void onPreStitcherEvent(TextureStitchEvent.Pre event) {
		
		ResourceLocation charterMarks;
		// Load each of the mark#.png files
		// Should find a better way to do this
		for(int i = 0; i < 50; i++) {
			charterMarks = new ResourceLocation("bythecharter:misc/mark"+i);
			event.getMap().registerSprite(charterMarks);
		}
	}
}
