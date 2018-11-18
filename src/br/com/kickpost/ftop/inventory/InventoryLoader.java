package br.com.kickpost.ftop.inventory;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.FTop;
import br.com.kickpost.ftop.factions.FactionsManager;
import br.com.kickpost.ftop.factions.FactionsUtils;
import br.com.kickpost.ftop.inventory.utils.Heads;
import br.com.kickpost.ftop.inventory.utils.Type;

public class InventoryLoader {

	private static Inventory COINS;
	private static Inventory POWER;
	private static Inventory SPAWNERS;
	
	public InventoryLoader(Player p, Type type) {
		switch (type) 
		{
			case COINS:
				if (COINS == null) p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
				else p.openInventory(COINS);
				break;
				
			case POWER:
				if (POWER == null) p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
				else p.openInventory(POWER);
				break;
				
			case SPAWNERS:
				if (SPAWNERS == null) p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
				else p.openInventory(SPAWNERS);
				break;
				
			default:
				throw new NoSuchMethodError("Tipo de inventario invalido!");		
		}
	}
	
	public static void updateCoins() {
		Bukkit.getScheduler().runTaskAsynchronously(FTop.getPlugin(), new Runnable() {
			@Override
			public void run() {
				COINS = Bukkit.createInventory(null, 54, "Ranking Geral - Coins");
				COINS.setItem(48, Heads.VERDE_COINS);
				COINS.setItem(49, Heads.CINZA_GERADORES);
				COINS.setItem(50, Heads.CINZA_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Double> s : FactionsUtils.organizeMapCoins(FactionsManager.COINS_BY_FACTION).entrySet()) {
					COINS.setItem(slot, FactionsUtils.getFactionBanner(s.getKey(), new FactionsManager(s.getKey(), s.getValue()).coinsToString(), pos));
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
					pos++;
				}
			}
		});
	}
	
	public static void updatePower() {
		Bukkit.getScheduler().runTaskAsynchronously(FTop.getPlugin(), new Runnable() {
			@Override
			public void run() {
				POWER = Bukkit.createInventory(null, 54, "Ranking Geral - Poder");
				POWER.setItem(48, Heads.CINZA_COINS);
				POWER.setItem(49, Heads.CINZA_GERADORES);
				POWER.setItem(50, Heads.VERDE_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Integer> s : FactionsUtils.organizeMapPower(FactionsManager.POWER_BY_FACTION).entrySet()) {
					POWER.setItem(slot, FactionsUtils.getFactionBanner(s.getKey(), new FactionsManager(s.getKey(), s.getValue()).powerToString(), pos));
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
					pos++;
				}
			}
		});
	}
	
	public static void updateCreatures() {
		Bukkit.getScheduler().runTaskAsynchronously(FTop.getPlugin(), new Runnable() {
			@Override
			public void run() {
				SPAWNERS = Bukkit.createInventory(null, 54, "Ranking Geral - Geradores");
				SPAWNERS.setItem(48, Heads.CINZA_COINS);
				SPAWNERS.setItem(49, Heads.VERDE_GERADORES);
				SPAWNERS.setItem(50, Heads.CINZA_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Double> s : FactionsUtils.organizeMapCreature(FactionsManager.SPAWNERS_BY_FACTION).entrySet()) {
					SPAWNERS.setItem(slot, FactionsUtils.getFactionBanner(s.getKey(), new FactionsManager(s.getKey(), s.getValue()).geradoresToString(), pos));
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
					pos++;
				}
			}
		});
	}
	
}