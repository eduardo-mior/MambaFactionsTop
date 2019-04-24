package br.com.kickpost.ftop.factions;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

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

import br.com.kickpost.ftop.Main;
import br.com.kickpost.ftop.hooks.VaultHook;
import br.com.kickpost.ftop.inventory.InventoryLoader;
import br.com.kickpost.ftopnpc.manager.FortuneManager;

public class FactionsLoader extends FactionsManager {

	private static HashMap<Faction, Set<PS>> CHUNKS_BY_FACTION  = new HashMap<>();
	private static final String WARZONE = Factions.ID_WARZONE;
	private static final String SAFEZONE = Factions.ID_SAFEZONE;
	private static final String NONE = Factions.ID_NONE;
	
	public static void loadAllFactions() {
		
		InventoryLoader.updateMenu();
		
		new BukkitRunnable() 
		{
			public void run() 
			{
				POWER_BY_FACTION.clear();
				COINS_BY_FACTION.clear();
				CHUNKS_BY_FACTION.clear();
				for (Faction faction : FactionColl.get().getAll()) 
				{
					String factionId = faction.getId();
					if (factionId.equals(NONE) || factionId.equals(WARZONE) || factionId.equals(SAFEZONE)) continue;
					POWER_BY_FACTION.put(faction, faction.getPowerRounded());
					COINS_BY_FACTION.put(faction, getFactionCoins(faction));
					CHUNKS_BY_FACTION.put(faction, getFactionChunks(faction));
				}
				InventoryLoader.updatePower();
				InventoryLoader.updateCoins();
				updateCreatures();
			}
		}.runTaskTimerAsynchronously(Main.get(), 0, 15 * 60 * 20L);
		
		if (Bukkit.getPluginManager().isPluginEnabled("FTopNPCs")) {
			System.out.println("[FTop] Carregando...");
			new FortuneManager();
		}
	}
	
	private static void updateCreatures() {
		new BukkitRunnable() 
		{
			public void run() 
			{
				SPAWNERS_BY_FACTION.clear();
				for (Entry<Faction, Set<PS>> entry : CHUNKS_BY_FACTION.entrySet()) 
				{
					SPAWNERS_BY_FACTION.put(entry.getKey(), getMobSpawners(entry.getKey(), entry.getValue()));
				}
				InventoryLoader.updateCreatures();
			}
		}.runTask(Main.get());
	}

	private static double getFactionCoins(Faction fac) {
		return fac.getMPlayers().stream().mapToDouble(r -> VaultHook.getSaldo(r)).sum();
	}
	
	private static Set<PS> getFactionChunks(Faction fac) {
		return BoardColl.get().getChunks(fac);
	}

	private static HashMap<EntityType, Integer> getMobSpawners(Faction fac, Set<PS> chunks) {
		HashMap<EntityType, Integer> spawners = new HashMap<>();
		for (PS chunk : chunks) {
			for (BlockState block : chunk.asBukkitChunk().getTileEntities()) {
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