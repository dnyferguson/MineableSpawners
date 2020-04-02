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
    private Map<String, Map<String, Double>> doubles = new HashMap<>();
    private Map<String, Map<String, Integer>> integers = new HashMap<>();

    public ConfigurationHandler(MineableSpawners plugin) {
        FileConfiguration config = plugin.getConfig();
        reload(config);
    }

    public void reload(FileConfiguration config) {
        globalSection(config);
        mainSection(config);
        giveSection(config);
        setSection(config);
        typesSection(config);
        anvilSection(config);
        eggsSection(config);
        explodeSection(config);
        miningSection(config);
        placingSection(config);
    }

    private void placingSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();
        ConfigurationSection section = config.getConfigurationSection("placing");

        bools.put("log", section.getBoolean("log"));

        messages.put("placing", msgs);
        booleans.put("placing", bools);
    }

    private void miningSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();
        Map<String, Double> dbls = new HashMap<>();
        Map<String, List<String>> lsts = new HashMap<>();
        Map<String, Integer> ints = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("mining");

        msgs.put("blacklisted", section.getString("messages.blacklisted"));
        msgs.put("no-permission", section.getString("messages.no-permission"));
        msgs.put("no-silktouch", section.getString("messages.no-silktouch"));
        msgs.put("not-level-required", section.getString("messages.not-level-required"));
        msgs.put("inventory-full", section.getString("messages.inventory-full"));
        msgs.put("still-break", section.getString("messages.still-break"));
        msgs.put("requirements.permission", section.getString("messages.requirements.permission"));
        msgs.put("requirements.silktouch", section.getString("messages.requirements.silktouch"));
        msgs.put("requirements.silktouch-level", section.getString("messages.requirements.silktouch-level"));

        lsts.put("blacklisted-worlds", section.getStringList("blacklisted-worlds"));

        bools.put("drop-exp", section.getBoolean("drop-exp"));
        bools.put("require-permission", section.getBoolean("require-permission"));
        bools.put("require-silktouch", section.getBoolean("require-silktouch"));
        bools.put("require-silktouch-level", section.getBoolean("require-silktouch-level"));
        bools.put("drop-to-inventory", section.getBoolean("drop-to-inventory"));
        bools.put("still-break", section.getBoolean("still-break"));

        ints.put("required-level", section.getInt("required-level"));

        dbls.put("chance", section.getDouble("chance"));

        messages.put("mining", msgs);
        booleans.put("mining", bools);
        doubles.put("mining", dbls);
        lists.put("mining", lsts);
        integers.put("mining", ints);
    }

    private void explodeSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();
        Map<String, Double> dbls = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("explode");

        bools.put("drop", section.getBoolean("drop"));

        dbls.put("chance", section.getDouble("chance"));

        messages.put("explode", msgs);
        booleans.put("explode", bools);
        doubles.put("explode", dbls);
    }

    private void eggsSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("eggs");

        msgs.put("no-permission", section.getString("messages.no-permission"));
        msgs.put("no-individual-permission", section.getString("messages.no-individual-permission"));
        msgs.put("already-type", section.getString("messages.already-type"));
        msgs.put("success", section.getString("messages.success"));

        bools.put("require-permission", section.getBoolean("require-permission"));
        bools.put("require-individual-permission", section.getBoolean("require-individual-permission"));

        messages.put("eggs", msgs);
        booleans.put("eggs", bools);
    }

    private void anvilSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("anvil");

        msgs.put("prevented", section.getString("messages.prevented"));

        bools.put("prevent-anvil", section.getBoolean("prevent-anvil"));

        messages.put("anvil", msgs);
        booleans.put("anvil", bools);
    }

    private void globalSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();
        Map<String, List<String>> lsts = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("global");

        msgs.put("name", section.getString("display.name"));

        lsts.put("lore", section.getStringList("display.lore"));

        bools.put("lore-enabled", section.getBoolean("display.lore-enabled"));

        messages.put("global", msgs);
        lists.put("global", lsts);
        booleans.put("global", bools);
    }

    private void mainSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("main");

        msgs.put("title", section.getString("helpmessage.title"));
        msgs.put("give", section.getString("helpmessage.give"));
        msgs.put("set", section.getString("helpmessage.set"));
        msgs.put("types", section.getString("helpmessage.types"));
        msgs.put("reload", section.getString("helpmessage.reload"));

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
        Map<String, List<String>> lsts = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("set");

        msgs.put("no-permission", section.getString("messages.no-permission"));
        msgs.put("no-individual-permission", section.getString("messages.no-individual-permission"));
        msgs.put("invalid-type", section.getString("messages.invalid-type"));
        msgs.put("not-looking-at", section.getString("messages.not-looking-at"));
        msgs.put("already-type", section.getString("messages.already-type"));
        msgs.put("success", section.getString("messages.success"));
        msgs.put("blacklisted", section.getString("messages.blacklisted"));

        bools.put("require-permission", section.getBoolean("require-permission"));
        bools.put("require-individual-permission", section.getBoolean("require-individual-permission"));

        lsts.put("blacklisted-worlds", section.getStringList("blacklisted-worlds"));

        messages.put("set", msgs);
        booleans.put("set", bools);
    }

    private void typesSection(FileConfiguration config) {
        Map<String, String> msgs = new HashMap<>();
        Map<String, Boolean> bools = new HashMap<>();

        ConfigurationSection section = config.getConfigurationSection("types");

        msgs.put("no-permission", section.getString("messages.no-permission"));
        msgs.put("title", section.getString("messages.title"));
        msgs.put("entries", section.getString("messages.entries"));

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

    public double getDouble(String section, String key) {
        return doubles.get(section).get(key);
    }

    public int getInteger(String section, String key) {
        return integers.get(section).get(key);
    }
}
