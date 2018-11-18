package br.com.kickpost.ftop.hooks;

import com.massivecraft.massivecore.money.MoneyMixinVault;

import net.milkbowl.vault.economy.Economy;

public class VaultHook {

	private static Economy ECONOMY;

	@SuppressWarnings("deprecation")
	public double getSaldo(String p) {
		return ECONOMY.getBalance(p);
	}

	public VaultHook() {
		ECONOMY = MoneyMixinVault.get().getEconomy();
	}

}