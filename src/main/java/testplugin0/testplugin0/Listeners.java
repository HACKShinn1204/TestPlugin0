package testplugin0.testplugin0;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.graalvm.compiler.phases.common.inlining.policy.GreedyInliningPolicy;

public class Listeners implements Listener {

    @EventHandler
    public void onChatPrefixAdmins(AsyncPlayerChatEvent e) {

        e.setCancelled(true);
        if (e.getPlayer().isOp())
        {
            Bukkit.broadcastMessage(ChatColor.RED + "[Admin] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GREEN + ": " + ChatColor.WHITE + e.getMessage());
        }
        else
        {
            Bukkit.broadcastMessage(e.getPlayer().getName() + ChatColor.GREEN + ": " + ChatColor.WHITE + e.getMessage());
        }
    }
    @EventHandler
    public void onPlayerPlaceEvent(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TNT) {
            e.setCancelled(true);
        }
    }
}
