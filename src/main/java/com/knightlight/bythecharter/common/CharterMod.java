package com.knightlight.bythecharter.common;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CharterMod.MODID, name = CharterMod.MODNAME, version = CharterMod.VERSION)
public class CharterMod
{
    public static final String MODID = "bythecharter";
    public static final String MODNAME = "By The Charter";
    public static final String VERSION = "0.0.1";
    
    @Instance
    public static CharterMod instance = new CharterMod();
    
    @SidedProxy(clientSide="com.knightlight.bythecharter.client.ClientProxy",serverSide="com.knightlight.bythecharter.ServerProxy")
    public static CommonProxy proxy;
    
	@EventHandler
	@SuppressWarnings("static-access")
    public void preInit(FMLPreInitializationEvent event) {
		FMLLog.log("ByTheCharter",Level.INFO,"BEGINNING PRE-INIT");
    	this.proxy.preInit(event);
    }

    @EventHandler
	@SuppressWarnings("static-access")
    public void init(FMLInitializationEvent event) {
    	FMLLog.log("ByTheCharter",Level.INFO,"BEGINNING INIT");
    	this.proxy.init(event);
    }
    
    @EventHandler
	@SuppressWarnings("static-access")
    public void postInit(FMLPostInitializationEvent event) {
    	FMLLog.log("ByTheCharter",Level.INFO,"BEGINNING POST-INIT");
    	this.proxy.postInit(event);
    }
}
