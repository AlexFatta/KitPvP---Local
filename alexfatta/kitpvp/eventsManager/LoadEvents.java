package fr.alexfatta.kitpvp.eventsManager;

import org.bukkit.Bukkit;

import fr.alexfatta.kitpvp.Main;
import fr.alexfatta.kitpvp.eventsManager.deathEvent.DeathEventManager;
import fr.alexfatta.kitpvp.eventsManager.dropEvent.DropEventManager;
import fr.alexfatta.kitpvp.eventsManager.joinEvent.JoinEventManager;
import fr.alexfatta.kitpvp.eventsManager.leaveEvent.LeaveEventManager;

public class LoadEvents {
	
	public static void loadAllEvents(Main main) {
		Bukkit.getPluginManager().registerEvents(new JoinEventManager(), main);
		Bukkit.getPluginManager().registerEvents(new DeathEventManager(), main);
		Bukkit.getPluginManager().registerEvents(new LeaveEventManager(), main);
		Bukkit.getPluginManager().registerEvents(new DropEventManager(), main);
	}

}
