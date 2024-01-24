package com.onewhohears.dscombat.minigame.phase.villagedefense;

import com.onewhohears.dscombat.minigame.condition.ScoreWinExitCondition;
import com.onewhohears.dscombat.minigame.data.VillageDefenseData;
import com.onewhohears.minigames.minigame.condition.TimeoutPhaseExitCondition;
import com.onewhohears.minigames.minigame.phase.deathmatch.DeathMatchPlayPhase;

import net.minecraft.server.MinecraftServer;

public class VillageDefenseBuyPhase extends DeathMatchPlayPhase<VillageDefenseData> {

	public VillageDefenseBuyPhase(VillageDefenseData gameData) {
		super("village_defense_buy", gameData, 
			new ScoreWinExitCondition(),
			new TimeoutPhaseExitCondition<>("village_defense_buy_timeout", 
				"village_defense_attack", gameData.getBuyTime(), 
				"info.dscombat.buy_phase_end"));
	}
	
	@Override
	public void tickPhase(MinecraftServer server) {
		super.tickPhase(server);
	}
	
	@Override
	public void onReset(MinecraftServer server) {
		super.onReset(server);
	}
	
	@Override
	public void onStart(MinecraftServer server) {
		super.onStart(server);
		getGameData().addShops("attacker", "defender");
		// TODO 3.8.2 give players money
	}
	
	@Override
	public void onStop(MinecraftServer server) {
		super.onStop(server);
		getGameData().removeShops("attacker", "defender");
	}

}
