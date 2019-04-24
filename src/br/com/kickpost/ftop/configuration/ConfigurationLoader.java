package br.com.kickpost.ftop.configuration;

import java.util.HashMap;

import br.com.kickpost.ftop.Main;
	
public class ConfigurationLoader {

	public static final HashMap<String, Double> ENTITY_BY_PRICE = new HashMap<>();

	public static void load() {
		ENTITY_BY_PRICE.clear();
		for (String s : Main.get().getConfig().getStringList("Spawners")) {
			String[] splitted = s.split(",");
			try {
				ENTITY_BY_PRICE.put(splitted[0].toUpperCase(), Double.parseDouble(splitted[1]));
			} catch (Throwable e) {
				System.out.println("[Ftop] Erro no arquivo de configuracao do plugin! Linha: " + s);
				continue;
			}
		}
	}
	
}