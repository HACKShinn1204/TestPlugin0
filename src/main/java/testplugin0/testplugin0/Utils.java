package testplugin0.testplugin0;

import java.util.concurrent.TimeUnit;
import org.bukkit.ChatColor;

public class Utils {
    public Utils() {
    }

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static boolean check(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void delay(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep((long)milliseconds);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }
}
