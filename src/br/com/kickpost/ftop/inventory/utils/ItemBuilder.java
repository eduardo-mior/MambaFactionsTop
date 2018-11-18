package br.com.kickpost.ftop.inventory.utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack is;

	public ItemBuilder(Material m) {
		this(m, 1);
	}

	public ItemBuilder(ItemStack is) {
		this.is = is;
	}

	public ItemBuilder(Material m, int quantia) {
		is = new ItemStack(m, quantia);
	}
	
	public ItemBuilder setName(String nome) {
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(nome);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder addItemFlag(ItemFlag flag) {
		ItemMeta im = is.getItemMeta();
		im.addItemFlags(flag);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setLore(String... lore) {
		ItemMeta im = is.getItemMeta();
		im.setLore(Arrays.asList(lore));
		is.setItemMeta(im);
		return this;
	}

	public ItemStack toItemStack() {
		return is;
	}
}