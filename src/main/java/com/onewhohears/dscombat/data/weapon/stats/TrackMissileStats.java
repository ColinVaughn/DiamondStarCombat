package com.onewhohears.dscombat.data.weapon.stats;

import static com.onewhohears.dscombat.DSCombatMod.MODID;

import java.util.List;

import com.google.gson.JsonObject;
import com.onewhohears.dscombat.data.jsonpreset.JsonPresetInstance;
import com.onewhohears.dscombat.data.jsonpreset.JsonPresetType;
import com.onewhohears.dscombat.data.weapon.WeaponType;
import com.onewhohears.dscombat.data.weapon.instance.TrackMissileInstance;
import com.onewhohears.dscombat.util.UtilMCText;
import com.onewhohears.dscombat.util.UtilParse;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

public class TrackMissileStats extends MissileStats {
	
	public static enum TargetType {
		AIR,
		GROUND,
		WATER
	}
	
	private final TargetType targetType;
	private final boolean active;

	public TrackMissileStats(ResourceLocation key, JsonObject json) {
		super(key, json);
		targetType = TargetType.valueOf(json.get("targetType").getAsString());
		active = UtilParse.getBooleanSafe(json, "activeTrack", true);
	}
	
	@Override
	public JsonPresetType getType() {
		return WeaponType.TRACK_MISSILE;
	}
	
	@Override
	public JsonPresetInstance<?> createPresetInstance() {
		return new TrackMissileInstance<>(this);
	}
	
	public TargetType getTargetType() {
		return targetType;
	}
	
	public boolean isActiveTrack() {
		return active;
	}
	
	@Override
	public void addToolTips(List<Component> tips, boolean advanced) {
		super.addToolTips(tips, advanced);
		switch(getTargetType()) {
		case AIR:
			tips.add(UtilMCText.literal("TARGETS FLYING").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
			break;
		case GROUND:
			tips.add(UtilMCText.literal("TARGETS GROUNDED").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
			break;
		case WATER:
			tips.add(UtilMCText.literal("TARGETS IN WATER").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
			break;
		}
		if (advanced) {
			if (active) tips.add(UtilMCText.literal("ACTIVE TRACK").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
			else tips.add(UtilMCText.literal("SEMI ACTIVE").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
		}
	}
	
	@Override
	public String getWeaponTypeCode() {
		switch(getTargetType()) {
		case AIR:
			if (active) return UtilMCText.transString("weapon_code.dscombat.fox3");
			else return UtilMCText.transString("weapon_code.dscombat.fox1");
		case GROUND:
			return UtilMCText.transString("weapon_code.dscombat.rifel");
		case WATER:
			return UtilMCText.transString("weapon_code.dscombat.bruiser");
		}
		return "";
	}
	
	@Override
	public String getDefaultIconLocation() {
		return MODID+":textures/ui/weapon_icons/radar_missile.png";
	}
	
	public boolean requiresRadar() {
		return true;
	}

}
