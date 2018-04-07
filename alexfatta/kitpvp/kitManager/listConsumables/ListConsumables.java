package fr.alexfatta.kitpvp.kitManager.listConsumables;

import org.bukkit.Material;

public class ListConsumables {
	
	private static Material[] consumables = {
			
			Material.APPLE,
			Material.ARROW,
			Material.BAKED_POTATO,
			Material.BEETROOT_SOUP,
			Material.BOAT,
			Material.BOAT_ACACIA,
			Material.BOAT_BIRCH,
			Material.BOAT_DARK_OAK,
			Material.BOAT_JUNGLE,
			Material.BOAT_SPRUCE,
			Material.BOW,
			Material.BOWL,
			Material.BREAD,
			Material.BUCKET,
			Material.CARROT,
			Material.CAKE,
			Material.CAKE_BLOCK,
			Material.COOKIE,
			Material.COOKED_BEEF,
			Material.COOKED_CHICKEN,
			Material.COOKED_FISH,
			Material.COOKED_MUTTON,
			Material.COOKED_RABBIT,
			Material.EGG,
			Material.ELYTRA,
			Material.FIREBALL,
			Material.FIREWORK,
			Material.FISHING_ROD,
			Material.FLINT_AND_STEEL,
			Material.GOLDEN_APPLE,
			Material.GOLDEN_CARROT,
			Material.GRILLED_PORK,
			Material.LAVA_BUCKET,
			Material.PORK,
			Material.POTATO,
			Material.POTION,
			Material.MELON,
			Material.MELON_BLOCK,
			Material.MILK_BUCKET,
			Material.PUMPKIN_PIE,
			Material.RABBIT_STEW,
			Material.RABBIT,
			Material.RAW_BEEF,
			Material.RAW_CHICKEN,
			Material.RAW_FISH,
			Material.SNOW_BALL,
			Material.MUSHROOM_SOUP,
			Material.TNT,
			Material.TORCH,
			Material.WATER_BUCKET
	};

	public static Material[] getConsumables() {
		return consumables;
	}

	public static void setConsumables(Material[] consumables) {
		ListConsumables.consumables = consumables;
	}

}
