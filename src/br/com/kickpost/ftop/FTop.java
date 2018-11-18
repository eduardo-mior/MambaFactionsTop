package br.com.kickpost.ftop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.kickpost.ftop.configuration.ConfigurationLoader;
import br.com.kickpost.ftop.factions.FactionsLoader;
import br.com.kickpost.ftop.hooks.VaultHook;
import br.com.kickpost.ftop.inventory.utils.Heads;
import br.com.kickpost.ftop.listeners.onClickInventory;
import br.com.kickpost.ftop.listeners.onPlayerCommand;

public class FTop extends JavaPlugin {

	public static VaultHook Vault;

	public void onEnable() {
		loadConfiguration();
		registerListeners();
		loadFactions();
		loadHeads();
		loadHook();
	}

	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new onPlayerCommand(), this);
		pm.registerEvents(new onClickInventory(), this);
	}

	private void loadFactions() {
		FactionsLoader.loadAllFactions();
	}

	private void loadHook() {
		Vault = new VaultHook();
	}
	
	private void loadHeads() {
		new Heads();
	}
	
	private void loadConfiguration() {
		saveDefaultConfig();
		ConfigurationLoader.load();
	}

	public static FTop getPlugin() {
		return FTop.getPlugin(FTop.class);
	}
}
