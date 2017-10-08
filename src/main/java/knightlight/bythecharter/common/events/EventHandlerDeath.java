package knightlight.bythecharter.common.events;

import knightlight.bythecharter.common.CharterMod;
import org.apache.logging.log4j.Level;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Handler for LivingDeathEvents
 * Will eventually be responsible for recording and tracking deaths
 * @author Majikguy
 *
 */
public class EventHandlerDeath {

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent e)
    {
		CharterMod.logger.debug("Entity with ID "+e.getEntity().getEntityId()+" died");
    }
}
