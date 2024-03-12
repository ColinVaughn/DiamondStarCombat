package com.onewhohears.dscombat.integration.jei;

import java.util.List;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.crafting.DSCIngredient;
import com.onewhohears.dscombat.crafting.WeaponRecipe;
import com.onewhohears.dscombat.init.ModBlocks;
import com.onewhohears.dscombat.util.UtilMCText;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WeaponRecipeCategory implements IRecipeCategory<WeaponRecipe> {
	
	public final static ResourceLocation UID = new ResourceLocation(DSCombatMod.MODID, "weapon_workbench");
	public static final RecipeType<WeaponRecipe> TYPE = RecipeType.create(UID.getNamespace(), UID.getPath(), WeaponRecipe.class);
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(DSCombatMod.MODID,
			"textures/ui/aircraft_screen.png");
	
	private final IDrawable background;
	private final IDrawable icon;
	
	public WeaponRecipeCategory(IGuiHelper helper) {
		background = helper.createDrawable(TEXTURE, 0, 0, 256, 256);
		icon = helper.createDrawableItemStack(ModBlocks.WEAPONS_BLOCK.get().asItem().getDefaultInstance());
	}
	
	@Override
	public RecipeType<WeaponRecipe> getRecipeType() {
		return TYPE;
	}

	@Override
	public Component getTitle() {
		return UtilMCText.translatable("container.dscombat.weapons_block_menu");
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
	public void setRecipe(IRecipeLayoutBuilder builder, WeaponRecipe recipe, IFocusGroup focuses) {
		List<DSCIngredient> ingredients = recipe.getDSCIngredients();
		int startX = 0, startY = 0;
		int iix = startX + 122;
		int ix = iix;
		int iy = startY + 44;
		for (int i = 0; i < ingredients.size(); ++i) {
			if (i != 0 && i % 4 == 0) {
				ix = iix;
				iy += 20;
			}
			ItemStack stack = ingredients.get(i).getDisplayItem();
			builder.addSlot(RecipeIngredientRole.INPUT, ix, iy).addItemStack(stack);
			ix += 20;
		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, startX, startY).addItemStack(recipe.getResultItem());
	}

}
