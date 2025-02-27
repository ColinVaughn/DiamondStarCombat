package com.onewhohears.dscombat.init;

import com.onewhohears.dscombat.DSCombatMod;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
	
	public static void init() {
		Blocks.init();
		EntityTypes.init();
		Items.init();
	}
	
	public static class Blocks {
		public static final TagKey<Block> FRAGILE = tag("fragile");
		public static final TagKey<Block> ABSORBENT = tag("absorbent");
		private static void init() {}
        public static TagKey<Block> tag(String name) {
        	return BlockTags.create(new ResourceLocation(DSCombatMod.MODID, name));
        }
	}
	
	public static class EntityTypes {
		public static final TagKey<EntityType<?>> PROJECTILE = tag("projectile");
		public static final TagKey<EntityType<?>> BULLET = tag("projectile/bullet");
		public static final TagKey<EntityType<?>> BOMB = tag("projectile/bomb");
		public static final TagKey<EntityType<?>> MISSILE = tag("projectile/missile");
		public static final TagKey<EntityType<?>> ANTI_TANK_SHELL = tag("projectile/anti_tank_shell");
		public static final TagKey<EntityType<?>> ALWAYS_GROUNDED = tag("always_grounded");
		public static final TagKey<EntityType<?>> VEHICLE = tag("vehicle");
		public static final TagKey<EntityType<?>> MISC_VEHICLE = tag("vehicle/misc");
		public static final TagKey<EntityType<?>> PLANE = tag("vehicle/plane");
		public static final TagKey<EntityType<?>> HELI = tag("vehicle/heli");
		public static final TagKey<EntityType<?>> CAR = tag("vehicle/car");
		public static final TagKey<EntityType<?>> TANK = tag("vehicle/tank");
		public static final TagKey<EntityType<?>> BOAT = tag("vehicle/boat");
		public static final TagKey<EntityType<?>> SUBMARINE = tag("vehicle/submarine");
		public static final TagKey<EntityType<?>> TURRET_SHOOT = tag("turret_shoot");
		public static final TagKey<EntityType<?>> TURRET_SHOOT_RANDOM = tag("turret_shoot/random");
		public static final TagKey<EntityType<?>> TURRET_SHOOT_DUMBASS = tag("turret_shoot/dumbass");
		public static final TagKey<EntityType<?>> TURRET_SHOOT_STUPID = tag("turret_shoot/stupid");
		public static final TagKey<EntityType<?>> TURRET_SHOOT_NORMAL = tag("turret_shoot/normal");
		public static final TagKey<EntityType<?>> TURRET_SHOOT_SMART = tag("turret_shoot/smart");
		public static final TagKey<EntityType<?>> TURRET_TARGET_MONSTERS = tag("turret_target_monsters");
		public static final TagKey<EntityType<?>> TURRET_TARGET_PLAYERS = tag("turret_target_players");
		public static final TagKey<EntityType<?>> IR_EMITTER = tag("ir_emitter");
		public static final TagKey<EntityType<?>> FLARE = tag("ir_emitter/flare");
		public static final TagKey<EntityType<?>> IR_EMITTER_LOW = tag("ir_emitter/low");
		public static final TagKey<EntityType<?>> IR_EMITTER_MED = tag("ir_emitter/med");
		public static final TagKey<EntityType<?>> IR_EMITTER_HIGH = tag("ir_emitter/high");
		public static final TagKey<EntityType<?>> IR_EMITTER_EXTREME = tag("ir_emitter/extreme");
		private static void init() {}
        public static TagKey<EntityType<?>> tag(String name) {
        	return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(DSCombatMod.MODID, name));
        }
	}
	
	public static class Items {
		public static final TagKey<Item> VEHICLE_PART = tag("vehicle_part");
		public static final TagKey<Item> VEHICLE_PART_FUEL_TANK = tag("vehicle_part/fuel_tank");
		public static final TagKey<Item> VEHICLE_PART_ENGINE = tag("vehicle_part/engine");
		public static final TagKey<Item> VEHICLE_ENGINE_INTERNAL_PUSH = tag("vehicle_part/engine/internal_push");
		public static final TagKey<Item> VEHICLE_ENGINE_INTERNAL_SPIN = tag("vehicle_part/engine/internal_spin");
		public static final TagKey<Item> VEHICLE_ENGINE_INTERNAL_RADIAL = tag("vehicle_part/engine/internal_radial");
		public static final TagKey<Item> VEHICLE_ENGINE_EXTERNAL_PUSH = tag("vehicle_part/engine/external_push");
		public static final TagKey<Item> VEHICLE_PART_FLARES = tag("vehicle_part/flares");
		public static final TagKey<Item> VEHICLE_PART_WEAPON = tag("vehicle_part/weapon");
		public static final TagKey<Item> VEHICLE_TURRET = tag("vehicle_part/weapon/turret");
		public static final TagKey<Item> VEHICLE = tag("vehicle");
		public static final TagKey<Item> AMMO = tag("ammo");
		public static final TagKey<Item> GAS_CAN = tag("gas_can");
		public static final TagKey<Item> SPRAY_CAN = tag("spray_can");
		public static final TagKey<Item> VEHICLE_CHAIN = tag("vehicle_chain");
		public static final TagKey<Item> VEHICLE_REPAIR_TOOL = tag("vehicle_repair_tool");
		public static final TagKey<Item> ALUMINUM_INGOT = tag("aluminum_ingot");
		public static final TagKey<Item> FORGE_ALUMINUM_INGOT = forgeTag("ingots/aluminum");
		public static final TagKey<Item> FORGE_OIL_BUCKET = forgeTag("buckets/oil");
		public static final TagKey<Item> FOSSIL_OIL_CONVERTER = tag("fossil_oil_converter");
		private static void init() {}
		public static TagKey<Item> tag(String name) {
        	return ItemTags.create(new ResourceLocation(DSCombatMod.MODID, name));
        }
		public static TagKey<Item> forgeTag(String name) {
        	return ItemTags.create(new ResourceLocation("forge", name));
        }
	}
	
	public static class Fluids {
		public static final TagKey<Fluid> OIL = forgeTag("oil");
		public static TagKey<Fluid> tag(String name) {
			return FluidTags.create(new ResourceLocation(DSCombatMod.MODID, name));
		}
		public static TagKey<Fluid> forgeTag(String name) {
			return FluidTags.create(new ResourceLocation("forge", name));
		}
	}
	
}
