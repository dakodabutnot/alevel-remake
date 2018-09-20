package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.world.item.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LootTest {

    @Test
    public void test_builder() {
        Item testingItem = Items.Consumable.APPLE.get();
        Integer testingInteger = 2;
        Loot loot = new Loot.Builder()
                .drop(testingItem, testingInteger)
                .build();
        Assert.assertNotNull(loot);
        Assert.assertTrue(loot.getDrops().containsKey(testingItem));
        Assert.assertTrue(loot.getDrops().containsValue(testingInteger));
    }
}
