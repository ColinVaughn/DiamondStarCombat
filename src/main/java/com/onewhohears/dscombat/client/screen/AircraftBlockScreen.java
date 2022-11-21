package com.onewhohears.dscombat.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.common.container.AircraftBlockMenuContainer;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AircraftBlockScreen extends AbstractContainerScreen<AircraftBlockMenuContainer> {
	
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(DSCombatMod.MODID,
			"textures/ui/aircraft_screen.png");
	
	public AircraftBlockScreen(AircraftBlockMenuContainer menu, Inventory playerInv, Component title) {
		super(menu, playerInv, title);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 256;
		this.imageHeight = 256;
	}
	
	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(poseStack);
		super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack stack, float pTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, BG_TEXTURE);
		blit(stack, leftPos, topPos, 0, 0, imageWidth, imageHeight);
	}
	
	@Override
	protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
		font.draw(stack, title, titleLabelX+38, titleLabelY, 0x404040);
		font.draw(stack, playerInventoryTitle, inventoryLabelX+38, inventoryLabelY+56, 0x404040);
	}
	
	@Override
	protected void init() {
		super.init();
		Button prevButton = new Button(0, 0, 10, 20, 
				Component.literal("<"), 
				onPress -> { prevButton(); });
		prevButton.x = getGuiLeft() + titleLabelX+38;
		prevButton.y = getGuiTop() + titleLabelY+10;
		addRenderableWidget(prevButton);
		Button nextButton = new Button(0, 0, 10, 20, 
				Component.literal(">"), 
				onPress -> { nextButton(); });
		nextButton.x = getGuiLeft() + titleLabelX+192;
		nextButton.y = getGuiTop() + titleLabelY+10;
		addRenderableWidget(nextButton);
		Button craftButton = new Button(0, 0, 80, 20, 
				Component.translatable("dscombat.craft_button"), 
				onPress -> { craftButton(); });
		craftButton.x = getGuiLeft() + titleLabelX+122;
		craftButton.y = getGuiTop() + titleLabelY+110;
		addRenderableWidget(craftButton);
	}
	
	@Override
	public void containerTick() {
		super.containerTick();
	}
	
	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
		return super.mouseScrolled(mouseX, mouseY, scroll);
	}
	
	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		return super.mouseClicked(mouseX, mouseY, button);
	}
	
	@Override
	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		return super.mouseReleased(mouseX, mouseY, button);
	}
	
	private void prevButton() {
		
	}
	
	private void nextButton() {
		
	}
	
	private void craftButton() {
		
	}

}
