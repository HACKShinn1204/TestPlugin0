

package testplugin0.testplugin0;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin0 extends JavaPlugin implements Listener {
    private Listeners listeners;

    public static JavaPlugin plugin;

    public static JavaPlugin getPlugin()
    {return plugin;};

    public void onEnable() {

        plugin = this;

        this.getLogger().info("プラグインが起動しました");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("reboot").setExecutor(new text());
        this.getCommand("crasher").setExecutor(new Crasher());
        this.listeners = new Listeners();
        Bukkit.getPluginManager().registerEvents(this.listeners,this);



        super.onEnable();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.YELLOW + p.getName() + "がサーバーに参加しました ようこそサーバーへ");
    }

    public void onDisable() {
        this.getLogger().info("プラグインが停止しました");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if (command.getName().equalsIgnoreCase("")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "このプラグインではプレイヤーでなければ実行できません");
                return true;
            } else {
                player = (Player)sender;
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.GREEN + "サバイバルでも飛べるようになりました");
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("medic")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "このプラグインではプレイヤーでなければ実行できません");
                return true;
            } else {
                player = (Player)sender;
                player.setHealth(20.0D);
                player.sendMessage(ChatColor.GREEN + "回復完了");
                return true;
            }
        } else {
            return true;
        }
    }
}
