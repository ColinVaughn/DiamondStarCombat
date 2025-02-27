package com.onewhohears.dscombat.common.event;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.command.DSCGameRules;
import com.onewhohears.dscombat.common.event.custom.RegisterPresetTypesEvent;
import com.onewhohears.dscombat.common.network.PacketHandler;
import com.onewhohears.dscombat.common.network.toclient.ToClientDataPackSynch;
import com.onewhohears.dscombat.common.network.toclient.ToClientSynchGameRules;
import com.onewhohears.dscombat.data.parts.PartPresets;
import com.onewhohears.dscombat.data.radar.RadarPresets;
import com.onewhohears.dscombat.data.vehicle.VehiclePresets;
import com.onewhohears.dscombat.data.weapon.NonTickingMissileManager;
import com.onewhohears.dscombat.data.weapon.WeaponPresets;
import com.onewhohears.dscombat.entity.vehicle.EntityVehicle;
import com.onewhohears.dscombat.entity.vehicle.RotableHitboxes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.PacketDistributor.PacketTarget;

@Mod.EventBusSubscriber(modid = DSCombatMod.MODID, bus = Bus.FORGE)
public final class CommonForgeEvents {
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void livingHurtEvent(LivingHurtEvent event) {
		if (event.getSource().isBypassArmor() || event.getSource().isMagic()) return;
		if (!event.getEntity().isPassenger() || !(event.getEntity().getRootVehicle() instanceof EntityVehicle plane)) return;
		float a = event.getAmount();
		//System.out.println("PLAYER HURT "+event.getEntity()+" "+a);
		event.setAmount(Math.max(0, a-a*plane.getTotalArmor()*DSCGameRules.getVehicleArmorStrengthFactor(plane.level)));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void explosionEvent(ExplosionEvent.Detonate event) {
		for (int i = 0; i < event.getAffectedEntities().size(); ++i) {
			if (!(event.getAffectedEntities().get(i) instanceof EntityVehicle plane)) continue;
			plane.customExplosionHandler(event.getExplosion());
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		// CANCEL ELYTRA
		if (event.player.isFallFlying() && event.player.level.getGameRules().getBoolean(DSCGameRules.DISABLE_ELYTRA_FLYING)) {
			event.player.stopFallFlying();
		}
		// CHANGE HITBOX
		/*if (!(event.player.getVehicle() instanceof EntitySeat seat)) return;
		double x = seat.getX(), y = seat.getY(), z = seat.getZ();
		double w = 0.1; //event.player.getBbWidth()/2;
		event.player.setBoundingBox(new AABB(x-w, y-w, z-w, x+w, y+w, z+w));*/
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void serverTickEvent(TickEvent.ServerTickEvent event) {
		if (event.phase != Phase.END) return;
		NonTickingMissileManager.serverTick(event.getServer());
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void onDatapackSync(OnDatapackSyncEvent event) {
		PacketTarget target;
		if (event.getPlayer() == null) target = PacketDistributor.ALL.noArg();
		else {
			target = PacketDistributor.PLAYER.with(() -> event.getPlayer());
			PacketHandler.INSTANCE.send(target, new ToClientSynchGameRules(event.getPlayer().getServer()));
		}
		PacketHandler.INSTANCE.send(target, new ToClientDataPackSynch());
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void serverStoppingEvent(ServerStoppingEvent event) {
		VehiclePresets.close();
		WeaponPresets.close();
		RadarPresets.close();
		PartPresets.close();
		RotableHitboxes.onServerStop();
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void addReloadListener(AddReloadListenerEvent event) {
		MinecraftForge.EVENT_BUS.post(new RegisterPresetTypesEvent());
		event.addListener(VehiclePresets.get());
		event.addListener(WeaponPresets.get());
		event.addListener(RadarPresets.get());
		event.addListener(PartPresets.get());
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void registerPresetTypes(RegisterPresetTypesEvent event) {
		VehiclePresets.get().registerDefaultPresetTypes();
		WeaponPresets.get().registerDefaultPresetTypes();
		RadarPresets.get().registerDefaultPresetTypes();
		PartPresets.get().registerDefaultPresetTypes();
	}
	
	/*@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void entityJoinLevelEvent(EntityJoinLevelEvent event) {
		Level level = event.getLevel();
		if (level.isClientSide) return;
		
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void entityLeaveLevelEvent(EntityLeaveLevelEvent event) {
		Level level = event.getLevel();
		if (level.isClientSide) return;
		if (!event.getEntity().getRemovalReason().shouldSave()) return;
		if (!(event.getEntity() instanceof EntityVehicle vehicle)) return;
		if (vehicle.getHitboxes().length == 0) return;
		
	}*/
	
	/*@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void chunkWatchEvent(ChunkWatchEvent.Watch event) {
		System.out.println("CHUNK WATCH EVENT");
		System.out.println("event chunk  = "+event.getPos());
		System.out.println("player chunk = "+event.getPlayer().chunkPosition());
		if (event.getPlayer().getVehicle() != null) 
		System.out.println("seat chunk   = "+event.getPlayer().getVehicle().chunkPosition());
		System.out.println("level tick   = "+event.getLevel().getGameTime());
		
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stack.length; ++i) {
			System.out.println(stack[i].toString());
			if (stack[i].toString().contains("net.minecraft.client.main.Main")) break;
		}
	}*/
	
}
