package com.onewhohears.dscombat.integration.jei;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.crafting.VehicleRecipe;
import com.onewhohears.dscombat.init.ModBlocks;
import com.onewhohears.dscombat.util.UtilMCText;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class VehicleRecipeCategory implements IRecipeCategory<VehicleRecipe> {
	
	public static final ResourceLocation UID = new ResourceLocation(DSCombatMod.MODID, "aircraft_workbench");
	public static final RecipeType<VehicleRecipe> TYPE = RecipeType.create(UID.getNamespace(), UID.getPath(), VehicleRecipe.class);
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(DSCombatMod.MODID,
			"textures/ui/vehicle_forge_ui.png");
	
	private final IDrawable background;
	private final IDrawable icon;
	
	public VehicleRecipeCategory(IGuiHelper helper) {
		background = helper.drawableBuilder(TEXTURE, 64, 27, 224, 129)
				.setTextureSize(512, 512).build();
		icon = helper.createDrawableItemStack(ModBlocks.AIRCRAFT_BLOCK.get().asItem().getDefaultInstance());
	}
	
	@Override
	public RecipeType<VehicleRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return UtilMCText.translatable("container.dscombat.aircraft_block_menu");
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, VehicleRecipe recipe, IFocusGroup focuses) {
		NonNullList<Ingredient> ingredients = recipe.getIngredients();
		int startX = 33, startY = 95;
		int ix = startX, iy = startY;
		int space = 18;
		for (int i = 0; i < ingredients.size(); ++i) {
			if (i == 9) {
				ix = startX;
				iy += space;
			}
			builder.addSlot(RecipeIngredientRole.INPUT, ix, iy).addIngredients(ingredients.get(i));
			ix += space;
		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, 105, 61).addItemStack(recipe.getResultItem());
	}

}
