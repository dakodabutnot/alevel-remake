package com.dakoda.alr.game.structure;

public interface Currency {

    static String convertToCSG(long amount) {

        long amountToConvert = amount;
        StringBuilder returned = new StringBuilder();
        boolean previousExists = false;
        for (Unit unit : invertArray(Unit.values())) {
            if (amountToConvert >= unit.value()) {
                long div = amountToConvert / unit.value();
                if (div > 0L) {
                    if (previousExists) returned.append(", ");
                    returned.append(div).append(" ").append(unit.name().toLowerCase());
                    previousExists = true;
                }
                amountToConvert %= unit.value();
            }
        }
        return returned.toString();
    }

    enum Unit {

        COPPER(1L),
        SILVER(50L),
        GOLD(1000L),
        PLATINUM(500_000L),

        ;

        private final long copperValue;

        Unit(
                long copperValue
        ) {
            this.copperValue = copperValue;
        }

        public long value() {
            return copperValue;
        }
    }

    static Unit[] invertArray(Unit[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Unit temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
