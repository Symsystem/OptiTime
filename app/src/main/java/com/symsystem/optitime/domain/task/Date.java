package com.symsystem.optitime.domain.task;

import java.util.Calendar;

/**
 * @author pierre
 */

public final class Date {

    private final Calendar calendar;

    public Date(Calendar calendar){
        this.calendar = calendar;
    }

    public int day() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int month() {
        return calendar.get(Calendar.MONTH);
    }

    public int year() {
        return calendar.get(Calendar.YEAR);
    }

    public long date() {
        return calendar.getTimeInMillis();
    }
}
