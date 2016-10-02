package com.symsystem.optitime.domaine.task;

/**
 * Created by Pierre on 02/10/2016.
 */

public class Date {


    private java.util.Date myDate;
    private int millis;

    public Date (){

        myDate = new java.util.Date( );

    }

    public void setMillis(int millis) {
        this.millis = millis;
    }

    public java.util.Date getMyDate() {
        return myDate;
    }
}
