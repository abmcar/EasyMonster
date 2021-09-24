package top.abmcar.easymonster.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import top.abmcar.easymonster.monster.MonsterLevel;

public class MonsterSpawnListener implements Listener {
    @EventHandler
    public void onCreatureSpawnMonster(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();
        EntityType entityType = entity.getType();
        if (entityType == EntityType.ZOMBIE)
            MonsterLevel.setLevel(entity,"僵尸");
        if (entityType == EntityType.BLAZE)
            MonsterLevel.setLevel(entity,"烈焰人");
        if (entityType == EntityType.CAVE_SPIDER)
            MonsterLevel.setLevel(entity,"洞穴蜘蛛");
        if (entityType == EntityType.CREEPER )
            MonsterLevel.setLevel(entity,"爬行者");
        if (entityType == EntityType.ENDERMAN )
            MonsterLevel.setLevel(entity,"末影人");
        if (entityType == EntityType.GHAST )
            MonsterLevel.setLevel(entity,"恶魂");
        if (entityType == EntityType.GUARDIAN)
            MonsterLevel.setLevel(entity,"守护者");
//        if (entityType == EntityType.MAGMA_CUBE)
//            MonsterLevel.setLevel(entity,"岩浆怪");
        if (entityType == EntityType.SILVERFISH)
            MonsterLevel.setLevel(entity,"蠹虫");
        if (entityType == EntityType.SKELETON )
            MonsterLevel.setLevel(entity,"骷髅");
//        if (entityType == EntityType.SLIME)
//            MonsterLevel.setLevel(entity,"史莱姆");
        if (entityType == EntityType.SNOWMAN)
            MonsterLevel.setLevel(entity,"雪人");
        if (entityType == EntityType.SPIDER)
            MonsterLevel.setLevel(entity,"蜘蛛");
        if (entityType == EntityType.WITCH)
            MonsterLevel.setLevel(entity,"女巫");
        if (entityType == EntityType.PIG_ZOMBIE)
            MonsterLevel.setLevel(entity,"僵尸猪人");
        if (entityType == EntityType.ZOMBIE_VILLAGER)
            MonsterLevel.setLevel(entity,"僵尸村民");
        if (entityType == EntityType.IRON_GOLEM)
            MonsterLevel.setLevel(entity,"铁傀儡");
        if (entityType.toString().contains("MAID_RINNOSUKE"))
            MonsterLevel.setLevel(entity, "森近霖之助");
        if (entityType.toString().contains("MAID_FAIRY"))
            MonsterLevel.setLevel(entity, "妖精");
    }
}
