package me.myPlugin.kano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.myPlugin.kano.plugin.utils.colored.colored;

public class feed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("feed")){
         if (sender instanceof Player){
             Player player = (Player) sender;
             if (args.length > 0){
                 Player target = Bukkit.getPlayer(args[0]);
                 if (target == null){
                     player.sendMessage(colored("&c" + args[0] + " &cis not online."));
                     return true;
                 }else{
                     player.sendMessage(colored("&aSuccessfully feed &e" + args[0]));
                     target.sendMessage(colored("&aYou have been feeded by &e" + player.getName()));
                     target.setFoodLevel(20);
                     return true;
                 }
             }else {
                 player.setFoodLevel(20);
                 player.sendMessage(colored("&aSuccessfully feed you."));
                 return true;
             }
         }else{
             sender.sendMessage(colored("&cYou can't use this command at console."));
             return true;
            }
        }

        return false;
    }
}
