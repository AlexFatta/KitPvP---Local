package fr.alexfatta.kitpvp.kitManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.alexfatta.kitpvp.Main;
public class KitManager {

	/*
	 * 8193 Regeneration Potion (0:45)
8194 Swiftness Potion (3:00)
8195 Fire Resistance Potion (3:00)
8196 Poison Potion (0:45)
8197 Healing Potion
8200 Weakness Potion (1:30)
8201 Strength Potion (3:00)
8202 Slowness Potion (1:30)
8204 Harming Potion
8225 Regeneration Potion II (0:22)
8226 Swiftness Potion II (1:30)
8228 Poison Potion II (0:22)
8229 Healing Potion II
8233 Strength Potion II (1:30)
8236 Harming Potion II
8257 Regeneration Potion (2:00)
8258 Swiftness Potion (8:00)
8259 Fire Resistance Potion (8:00)
8260 Poison Potion (2:00)
8264 Weakness Potion (4:00)
8265 Strength Potion (8:00)
8266 Slowness Potion (4:00)
16378 Fire Resistance Splash (2:15)
16385 Regeneration Splash (0:33)
16386 Swiftness Splash (2:15)
16388 Poison Splash (0:33)
16389 Healing Splash
16392 Weakness Splash (1:07)
16393 Strength Splash (2:15)
16394 Slowness Splash (1:07)
16396 Harming Splash
16418 Swiftness Splash II (1:07)
16420 Poison Splash II (0:16)
16421 Healing Splash II
16425 Strength Splash II (1:07)
16428 Harming Splash II
16449 Regeneration Splash (1:30)
16450 Swiftness Splash (6:00)
16451 Fire Resistance Splash (6:00)
16452 Poison Splash (1:30)
16456 Weakness Splash (3:00)
16457 Strength Splash (6:00)
16458 Slowness Splash (3:00)
16471 Regeneration Splash II (0:16)
	 */

	public static void kitArcher(Player player) {

		//Tête
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner("MHF_Skeleton");
		meta.setDisplayName(ChatColor.GRAY + "Tête d'Archer");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		skull.setItemMeta(meta);
		player.getInventory().setHelmet(skull);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.GRAY + "Plastron d'Archer");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.GRAY + "Pantalon d'Archer");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.GRAY + "Bottes d'Archer");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.GRAY + "Épée d'Archer");
		swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		sword.setItemMeta(swordMeta);
		player.getInventory().setItem(0, sword);

		//Arme secondaire
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowMeta = bow.getItemMeta();
		bowMeta.setDisplayName(ChatColor.GRAY + "Arc d'Archer");
		bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
		bow.setItemMeta(bowMeta);
		player.getInventory().setItem(1, bow);

		//Flèche
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.GRAY + "Flèche unique...");
		arrow.setItemMeta(arrowMeta);
		player.getInventory().setItem(2, arrow);

		//Potions
		ItemStack potion = new ItemStack(Material.POTION, 2, (short) 8197);
		player.getInventory().setItem(3, potion);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(4, food);

		player.sendMessage(Main.getPrefix() + ChatColor.GRAY + "Kit Archer recu");
	}

	public static void kitBrute(Player player) {

		//Tête
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner("MHF_Wither");
		meta.setDisplayName(ChatColor.DARK_RED + "Tête de Brute");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		skull.setItemMeta(meta);
		player.getInventory().setHelmet(skull);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.DARK_RED + "Plastron de Brute");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.DARK_RED + "Pantalon de Brute");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.DARK_RED + "Bottes de Brute");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.DARK_RED + "Épée de Brute");
		swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		sword.setItemMeta(swordMeta);
		player.getInventory().setItem(0, sword);

		//Potions
		ItemStack potionHealing = new ItemStack(Material.POTION, 2, (short) 8197);
		player.getInventory().setItem(1, potionHealing);

		ItemStack potionStrength = new ItemStack(Material.POTION, 2, (short) 8201);
		player.getInventory().setItem(2, potionStrength);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(3, food);

		player.sendMessage(Main.getPrefix() + ChatColor.DARK_RED + "Kit Brute recu");
	}

	public static void kitPosey(Player player) {

		//Tête
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner("MHF_Zombie");
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Tête Posey");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		skull.setItemMeta(meta);
		player.getInventory().setHelmet(skull);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Plastron Posey");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pantalon Posey");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Bottes Posey");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack shovel = new ItemStack(Material.IRON_SPADE, 1);
		ItemMeta shovelMeta = shovel.getItemMeta();
		shovelMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pelle Posey");
		shovelMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
		shovel.setItemMeta(shovelMeta);
		player.getInventory().setItem(0, shovel);

		//Potions
		ItemStack potion = new ItemStack(Material.POTION, 2, (short) 8197);
		player.getInventory().setItem(1, potion);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(2, food);

		player.sendMessage(Main.getPrefix() + ChatColor.LIGHT_PURPLE + "Kit Posey recu");
	}

	public static void kitKevin(Player player) {

		//Tête
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 1);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner("MHF_Steve");
		meta.setDisplayName(ChatColor.GREEN + "Tête du Kevin");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		skull.setItemMeta(meta);
		player.getInventory().setHelmet(skull);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.GREEN + "Plastron du Kevin");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.GREEN + "Pantalon du Kevin");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.GREEN + "Bottes du Kevin");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.GREEN + "Épée du Kevin");
		swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		sword.setItemMeta(swordMeta);
		player.getInventory().setItem(0, sword);

		//Potions
		ItemStack potionSpeed = new ItemStack(Material.POTION, 3, (short) 8194);
		player.getInventory().setItem(1, potionSpeed);

		ItemStack potionHealing = new ItemStack(Material.POTION, 1, (short) 8197);
		player.getInventory().setItem(2, potionHealing);

		ItemStack potionStrength = new ItemStack(Material.POTION, 2, (short) 8201);
		player.getInventory().setItem(3, potionStrength);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(4, food);

		player.sendMessage(Main.getPrefix() + ChatColor.GREEN + "Kit Kevin recu");
	}

	public static void kitBucheron(Player player) {

		//Tête
		ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta helmetMeta = helmet.getItemMeta();
		helmetMeta.setDisplayName(ChatColor.GOLD + "Casque de Bucheron");
		helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		helmet.setItemMeta(helmetMeta);
		player.getInventory().setHelmet(helmet);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.GOLD + "Plastron de Bucheron");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.GOLD_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.GOLD + "Pantalon de Bucheron");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.GOLD + "Bottes de Bucheron");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
		ItemMeta axeMeta = axe.getItemMeta();
		axeMeta.setDisplayName(ChatColor.GOLD + "Hache de bucheron");
		axeMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		axeMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		axe.setItemMeta(axeMeta);
		player.getInventory().setItem(0, axe);

		//Potions
		ItemStack potion = new ItemStack(Material.POTION, 2, (short) 8197);
		player.getInventory().setItem(1, potion);

		ItemStack potionStrength = new ItemStack(Material.POTION, 2, (short) 8201);
		player.getInventory().setItem(2, potionStrength);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(3, food);

		player.sendMessage(Main.getPrefix() + ChatColor.GOLD + "Kit Bucheron recu");
	}

	public static void kitKnockage(Player player) {

		//Tête
		ItemStack helmet = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmetMeta = helmet.getItemMeta();
		helmetMeta.setDisplayName(ChatColor.DARK_GRAY + "Casque de Knockage");
		helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		helmet.setItemMeta(helmetMeta);
		player.getInventory().setHelmet(helmet);

		//Plastron
		ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta chestplateMeta = chestplate.getItemMeta();
		chestplateMeta.setDisplayName(ChatColor.DARK_GRAY + "Plastron de Knockage");
		chestplateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		chestplate.setItemMeta(chestplateMeta);
		player.getInventory().setChestplate(chestplate);

		//Pantalon
		ItemStack pants = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta pantsMeta = pants.getItemMeta();
		pantsMeta.setDisplayName(ChatColor.DARK_GRAY + "Pantalon de Knockage");
		pantsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		pants.setItemMeta(pantsMeta);
		player.getInventory().setLeggings(pants);

		//Bottes
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta bootsMeta = boots.getItemMeta();
		bootsMeta.setDisplayName(ChatColor.DARK_GRAY + "Bottes de Knockage");
		bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		boots.setItemMeta(bootsMeta);
		player.getInventory().setBoots(boots);

		//Arme principale
		ItemStack sword = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.DARK_GRAY + "Épée de Knockage");
		swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		sword.setItemMeta(swordMeta);
		player.getInventory().setItem(0, sword);

		//Arme secondaire
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta bowMeta = bow.getItemMeta();
		bowMeta.setDisplayName(ChatColor.DARK_GRAY + "Arc de Knockage");
		bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 4, true);
		bow.setItemMeta(bowMeta);
		player.getInventory().setItem(1, bow);

		//Flèche
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName(ChatColor.DARK_GRAY + "Flèche unique...");
		arrow.setItemMeta(arrowMeta);
		player.getInventory().setItem(2, arrow);

		//Potions
		ItemStack potion = new ItemStack(Material.POTION, 1, (short) 8197);
		player.getInventory().setItem(3, potion);

		//Bouffe
		ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
		player.getInventory().setItem(4, food);

		player.sendMessage(Main.getPrefix() + ChatColor.DARK_GRAY + "Kit Knockage recu");
	}
}	