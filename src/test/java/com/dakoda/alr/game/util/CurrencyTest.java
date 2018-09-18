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

    @Test
    public void test_convertToUnits_allUnits() {
        StringBuilder result = new StringBuilder();
        for (Currency.Unit unit : Currency.Unit.values()) {
            if (unit.ordinal() != 0) {
                result.insert(0, ", ");
            }
            result.insert(0, unit.name().toLowerCase()).insert(0, "1 ");
        }
        int compare = 0;
        for (Currency.Unit unit : Currency.Unit.values()) {
            compare += unit.value();
        }
        Assert.assertEquals(
                result.toString(),
                Currency.convertToUnits(compare)
        );
    }
}

