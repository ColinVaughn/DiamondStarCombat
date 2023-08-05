package com.onewhohears.dscombat.data.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onewhohears.dscombat.Config;
import com.onewhohears.dscombat.util.UtilParse;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistries;

public class RadarTargetTypes {
	
	private static RadarTargetTypes instance;
	
	public static RadarTargetTypes get() {
		if (instance == null) {
			instance = new RadarTargetTypes();
		}
		return instance;
	}
	
	public static void close() {
		instance = null;
	}
	
	private List<Class<? extends Entity>> irEntityClasses = new ArrayList<>();
	private List<Float> irEntityHeats = new ArrayList<>();
	private Map<String, Float> entityHeats = new HashMap<>();
	
	private List<Class<? extends Entity>> radarVehicleClasses = new ArrayList<>();
	
	private List<Class<? extends Entity>> radarMobClasses = new ArrayList<>();
	
	private RadarTargetTypes() {
	}
	
	public void readConfig() {
		System.out.println("RadarTargetTypes READ CONFIG");
		readIRMissiles();
		readEntityHeats();
		readRadarVehicles();
		readRadarMobs();
	}
	
	private void readIRMissiles() {
		irEntityClasses.clear();
		irEntityHeats.clear();
		List<? extends String> irList =  Config.COMMON.irEntities.get();
		for (int i = 0; i < irList.size(); ++i) {
			String a = irList.get(i);
			if (!a.contains("/")) continue;
			String[] split = a.split("/");
			if (split.length != 2) continue;
			String className = split[0];
			Class<? extends Entity> c = UtilParse.getEntityClass(className);
			if (c == null) {
				System.out.println("ERROR: "+className+" does not exist! IR missiles will not look for it.");
				continue;
			}
			irEntityClasses.add(c);
			System.out.println("ADDED IR ENTITY CLASS: "+c.getName());
			float heat = 0;
			try {
				heat = Float.parseFloat(split[1]);
			} catch (NumberFormatException e) {
				System.out.println("ERROR: "+split[1]+" is not a number!");
			}
			irEntityHeats.add(heat);
		}
	}
	
	private void readEntityHeats() {
		entityHeats.clear();
		List<? extends String> irList =  Config.COMMON.specificEntityHeat.get();
		for (int i = 0; i < irList.size(); ++i) {
			String a = irList.get(i);
			if (!a.contains("/")) continue;
			String[] split = a.split("/");
			if (split.length != 2) continue;
			String entityId = split[0];
			if (!ForgeRegistries.ENTITY_TYPES.containsKey(new ResourceLocation(entityId))) {
				System.out.println("ERROR: "+entityId+" does not exist! IR missiles will not read that heat value!");
				continue;
			}
			System.out.println("ADDED ENTITY HEAT OVERRIDE: "+a);
			float heat = 0;
			try {
				heat = Float.parseFloat(split[1]);
			} catch (NumberFormatException e) {
				System.out.println("ERROR: "+split[1]+" is not a number!");
			}
			entityHeats.put(entityId, heat);
		}
	}
	
	public List<Class<? extends Entity>> getIrEntityClasses() {
		return irEntityClasses;
	}
	
	public List<Float> getIrEntityHeats() {
		return irEntityHeats;
	}
	
	public float getEntityHeat(String id, float instead) {
		if (!entityHeats.containsKey(id)) return instead;
		return entityHeats.get(id);
	}
	
	private void readRadarVehicles() {
		radarVehicleClasses.clear();
		List<? extends String> vehicleList =  Config.COMMON.radarVehicles.get();
		for (int i = 0; i < vehicleList.size(); ++i) {
			String className = vehicleList.get(i);
			Class<? extends Entity> c = UtilParse.getEntityClass(className);
			if (c == null) {
				System.out.println("ERROR: "+className+" does not exist! Vehicle Radar will not look for it.");
				continue;
			}
			radarVehicleClasses.add(c);
			System.out.println("ADDED VEHICLE ENTITY CLASS: "+c.getName());
		}
	}
	
	public List<Class<? extends Entity>> getRadarVehicleClasses() {
		return radarVehicleClasses;
	}
	
	private void readRadarMobs() {
		radarMobClasses.clear();
		List<? extends String> mobList =  Config.COMMON.radarMobs.get();
		for (int i = 0; i < mobList.size(); ++i) {
			String className = mobList.get(i);
			Class<? extends Entity> c = UtilParse.getEntityClass(className);
			if (c == null) {
				System.out.println("ERROR: "+className+" does not exist! Mob Radar will not look for it.");
				continue;
			}
			radarMobClasses.add(c);
			System.out.println("ADDED MOB ENTITY CLASS: "+c.getName());
		}
	}
	
	public List<Class<? extends Entity>> getRadarMobClasses() {
		return radarMobClasses;
	}
	
}
