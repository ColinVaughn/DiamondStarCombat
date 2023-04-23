package com.onewhohears.dscombat.common.network.toserver;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.onewhohears.dscombat.common.network.IPacket;
import com.onewhohears.dscombat.entity.aircraft.EntityAircraft;
import com.onewhohears.dscombat.init.DataSerializers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent.Context;

public class ToServerAircraftAV extends IPacket {
	
	public final int id;
	public final Vec3 av;
	
	public ToServerAircraftAV(EntityAircraft e) {
		this.id = e.getId();
		this.av = e.clientAV;
	}
	
	public ToServerAircraftAV(FriendlyByteBuf buffer) {
		id = buffer.readInt();
		av = DataSerializers.VEC3.read(buffer);
	}
	
	@Override
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(id);
		DataSerializers.VEC3.write(buffer, av);
	}

	@Override
	public boolean handle(Supplier<Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			success.set(true);
			ServerPlayer player = ctx.get().getSender();
			ServerLevel level = player.getLevel();
			if (level.getEntity(id) instanceof EntityAircraft plane) {
				plane.setAngularVel(av);
			}
		});
		ctx.get().setPacketHandled(true);
		return success.get();
	}

}
