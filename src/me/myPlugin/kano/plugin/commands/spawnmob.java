package me.myPlugin.kano.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static me.myPlugin.kano.plugin.utils.utils.colored;

public class spawnmob implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("spawnmob")){
            if (sender instanceof Player){
                if (args.length > 1){
                    Player player = (Player) sender;
                    try{
                        EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                        int amount = Integer.parseInt(args[1]);
                        for (int i = 0; i < amount; i++){
                            player.getWorld().spawnEntity(player.getLocation(), entity);
                        }
                        return true;
                    }catch (IllegalArgumentException e){
                        player.sendMessage(colored("&cThe entity doesn't exist"));
                    }
                }else if (args.length == 1){
                    Player player = (Player) sender;
                    try{
                        EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                        return true;
                    }catch (IllegalArgumentException e){
                        player.sendMessage(colored("&cThe entity doesn't exist"));
                    }
                }else{
                    sender.sendMessage(colored("&7Usage: &c/spawnmob <entity> <amount>"));
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
