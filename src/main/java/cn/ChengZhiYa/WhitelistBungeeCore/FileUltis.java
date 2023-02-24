package cn.ChengZhiYa.WhitelistBungeeCore;

import com.google.common.base.Charsets;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;

public class FileUltis {
    static Configuration configuration;

    public static void saveDefaultConfig() {
        File DataFolder = main.main.getDataFolder();
        if (!DataFolder.exists()) {
            DataFolder.mkdir();
        }
        File file = new File(DataFolder, "config.yml");

        if (!file.exists()) {
            try (InputStream in = main.main.getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reloadConfig() {
        File DataFolder = main.main.getDataFolder();
        File file = new File(DataFolder, "config.yml");

        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveConfig() {
        File DataFolder = main.main.getDataFolder();
        File file = new File(DataFolder, "config.yml");
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration getConfig() {
        return configuration;
    }
}
