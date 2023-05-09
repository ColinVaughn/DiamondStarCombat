package com.onewhohears.dscombat.item;

import com.onewhohears.dscombat.DSCombatMod;
import com.onewhohears.dscombat.data.weapon.WeaponData;
import com.onewhohears.dscombat.data.weapon.WeaponData.WeaponType;
import com.onewhohears.dscombat.data.weapon.WeaponPresets;
import com.onewhohears.dscombat.init.ModItems;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemAmmo extends Item {
	
	private final String defaultWeaponId;
	private final WeaponType weaponType;
	
	public ItemAmmo(int size, String defaultWeaponId, WeaponType type) {
		super(weaponProps(size));
		this.defaultWeaponId = defaultWeaponId;
		this.weaponType = type;
	}
	
	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		if (group.getId() != ModItems.WEAPONS.getId()) return;
		for (int i = 0; i < WeaponPresets.get().getPresetNum(); ++i) {
			WeaponData w = WeaponPresets.get().getAllPresets()[i];
			if (w.getType() != weaponType) continue;
			ItemStack test = new ItemStack(this);
			CompoundTag tag = new CompoundTag();
			tag.putString("weapon", w.getId());
			test.setTag(tag);
			items.add(test);
		}
	}
	
	@Override
	public Component getName(ItemStack stack) {
		return WeaponData.makeDisplayName(getCreatorModId(stack), getWeaponId(stack))
				.append(" ").append(Component.translatable(DSCombatMod.MODID+".ammo"));
	}
	
	public static String getWeaponId(ItemStack stack) {
		if (stack.getItem() instanceof ItemAmmo ia) {
			if (!stack.getOrCreateTag().contains("weapon")) return ia.defaultWeaponId;
			return stack.getOrCreateTag().getString("weapon");
		}
		return "";
	}
	
	public static Properties weaponProps(int stackSize) {
		return new Item.Properties().tab(ModItems.WEAPONS).stacksTo(stackSize);
	}

}
