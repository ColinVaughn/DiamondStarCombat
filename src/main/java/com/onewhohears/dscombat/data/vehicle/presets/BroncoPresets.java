package com.onewhohears.dscombat.data.vehicle.presets;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.parts.PartSlot;
import com.onewhohears.dscombat.data.parts.SlotType;
import com.onewhohears.dscombat.data.vehicle.LiftKGraph;
import com.onewhohears.dscombat.data.vehicle.VehicleSoundManager.PassengerSoundPack;
import com.onewhohears.dscombat.data.vehicle.stats.VehicleStats;
import com.onewhohears.dscombat.init.ModItems;
import com.onewhohears.dscombat.init.ModSounds;

public class BroncoPresets {
	
	public static final VehicleStats EMPTY_BRONCO_PLANE = VehicleStats.Builder
			.createPlane(DSCombatMod.MODID, "bronco_plane_empty")
			.setAssetId("bronco_plane")
			.setSortFactor(4)
			.setItem(ModItems.BRONCO_PLANE.getId())
			.setMaxHealth(90f)
			.setMass(3100f)
			.setMaxSpeed(0.85f)
			.setStealth(1f)
			.setCrossSecArea(5f)
			.setIdleHeat(3f)
			.setBaseArmor(1f)
			.setTurnRadius(8f)
			.setMaxTurnRates(2.5f, 1.2f, 0.9f)
			.setTurnTorques(1.5f, 2f, 3f)
			.setThrottleRate(0.03f, 0.07f)
			.setPlaneWingArea(27f)
			.setBasicEngineSounds(ModSounds.BIPLANE_1, ModSounds.BIPLANE_1)
			.setRotationalInertia(6, 10, 5)
			.setCrashExplosionRadius(4)
			.set3rdPersonCamDist(14)
			.setPlaneLiftAOAGraph(LiftKGraph.JAVI_PLANE_GRAPH)
			.setPlaneFlapDownAOABias(9)
			.setPlaneNoseCanAimDown(false)
			.setBaseTextureNum(2)
			.setLayerTextureNum(2)
			.setDefultPassengerSoundPack(PassengerSoundPack.ENG_NON_BINARY_GOOBER)
			.addIngredientTag("minecraft:planks", 40)
			.addIngredientTag("dscombat:aluminum_ingot", 6)
			.addIngredient(ModItems.WING.getId(), 3)
			.addIngredient(ModItems.COCKPIT.getId(), 1)
			.addIngredient(ModItems.SEAT.getId(), 1)
			.addIngredient(ModItems.WHEEL.getId(), 3)
			.addIngredient(ModItems.PROPELLER.getId(), 2)
			.addPilotSeatSlot(0, -0.74, 4.5)
			.addSeatSlot(PartSlot.COPILOT_SLOT_NAME, SlotType.MOUNT_LIGHT, 0, -0.61, 3.125)
			.addEmptySlot("nose_1", SlotType.PYLON_LIGHT, 0, -0.9357, 6.0625, 180)
			.addEmptySlot("frame_1", SlotType.PYLON_LIGHT, 0.5, -1.25, 1.1875, 180)
			.addEmptySlot("frame_2", SlotType.PYLON_LIGHT, 1.125, -1.375, 1.1875, 180)
			.addEmptySlot("frame_3", SlotType.PYLON_LIGHT, -0.5, -1.25, 1.1875, 180)
			.addEmptySlot("frame_4", SlotType.PYLON_LIGHT, -1.125, -1.375, 1.1875, 180)
			.addEmptySlot("left_wing_1", SlotType.PYLON_LIGHT, 4.875, 0.125, 1.0625, 180)
			.addEmptySlot("right_wing_1", SlotType.PYLON_LIGHT, -4.875, 0.125, 1.0625, 180)
			.addEmptySlot("internal_1", SlotType.RADIAL_ENGINE)
			.addEmptySlot("internal_2", SlotType.RADIAL_ENGINE)
			.addEmptySlot("internal_3", SlotType.INTERNAL)
			.addEmptySlot("internal_4", SlotType.INTERNAL)
			.addEmptySlot("internal_5", SlotType.MOUNT_TECH)
			.setEntityMainHitboxSize(4, 4)
			.build();
	
	public static final VehicleStats UNARMED_BRONCO_PLANE = VehicleStats.Builder
			.createFromCopy(DSCombatMod.MODID, "bronco_plane_unarmed", EMPTY_BRONCO_PLANE)
			.setCraftable()
			.setSlotItem("internal_1", ModItems.CM_MANLY_52.getId())
			.setSlotItem("internal_2", ModItems.CM_MANLY_52.getId())
			.setSlotItem("internal_3", ModItems.LIGHT_FUEL_TANK.getId(), true)
			.addIngredient(ModItems.CM_MANLY_52.getId(), 2)
			.addIngredient(ModItems.LIGHT_FUEL_TANK.getId())
			.build();
	
	public static final VehicleStats DEFAULT_BRONCO_PLANE = VehicleStats.Builder
			.createFromCopy(DSCombatMod.MODID, "bronco_plane", UNARMED_BRONCO_PLANE)
			.setSlotItem("internal_4", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.setSlotItem("left_wing_1", ModItems.LIGHT_MISSILE_RACK.getId(), "agm114k", true)
			.setSlotItem("right_wing_1", ModItems.LIGHT_MISSILE_RACK.getId(), "agm65l", true)
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.build();
	
}
