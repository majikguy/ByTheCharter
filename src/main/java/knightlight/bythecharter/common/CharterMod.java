package knightlight.bythecharter.common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Main Class for the By the Charter mod.
 * Is registered by Forge, and provides the methods to set up the mod
 * @author Majikguy
 */
// Mod annotation so that it is picked up by FML
@Mod(modid = CharterMod.MODID, name = CharterMod.MODNAME, version = CharterMod.VERSION)
public class CharterMod
{
	// Mod annotation argument declaration
    public static final String MODID = "bythecharter";
    public static final String MODNAME = "By The Charter";
    public static final String VERSION = "0.0.1";
    
    // Instance of this Class loaded by FML
    @Instance
    public static CharterMod instance = new CharterMod();
    
    // Proxy object, handles loading of the mod. Contains ClientProxy on the client, and ServerProxy on the server
    @SidedProxy(clientSide="knightlight.bythecharter.client.ClientProxy",serverSide="knightlight.bythecharter.ServerProxy")
    public static CommonProxy proxy;

    public static Logger logger;
    
    // Setup methods, hands the reigns off to the Proxy
	@EventHandler
	//@SuppressWarnings("static-access")
    public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
        logger.debug("BEGINNING PRE-INIT");
    	this.proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	logger.debug("BEGINNING INIT");
    	this.proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	logger.debug("BEGINNING POST-INIT");
    	this.proxy.postInit(event);
    }
}
