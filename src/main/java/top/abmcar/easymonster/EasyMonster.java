package top.abmcar.easymonster;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import top.abmcar.easymonster.config.Config;
import top.abmcar.easymonster.config.ConfigUtil;
import top.abmcar.easymonster.listener.MonsterDeathListener;
import top.abmcar.easymonster.listener.MonsterSpawnListener;
import top.abmcar.easymonster.listener.OtherDamageListener;
import top.abmcar.easymonster.listener.ProjectileHitListener;

public final class EasyMonster extends JavaPlugin {
    private static Plugin plugin;
    private Config config;

    @Override
    public void onEnable() {
        plugin = this;
        this.config = ConfigUtil.loadConfig(plugin, "config.yml");
        Bukkit.getPluginManager().registerEvents(new MonsterSpawnListener(), this);
        Bukkit.getPluginManager().registerEvents(new MonsterDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProjectileHitListener(), this);
        Bukkit.getPluginManager().registerEvents(new OtherDamageListener(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        ConfigUtil.saveFile(config);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}

