package br.com.kickpost.ftop.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.kickpost.ftop.inventory.InventoryLoader;
import br.com.kickpost.ftop.inventory.utils.Type;

public class onClickInventory implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onClick(InventoryClickEvent e) {
		if (e.getSlotType() == SlotType.OUTSIDE || e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
			return;

		Inventory inv = e.getInventory();
		if (inv.getTitle().startsWith("Ranking Geral - ")) {
			e.setCancelled(true);
			e.setResult(Result.DENY);

			ItemStack item = e.getCurrentItem();
			if (item.getType().equals(Material.SKULL_ITEM)) {

				String itemName = item.getItemMeta().getDisplayName().toLowerCase();
				Player p = (Player) e.getWhoClicked();

				if (itemName.contains("poder"))
					new InventoryLoader(p, Type.POWER);
				if (itemName.contains("coins"))
					new InventoryLoader(p, Type.COINS);
				if (itemName.contains("geradores"))
					new InventoryLoader(p, Type.SPAWNERS);
			}
		}
	}
}
