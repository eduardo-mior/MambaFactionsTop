package br.com.kickpost.ftop.inventory.utils;

import java.lang.reflect.Field;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class Heads {

	public static ItemStack VERDE_COINS;
	public static ItemStack VERDE_POWER;
	public static ItemStack VERDE_GERADORES;;

	public static ItemStack CINZA_COINS;
	public static ItemStack CINZA_POWER;
	public static ItemStack CINZA_GERADORES;


	public Heads() 
	{
		ItemStack VERDE = getSkull("http://textures.minecraft.net/texture/361e5b333c2a3868bb6a58b6674a2639323815738e77e053977419af3f77");
		ItemStack CINZA = getSkull("http://textures.minecraft.net/texture/f2f085c6b3cb228e5ba81df562c4786762f3c257127e9725c77b7fd301d37");
		
		VERDE_COINS = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Coins").setLore("§7Clique para ordenar de acordo", "§7com os Coins de cada Facção.").toItemStack();
		VERDE_POWER = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Poder").setLore("§7Clique para ordenar de acordo", "§7com o Poder de cada Facção.").toItemStack();
		VERDE_GERADORES = new ItemBuilder(VERDE.clone()).setName("§eOrdenar por Geradores").setLore("§7Clique para ordenar de acordo", "§7com o número de Geradores de cada Facção.").toItemStack();
		
		CINZA_COINS = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Coins").setLore("§7Clique para ordenar de acordo", "§7com os Coins de cada Facção.").toItemStack();
		CINZA_POWER = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Poder").setLore("§7Clique para ordenar de acordo", "§7com o Poder de cada Facção.").toItemStack();
		CINZA_GERADORES = new ItemBuilder(CINZA.clone()).setName("§eOrdenar por Geradores").setLore("§7Clique para ordenar de acordo", "§7com o número de Geradores de cada Facção.").toItemStack();
	}

	private static ItemStack getSkull(String url) 
	{
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		GameProfile profile = new GameProfile(UUID.randomUUID(), null);
		byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
		profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
		try {
			Field profileField = skullMeta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(skullMeta, profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		skull.setItemMeta(skullMeta);
		return skull;
	}
}
