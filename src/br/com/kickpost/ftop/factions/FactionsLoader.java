package br.com.kickpost.ftop.factions;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.massivecore.ps.PS;

import br.com.kickpost.ftop.FTop;
import br.com.kickpost.ftop.inventory.InventoryLoader;
import br.com.kickpost.ftopnpc.manager.FortuneManager;

public class FactionsLoader {

	private static final String WARZONE = Factions.ID_WARZONE;
	private static final String SAFEZONE = Factions.ID_SAFEZONE;
	private static final String NONE = Factions.ID_NONE;
	
	public static void loadAllFactions() {
		
		InventoryLoader.updateMenu();
		
		new BukkitRunnable() 
		{
			public void run() 
			{
				FactionsManager.POWER_BY_FACTION.clear();
				FactionsManager.COINS_BY_FACTION.clear();
				for (Faction faction : FactionColl.get().getAll()) 
				{
					String factionId = faction.getId();
					if (factionId.equals(NONE) || factionId.equals(WARZONE) || factionId.equals(SAFEZONE)) continue;
					FactionsManager.POWER_BY_FACTION.put(faction, getFactionPower(faction));
					FactionsManager.COINS_BY_FACTION.put(faction, getFactionCoins(faction));
				}
				InventoryLoader.updatePower();
				InventoryLoader.updateCoins();
			}
		}.runTaskTimerAsynchronously(FTop.getPlugin(), 0, 15 * 60 * 20L);
		
		new BukkitRunnable() 
		{
			public void run() 
			{
				FactionsManager.SPAWNERS_BY_FACTION.clear();
				for (Faction faction : FactionColl.get().getAll()) 
				{
					String factionId = faction.getId();
					if (factionId.equals(NONE) || factionId.equals(WARZONE) || factionId.equals(SAFEZONE)) continue;
					FactionsManager.SPAWNERS_BY_FACTION.put(faction, getMobSpawners(faction));
				}
				InventoryLoader.updateCreatures();
			}
		}.runTaskTimer(FTop.getPlugin(), 0, 15 * 60 * 20L);
		
		new BukkitRunnable() 
		{
			public void run() 
			{
				if (InventoryLoader.updateIsAvailable()) {
					InventoryLoader.updateGeneral();
				}
			}
		}.runTaskTimerAsynchronously(FTop.getPlugin(), 0, 1 * 60 * 20L);
		
		if (Bukkit.getPluginManager().isPluginEnabled("FTopNPCs")) {
			System.out.println("[FTop] Carregando...");
			new FortuneManager();
		}
	}

	public static int getFactionPower(Faction fac) {
		return fac.getPowerRounded();
	}

	public static double getFactionCoins(Faction fac) {
		return fac.getMPlayers().stream().mapToDouble(r -> FTop.vault.getSaldo(r)).sum();
	}

	public static HashMap<EntityType, Integer> getMobSpawners(Faction fac) {

		HashMap<EntityType, Integer> spawners = new HashMap<>();
		
		for (PS ps : BoardColl.get().getChunks(fac)) {
			for (BlockState block : ps.asBukkitChunk().getTileEntities()) {
				if (block.getType() == Material.MOB_SPAWNER) {
					
					CreatureSpawner spawner = (CreatureSpawner) block;
					EntityType spawnedType = spawner.getSpawnedType();
					
					if (spawners.containsKey(spawnedType))
						spawners.replace(spawnedType, spawners.get(spawnedType) + 1);
					else
						spawners.put(spawnedType, 1);
				}
			}
		}
		return spawners;
	}
	
}