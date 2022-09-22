package com.onewhohears.dscombat.common.event;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.entity.aircraft.parts.EntitySeat;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DSCombatMod.MODID, bus = Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ForgeEvents {
	
	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event) {
		// TODO change player bounding box so camera entity can't attack player
		final var player = event.player;
		System.out.println("server side player "+player);
		if (player == null) return;
		System.out.println("server side vehicle "+player.getVehicle());
		if (!(player.getVehicle() instanceof EntitySeat seat)) return;
		EntityDimensions dim = new EntityDimensions(player.getBbWidth(), 1f, false);
		player.setBoundingBox(dim.makeBoundingBox(player.position()));
		System.out.println("server side player hitbox");
	}
	
}
