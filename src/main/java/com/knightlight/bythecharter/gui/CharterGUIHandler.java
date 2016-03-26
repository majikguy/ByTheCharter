package com.knightlight.bythecharter.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CharterGUIHandler implements IGuiHandler {
	
	public static final int CASTING_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case CASTING_GUI:
				return new CastingGUI();
			default:
				return null;
		}
	}

}
