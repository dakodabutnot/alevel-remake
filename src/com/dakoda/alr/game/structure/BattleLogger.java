package com.dakoda.alr.game.structure;
import com.dakoda.alr.world.entity.Entity;

public interface BattleLogger {

    static String logDamage(Entity damager, Entity damagee, long amount) {
        return damager.getName() + " dealt " + amount + " damage to " + damagee.getName();
    }

    static String logDamage(Entity entity, long amount) {
        return entity.getName() + " took " + amount + " damage";
    }

    static String logHeal(Entity entity, long amount, String healStat) {
        return entity.getName() + " healed themselves for " + amount + " " + healStat.toLowerCase();
    }

    static String logHeal(Entity healer, Entity healee, long amount, String healStat) {
        return healer.getName() + " healed " + healee.getName() + " for " + amount + " " + healStat.toLowerCase();
    }

    static String logStatusPoison(Entity entity) {
        return entity.getName() + " has been inflicted with poison!";
    }

    static String logStatusPoison(Entity entity, Entity dealer) {
        return entity.getName() + " has been inflicted with poison from " + dealer.getName() + "!";
    }

    static String logStatusFire(Entity entity) {
        return entity.getName() + " has been set on fire!";
    }

    static String logStatusFire(Entity entity, Entity dealer) {
        return entity.getName() + " has been set on fire by " + dealer.getName() + "!";
    }

    static String logStatusSleep(Entity entity) {
        return entity.getName() + " has fallen into a deep sleep...";
    }

    static String logStatusSleep(Entity entity, Entity dealer) {
        return entity.getName() + " has been forced into a deep sleep by " + dealer.getName();
    }

    static String logStatusFreeze(Entity entity) {
        return entity.getName() + " has been frozen!";
    }

    static String logStatusFreeze(Entity entity, Entity dealer) {
        return entity.getName() + " has been frozen by " + dealer.getName();
    }

    static String logStatusMute(Entity entity) {
        return entity.getName() + " has been rendered mute; they can no longer use abilities!";
    }

    static String logStatusMute(Entity entity, Entity dealer) {
        return entity.getName() + " has been rendered mute by " + dealer.getName() + "; they can no longer use abilities!";
    }

    static String logStatusClear(Entity entity) {
        return entity.getName() + " has been relieved of all status conditions";
    }

    static String logStatusClear(Entity entity, Entity dealer) {
        return dealer.getName() + " has relieved " + entity.getName() + " of all status conditions";
    }

    static String logDeath(Entity entity) {
        return entity.getName() + " has died!";
    }
}
