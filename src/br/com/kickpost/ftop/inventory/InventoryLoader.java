package br.com.kickpost.ftop.inventory;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.Main;
import br.com.kickpost.ftop.factions.FactionsManager;
import br.com.kickpost.ftop.factions.FactionsUtils;
import br.com.kickpost.ftop.inventory.utils.GuiHolder;
import br.com.kickpost.ftop.inventory.utils.Heads;
import br.com.kickpost.ftop.inventory.utils.Type;

public class InventoryLoader {

	private static Inventory COINS;
	private static Inventory POWER;
	private static Inventory SPAWNERS;
	private static Inventory GENERAL;
	private static Inventory MENU;
	
	private static boolean coinsUpdated = false;
	private static boolean spawnerUpdated = false;
	
	public static void open(Player p, Type type) {
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
				
			case GENERAL:
				if (GENERAL == null) p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
				else p.openInventory(GENERAL);
				break;
				
			case MENU:
				if (MENU == null) p.sendMessage("§cO Ranking esta sendo atualizado aguarde...");
				else p.openInventory(MENU);
				break;
				
			default:
				throw new NoSuchMethodError("Tipo de inventario invalido!");		
		}
	}
	
	public static void updatePower() {
		Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
			@Override
			public void run() {
				POWER = Bukkit.createInventory(new GuiHolder(Type.POWER), 54, "Ranking Geral - Poder");
				POWER.setItem(47, Heads.ARROW);
				POWER.setItem(48, Heads.CINZA_COINS);
				POWER.setItem(49, Heads.CINZA_GERADORES);
				POWER.setItem(50, Heads.VERDE_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Integer> entry : FactionsUtils.organizeMapPower(FactionsManager.POWER_BY_FACTION)) {
					POWER.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.powerToString(entry.getKey(), entry.getValue()), pos++));
					if (pos == 22) break;
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
				}
			}
		});
	}
	
	public static void updateCoins() {
		Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
			@Override
			public void run() {
				COINS = Bukkit.createInventory(new GuiHolder(Type.COINS), 54, "Ranking Geral - Coins");
				COINS.setItem(47, Heads.ARROW);
				COINS.setItem(48, Heads.VERDE_COINS);
				COINS.setItem(49, Heads.CINZA_GERADORES);
				COINS.setItem(50, Heads.CINZA_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Double> entry : FactionsUtils.organizeMapCoins(FactionsManager.COINS_BY_FACTION)) {
					COINS.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.coinsToString(entry.getKey(), entry.getValue()), pos++));
					if (pos == 22) break;
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
				}
				coinsUpdated = true;
				if (updateIsAvailable()) {
					updateGeneral();
				}
			}
		});
	}
	
	public static void updateCreatures() {
		Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
			@Override
			public void run() {
				SPAWNERS = Bukkit.createInventory(new GuiHolder(Type.SPAWNERS), 54, "Ranking Geral - Geradores");
				SPAWNERS.setItem(47, Heads.ARROW);
				SPAWNERS.setItem(48, Heads.CINZA_COINS);
				SPAWNERS.setItem(49, Heads.VERDE_GERADORES);
				SPAWNERS.setItem(50, Heads.CINZA_POWER);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Double> entry : FactionsUtils.organizeMapCreature(FactionsManager.SPAWNERS_BY_FACTION)) {
					SPAWNERS.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.geradoresToString(entry.getKey(), entry.getValue()), pos++));
					if (pos == 22) break;
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
				}
				spawnerUpdated = true;
				if (updateIsAvailable()) {
					updateGeneral();
				}
			}
		});
	}
	
	public static void updateGeneral() {
		Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
			@Override
			public void run() {
				List<Entry<Faction, Double[]>> facs = FactionsUtils.organizeMapGeneral(FactionsManager.SPAWNERS_BY_FACTION, FactionsManager.COINS_BY_FACTION);
				GENERAL = Bukkit.createInventory(new GuiHolder(Type.GENERAL), 54, "Ranking Geral - Valor");
				GENERAL.setItem(49, Heads.ARROW);
				int slot = 10;
				int pos = 1;
				for (Entry<Faction, Double[]> entry : facs) {
					GENERAL.setItem(slot, FactionsUtils.getFactionBanner(entry.getKey(), FactionsManager.valueToString(entry.getValue()), pos++));
					if (pos == 22) break;
					slot += slot == 16 || slot == 25 ? + 3 : + 1;
				}
				pos = 1;
				for (Entry<Faction, Double[]> entry : facs) {
					FactionsManager.POS_BY_FACTION.put(entry.getKey(), pos++);
				}
				FactionsManager.ENABLED = Boolean.TRUE;
				spawnerUpdated = false;
				coinsUpdated = false;
			}
		});
	}
	
	public static void updateMenu() {
		Bukkit.getScheduler().runTaskAsynchronously(Main.get(), new Runnable() {
			@Override
			public void run() {
				MENU = Bukkit.createInventory(new GuiHolder(Type.MENU), 27, "Escolha uma categoria:");
				ItemStack netherStar = new ItemStack(Material.NETHER_STAR);
				ItemStack blockGrass = new ItemStack(Material.GRASS);
				
				ItemMeta netherMeta = netherStar.getItemMeta();
				ItemMeta blockMeta = blockGrass.getItemMeta();
				
				netherMeta.setLore(Arrays.asList("§7Veja as facções com", "§7mais valor no servidor."));
				blockMeta.setLore(Arrays.asList("§7Veja as facções com mais desempenho", "§7no servidor em diversas categorias."));
				
				netherMeta.setDisplayName("§aRanking de Valor");
				blockMeta.setDisplayName("§aRanking Geral");
				
				netherStar.setItemMeta(netherMeta);
				blockGrass.setItemMeta(blockMeta);
				
				MENU.setItem(12, netherStar);
				MENU.setItem(14, blockGrass);
			}
		});
	}
	
	public static boolean updateIsAvailable() {
		return coinsUpdated && spawnerUpdated;
	}
	
}