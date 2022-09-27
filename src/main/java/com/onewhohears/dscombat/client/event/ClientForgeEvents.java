package com.onewhohears.dscombat.client.event;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Quaternion;
import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.client.input.KeyInit;
import com.onewhohears.dscombat.common.PacketHandler;
import com.onewhohears.dscombat.common.network.ServerBoundFlightControlPacket;
import com.onewhohears.dscombat.data.RadarData;
import com.onewhohears.dscombat.data.RadarData.RadarPing;
import com.onewhohears.dscombat.entity.aircraft.EntityAbstractAircraft;
import com.onewhohears.dscombat.entity.aircraft.parts.EntitySeat;
import com.onewhohears.dscombat.entity.aircraft.parts.EntitySeatCamera;
import com.onewhohears.dscombat.util.math.UtilAngles;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = DSCombatMod.MODID, bus = Bus.FORGE, value = Dist.CLIENT)
public final class ClientForgeEvents {
	
	private ClientForgeEvents() {}
	
	@SubscribeEvent
	public static void clientTick(TickEvent.ClientTickEvent event) {
		if (event.phase != Phase.START) return;
		Minecraft m = Minecraft.getInstance();
		final var player = m.player;
		if (player == null) return;
		//System.out.println("VEHICLE "+player.getVehicle());
		//System.out.println("ROOT "+player.getRootVehicle());
		if (!(player.getRootVehicle() instanceof EntityAbstractAircraft plane)) return;
		if (plane.getControllingPassenger() != player) return;
		boolean throttleUp = KeyInit.throttleUpKey.isDown();
		boolean throttleDown = KeyInit.throttleDownKey.isDown();
		boolean pitchUp = KeyInit.pitchUpKey.isDown();
		boolean pitchDown = KeyInit.pitchDownKey.isDown();
		boolean rollLeft = KeyInit.rollLeftKey.isDown();
		boolean rollRight = KeyInit.rollRightKey.isDown();
		boolean yawLeft = KeyInit.yawLeftKey.isDown();
		boolean yawRight = KeyInit.yawRightKey.isDown();
		boolean mouseMode = KeyInit.mouseModeKey.isDown();
		boolean flare = KeyInit.flareKey.isDown();
		boolean shoot = KeyInit.shootKey.isDown();
		boolean select = KeyInit.weaponSelectKey.isDown();
		PacketHandler.INSTANCE.sendToServer(new ServerBoundFlightControlPacket(
				throttleUp, throttleDown, pitchUp, pitchDown, 
				rollLeft, rollRight, yawLeft, yawRight,
				mouseMode, flare, shoot, select));
		plane.updateControls(throttleUp, throttleDown, pitchUp, pitchDown, 
				rollLeft, rollRight, yawLeft, yawRight, 
				mouseMode, flare, shoot, select);
		/**
		 * check if the currently selected weapon needs a packet with the target to fire
		 * TODO get radar data of plane from the server to the client
		 * draw boxes around potential radar targets
		 * client clicks on those boxes to choose a target
		 * presses shoot button to launch
		 */
	}
	
	@SubscribeEvent
	public static void onClick(InputEvent.ClickInputEvent event) {
		if (event.isAttack()) {
			//System.out.println("input attack event");
			Minecraft m = Minecraft.getInstance();
			if (m.hitResult.getType() == HitResult.Type.ENTITY) {
				EntityHitResult hit = (EntityHitResult) m.hitResult;
				if (hit.getEntity().equals(m.player)) {
					event.setSwingHand(false);
					event.setCanceled(true);
					//System.out.println("canceled");
				}
			}
		}
	}
	
	/*@SubscribeEvent
	public static void renderClient(RenderTickEvent event) {
		if (event.phase != Phase.START) return;
		Minecraft m = Minecraft.getInstance();
		final var player = m.player;
		if (player == null) return;
	}*/
	
	private static VertexBuffer pingBuffer;
	
	@SubscribeEvent
	public static void renderLevel(RenderLevelLastEvent event) {
		Minecraft m = Minecraft.getInstance();
		final var player = m.player;
		if (player.getVehicle() instanceof EntitySeat seat 
				&& seat.getVehicle() instanceof EntityAbstractAircraft plane) {
			RadarData radar = plane.getRadar();
			if (radar == null) return;
			List<RadarPing> pings = radar.getRadarPings();
			if (pings == null) return;
			//System.out.println("RADAR PINGS");
			for (int i = 0; i < pings.size(); ++i) {
				RadarPing p = pings.get(i);
				//System.out.println(p.pos);
				Vec3 view = m.gameRenderer.getMainCamera().getPosition();
				double x = p.pos.x, y = p.pos.y+0.02, z = p.pos.z, w2 = 1, w = w2/2;
				
				var tesselator = Tesselator.getInstance();
				var buffer = tesselator.getBuilder();
				if (pingBuffer != null) pingBuffer.close();
				pingBuffer = new VertexBuffer();
				buffer.begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
				// TODO change color if selected or hovering over
				buffer.vertex(x-w, y, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x-w, y, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x-w, y, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x-w, y, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x-w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x+w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x+w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				
				buffer.vertex(x-w, y+w2, z+w).color(0, 255, 0, 255).endVertex();
				buffer.vertex(x-w, y+w2, z-w).color(0, 255, 0, 255).endVertex();
				
				buffer.end();
				pingBuffer.upload(buffer);

				RenderSystem.depthMask(false);
				RenderSystem.disableCull();
				RenderSystem.enableBlend();
				RenderSystem.defaultBlendFunc();
				RenderSystem.disableTexture();
				GL11.glEnable(GL11.GL_LINE_SMOOTH);
				GL11.glEnable(GL11.GL_DEPTH_TEST);

				PoseStack poseStack = event.getPoseStack();
				poseStack.pushPose();
				poseStack.translate(-view.x, -view.y, -view.z);
				var shader = GameRenderer.getPositionColorShader();
				pingBuffer.drawWithShader(poseStack.last().pose(), event.getProjectionMatrix().copy(), shader);
				poseStack.popPose();

				RenderSystem.depthMask(true);
				RenderSystem.disableBlend();
				RenderSystem.enableCull();
				RenderSystem.enableTexture();
			}
		}
	}
	
	@SubscribeEvent
	public static void playerRender(RenderPlayerEvent.Pre event) {
		//System.out.println("render player");
		Minecraft m = Minecraft.getInstance();
		final var playerC = m.player;
		Player player = event.getPlayer();
		if (player.getVehicle() instanceof EntitySeat seat 
				&& seat.getVehicle() instanceof EntityAbstractAircraft plane) {
			changePlayerHitbox(player);
			if (player.equals(playerC) &&
					m.options.getCameraType().isFirstPerson()) {
				event.setCanceled(true);
				return;
			}
			Quaternion q = UtilAngles.lerpQ(event.getPartialTick(), plane.getPrevQ(), plane.getQ());
			event.getPoseStack().mulPose(q);
		}
		// TODO player inventory not rendering
	}
	
	private static void changePlayerHitbox(Player player) {
		double x = player.getX();
		double y = player.getY();
		double z = player.getZ();
		double w = player.getBbWidth()/2;
		player.setBoundingBox(new AABB(x+w, y+0.5d, z+w, x-w, y, z-w)); 
	}
	
	@SubscribeEvent
	public static void cameraSetup(EntityViewRenderEvent.CameraSetup event) {
		Minecraft m = Minecraft.getInstance();
		final var player = m.player;
		boolean playerCam = m.getCameraEntity().equals(player);
		if (player == null) return;
		if (player.getVehicle() instanceof EntitySeat seat 
				&& seat.getVehicle() instanceof EntityAbstractAircraft plane) {
			EntitySeatCamera camera = seat.getCamera();
			float xo, xn, yo, yn, zo, zn;
			if (plane.isFreeLook()) {
				xo = player.xRotO;
				//xo = player.getXRot();
				//xo = event.getPitch();
				xn = player.getXRot();
				yo = player.yRotO;
				//yo = player.getYRot();
				//yo = event.getYaw();
				yn = player.getYRot();
				zo = plane.prevZRot;
				//zo = event.getRoll();
				zn = plane.zRot;
			} else {
				xo = plane.prevXRot;
				//xo = event.getPitch();
				xn = plane.getXRot();
				yo = plane.prevYRot;
				//yo = event.getYaw();
				yn = plane.getYRot();
				zo = plane.prevZRot;
				//zo = event.getRoll();
				zn = plane.zRot;
			}
			float xi = xo + (xn - xo) * (float)event.getPartialTicks();
			float yi = yo + (yn - yo) * (float)event.getPartialTicks();
			float zi = zo + (zn - zo) * (float)event.getPartialTicks();
			if (m.options.getCameraType() == CameraType.THIRD_PERSON_FRONT) {
				event.setPitch(xi*-1f);
				event.setYaw(yi+180f);
				event.setRoll(zi*-1f);
			} else {
				event.setPitch(xi);
				event.setYaw(yi);
				event.setRoll(zi);
			}
			// TODO third person camera shakes probably because no lerp
			camera.setXRot(xi);
			camera.setYRot(yi);
			player.setXRot(xi);
			player.setYRot(yi);
			if (playerCam) m.setCameraEntity(camera);
		} else {
			if (!playerCam) m.setCameraEntity(player);
		}
	}
	
	/*@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent event) {
		System.out.println("attacked entity "+event.getTarget());
		if (event.getTarget().equals(event.getEntity())) {
			System.out.println("canceled");
			event.setCanceled(true);
		}
	}*/
	
	/*@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		System.out.println(event.getEntity()+" interacted with "+event.getTarget());
		if (event.getTarget().equals(event.getEntity())) {
			System.out.println("canceled");
			event.setCanceled(true);
		}
	}*/
	
}
