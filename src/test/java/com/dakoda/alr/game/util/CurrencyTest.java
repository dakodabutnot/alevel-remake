package com.dakoda.alr.game.util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CurrencyTest {

    @Test
    public void test_convertToUnits_singleUnit() {
        for (Currency.Unit unit : Currency.Unit.values()) {
            Assert.assertEquals(
                    "1 " + unit.name().toLowerCase(),
                    Currency.convertToUnits(unit.value()));
        }
    }
}
