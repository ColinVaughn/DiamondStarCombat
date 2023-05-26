package com.onewhohears.dscombat.data.aircraft;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.parts.PartSlot;
import com.onewhohears.dscombat.data.parts.PartSlot.SlotType;
import com.onewhohears.dscombat.entity.aircraft.EntityAircraft.AircraftType;
import com.onewhohears.dscombat.init.ModItems;

import net.minecraft.world.item.DyeColor;

public class DefaultAircraftPresets {
	
	// TODO 0.7 review aircraft presets so they fit new weapons
	
	public static final AircraftPreset EMPTY_ALEXIS_PLANE = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "alexis_plane_empty")
			.setAircraftType(AircraftType.PLANE)
			.setItem(ModItems.ALEXIS_PLANE.getId())
			.setMaxHealth(150f)
			.setMass(20f)
			.setMaxSpeed(1.45f)
			.setStealth(0.8f)
			.setIdleHeat(4f)
			.setTurnRadius(10f)
			.setMaxTurnRates(6f, 2.5f, 1.5f)
			.setTurnTorques(1f, 2f, 4f)
			.setThrottleRate(0.04f, 0.08f)
			.setPlaneWingArea(12f)
			.setDefaultTexture(DyeColor.WHITE, "dscombat:textures/entities/alexis_plane/white.png")
			.setAltTexture(DyeColor.RED, "dscombat:textures/entities/alexis_plane/red.png")
			.setAltTexture(DyeColor.CYAN, "dscombat:textures/entities/alexis_plane/cyan.png")
			.setAltTexture(DyeColor.BLACK, "dscombat:textures/entities/alexis_plane/black.png")
			.setAltTexture(DyeColor.ORANGE, "dscombat:textures/entities/alexis_plane/orange.png")
			.setAltTexture(DyeColor.BLUE, "dscombat:textures/entities/alexis_plane/blue.png")
			.setAltTexture(DyeColor.PURPLE, "dscombat:textures/entities/alexis_plane/purple.png")
			.addIngredient(ModItems.FUSELAGE.getId(), 2)
			.addIngredient(ModItems.WING.getId(), 2)
			.addIngredient(ModItems.ADVANCED_COCKPIT.getId())
			.addIngredient("minecraft:gold_ingot", 4)
			.addPilotSeatSlot(0, -0.3, 2, 48, 20)
			.addEmptySlot("slotname.dscombat.left_wing_1", SlotType.WING, 1.5, -0.3, 0.5, 0, 48, 40)
			.addEmptySlot("slotname.dscombat.left_wing_2", SlotType.WING, 2.5, -0.3, 0.5, 0, 68, 40)
			.addEmptySlot("slotname.dscombat.left_wing_3", SlotType.WING, 3.5, -0.3, 0.5, 0, 88, 40) 
			.addEmptySlot("slotname.dscombat.right_wing_1", SlotType.WING, -1.5, -0.3, 0.5, 0, 48, 60)
			.addEmptySlot("slotname.dscombat.right_wing_2", SlotType.WING, -2.5, -0.3, 0.5, 0, 68, 60)
			.addEmptySlot("slotname.dscombat.right_wing_3", SlotType.WING, -3.5, -0.3, 0.5, 0, 88, 60) 
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.FRAME, 0, -0.4, 2.5, 0, 48, 80)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.PUSH_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.ADVANCED_INTERNAL, 108, 100)
			.addEmptySlot("slotname.dscombat.internal_5", SlotType.ADVANCED_INTERNAL, 128, 100)
			.addEmptySlot("slotname.dscombat.internal_6", SlotType.ADVANCED_INTERNAL, 148, 100)
			.build();
	
	public static final AircraftPreset UNARMED_ALEXIS_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "alexis_plane_unarmed", EMPTY_ALEXIS_PLANE)
			.setCraftable()
			.setSlotItem("slotname.dscombat.internal_1", ModItems.TURBOFAN_F145.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_3", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.addIngredient(ModItems.TURBOFAN_F145.getId())
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.build();
	
	public static final AircraftPreset DEFAULT_ALEXIS_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "alexis_plane", UNARMED_ALEXIS_PLANE)
			.setCraftable()
			.setSlotItem("slotname.dscombat.left_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120b", true)
			.setSlotItem("slotname.dscombat.left_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9x", true)
			.setSlotItem("slotname.dscombat.right_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120c", true)
			.setSlotItem("slotname.dscombat.right_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9x", true)
			.setSlotItem("slotname.dscombat.frame_1", ModItems.XM12.getId(), "20mm", true)
			.setSlotItem("slotname.dscombat.internal_4", ModItems.AR2K.getId())
			.addIngredient(ModItems.AR2K.getId())
			.addIngredient(ModItems.HEAVY_MISSILE_RACK.getId(), 2)
			.addIngredient(ModItems.LIGHT_MISSILE_RACK.getId(), 2)
			.addIngredient(ModItems.XM12.getId())
			.build();
	
	public static final AircraftPreset EMPTY_JAVI_PLANE = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "javi_plane_empty")
			.setAircraftType(AircraftType.PLANE)
			.setItem(ModItems.JAVI_PLANE.getId())
			.setMaxHealth(200f)
			.setMass(25f)
			.setMaxSpeed(1.20f)
			.setStealth(1.1f)
			.setIdleHeat(5f)
			.setTurnRadius(12f)
			.setMaxTurnRates(4f, 2f, 1f)
			.setTurnTorques(1f, 2f, 4f)
			.setThrottleRate(0.04f, 0.08f)
			.setPlaneWingArea(12f)
			.setDefaultTexture(DyeColor.GREEN, "dscombat:textures/entities/javi_plane/green.png")
			.setAltTexture(DyeColor.BLUE, "dscombat:textures/entities/javi_plane/blue.png")
			.setAltTexture(DyeColor.RED, "dscombat:textures/entities/javi_plane/red.png")
			.setAltTexture(DyeColor.BLACK, "dscombat:textures/entities/javi_plane/black.png")
			.setAltTexture(DyeColor.PURPLE, "dscombat:textures/entities/javi_plane/purple.png")
			.addIngredient(ModItems.FUSELAGE.getId(), 2)
			.addIngredient(ModItems.LARGE_WING.getId(), 2)
			.addIngredient(ModItems.COCKPIT.getId())
			.addIngredient("minecraft:gold_ingot", 4)
			.addPilotSeatSlot(0, -0.4, 3, 48, 20)
			.addSeatSlot("slotname.dscombat.seat2", SlotType.TURRET, 0, -0.4, 2, 68, 20)
			.addEmptySlot("slotname.dscombat.left_wing_1", SlotType.WING, 1.5, -0.3, 0, 0, 48, 40)
			.addEmptySlot("slotname.dscombat.left_wing_2", SlotType.WING, 3.0, -0.2, 0, 0, 68, 40)
			.addEmptySlot("slotname.dscombat.left_wing_3", SlotType.WING, 4.0, -0.07, 0, 0, 88, 40) 
			.addEmptySlot("slotname.dscombat.left_wing_4", SlotType.WING, 5.0, 0.05, 0, 0, 108, 40) 
			.addEmptySlot("slotname.dscombat.right_wing_1", SlotType.WING, -1.5, -0.3, 0, 0, 48, 60)
			.addEmptySlot("slotname.dscombat.right_wing_2", SlotType.WING, -3.0, -0.2, 0, 0, 68, 60)
			.addEmptySlot("slotname.dscombat.right_wing_3", SlotType.WING, -4.0, -0.07, 0, 0, 88, 60) 
			.addEmptySlot("slotname.dscombat.right_wing_4", SlotType.WING, -5.0, 0.05, 0, 0, 108, 60) 
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.FRAME, 0, -0.65, 3, 0, 48, 80)
			.addEmptySlot("slotname.dscombat.frame_2", SlotType.FRAME, 0, -0.65, 0, 0, 68, 80)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.PUSH_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.PUSH_ENGINE, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.ADVANCED_INTERNAL, 108, 100)
			.addEmptySlot("slotname.dscombat.internal_5", SlotType.ADVANCED_INTERNAL, 128, 100)
			.addEmptySlot("slotname.dscombat.internal_6", SlotType.ADVANCED_INTERNAL, 148, 100)
			.build();
	
	public static final AircraftPreset UNARMED_JAVI_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "javi_plane_unarmed", EMPTY_JAVI_PLANE)
			.setCraftable()
			.setSlotItem("slotname.dscombat.internal_1", ModItems.TURBOFAN_F25.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.TURBOFAN_F25.getId())
			.setSlotItem("slotname.dscombat.internal_3", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_4", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.addIngredient(ModItems.TURBOFAN_F25.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.build();
	
	public static final AircraftPreset DEFAULT_JAVI_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "javi_plane", UNARMED_JAVI_PLANE)
			.setCraftable()
			.setSlotItem("slotname.dscombat.left_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120b", true)
			.setSlotItem("slotname.dscombat.left_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "agm114k", true)
			.setSlotItem("slotname.dscombat.right_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "agm65l", true)
			.setSlotItem("slotname.dscombat.right_wing_2", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9p5", true)
			.setSlotItem("slotname.dscombat.frame_1", ModItems.XM12.getId(), "50mmhe", true)
			.setSlotItem("slotname.dscombat.frame_2", ModItems.HEAVY_MISSILE_RACK.getId(), "agm84e", true)
			.setSlotItem("slotname.dscombat.internal_5", ModItems.AR1K.getId())
			.setSlotItem("slotname.dscombat.internal_6", ModItems.GR400.getId())
			.addIngredient(ModItems.AR1K.getId())
			.addIngredient(ModItems.GR400.getId())
			.build();
	
	public static final AircraftPreset EMPTY_NOAH_CHOPPER = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "noah_chopper_empty")
			.setAircraftType(AircraftType.HELICOPTER)
			.setItem(ModItems.NOAH_CHOPPER.getId())
			.setMaxHealth(300f)
			.setMass(30f)
			.setMaxSpeed(0.8f)
			.setStealth(1.2f)
			.setIdleHeat(8f)
			.setTurnRadius(0f)
			.setMaxTurnRates(4f, 2f, 4f)
			.setTurnTorques(1f, 1f, 2.5f)
			.setThrottleRate(0.01f, 0.02f)
			.setHeliHoverMovement(0.04f, 0.02f)
			.addPilotSeatSlot(0.4, -0.65, 1.5, 48, 20)
			.addSeatSlot("slotname.dscombat.seat2", SlotType.TURRET, -0.4, -0.65, 1.5, 68, 20)
			.addSeatSlot("slotname.dscombat.seat3", SlotType.TURRET, 0.4, -0.65, 0.3, 88, 20)
			.addSeatSlot("slotname.dscombat.seat4", SlotType.TURRET, -0.4, -0.65, 0.3, 108, 20)
			.addEmptySlot("slotname.dscombat.left_wing_1", SlotType.WING, 0.75, -0.5, 1.8, 90, 48, 40)
			.addEmptySlot("slotname.dscombat.left_wing_2", SlotType.WING, 0.75, -0.5, 0.9, 90, 68, 40)
			.addEmptySlot("slotname.dscombat.left_wing_3", SlotType.WING, 0.75, -0.5, 0, 90, 88, 40)
			.addEmptySlot("slotname.dscombat.left_wing_4", SlotType.WING, 0.65, 0.5, 0, 90, 108, 40)
			.addEmptySlot("slotname.dscombat.right_wing_1", SlotType.WING, -0.75, -0.5, 1.8, -90, 48, 60)
			.addEmptySlot("slotname.dscombat.right_wing_2", SlotType.WING, -0.75, -0.5, 0.9, -90, 68, 60)
			.addEmptySlot("slotname.dscombat.right_wing_3", SlotType.WING, -0.75, -0.5, 0, -90, 88, 60)
			.addEmptySlot("slotname.dscombat.right_wing_4", SlotType.WING, -0.65, 0.5, 0, -90, 108, 60)
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.FRAME, 0, -0.67, 1.9, 0, 48, 80)
			.addEmptySlot("slotname.dscombat.frame_2", SlotType.FRAME, 0, -0.67, 1.1, 0, 68, 80)
			.addEmptySlot("slotname.dscombat.frame_3", SlotType.FRAME, 0, -0.67, 0.3, 0, 88, 80)
			.addEmptySlot("slotname.dscombat.frame_4", SlotType.FRAME, 0, -0.67, -0.5, 0, 108, 80)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.SPIN_ENGINE, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.INTERNAL, 108, 100)
			.addEmptySlot("slotname.dscombat.internal_5", SlotType.ADVANCED_INTERNAL, 128, 100)
			.addEmptySlot("slotname.dscombat.internal_6", SlotType.ADVANCED_INTERNAL, 148, 100)
			.addEmptySlot("slotname.dscombat.internal_7", SlotType.ADVANCED_INTERNAL, 168, 100)
			.addEmptySlot("slotname.dscombat.internal_8", SlotType.ADVANCED_INTERNAL, 188, 100)
			.setDefaultTexture(DyeColor.BROWN, "dscombat:textures/entities/noah_chopper/brown.png")
			.setAltTexture(DyeColor.BLUE, "dscombat:textures/entities/noah_chopper/blue.png")
			.setAltTexture(DyeColor.RED, "dscombat:textures/entities/noah_chopper/red.png")
			.setAltTexture(DyeColor.BLACK, "dscombat:textures/entities/noah_chopper/black.png")
			.addIngredient(ModItems.FUSELAGE.getId())
			.addIngredient(ModItems.LARGE_PROPELLER.getId(), 2)
			.addIngredient(ModItems.PROPELLER.getId())
			.addIngredient(ModItems.COCKPIT.getId())
			.addIngredient("minecraft:gold_ingot", 4)
			.build();
	
	public static final AircraftPreset UNARMED_NOAH_CHOPPER = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "noah_chopper_unarmed", EMPTY_NOAH_CHOPPER)
			.setCraftable()
			.setSlotItem("slotname.dscombat.internal_1", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_3", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_4", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.addIngredient(ModItems.C12_ENGINE.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.build();
	
	public static final AircraftPreset DEFAULT_NOAH_CHOPPER = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "noah_chopper", UNARMED_NOAH_CHOPPER)
			.setCraftable()
			.setSlotItem("slotname.dscombat.seat2", ModItems.MINIGUN_TURRET.getId())
			.setSlotItem("slotname.dscombat.left_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "aim120b", true)
			.setSlotItem("slotname.dscombat.left_wing_2", ModItems.HEAVY_MISSILE_RACK.getId(), "agm65g", true)
			.setSlotItem("slotname.dscombat.left_wing_3", ModItems.LIGHT_MISSILE_RACK.getId(), "agm114k", true)
			.setSlotItem("slotname.dscombat.right_wing_1", ModItems.HEAVY_MISSILE_RACK.getId(), "agm65l", true)
			.setSlotItem("slotname.dscombat.right_wing_2", ModItems.HEAVY_MISSILE_RACK.getId(), "agm84e", true)
			.setSlotItem("slotname.dscombat.right_wing_3", ModItems.LIGHT_MISSILE_RACK.getId(), "aim9p5", true)
			.setSlotItem("slotname.dscombat.frame_1", ModItems.XM12.getId(), "20mm", true)
			.setSlotItem("slotname.dscombat.frame_2", ModItems.XM12.getId(), "50mmhe", true)
			.setSlotItem("slotname.dscombat.internal_5", ModItems.AR500.getId())
			.setSlotItem("slotname.dscombat.internal_6", ModItems.GR400.getId())
			.addIngredient(ModItems.AR500.getId())
			.addIngredient(ModItems.GR400.getId())
			.addIngredient(ModItems.MINIGUN_TURRET.getId())
			.build();
	
	public static final AircraftPreset EMPTY_MRBUDGER_TANK = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "mrbudger_tank_empty")
			.setAircraftType(AircraftType.CAR)
			.setItem(ModItems.MRBUDGER_TANK.getId())
			.setMaxHealth(500f)
			.setMass(50f)
			.setMaxSpeed(0.3f)
			.setStealth(1.0f)
			.setIdleHeat(10f)
			.setTurnRadius(0f)
			.setMaxTurnRates(0f, 0f, 2f)
			.setTurnTorques(0f, 0f, 8f)
			.setThrottleRate(0.04f, 0.04f)
			.setDefaultTexture(DyeColor.YELLOW, "dscombat:textures/entities/mrbudger_tank/yellow.png")
			.setAltTexture(DyeColor.BLUE, "dscombat:textures/entities/mrbudger_tank/blue.png")
			.setAltTexture(DyeColor.RED, "dscombat:textures/entities/mrbudger_tank/red.png")
			.setAltTexture(DyeColor.BLACK, "dscombat:textures/entities/mrbudger_tank/black.png")
			.addIngredient("minecraft:minecart", 4)
			.addIngredient(ModItems.FUSELAGE.getId())
			.addIngredient(ModItems.SEAT.getId(), 4)
			.addIngredient("minecraft:gold_ingot", 4)
			.addSeatSlot(PartSlot.PILOT_SLOT_NAME, SlotType.HEAVY_TURRET, 0, 1.4, 0, 48, 20)
			.addSeatSlot("slotname.dscombat.seat1", SlotType.HEAVY_TURRET, 1, 1.4, 2, 68, 20)
			.addSeatSlot("slotname.dscombat.seat2", SlotType.HEAVY_TURRET, -1, 1.4, 2, 88, 20)
			.addSeatSlot("slotname.dscombat.seat3", SlotType.HEAVY_TURRET, 1, 1.4, -2, 108, 20)
			.addSeatSlot("slotname.dscombat.seat4", SlotType.HEAVY_TURRET, -1, 1.4, -2, 128, 20)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.SPIN_ENGINE, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.build();
	
	public static final AircraftPreset UNARMED_MRBUDGER_TANK = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "mrbudger_tank_unarmed", EMPTY_MRBUDGER_TANK)
			.setCraftable()
			.setSlotItem("slotname.dscombat.internal_1", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_3", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.addIngredient(ModItems.C12_ENGINE.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.build();
	
	public static final AircraftPreset DEFAULT_MRBUDGER_TANK = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "mrbudger_tank", UNARMED_MRBUDGER_TANK)
			.setCraftable()
			.setSlotItem(PartSlot.PILOT_SLOT_NAME, ModItems.HEAVY_TANK_TURRET.getId(), true)
			.addIngredient(ModItems.HEAVY_TANK_TURRET.getId())
			.build();
	
	public static final AircraftPreset EMPTY_SMALL_ROLLER = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "small_roller_empty")
			.setAircraftType(AircraftType.CAR)
			.setItem(ModItems.SMALL_ROLLER.getId())
			.setMaxHealth(30f)
			.setMass(5f)
			.setMaxSpeed(0.2f)
			.setStealth(1.0f)
			.setIdleHeat(1f)
			.setTurnRadius(0f)
			.setMaxTurnRates(0f, 0f, 3f)
			.setTurnTorques(0f, 0f, 10f)
			.setThrottleRate(0.08f, 0.08f)
			.setDefaultTexture(DyeColor.GRAY, "dscombat:textures/entities/small_roller.png")
			.addIngredient("minecraft:minecart", 2)
			.addIngredient(ModItems.FUSELAGE.getId())
			.addIngredient(ModItems.SEAT.getId(), 1)
			.addIngredient("minecraft:gold_ingot", 4)
			.addSeatSlot(PartSlot.PILOT_SLOT_NAME, SlotType.HEAVY_TURRET, 0, 0.6, 0, 48, 20)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100)
			.build();
	
	public static final AircraftPreset UNARMED_SMALL_ROLLER = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "small_roller_unarmed", EMPTY_SMALL_ROLLER)
			.setCraftable()
			.addIngredient(ModItems.C6_ENGINE.getId())
			.addIngredient(ModItems.LIGHT_FUEL_TANK.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.C6_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.LIGHT_FUEL_TANK.getId(), true)
			.build();
	
	public static final AircraftPreset DEFAULT_SMALL_ROLLER = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "small_roller", UNARMED_SMALL_ROLLER)
			.setCraftable()
			.setSlotItem(PartSlot.PILOT_SLOT_NAME, ModItems.STEVE_UP_SMASH.getId(), true)
			.addIngredient(ModItems.STEVE_UP_SMASH.getId())
			.build();
	
	public static final AircraftPreset EMPTY_NATHAN_BOAT = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "nathan_boat_empty")
			.setAircraftType(AircraftType.BOAT)
			.setItem(ModItems.NATHAN_BOAT.getId())
			.setMaxHealth(100f)
			.setMass(10f)
			.setMaxSpeed(0.85f)
			.setStealth(1.0f)
			.setIdleHeat(2f)
			.setTurnRadius(0f)
			.setMaxTurnRates(0f, 0f, 3.5f)
			.setTurnTorques(0f, 0f, 2f)
			.setThrottleRate(0.05f, 0.10f)
			.setDefaultTexture(DyeColor.WHITE, "dscombat:textures/entities/nathan_boat/white.png")
			.addIngredient("minecraft:boat", 4)
			.addIngredient(ModItems.FUSELAGE.getId())
			.addIngredient(ModItems.SEAT.getId(), 7)
			.addPilotSeatSlot(0.8, 1.2, -1.13, 48, 20)
			.addSeatSlot("slotname.dscombat.seat1", SlotType.TURRET, 0.65, 1.2, 2.44, 68, 20)
			.addSeatSlot("slotname.dscombat.seat2", SlotType.TURRET, -0.65, 1.2, 2.44, 88, 20)
			.addSeatSlot("slotname.dscombat.seat3", SlotType.TURRET, 0.65, 1.2, 1.25, 108, 20)
			.addSeatSlot("slotname.dscombat.seat4", SlotType.TURRET, -0.65, 1.2, 1.25, 128, 20)
			.addSeatSlot("slotname.dscombat.seat5", SlotType.TURRET, 0.65, 1.2, -0.06, 148, 20)
			.addSeatSlot("slotname.dscombat.seat6", SlotType.TURRET, -0.65, 1.2, -0.06, 168, 20)
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.FRAME, 1.5, 1, 0, 90, 48, 60)
			.addEmptySlot("slotname.dscombat.frame_2", SlotType.FRAME, -1.5, 1, 0, -90, 68, 60)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.PUSH_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.ADVANCED_INTERNAL, 108, 100)
			.build();
	
	public static final AircraftPreset UNARMED_NATHAN_BOAT = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "nathan_boat_unarmed", EMPTY_NATHAN_BOAT)
			.setCraftable()
			.addIngredient(ModItems.TURBOFAN_F145.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.TURBOFAN_F145.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_4", ModItems.WR400.getId())
			.build();
	
	public static final AircraftPreset DEFAULT_NATHAN_BOAT = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "nathan_boat", UNARMED_NATHAN_BOAT)
			.setCraftable()
			.addIngredient(ModItems.MINIGUN_TURRET.getId())
			.addIngredient(ModItems.WR400.getId())
			.setSlotItem("slotname.dscombat.seat1", ModItems.MINIGUN_TURRET.getId())
			.setSlotItem("slotname.dscombat.frame_1", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_2", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.build();
	
	public static final AircraftPreset EMPTY_ANDOLF_SUB = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "andolf_sub_empty")
			.setAircraftType(AircraftType.SUBMARINE)
			.setItem(ModItems.ANDOLF_SUB.getId())
			.setMaxHealth(800f)
			.setMass(200f)
			.setMaxSpeed(0.5f)
			.setStealth(0.6f)
			.setIdleHeat(10f)
			.setTurnRadius(0f)
			.setMaxTurnRates(2f, 2f, 2f)
			.setTurnTorques(1f, 1f, 1f)
			.setThrottleRate(0.04f, 0.04f)
			.setDefaultTexture(DyeColor.BLUE, "dscombat:textures/entities/andolf_sub/blue.png")
			.addIngredient("minecraft:minecart", 4)
			.addIngredient(ModItems.FUSELAGE.getId(), 3)
			.addIngredient(ModItems.SEAT.getId(), 6)
			.addIngredient("minecraft:gold_ingot", 4)
			.addPilotSeatSlot(0.6, -1.5, 2.8, 48, 20)
			.addSeatSlot("slotname.dscombat.seat1", -0.6, -1.5, 2.8, 68, 20)
			.addSeatSlot("slotname.dscombat.seat2", 0.6, -1.5, 1.6, 88, 20)
			.addSeatSlot("slotname.dscombat.seat3", -0.6, -1.5, 1.6, 108, 20)
			.addSeatSlot("slotname.dscombat.seat4", 0.6, -1.5, 0.4, 128, 20)
			.addSeatSlot("slotname.dscombat.seat5", -0.6, -1.5, 0.4, 148, 20)
			.addEmptySlot("slotname.dscombat.nose_1", SlotType.FRAME, 0, -1.6, 3.5, 0, 48, 80)
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.FRAME, 2, 0, 1, 90, 48, 60)
			.addEmptySlot("slotname.dscombat.frame_2", SlotType.FRAME, 2, 0, 0, 90, 68, 60)
			.addEmptySlot("slotname.dscombat.frame_3", SlotType.FRAME, 2, 0, -1, 90, 88, 60)
			.addEmptySlot("slotname.dscombat.frame_4", SlotType.FRAME, -2, 0, 1, -90, 108, 60)
			.addEmptySlot("slotname.dscombat.frame_5", SlotType.FRAME, -2, 0, 0, -90, 128, 60)
			.addEmptySlot("slotname.dscombat.frame_6", SlotType.FRAME, -2, 0, -1, -90, 148, 60)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.SPIN_ENGINE, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.ADVANCED_INTERNAL, 108, 100)
			.addEmptySlot("slotname.dscombat.internal_5", SlotType.ADVANCED_INTERNAL, 128, 100)
			.addEmptySlot("slotname.dscombat.internal_6", SlotType.ADVANCED_INTERNAL, 148, 100)
			.build();
			
	public static final AircraftPreset UNARMED_ANDOLF_SUB = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "andolf_sub_unarmed", EMPTY_ANDOLF_SUB)
			.setCraftable()
			.addIngredient(ModItems.C12_ENGINE.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_3", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.build();
	
	public static final AircraftPreset DEFAULT_ANDOLF_SUB = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "andolf_sub", UNARMED_ANDOLF_SUB)
			.setCraftable()
			.addIngredient(ModItems.WR1K.getId())
			.setSlotItem("slotname.dscombat.internal_4", ModItems.WR1K.getId())
			.setSlotItem("slotname.dscombat.nose_1", ModItems.XM12.getId(), "20mm", true)
			.setSlotItem("slotname.dscombat.frame_1", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_2", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_3", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_4", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_5", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.setSlotItem("slotname.dscombat.frame_6", ModItems.HEAVY_MISSILE_RACK.getId(), "torpedo1", true)
			.build();
	
	public static final AircraftPreset DEFAULT_ORANGE_TESLA = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "orange_tesla")
			.setAircraftType(AircraftType.CAR)
			.setItem(ModItems.ORANGE_TESLA.getId())
			.setCraftable()
			.setMaxHealth(40f)
			.setMass(8f)
			.setMaxSpeed(0.65f)
			.setStealth(1.0f)
			.setIdleHeat(4f)
			.setTurnRadius(7f)
			.setMaxTurnRates(0f, 0f, 4f)
			.setTurnTorques(0f, 0f, 1f)
			.setThrottleRate(0.07f, 0.07f)
			.addPilotSeatSlot(0.5, 0.45, 0.3, 48, 20)
			.addSeatSlot("slotname.dscombat.seat1", -0.5, 0.45, 0.3, 68, 20)
			.addSeatSlot("slotname.dscombat.seat2", 0.5, 0.45, -0.85, 88, 20)
			.addSeatSlot("slotname.dscombat.seat3", -0.5, 0.45, -0.85, 108, 20)
			.addItemSlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 100, ModItems.C6_ENGINE.getId())
			.addItemSlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100, ModItems.LIGHT_FUEL_TANK.getId(), true)
			.setDefaultTexture(DyeColor.ORANGE, "dscombat:textures/entities/orange_tesla/orange.png")
			.addIngredient("minecraft:minecart", 4)
			.addIngredient(ModItems.FUSELAGE.getId(), 1)
			.addIngredient(ModItems.SEAT.getId(), 4)
			.addIngredient(ModItems.C6_ENGINE.getId())
			.addIngredient(ModItems.LIGHT_FUEL_TANK.getId())
			.build();
	
	public static final AircraftPreset EMPTY_WOODEN_PLANE = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "wooden_plane_empty")
			.setAircraftType(AircraftType.PLANE)
			.setItem(ModItems.WOODEN_PLANE.getId())
			.setMaxHealth(40f)
			.setMass(8f)
			.setMaxSpeed(0.9f)
			.setStealth(1.0f)
			.setIdleHeat(1f)
			.setTurnRadius(16f)
			.setMaxTurnRates(5f, 3.0f, 2.0f)
			.setTurnTorques(1.5f, 2.5f, 4.5f)
			.setThrottleRate(0.02f, 0.06f)
			.setPlaneWingArea(6f)
			.setDefaultTexture(DyeColor.BROWN, "dscombat:textures/entities/wooden_plane/brown.png")
			.addIngredient("minecraft:oak_planks", 60)
			.addIngredient(ModItems.COCKPIT.getId())
			.addPilotSeatSlot(0, -0.4, 0, 48, 20)
			.addEmptySlot("slotname.dscombat.left_wing_1", SlotType.WING, 1.5, 0, 0, 0, 48, 40)
			.addEmptySlot("slotname.dscombat.right_wing_1", SlotType.WING, -1.5, 0, 0, 0, 48, 60)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.RADIAL_ENGINE, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.build();
	
	public static final AircraftPreset DEFAULT_WOODEN_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "wooden_plane", EMPTY_WOODEN_PLANE)
			.setCraftable()
			.addIngredient(ModItems.CM_MANLY_52.getId())
			.addIngredient(ModItems.LIGHT_FUEL_TANK.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.CM_MANLY_52.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.LIGHT_FUEL_TANK.getId(), true)
			.build();
	
	public static final AircraftPreset EMPTY_E3SENTRY_PLANE = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "e3sentry_plane_empty")
			.setAircraftType(AircraftType.PLANE)
			.setItem(ModItems.E3SENTRY_PLANE.getId())
			.setMaxHealth(400f)
			.setMass(60f)
			.setMaxSpeed(1.0f)
			.setStealth(1.3f)
			.setIdleHeat(20f)
			.setTurnRadius(40f)
			.setMaxTurnRates(3f, 2.0f, 2.0f)
			.setTurnTorques(2.0f, 2.0f, 2.0f)
			.setThrottleRate(0.01f, 0.04f)
			.setPlaneWingArea(30f)
			.setDefaultTexture(DyeColor.GRAY, "dscombat:textures/entities/e3sentry_plane/gray.png")
			.addIngredient(ModItems.ADVANCED_COCKPIT.getId())
			.addIngredient(ModItems.SEAT.getId(), 11)
			.addPilotSeatSlot(0.5, -1.35, 4.7, 48, 20)
			.addSeatSlot("slotname.dscombat.seat1", -0.5, -1.35, 4.7, 48, 40)
			.addSeatSlot("slotname.dscombat.seat2", 0.5, -1.35, 3, 68, 20)
			.addSeatSlot("slotname.dscombat.seat3", 0.5, -1.35, 1.5, 88, 20)
			.addSeatSlot("slotname.dscombat.seat4", 0.5, -1.35, 0, 108, 20)
			.addSeatSlot("slotname.dscombat.seat5", 0.5, -1.35, -1.5, 128, 20)
			.addSeatSlot("slotname.dscombat.seat6", 0.5, -1.35, -3, 148, 20)
			.addSeatSlot("slotname.dscombat.seat7", -0.5, -1.35, 3, 68, 40)
			.addSeatSlot("slotname.dscombat.seat8", -0.5, -1.35, 1.5, 88, 40)
			.addSeatSlot("slotname.dscombat.seat9", -0.5, -1.35, 0, 108, 40)
			.addSeatSlot("slotname.dscombat.seat10", -0.5, -1.35, -1.5, 128, 40)
			.addSeatSlot("slotname.dscombat.seat11", -0.5, -1.35, -3, 148, 40)
			.addEmptySlot("slotname.dscombat.left_wing_1", SlotType.WING, 4, -0.6, 0.5, 0, 48, 60)
			.addEmptySlot("slotname.dscombat.right_wing_1", SlotType.WING, -4, -0.6, 0.5, 0, 68, 60)
			.addEmptySlot("slotname.dscombat.left_wing_2", SlotType.WING, 6,-0.6, 0.5, 0, 88, 60)
			.addEmptySlot("slotname.dscombat.right_wing_2", SlotType.WING, -6, -0.6, 0.5, 0, 108, 60)
			.addEmptySlot("slotname.dscombat.frame_1", SlotType.HEAVY_FRAME, 0, 0.8, -1.3, 180, 48, 80)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.INTERNAL, 48, 100)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 100)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.INTERNAL, 88, 100)
			.addEmptySlot("slotname.dscombat.internal_4", SlotType.INTERNAL, 108, 100)
			.addEmptySlot("slotname.dscombat.internal_5", SlotType.ADVANCED_INTERNAL, 128, 100)
			.addEmptySlot("slotname.dscombat.internal_6", SlotType.ADVANCED_INTERNAL, 148, 100)
			.addEmptySlot("slotname.dscombat.internal_7", SlotType.ADVANCED_INTERNAL, 168, 100)
			.addEmptySlot("slotname.dscombat.internal_8", SlotType.ADVANCED_INTERNAL, 188, 100)
			.build();
	
	public static final AircraftPreset DEFAULT_E3SENTRY_PLANE = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "e3sentry_plane", EMPTY_E3SENTRY_PLANE)
			.setCraftable()
			.addIngredient(ModItems.CFM56.getId(), 2)
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId(), 2)
			.addIngredient(ModItems.AR20K.getId())
			.addIngredient(ModItems.DATA_LINK.getId())
			.addIngredient(ModItems.BASIC_FLARE_DISPENSER.getId())
			.setSlotItem("slotname.dscombat.left_wing_1", ModItems.CFM56.getId())
			.setSlotItem("slotname.dscombat.right_wing_1", ModItems.CFM56.getId())
			.setSlotItem("slotname.dscombat.frame_1", ModItems.AR20K.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_2", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.setSlotItem("slotname.dscombat.internal_3", ModItems.BASIC_FLARE_DISPENSER.getId(), true)
			.setSlotItem("slotname.dscombat.internal_5", ModItems.DATA_LINK.getId())
			.build();
	
	public static final AircraftPreset EMPTY_AXCEL_TRUCK = AircraftPreset.Builder
			.create(DSCombatMod.MODID, "axcel_truck_empty")
			.setAircraftType(AircraftType.CAR)
			.setItem(ModItems.AXCEL_TRUCK.getId())
			.setMaxHealth(80f)
			.setMass(15f)
			.setMaxSpeed(0.5f)
			.setStealth(1.0f)
			.setIdleHeat(6f)
			.setTurnRadius(11f)
			.setMaxTurnRates(0f, 0f, 4f)
			.setTurnTorques(0f, 0f, 1f)
			.setThrottleRate(0.05f, 0.05f)
			.addPilotSeatSlot(0.5, 0.9, 1, 48, 20)
			.addSeatSlot("slotname.dscombat.seat2", -0.5, 0.9, 1, 68, 20)
			.setDefaultTexture(DyeColor.YELLOW, "dscombat:textures/entities/axcel_truck/yellow.png")
			.addIngredient("minecraft:minecart", 4)
			.addIngredient(ModItems.FUSELAGE.getId(), 1)
			.addIngredient(ModItems.SEAT.getId(), 2)
			.addIngredient(ModItems.AR2K.getId())
			.addEmptySlot("slotname.dscombat.cargo_bed_1", SlotType.HEAVY_TURRET, 0, 0.95, -1.5, 0, 48, 40)
			.addEmptySlot("slotname.dscombat.internal_1", SlotType.SPIN_ENGINE, 48, 60)
			.addEmptySlot("slotname.dscombat.internal_2", SlotType.INTERNAL, 68, 60)
			.addEmptySlot("slotname.dscombat.internal_3", SlotType.ADVANCED_INTERNAL, 88, 60)
			.setSlotItem("slotname.dscombat.internal_3", ModItems.AXCEL_TRUCK_RADAR.getId())
			.lockSlot("slotname.dscombat.internal_3")
			.build();
	
	public static final AircraftPreset DEFAULT_AXCEL_TRUCK = AircraftPreset.Builder
			.createFromCopy(DSCombatMod.MODID, "axcel_truck", EMPTY_AXCEL_TRUCK)
			.setCraftable()
			.addIngredient(ModItems.SAM_LAUNCHER.getId())
			.addIngredient(ModItems.C12_ENGINE.getId())
			.addIngredient(ModItems.HEAVY_FUEL_TANK.getId())
			.setSlotItem("slotname.dscombat.cargo_bed_1", ModItems.SAM_LAUNCHER.getId())
			.setSlotItem("slotname.dscombat.internal_1", ModItems.C12_ENGINE.getId())
			.setSlotItem("slotname.dscombat.internal_2", ModItems.HEAVY_FUEL_TANK.getId(), true)
			.build();
			
}
