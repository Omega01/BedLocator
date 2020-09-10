package org.hisparquia.bedlocator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Has been enabled.");
        getLogger().info("Made by Omega01");
    }

    public void onDisable() {
        getLogger().info("Has been disabled.");
        getLogger().info("Made by Omega01");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("bed")) {
                Player p = (Player)sender;
                if (p.getBedSpawnLocation() == null) {
                    p.sendMessage("§cYou don't have a bed placed.");
                } else {
                    double bedx = p.getBedSpawnLocation().getX();
                    double bedy = p.getBedSpawnLocation().getY();
                    double bedz = p.getBedSpawnLocation().getZ();
                    p.sendMessage("§aBed:\n" + "X: " + bedx + "\nY: " + bedy + "\nZ: " + bedz);
                }
                return true;
            }
        }
        sender.sendMessage("§cCommand only for players.");
        return true;
    }
}