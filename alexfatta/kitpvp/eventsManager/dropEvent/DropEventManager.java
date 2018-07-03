package fr.alexfatta.kitpvp.eventsManager.dropEvent;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEventManager implements Listener {

    @EventHandler (priority=EventPriority.LOWEST)
    public static void onDrop (PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
            event.setCancelled(true);
        }
    }

}
