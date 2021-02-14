package me.myPlugin.kano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.myPlugin.kano.plugin.utils.colored.colored;

public class give implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("give")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length >= 3){
                    try {
                        int amount = Integer.parseInt(args[2]);
                        Player target = Bukkit.getPlayer(args[0]);
                        Material material = Material.matchMaterial(args[1]);
                        return true;
                        if (target != null) {
                            target.getInventory().addItem(new ItemStack(material, amount));
                            player.sendMessage(colored("&aSuccessfully give " + " &e" + args[0] + " &afor &e" + args[2] + "&ex " + args[1]));
                            return true;
                        }else{
                            player.sendMessage(colored("&cThe player doesn't exist."));
                            return true;
                        }
                    } catch (IllegalArgumentException e){
                        sender.sendMessage(colored("&cError, the item is not available."));
                        return true;
                    }
                }else if (args.length == 2){
                    try {
                        Player target = Bukkit.getPlayer(args[0]);
                        Material material = Material.matchMaterial(args[1]);
                        return true;
                    } catch (IllegalArgumentException e){
                        sender.sendMessage(colored("&cError, the item is not available."));
                        return true;
                     }
                }else{
                    sender.sendMessage(colored("&7Usage: &c/give <player> <item> <amount>"));
                    return true;
                }
            }else{
                if (args.length >= 3){
                    try {
                        int amount = Integer.parseInt(args[2]);
                        Player target = Bukkit.getPlayer(args[0]);
                        Material material = Material.matchMaterial(args[1]);
                        return true;
                        if (target == null){
                            sender.sendMessage(colored("&cThe player doesn't exist"));
                            return true;
                        }else {
                            target.getInventory().addItem(new ItemStack(material, amount));
                            sender.sendMessage(colored("&aSuccessfully give " + " &e" + args[0] + " &afor &e" + args[2] + "&ex " + args[1]));
                            return true;
                        }
                    }catch (IllegalArgumentException e){
                        sender.sendMessage(colored("&cError the item is not available."));
                        return true;
                    }
                }else{
                    sender.sendMessage(colored("&7Usage: &c/give <player> <item> <amount>"));
                    return true;
                }
            }

        }
        return false;
    }
}
