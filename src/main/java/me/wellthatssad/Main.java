package me.wellthatssad;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() { return instance; }



    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        this.getCommand("Link").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
