package top.abmcar.easymonster.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;
import top.abmcar.easymonster.config.ConfigData;
import top.abmcar.easymonster.monster.MonsterUtil;

public class OtherDamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();
        if (entity instanceof LivingEntity) {
            if (entity instanceof Monster) {
                LivingEntity creeper = (LivingEntity) entity;
                int nowLevel = MonsterUtil.getLevel(creeper);
                if (nowLevel == -1)
                    return;
                event.setDamage(ConfigData.INSTANCE.getDamage(nowLevel));
            }
        }
    }
}
