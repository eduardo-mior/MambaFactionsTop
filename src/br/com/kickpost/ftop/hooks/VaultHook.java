package br.com.kickpost.ftop.hooks;

import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.money.MoneyMixinVault;

import net.milkbowl.vault.economy.Economy;

public class VaultHook {

	private static Economy ECONOMY;

	@SuppressWarnings("deprecation")
	public double getSaldo(MPlayer mp) {
		try {
			return ECONOMY.getBalance(mp.getName());
		} catch (Throwable e) {
			return 0;
		}
	}

	public VaultHook() {
		ECONOMY = MoneyMixinVault.get().getEconomy();
	}

}