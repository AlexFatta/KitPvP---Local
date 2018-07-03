package fr.alexfatta.kitpvp.fileManager;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;

import fr.alexfatta.kitpvp.Main;
import fr.alexfatta.kitpvp.spreadPlayers.SpreadPlayersManager;

public abstract class FileManager {

    private static Config arenas, kits, documentation, config;

    public static void generateConf(Main main) {

        setArenas(new Config(main, "arenas.yml", "arenas.yml"));
        setKits(new Config(main, "kits.yml", "kits.yml"));
        setDocumentation(new Config(main, "documentation.yml", "documentation.yml"));
        setConfig(new Config(main, "config.yml", "config.yml"));
        getArenas().save();

    }

    public static Config getArenasFile() {
        return getArenas();
    }

    public static void saveArena() {
        getArenas().save();
    }

    public static void writeConfArenas(String arenaName, Location location, String number) {
        String key = arenaName + "_" + number;

        getArenas().set("Arenas." + arenaName + "." + key + ".world", location.getWorld().getName());
        getArenas().set("Arenas." + arenaName + "." + key + ".x", location.getX());
        getArenas().set("Arenas." + arenaName + "." + key + ".y", location.getY());
        getArenas().set("Arenas." + arenaName + "." + key + ".z", location.getZ());
        getArenas().set("Arenas." + arenaName + "." + key + ".pitch", location.getPitch());
        getArenas().set("Arenas." + arenaName + "." + key + ".yaw", location.getYaw());
        getArenas().save();
        getArenas().reload();
    }

    public static void loadConfArenas() {
        SpreadPlayersManager.getSpawnPoints().clear();

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        try {
            for (String entry : getArenas().getConfigurationSection("Arenas").getValues(false).keySet()) {

                if (!SpreadPlayersManager.getArenaList().contains(entry)) {
                    SpreadPlayersManager.getArenaList().add(entry);
                }

                for (String secondEntry : getArenas().getConfigurationSection("Arenas." + entry).getValues(false).keySet()) {
                    String world = getArenas().getString("Arenas." + entry + "." + secondEntry + ".world");
                    double x = getArenas().getDouble("Arenas." + entry + "." + secondEntry + ".x");
                    double y = getArenas().getDouble("Arenas." + entry + "." + secondEntry + ".y");
                    double z = getArenas().getDouble("Arenas." + entry + "." + secondEntry + ".z");
                    double yaw = getArenas().getDouble("Arenas." + entry + "." + secondEntry + ".yaw");
                    double pitch = getArenas().getDouble("Arenas." + entry + "." + secondEntry + ".pitch");

                    SpreadPlayersManager.getSpawnPoints().put(entry + "." + secondEntry, new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch));
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        console.sendMessage(ChatColor.GREEN + "List of arenas :\n" + ChatColor.AQUA + SpreadPlayersManager.getArenaList() + "\n");

    }

    public static boolean checkNullArenaConfFile() {
        try {
            if (getArenas().getConfigurationSection("Arenas").getValues(false).keySet() == null) {
                SpreadPlayersManager.getSpawnPoints().put("default", new Location(Bukkit.getServer().getWorld("world"), 0, 65, 0));
                writeConfArenas("default", new Location(Bukkit.getWorld("world"),0, 65, 0), "1");
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return true;
        }

        return false;
    }

    public static Config getArenas() {
        return arenas;
    }

    public static void setArenas(Config arenas) {
        FileManager.arenas = arenas;
    }

    public static Config getKits() {
        return kits;
    }

    public static void setKits(Config kits) {
        FileManager.kits = kits;
    }

    public static Config getDocumentation() {
        return documentation;
    }

    public static void setDocumentation(Config documentation) {
        FileManager.documentation = documentation;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        FileManager.config = config;
    }

}
