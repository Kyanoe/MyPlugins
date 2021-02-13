package me.myPlugin.kano.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.myPlugin.kano.plugin.utils.colored.colored;

public class help implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("help")){
            if (args.length > 0){
                try {
                    int page = Integer.parseInt(args[0]);
                    if (page == 1){
                        sender.sendMessage(colored("&7&l&m------------------------"));
                        sender.sendMessage(colored("     &e&lMyPlugin &7v1.0"));
                        sender.sendMessage(colored("&7&l&m------------------------"));
                        sender.sendMessage(colored(" &7- &a/give <player> <item> <amount>"));
                        sender.sendMessage(colored(" &7- &a/gmc"));
                        sender.sendMessage(colored(" &7- &a/gms"));
                        sender.sendMessage(colored(" &7- &a/gmsp"));
                        sender.sendMessage(colored(" &7- &a/fly <player>"));
                        sender.sendMessage(colored(" &7- &a/heal <player>"));
                        sender.sendMessage(colored(" &7- &a/feed <player>"));
                        sender.sendMessage(colored(" &7- &a/spawnmob <entity> <amount>"));
                        sender.sendMessage(colored(" &7- &a/help <page>"));
                        sender.sendMessage(colored("&7&l&m------------------------"));
                        return true;
                    }else{
                        sender.sendMessage(colored("&cThe page doesn't exist."));
                        return true;
                    }
                }catch (IllegalArgumentException e){
                    sender.sendMessage(colored("&cError page."));
                }
            }else{
                sender.sendMessage(colored("&7&l&m------------------------"));
                sender.sendMessage(colored("     &e&lMyPlugin &7v1.0"));
                sender.sendMessage(colored("&7&l&m------------------------"));
                sender.sendMessage(colored(" &7- &a/give <player> <item> <amount>"));
                sender.sendMessage(colored(" &7- &a/gmc"));
                sender.sendMessage(colored(" &7- &a/gms"));
                sender.sendMessage(colored(" &7- &a/gmsp"));
                sender.sendMessage(colored(" &7- &a/fly <player>"));
                sender.sendMessage(colored(" &7- &a/heal <player>"));
                sender.sendMessage(colored(" &7- &a/feed <player>"));
                sender.sendMessage(colored(" &7- &a/spawnmob <entity> <amount>"));
                sender.sendMessage(colored(" &7- &a/help <page>"));
                sender.sendMessage(colored("&7&l&m------------------------"));
                return true;
            }

        }

        return false;
    }
}
