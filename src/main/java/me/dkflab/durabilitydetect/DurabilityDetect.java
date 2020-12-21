package me.dkflab.durabilitydetect;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DurabilityDetect extends JavaPlugin {
    private static DurabilityDetect instance;
    public void onEnable () {
        System.out.println("DurabilityDetect Starting");
        instance = this;
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new MiningListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
        this.saveDefaultConfig();
    }
    public void onDisable() {
        System.out.println("DurabilityDetect has been disabled");
    }

    static DurabilityDetect getInstance() {
        return instance;
    }

}
