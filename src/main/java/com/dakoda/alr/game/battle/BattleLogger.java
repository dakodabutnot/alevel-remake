package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.world.entity.Entity;

public interface BattleLogger {

    /**
     * Logs damage done to an entity.
     * @param damager The entity dealing the damage.
     * @param damagee The entity taking the damage.
     * @param amount The amount of damage done.
     * @return String representing damage done to an entity by another.
     */
    static String logDamage(Entity damager, Entity damagee, long amount) {
        return damager.name() + " dealt " + amount + " damage to " + damagee.name();
    }

    /**
     * Logs damage done to an entity.
     * @param entity The entity taking the damage.
     * @param amount The amount of damage done.
     * @return String representing damage done to an entity.
     */
    static String logDamage(Entity entity, long amount) {
        return entity.name() + " took " + amount + " damage";
    }

    /**
     * Logs healing done to an entity.
     * @param entity The entity being healed.
     * @param amount The amount of healing done.
     * @param healStat The stat being healed.
     * @return String representing healing done to an entity.
     */
    static String logHeal(Entity entity, long amount, String healStat) {
        return entity.name() + " healed themselves for " + amount + " " + healStat.toLowerCase();
    }

    /**
     * Logs healing done to an entity.
     * @param healer The entity doing the healing.
     * @param healee The entity receiving the healing.
     * @param amount The amount of healing done.
     * @param healStat The stat being healed.
     * @return String representing healing done to an entity by another.
     */
    static String logHeal(Entity healer, Entity healee, long amount, String healStat) {
        return healer.name() + " healed " + healee.name() + " for " + amount + " " + healStat.toLowerCase();
    }

    /**
     * Logs poison being inflicted on an entity.
     * @param entity The entity being poisoned.
     * @return String representing an entity being poisoned.
     */
    static String logStatusPoison(Entity entity) {
        return entity.name() + " has been inflicted with poison!";
    }

    /**
     * Logs poison being inflicted on an entity by another.
     * @param entity The entity being poisoned.
     * @param dealer The entity poisoning the other.
     * @return String representing an entity being poisoned by another.
     */
    static String logStatusPoison(Entity entity, Entity dealer) {
        return entity.name() + " has been inflicted with poison by " + dealer.name() + "!";
    }

    /**
     * Logs an entity being set on fire.
     * @param entity The entity being set on fire.
     * @return String representing an entity being set on fire.
     */
    static String logStatusFire(Entity entity) {
        return entity.name() + " has been set on fire!";
    }

    /**
     * Logs an entity being set on fire.
     * @param entity The entity being set on fire.
     * @param dealer The entity setting the other on fire.
     * @return String representing an entity being set on fire by another.
     */
    static String logStatusFire(Entity entity, Entity dealer) {
        return entity.name() + " has been set on fire by " + dealer.name() + "!";
    }

    /**
     * Logs an entity falling asleep.
     * @param entity The entity falling asleep.
     * @return String representing an entity falling asleep.
     */
    static String logStatusSleep(Entity entity) {
        return entity.name() + " has fallen into a deep sleep...";
    }

    /**
     * Logs an entity being put to sleep.
     * @param entity The entity being put to sleep.
     * @param dealer The entity putting the other to sleep.
     * @return String representing an entity being put to sleep by another.
     */
    static String logStatusSleep(Entity entity, Entity dealer) {
        return entity.name() + " has been forced into a deep sleep by " + dealer.name();
    }

    /**
     * Logs an entity being frozen.
     * @param entity The entity being frozen.
     * @return String representing an entity being frozen.
     */
    static String logStatusFreeze(Entity entity) {
        return entity.name() + " has been frozen!";
    }

    /**
     * Logs an entity being frozen.
     * @param entity The entity being frozen.
     * @param dealer The entity freezing the other.
     * @return String representing an entity being frozen by another.
     */
    static String logStatusFreeze(Entity entity, Entity dealer) {
        return entity.name() + " has been frozen by " + dealer.name();
    }

    /**
     * Logs an entity being muted.
     * @param entity The entity being muted.
     * @return String representing an entity being muted.
     */
    static String logStatusMute(Entity entity) {
        return entity.name() + " has been rendered mute; they can no longer use abilities!";
    }

    /**
     * Logs an entity being muted.
     * @param entity The entity being muted.
     * @param dealer The entity muting the other.
     * @return String representing an entity being muted by another.
     */
    static String logStatusMute(Entity entity, Entity dealer) {
        return entity.name() + " has been rendered mute by " + dealer.name() + "; they can no longer use abilities!";
    }

    /**
     * Logs an entity having all status conditions removed.
     * @param entity The entity having all status conditions removed.
     * @return String representing an entity having all status conditions removed.
     */
    static String logStatusClear(Entity entity) {
        return entity.name() + " has been relieved of all status conditions";
    }

    /**
     * Logs an entity having all status conditions removed.
     * @param entity The entity having all status conditions removed.
     * @param dealer The entity removing all status conditions from the other.
     * @return String representing an entity having all status conditions removed by another.
     */
    static String logStatusClear(Entity entity, Entity dealer) {
        return dealer.name() + " has relieved " + entity.name() + " of all status conditions";
    }

    /**
     * Logs an entity dying.
     * @param entity The entity dying.
     * @return String representing an entity dying by any cause.
     */
    static String logDeath(Entity entity) {
        return entity.name() + " has died!";
    }
}
