package com.onewhohears.dscombat.data.vehicle.presets;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.client.entityscreen.EntityScreenIds;
import com.onewhohears.dscombat.data.parts.PartSlot;
import com.onewhohears.dscombat.data.parts.SlotType;
import com.onewhohears.dscombat.data.vehicle.LiftKGraph;
import com.onewhohears.dscombat.data.vehicle.VehicleSoundManager.PassengerSoundPack;
import com.onewhohears.dscombat.data.vehicle.stats.VehicleStats;
import com.onewhohears.dscombat.init.ModItems;
import com.onewhohears.dscombat.init.ModSounds;

public class EdenPresets {
	
	public static final VehicleStats EMPTY_EDEN_PLANE = VehicleStats.Builder
			.createPlane(DSCombatMod.MODID, "eden_plane_empty")
			.setAssetId("eden_plane")
			.setSortFactor(9)
			.setItem(ModItems.EDEN_PLANE.getId())
			.setMaxHealth(160f)
			.setMass(11000)
			.setMaxSpeed(1.5f)
			.setStealth(0.95f)
			.setCrossSecArea(4.5f)
			.setIdleHeat(5f)
			.setBaseArmor(3f)
			.setTurnRadius(11f)
			.setMaxTurnRates(5.5f, 2.25f, 1.25f)
			.setTurnTorques(1.5f, 2f, 4f)
			.setThrottleRate(0.04f, 0.08f)
			.setPlaneWingArea(38f)
			.setFighterJetSounds(ModSounds.ALEXIS_EXT_AFTERBURNER_CLOSE, ModSounds.ALEXIS_EXT_AFTERBURNER_FAR,
					ModSounds.ALEXIS_EXT_RPM, ModSounds.ALEXIS_EXT_WIND_CLOSE, ModSounds.ALEXIS_EXT_WIND_FAR,
					ModSounds.ALEXIS_CP_RPM, ModSounds.ALEXIS_CP_AFTERBURNER, ModSounds.ALEXIS_CP_WIND_SLOW, 
					ModSounds.ALEXIS_CP_WIND_FAST)
			.setRotationalInertia(4.5f, 8.5f, 2.5f)
			.setCrashExplosionRadius(5.5f)
			.set3rdPersonCamDist(19)
			.setPlaneLiftAOAGraph(LiftKGraph.ALEXIS_PLANE_GRAPH)
			.setPlaneFlapDownAOABias(9)
			.setPlaneNoseCanAimDown(false)
			.setBaseTextureNum(3)
			.setLayerTextureNum(3)
			.setDefultPassengerSoundPack(PassengerSoundPack.ENG_NON_BINARY_GOOBER)
			.addIngredient(ModItems.FUSELAGE.getId(), 1)
			.addIngredient(ModItems.WING.getId(), 4)
			.addIngredient(ModItems.ADVANCED_COCKPIT.getId())
			.addIngredient(ModItems.SEAT.getId())
			.addIngredient(ModItems.WHEEL.getId(), 3)
			.addIngredient("minecraft:gold_ingot", 20)
			.addPilotSeatSlot(0, 0.3, 8.5)
			.addSeatSlot(PartSlot.COPILOT_SLOT_NAME, 0, 0.4, 6.8)
			.addEmptySlot("left_wing_1", SlotType.PYLON_MED, 3, 0.05, 0.4, 180)
			.addEmptySlot("left_wing_2", SlotType.PYLON_LIGHT, 4, 0.05, -0.4, 180)
			.addEmptySlot("left_wing_3", SlotType.PYLON_LIGHT, 5, 0.05, -1.2, 180)
			.addEmptySlot("right_wing_1", SlotType.PYLON_LIGHT, -3, 0.05, 0.4, 180)
			.addEmptySlot("right_wing_2", SlotType.PYLON_LIGHT, -4, 0.05, -0.4, 180)
			.addEmptySlot("right_wing_3", SlotType.PYLON_LIGHT, -5, 0.05, -1.2, 180)
			.addEmptySlot("internal_gun", SlotType.INTERNAL_GUN, 0, -0.14, 9.6, 180)
			.setSlotOnlyCompatible("internal_gun", "gsh_30_1")
			.addEmptySlot("internal_1", SlotType.PUSH_ENGINE)
			.addEmptySlot("internal_2", SlotType.PUSH_ENGINE)
			.addEmptySlot("internal_3", SlotType.INTERNAL)
			.addEmptySlot("internal_4", SlotType.INTERNAL)
			.addEmptySlot("internal_5", SlotType.TECH_INTERNAL)
			.addEmptySlot("internal_6", SlotType.TECH_INTERNAL)
			.addEmptySlot("internal_7", SlotType.TECH_INTERNAL)
			.addAfterBurnerSmokePos(-1,0.1,-5)
			.addAfterBurnerSmokePos(1,0.1,-5)
			.addEntityScreen(EntityScreenIds.AIR_RADAR_SCREEN, 0.3, 0.9, 9.242, 0.22, 0.28, 5)
			.addEntityScreen(EntityScreenIds.GROUND_RADAR_SCREEN, -0.3, 0.9, 9.242, 0.22, 0.28, 5)
			.addEntityScreen(EntityScreenIds.RWR_SCREEN, 0, 0.94, 9.245, 0.2, 0.2, 5)
			.addEntityScreen(EntityScreenIds.FUEL_SCREEN, -0.505, 0.702, 8.93, 0.11, 0.11, 90)
			.addEntityScreen(EntityScreenIds.AIR_RADAR_SCREEN, 0.3, 1.185, 7.475, 0.22, 0.28, 5)
			.addEntityScreen(EntityScreenIds.GROUND_RADAR_SCREEN, -0.3, 1.185, 7.475, 0.22, 0.28, 5)
			.addEntityScreen(EntityScreenIds.RWR_SCREEN, 0, 1.225, 7.478, 0.2, 0.2, 5)
			.addEntityScreen(EntityScreenIds.FUEL_SCREEN, -0.505, 0.985, 7.205, 0.11, 0.11, 90)
			.setEntityMainHitboxSize(4, 4)
			.build();
	
	public static final VehicleStats UNARMED_EDEN_PLANE = VehicleStats.Builder
			.createFromCopy(DSCombatMod.MODID, "eden_plane_unarmed", EMPTY_EDEN_PLANE)
			.setCraftable()
			.setSlotItem("internal_1", ModItems.KLIMOV_RD33.getId())
			.setSlotItem("internal_2", ModItems.KLIMOV_RD33.getId())
			.setSlotItem("internal_3", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("internal_gun", "gsh_30_1", "20mm", false)
			.addIngredient(ModItems.INTERNAL_GUN.getId())
			.addIngredient(ModItems.KLIMOV_RD33.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.build();
	
	public static final VehicleStats DEFAULT_EDEN_PLANE = VehicleStats.Builder
			.createFromCopy(DSCombatMod.MODID, "eden_plane", UNARMED_EDEN_PLANE)
			.setSlotItem("left_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120b", true)
			.setSlotItem("left_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9x", true)
			.setSlotItem("right_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120c", true)
			.setSlotItem("right_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9x", true)
			.setSlotItem("internal_gun", "gsh_30_1", "20mm", true)
			.setSlotItem("internal_5", ModItems.AR2K.getId())
			.setSlotItem("internal_4", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.addIngredient(ModItems.AR2K.getId())
			.addIngredient(ModItems.HEAVY_MISSILE_RACK.getId(), 2)
			.addIngredient(ModItems.LIGHT_MISSILE_RACK.getId(), 2)
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.addIngredient("minecraft:copper_ingot", 63)
			.addIngredient("dscombat:aluminum_ingot", 64)
			.addIngredient("minecraft:redstone", 64)
			.addIngredient("minecraft:gunpowder", 64)
			.setDefaultBaseTexture(1)
			.build();
	
	public static final VehicleStats SUPPORT_EDEN_PLANE = VehicleStats.Builder
			.createFromCopy(DSCombatMod.MODID, "eden_plane_support", UNARMED_EDEN_PLANE)
			.setSlotItem("left_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "agm84e", true)
			.setSlotItem("left_wing_2", ModItems.HEAVY_MISSILE_RACK.getId(), "agm65l", true)
			.setSlotItem("left_wing_3", ModItems.GIMBAL_CAMERA.getId())
			.setSlotItem("right_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "agm88g", true)
			.setSlotItem("right_wing_2", ModItems.HEAVY_MISSILE_RACK.getId(), "agm65g", true)
			.setSlotItem("right_wing_3", ModItems.HEAVY_MISSILE_RACK.getId(), "aim9x", true)
			.setSlotItem("internal_gun", "gsh_30_1", "20mmhe", true)
			.setSlotItem("internal_5", ModItems.AR1K.getId())
			.setSlotItem("internal_6", ModItems.GR400.getId())
			.setSlotItem("internal_4", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.addIngredient(ModItems.AR1K.getId())
			.addIngredient(ModItems.GR400.getId())
			.addIngredient(ModItems.HEAVY_MISSILE_RACK.getId(), 4)
			.addIngredient(ModItems.LIGHT_MISSILE_RACK.getId(), 1)
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.addIngredient("minecraft:copper_ingot", 64)
			.addIngredient("dscombat:aluminum_ingot", 64)
			.addIngredient("minecraft:redstone", 64)
			.addIngredient("minecraft:gunpowder", 64)
			.setDefaultBaseTexture(2)
			.build();
	
}
