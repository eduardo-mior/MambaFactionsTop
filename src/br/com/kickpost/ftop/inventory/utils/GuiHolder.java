package br.com.kickpost.ftop.inventory.utils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GuiHolder implements InventoryHolder {

	private Type type;
	
	public GuiHolder(Type type) {
		this.type = type;
	}

	public Inventory getInventory() {
		return null;
	}

	public Type getType() {
		return type;
	}
	
}