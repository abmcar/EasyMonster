package top.abmcar.easymonster.monster;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import top.abmcar.easymonster.EasyMonster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MonsterUtil {
//    Class<?> class = this.getClass();
//    this.class();
//    this.getClass();
    public static void setHealth(LivingEntity entity, Integer health) {
//        List<String> list = new ArrayList<String>();
//        list.add("生命力" + health);
//        this.getClass();
//        AttributeData attributeData = AttributeAPI.getAttrData(entity);
//        AttributeData attributeData = new AttributeData(list);
//        ExAttributeAPI.getHandleApi().addAttribute(entity, EasyMonster.getPlugin().getClass(), attributeData);
//        AttributeAPI.addSourceAttribute(attributeData,"EasyMonster", list, false);
        AttributeInstance attributeInstance = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attributeInstance.setBaseValue(1.0 + health);
    }

    public static void setDamage(LivingEntity entity, Integer damage) {
//        List<String> list = new ArrayList<String>();
//        list.add("物理伤害" + damage);
//        AttributeData attributeData = AttributeAPI.getAttrData(entity);
//        AttributeAPI.addSourceAttribute(attributeData,"EasyMonster", list, false);.
//        AttributeData attributeData = new AttributeData(list);
//        ExAttributeAPI.getHandleApi().addAttribute(entity, EasyMonster.getPlugin().getClass(), attributeData);
        try {
            AttributeInstance attributeInstance = entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
            attributeInstance.setBaseValue(1.0 + damage);
        } catch (Exception e) {
            EasyMonster.getPlugin().getLogger().info(entity.getType().toString());
        }
    }

    public static void setName(LivingEntity entity, String typeName, Integer level) {
        entity.setCustomName("§b[" + level + "级]§f " + typeName);
        entity.setCustomNameVisible(true);
    }

    public static Integer getLevel(LivingEntity entity) {
        Set<String> set = entity.getScoreboardTags();
        for (String tag : set)
            if (tag.contains("lv")) {
                tag = tag.replace("lv", "");
                return Integer.parseInt(tag);
            }
        return -1;
    }
}
