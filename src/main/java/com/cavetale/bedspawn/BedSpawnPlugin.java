package com.cavetale.bedspawn;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedSpawnPlugin extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (args.length != 0) return false;
        Player player = (Player) sender;
        if (player.getBedSpawnLocation() == null) {
            player.sendMessage(ChatColor.RED + "You do not have a bed spawn. Sleep in a bed first.");
            return true;
        }
        player.teleport(player.getBedSpawnLocation().add(0.5, 0.0, 0.5));
        player.sendMessage(ChatColor.BLUE + "Welcome to your bed.");
        return true;
    }
}
