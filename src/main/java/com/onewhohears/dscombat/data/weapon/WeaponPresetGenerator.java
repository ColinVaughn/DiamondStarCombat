package com.onewhohears.dscombat.data.weapon;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.JsonPresetGenerator;
import com.onewhohears.dscombat.data.weapon.TrackMissileData.TargetType;
import com.onewhohears.dscombat.init.ModEntities;
import com.onewhohears.dscombat.init.ModItems;
import com.onewhohears.dscombat.init.ModSounds;

import net.minecraft.data.DataGenerator;

public class WeaponPresetGenerator extends JsonPresetGenerator<WeaponData>{
	
	protected void registerBullets() {
		// max ammo cost: 63 copper
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "10mm")
				.setFireRate(1)
				.setInnacuracy(2.2f)
				.setCanShootOnGround(true)
				.setDamage(6f)
				.setSpeed(12f)
				.setExplosionRadius(0)
				.setExplosive(false)
				.setDestoryTerrain(false)
				.setCausesFire(false)
				.setMaxAmmo(1000)
				.setMaxAge(40)
				.setItem(ModItems.BULLET.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setRackEntityType(ModEntities.XM12.getId())
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.XM12.getId())
				.setCraftNum(64)
				.addIngredient("minecraft:copper_ingot", 4)
				.build());
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "15mm")
				.setFireRate(2)
				.setInnacuracy(1.8f)
				.setCanShootOnGround(true)
				.setDamage(9f)
				.setSpeed(11f)
				.setExplosionRadius(0)
				.setExplosive(false)
				.setDestoryTerrain(false)
				.setCausesFire(false)
				.setMaxAmmo(750)
				.setMaxAge(40)
				.setItem(ModItems.BULLET.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setRackEntityType(ModEntities.XM12.getId())
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.XM12.getId())
				.setCraftNum(48)
				.addIngredient("minecraft:copper_ingot", 4)
				.build());
		// max ammo cost: 63 copper
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "20mm")
				.setFireRate(1)
				.setInnacuracy(1.1f)
				.setCanShootOnGround(true)
				.setDamage(12f)
				.setSpeed(10f)
				.setExplosionRadius(0)
				.setExplosive(false)
				.setDestoryTerrain(false)
				.setCausesFire(false)
				.setMaxAmmo(500)
				.setMaxAge(40)
				.setItem(ModItems.B_20MM.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setRackEntityType(ModEntities.XM12.getId())
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.XM12.getId())
				.setCraftNum(32)
				.addIngredient("minecraft:copper_ingot", 4)
				.build());
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "20mmhe")
				.setFireRate(1)
				.setInnacuracy(1.2f)
				.setCanShootOnGround(true)
				.setDamage(12f)
				.setSpeed(10f)
				.setExplosionRadius(1.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(500)
				.setMaxAge(40)
				.setItem(ModItems.B_20MM.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setRackEntityType(ModEntities.XM12.getId())
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.XM12.getId())
				.setCraftNum(32)
				.addIngredient("minecraft:copper_ingot", 4)
				.addIngredient("minecraft:gunpowder", 8)
				.build());
		// max ammo cost: 125 copper, 78 gun powder
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "50mmhe")
				.setFireRate(4)
				.setInnacuracy(1.0f)
				.setCanShootOnGround(true)
				.setDamage(20f)
				.setSpeed(9f)
				.setExplosionRadius(3f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(250)
				.setMaxAge(40)
				.setItem(ModItems.B_50MMHE.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setRackEntityType(ModEntities.XM12.getId())
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.XM12.getId())
				.setCraftNum(16)
				.addIngredient("minecraft:copper_ingot", 8)
				.addIngredient("minecraft:gunpowder", 10)
				.build());
		// max ammo cost: 64 copper, 80 gunpowder
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "120mmhe")
				.setFireRate(30)
				.setInnacuracy(0.4f)
				.setCanShootOnGround(true)
				.setDamage(40f)
				.setSpeed(8f)
				.setExplosionRadius(4.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(16)
				.setMaxAge(40)
				.setItem(ModItems.B_120MMHE.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setNoRack()
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setNoCompatible()
				.setCraftNum(1)
				.addIngredient("minecraft:copper_ingot", 4)
				.addIngredient("minecraft:gunpowder", 6)
				.build());
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "406mmhe")
				.setFireRate(60)
				.setInnacuracy(1.1f)
				.setCanShootOnGround(true)
				.setDamage(70f)
				.setSpeed(5f)
				.setExplosionRadius(7f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(36)
				.setMaxAge(40)
				.setItem(ModItems.B_120MMHE.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setNoRack()
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setNoCompatible()
				.setCraftNum(1)
				.addIngredient("minecraft:copper_ingot", 10)
				.addIngredient("minecraft:gunpowder", 8)
				.build());
		addPresetToGenerate(BulletData.Builder
				.bulletBuilder(DSCombatMod.MODID, "127mm")
				.setFireRate(12)
				.setInnacuracy(0.3f)
				.setCanShootOnGround(true)
				.setDamage(50f)
				.setSpeed(7f)
				.setExplosionRadius(0)
				.setExplosive(false)
				.setDestoryTerrain(false)
				.setCausesFire(false)
				.setMaxAmmo(50)
				.setMaxAge(40)
				.setItem(ModItems.BULLET.getId())
				.setEntityType(ModEntities.BULLET.getId())
				.setNoRack()
				.setShootSound(ModSounds.BULLET_SHOOT_1.getId())
				.setNoCompatible()
				.setCraftNum(1)
				.addIngredient("minecraft:copper_ingot", 5)
				.build());
	}
	
	protected void registerAAMissiles() {
		// max ammo cost: 24 iron, 10 tnt (50 gunpowder), 14 coal block, 4 ti83 (8 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "aim7f")
				.setNotActiveTrack()
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(80f)
				.setSpeed(3.0f)
				.setExplosionRadius(6f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(200)
				.setFuelTicks(100)
				.setTurnRadius(200f)
				.setAcceleration(0.07f)
				.setBleed(0.03f)
				.setFuseDistance(3f)
				.setFieldOfView(-1f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.AIM7F.getId())
				.setEntityType(ModEntities.AIM7F.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 12)
				.addIngredient("minecraft:tnt", 4)
				.addIngredient("minecraft:coal_block", 1)
				.addIngredient("minecraft:lightning_rod")
				.addIngredient("dscombat:ti83", 2)
				.build());
		// max ammo cost: 24 iron, 10 tnt (50 gunpowder), 14 coal block, 4 ti83 (8 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "aim7mh")
				.setNotActiveTrack()
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(80f)
				.setSpeed(3.0f)
				.setExplosionRadius(6f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(334)
				.setFuelTicks(167)
				.setTurnRadius(220f)
				.setAcceleration(0.07f)
				.setBleed(0.03f)
				.setFuseDistance(3f)
				.setFieldOfView(-1f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.AIM7MH.getId())
				.setEntityType(ModEntities.AIM7MH.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 12)
				.addIngredient("minecraft:tnt", 4)
				.addIngredient("minecraft:coal_block", 2)
				.addIngredient("minecraft:lightning_rod")
				.addIngredient("dscombat:ti83", 2)
				.build());
		// max ammo cost: 24 iron, 9 tnt (45 gunpowder), 15 coal block, 3 pentium (30 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "aim120b")
				.setActiveTrack()
				.setFireRate(30)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(4.0f)
				.setExplosionRadius(4.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(350)
				.setFuelTicks(175)
				.setTurnRadius(140f)
				.setAcceleration(0.05f)
				.setBleed(0.04f)
				.setFuseDistance(3f)
				.setFieldOfView(60f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.AIM120B.getId())
				.setEntityType(ModEntities.AIM120B.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 8)
				.addIngredient("minecraft:tnt", 3)
				.addIngredient("minecraft:coal_block", 3)
				.addIngredient("minecraft:ender_eye")
				.addIngredient("dscombat:intel_pentium")
				.build());
		// max ammo cost: 24 iron, 9 tnt (45 gunpowder), 18 coal block, 3 pentium (30 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "aim120c")
				.setActiveTrack()
				.setFireRate(30)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(4.0f)
				.setExplosionRadius(4.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(500)
				.setFuelTicks(250)
				.setTurnRadius(160f)
				.setAcceleration(0.05f)
				.setBleed(0.04f)
				.setFuseDistance(3f)
				.setFieldOfView(60f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.AIM120C.getId())
				.setEntityType(ModEntities.AIM120C.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 8)
				.addIngredient("minecraft:tnt", 3)
				.addIngredient("minecraft:coal_block", 4)
				.addIngredient("minecraft:ender_eye")
				.addIngredient("dscombat:intel_pentium")
				.build());
		//
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "meteor")
				.setActiveTrack()
				.setFireRate(50)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(65f)
				.setSpeed(6f)
				.setExplosionRadius(5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(2)
				.setMaxAge(500)
				.setFuelTicks(300)
				.setTurnRadius(160f)
				.setAcceleration(0.05f)
				.setBleed(0.04f)
				.setFuseDistance(4f)
				.setFieldOfView(50f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.TRACK_AIR_MISSILE.getId())
				.setEntityType(ModEntities.METEOR.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 16)
				.addIngredient("minecraft:tnt", 4)
				.addIngredient("minecraft:coal_block", 4)
				.addIngredient("minecraft:ender_eye")
				.addIngredient("minecraft:diamond")
				.addIngredient("dscombat:intel_pentium")
				.build());
		// max ammo cost: 40 iron, 24 tnt (120 gunpowder), 24 coal block, 4 pentium (40 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "pac3")
				.setActiveTrack()
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(90f)
				.setSpeed(4.0f)
				.setExplosionRadius(7f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(300)
				.setFuelTicks(150)
				.setTurnRadius(190f)
				.setAcceleration(0.08f)
				.setBleed(0.07f)
				.setFuseDistance(3f)
				.setFieldOfView(40f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.TRACK_AIR_MISSILE.getId())
				.setEntityType(ModEntities.PAC3.getId())
				.setNoRack()
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setNoCompatible()
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot",14)
				.addIngredient("minecraft:tnt", 6)
				.addIngredient("minecraft:coal_block", 3)
				.addIngredient("minecraft:ender_eye")
				.addIngredient("dscombat:intel_pentium")
				.build());
		// max ammo cost: 
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "bgm109")
				.setNotActiveTrack()
				.setFireRate(25)
				.setInnacuracy(0f)
				.setCanShootOnGround(true)
				.setDamage(45f)
				.setSpeed(3.5f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(16)
				.setMaxAge(172)
				.setFuelTicks(150)
				.setTurnRadius(100f)
				.setAcceleration(0.1f)
				.setBleed(0.03f)
				.setFuseDistance(2f)
				.setFieldOfView(-1f)
				.setTargetType(TargetType.AIR)
				.setItem(ModItems.TRACK_AIR_MISSILE.getId())
				.setEntityType(ModEntities.AIM120C.getId())
				.setRackEntityType(ModEntities.VLS.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.VLS.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 10)
				.addIngredient("minecraft:tnt", 1)
				.addIngredient("minecraft:coal_block", 1)
				.addIngredient("minecraft:lightning_rod")
				.addIngredient("dscombat:ti83", 2)
				.build());		
		// max ammo cost: 16 iron, 4 tnt (20 gunpowder), 4 coal block, 4 ti83 (8 redstone)
		addPresetToGenerate(MissileData.Builder
				.irMissileBuilder(DSCombatMod.MODID, "aim9l")
				.setFireRate(20)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(40f)
				.setSpeed(2.0f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(100)
				.setFuelTicks(75)
				.setTurnRadius(80f)
				.setAcceleration(0.04f)
				.setBleed(0.02f)
				.setFuseDistance(3f)
				.setFieldOfView(30f)
				.setFlareResistance(1.5f)
				.setItem(ModItems.AIM9L.getId())
				.setEntityType(ModEntities.AIM9L.getId())
				.setRackEntityType(ModEntities.LIGHT_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.LIGHT_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 4)
				.addIngredient("minecraft:tnt", 1)
				.addIngredient("minecraft:coal_block", 1)
				.addIngredient("minecraft:spider_eye", 1)
				.addIngredient("dscombat:ti83")
				.build());
		// max ammo cost: 16 iron, 4 tnt (20 gunpowder), 4 coal block, 8 ti83 (16 redstone)
		addPresetToGenerate(MissileData.Builder
				.irMissileBuilder(DSCombatMod.MODID, "aim9p5")
				.setFireRate(20)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(40f)
				.setSpeed(2.5f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(100)
				.setFuelTicks(80)
				.setTurnRadius(70f)
				.setAcceleration(0.04f)
				.setBleed(0.02f)
				.setFuseDistance(3f)
				.setFieldOfView(40f)
				.setFlareResistance(1f)
				.setItem(ModItems.AIM9P5.getId())
				.setEntityType(ModEntities.AIM9P5.getId())
				.setRackEntityType(ModEntities.LIGHT_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.LIGHT_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 4)
				.addIngredient("minecraft:tnt", 1)
				.addIngredient("minecraft:coal_block", 1)
				.addIngredient("minecraft:spider_eye", 2)
				.addIngredient("dscombat:ti83", 2)
				.build());
		// max ammo cost: 20 iron, 4 tnt (20 gunpowder), 8 coal block, 4 pentium (40 redstone)
		addPresetToGenerate(MissileData.Builder
				.irMissileBuilder(DSCombatMod.MODID, "aim9x")
				.setFireRate(20)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(40f)
				.setSpeed(3f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(100)
				.setFuelTicks(85)
				.setTurnRadius(60f)
				.setAcceleration(0.05f)
				.setBleed(0.02f)
				.setFuseDistance(3f)
				.setFieldOfView(50f)
				.setFlareResistance(0.7f)
				.setItem(ModItems.AIM9X.getId())
				.setEntityType(ModEntities.AIM9X.getId())
				.setRackEntityType(ModEntities.LIGHT_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.LIGHT_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 5)
				.addIngredient("minecraft:tnt", 1)
				.addIngredient("minecraft:coal_block", 2)
				.addIngredient("minecraft:spider_eye", 4)
				.addIngredient("dscombat:intel_pentium")
				.build());
	}
	
	protected void registerAGMissiles() {
		// max ammo cost: 18 iron, 6 tnt (30 gunpowder), 6 coal block, 6 ti83 (12 redstone)
		addPresetToGenerate(MissileData.Builder
				.posMissileBuilder(DSCombatMod.MODID, "agm114k")
				.setFireRate(20)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(40f)
				.setSpeed(3f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(6)
				.setMaxAge(200)
				.setFuelTicks(200)
				.setTurnRadius(30f)
				.setAcceleration(0.05f)
				.setBleed(0.02f)
				.setFuseDistance(2f)
				.setFieldOfView(-1f)
				.setItem(ModItems.AGM114K.getId())
				.setEntityType(ModEntities.AGM114K.getId())
				.setRackEntityType(ModEntities.LIGHT_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.LIGHT_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 3)
				.addIngredient("minecraft:tnt", 1)
				.addIngredient("minecraft:coal_block", 1)
				.addIngredient("dscombat:ti83")
				.build());
		// max ammo cost: 20 iron, 12 tnt (60 gunpowder), 8 coal block, 4 ti83 (8 redstone)
		addPresetToGenerate(MissileData.Builder
				.posMissileBuilder(DSCombatMod.MODID, "agm65l")
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(2f)
				.setExplosionRadius(5.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(300)
				.setFuelTicks(300)
				.setTurnRadius(60f)
				.setAcceleration(0.025f)
				.setBleed(0.02f)
				.setFuseDistance(1.5f)
				.setFieldOfView(-1f)
				.setItem(ModItems.AGM65L.getId())
				.setEntityType(ModEntities.AGM65L.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 5)
				.addIngredient("minecraft:tnt", 3)
				.addIngredient("minecraft:coal_block", 2)
				.addIngredient("dscombat:ti83")
				.build());
		// max ammo cost: 20 iron, 12 tnt (60 gunpowder), 8 coal block, 4 ti83 (8 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "agm65g")
				.setActiveTrack()
				.setTargetType(TargetType.GROUND)
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(2f)
				.setExplosionRadius(5.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(300)
				.setFuelTicks(300)
				.setTurnRadius(60f)
				.setAcceleration(0.025f)
				.setBleed(0.02f)
				.setFuseDistance(1.5f)
				.setFieldOfView(-1f)
				.setItem(ModItems.AGM65G.getId())
				.setEntityType(ModEntities.AGM65G.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 5)
				.addIngredient("minecraft:tnt", 3)
				.addIngredient("minecraft:coal_block", 2)
				.addIngredient("dscombat:ti83")
				.build());
		// max ammo cost: 18 iron, 9 tnt (45 gunpowder), 9 coal block, 6 ti83 (12 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "agm84e")
				.setActiveTrack()
				.setTargetType(TargetType.GROUND)
				.setFireRate(50)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(2.5f)
				.setExplosionRadius(4.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(300)
				.setFuelTicks(300)
				.setTurnRadius(45f)
				.setAcceleration(0.035f)
				.setBleed(0.02f)
				.setFuseDistance(2f)
				.setFieldOfView(-1f)
				.setSeeThroBlockNum(4)
				.setItem(ModItems.AGM84E.getId())
				.setEntityType(ModEntities.AGM84E.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 6)
				.addIngredient("minecraft:tnt", 3)
				.addIngredient("minecraft:coal_block", 3)
				.addIngredient("dscombat:ti83", 2)
				.build());
	}
	
	protected void registerOtherMissiles() {
		// max ammo cost: 24 iron, 8 tnt (40 gunpowder), 8 coal block, 2 pentium (20 redstone)
		addPresetToGenerate(MissileData.Builder
				.antiRadarMissileBuilder(DSCombatMod.MODID, "agm88g")
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(60f)
				.setSpeed(3f)
				.setExplosionRadius(8f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(2)
				.setMaxAge(600)
				.setFuelTicks(400)
				.setTurnRadius(160f)
				.setAcceleration(0.04f)
				.setBleed(0.02f)
				.setFuseDistance(2f)
				.setFieldOfView(30f)
				.setScanRange(1200f)
				.setItem(ModItems.AGM88G.getId())
				.setEntityType(ModEntities.AGM88G.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 12)
				.addIngredient("minecraft:tnt", 4)
				.addIngredient("minecraft:coal_block", 4)
				.addIngredient("dscombat:intel_pentium")
				.build());
		// max ammo cost: 36 iron, 6 tnt (30 gunpowder), 12 coal block, 6 ti83 (12 redstone)
		addPresetToGenerate(MissileData.Builder
				.torpedoBuilder(DSCombatMod.MODID, "mk13")
				.setActiveTrack()
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(50f)
				.setSpeed(2.5f)
				.setExplosionRadius(4f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(3)
				.setMaxAge(600)
				.setFuelTicks(400)
				.setTurnRadius(80f)
				.setAcceleration(0.04f)
				.setBleed(0.05f)
				.setFuseDistance(2f)
				.setFieldOfView(40f)
				.setSeeThroWaterNum(10000)
				.setTargetType(TargetType.WATER)
				.setItem(ModItems.MK13.getId())
				.setEntityType(ModEntities.MK13.getId())
				.setRackEntityType(ModEntities.HEAVY_MISSILE_RACK.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.HEAVY_MISSILE_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 12)
				.addIngredient("minecraft:tnt", 2)
				.addIngredient("minecraft:coal_block", 4)
				.addIngredient("dscombat:ti83", 2)
				.build());
		// max ammo cost: 36 iron, 6 tnt (30 gunpowder), 12 coal block, 6 ti83 (12 redstone)
		addPresetToGenerate(MissileData.Builder
				.trackMissileBuilder(DSCombatMod.MODID, "rgm84")
				.setActiveTrack()
				.setFireRate(40)
				.setInnacuracy(0f)
				.setCanShootOnGround(true)
				.setDamage(50f)
				.setSpeed(2.5f)
				.setExplosionRadius(4f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(4)
				.setMaxAge(600)
				.setFuelTicks(400)
				.setTurnRadius(80f)
				.setAcceleration(0.04f)
				.setBleed(0.05f)
				.setFuseDistance(2f)
				.setFieldOfView(60f)
				.setSeeThroWaterNum(100)
				.setTargetType(TargetType.GROUND)
				.setItem(ModItems.TORPEDO1.getId())
				.setEntityType(ModEntities.AIM120C.getId())
				.setRackEntityType(ModEntities.ADL.getId())
				.setShootSound(ModSounds.MISSILE_LAUNCH_1.getId())
				.setCompatibleWeaponPart(ModItems.ADL.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 12)
				.addIngredient("minecraft:tnt", 2)
				.addIngredient("minecraft:coal_block", 4)
				.addIngredient("dscombat:ti83", 2)
				.build());
	}
	
	protected void registerBombs() {
		// max ammo cost: 32 iron, 16 tnt (80 gunpowder)
		addPresetToGenerate(BombData.Builder
				.bombBuilder(DSCombatMod.MODID, "anm30")
				.setFireRate(4)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(20f)
				.setSpeed(0f)
				.setExplosionRadius(3.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(40)
				.setMaxAge(200)
				.setItem(ModItems.BOMB.getId())
				.setEntityType(ModEntities.BOMB.getId())
				.setRackEntityType(ModEntities.BOMB_RACK.getId())
				.setShootSound(ModSounds.BOMB_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.BOMB_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 1)
				.addIngredient("minecraft:tnt", 1)
				.build());
		// max ammo cost: 32 iron, 16 tnt (80 gunpowder)
		addPresetToGenerate(BombData.Builder
				.bombBuilder(DSCombatMod.MODID, "anm57")
				.setFireRate(6)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(30f)
				.setSpeed(0f)
				.setExplosionRadius(4.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(20)
				.setMaxAge(200)
				.setItem(ModItems.BOMB.getId())
				.setEntityType(ModEntities.BOMB.getId())
				.setRackEntityType(ModEntities.BOMB_RACK.getId())
				.setShootSound(ModSounds.BOMB_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.BOMB_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 2)
				.addIngredient("minecraft:tnt", 2)
				.build());
		// max ammo cost: 24 iron, 12 tnt (60 gunpowder)
		addPresetToGenerate(BombData.Builder
				.bombBuilder(DSCombatMod.MODID, "anm64")
				.setFireRate(11)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(40f)
				.setSpeed(0f)
				.setExplosionRadius(8.5f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(10)
				.setMaxAge(200)
				.setItem(ModItems.BOMB.getId())
				.setEntityType(ModEntities.BOMB.getId())
				.setRackEntityType(ModEntities.BOMB_RACK.getId())
				.setShootSound(ModSounds.BOMB_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.BOMB_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 4)
				.addIngredient("minecraft:tnt", 4)
				.build());
		addPresetToGenerate(BombData.Builder
				.bombBuilder(DSCombatMod.MODID, "napalm")
				.setFireRate(3)
				.setInnacuracy(0f)
				.setCanShootOnGround(false)
				.setDamage(20f)
				.setSpeed(0f)
				.setExplosionRadius(2f)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(true)
				.setMaxAmmo(50)
				.setMaxAge(200)
				.setItem(ModItems.BOMB.getId())
				.setEntityType(ModEntities.BOMB.getId())
				.setRackEntityType(ModEntities.BOMB_RACK.getId())
				.setShootSound(ModSounds.BOMB_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.BOMB_RACK.getId())
				.setCraftNum(3)
				.addIngredient("minecraft:iron_ingot", 3)
				.addIngredient("minecraft:tnt", 2)
				.addIngredient("minecraft:blaze_powder", 1)
				.build());
	}
	
	protected void registerOther() {
		addPresetToGenerate(BunkerBusterData.Builder
				.bunkerBusterBuilder(DSCombatMod.MODID, "gruetz_bunker_buster")
				.setFireRate(60)
				.setInnacuracy(0f)
				.setCanShootOnGround(true)
				.setDamage(50f)
				.setSpeed(0f)
				.setExplosionRadius(12)
				.setExplosive(true)
				.setDestoryTerrain(true)
				.setCausesFire(false)
				.setMaxAmmo(1)
				.setMaxAge(300)
				.setBlockStrength(1500)
				.setItem(ModItems.GRUETZ_BUNKER_BUSTER.getId())
				.setEntityType(ModEntities.GRUETZ_BUNKER_BUSTER.getId())
				.setRackEntityType(ModEntities.BOMB_RACK.getId())
				.setShootSound(ModSounds.BOMB_SHOOT_1.getId())
				.setCompatibleWeaponPart(ModItems.BOMB_RACK.getId())
				.setCraftNum(1)
				.addIngredient("minecraft:iron_ingot", 16)
				.addIngredient("minecraft:tnt", 8)
				.addIngredient("minecraft:diamond_pickaxe")
				.addIngredient(ModItems.TI83.getId())
				.build());
	}
	
	@Override
	protected void registerPresets() {
		registerBullets();
		registerAAMissiles();
		registerAGMissiles();
		registerOtherMissiles();
		registerBombs();
		registerOther();
	}	
	
	public WeaponPresetGenerator(DataGenerator output) {
		super(output, "weapons");
	}

	@Override
	public String getName() {
		return "Weapons: "+DSCombatMod.MODID;
	}
	
	
	
}
