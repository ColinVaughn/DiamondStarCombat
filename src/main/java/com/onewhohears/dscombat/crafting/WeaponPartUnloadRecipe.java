package com.onewhohears.dscombat.crafting;

import javax.annotation.Nonnull;

import com.onewhohears.dscombat.data.parts.instance.WeaponPartInstance;
import com.onewhohears.dscombat.data.weapon.WeaponPresets;
import com.onewhohears.dscombat.data.weapon.stats.WeaponStats;
import com.onewhohears.dscombat.init.ModRecipes;
import com.onewhohears.dscombat.item.ItemAmmo;
import com.onewhohears.dscombat.item.ItemWeaponPart;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class WeaponPartUnloadRecipe extends PartItemUnloadRecipe<WeaponPartInstance<?>> {

	public WeaponPartUnloadRecipe(ResourceLocation id) {
		super(id);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ModRecipes.WEAPON_PART_UNLOAD.get();
	}

	@Override @Nonnull
	public ItemStack getNewAmmoItem(String continuity) {
		WeaponStats wd = WeaponPresets.get().get(continuity);
		if (wd == null) return ItemStack.EMPTY;
		return wd.getNewItem();
	}

	@Override
	public boolean isLoadablePartItem(ItemStack stack) {
		return stack.getItem() instanceof ItemWeaponPart;
	}

	@Override
	public boolean isItemAmmo(ItemStack stack) {
		return stack.getItem() instanceof ItemAmmo;
	}

	@Override
	public boolean checkAmmoContinuity() {
		return true;
	}

	@Override
	public String getItemAmmoContinuity(ItemStack stack) {
		return ItemAmmo.getWeaponId(stack);
	}

	@Override
	public boolean isContinuityValid(String continuity) {
		return WeaponPresets.get().has(continuity);
	}

	@Override
	public int getContinuityMaxAmmo(WeaponPartInstance<?> lpd, String continuity) {
		if (!isContinuityValid(continuity)) return 0;
		return lpd.getStats().getMaxAmmo();
	}

}
