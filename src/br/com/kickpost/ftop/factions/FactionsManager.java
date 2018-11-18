package br.com.kickpost.ftop.factions;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import org.bukkit.entity.EntityType;

import com.massivecraft.factions.entity.Faction;

import br.com.kickpost.ftop.FTop;

public class FactionsManager {

	public static HashMap<Faction, HashMap<EntityType, Integer>> SPAWNERS_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Integer> POWER_BY_FACTION = new HashMap<>();
	public static HashMap<Faction, Double> COINS_BY_FACTION = new HashMap<>();
	
	public static final DecimalFormatSymbols DFS = new DecimalFormatSymbols(new Locale("pt", "BR"));
	public static final DecimalFormat FORMATTER = new DecimalFormat("###,###,###", DFS);

	private Faction faction;
	private Double value;
	private Integer power;
	
	public FactionsManager(Faction faction, Double value) {
		this.faction = faction;
		this.value = value;
	}
	
	public FactionsManager(Faction faction, Integer power) {
		this.faction = faction;
		this.power = power;
	}
	
	public FactionsManager(Faction faction, HashMap<EntityType, Integer> spawners) {
		this.faction = faction;
	}

	public int getSpawnersTotal() {
		return SPAWNERS_BY_FACTION.containsKey(faction) ? SPAWNERS_BY_FACTION.get(faction).values().stream().mapToInt(Integer::intValue).sum() : 0;
	}

	public ArrayList<String> geradoresToString() {
		ArrayList<String> geradoresString = new ArrayList<>();
		
		geradoresString.add("§fTotal de coins dos " + getSpawnersTotal() + " geradores: §7"	+ FORMATTER.format(value));
		
		if (getSpawnersTotal() == 0)
			return geradoresString;
		
		geradoresString.add("");
		
		for (Entry<EntityType, Integer> s : SPAWNERS_BY_FACTION.get(faction).entrySet()) {
			geradoresString.add("§f    " + getEntityName(s.getKey()) + ": §7" + s.getValue());
		}
		
		geradoresString.add("");

		return geradoresString;
	}

	public ArrayList<String> coinsToString() {
		ArrayList<String> coinsString = new ArrayList<>();
		
		coinsString.add("§fCoins: §7" + FORMATTER.format(value));
		coinsString.add("");
		
		faction.getMPlayers().forEach(p -> coinsString.add("§f" + p.getName() + ": §7" + FORMATTER.format(FTop.Vault.getSaldo(p.getName()))));
		return coinsString;
	}

	public ArrayList<String> powerToString() {
		ArrayList<String> powerString = new ArrayList<>();
		
		powerString.add("§fPoder: §7" + power + "/" + faction.getPowerMaxRounded());
		powerString.add("");
		
		faction.getMPlayers().forEach(p -> powerString.add("§f" + p.getName() + ": §7" + p.getPowerRounded() + "/" + p.getPowerMaxRounded()));
		
		return powerString;
	}

	@SuppressWarnings("deprecation")
	private String getEntityName(EntityType tipo) {
		try {
			return EntityNames.valueOf(tipo.getName().toUpperCase()).getNome();
		} catch (Exception e) {
			return tipo.getName().replace("_", "");
		}
	}

}

enum EntityNames {

	LAVASLIME("Cubo de Magma"), BLAZE("Blaze"), CAVESPIDER("Aranha da Caverna"), 
	CHICKEN("Galinha"), COW("Vaca"), CREEPER("Creeper"), ENTITYHORSE("Cavalo"), 
	ENDERMITE("Endermite"), GHAST("Ghast"), GUARDIAN("Guardião"), PIG("Porco"),
	BAT("Morcego"),VILLAGERGOLEM("Golem de Ferro"), ENDERMAN("Enderman"),
	MUSHROOMCOW("Vaca de Cogumelo"), OZELOT("Jaguatirica"), HORSE("Cavalo"), 
	PIGZOMBIE("Porco Zumbi"), RABBIT("Coelho"), SHEEP("Ovelha"), SLIME("Slime"),
	SKELETON("Esqueleto"), SPIDER("Aranha"), WITCH("Bruxa"), WITHERBOSS("Wither"),
	ZOMBIE("Zumbi"), SNOWMAN("Golem de Neve"), SQUID("Lula"), WOLF("Lobo");

	private String nome;

	private EntityNames(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
