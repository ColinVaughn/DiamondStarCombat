package com.onewhohears.dscombat.common.network.toclient;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.onewhohears.dscombat.client.input.DSCClientInputs;
import com.onewhohears.dscombat.command.DSCGameRules;
import com.onewhohears.dscombat.common.network.IPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent.Context;

public class ToClientSynchGameRules extends IPacket {
	
	public final boolean disable3rdPersonVehicle;
	
	public ToClientSynchGameRules(MinecraftServer server) {
		this.disable3rdPersonVehicle = server.getGameRules().getBoolean(DSCGameRules.DISABLE_3RD_PERSON_VEHICLE);
	}
	
	public ToClientSynchGameRules(FriendlyByteBuf buffer) {
		disable3rdPersonVehicle = buffer.readBoolean();
	}
	
	@Override
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBoolean(disable3rdPersonVehicle);
	}

	@Override
	public boolean handle(Supplier<Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
				DSCClientInputs.disable3rdPersonVehicle = disable3rdPersonVehicle;
				success.set(true);
			});
		});
		ctx.get().setPacketHandled(true);
		return success.get();
	}

}
