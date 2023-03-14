package com.onewhohears.dscombat.data.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.onewhohears.dscombat.common.network.PacketHandler;
import com.onewhohears.dscombat.common.network.toclient.ToClientAddPart;
import com.onewhohears.dscombat.common.network.toclient.ToClientAircraftFuel;
import com.onewhohears.dscombat.common.network.toclient.ToClientRemovePart;
import com.onewhohears.dscombat.data.parts.PartData.PartType;
import com.onewhohears.dscombat.entity.aircraft.EntityAircraft;
import com.onewhohears.dscombat.item.ItemSeat;
import com.onewhohears.dscombat.util.UtilParse;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.PacketDistributor;

public class PartsManager {
	
	private List<PartSlot> slots = new ArrayList<PartSlot>();
	private Container inventory = new SimpleContainer(0);
	private boolean readData = false;
	private EntityAircraft parent;
	
	public PartsManager() {
		
	}
	
	/**
	 * deletes all slot data currently in the list and reads from this compound
	 * @param compound
	 */
	public void read(CompoundTag compound) {
		
		slots.clear();
		ListTag list = compound.getList("slots", 10);
		for (int i = 0; i < list.size(); ++i) {
			CompoundTag tag = list.getCompound(i);
			slots.add(new PartSlot(tag));
		}
		createNewInventory();
		readData = true;
	}
	
	private void createNewInventory() {
		System.out.println("CREATING NEW INVENTORY client side = "+parent.level.isClientSide+" for slots "+this);
		inventory = new SimpleContainer(slots.size()) {
			@Override
			public void setChanged() {
				super.setChanged();
			}
			@Override
			public void setItem(int i, ItemStack stack) {
				System.out.println("SET ITEM "+i+" "+stack);
				if (readData) this.setItem(i, stack);
				super.setItem(i, stack);
			}
			@Override
			public ItemStack removeItem(int i, int count) {
				System.out.println("REMOVE ITEM "+i);
				if (readData) this.removeItem(i, count);
				return super.removeItem(i, count);
			}			
		};
		for (int i = 0; i < slots.size(); ++i) if (slots.get(i).filled()) {
			inventory.setItem(i, slots.get(i).getPartData().getNewItemStack());
			System.out.println("new item in slot "+i+" "+inventory.getItem(i)+" "+inventory.getItem(i).getTag());
		}
	}
	
	public void setItem(int i, ItemStack stack) {
		if (i < 0 || i >= slots.size()) {
			System.out.println("WARNING! INDEX "+i+" IS OUT OF BOUNDS IN PARTS MANAGER "+this);
			return;
		}
		PartSlot slot = slots.get(i);
		Entity pilot = null;
		if (slot.isPilotSlot()) pilot = parent.getControllingPassenger();
		if (stack.isEmpty()) {
			//removePart(slot.getName(), false);
			slot.removePartData(parent);
			if (pilot != null && pilot.getVehicle() == null) {
				SeatData seatdata = ItemSeat.getDefaultSeat();
				//addPart(seatdata, slot.getName(), false);
				slot.addPartData(seatdata, parent);
				parent.rideAvailableSeat(pilot);
				readData = false;
				inventory.setItem(i, seatdata.getNewItemStack());
				readData = true;
			}
		} else {
			PartData data = UtilParse.parsePartFromCompound(stack.getTag());
			if (data == null) {
				System.out.println("ERROR! COULD NOT GET PART DATA FROM "+stack+" "+stack.getTag());
				return;
			}
			//if (slot.filled()) removePart(slot.getName(), false);
			if (slot.filled()) slot.removePartData(parent);
			//addPart(data, slot.getName(), false);
			slot.addPartData(data, parent);
			if (pilot != null && pilot.getVehicle() == null) {
				parent.rideAvailableSeat(pilot);
			}
		}	
	}
	
	public void removeItem(int i, int count) {
		if (i < 0 || i >= slots.size()) {
			System.out.println("WARNING! INDEX "+i+" IS OUT OF BOUNDS IN PARTS MANAGER "+this);
			return;
		}
		Entity pilot = null;
		if (slots.get(i).isPilotSlot()) pilot = parent.getControllingPassenger();
		//removePart(slots.get(i).getName(), false);
		slots.get(i).removePartData(parent);
		if (pilot != null && pilot.getVehicle() == null) {
			SeatData seatdata = ItemSeat.getDefaultSeat();
			//addPart(seatdata, slot.getName(), false);
			slots.get(i).addPartData(seatdata, parent);
			parent.rideAvailableSeat(pilot);
			readData = false;
			inventory.setItem(i, seatdata.getNewItemStack());
			readData = true;
		}
	}
	
	public void write(CompoundTag compound) {
		ListTag list = new ListTag();
		for (PartSlot s : slots) list.add(s.write());
		compound.put("slots", list);
	}
	
	public PartsManager(FriendlyByteBuf buffer) {
		int num = buffer.readInt();
		for (int i = 0; i < num; ++i) slots.add(new PartSlot(buffer));
		createNewInventory();
		readData = true;
	}
	
	public void write(FriendlyByteBuf buffer) {
		buffer.writeInt(slots.size());
		for (PartSlot p : slots) p.write(buffer);
	}
	
	/**
	 * @param copy copies this part manager's slot data
	 */
	public void copy(PartsManager copy) {
		this.slots = copy.slots;
		createNewInventory();
		readData = true;
	}
	
	public void setupParts(EntityAircraft craft) {
		this.parent = craft;
		//System.out.println("setupParts "+this);
		for (PartSlot p : slots) p.setup(craft);
	}
	
	public void clientPartsSetup(EntityAircraft craft) {
		this.parent = craft;
		//System.out.println("clientPartsSetup "+this);
		for (PartSlot p : slots) p.clientSetup(craft);
	}
	
	public void tickParts() {
		for (PartSlot p : slots) p.tick();
	}
	
	public void clientTickParts() {
		for (PartSlot p : slots) p.clientTick();
	}
	
	// TODO these shouldn't need to send packets and shouldn't be public
	public boolean addPart(PartData part, String slotName, boolean updateClient) {
		System.out.println("ADDING PART "+part+" IN SLOT "+slotName+" client side "+parent.level.isClientSide);
		for (PartSlot p : slots) if (p.getName().equals(slotName) && !p.filled()) {
			boolean ok = p.addPartData(part, parent);
			if (updateClient && ok) {
				PacketHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> parent), 
						new ToClientAddPart(parent.getId(), slotName, part));
			}
			return true;
		}
		return false;
	}
	
	public void removePart(String slotName, boolean updateClient) {
		System.out.println("ADDING PART IN SLOT "+slotName+" client side "+parent.level.isClientSide);
		for (PartSlot p : slots) if (p.getName().equals(slotName)) {
			boolean ok = p.removePartData(parent);
			if (updateClient && ok) {
				PacketHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> parent), 
						new ToClientRemovePart(parent.getId(), slotName));
			}
			return;
		}
	}
	
	@Nullable
	public PartSlot getSlot(String slotName) {
		for (PartSlot p : slots) if (p.getName().equals(slotName)) return p;
		return null;
	}
	
	@Override
	public String toString() {
		String s = "Parts:";
		for (int i = 0; i < slots.size(); ++i) s += slots.get(i).toString();
		return s;
	}
	
	public boolean isReadData() {
		return readData;
	}
	
	public float getPartsWeight() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled()) total += p.getPartData().getWeight();
		return total;
	}
	
	public float getTotalEngineThrust() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.ENGINE) 
			total += ((EngineData)p.getPartData()).getThrust();
		return total;
	}
	
	public float getTotalEngineHeat() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.ENGINE) 
			total += ((EngineData)p.getPartData()).getHeat();
		return total;
	}
	
	public float getTotalEngineFuelConsume() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.ENGINE) 
			total += ((EngineData)p.getPartData()).getFuelPerTick();
		return total;
	}
	
	public float getCurrentFuel() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.FUEL_TANK) 
			total += ((FuelTankData)p.getPartData()).getFuel();
		return total;
	}
	
	public float getMaxFuel() {
		float total = 0;
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.FUEL_TANK) 
			total += ((FuelTankData)p.getPartData()).getMaxFuel();
		return total;
	}
	
	public float addFuel(float fuel) {
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.FUEL_TANK) {
			FuelTankData data = (FuelTankData) p.getPartData();
			fuel = data.addFuel(fuel);
			if (fuel == 0) break;
		}
		return fuel;
	}
	
	public void tickFuel(boolean updateClient) {
		addFuel(-getTotalEngineFuelConsume() * Math.abs(parent.getCurrentThrottle()));
		if (updateClient && parent.tickCount % 100 == 0) {
			PacketHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> parent), 
					new ToClientAircraftFuel(parent));
		}
	}
	
	public List<PartSlot> getFuelTanks() {
		List<PartSlot> tanks = new ArrayList<PartSlot>();
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.FUEL_TANK) tanks.add(p);
		return tanks;
	}
	
	public float[] getFuelsForClient() {
		List<PartSlot> tanks = getFuelTanks();
		float[] fuels = new float[tanks.size()];
		for (int i = 0; i < tanks.size(); ++i) fuels[i] = ((FuelTankData)tanks.get(i).getPartData()).getFuel();
		return fuels;
	}
	
	public void readFuelsForClient(float[] fuels) {
		List<PartSlot> tanks = getFuelTanks();
		if (fuels.length != tanks.size()) return;
		for (int i = 0; i < tanks.size(); ++i) ((FuelTankData)tanks.get(i).getPartData()).setFuel(fuels[i]);
	}
	
	/*public void readContainer(Container c) {
		//System.out.println("READING CHANGED CONTAINER client side "+parent.level.isClientSide+" items "+c);
		if (c.getContainerSize() != slots.size()) {
			System.out.println("WARNING! THIS CONTAINER HAS THE WRONG NUMBER OF SLOTS!");
			return;
		}
		for (int i = 0; i < c.getContainerSize(); ++i) {
			ItemStack stack = c.getItem(i);
			if (stack.isEmpty()) {
				removePart(slots.get(i).getName(), false);
				continue;
			}
		}
		for (int i = 0; i < c.getContainerSize(); ++i) {
			//System.out.println("### CHECKING CONTAINER "+i);
			ItemStack stack = c.getItem(i);
			if (stack.isEmpty()) continue;
			PartSlot slot = slots.get(i);
			//System.out.println("stack = "+stack+" "+stack.getTag());
			//System.out.println("slot = "+slot);
			PartData data = UtilParse.parsePartFromCompound(stack.getTag());
			if (data == null) {
				System.out.println("ERROR! COULD NOT GET PART DATA FROM "+stack+" "+stack.getTag());
				continue;
			}
			if (data.isSetup(slot.getName(), parent)) {
				//System.out.println("ALREADY SETUP");
				continue;
			}
			//System.out.println("REMOVING");
			removePart(slot.getName(), false);
			//System.out.println("ADDING");
			addPart(data, slot.getName(), false);
		}
	}*/
	
	public List<PartSlot> getSlots() {
		return slots;
	}
	
	public Container getInventory() {
		return inventory;
	}
	
	public List<PartSlot> getFlares() {
		List<PartSlot> flares = new ArrayList<PartSlot>();
		for (PartSlot p : slots) if (p.filled() && p.getPartData().getType() == PartType.FLARE_DISPENSER) flares.add(p);
		return flares;
	}
	
	public boolean useFlares(boolean consume) {
		List<PartSlot> flares = getFlares();
		boolean r = false;
		for (PartSlot p : flares)
			if (((FlareDispenserData)p.getPartData()).flare(consume))
				r = true;
		return r;
	}
	
}
