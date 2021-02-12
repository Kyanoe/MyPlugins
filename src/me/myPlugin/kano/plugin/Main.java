package me.myPlugin.kano.plugin;
import me.myPlugin.kano.plugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import static me.myPlugin.kano.plugin.utils.utils.colored;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        give giveCommands = new give();

        fly flyCommands = new fly();

        help helpCommands = new help();

        heal healCommands = new heal();

        spawnmob spawnmobCommands = new spawnmob();

        getServer().getConsoleSender().sendMessage(colored("&7[&6MyPlugins&7] &aPlugins Enable."));

        getCommand("give").setExecutor(giveCommands);

        getCommand("fly").setExecutor(flyCommands);

        getCommand("help").setExecutor(helpCommands);

        getCommand("heal").setExecutor(healCommands);

        getCommand("feed").setExecutor(new feed());

        getCommand("spawnmob").setExecutor(spawnmobCommands);

        getCommand("gmc").setExecutor(new gmc());

        getCommand("gms").setExecutor(new gms());

        getCommand("gmsp").setExecutor(new gmsp());
    }

    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage(colored("&7[&6MyPlugins&7] &cPlugins Disable."));
    }
};