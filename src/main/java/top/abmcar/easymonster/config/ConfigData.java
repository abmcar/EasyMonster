package top.abmcar.easymonster.config;

import org.bukkit.configuration.file.YamlConfiguration;
import top.abmcar.easymonster.EasyMonster;

import java.util.List;

public class ConfigData {
    public static ConfigData INSTANCE = new ConfigData();

    private ConfigData() {}

    private YamlConfiguration config = ConfigUtil.loadYaml(EasyMonster.getPlugin(), "config.yml");

    public YamlConfiguration getConfigYaml() {
        return config;
    }

    public void setConfigYaml(YamlConfiguration config) {
        this.config = config;
    }

    public Integer MAX_LEVEL = config.getInt("MaxLevel");

    public Integer ADD_HEALTH = config.getInt("AddHealth");

    public Integer ADD_DAMAGE = config.getInt("AddDamage");

    public Integer getHealth(int level) {
        return config.getInt(level + ".health");
    }

    public Integer getDamage(int level) {
        return config.getInt(level + ".damage");
    }

    public Integer getExp(int level) {
        return config.getInt(level + ".exp");
    }

    public Integer getMoney(int level) {
        return config.getInt(level + ".money");
    }


    public void reload() {

    }
}
