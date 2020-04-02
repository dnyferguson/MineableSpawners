package com.dnyferguson.mineablespawners.utils;

import com.dnyferguson.mineablespawners.MineableSpawners;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationHandler {
    private Map<String, Map<String, String>> messages = new HashMap<>();
    private Map<String, Map<String, Boolean>> booleans = new HashMap<>();
    private Map<String, Map<String, List<String>>> lists = new HashMap<>();

    public ConfigurationHandler(MineableSpawners plugin) {
        FileConfiguration config = plugin.getConfig();
        globalSection(config);
        mainSection(config);
        giveSection(config);
        setSection(config);
    }

    private void globalSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();
        Map<String, List<String>> lst = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("global");

        msgs.put("name", section.getString("display.name"));

        lst.put("lore", section.getStringList("display.lore"));

        bools.put("lore-enabled", section.getBoolean("display.lore-enabled"));

        messages.put("global", msgs);
        lists.put("global", lst);
        booleans.put("global", bools);
    }

    private void mainSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("main");

        msgs.put("title", section.getString("helpmessage.title"));
        msgs.put("give", section.getString("helpmessage.give"));
        msgs.put("set", section.getString("helpmessage.set"));
        msgs.put("types", section.getString("helpmessage.types"));

        messages.put("main", msgs);
    }

    private void giveSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("give");

        msgs.put("no-permission", section.getString("messages.no-permission"));
        msgs.put("player-does-not-exist", section.getString("messages.player-does-not-exist"));
        msgs.put("invalid-type", section.getString("messages.invalid-type"));
        msgs.put("invalid-amount", section.getString("messages.invalid-amount"));
        msgs.put("inventory-full", section.getString("messages.inventory-full"));
        msgs.put("success", section.getString("messages.success"));
        msgs.put("received", section.getString("messages.received"));

        bools.put("require-permission", section.getBoolean("require-permission"));

        messages.put("give", msgs);
        booleans.put("give", bools);
    }

    private void setSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("set");

        msgs.put("no-permission", section.getString("messages.no-permission"));

        bools.put("require-permission", section.getBoolean("require-permission"));

        messages.put("set", msgs);
        booleans.put("set", bools);
    }

    public List<String> getList(String section, String key) {
        return lists.get(section).get(key);
    }

    public String getMessage(String section, String key) {
        return Chat.format(messages.get(section).get(key));
    }

    public boolean getBoolean(String section, String key) {
        return booleans.get(section).get(key);
    }
}
