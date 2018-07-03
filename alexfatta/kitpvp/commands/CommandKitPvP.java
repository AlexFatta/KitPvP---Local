package fr.alexfatta.kitpvp.commands;

import fr.alexfatta.kitpvp.Main;
import fr.alexfatta.kitpvp.kitManager.CheckExistingKit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.alexfatta.kitpvp.kitManager.EquipPlayerWithKit;

public class CommandKitPvP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        //Gestion de la commande KitPvP
        if (label.equalsIgnoreCase("kitpvp") && sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1 && CheckExistingKit.checkExistingAskedKit(args[0])) {

                player.getInventory().clear();

                EquipPlayerWithKit.equipKit(args[0], player);

                return true;
            } else {
                player.sendMessage(Main.getPrefix() + "Impossible d'équiper le kit " + args[0] + ".");
            }
        }
        return false;
    }
}