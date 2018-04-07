package fr.alexfatta.kitpvp.spreadPlayers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.alexfatta.kitpvp.Main;
import fr.alexfatta.kitpvp.fileManager.FileManager;

public class SpreadPlayersManager implements CommandExecutor {

	//Récupérer le nombre de SP par arène

	public static Main main;

	private static Integer spawns_count;

	private static ArrayList<String> arenaList = new ArrayList<>(); //Liste des noms des arènes
	private static HashMap<String, Location> spawnPoints = new HashMap<>(); //Liste des arènes avec leurs points de spawn

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,	String[] args) {

		if (sender instanceof Player && label.equalsIgnoreCase("spread")) {	
			Player player = (Player) sender;
			if (args.length == 1) {
				player.teleport(locToTeleport(args[0].toString()));
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "Erreur : merci de contacter un administrateur.");
				return true;
			}
		}

		return false;
	}

	public Location locToTeleport (String name) {
		Location location = null;
		
		int spawnNumber = 0;
		for (@SuppressWarnings("unused") String secondEntry : FileManager.getArenas().getConfigurationSection("Arenas." + name).getValues(false).keySet()) {
			spawnNumber += 1;
		}

		Random random= new Random();
		int alea = random.nextInt(spawnNumber + 1);
		
		if (alea == 0) alea +=1;
		
		location = spawnPoints.get(name + "." + name + "_" + alea);

		return location;
	}

	public static Integer getSpawns_count() {
		return spawns_count;
	}

	public static void setSpawns_count(Integer spawns_count) {
		SpreadPlayersManager.spawns_count = spawns_count;
	}
	
	public static HashMap<String, Location> getSpawnPoints() {
		return spawnPoints;
	}

	public static void setSpawnPoints(String string, Location location) {
		spawnPoints.put(string, location);
	}

	public static ArrayList<String> getArenaList() {
		return arenaList;
	}

	public static void setArenaList(ArrayList<String> arenaList) {
		SpreadPlayersManager.arenaList = arenaList;
	}
}
