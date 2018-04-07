package fr.alexfatta.kitpvp.eventsManager.deathEvent;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEventManager implements Listener {
	
	@EventHandler (priority=EventPriority.LOWEST)
	public void onDeath (PlayerDeathEvent event) {
		
		if (/*event.getEntity().getKiller() instanceof Player && */event.getEntity() instanceof Player) {
			Player attacker = event.getEntity().getKiller();
			Player victim = (Player) event.getEntity();
			
			World world = victim.getWorld();
			List<Entity> entList = world.getEntities();
	        
			for(Entity current : entList){
	            if (current.getType() == EntityType.DROPPED_ITEM){
	                current.remove();
	            }
	        }
	        
			event.setDeathMessage(ChatColor.RED.toString() + ChatColor.BOLD + victim.getName() 
					+ ChatColor.YELLOW + " was killed by " + ChatColor.RED.toString() + ChatColor.BOLD + attacker);
		
		}
		
	}

}
