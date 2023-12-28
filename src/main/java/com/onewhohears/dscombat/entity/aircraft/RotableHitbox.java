package com.onewhohears.dscombat.entity.aircraft;

import java.util.List;
import java.util.function.Predicate;

import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.onewhohears.dscombat.util.math.RotableAABB;
import com.onewhohears.dscombat.util.math.UtilAngles;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.entity.PartEntity;

public class RotableHitbox extends PartEntity<EntityVehicle> {
	
	private final String name;
	private final RotableAABB hitbox;
	private final EntityDimensions size;
	private final Vec3 rel_pos;
	
	public RotableHitbox(EntityVehicle parent, String name, Vector3f size, Vec3 rel_pos) {
		super(parent);
		this.name = name;
		this.hitbox = new RotableAABB(size.x(), size.y(), size.z());
		//this.size = hitbox.getMaxDimensions();
		this.size = EntityDimensions.scalable(1f, 1f);
		this.rel_pos = rel_pos;
		this.noPhysics = true;
		// this.blocksBuilding = true;
		refreshDimensions();
	}
	
	@Override
	public void tick() {
		positionSelf();
		pushEntitiesOut();
		firstTick = false;
	}
	
	protected void positionSelf() {
		setOldPosAndRot();
		Quaternion q = getParent().getQBySide();
		Vec3 pos = getParent().position().add(UtilAngles.rotateVector(getRelPos(), q));
		setPos(pos);
		hitbox.setCenterAndRot(pos, q);
		//System.out.println("AABB="+getBoundingBox().toString()+" "+this);
		
	}
	
	public void handlePosibleCollision(List<VoxelShape> colliders, Entity entity, AABB aabb, Vec3 move) {
		if (!couldCollide(entity) || !hitbox.isColliding(aabb)) return;
		//System.out.println("HANDLE COLLISION "+entity+" "+move);
		// FIXME 4.6 prevent entities from falling off when the chunks load
		if (!getParent().didEntityAlreadyCollide(entity)) {
			Vec3 entityMoveByParent = moveEntityFromParent(entity);
			hitbox.updateColliders(colliders, aabb, entityMoveByParent);
			getParent().addHitboxCollider(entity);
		}
	}
	
	public Vec3 moveEntityFromParent(Entity entity) {
		Vec3 parent_pos = getParent().position();
		Vec3 parent_move = getParent().getDeltaMovement();
		Vec3 parent_rot_rate = getParent().getAngularVel();
		Quaternion q = getParent().getQBySide();
		Quaternion qi = q.copy();
		qi.conj();
		Vec3 rel_pos = UtilAngles.rotateVector(entity.position().subtract(parent_pos), qi);
		Vec3 rel_tan_vel = parent_rot_rate.scale(Math.toRadians(1d))
				.multiply(-1d,-1d,1d).cross(rel_pos);
		Vec3 tan_vel = UtilAngles.rotateVector(rel_tan_vel, q);
		Vec3 entityMoveByParent = parent_move.add(tan_vel);//.add(0, 0.001, 0);
		entity.setPos(entity.position().add(entityMoveByParent));
		entity.setYRot(entity.getYRot()-(float)parent_rot_rate.y);
		if (entity instanceof EntityVehicle vehicle) {
			Quaternion qv = vehicle.getQBySide();
			qv.mul(Vector3f.YN.rotationDegrees((float)parent_rot_rate.y));
			vehicle.setQBySide(qv);
		}
		return entityMoveByParent;
	}
	
	protected void pushEntitiesOut() {
		// FIXME 4.1 push out of rotable hitbox isn't working correctly
		List<Entity> list = level.getEntities(this, hitbox.getMaxDimBox(), PUSH_OUT);
		for (Entity entity : list) {
			System.out.println("PUSHING OUT "+entity);
			entity.setPos(hitbox.getPushOutPos(entity.position(), entity.getBoundingBox()));
			System.out.println("PUSHED OUT  "+entity);
		}
	}
	
	public final Predicate<? super Entity> PUSH_OUT = (entity) -> {
		if (!couldCollide(entity)) return false;
		if (!isInside(entity)) return false;
		return true;
	};
	
	public boolean isInside(Entity entity) {
		return hitbox.isInside(entity.getBoundingBox());
	}
	
	public boolean couldCollide(Entity entity) {
		if (entity.noPhysics) return false;
		if (entity.isRemoved()) return false;
		if (!entity.canCollideWith(getParent())) return false;
		if (entity.isPassenger()) return false;
		if (entity.getRootVehicle().equals(getParent())) return false;
		return true;
	}
	
	@Override
    public boolean hurt(DamageSource source, float amount) {
    	return getParent().hurt(source, amount);
    }
	
	@Override
    protected AABB makeBoundingBox() {
		if (hitbox == null) return AABB.ofSize(position(), 1f, 1f, 1f);
		return hitbox.getDisguisedAABB(position());
    }
	
	public String getHitboxName() {
		return name;
	}
	
	public RotableAABB getHitbox() {
		return hitbox;
	}
	
	public Vec3 getRelPos() {
		return rel_pos;
	}
	
	@Override
	public boolean isPickable() {
		return true;
	}
	
	@Override
    public boolean isPushable() {
    	return false;
    }
    
    @Override
    public boolean isPushedByFluid() {
    	return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    @Override
    public boolean canCollideWith(Entity entity) {
    	return couldCollide(entity);
    }
	
    @Override
	public EntityDimensions getDimensions(Pose pPose) {
		return size;
	}
	
	@Override
	public Packet<?> getAddEntityPacket() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean shouldBeSaved() {
		return false;
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag nbt) {
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag nbt) {
	}

}
