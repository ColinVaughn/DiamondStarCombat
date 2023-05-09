package com.onewhohears.dscombat.data.weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.onewhohears.dscombat.data.JsonPresetReloadListener;

import net.minecraft.resources.ResourceLocation;

public class WeaponPresets extends JsonPresetReloadListener<WeaponData> {
	
	private static WeaponPresets instance;
	
	public static WeaponPresets get() {
		if (instance == null) instance = new WeaponPresets();
		return instance;
	}
	
	public static void close() {
		instance = null;
	}
	
	private Map<String, List<String>> compatibleMap = new HashMap<>();
	private WeaponData[] weaponList;
	
	public WeaponPresets() {
		super("weapons");
	}
	
	@Override
	public WeaponData[] getAllPresets() {
		if (weaponList == null) {
			weaponList = presetMap.values().toArray(new WeaponData[presetMap.size()]);
		}
		return weaponList;
	}
	
	public List<String> getCompatibleWeapons(ResourceLocation weaponPartItemId) {
		List<String> list = compatibleMap.get(weaponPartItemId.toString());
		if (list == null) return new ArrayList<>();
		return list;
	}
	
	@Override
	protected void resetCache() {
		weaponList = null;
		refreshCompatibility();
	}
	
	protected void refreshCompatibility() {
		compatibleMap.clear();
		for (int i = 0; i < getAllPresets().length; ++i) {
			String partId = getAllPresets()[i].getCompatibleWeaponPart();
			if (partId.isEmpty()) continue;
			List<String> list = compatibleMap.get(partId);
			if (list == null) {
				list = new ArrayList<String>();
				compatibleMap.put(partId, list);
			}
			list.add(getAllPresets()[i].getId());
		}
		System.out.println("WEAPON CAPATIBILITY: "+compatibleMap.toString());
	}
	
	@Nullable
	public WeaponData getFromJson(ResourceLocation key, JsonObject json) {
		int index = json.get("type").getAsInt();
		WeaponData.WeaponType type = WeaponData.WeaponType.values()[index];
		switch (type) {
		case BOMB:
			return new BombData(key, json);
		case BULLET:
			return new BulletData(key, json);
		case IR_MISSILE:
			return new IRMissileData(key, json);
		case POS_MISSILE:
			return new PosMissileData(key, json);
		case TRACK_MISSILE:
			return new TrackMissileData(key, json);
		case ANTIRADAR_MISSILE:
			return new AntiRadarMissileData(key, json);
		case TORPEDO:
			return new TorpedoData(key, json);
		}
		return null;
	}
	
}
