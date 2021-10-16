package top.abmcar.easymonster.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import top.abmcar.easymonster.EasyMonster;
import top.abmcar.easymonster.config.ConfigData;
import top.abmcar.easymonster.monster.MonsterUtil;
import top.abmcar.easyvar.EasyVar;


public class MonsterDeathListener implements Listener {
    @EventHandler
    public void onMonsterDeath(EntityDeathEvent event) {
        if (EasyMonster.EasyVar == null)
            return;
        LivingEntity entity = event.getEntity();
        Integer nowLevel = MonsterUtil.getLevel(entity);
        if (nowLevel != -1) {
            event.setDroppedExp(ConfigData.INSTANCE.getExp(nowLevel));
            if (entity.getKiller().getType() == EntityType.PLAYER) {
                Player player = entity.getKiller();
                EasyVar.getVarManager().addPlayerValue(player.getName(), "killPoint", ConfigData.INSTANCE.getMoney(nowLevel));
                EasyMonster.getPlugin().getLogger().info(ConfigData.INSTANCE.getMoney(nowLevel).toString());
            }

        }
    }
}
