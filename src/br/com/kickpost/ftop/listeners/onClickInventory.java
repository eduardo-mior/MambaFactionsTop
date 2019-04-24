package br.com.kickpost.ftop.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import br.com.kickpost.ftop.inventory.InventoryLoader;
import br.com.kickpost.ftop.inventory.utils.GuiHolder;
import br.com.kickpost.ftop.inventory.utils.Type;

public class onClickInventory implements Listener {

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void aoClickar(InventoryClickEvent e) {
		
		if (e.getInventory().getHolder() instanceof GuiHolder) {
			
			e.setCancelled(true);
			e.setResult(Result.DENY);
			
    		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
    			return;


			Player p = (Player) e.getWhoClicked();
			int slot = e.getRawSlot();
			GuiHolder holder = (GuiHolder) e.getInventory().getHolder();
			Type type = holder.getType();
			
			if (e.getInventory().getSize() < slot) return;
			
			if (type == Type.MENU) {
				if (slot == 12) 
					InventoryLoader.open(p, Type.GENERAL);
				if (slot == 14)
					InventoryLoader.open(p, Type.COINS);
			}
			
			if (type == Type.GENERAL) {
				if (slot == 49) 
					InventoryLoader.open(p, Type.MENU);
			}
			
			else {
				if (slot == 47)
					InventoryLoader.open(p, Type.MENU);
				if (slot == 48)
					InventoryLoader.open(p, Type.COINS);
				if (slot == 49)
					InventoryLoader.open(p, Type.SPAWNERS);
				if (slot == 50)
					InventoryLoader.open(p, Type.POWER);
			}
			
		}
	}
}
