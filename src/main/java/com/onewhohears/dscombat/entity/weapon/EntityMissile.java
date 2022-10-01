package com.onewhohears.dscombat.entity.weapon;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.MissileData;
import com.onewhohears.dscombat.data.MissileData.GuidanceType;
import com.onewhohears.dscombat.data.MissileData.TargetType;
import com.onewhohears.dscombat.data.WeaponData;
import com.onewhohears.dscombat.entity.aircraft.plane.EntityTestPlane;
import com.onewhohears.dscombat.init.ModEntities;

import net.minecraft.client.model.EntityModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityMissile extends EntityBullet {
	
	private static final ResourceLocation TEXTURE_MISSILE1 = new ResourceLocation(DSCombatMod.MODID, "textures/entities/missile1.png");
	public static EntityModel<EntityTestPlane> MODEL_MISSILE1 = null;
	
	public Entity parent;
	public Entity target;
	public Vec3 targetPos;
	
	public EntityMissile(EntityType<? extends EntityMissile> type, Level level) {
		super(type, level);
	}
	
	public EntityMissile(Level level, Entity owner, MissileData data) {
		this(ModEntities.MISSILE.get(), level);
		this.setOwner(owner);
		this.setWeaponData(data);
	}
	
	@Override
	public void tick() {
		//System.out.println("rocket "+this.tickCount+" "+this.level);
		// TODO doesn't visually look like missile hitting the target
		super.tick();
		if (!this.level.isClientSide) {
			MissileData data = (MissileData)this.getWeaponData();
			data.tickGuide(this);
			motionClamp();
			if (data.getTargetType() != TargetType.POS) {
				if (this.distanceTo(target) < data.getFuseDist()) {
					this.setPos(target.position());
				}
			}
		}
		if (this.level.isClientSide /*&& this.tickCount % 2 == 0*/) {
			Vec3 move = this.getDeltaMovement();
			level.addParticle(ParticleTypes.FIREWORK, 
					this.getX(), this.getY(), this.getZ(), 
					-move.x * 0.5D + random.nextGaussian() * 0.05D, 
					-move.y * 0.5D + random.nextGaussian() * 0.05D, 
					-move.y * 0.5D + random.nextGaussian() * 0.05D);
		}
	}
	
	public void motionClamp() {
		Vec3 motion = getDeltaMovement();
		double vel = motion.length();
		double max = 1d;
		if (vel > max) motion = motion.scale(max / vel);
		setDeltaMovement(motion);
	}
	
	@Override
	public ResourceLocation getTexture() {
		return TEXTURE_MISSILE1;
	}
	
	@Override
	public EntityModel<?> getModel() {
		return MODEL_MISSILE1;
	}
	
	@Override
	public WeaponData getDefaultData() {
		return new MissileData("default_missile", Vec3.ZERO,
				0, 0, 0, 0, 0, 0, 
				false, false, false, 0, 0,
				TargetType.POS, GuidanceType.IR,
				0, 0, 0);
	}

}
