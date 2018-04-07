package fr.alexfatta.kitpvp.kitManager.listWeapons;

import org.bukkit.Material;

public class ListOfWeapons {
	
	private static Material[] weaponsList = {
		Material.WOOD_AXE,
		Material.WOOD_HOE,
		Material.WOOD_PICKAXE,
		Material.WOOD_SWORD,
		
		Material.STONE_AXE,
		Material.STONE_HOE,
		Material.STONE_PICKAXE,
		Material.STONE_SWORD,
		
		Material.IRON_AXE,
		Material.IRON_HOE,
		Material.IRON_PICKAXE,
		Material.IRON_SWORD,
		
		Material.GOLD_AXE,
		Material.GOLD_HOE,
		Material.GOLD_PICKAXE,
		Material.GOLD_SWORD,
		
		Material.DIAMOND_AXE,
		Material.DIAMOND_HOE,
		Material.DIAMOND_PICKAXE,
		Material.DIAMOND_SWORD,
		
		Material.BOW,
		Material.FISHING_ROD
	};

	public static Material[] getWeaponsList() {
		return weaponsList;
	}

	public static void setWeaponsList(Material[] weaponsList) {
		ListOfWeapons.weaponsList = weaponsList;
	}

}
