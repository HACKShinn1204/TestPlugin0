package testplugin0.testplugin0;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AllPlayerKick extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private String PREFIX = ChatColor.DARK_GREEN + "[" + ChatColor.AQUA + "AllPlayerKicker" + ChatColor.DARK_GREEN + "]";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("allkick")) {
            if (!sender.hasPermission("allkick.use")) {
                sender.sendMessage(ChatColor.RED + PREFIX + ChatColor.RED + "権限がありません。");
                return true;
            }
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (!all.hasPermission("allkick.ignore") || !all.isOp()) {
                    all.kickPlayer(ChatColor.translateAlternateColorCodes('&', args[0]).replaceAll("%n", "\n"));
                }
                sender.sendMessage(PREFIX + ChatColor.GREEN + "OP(Permissio)持ち以外を全員Kickしました。");
            }
        }
        return false;
    }
}