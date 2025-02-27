package com.onewhohears.dscombat.entity.vehicle;

import com.mojang.math.Quaternion;
import com.onewhohears.dscombat.command.DSCGameRules;
import com.onewhohears.dscombat.data.vehicle.DSCPhyCons;
import com.onewhohears.dscombat.data.vehicle.VehicleType;
import com.onewhohears.dscombat.entity.damagesource.WeaponDamageSource.WeaponDamageType;
import com.onewhohears.dscombat.util.math.UtilAngles;
import com.onewhohears.dscombat.util.math.UtilGeometry;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EntityPlane extends EntityVehicle {

	private float aoa = 0, liftK = 0, airFoilSpeedSqr = 0;
	private float centripetalForce, centrifugalForce;
	private double liftMag, prevMaxSpeedMod = 1;
	private Vec3 liftDir = Vec3.ZERO, airFoilAxes = Vec3.ZERO;
	private boolean engineKilledByWater = false;

	public EntityPlane(EntityType<? extends EntityPlane> entity, Level level, String defaultPreset) {
		super(entity, level, defaultPreset);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.PLANE;
	}

	@Override
	public void directionAir(Quaternion q) {
		super.directionAir(q);
		if (!isOperational()) return;
		addMomentX(inputs.pitch * getPitchTorque(), true);
		addMomentY(inputs.yaw * getYawTorque(), true);
		if (inputs.bothRoll) flatten(q, 0, getRollTorque(), false);
		else addMomentZ(inputs.roll * getRollTorque(), true);
	}

	@Override
	public void tickAlways(Quaternion q) {
		super.tickAlways(q);
		setForces(getForces().add(getLiftForce(q)));
	}

	@Override
	protected void calcMoveStatsPre(Quaternion q) {
		super.calcMoveStatsPre(q);
		calculateAOA(q);
		calculateLift(q);
	}

	@Override
	public double getDriveAcc() {
		return 0;
	}

	@Override
	public double getMaxSpeedForMotion() {
		return super.getMaxSpeedForMotion() * getPlaneSpeedPercent() * getMaxSpeedFromThrottleMod();
	}

	public double getPlaneSpeedPercent() {
		return level.getGameRules().getInt(DSCGameRules.PLANE_SPEED_PERCENT) * 0.01;
	}

	public double getMaxSpeedFromThrottleMod() {
		if (isOnGround()) {
			prevMaxSpeedMod = 1;
			return prevMaxSpeedMod;
		}
		float th = getCurrentThrottle();
		double goal;
		if (th < 0.5) goal = 0.7;
		else goal = 0.7 + 0.6 * (th - 0.5);
		prevMaxSpeedMod = Mth.lerp(0.015, prevMaxSpeedMod, goal);
		return prevMaxSpeedMod;
	}

	@Override
	public boolean isBraking() {
		return inputs.special2 && isOnGround();
	}

	@Override
	public boolean isFlapsDown() {
		return inputs.special;
	}

	@Override
	public void tickAir(Quaternion q) {
		super.tickAir(q);
	}

	protected void calculateAOA(Quaternion q) {
		Vec3 u = getDeltaMovement();
		Vec3 pitchAxis = UtilAngles.getPitchAxis(q);
		liftDir = u.cross(pitchAxis).normalize();
		airFoilAxes = UtilAngles.getRollAxis(q);
		airFoilSpeedSqr = (float)UtilGeometry.vecCompByNormAxis(u, airFoilAxes).lengthSqr();
		if (isOnGround() || UtilGeometry.isZero(u)) {
			aoa = 0;
		} else {
			Vec3 planeNormal = UtilAngles.getYawAxis(q).scale(-1);
			aoa = (float)UtilGeometry.angleBetweenVecPlaneDegrees(u, planeNormal);
		}
		if (isFlapsDown()) aoa += getStats().asPlane().flapsAOABias;
		liftK = (float) getLiftK();
	}

	public float getYawRate() {
		return getYRot() - yRotO;
	}

	protected void calculateLift(Quaternion q) {
		double wing = getWingSurfaceArea();
		liftMag = liftK * airPressure * airFoilSpeedSqr * wing * DSCPhyCons.LIFT;
		Vec3 lift = getLiftForce(q);
		Vec3 cenAxis = UtilAngles.getRollAxis(0, (getYRot()+90)*Mth.DEG_TO_RAD);
		centripetalForce = (float) UtilGeometry.vecCompMagDirByNormAxis(lift, cenAxis);
		if (Mth.abs(centripetalForce) < 0.01) centripetalForce = 0;
		if (Mth.abs(centrifugalForce) < 0.01) centrifugalForce = 0;
		centrifugalForce = getTotalMass() * xzSpeed * getYawRate()*Mth.DEG_TO_RAD;
	}

	public Vec3 getLiftForce(Quaternion q) {
		double cenScale = DSCPhyCons.CENTRIPETAL_SCALE;
		Vec3 liftForce = liftDir.scale(getLiftMag())
				.multiply(cenScale, 1, cenScale);
		return liftForce;
	}

	public double getLiftMag() {
		return liftMag;
	}

	public double getLiftK() {
		return getStats().asPlane().liftKGraph.getLift(aoa);
	}

	@Override
	public Vec3 getThrustForce(Quaternion q) {
		//if (isUnderWater() || engineKilledByWater) {
		//	engineKilledByWater = true; // Ensure engine is permanently killed
		//	return Vec3.ZERO; // Set thrust force to zero
		//}
		Vec3 direction = UtilAngles.getRollAxis(q);
		Vec3 thrustForce = direction.scale(getPushThrustMag());
		return thrustForce;
	}

	@Override
	public double getCrossSectionArea() {
		double a = super.getCrossSectionArea();
		a += getWingSurfaceArea() * Math.sin(Math.toRadians(aoa));
		if (isLandingGear()) a += 10.0 * Math.cos(Math.toRadians(aoa));
		if (isFlapsDown()) a += getWingSurfaceArea() / 4 * Math.cos(Math.toRadians(aoa));
		return a;
	}

	public float getAOA() {
		return aoa;
	}

	@Override
	public boolean isCustomBoundingBox() {
		return true;
	}

	public final float getWingSurfaceArea() {
		return getStats().asPlane().wing_area;
	}

	@Override
	public boolean isWeaponAngledDown() {
		return getStats().asPlane().canAimDown && !onGround && inputs.special2;
	}

	@Override
	public boolean canAngleWeaponDown() {
		return getStats().asPlane().canAimDown;
	}

	@Override
	public boolean canBrake() {
		return onGround;
	}

	@Override
	public boolean canToggleLandingGear() {
		return true;
	}

	@Override
	public boolean canFlapsDown() {
		return true;
	}

	public float getCentripetalForce() {
		return centripetalForce;
	}

	public float getCentrifugalForce() {
		return centrifugalForce;
	}

	@Override
	public float calcProjDamageBySource(DamageSource source, float amount) {
		WeaponDamageType wdt = WeaponDamageType.byId(source.getMsgId());
		if (wdt != null && wdt.isContact()) return amount * DSCGameRules.getBulletDamagePlaneFactor(level);
		return super.calcProjDamageBySource(source, amount);
	}

	@Override
	public boolean isStalling() {
		return Math.abs(getAOA()) >= getStats().asPlane().liftKGraph.getCriticalAOA() || liftLost();
	}

	@Override
	public boolean isAboutToStall() {
		return Math.abs(getAOA()) >= getStats().asPlane().liftKGraph.getWarnAOA() && !isFlapsDown();
	}

	@Override
	public boolean liftLost() {
		return !isOnGround() && getForces().y < -10 && getDeltaMovement().y < -0.1 && Math.abs(zRot) > 15;
	}

	public boolean isUnderWater() {
		AABB boundingBox = this.getBoundingBox();
		for (int x = Mth.floor(boundingBox.minX); x <= Mth.ceil(boundingBox.maxX); x++) {
			for (int y = Mth.floor(boundingBox.minY); y <= Mth.ceil(boundingBox.maxY); y++) {
				for (int z = Mth.floor(boundingBox.minZ); z <= Mth.ceil(boundingBox.maxZ); z++) {
					if (level.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.WATER) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
