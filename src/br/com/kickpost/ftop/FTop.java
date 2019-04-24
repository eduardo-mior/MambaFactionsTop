package br.com.kickpost.ftop;

import java.util.Collection;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.factions.FactionsManager;

public class FTop {
	
	private FTop() {}
	private static FTop i = new FTop();
	public static FTop get() { return i; }
	
	public int getTopPosition(Faction faction) {
		try {
			return FactionsManager.POS_BY_FACTION.get(faction);
		} catch (Throwable e) {
			return -1;
		}
	}
	
	public Collection<Faction> getTopFactions() {
		return FactionsManager.POS_BY_FACTION.keySet();
	}
	
	public boolean isLoaded() {
		return FactionsManager.ENABLED;
	}
	
}