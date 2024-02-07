package com.onewhohears.dscombat.entity.aircraft.custom;

import com.onewhohears.dscombat.client.model.obj.ObjRadarModel.MastType;
import com.onewhohears.dscombat.data.aircraft.presets.BoatPresets;
import com.onewhohears.dscombat.entity.aircraft.EntityBoat;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GronkBattleship extends EntityBoat {
	
	public GronkBattleship(EntityType<? extends EntityBoat> entity, Level level) {
		super(entity, level, BoatPresets.DEFAULT_GRONK_BATTLESHIP.getId());
	}
	
	@Override
	public MastType getMastType() {
		return MastType.NORMAL;
	}

}
