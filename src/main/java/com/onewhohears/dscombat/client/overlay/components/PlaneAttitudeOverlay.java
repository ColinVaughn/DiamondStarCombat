package com.onewhohears.dscombat.client.overlay.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.client.overlay.VehicleOverlayComponent;
import com.onewhohears.dscombat.entity.vehicle.EntityHelicopter;
import com.onewhohears.dscombat.entity.vehicle.EntityPlane;
import com.onewhohears.dscombat.entity.vehicle.EntityVehicle;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.jetbrains.annotations.NotNull;

import static com.onewhohears.dscombat.client.overlay.components.TurnCoordinatorOverlay.TURN_COORD_SIZE;
import static com.onewhohears.dscombat.client.overlay.components.VehicleControlOverlay.STICK_BASE_SIZE;
import static com.onewhohears.dscombat.client.overlay.components.VehicleThrottleOverlay.THROTTLE_WIDTH;

// TODO: redo texture
public class PlaneAttitudeOverlay extends VehicleOverlayComponent {
    public static final ResourceLocation ATTITUDE_BASE = new ResourceLocation(DSCombatMod.MODID,
            "textures/ui/attitude_base.png");
    public static final ResourceLocation ATTITUDE_FRAME = new ResourceLocation(DSCombatMod.MODID,
            "textures/ui/attitude_frame.png");
    public static final ResourceLocation ATTITUDE_MID = new ResourceLocation(DSCombatMod.MODID,
            "textures/ui/attitude_mid.png");
    public static final ResourceLocation ATTITUDE_FRONT = new ResourceLocation(DSCombatMod.MODID,
            "textures/ui/attitude_front.png");

    private static final int ATTITUDE_SIZE = 80;

    @Override
    protected boolean shouldRender(ForgeGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        if (defaultRenderConditions()) return false;
        return getPlayerRootVehicle() instanceof EntityPlane || getPlayerRootVehicle() instanceof EntityHelicopter;
    }

    @Override
    protected void render(ForgeGui gui, PoseStack poseStack, float partialTick, int screenWidth, int screenHeight) {
        EntityVehicle vehicle = (EntityVehicle) getPlayerRootVehicle();
        assert vehicle != null;

        int attX = screenWidth - ATTITUDE_SIZE - PADDING *3- STICK_BASE_SIZE - THROTTLE_WIDTH;
        int attY = screenHeight - PADDING *2- TURN_COORD_SIZE- ATTITUDE_SIZE;
        RenderSystem.setShaderTexture(0, ATTITUDE_BASE);
        blit(poseStack,
                attX, attY,
                0, 0,
                ATTITUDE_SIZE, ATTITUDE_SIZE,
                ATTITUDE_SIZE, ATTITUDE_SIZE);
        RenderSystem.setShaderTexture(0, ATTITUDE_MID);
        poseStack.pushPose();
        poseStack.translate(attX+ (double) ATTITUDE_SIZE /2, attY+ (double) ATTITUDE_SIZE /2, 0);
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(-vehicle.zRot));
        int pitchPointY = (int)(Mth.clamp(-vehicle.getXRot(), -30, 30) * ATTITUDE_SIZE * 0.0055);
        poseStack.translate(0, pitchPointY, 0);
        blit(poseStack,
                -ATTITUDE_SIZE /2, -ATTITUDE_SIZE /2,
                0, 0,
                ATTITUDE_SIZE, ATTITUDE_SIZE,
                ATTITUDE_SIZE, ATTITUDE_SIZE);
        poseStack.popPose();
        RenderSystem.setShaderTexture(0, ATTITUDE_FRAME);
        blit(poseStack,
                attX, attY,
                0, 0,
                ATTITUDE_SIZE, ATTITUDE_SIZE,
                ATTITUDE_SIZE, ATTITUDE_SIZE);
        RenderSystem.setShaderTexture(0, ATTITUDE_FRONT);
        blit(poseStack,
                attX, attY,
                0, 0,
                ATTITUDE_SIZE, ATTITUDE_SIZE,
                ATTITUDE_SIZE, ATTITUDE_SIZE);
    }

    @Override
    protected @NotNull String componentId() {
        return "dscombat_attitude";
    }
}
