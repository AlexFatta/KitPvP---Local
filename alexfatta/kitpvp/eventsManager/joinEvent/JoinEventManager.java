package fr.alexfatta.kitpvp.eventsManager.joinEvent;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventManager implements Listener {

    private static double player_health;

    @EventHandler (priority=EventPriority.LOWEST)
    public void onJoinEvent (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);
        event.getPlayer().setHealthScale(player_health);
        event.setJoinMessage(ChatColor.DARK_AQUA + "(" + ChatColor.GOLD + "+" + ChatColor.DARK_AQUA + ") " + player.getName());
    }

    public static double getPlayer_health() {
        return player_health;
    }

    public static void setPlayer_health(double player_health) {
        JoinEventManager.player_health = player_health;
    }

}
