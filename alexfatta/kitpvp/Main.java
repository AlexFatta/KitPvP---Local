package fr.alexfatta.kitpvp;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import fr.alexfatta.kitpvp.spreadPlayers.SpreadPlayersManager;
import fr.alexfatta.kitpvp.commands.ArenaCommand;
import fr.alexfatta.kitpvp.commands.CommandKitPvP;
import fr.alexfatta.kitpvp.eventsManager.LoadEvents;
import fr.alexfatta.kitpvp.eventsManager.joinEvent.JoinEventManager;
import fr.alexfatta.kitpvp.fileManager.FileManager;
import fr.alexfatta.kitpvp.kitManager.LoadKits;

public class Main extends JavaPlugin {
	
	/*
	 * Tout objectifs accomplis
	 */

    private static Main INSTANCE;

    private static String prefix = ChatColor.GOLD + "[" + ChatColor.GREEN + "KitPvP" + ChatColor.GOLD + "] ";

    @Override
    public void onEnable() {
        INSTANCE = this;
        SpreadPlayersManager.main = this;
        FileManager.generateConf(this);
        JoinEventManager.setPlayer_health(FileManager.getConfig().getDouble("player_health"));
        FileManager.checkNullArenaConfFile();
        FileManager.loadConfArenas();
        LoadKits.setMain(this);
        LoadEvents.loadAllEvents(this);
        LoadKits.loadKit();
        getCommand("kitpvp").setExecutor(new CommandKitPvP());
        getCommand("spread").setExecutor(new SpreadPlayersManager());
        getCommand("arena").setExecutor(new ArenaCommand());
        System.out.println("KitPvp launched with success !");
    }

    @Override
    public void onDisable() {

    }

    public static Main getINSTANCE() {
        return INSTANCE;
    }

    public void setINSTANCE(Main iNSTANCE) {
        INSTANCE = iNSTANCE;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        Main.prefix = prefix;
    }

}