package me.myPlugin.kano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.myPlugin.kano.plugin.utils.utils.colored;

public class heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("heal")){

            if (sender instanceof Player){
                if (args.length >= 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    Player player = (Player) sender;
                    if (target != null) {
                        target.setHealth(20.0);
                        target.sendMessage(colored("&aYou have been healed by &e" + sender.getName()));
                        player.sendMessage(colored("&aSuccessfully healed for player &e" + args[0]));
                        return true;
                    }else{
                        player.sendMessage(colored("&cThe player doesn't exist"));
                        return true;
                    }
                }else{
                    Player player = (Player) sender;
                    player.setHealth(20.0);
                    sender.sendMessage(colored("&aYou have been healed"));
                    return true;
                }
            }else{
                if (args.length > 0){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        target.setHealth(20.0);
                        sender.sendMessage(colored("&aSuccessfully healed " + args[0]));
                        return true;
                    }else{
                        sender.sendMessage(colored("&e" + args[0] + " &cdoesn't exist"));
                        return true;
                    }
                }else{
                    sender.sendMessage(colored("&cYou must input the player's name"));
                    return true;
                }
            }

        }

        return false;
    }
}
