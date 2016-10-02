package com.symsystem.optitime.domaine.task;

/**
 * Created by Pierre on 02/10/2016.
 */

public class Task {

    private TaxId myTaxId;
    private Date myLimiteDate;
    private Duration myDuration;
    private String myName;
    private State myState;
    private Priority myPriority;

    public void setlimiteDate(Date myLimiteDate) {
        this.myLimiteDate = myLimiteDate;
    }

    public void setName(String myName) {
        this.myName = myName;
    }

    public void setDuration(Duration myDuration) {
        this.myDuration = myDuration;
    }

    public void setTaxId(TaxId myTaxId) {
        this.myTaxId = myTaxId;
    }

    public void setState(State myState) {
        this.myState = myState;
    }

    public void priority(Priority myPriority) {
        this.myPriority = myPriority;
    }

    public String name() {
        return myName;
    }

    public State state(){
        return myState;
    }

    public Priority priority() {
        return myPriority;
    }

    public Duration duration() {
        return myDuration;
    }


}
