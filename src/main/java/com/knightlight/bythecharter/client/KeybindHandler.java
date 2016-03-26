package com.knightlight.bythecharter.client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeybindHandler {

	public static KeyBinding castingKeybind;
	
	public static void init() {
		castingKeybind = new KeyBinding("bythecharter.cast", Keyboard.KEY_R, "key.categories.gameplay");
		ClientRegistry.registerKeyBinding(castingKeybind);
	}
}
