package com.onewhohears.dscombat.client.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import com.onewhohears.dscombat.client.overlay.components.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.level.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@OnlyIn(Dist.CLIENT)
public class VehicleOverlay {
	public static final IGuiOverlay HUD_Aircraft_Stats = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
		if (Minecraft.getInstance().options.hideGui) return;
		if (Minecraft.getInstance().gameMode.getPlayerMode() == GameType.SPECTATOR) return;

		RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		// TODO: potentially refactor overlays to a singleton pattern so there isn't constant instantiation?
		// Something needs to be done WRT the above comment. I don't like this implementation.
		new DebugOverlay(screenWidth, screenHeight).render(poseStack);
		new PlaneAttitudeOverlay(screenWidth, screenHeight).render(poseStack);
		new PlaneDataOverlay(screenWidth, screenHeight).render(poseStack);
		new RadarOverlay(screenWidth, screenHeight, partialTick).render(poseStack);
		new VehicleCompassOverlay(screenWidth, screenHeight).render(poseStack);
		new VehicleControlOverlay(screenWidth, screenHeight).render(poseStack);
		new VehicleStatsOverlay(screenWidth, screenHeight).render(poseStack);
		new VehicleFuelOverlay(screenWidth, screenHeight).render(poseStack);
		new VehicleThrottleOverlay(screenWidth, screenHeight).render(poseStack);
		new VehicleWeaponsOverlay(screenWidth, screenHeight).render(poseStack);
		new TurnCoordinatorOverlay(screenWidth, screenHeight).render(poseStack);
		new TurretDataOverlay(screenWidth, screenHeight).render(poseStack);
	});
}
