package com.knightlight.bythecharter.gui;

import java.io.IOException;

import com.knightlight.bythecharter.common.entity.EntityCharterSpellProjectile;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

/**
 * Test GUI that opens a button
 * @author Majikguy
 *
 */
public class CastingGUI extends GuiScreen {
	
	private GuiButton a;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    this.drawDefaultBackground();
	    super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(this.a = new GuiButton(0, this.width / 2 -100, this.height / 2 - 24, "THIS IS A BUTTON!"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button == this.a) {
			this.mc.displayGuiScreen(null);
			
			if(this.mc.currentScreen == null)
				this.mc.setIngameFocus();
			
			EntityCharterSpellProjectile spell = new EntityCharterSpellProjectile(mc.thePlayer.worldObj, mc.thePlayer);
			mc.thePlayer.worldObj.spawnEntityInWorld(spell);
		}
	}
}
