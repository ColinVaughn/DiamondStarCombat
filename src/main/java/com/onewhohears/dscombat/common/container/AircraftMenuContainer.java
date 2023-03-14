package com.onewhohears.dscombat.common.container;

import java.util.List;

import com.onewhohears.dscombat.common.container.slot.PartItemSlot;
import com.onewhohears.dscombat.data.parts.PartSlot;
import com.onewhohears.dscombat.entity.aircraft.EntityAircraft;
import com.onewhohears.dscombat.init.ModContainers;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class AircraftMenuContainer extends AbstractContainerMenu {
	
	private Container playerInv;
	private Container planeInv;
	
	public AircraftMenuContainer(int id, Inventory playerInv) {
		super(ModContainers.PLANE_MENU.get(), id);
		System.out.println("AircraftMenuContainer client side "+playerInv.player.level.isClientSide);
		this.playerInv = playerInv;
		// display plane parts
		if (playerInv.player.getRootVehicle() instanceof EntityAircraft plane) {
			this.planeInv = plane.partsManager.getInventory();
			List<PartSlot> slots = plane.partsManager.getSlots();
			// create plane menu container
			for (int i = 0; i < planeInv.getContainerSize(); ++i) {
				//System.out.println("partsInv i = "+i);
				this.addSlot(new PartItemSlot(planeInv, i, slots.get(i)));
			}
		}
		// display player inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				//System.out.println("playerInv i = "+i+" j = "+j);
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 48 + j * 18, 138 + i * 18));
			}
		}
		for(int i = 0; i < 9; i++) {
			//System.out.println("playerInv i = "+i);
			this.addSlot(new Slot(playerInv, i, 48 + i * 18, 196));
		}
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}
	
	@Override
	public void slotsChanged(Container inventory) {
		super.slotsChanged(inventory);
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack stack = ItemStack.EMPTY;
		// TODO quick move stack aircraft menu
		return stack;
	}
	
	public Container getPlayerInventory() {
        return this.playerInv;
    }
	
	public Container getPlaneInventory() {
		return this.planeInv;
	}

}
