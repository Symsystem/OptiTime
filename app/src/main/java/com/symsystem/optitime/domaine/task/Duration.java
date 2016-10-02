package com.symsystem.optitime.domaine.task;

/**
 * Created by Pierre on 02/10/2016.
 */

public class Duration {

    private int min;
    private int hours;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMins(int min) {
        this.min = min;
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }
}
