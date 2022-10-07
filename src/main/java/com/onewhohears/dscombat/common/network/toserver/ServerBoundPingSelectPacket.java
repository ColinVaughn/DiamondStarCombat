package com.onewhohears.dscombat.common.network.toserver;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.onewhohears.dscombat.common.network.IPacket;
import com.onewhohears.dscombat.data.RadarData.RadarPing;
import com.onewhohears.dscombat.entity.aircraft.EntityAbstractAircraft;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent.Context;

public class ServerBoundPingSelectPacket extends IPacket {
	
	public final int id;
	public final RadarPing ping;
	
	public ServerBoundPingSelectPacket(int planeId, RadarPing ping) {
		this.id = planeId;
		this.ping = ping;
	}
	
	public ServerBoundPingSelectPacket(FriendlyByteBuf buffer) {
		id = buffer.readInt();
		ping = new RadarPing(buffer);
	}
	
	@Override
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(id);
		ping.write(buffer);
	}

	@Override
	public boolean handle(Supplier<Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			success.set(true);
			ServerPlayer player = ctx.get().getSender();
			ServerLevel level = player.getLevel();
			EntityAbstractAircraft plane = (EntityAbstractAircraft) level.getEntity(id);
			if (plane != null) {
				plane.radarSystem.selectTarget(ping);
			}
		});
		ctx.get().setPacketHandled(true);
		return success.get();
	}

}
