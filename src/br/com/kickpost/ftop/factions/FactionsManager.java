package br.com.kickpost.ftop.factions;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

import org.bukkit.entity.EntityType;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.hooks.VaultHook;
import br.com.kickpost.ftop.inventory.utils.EntityName;

public class FactionsManager {

	public static HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Integer> POWER_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Double> COINS_BY_FACTION = new HashMap<>();
	public static LinkedHashMap<Faction, Integer> POS_BY_FACTION = new LinkedHashMap<>();
	public static Boolean ENABLED = Boolean.FALSE;
	
	public static final DecimalFormatSymbols DFS = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static final DecimalFormat FORMATTER = new DecimalFormat("###,###,###", DFS);

	public static ArrayList<String> geradoresToString(Faction faction, Double coins) {
		ArrayList<String> geradoresString = new ArrayList<>();
		
		geradoresString.add("§fTotal de coins dos " + getSpawnersTotal(faction) + " geradores: §7" + FORMATTER.format(coins));
		
		if (getSpawnersTotal(faction) == 0)
			return geradoresString;
		
		geradoresString.add("");
		
		for (Entry<EntityType, Integer> s : SPAWNERS_BY_FACTION.get(faction).entrySet()) {
			geradoresString.add("§f    " + getEntityName(s.getKey()) + ": §7" + s.getValue());
		}
		
		geradoresString.add("");

		return geradoresString;
	}

	public static ArrayList<String> coinsToString(Faction faction, Double coins) {
		ArrayList<String> coinsString = new ArrayList<>();
		
		coinsString.add("§fCoins: §7" + FORMATTER.format(coins));
		coinsString.add("");
		
		faction.getMPlayers().forEach(p -> coinsString.add("§f" + p.getName() + ": §7" + FORMATTER.format(VaultHook.getSaldo(p))));
		return coinsString;
	}

	public static ArrayList<String> powerToString(Faction faction, Integer power) {
		ArrayList<String> powerString = new ArrayList<>();
		
		powerString.add("§fPoder: §7" + power + "/" + faction.getPowerMaxRounded());
		powerString.add("");
		
		faction.getMPlayers().forEach(p -> powerString.add("§f" + p.getName() + ": §7" + p.getPowerRounded() + "/" + p.getPowerMaxRounded()));
		
		return powerString;
	}
	
	public static ArrayList<String> valueToString(Double[] value) {
		ArrayList<String> valueString = new ArrayList<>();
		
		valueString.add("§fValor da Facção: §6" + FORMATTER.format(value[0] + value[1]));
		valueString.add("");
		valueString.add("§fTotal em Coins: §7" + FORMATTER.format(value[0]));
		valueString.add("§fTotal em Geradores: §7" + FORMATTER.format(value[1]));
		
		return valueString;
	}

	private static int getSpawnersTotal(Faction faction) {
		return SPAWNERS_BY_FACTION.containsKey(faction) ? SPAWNERS_BY_FACTION.get(faction).values().stream().mapToInt(Integer::intValue).sum() : 0;
	}

	@SuppressWarnings("deprecation")
	private static String getEntityName(EntityType tipo) {
		try {
			return EntityName.valueOf(tipo).getName();
		} catch (Throwable e) {
			return tipo.getName().replace("_", "");
		}
	}

}