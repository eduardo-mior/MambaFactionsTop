package br.com.kickpost.ftop.events;

import java.util.List;
import java.util.Map.Entry;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import com.massivecraft.factions.entity.Faction;

public class FactionsTopGeneralUpdateEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
    
    private List<Entry<Faction, Double[]>> topFactions;

    public FactionsTopGeneralUpdateEvent(List<Entry<Faction, Double[]>> topFactions) {
        this.topFactions = topFactions;
    }

    public List<Entry<Faction, Double[]>> getTopFactions() {
    	return topFactions;
    }
    
}