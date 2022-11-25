package com.onewhohears.dscombat.entity.weapon;

import javax.annotation.Nullable;

import com.onewhohears.dscombat.data.weapon.BulletData;
import com.onewhohears.dscombat.data.weapon.WeaponDamageSource;
import com.onewhohears.dscombat.entity.aircraft.EntityAbstractAircraft;
import com.onewhohears.dscombat.util.math.UtilAngles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntityBullet extends EntityAbstractWeapon {
	
	public static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Boolean> EXPLOSIVE = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> TERRAIN = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> FIRE = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(EntityBullet.class, EntityDataSerializers.FLOAT);
	
	public EntityBullet(EntityType<?> type, Level level) {
		super(type, level);
	}
	
	public EntityBullet(Level level, Entity owner, BulletData data) {
		super(level, owner, data);
		this.setDamage(data.getDamage());
		this.setExplosive(data.isExplosive());
		this.setTerrain(data.isDestroyTerrain());
		this.setFire(data.isCausesFire());
		this.setRadius(data.getExplosionRadius());
		this.setSpeed((float)data.getSpeed());
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(DAMAGE, 0f);
		entityData.define(EXPLOSIVE, false);
		entityData.define(TERRAIN, false);
		entityData.define(FIRE, false);
		entityData.define(RADIUS, 0f);
		entityData.define(SPEED, 0f);
	}
	
	/*@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setWeaponData(new BulletData(compound.getCompound("weapondata")));
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.put("weapondata", this.getWeaponData().write());
	}*/
	
	@Override
	public void tick() {
		//System.out.println("bullet "+this.tickCount+" "+this.level);
		//System.out.println(this);
		Vec3 vec3 = this.getDeltaMovement();
		Vec3 vec32 = this.position();
		Vec3 vec33 = vec32.add(vec3);
		HitResult hitresult = this.level.clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
		if (hitresult.getType() != HitResult.Type.MISS) {
			vec33 = hitresult.getLocation();
		}
		while(!this.isRemoved()) {
			EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
			if (entityhitresult != null) {
				hitresult = entityhitresult;
			}
			if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
				Entity hit = ((EntityHitResult)hitresult).getEntity();
				Entity owner = this.getOwner();
				System.out.println("BULLET "+this);
				System.out.println("HIT "+hit);
				System.out.println("OWNER "+owner);
				if (owner instanceof Player) {
					if (hit instanceof Player && !((Player)owner).canHarmPlayer((Player)hit)) {
						hitresult = null;
						entityhitresult = null;
					} else if (hit instanceof EntityAbstractAircraft plane) {
						Entity c = plane.getControllingPassenger();
						if (c != null && c instanceof Player 
								&& !((Player)owner).canHarmPlayer((Player)c)) {
							hitresult = null;
							entityhitresult = null;
						}
					}
				}
			}
			if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !noPhysics 
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
				this.onHit(hitresult);
				this.hasImpulse = true;
				break;
			}
			if (entityhitresult == null /*|| this.getPierceLevel() <= 0*/) {	
				break;
			}
			hitresult = null;
		}
		super.tick();
	}
	
	@Override
	public void onHit(HitResult result) {
		if (this.isRemoved()) return;
		this.setPos(result.getLocation());
		super.onHit(result);
	}
	
	@Override
	public void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		//System.out.println("BULLET HIT "+result.getBlockPos());
		this.checkExplode();
		this.discard();
	}
	
	@Override
	public void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		//System.out.println("BULLET HIT "+result.getEntity());
		DamageSource source = this.getDamageSource(false);
		result.getEntity().hurt(source, getDamage());
		checkExplode();
		this.discard();
	}
	
	@Nullable
	protected EntityHitResult findHitEntity(Vec3 p_36758_, Vec3 p_36759_) {
		return ProjectileUtil.getEntityHitResult(this.level, this, p_36758_, p_36759_, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), this::canHitEntity);
	}
	
	protected DamageSource getDamageSource(boolean explosion) {
		Entity owner = getOwner();
		if (owner instanceof LivingEntity living) {
			return new WeaponDamageSource(living, this, explosion);
		}
		if (explosion) return DamageSource.explosion((Explosion)null);
		return new EntityDamageSource("dscombat.bullet", this);
	}
	
	protected void checkExplode() {
		//System.out.println("explode");
		//BulletData data = (BulletData) this.getWeaponData();
		if (this.getExplosive()) {
			if (!this.level.isClientSide) {
				Explosion.BlockInteraction interact = Explosion.BlockInteraction.NONE;
				if (this.getTerrain()) interact = Explosion.BlockInteraction.BREAK;
				level.explode(this, getDamageSource(true),
						null, getX(), getY(), getZ(), 
						this.getRadius(), this.getFire(), 
						interact);
				//System.out.println("EXPLODE "+this);
			} else {
				level.addParticle(ParticleTypes.SMOKE, 
						this.getX(), this.getY()+0.5D, this.getZ(), 
						0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	@Override
	protected void motion() {
		Vec3 dir = UtilAngles.rotationToVector(this.getYRot(), this.getXRot());
		this.setDeltaMovement(dir.scale(this.getSpeed()));
	}
	
	public float getDamage() {
		return entityData.get(DAMAGE);
	}
	
	public void setDamage(float damage) {
		entityData.set(DAMAGE, damage);
	}
	
	public boolean getExplosive() {
		return entityData.get(EXPLOSIVE);
	}
	
	public void setExplosive(boolean explosive) {
		entityData.set(EXPLOSIVE, explosive);
	}
	
	public boolean getTerrain() {
		return entityData.get(TERRAIN);
	}
	
	public void setTerrain(boolean terrain) {
		entityData.set(TERRAIN, terrain);
	}
	
	public boolean getFire() {
		return entityData.get(FIRE);
	}
	
	public void setFire(boolean fire) {
		entityData.set(FIRE, fire);
	}
	
	public float getRadius() {
		return entityData.get(RADIUS);
	}
	
	public void setRadius(float radius) {
		entityData.set(RADIUS, radius);
	}
	
	public float getSpeed() {
		return entityData.get(SPEED);
	}
	
	public void setSpeed(float speed) {
		entityData.set(SPEED, speed);
	}

}
