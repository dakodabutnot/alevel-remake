package com.dakoda.alr.game.mechanic;

public interface Currency {

    /**
     * Divides a given number into the minimum amount of monetary units. Dependent on the Unit enum within the same class.
     * Stylised based on this current context using StringBuilder.
     * @param amount number to convert
     * @return A string explaining the monetary makeup of the number as defined in the Unit enum.
     */
    static String convertToUnits(long amount) {

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

    /**
     * Defines preset names for each monetary value. The first element must have a value of 1.
     * The values of those thereafter define the worth of each element in relation to the first element.
     */
    public enum Unit {

        COPPER(1),
        SILVER(50),
        GOLD(1000),
        PLATINUM(500_000),

        ;

        private final long minimumValue;

        Unit(
                long minimumValue
        ) {
            this.minimumValue = minimumValue;
        }

        public long value() {
            return minimumValue;
        }
    }

    /**
     * Inverts (reverses) a given array.
     * @param array The Unit[] array to be inverted (reversed).
     * @return The reversed Unit[] array.
     */
    static Unit[] invertArray(Unit[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Unit temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
