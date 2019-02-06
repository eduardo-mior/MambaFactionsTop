package br.com.kickpost.ftop.inventory.utils;

public enum Type {

	COINS("Coins"), SPAWNERS("Geradores"), POWER("Poder"), GENERAL("Valor"), MENU("null");

	private String name;

	private Type(String name) {
		this.name = name;
	}

	public String getNome() {
		return name;
	}
}