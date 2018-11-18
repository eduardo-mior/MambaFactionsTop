package br.com.kickpost.ftop.factions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.configuration.ConfigurationLoader;
import br.com.kickpost.ftop.inventory.utils.Banner;
import br.com.kickpost.ftop.inventory.utils.ItemBuilder;

public class FactionsUtils {

	public static ItemStack getFactionBanner(Faction faction, List<String> lore, int pos) {
		ItemStack bandeira = new ItemBuilder(Banner.get(faction.getName().toLowerCase())).addItemFlag(ItemFlag.HIDE_POTION_EFFECTS).toItemStack();
		ItemMeta bandeiraMeta = bandeira.getItemMeta();
		bandeiraMeta.setDisplayName("§f" + pos + "º.§8 " + faction.getName());
		bandeiraMeta.setLore(lore);
		bandeira.setItemMeta(bandeiraMeta);
		return bandeira;
	}

	public static Map<Faction, Double> organizeMapCoins(Map<Faction, Double> unsortMap) {
		List<Entry<Faction, Double>> list = new LinkedList<Entry<Faction, Double>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<Faction, Double>>() {
			public int compare(Entry<Faction, Double> o1, Entry<Faction, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<Faction, Double> sortedMap = new LinkedHashMap<>();
		Integer v = 1;
		for (Entry<Faction, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
			if (v == 21) break;
			v++;
		}
		return sortedMap;
	}
	
	public static Map<Faction, Integer> organizeMapPower(Map<Faction, Integer> unsortMap) {
		List<Entry<Faction, Integer>> list = new LinkedList<Entry<Faction, Integer>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<Faction, Integer>>() {
			public int compare(Entry<Faction, Integer> o1, Entry<Faction, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<Faction, Integer> sortedMap = new LinkedHashMap<>();
		Integer v = 1;
		for (Entry<Faction, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
			if (v == 21) break;
			v++;
		}
		return sortedMap;
	}
	
	public static Map<Faction, Double> organizeMapCreature(HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION) {
		Map<Faction, Double> valueMap = new HashMap<>();
		
		for (Entry<Faction, HashMap<EntityType, Integer>> s : SPAWNERS_BY_FACTION.entrySet()) {
			valueMap.put(s.getKey(), getMobSpawnersValor(s.getValue()));
		}
		
		return organizeMapCoins(valueMap);
	}
	
	@SuppressWarnings("deprecation")
	public static double getMobSpawnersValor(HashMap<EntityType, Integer> map) {
		double valor = 0D;
		for (Entry<EntityType, Integer> s : map.entrySet()) {
			try {
				valor += ConfigurationLoader.ENTITY_BY_PRICE.get(s.getKey().getName().toUpperCase()) * s.getValue();
			} catch (Exception e) {
				continue;
			}
		}
		return valor;
	}
}
