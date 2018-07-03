package fr.alexfatta.kitpvp.kitManager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.alexfatta.kitpvp.Main;
import fr.alexfatta.kitpvp.fileManager.FileManager;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Armor;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Consumables;
import fr.alexfatta.kitpvp.kitManager.kitObjects.PotionsLots;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Weapons;
import fr.alexfatta.kitpvp.kitManager.listConsumables.ListConsumables;
import fr.alexfatta.kitpvp.kitManager.listWeapons.ListOfWeapons;


public class LoadKits {

	private static ArrayList<Kits> loadedKits = new ArrayList<>();

	private static Main main;

	public static void loadKit() {

		ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();


		//On récupère le nom et la section du Kit à charger
		for (String kitName : FileManager.getKits().getConfigurationSection("kits").getValues(false).keySet()) {

			int totalPotionNumber = 1;
			int totalWeaponNumber = 0;

			Armor armor = new Armor();
			ArrayList<ItemStack> listConsumables = new ArrayList<>();
			ArrayList<ItemStack> listWeapons = new ArrayList<>();
			ArrayList<ItemStack> listOfPotionsToLoad = new ArrayList<>();

			//On récupère l'élément à charger du kit en chargement
			for (String elementName : FileManager.getKits().getConfigurationSection("kits." + kitName).getValues(false).keySet()) {

				//On définit le type, le slot et le nombre d'item.
				String itemName = FileManager.getKits().getString("kits." + kitName + "." + elementName + ".name").replace('&', '§');
				@SuppressWarnings("unused")
				String type = FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type");
				int numberOfItem = FileManager.getKits().getInt("kits." + kitName + "." + elementName + ".number");



				//C'est une arme, un consommable ou une armure
				if (FileManager.getKits().get("kits." + kitName + "." + elementName + ".type") instanceof String) {


					switch (elementName.toString()) {
					case "Helmet":
						ItemStack helmet = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), true));
						armor.setHelmet(helmet);
						break;
					case "Chestplate":
						ItemStack chestplate = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), true));
						armor.setChestplate(chestplate);
						break;
					case "Leggings":
						ItemStack leggings = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), true));
						armor.setLeggings(leggings);
						break;
					case "Boots":
						ItemStack boots = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), true));
						armor.setBoots(boots);
						break;
					default:

						Material element = Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type"));


						//Verification si l'objet est un consommables.
						for (Material m : ListConsumables.getConsumables()) {
							if (m.equals(element)) {
								ItemStack ISToAddConsumables = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), false));
								ItemMeta ISMeta = ISToAddConsumables.getItemMeta();
								ISMeta.setDisplayName(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".name").replace("&", "§"));
								ISToAddConsumables.setItemMeta(ISMeta);
								ISToAddConsumables.setAmount(numberOfItem);
								listConsumables.add(ISToAddConsumables);
							}
						}

						//Verification si l'objet est une arme
						for (Material m : ListOfWeapons.getWeaponsList()) {
							if (m.equals(element)) {
								ItemStack ISToAddWeapon = new ItemStack(attributeEnchants(kitName, elementName, itemName, Material.matchMaterial(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".type")), true));
								listWeapons.add(ISToAddWeapon);
								totalWeaponNumber += 1;
							}
						}
						break;
					}
				} //Fin du String


				//C'est une potion
				else if (FileManager.getKits().get("kits." + kitName + "." + elementName + ".type") instanceof Integer) {

					int potionID = FileManager.getKits().getInt("kits." + kitName + "." + elementName + ".type");
					int numberOfPotion = FileManager.getKits().getInt("kits." + kitName + "." + elementName + ".number");
					ItemStack potion = new ItemStack(Material.POTION, numberOfPotion, (short) potionID);
					/*ItemMeta potionMeta = potion.getItemMeta();
                    potionMeta.setDisplayName(FileManager.getKits().getString("kits." + kitName + "." + elementName + ".name").replace("&", "§"));
                    potion.setItemMeta(potionMeta);*/

					switch (totalPotionNumber) {

					case 1:
						listOfPotionsToLoad.add(potion);
						totalPotionNumber += 1;
						break;
					case 2:
						listOfPotionsToLoad.add(potion);
						totalPotionNumber += 1;
						break;
					case 3:
						listOfPotionsToLoad.add(potion);
						totalPotionNumber += 1;
						break;
					default:
						numberOfPotion = 1;
						break;
					}

				} //Fin de l'Integer

			} //Fin de la boucle elementName

			Weapons weapons = new Weapons(listWeapons);
			Consumables consumables = new Consumables(listConsumables);
			PotionsLots potionsLots = new PotionsLots(listOfPotionsToLoad);

			//Coder la partie des armes
			Kits kitToLoad = new Kits(armor, weapons, totalWeaponNumber, potionsLots, consumables, kitName);

			loadedKits.add(kitToLoad);

			sender.sendMessage(ChatColor.GREEN + "Kit " + ChatColor.YELLOW + kitToLoad.getKitName() + ChatColor.GREEN + " saved with success !");

		} //Fin de la boucle kitName For

		sender.sendMessage(ChatColor.GREEN + "Loaded kits : " + loadedKits);

	}

	public static ItemStack attributeEnchants(String kitName, String elementName, String itemName, Material elementToEnchant, boolean isEnchantable) {

		ItemStack elementItemStack = new ItemStack(elementToEnchant);

		//Enchantements
		if (isEnchantable) {
			try {
				String enchantements = FileManager.getKits().getString("kits." + kitName + "." + elementName + ".enchants");
				String strEnchant[] = enchantements.split(";");

				ItemMeta meta = elementItemStack.getItemMeta();
				meta.setDisplayName(itemName);

				for (String enchant : strEnchant) {
					String strPower[] = enchant.split(",");
					Enchantment objEnch = Enchantment.getByName(strPower[0]);
					final int power;

					if (strPower.length == 2) {
						power = Integer.parseInt(strPower[1]);
					} else {
						power = 1;
					}

					meta.addEnchant(objEnch, power, true);
				}
				elementItemStack.setItemMeta(meta);


			} catch (NullPointerException e) {
				System.out.println("Error : bad enchantment ! Cannot find or enchant the piece " + elementName + " of kit " + kitName);
			}
		}
		return elementItemStack;
	}

	public static Main getMain() {
		return main;
	}

	public static void setMain(Main main) {
		LoadKits.main = main;
	}

	public static ArrayList<Kits> getLoadedKits() {
		return loadedKits;
	}

	public void setLoadedKits(ArrayList<Kits> loadedKits) {
		LoadKits.loadedKits = loadedKits;
	}

}
