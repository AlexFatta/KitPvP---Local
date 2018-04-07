package fr.alexfatta.kitpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.alexfatta.kitpvp.fileManager.FileManager;
import fr.alexfatta.kitpvp.spreadPlayers.SpreadPlayersManager;

public class ArenaCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (label.equalsIgnoreCase("arena") && sender instanceof Player ) {
			Player player = (Player) sender;

			if (args.length >= 1 && args.length <= 3) {	
				if (player.hasPermission("kitpvp.arena.manage") || player.isOp()) {
					if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage(ChatColor.GREEN + "Correct usage :");
						player.sendMessage(ChatColor.AQUA + "/arena create <name>" + ChatColor.RESET + " : " + ChatColor.LIGHT_PURPLE + "Créer une nouvelle arène.");
						player.sendMessage(ChatColor.AQUA + "/arena <name> setspawn <number>" + ChatColor.RESET + " : " + ChatColor.LIGHT_PURPLE + "Pose un point de spawn isi pour cette arène.");
						return true;


					} else if (args[0].equalsIgnoreCase("create") && args.length == 2) {
						if (!SpreadPlayersManager.getArenaList().contains(args[1].toString())) {
							SpreadPlayersManager.getArenaList().add(args[1].toString());
							player.sendMessage(ChatColor.GREEN + "Tu as crée l'arène " + ChatColor.LIGHT_PURPLE + args[1].toString());
							player.sendMessage(ChatColor.GREEN + "Tu peux maintenant lui attribuer ses points de spawn : " + ChatColor.LIGHT_PURPLE +
									"/arena " + ChatColor.YELLOW + args[1].toString() + ChatColor.LIGHT_PURPLE + " setspawn <number>");
							return true;
						} else {
							player.sendMessage(ChatColor.RED + "Erreur : impossible de créer cette arène. Est-elle déjà créée... ?");
						}

					} else if ((args.length == 3) && (args[1].equalsIgnoreCase("setspawn")) && (SpreadPlayersManager.getArenaList().contains(args[0].toString()))) {
						FileManager.writeConfArenas(args[0].toString(), player.getLocation(), args[2]);

						player.sendMessage(ChatColor.GREEN + "Tu as ajouté ce point de spawn à l'arène " + ChatColor.LIGHT_PURPLE + args[0].toString());
						FileManager.saveArena();
						return true;

					} else if (args[0].equalsIgnoreCase("list") && args.length == 1){
						player.sendMessage(ChatColor.GREEN + "Voici la liste des arènes :");
						player.sendMessage(ChatColor.GRAY + "Chargement...");
						player.sendMessage(SpreadPlayersManager.getArenaList().toString());
						return true;

					} else if (args[0].equalsIgnoreCase("see") && args.length == 2 && SpreadPlayersManager.getArenaList().contains(args[1].toString())){
						player.sendMessage(ChatColor.GREEN + "Voici la liste des point de spawn de l'arène " +ChatColor.YELLOW + args[1].toString() + ChatColor.GREEN + " :");
						player.sendMessage(ChatColor.GRAY + "Chargement...");

						int count = 0;
						for (String secondEntry : FileManager.getArenas().getConfigurationSection("Arenas." + args[1].toString()).getValues(false).keySet()) {
							count += 1;

							String worldName = FileManager.getArenas().getString("Arenas." + args[1] + "." + secondEntry + ".world");
							double x = FileManager.getArenas().getDouble("Arenas." + args[1] + "." + secondEntry + ".x");
							double y = FileManager.getArenas().getDouble("Arenas." + args[1] + "." + secondEntry + ".y");
							double z = FileManager.getArenas().getDouble("Arenas." + args[1] + "." + secondEntry +  ".z");

							player.sendMessage(ChatColor.LIGHT_PURPLE + "Location " + count + " :");
							player.sendMessage(ChatColor.YELLOW + "  Nom du monde de la position : " + ChatColor.DARK_GREEN + worldName + "\n" + 
									ChatColor.YELLOW + "  Coordonée en X de la position : " + ChatColor.DARK_GREEN + x + "\n" + 
									ChatColor.YELLOW + "  Coordonée en Y de la position : " + ChatColor.DARK_GREEN + y + "\n" + 
									ChatColor.YELLOW + "  Coordonée en Z de la position : " + ChatColor.DARK_GREEN + z + "\n");
						}
						return true;
					}

					else {
						player.sendMessage(ChatColor.RED + "Erreur : mauvaise saisie.");
						player.sendMessage(ChatColor.RED + "/arena help pour afficher l'aide.");
						return true;
					}

				}
			} else {
				player.sendMessage(ChatColor.RED + "Erreur : mauvaise saisie.");
				player.sendMessage(ChatColor.RED + "/arena help pour afficher l'aide.");
				return true;
			}

		}

		return false;
	}

}
