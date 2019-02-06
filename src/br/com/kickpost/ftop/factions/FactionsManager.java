package br.com.kickpost.ftop.factions;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import org.bukkit.entity.EntityType;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.FTop;
import br.com.kickpost.ftop.inventory.utils.EntityName;

public class FactionsManager {

	public static HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Integer> POWER_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Double> COINS_BY_FACTION = new HashMap<>();
	
	public static final DecimalFormatSymbols DFS = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static final DecimalFormat FORMATTER = new DecimalFormat("###,###,###", DFS);

	private Faction faction;
	private Double coins;
	private Integer power;
	private Double[] value;
	
	public FactionsManager(Faction faction, Double coins) {
		this.faction = faction;
		this.coins = coins;
	}
	
	public FactionsManager(Faction faction, Integer power) {
		this.faction = faction;
		this.power = power;
	}
	
	public FactionsManager(Faction faction, HashMap<EntityType, Integer> spawners) {
		this.faction = faction;
	}
	
	public FactionsManager(Faction faction, Double[] value) {
		this.faction = faction;
		this.value = value;
	}

	public int getSpawnersTotal() {
		return SPAWNERS_BY_FACTION.containsKey(faction) ? SPAWNERS_BY_FACTION.get(faction).values().stream().mapToInt(Integer::intValue).sum() : 0;
	}

	public ArrayList<String> geradoresToString() {
		ArrayList<String> geradoresString = new ArrayList<>();
		
		geradoresString.add("§fTotal de coins dos " + getSpawnersTotal() + " geradores: §7"	+ FORMATTER.format(coins));
		
		if (getSpawnersTotal() == 0)
			return geradoresString;
		
		geradoresString.add("");
		
		for (Entry<EntityType, Integer> s : SPAWNERS_BY_FACTION.get(faction).entrySet()) {
			geradoresString.add("§f    " + getEntityName(s.getKey()) + ": §7" + s.getValue());
		}
		
		geradoresString.add("");

		return geradoresString;
	}

	public ArrayList<String> coinsToString() {
		ArrayList<String> coinsString = new ArrayList<>();
		
		coinsString.add("§fCoins: §7" + FORMATTER.format(coins));
		coinsString.add("");
		
		faction.getMPlayers().forEach(p -> coinsString.add("§f" + p.getName() + ": §7" + FORMATTER.format(FTop.vault.getSaldo(p))));
		return coinsString;
	}

	public ArrayList<String> powerToString() {
		ArrayList<String> powerString = new ArrayList<>();
		
		powerString.add("§fPoder: §7" + power + "/" + faction.getPowerMaxRounded());
		powerString.add("");
		
		faction.getMPlayers().forEach(p -> powerString.add("§f" + p.getName() + ": §7" + p.getPowerRounded() + "/" + p.getPowerMaxRounded()));
		
		return powerString;
	}
	
	public ArrayList<String> valueToString() {
		ArrayList<String> valueString = new ArrayList<>();
		
		valueString.add("§fValor da Facção: §6" + FORMATTER.format(value[0] + value[1]));
		valueString.add("");
		valueString.add("§fTotal em Coins: §7" + FORMATTER.format(value[0]));
		valueString.add("§fTotal em Geradores: §7" + FORMATTER.format(value[1]));
		
		return valueString;
	}

	@SuppressWarnings("deprecation")
	private String getEntityName(EntityType tipo) {
		try {
			return EntityName.valueOf(tipo).getName();
		} catch (Throwable e) {
			return tipo.getName().replace("_", "");
		}
	}

}