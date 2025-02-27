package com.onewhohears.dscombat.data.vehicle.client;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.client.model.obj.customanims.CustomAnimsBuilder;
import com.onewhohears.dscombat.client.model.obj.customanims.VehicleModelTransform.InputAxis;
import com.onewhohears.dscombat.client.model.obj.customanims.VehicleModelTransform.RotationAxis;
import com.onewhohears.dscombat.data.jsonpreset.JsonPresetGenerator;
import com.onewhohears.dscombat.data.parts.PartSlot;

import net.minecraft.data.DataGenerator;

public class VehicleClientPresetGenerator extends JsonPresetGenerator<VehicleClientStats> {
	
	@Override
	protected void registerPresets() {
		int alexis_middle_x = 120, alexis_wing_y = 57;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "alexis_plane")
				.setHardCodedModelAnims()
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/alexis_plane.png")
				.addUIPos("internal_gun", alexis_middle_x, 2)
				.addUIPos(PartSlot.PILOT_SLOT_NAME, alexis_middle_x, 21)
				.addUIPos("internal_4", alexis_middle_x-9, 40)
				.addUIPos("internal_5", alexis_middle_x+9, 40)
				.addUIPos("internal_6", alexis_middle_x, 58)
				.addUIPos("internal_3", alexis_middle_x+9, 78)
				.addUIPos("internal_2", alexis_middle_x-9, 78)
				.addUIPos("internal_1", alexis_middle_x, 100)
				.addUIPos("left_wing_1", alexis_middle_x-27, alexis_wing_y)
				.addUIPos("left_wing_2", alexis_middle_x-45, alexis_wing_y)
				.addUIPos("left_wing_3", alexis_middle_x-63, alexis_wing_y)
				.addUIPos("left_wing_4", alexis_middle_x-81, alexis_wing_y)
				.addUIPos("right_wing_1", alexis_middle_x+27, alexis_wing_y)
				.addUIPos("right_wing_2", alexis_middle_x+45, alexis_wing_y)
				.addUIPos("right_wing_3", alexis_middle_x+63, alexis_wing_y)
				.addUIPos("right_wing_4", alexis_middle_x+81, alexis_wing_y)
				.build());
		int javi_middle_x = 124, javi_wing_y = 50;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "javi_plane")
				.setHardCodedModelAnims()
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/javi_plane.png")
				.addUIPos("internal_gun", javi_middle_x+18, 0)
				.addUIPos(PartSlot.PILOT_SLOT_NAME, javi_middle_x, 9)
				.addUIPos("seat2", javi_middle_x, 27)
				.addUIPos("internal_4", javi_middle_x+9, 70)
				.addUIPos("internal_5", javi_middle_x-9, 70)
				.addUIPos("internal_6", javi_middle_x+9, 106)
				.addUIPos("internal_3", javi_middle_x-9, 106)
				.addUIPos("internal_1", javi_middle_x+12, 88)
				.addUIPos("internal_2", javi_middle_x-12, 88)
				.addUIPos("frame_2", javi_middle_x, javi_wing_y)
				.addUIPos("left_wing_1", javi_middle_x-18, javi_wing_y)
				.addUIPos("left_wing_2", javi_middle_x-36, javi_wing_y)
				.addUIPos("left_wing_3", javi_middle_x-54, javi_wing_y)
				.addUIPos("left_wing_4", javi_middle_x-72, javi_wing_y)
				.addUIPos("right_wing_1", javi_middle_x+18, javi_wing_y)
				.addUIPos("right_wing_2", javi_middle_x+36, javi_wing_y)
				.addUIPos("right_wing_3", javi_middle_x+54, javi_wing_y)
				.addUIPos("right_wing_4", javi_middle_x+72, javi_wing_y)
				.build());
		int noah_middle_x = 120, noah_seat1_y = 14;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "noah_chopper")
				.setCustomAnims("noah_chopper", CustomAnimsBuilder.create()
						.addMotorRotAnim("blade_main", 0, 23, 12, RotationAxis.Y, 50)
						.addMotorRotAnim("blade_back", 3, 7, -59, RotationAxis.X, 31)
						.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/noah_chopper.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, noah_middle_x-18, noah_seat1_y)
				.addUIPos("seat2", noah_middle_x+18, noah_seat1_y)
				.addUIPos("seat3", noah_middle_x-18, noah_seat1_y+18)
				.addUIPos("seat4", noah_middle_x+18, noah_seat1_y+18)
				.addUIPos("frame_1", noah_middle_x, noah_seat1_y)
				.addUIPos("frame_2", noah_middle_x, noah_seat1_y+18)
				.addUIPos("frame_3", noah_middle_x, noah_seat1_y+18*2)
				.addUIPos("frame_4", noah_middle_x, noah_seat1_y+18*3)
				.addUIPos("left_wing_1", noah_middle_x-36, noah_seat1_y)
				.addUIPos("left_wing_2", noah_middle_x-36, noah_seat1_y+18)
				.addUIPos("left_wing_3", noah_middle_x-36, noah_seat1_y+18*2)
				.addUIPos("left_wing_4", noah_middle_x-36, noah_seat1_y+18*3)
				.addUIPos("right_wing_1", noah_middle_x+36, noah_seat1_y)
				.addUIPos("right_wing_2", noah_middle_x+36, noah_seat1_y+18)
				.addUIPos("right_wing_3", noah_middle_x+36, noah_seat1_y+18*2)
				.addUIPos("right_wing_4", noah_middle_x+36, noah_seat1_y+18*3)
				.addUIPos("internal_1", noah_middle_x-18, noah_seat1_y+18*2)
				.addUIPos("internal_2", noah_middle_x+18, noah_seat1_y+18*2)
				.addUIPos("internal_3", noah_middle_x-18, noah_seat1_y+18*3)
				.addUIPos("internal_4", noah_middle_x+18, noah_seat1_y+18*3)
				.addUIPos("internal_5", noah_middle_x-9, noah_seat1_y+18*4)
				.addUIPos("internal_6", noah_middle_x+9, noah_seat1_y+18*4)
				.addUIPos("internal_7", noah_middle_x-9, noah_seat1_y+18*5)
				.addUIPos("internal_8", noah_middle_x+9, noah_seat1_y+18*5)
				.build());
		int bud_middle_x = 120;
		float wheel_rot_rate = 160;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "mrbudger_tank")
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/mrbudger_tank.png")
				.setCustomAnims(CustomAnimsBuilder.create()
						.addWheelRotAnim("wl0", 0, 8, 30, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wl1", 0, 8, 15, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wl2", 0, 8, 0, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wl3", 0, 8, -15, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wl4", 0, 8, -30, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr0", 0, 8, 30, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr1", 0, 8, 15, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr2", 0, 8, 0, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr3", 0, 8, -15, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr4", 0, 8, -30, RotationAxis.X, wheel_rot_rate)
						.build())
				.addUIPos(PartSlot.PILOT_SLOT_NAME, bud_middle_x, 50)
				.addUIPos("seat1", bud_middle_x+20, 12)
				.addUIPos("seat2", bud_middle_x-20, 12)
				.addUIPos("seat3", bud_middle_x+20, 90)
				.addUIPos("seat4", bud_middle_x-20, 90)
				.addUIPos("internal_1", bud_middle_x-9, 30)
				.addUIPos("internal_2", bud_middle_x+9, 30)
				.addUIPos("internal_3", bud_middle_x-9, 70)
				.addUIPos("internal_4", bud_middle_x+9, 70)
				.build());
		int roller_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "small_roller")
				.setCustomAnims(CustomAnimsBuilder.create()
						.addWheelRotAnim("wl0", 0, 6.5f, 6.5f, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wl1", 0, 6.5f, -6.5f, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr0", 0, 6.5f, 6.5f, RotationAxis.X, wheel_rot_rate)
						.addWheelRotAnim("wr1", 0, 6.5f, -6.5f, RotationAxis.X, wheel_rot_rate)
						.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/small_roller.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, roller_middle_x, 50)
				.addUIPos("internal_1", roller_middle_x-9, 70)
				.addUIPos("internal_2", roller_middle_x+9, 70)
				.build());
		int nathan_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "nathan_boat")
				.setCustomAnims(CustomAnimsBuilder.create()
					.addMotorRotAnim("rudder/blade", 0, -4, -36, RotationAxis.Z, 43)
					.addInputBoundRotAnim("rudder", 0, 11, -20, RotationAxis.Y, InputAxis.YAW, 15)
					.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/nathan_boat.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, nathan_middle_x-18, 42+18*3)
				.addUIPos("seat1", nathan_middle_x-18, 42)
				.addUIPos("seat2", nathan_middle_x+18, 42)
				.addUIPos("seat3", nathan_middle_x-18, 42+18)
				.addUIPos("seat4", nathan_middle_x+18, 42+18)
				.addUIPos("seat5", nathan_middle_x-18, 42+18*2)
				.addUIPos("seat6", nathan_middle_x+18, 42+18*2)
				.addUIPos("frame_1", nathan_middle_x-54, 60)
				.addUIPos("frame_2", nathan_middle_x+54, 60)
				.addUIPos("internal_1", nathan_middle_x, 42+18*3)
				.addUIPos("internal_2", nathan_middle_x, 42+18*2)
				.addUIPos("internal_3", nathan_middle_x, 42+18)
				.addUIPos("internal_4", nathan_middle_x, 42)
				.build());
		int andolf_middle_x = 117;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "andolf_sub")
				.setCustomAnims(CustomAnimsBuilder.create()
						.addMotorRotAnim("propellor", 0, -1, -58, RotationAxis.Z, 19)
						.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/andolf_sub.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, andolf_middle_x-9, 25)
				.addUIPos("seat1", andolf_middle_x+9, 25)
				.addUIPos("seat2", andolf_middle_x-9, 25+18)
				.addUIPos("seat3", andolf_middle_x+9, 25+18)
				.addUIPos("seat4", andolf_middle_x-9, 25+36)
				.addUIPos("seat5", andolf_middle_x+9, 25+36)
				.addUIPos("nose_1", andolf_middle_x, 7)
				.addUIPos("frame_1", andolf_middle_x-42, 35)
				.addUIPos("frame_2", andolf_middle_x-42, 35+18)
				.addUIPos("frame_3", andolf_middle_x-42, 35+36)
				.addUIPos("frame_4", andolf_middle_x+42, 35)
				.addUIPos("frame_5", andolf_middle_x+42, 35+18)
				.addUIPos("frame_6", andolf_middle_x+42, 35+36)
				.addUIPos("internal_1", andolf_middle_x-18, 80)
				.addUIPos("internal_2", andolf_middle_x, 80)
				.addUIPos("internal_3", andolf_middle_x+18, 80)
				.addUIPos("internal_4", andolf_middle_x-18, 98)
				.addUIPos("internal_5", andolf_middle_x, 98)
				.addUIPos("internal_6", andolf_middle_x+18, 98)
				.build());
		int orange_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "orange_tesla")
				.setCustomAnims(CustomAnimsBuilder.create()
					.addInputBoundRotAnim("wheel", 8, 19, 13, RotationAxis.Z, InputAxis.YAW, 40)
					.addInputBoundRotAnim("wl0", 16, 6, 21, RotationAxis.Y, InputAxis.YAW, -40)
					.addInputBoundRotAnim("wr0", -16, 6, 21, RotationAxis.Y, InputAxis.YAW, -40)
					.addWheelRotAnim("wl0", 16, 6, 21, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wl1", 16, 6, -19, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wr0", -16, 6, 21, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wr1", -16, 6, -19, RotationAxis.X, wheel_rot_rate)
					.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/orange_tesla.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, orange_middle_x-18, 50)
				.addUIPos("seat1", orange_middle_x+18, 50)
				.addUIPos("seat2", orange_middle_x-18, 70)
				.addUIPos("seat3", orange_middle_x+18, 70)
				.addUIPos("internal_1", orange_middle_x, 25)
				.addUIPos("internal_2", orange_middle_x, 45)
				.build());
		int wood_middle_x = 118;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "wooden_plane")
				.setCustomAnims(CustomAnimsBuilder.create()
						.addMotorRotAnim("blade", 0, 0, 20, RotationAxis.Z, 30)
						.addLandingGearAnim("gear_front", 0, -6.5f, 4.5f, RotationAxis.X, 90)
						.addLandingGearAnim("gear_back", 0, -6f, -26.5f, RotationAxis.X, -90)
						.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/wooden_plane.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, wood_middle_x, 43)
				.addUIPos("left_wing_1", wood_middle_x-30, 43)
				.addUIPos("right_wing_1", wood_middle_x+30, 43)
				.addUIPos("internal_1", wood_middle_x, 25)
				.addUIPos("internal_2", wood_middle_x, 61)
				.addUIPos("internal_3", wood_middle_x, 79)
				.build());
		int e3sentry_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "e3sentry_plane")
				.setCustomAnims(CustomAnimsBuilder.create()
					.addLandingGearAnim("gear_front", 0, -21, 56, RotationAxis.X, 90)
					.addLandingGearAnim("gear_left", 32, -10, 11, RotationAxis.Z, -90)
					.addLandingGearAnim("gear_right", -32, -10, 11, RotationAxis.Z, 90)
					.addSpinningRadarAnim("radar", 0, 21, -24, RotationAxis.Y, 2, "ar20k")
					.addInputBoundRotAnim("stick", 8, -20, 83.5f, RotationAxis.Z, InputAxis.ROLL, 23)
					.addInputBoundRotAnim("stick", 8, -20, 83.5f, RotationAxis.X, InputAxis.PITCH, -15)
					.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/e3sentry_plane.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, e3sentry_middle_x-18, 5)
				.addUIPos("seat2", e3sentry_middle_x-18, 5+18)
				.addUIPos("seat3", e3sentry_middle_x-18, 5+18*2)
				.addUIPos("seat4", e3sentry_middle_x-18, 5+18*3)
				.addUIPos("seat5", e3sentry_middle_x-18, 5+18*4)
				.addUIPos("seat6", e3sentry_middle_x-18, 5+18*5)
				.addUIPos("seat1", e3sentry_middle_x+18, 5)
				.addUIPos("seat7", e3sentry_middle_x+18, 5+18)
				.addUIPos("seat8", e3sentry_middle_x+18, 5+18*2)
				.addUIPos("seat9", e3sentry_middle_x+18, 5+18*3)
				.addUIPos("seat10", e3sentry_middle_x+18, 5+18*4)
				.addUIPos("seat11", e3sentry_middle_x+18, 5+18*5)
				.addUIPos("left_wing_1", e3sentry_middle_x-40, 50)
				.addUIPos("left_wing_2", e3sentry_middle_x-60, 50)
				.addUIPos("right_wing_1", e3sentry_middle_x+40, 50)
				.addUIPos("right_wing_2", e3sentry_middle_x+60, 50)
				.addUIPos("frame_1", e3sentry_middle_x, 5+18*3)
				.addUIPos("internal_1", e3sentry_middle_x, 5)
				.addUIPos("internal_2", e3sentry_middle_x, 5+18)
				.addUIPos("internal_3", e3sentry_middle_x, 5+18*2)
				.addUIPos("internal_4", e3sentry_middle_x, 5+18*4)
				.addUIPos("internal_5", e3sentry_middle_x, 5+18*5)
				.addUIPos("internal_6", e3sentry_middle_x-36, 5+18*5)
				.addUIPos("internal_7", e3sentry_middle_x, 5+18*6)
				.addUIPos("internal_8", e3sentry_middle_x+36, 5+18*5)
				.build());
		int axcel_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "axcel_truck")
				.setCustomAnims(CustomAnimsBuilder.create()
					.addSpinningRadarAnim("radar", 1, 46, 15, RotationAxis.Y, 4.8f, "axcel_truck_radar")
					.addInputBoundRotAnim("wheel", 7, 27, 26, RotationAxis.Z, InputAxis.YAW, 40)
					.addInputBoundRotAnim("wl0", 15.875f, 6.0082f, 13.985f, RotationAxis.Y, InputAxis.YAW, -40)
					.addInputBoundRotAnim("wr0", -15.875f, 6.0082f, 13.985f, RotationAxis.Y, InputAxis.YAW, -40)
					.addWheelRotAnim("wl0", 15.875f, 6.0082f, 13.985f, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wr0", -15.875f, 6.0082f, 13.985f, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wl1", 15.875f, 6.0082f, -35.015f, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wr1", -15.875f, 6.0082f, -35.015f, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wl2", 15.875f, 6.0082f, -50.015f, RotationAxis.X, wheel_rot_rate)
					.addWheelRotAnim("wr2", -15.875f, 6.0082f, -50.015f, RotationAxis.X, wheel_rot_rate)
					.build())
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/axcel_truck.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, axcel_middle_x-9, 20)
				.addUIPos("seat2", axcel_middle_x+9, 20)
				.addUIPos("frame_1", axcel_middle_x, 40)
				.addUIPos("cargo_bed_1", axcel_middle_x, 80)
				.addUIPos("internal_1", axcel_middle_x-9, 60)
				.addUIPos("internal_2", axcel_middle_x+9, 60)
				.addUIPos("internal_3", axcel_middle_x-9, 100)
				.addUIPos("internal_4", axcel_middle_x+9, 100)
				.build());
		int gronk_middle_x = 120;
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "gronk_battleship")
				.setHardCodedModelAnims()
				.setBackground("dscombat:textures/ui/vehicle_inventory_backgrounds/gronk_battleship.png")
				.addUIPos(PartSlot.PILOT_SLOT_NAME, gronk_middle_x-9, 40)
				.addUIPos("seat2", gronk_middle_x+9, 40)
				.addUIPos("seat3", gronk_middle_x-9, 40+18*2)
				.addUIPos("seat4", gronk_middle_x+9, 40+18*2)
				.addUIPos("seat5", gronk_middle_x-9, 40-18)
				.addUIPos("seat6", gronk_middle_x-9, 40+18*3)
				.addUIPos("seat7", gronk_middle_x, 40-18*2)
				.addUIPos("seat8", gronk_middle_x, 40+18*4)
				.addUIPos("seat9", gronk_middle_x+9, 40-18)
				.addUIPos("seat10", gronk_middle_x+9, 40+18*3)
				.addUIPos("frame_1", gronk_middle_x, 40+18)
				.addUIPos("frame_2", gronk_middle_x-45, 40)
				.addUIPos("frame_3", gronk_middle_x+45, 40)
				.addUIPos("frame_4", gronk_middle_x-45, 40+18*2)
				.addUIPos("frame_5", gronk_middle_x+45, 40+18*2)
				.addUIPos("internal_1", gronk_middle_x-27, 40+18*3)
				.addUIPos("internal_2", gronk_middle_x+27, 40+18*3)
				.addUIPos("internal_3", gronk_middle_x-27, 40)
				.addUIPos("internal_4", gronk_middle_x+27, 40)
				.addUIPos("internal_5", gronk_middle_x-27, 40+18*2)
				.addUIPos("internal_6", gronk_middle_x+27, 40+18*2)
				.addUIPos("internal_7", gronk_middle_x-18*2, 40+18)
				.addUIPos("internal_8", gronk_middle_x-18, 40+18)
				.addUIPos("internal_9", gronk_middle_x+18, 40+18)
				.addUIPos("internal_10", gronk_middle_x+18*2, 40+18)
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "bronco_plane")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "corvette")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "eden_plane")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "felix_plane")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "google_sub")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "jason_plane")
				.setHardCodedModelAnims()
				.build());
		addPresetToGenerate(VehicleClientStats.Builder.create(DSCombatMod.MODID, "aircraft_carrier")
				.setSimpleModelId("carrier")
				.build());
	}
	
	public VehicleClientPresetGenerator(DataGenerator output) {
		super(output, "aircraft_client", DataGenerator.Target.RESOURCE_PACK);
	}

	@Override
	public String getName() {
		return "Aircraft Client: "+DSCombatMod.MODID;
	}

}
