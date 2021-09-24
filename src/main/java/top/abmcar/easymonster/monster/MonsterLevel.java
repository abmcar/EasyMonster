package top.abmcar.easymonster.monster;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Witch;
import top.abmcar.easymonster.EasyMonster;
import top.abmcar.easymonster.config.ConfigData;

import java.util.Random;

public class MonsterLevel {

    public static void setLevel(LivingEntity entity, String typeName) {
        Random random = new Random();
        int randomLevel = random.nextInt(ConfigData.INSTANCE.MAX_LEVEL);
        int monsterHealth = ConfigData.INSTANCE.getHealth(randomLevel);
        int monsterDamage = ConfigData.INSTANCE.getDamage(randomLevel);
//        EasyMonster.getPlugin().getLogger().info(monsterHealth + " " + monsterDamage + " " + randomLevel);
        if (entity instanceof Witch) {
            monsterDamage *= 4;
            monsterHealth *= 4;
        }
        MonsterUtil.setHealth(entity,monsterHealth);
        MonsterUtil.setDamage(entity,monsterDamage);
        if (entity instanceof Slime) {
            ((Slime) entity).setSize(randomLevel);
        }

        MonsterUtil.setName(entity,typeName,randomLevel);
        entity.setHealth(monsterHealth);
        entity.setRemoveWhenFarAway(true);
        entity.addScoreboardTag("lv" + randomLevel);
    }
}
