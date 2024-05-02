package com.onewhohears.dscombat.data.weapon;

import static com.onewhohears.dscombat.DSCombatMod.MODID;

import java.util.List;

import com.google.gson.JsonObject;
import com.onewhohears.dscombat.data.jsonpreset.JsonPreset;
import com.onewhohears.dscombat.entity.weapon.AntiRadarMissile;
import com.onewhohears.dscombat.entity.weapon.EntityWeapon;
import com.onewhohears.dscombat.util.UtilMCText;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

public class AntiRadarMissileData extends MissileData {
	
	private final double scan_range;
	
	public AntiRadarMissileData(ResourceLocation key, JsonObject json) {
		super(key, json);
		scan_range = json.get("scan_range").getAsDouble();
	}
	
	@Override
	public void readNBT(CompoundTag tag) {
		super.readNBT(tag);
	}
	
	@Override
	public CompoundTag writeNbt() {
		CompoundTag tag = super.writeNbt();
		return tag;
	}
	
	@Override
	public WeaponType getType() {
		return WeaponType.ANTIRADAR_MISSILE;
	}
	
	@Override
	public void addToolTips(List<Component> tips, boolean advanced) {
		super.addToolTips(tips, advanced);
		tips.add(UtilMCText.literal("TARGETS GROUNDED").setStyle(Style.EMPTY.withColor(SPECIAL_COLOR)));
		tips.add(UtilMCText.literal("Scan Range: ").append(getScanRange()+"").setStyle(Style.EMPTY.withColor(INFO_COLOR)));
	}
	
	@Override
	public <T extends JsonPreset> T copy() {
		return (T) new AntiRadarMissileData(getKey(), getJsonData());
	}
	
	@Override
	public EntityWeapon getShootEntity(WeaponShootParameters params) {
		AntiRadarMissile missile = (AntiRadarMissile) super.getShootEntity(params);
		if (missile == null) return null;
		return missile;
	}
	
	public double getScanRange() {
		return scan_range;
	}
	
	@Override
	public String getWeaponTypeCode() {
		return "AGAR";
	}
	
	@Override
	public String getDefaultIconLocation() {
		return MODID+":textures/ui/weapon_icons/anti_radar_missile.png";
	}

}
