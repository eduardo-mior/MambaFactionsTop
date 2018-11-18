package br.com.kickpost.ftop.inventory.utils;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class Banner {

	public static ItemStack get(String string) {
		string = ChatColor.stripColor(string.toUpperCase()).substring(0, 1);

		ItemStack banner = new ItemStack(Material.BANNER);
		BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
		bannerMeta.setBaseColor(DyeColor.WHITE);
		switch (string) {
		case "A":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "B":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "C":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "D":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "E":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "F":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "G":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "H":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "I":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "J":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "K":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL_MIRROR));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "L":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "M":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "N":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT_MIRROR));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNRIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "O":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "P":
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "Q":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_RIGHT));
			break;
		case "R":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNRIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "S":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNRIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
			break;
		case "T":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "U":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "V":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "W":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "X":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_CENTER));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "Y":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.CROSS));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_VERTICAL_MIRROR));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "Z":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "1":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_TOP_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_CENTER));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "2":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.RHOMBUS_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "3":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "4":
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "5":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNRIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "6":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "7":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.DIAGONAL_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.SQUARE_BOTTOM_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "8":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "9":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		case "0":
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_RIGHT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_LEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.BLACK, PatternType.STRIPE_DOWNLEFT));
			bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.BORDER));
			break;
		}
		banner.setItemMeta(bannerMeta);
		return banner;
	}

}