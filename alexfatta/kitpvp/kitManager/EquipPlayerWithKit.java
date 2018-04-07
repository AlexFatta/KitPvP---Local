package fr.alexfatta.kitpvp.kitManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.alexfatta.kitpvp.kitManager.kitObjects.Consumables;
import fr.alexfatta.kitpvp.kitManager.kitObjects.PotionsLots;
import fr.alexfatta.kitpvp.kitManager.kitObjects.Weapons;

public class EquipPlayerWithKit {

	public static void equipKit (String kitName, Player player) {

		int slotNumber = 0;
		int i = 0;
		
		while (i < LoadKits.getLoadedKits().size()) {

			Kits kit = LoadKits.getLoadedKits().get(i);
			if (kit.getKitName().equals(kitName) && kit != null) {

				//Armor
				try {
					player.getInventory().setHelmet(kit.getArmor().getHelmet());
					player.getInventory().setChestplate(kit.getArmor().getChestplate());
					player.getInventory().setLeggings(kit.getArmor().getLeggings());
					player.getInventory().setBoots(kit.getArmor().getBoots());
				} catch (NullPointerException e) {

				}

				//Armes
				for (int j = 0; j < Weapons.getListWeapons().size(); j++) {
					player.getInventory().setItem(slotNumber, Weapons.getListWeapons().get(j));
					slotNumber += 1;
				}

				//Potions
				for (int k = 0; k < PotionsLots.getListOfPotions().size(); k++) {
					player.getInventory().setItem(slotNumber, PotionsLots.getListOfPotions().get(k));
					slotNumber += 1;
				}
				
				//Consommables
				for (int l = 0; l < Consumables.getMapConsumables().size(); l++) {
					player.getInventory().setItem(slotNumber, Consumables.getMapConsumables().get(l));
					slotNumber += 1;
				}

				player.sendMessage(ChatColor.GRAY + "Kit " + kit.getKitName() + " recu avec succès !");

			}

			i++;
		}

	}

}
