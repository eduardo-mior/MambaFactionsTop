package br.com.kickpost.ftop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import br.com.kickpost.ftop.inventory.InventoryLoader;
import br.com.kickpost.ftop.inventory.utils.GuiHolder;
import br.com.kickpost.ftop.inventory.utils.Type;

public class onClickInventory implements Listener {

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void aoClickar(InventoryClickEvent e) {
		if (e.getCurrentItem() == null || e.getInventory().getType() != InventoryType.CHEST)
			return;
		
		Inventory inv = e.getInventory();
		if (inv.getHolder() instanceof GuiHolder) {
			
			e.setCancelled(true);
			e.setResult(Result.DENY);

			Player p = (Player) e.getWhoClicked();
			int slot = e.getRawSlot();
			Type type = ((GuiHolder)inv.getHolder()).getType();

			if (inv.getSize() < slot) return;
			
			if (type == Type.MENU) {
				if (slot == 12) 
					new InventoryLoader(p, Type.GENERAL);
				if (slot == 14)
					new InventoryLoader(p, Type.COINS);
			}
			
			if (type == Type.GENERAL) {
				if (slot == 49) 
					new InventoryLoader(p, Type.MENU);
			}
			
			else {
				if (slot == 47)
					new InventoryLoader(p, Type.MENU);
				if (slot == 48)
					new InventoryLoader(p, Type.COINS);
				if (slot == 49)
					new InventoryLoader(p, Type.SPAWNERS);
				if (slot == 50)
					new InventoryLoader(p, Type.POWER);
			}
			
		}
	}
}
