package com.onewhohears.dscombat.data.damagesource;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.entity.aircraft.EntityAircraft;
import com.onewhohears.dscombat.util.UtilParse;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class AircraftDamageSource extends DamageSource {
	
	public final EntityAircraft aircraft;
	
	public AircraftDamageSource(String type, EntityAircraft aircraft) {
		super(type);
		this.aircraft = aircraft;
	}
	
	public static DamageSource roadKill(EntityAircraft aircraft) {
		return new AircraftDamageSource(getRoadKillDeath(), aircraft);
	}
	
	public static DamageSource fall(EntityAircraft aircraft) {
		return new AircraftDamageSource(getFallDeath(), aircraft).setExplosion();
	}
	
	public static DamageSource collide(EntityAircraft aircraft) {
		return new AircraftDamageSource(getCollideDeath(), aircraft).setExplosion();
	}
	
	public static final String[] roadKillDeaths = {"roadkill1","roadkill2"};
	public static final String[] crashDeaths = {"plane_crash1","plane_crash2"};
	public static final String[] fallCrashDeaths = {"plane_crash_fall1","plane_crash_fall2","plane_crash_fall3"};
	public static final String[] wallCrashDeaths = {"plane_crash_collide1","plane_crash_collide2","plane_crash_collide3"};
	
	public static String getRoadKillDeath() {
		return UtilParse.getRandomString(crashDeaths, roadKillDeaths, wallCrashDeaths);
	}
	
	public static String getFallDeath() {
		return UtilParse.getRandomString(crashDeaths, fallCrashDeaths);
	}
	
	public static String getCollideDeath() {
		return UtilParse.getRandomString(crashDeaths, wallCrashDeaths);
	}
	
	public Component getLocalizedDeathMessage(LivingEntity killed) {
		Entity killer = aircraft.getControllingPassenger();
		String s = "death.attack."+DSCombatMod.MODID+"."+msgId;
		if (killer == null) {
			return new TranslatableComponent(s, killed.getDisplayName());
		} else if (killed.equals(killer)) {
			return new TranslatableComponent(s+".self", killed.getDisplayName());
		} else {
			return new TranslatableComponent(s+".player", killed.getDisplayName(), killer.getDisplayName());
		}
	}

}
