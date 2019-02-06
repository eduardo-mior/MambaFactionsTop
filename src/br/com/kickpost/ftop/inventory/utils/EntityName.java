package br.com.kickpost.ftop.inventory.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum EntityName {

	AREA_EFFECT_CLOUD("Area de Efeito Poção"),
	ARMOR_STAND("Suporte de Armaduras"),
	ARROW("Flecha"),
	BAT("Morcego"),
	BLAZE("Blaze"),
	BOAT("Barco"),
	CAVE_SPIDER("Aranha da Caverna"),
	CHICKEN("Galinha"),
	COD("Bacalhau"),
	COMPLEX_PART("Desconhecido"),
	COW("Vaca"),
	CREEPER("Creeper"),
	DOLPHIN("Golfinho"),
	DONKEY("Burro"),
	DRAGON_FIREBALL("Bola de Fogo"),
	DROPPED_ITEM("Item dropado"),
	DROWNED("Afogado"),
	EGG("Ovo"),
	ELDER_GUARDIAN("Guardião Mestre"),
	ENDER_CRYSTAL("Cristal do End"),
	ENDER_DRAGON("Dragão do Fim"),
	ENDER_PEARL("Pérola do Fim"),
	ENDER_SIGNAL("Olho do Fim"),
	ENDERMAN("Enderman"),
	ENDERMITE("Endermite"),
	EVOKER("Invocador"),
	EVOKER_FANGS("Desconhecido"),
	EXPERIENCE_ORB("Orb de Xp"),
	FALLING_BLOCK("Bloco Caindo"),
	FIREBALL("Bola de Fogo"),
	FIREWORK("Fogos de Artificio"),
	FISHING_HOOK("Vara de Pesca"),
	GHAST("Ghast"),
	GIANT("Zumbi Gigante"),
	GUARDIAN("Guardião"),
	HORSE("Cavalo"),
	HUSK("Zumbi do Deserto"),
	ILLUSIONER("Ilusionista"),
	IRON_GOLEM("Golem de Ferro"),
	ITEM_FRAME("Moldura"),
	LEASH_HITCH("Desconhecido"),
	LIGHTNING("Raio"),
	LINGERING_POTION("Poção"),
	LLAMA("Lhama"),
	LLAMA_SPIT("Desconhecido"),
	MAGMA_CUBE("Cubo de Magma"),
	MINECART("Carrinho"),
	MINECART_CHEST("Carrinho com Baú"),
	MINECART_COMMAND("Carrinho com Bloco de Comando"),
	MINECART_FURNACE("Carrinho com Fornalha"),
	MINECART_HOPPER("Carrinho com Funil"),
	MINECART_MOB_SPAWNER("Carrinho com Mob Spawner"),
	MINECART_TNT("Carrinho con TNT"),
	MULE("Mula"),
	MUSHROOM_COW("Vaca de Cogumelo"),
	OCELOT("Jaguatirica"),
	PAINTING("Pintura"),
	PARROT("Papagaio"),
	PHANTOM("Phantom"),
	PIG("Porco"),
	PIG_ZOMBIE("Porco Zumbi"),
	PLAYER("Player"),
	POLAR_BEAR("Urso Polar"),
	PRIMED_TNT("TNT"),
	PUFFERFISH("Baiacu"),
	RABBIT("Coelho"),
	SALMON("Salmão"),
	SHEEP("Ovelha"),
	SHULKER("Shulker"),
	SHULKER_BULLET("Desconhecido"),
	SILVERFISH("Silverfish"),
	SKELETON("Esqueleto"),
	SKELETON_HORSE("Cavalo Esqueleto"),
	SLIME("Slime"),
	SMALL_FIREBALL("Bola de fogo pequena"),
	SNOWBALL("Bola de Neve"),
	SNOWMAN("Golem de Neve"),
	SPECTRAL_ARROW("Flecha Spectral"),
	SPIDER("Aranha"),
	SPLASH_POTION("Poção Arremessável"),
	SQUID("Lula"),
	STRAY("Esqueleto Vagante"),
	THROWN_EXP_BOTTLE("Frasco de Xp"),
	TIPPED_ARROW("Flecha"),
	TRIDENT("Tridente"),
	TROPICAL_FISH("Peixe Tropical"),	 
	TURTLE("Tartaruga"),
	UNKNOWN("Desconhecido"),
	VEX("Fantasma"),
	VILLAGER("Vilager"),
	VINDICATOR("Vingador"),
	WEATHER("Desconhecido"),
	WITCH("Bruxa"),
	WITHER("Whiter"),
	WITHER_SKELETON("Esqueleto Whiter"),
	WITHER_SKULL("Desconhecido"),
	WOLF("Lobo"),
	ZOMBIE("Zumbi"),
	ZOMBIE_HORSE("Cavalo Zumbi"),
	ZOMBIE_VILLAGER("Vilager Zumbi");

	private String name;
	
	EntityName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static EntityName valueOf(Entity entity) {
		return EntityName.valueOf(entity.getType());
	}
	
	public static EntityName valueOf(EntityType entityType) {
		return EntityName.valueOf(entityType.name());
	}
	
}