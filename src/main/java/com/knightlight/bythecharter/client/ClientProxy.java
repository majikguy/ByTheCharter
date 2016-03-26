package com.knightlight.bythecharter.client;

import com.knightlight.bythecharter.client.events.ClientTickHandler;
import com.knightlight.bythecharter.client.events.EventHandlerTextureStitch;
import com.knightlight.bythecharter.common.CommonProxy;
import com.knightlight.bythecharter.events.EventHandlerKeyInput;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
		KeybindHandler.init();
		MinecraftForge.EVENT_BUS.register(new EventHandlerTextureStitch());
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		MinecraftForge.EVENT_BUS.register(new EventHandlerKeyInput());
		MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	@Override
	public void generateCharterParticles(Entity entity) {
		
		if(entity == null) return;
		
		double motionX = entity.motionX + entity.worldObj.rand.nextGaussian() + 0.02D;
		double motionY = entity.motionY + entity.worldObj.rand.nextGaussian() + 0.02D;
		double motionZ = entity.motionZ + entity.worldObj.rand.nextGaussian() + 0.02D;
		
		EntityCharterParticleFX particle = new EntityCharterParticleFX(
													entity.worldObj,
													entity.posX + entity.worldObj.rand.nextFloat() * entity.width * 2.0F - entity.width,
													entity.posY + entity.worldObj.rand.nextFloat() * entity.height * 2.0F - entity.height,
													entity.posZ + entity.worldObj.rand.nextFloat() * entity.width * 2.0F - entity.width,
													motionX,
													motionY,
													motionZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}
	
	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}

}
