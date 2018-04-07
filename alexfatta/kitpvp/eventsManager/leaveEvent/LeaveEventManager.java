package fr.alexfatta.kitpvp.eventsManager.leaveEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEventManager implements Listener {
	
	@EventHandler
	public void leaveEvent (PlayerQuitEvent event) {
		Player player = event.getPlayer();
		player.getInventory().clear();
		event.setQuitMessage(ChatColor.RED + "(" + ChatColor.GOLD + "-" + ChatColor.RED + ") " + player.getName());
	}

}
