package testplugin0.testplugin0;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Crasher implements CommandExecutor {
    public Crasher() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (!p.hasPermission("toolkit.crasher")) {
            return false;
        } else {
            if (args.length == 0) {
                p.sendMessage("[CRASHER] Please use /crasher <player>");
            } else {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage("[CRASHER] Player " + args[0] + " is not online!");
                } else if (target.getName().equalsIgnoreCase(p.getName())) {
                    p.sendMessage("[CRASHER] You can't crash yourself!");
                } else if (target.hasPermission("toolkit.bypass")) {
                    p.sendMessage("[CRASHER] You cannot crash this player!");
                } else {
                    Location loc = target.getLocation();
                    target.spawnParticle(Particle.EXPLOSION_HUGE, loc, 2147483647);
                    target.kickPlayer("");
                    p.sendMessage("[CRASHER] Player " + target.getName() + "has been crashed!");
                }
            }

            return false;
        }
    }
}
