package br.com.kickpost.ftop.inventory.utils;

public enum Type {

	COINS("Coins"), SPAWNERS("Geradores"), POWER("Poder");

	private String name;

	private Type(String name) {
		this.name = name;
	}

	public String getNome() {
		return name;
	}
}