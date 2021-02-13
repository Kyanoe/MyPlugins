package me.myPlugin.kano.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.myPlugin.kano.plugin.utils.colored.colored;

public class fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")){
            if (sender instanceof Player){
                if (args.length >= 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null){
                        sender.sendMessage(colored("&cError, the player is not exist"));
                        return true;
                    }else{
                        Player player = (Player) sender;
                        if (target.isFlying()){
                            target.setFlying(false);
                            target.setAllowFlight(false);
                            player.sendMessage(colored("&cSuccessfully disable fly for " + args[0]));
                            return true;
                        }else{
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            player.sendMessage(colored("&aSuccessfully enable fly for " + args[0]));
                            return true;
                        }
                    }
                }else if (args.length == 0){
                    Player player = (Player) sender;
                    if (player.isFlying()){
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        player.sendMessage(colored("&cSuccessfully Disable fly."));
                        return true;
                    }else{
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(colored("&aSuccessfully Enable fly"));
                        return true;
                    }
                }
            }else if (!(sender instanceof Player)){
                sender.sendMessage(colored("&cYou can't use this command at console."));
                return true;
            }
        }
        return false;
    }
}
