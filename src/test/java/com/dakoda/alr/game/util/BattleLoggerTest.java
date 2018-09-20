package com.dakoda.alr.game.util;
import com.dakoda.alr.game.world.entity.Entity;
import com.dakoda.alr.game.world.entity.entities.hostile.Hostile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BattleLoggerTest {

    private Entity entity1 = new Hostile() {
        @Override
        public String getName() {
            return "entity1";
        }
    };
    private Entity entity2 = new Hostile() {
        @Override
        public String getName() {
            return "entity2";
        }
    };

    @Test
    public void test_logDamage_twoEntities() {
        Assert.assertEquals(
                "entity1 dealt 1 damage to entity2",
                BattleLogger.logDamage(entity1, entity2, 1)
        );
    }

    @Test
    public void test_logDamage_oneEntity() {
        Assert.assertEquals(
                "entity2 took 1 damage",
                BattleLogger.logDamage(entity2, 1)
        );
    }

    @Test
    public void test_logHeal_oneEntity() {
        Assert.assertEquals(
                "entity2 healed themselves for 1 health",
                BattleLogger.logHeal(entity2, 1, "health")
        );
    }

    @Test
    public void test_logHeal_twoEntities() {
        Assert.assertEquals(
                "entity1 healed entity2 for 1 health",
                BattleLogger.logHeal(entity1, entity2, 1, "health")
        );
    }

    @Test
    public void test_logStatusPoison_oneEntity() {
        Assert.assertEquals(
                "entity1 has been inflicted with poison!",
                BattleLogger.logStatusPoison(entity1)
        );
    }

    @Test
    public void test_logStatusPoison_twoEntities() {
        Assert.assertEquals(
                "entity1 has been inflicted with poison by entity2!",
                BattleLogger.logStatusPoison(entity1, entity2)
        );
    }

    @Test
    public void test_logStatusFire_oneEntity() {
        Assert.assertEquals(
                "entity1 has been set on fire!",
                BattleLogger.logStatusFire(entity1)
        );
    }

    @Test
    public void test_logStatusFire_twoEntities() {
        Assert.assertEquals(
                "entity1 has been set on fire by entity2!",
                BattleLogger.logStatusFire(entity1, entity2)
        );
    }

    @Test
    public void test_logStatusSleep_oneEntity() {
        Assert.assertEquals(
                "entity1 has fallen into a deep sleep...",
                BattleLogger.logStatusSleep(entity1)
        );
    }

    @Test
    public void test_logStatusSleep_twoEntities() {
        Assert.assertEquals(
                "entity1 has been forced into a deep sleep by entity2",
                BattleLogger.logStatusSleep(entity1, entity2)
        );
    }

    @Test
    public void test_logStatusFreeze_oneEntity() {
        Assert.assertEquals(
                "entity1 has been frozen!",
                BattleLogger.logStatusFreeze(entity1)
        );
    }

    @Test
    public void test_logStatusFreeze_twoEntities() {
        Assert.assertEquals(
                "entity1 has been frozen by entity2",
                BattleLogger.logStatusFreeze(entity1, entity2)
        );
    }

    @Test
    public void test_logStatusMute_oneEntity() {
        Assert.assertEquals(
                "entity1 has been rendered mute; they can no longer use abilities!",
                BattleLogger.logStatusMute(entity1)
        );
    }

    @Test
    public void test_logStatusMute_twoEntities() {
        Assert.assertEquals(
                "entity1 has been rendered mute by entity2; they can no longer use abilities!",
                BattleLogger.logStatusMute(entity1, entity2)
        );
    }

    @Test
    public void test_logStatusClear_oneEntity() {
        Assert.assertEquals(
                "entity1 has been relieved of all status conditions",
                BattleLogger.logStatusClear(entity1)
        );
    }

    @Test
    public void test_logStatusClear_twoEntities() {
        Assert.assertEquals(
                "entity2 has relieved entity1 of all status conditions",
                BattleLogger.logStatusClear(entity1, entity2)
        );
    }

    @Test
    public void test_logDeath_oneEntityGeneric() {
        Assert.assertEquals(
                "entity1 has died!",
                BattleLogger.logDeath(entity1)
        );
    }
}
