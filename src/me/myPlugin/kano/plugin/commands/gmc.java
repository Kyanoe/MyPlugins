package me.myPlugin.kano.plugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.myPlugin.kano.plugin.utils.utils.colored;

public class gmc implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gmc")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (player.getGameMode().equals(GameMode.CREATIVE)){
                    player.sendMessage(colored("&cYou already in gamemode Creative"));
                    return true;
                }else{
                    String gamemode = player.getGameMode().toString().toLowerCase();
                    player.sendMessage(colored("&aSuccessfully change your gamemode from &e" + gamemode + " &ato &eCreative."));
                    player.setGameMode(GameMode.CREATIVE);
                    return true;
                }
            }else{
                sender.sendMessage(colored("&cYou only can use this command in game."));
                return true;
            }
        }

        return false;
    }

}
