package testplugin0.testplugin0;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "あなたは権限がありません");
            return true;
        }

        final Player p = (Player) sender;

        if (p.getAllowFlight())
        {
            p.setAllowFlight(false);
            sender.sendMessage(ChatColor.RED + "Flyを無効化しました");
            return true;
        }

        sender.sendMessage(ChatColor.GREEN + "Flyを有効化しました");
        p.setAllowFlight(true);

        return true;
    }
}
