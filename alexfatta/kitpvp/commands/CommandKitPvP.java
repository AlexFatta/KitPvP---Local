package fr.alexfatta.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.alexfatta.kitpvp.kitManager.EquipPlayerWithKit;
import fr.alexfatta.kitpvp.kitManager.KitManager;

public class CommandKitPvP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


		//Gestion de la commande KitPvP
		if (label.equalsIgnoreCase("kitpvp") && sender instanceof Player) {
			Player player = (Player) sender;

			if (args.length == 1) {
				
				player.getInventory().clear();
				
				switch (args[0]) {

				case "archer":
					EquipPlayerWithKit.equipKit("archer", player);
					//KitManager.kitArcher(player);
					break;

				case "brute":
					KitManager.kitBrute(player);
					break;

				case "posey":
					KitManager.kitPosey(player);
					break;

				case "kevin":
					KitManager.kitKevin(player);
					break;

				case "bucheron":
					KitManager.kitBucheron(player);
					break;

				case "knockage":
					KitManager.kitKnockage(player);
					break;

				default:
					player.sendMessage(ChatColor.RED + "Erreur : mauvais kit !");
				}
				
				return true;

			} else {
				player.sendMessage(ChatColor.RED + "Erreur : mauvaise saisie !");
				return true;
			}
		}

		return false;
	}

}
