package com.onewhohears.dscombat.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.onewhohears.dscombat.data.parts.PartSlot;
import com.onewhohears.dscombat.data.parts.PartSlot.SlotType;
import com.onewhohears.dscombat.data.parts.PartsManager;
import com.onewhohears.dscombat.data.parts.SeatData;
import com.onewhohears.dscombat.data.parts.WeaponPartData;
import com.onewhohears.dscombat.data.parts.WeaponRackData;
import com.onewhohears.dscombat.data.radar.RadarData;
import com.onewhohears.dscombat.data.radar.RadarSystem;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.Vec3;

public class AircraftPresets {
	
	public static List<CompoundTag> presets = new ArrayList<CompoundTag>();
	
	public static void setupPresets() {
		presets.add(JaviPreset());
		presets.add(TestPreset());
		// TODO check for a text file with the names of all the presets to read
	}
	
	@Nullable
	public static CompoundTag getPreset(String preset) {
		for (CompoundTag tag : presets) if (tag.getString("preset").equals(preset)) return tag;
		return null;
	}
	
	public static CompoundTag TestPreset() {
		System.out.println("CREATING TEST PRESET");
		CompoundTag tag = JaviPreset();
		tag.putString("preset", "test_plane");
		RadarSystem rs = new RadarSystem();
		RadarData radar2 = new RadarData("radar_all", 1000, -1, 20);
		radar2.setScanAircraft(true);
		radar2.setScanPlayers(true);
		radar2.setScanMobs(true);
		radar2.setScanAir(true);
		radar2.setScanGround(true);
		rs.addRadar(radar2, false);
		rs.write(tag);
		return tag;
	}
	
	public static CompoundTag JaviPreset() {
		System.out.println("CREATING JAVI PRESET");
		CompoundTag tag = new CompoundTag();
		// parts
		PartsManager pm = new PartsManager();
		pm.addSlot(PartSlot.PILOT_SLOT_NAME, SlotType.SEAT, new Vec3(0, -0.5, 0), 48, 60);
		pm.addSlot("dscombat.seat2", SlotType.SEAT, new Vec3(1, -0.5, 1), 68, 60);
		pm.addSlot("dscombat.seat3", SlotType.SEAT, new Vec3(-1, -0.5, 1), 88, 60);
		pm.addSlot("dscombat.left_wing_1", SlotType.WING, new Vec3(-0.9, -0.5, 1), 48, 80);
		pm.addSlot("dscombat.left_wing_2", SlotType.WING, new Vec3(-1.8, -0.5, 1), 68, 80);
		pm.addSlot("dscombat.right_wing_1", SlotType.WING, new Vec3(0.9, -0.5, 1), 88, 80);
		pm.addSlot("dscombat.right_wing_2", SlotType.WING, new Vec3(1.8, -0.5, 1), 108, 80);
		pm.addSlot("dscombat.internal_1", SlotType.INTERNAL, new Vec3(0, 0, 1), 48, 100);
		pm.addPart(new SeatData(0.003f), PartSlot.PILOT_SLOT_NAME, false);
		pm.addPart(new SeatData(0.003f), "dscombat.seat2", false);
		pm.addPart(new SeatData(0.003f), "dscombat.seat3", false);
		pm.addPart(new WeaponRackData(0.005f, "gbu", 8, 8), "dscombat.left_wing_1", false);
		pm.addPart(new WeaponRackData(0.005f, "fox3_1", 4, 4), "dscombat.right_wing_1", false);
		pm.addPart(new WeaponRackData(0.005f, "fox2_1", 12, 12), "dscombat.left_wing_2", false);
		pm.addPart(new WeaponPartData(0.002f, "bullet_1", 1000, 1000), "dscombat.internal_1", false);
		pm.write(tag);
		System.out.println(pm);
		// weapons
		/*WeaponSystem ws = new WeaponSystem();
		WeaponData b1 = WeaponPresets.getById("bullet_1");
		WeaponData gbu = WeaponPresets.getById("gbu");
		WeaponData f31 = WeaponPresets.getById("fox3_1");
		WeaponData f21 = WeaponPresets.getById("fox2_1");
		b1.setCurrentAmmo(b1.getMaxAmmo());
		gbu.setCurrentAmmo(gbu.getMaxAmmo());
		f31.setCurrentAmmo(f31.getMaxAmmo());
		f21.setCurrentAmmo(f21.getMaxAmmo());
		b1.setLaunchPos(new Vec3(0, 0, 1));
		gbu.setLaunchPos(new Vec3(0, 0, 1));
		f31.setLaunchPos(new Vec3(0, 0, 1));
		f21.setLaunchPos(new Vec3(0, 0, 1));
		ws.addWeapon(b1, false);
		ws.addWeapon(gbu, false);
		ws.addWeapon(f31, false);
		ws.addWeapon(f21, false);
		ws.write(tag);*/
		// radar
		RadarSystem rs = new RadarSystem();
		RadarData radar = new RadarData("radar_air", 1000, 70, 20);
		radar.setScanAircraft(true);
		radar.setScanPlayers(true);
		radar.setScanMobs(false);
		radar.setScanAir(true);
		radar.setScanGround(false);
		rs.addRadar(radar, false);
		RadarData radar2 = new RadarData("radar_ground", 200, -1, 15);
		radar2.setScanAircraft(true);
		radar2.setScanPlayers(true);
		radar2.setScanMobs(true);
		radar2.setScanAir(false);
		radar2.setScanGround(true);
		rs.addRadar(radar2, false);
		rs.write(tag);
		// other
		tag.putString("preset", "javi");
		tag.putFloat("max_speed", 1.5f);
		tag.putFloat("max_health", 100);
		tag.putFloat("health", 100);
		tag.putInt("flares", 100);
		tag.putFloat("stealth", 1);
		tag.putFloat("maxroll", 8);
		tag.putFloat("maxpitch", 2);
		tag.putFloat("maxyaw", 1);
		tag.putFloat("throttleup", 0.04f);
		tag.putFloat("throttledown", 0.04f);
		tag.putFloat("idleheat", 4f);
		tag.putFloat("engineheat", 4f);
		tag.putFloat("weight", 0.04f);
		tag.putFloat("maxthrust", 0.1f);
		tag.putFloat("surfacearea", 1f);
		return tag;
	}
	
}
