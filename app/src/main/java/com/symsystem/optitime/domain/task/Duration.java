package com.symsystem.optitime.domain.task;

/**
 * @author pierre
 */

public class Duration {

    private final int min;
    private final int hours;

    public Duration(int min, int hours) {
        this.min = min;
        this.hours = hours;
    }

    public Duration setHours(int hours) {
        return new Duration(min, hours);
    }

    public Duration setMins(int min) {
        return new Duration(min, hours);
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }
}
