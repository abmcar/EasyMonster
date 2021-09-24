package top.abmcar.easymonster.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;
import top.abmcar.easymonster.config.ConfigData;
import top.abmcar.easymonster.monster.MonsterUtil;

public class ProjectileHitListener implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        Entity hitEntity = event.getHitEntity();
        ProjectileSource shooter = projectile.getShooter();
        if (shooter instanceof LivingEntity) {
            if (shooter instanceof Monster || shooter instanceof Snowman) {
                LivingEntity entity = (LivingEntity) shooter;
                int nowLevel = MonsterUtil.getLevel(entity);
                if (nowLevel == -1)
                    return;
                if (hitEntity instanceof LivingEntity) {
                    ((LivingEntity) hitEntity).damage(ConfigData.INSTANCE.getDamage(nowLevel),entity);
                }
            }
        }
    }
}
