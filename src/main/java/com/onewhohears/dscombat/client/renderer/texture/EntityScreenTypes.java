package com.onewhohears.dscombat.client.renderer.texture;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class EntityScreenTypes {
	
	public static final Int2ObjectMap<EntityScreenFactory> screenTypes = new Int2ObjectOpenHashMap<>();
	public static final int RADAR_SCREEN = 0;
	public static final int FUEL_SCREEN = 1;
	public static final int HUD_SCREEN = 2;
	
	static {
		// TODO 1.1 give every vehicle that needs it a radar screen (show radar mode)
		screenTypes.put(RADAR_SCREEN, RadarScreenInstance::new);
		// TODO 1.2 give every vehicle fuel screen
		screenTypes.put(FUEL_SCREEN, FuelScreenInstance::new);
		// TODO 1.3 give every vehicle that needs it a hud screen
		screenTypes.put(HUD_SCREEN, HudScreenInstance::new);
		// TODO 1.4 give every vehicle that needs it an rwr screen
		// TODO 1.5 give every vehicle compass screen
		// TODO 1.6 give every vehicle that needs it turn coordinator screen
		// TODO 1.7 give every vehicle that needs it an attitude indicator
		// TODO 1.8 give every vehicle that needs it flare count screen
		
	}
	
	public interface EntityScreenFactory {
		EntityScreenInstance create(int id);
	}
	
}
