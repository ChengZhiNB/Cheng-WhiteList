package cn.ChengZhiYa.WhitelistBungeeCore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static cn.ChengZhiYa.WhitelistBungeeCore.FileUltis.*;

public class PostLogin_Event implements Listener {
    @EventHandler
    public void On_Event(PostLoginEvent event) {
        ProxiedPlayer player = event.getPlayer();
        String PlayerIP = player.getSocketAddress().toString().substring(0,player.getSocketAddress().toString().indexOf(":"));
        for (String WhiteListName : getConfig().getStringList("WhiteList")) {
            if (player.getName().equals(WhiteListName)) {
                return;
            }
        }

        if (Int_HashMap.Get( PlayerIP + "_KickTimes") == null) {
            Int_HashMap.Set( PlayerIP + "_KickTimes",0);
        }

        if (Int_HashMap.Get( PlayerIP + "_KickTimes") >= 3) {
            player.disconnect(TextComponent.fromLegacyText("Time out"));
            return;
        }

        if (player.getName().contains("LOL") && player.getName().contains("FW") && player.getName().contains("LOLFWXK_")) {
            player.disconnect(TextComponent.fromLegacyText("Time out"));
            return;
        }

        player.disconnect(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&e专线系统\n&c您的ID不能使用这个线路！")));
        Int_HashMap.Set(PlayerIP + "_KickTimes", Int_HashMap.Get(PlayerIP + "_KickTimes")+1);
    }
}
