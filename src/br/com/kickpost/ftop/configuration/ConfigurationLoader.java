package br.com.kickpost.ftop.configuration;

import java.util.HashMap;

import br.com.kickpost.ftop.FTop;

public class ConfigurationLoader {

	public static final HashMap<String, Integer> ENTITY_BY_PRICE = new HashMap<>();

	public static void load() {
		for (String s : FTop.getPlugin().getConfig().getStringList("Spawners")) {
			String[] splitted = s.split(",");
			try {
				ENTITY_BY_PRICE.put(splitted[0].toUpperCase(), Integer.parseInt(splitted[1]));
			} catch (Throwable e) {
				System.out.println("[Ftop] Erro no arquivo de configuracao do plugin! Linha: " + s);
				continue;
			}
		}
	}
}
