package com.onewhohears.dscombat.entity.weapon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.onewhohears.dscombat.data.weapon.WeaponType;
import com.onewhohears.dscombat.data.weapon.stats.AntiRadarMissileStats;
import com.onewhohears.dscombat.entity.vehicle.EntityVehicle;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class AntiRadarMissile<T extends AntiRadarMissileStats> extends EntityMissile<T> {
	
	public AntiRadarMissile(EntityType<? extends AntiRadarMissile<?>> type, Level level, String defaultWeaponId) {
		super(type, level, defaultWeaponId,0.001);
	}
	
	@Override
	public WeaponType getWeaponType() {
		return WeaponType.ANTI_RADAR_MISSILE;
	}
	
	@Override
	public void tickGuide() {
		if (tickCount % 10 == 0) findARTarget();
		if (target != null) guideToTarget();
	}
	
	@Override
	public boolean dieIfNoTargetOutsideTickRange() {
		return false;
	}
	
	protected List<ARTarget> targets = new ArrayList<ARTarget>();

	protected void findARTarget() {
		targets.clear();

		// Get all vehicles within the bounding box
		List<EntityVehicle> vehicles = level.getEntitiesOfClass(EntityVehicle.class, getARBoundingBox());

		for (EntityVehicle vehicle : vehicles) {
			if (isValidTarget(vehicle)) {
				float distSqr = (float) distanceToSqr(vehicle);
				float radiation = (float) vehicle.radarSystem.getMaxAirRange() / distSqr;
				targets.add(new ARTarget(vehicle, radiation));
			}
		}

		// Pick the best target based on radiation
		if (targets.isEmpty()) {
			target = null;
			targetPos = null;
			return;
		}

		ARTarget bestTarget = targets.stream()
				.max(Comparator.comparingDouble(t -> t.radiation))
				.orElse(null);

        target = bestTarget.entity;
        targetPos = bestTarget.entity.position();
    }

	private boolean isValidTarget(EntityVehicle vehicle) {
		return vehicle.radarSystem.hasRadar() &&
				!vehicle.getRadarMode().isOff() &&
				vehicle.radarSystem.canServerTick() &&
				basicCheck(vehicle);
	}


	protected boolean basicCheck(Entity ping) {
		//System.out.println("target? "+ping);
		if (!ping.isOnGround()) {
			return false;
		}
		if (isAlliedTo(ping)) {
			//System.out.println("is allied");
			return false;
		}
		if (!checkTargetRange(ping, getWeaponStats().getScanRange())) {
			//System.out.println("not in cone");
			return false;
		}
		if (!checkCanSee(ping)) {
			//System.out.println("can't see");
			return false;
		}
		//System.out.println("POSSIBLE");
		return true;
	}
	
	protected AABB getARBoundingBox() {
		double x = getX();
		double y = getY();
		double z = getZ();
		double w = getWeaponStats().getScanRange();
		return new AABB(x+w, y+w, z+w, x-w, y-w, z-w);
	}
	
	public static class ARTarget {
		
		public final Entity entity;
		public final float radiation;
		
		public ARTarget(Entity entity, float radiation) {
			this.entity = entity;
			this.radiation = radiation;
		}
		
	}

}
