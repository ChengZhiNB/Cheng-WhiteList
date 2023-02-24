package cn.ChengZhiYa.WhitelistBungeeCore;

import net.md_5.bungee.api.plugin.Plugin;

import static cn.ChengZhiYa.WhitelistBungeeCore.FileUltis.*;

public final class main extends Plugin {

    public static main main;

    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        saveDefaultConfig();
        reloadConfig();

        getProxy().getPluginManager().registerCommand(this,new ReloadConfig());
        getProxy().getPluginManager().registerListener(this,new PostLogin_Event());
        getLogger().info("白名单已开启! 作者:292200693");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        main = null;
        getLogger().info("白名单已关闭! 作者:292200693");
    }
}
