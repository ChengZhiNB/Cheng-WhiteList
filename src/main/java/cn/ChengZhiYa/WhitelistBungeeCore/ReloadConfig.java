package cn.ChengZhiYa.WhitelistBungeeCore;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.ArrayList;
import java.util.List;

import static cn.ChengZhiYa.WhitelistBungeeCore.FileUltis.*;

public class ReloadConfig extends Command implements TabExecutor {
    public ReloadConfig() {
        super("WhiteList", "ChengWhiteList-Reload","wl");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            String Command = args[0];
            if (Command.equals("relaod")) {
                reloadConfig();
                main.main.getLogger().info("重载完成!");
                return;
            }
        }
        if (args.length == 2) {
            String Command = args[0];
            String PlayerName = args[1];
            if (Command.equals("add")) {
                List<String> WhiteList = getConfig().getStringList("WhiteList");
                if (WhiteList.contains(PlayerName)) {
                    main.main.getLogger().info("这个玩家已经有白名单了!");
                    return;
                }
                WhiteList.add(PlayerName);
                getConfig().set("WhiteList",WhiteList);
                saveConfig();
                reloadConfig();
                main.main.getLogger().info("添加成功!");
                return;
            }
            if (Command.equals("del")) {
                List<String> WhiteList = getConfig().getStringList("WhiteList");
                if (!WhiteList.contains(PlayerName)) {
                    main.main.getLogger().info("这个玩家没有白名单!");
                    return;
                }
                WhiteList.remove(PlayerName);
                getConfig().set("WhiteList",WhiteList);
                saveConfig();
                reloadConfig();
                main.main.getLogger().info("删除成功!");
                return;
            }
        }
        main.main.getLogger().info("-------------WhiteList-------------");
        main.main.getLogger().info("/wl reload - 重载插件配置");
        main.main.getLogger().info("/wl add <玩家ID> - 添加白名单");
        main.main.getLogger().info("/wl del <玩家ID> - 删除白名单");
        main.main.getLogger().info("-------------WhiteList-------------");

    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length == 1) {
            List<String> TabList = new ArrayList<>();
            TabList.add("reload");
            TabList.add("add");
            TabList.add("del");
            return TabList;
        }
        return null;
    }
}
