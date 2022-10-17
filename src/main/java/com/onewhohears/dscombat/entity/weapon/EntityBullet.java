package com.onewhohears.dscombat.entity.weapon;

import javax.annotation.Nullable;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.weapon.BulletData;
import com.onewhohears.dscombat.data.weapon.WeaponDamageSource;
import com.onewhohears.dscombat.data.weapon.WeaponData;
import com.onewhohears.dscombat.entity.aircraft.EntityAbstractAircraft;
import com.onewhohears.dscombat.entity.aircraft.plane.EntityTestPlane;
import com.onewhohears.dscombat.init.ModEntities;

import net.minecraft.client.model.EntityModel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
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
	
	private static final ResourceLocation TEXTURE_BULLET1 = new ResourceLocation(DSCombatMod.MODID, "textures/entities/bullet1.png");
	public static EntityModel<EntityTestPlane> MODEL_BULLET1 = null;
	
	public EntityBullet(EntityType<? extends EntityBullet> type, Level level) {
		super(type, level);
	}
	
	public EntityBullet(Level level, Entity owner, BulletData data) {
		this(ModEntities.BULLET.get(), level);
		this.setOwner(owner);
		this.setWeaponData(data);
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
		if (source != null) {
			result.getEntity().hurt(source, ((BulletData)getWeaponData()).getDamage());
			checkExplode();
		}
		this.discard();
	}
	
	@Nullable
	protected EntityHitResult findHitEntity(Vec3 p_36758_, Vec3 p_36759_) {
		return ProjectileUtil.getEntityHitResult(this.level, this, p_36758_, p_36759_, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), this::canHitEntity);
	}
	
	protected DamageSource getDamageSource(boolean explosion) {
		DamageSource source = null;
		if (getOwner() instanceof LivingEntity living) {
			source = new WeaponDamageSource(living, this, explosion);
		}
		return source;
	}
	
	protected void checkExplode() {
		//System.out.println("explode");
		BulletData data = (BulletData) this.getWeaponData();
		if (data.isExplosive()) {
			if (!this.level.isClientSide) {
				Explosion.BlockInteraction interact = Explosion.BlockInteraction.NONE;
				if (data.isDestroyTerrain()) interact = Explosion.BlockInteraction.BREAK;
				level.explode(this, getDamageSource(true),
						null, getX(), getY(), getZ(), 
						data.getExplosionRadius(), data.isCausesFire(), 
						interact);
				System.out.println("EXPLODE "+this);
			} else {
				level.addParticle(ParticleTypes.SMOKE, 
						this.getX(), this.getY()+0.5D, this.getZ(), 
						0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	@Override
	public ResourceLocation getTexture() {
		return TEXTURE_BULLET1;
	}
	
	@Override
	public EntityModel<?> getModel() {
		return MODEL_BULLET1;
	}

	@Override
	public WeaponData getDefaultData() {
		return new BulletData("default_bullet", Vec3.ZERO, 
				0, 0, 0, 0, 0, 0);
	}

}
