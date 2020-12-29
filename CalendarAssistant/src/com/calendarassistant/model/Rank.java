package com.calendarassistant.model;

public enum Rank {
    CEO(0),
    COO(1),
    DIRECTOR(2),
    MANAGER(3);

    private final int value;

    Rank(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
