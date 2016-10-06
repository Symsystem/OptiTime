package com.symsystem.optitime.domain.template;

import com.symsystem.optitime.domain.State;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.domain.task.Date;
import com.symsystem.optitime.domain.task.Duration;
import com.symsystem.optitime.domain.task.TaskId;

/**
 * @author sym
 *
 * A Tzmplate is a mutable object that represents a Template of a task
 *
 * @specfield id : TaskId        // The id of the task.
 * @specfield name : String      // The name that labels and describes the task.
 * @specfield limitDate : Date   // The end date where the task should be done
 * @sepcfield duration : Duration   // The amount of time the task is expected
 *                                      to take.
 * @specfield state : State      // The current state which the task is in.
 * @specfield priority : Priority   // The priority of the task
 * @specfield location : Location   // The place where a task should be done.
 *
 * @invariant id not null
 * @invariant name not null and not empty String
 */

public final class Template {

    private final TemplateId templateId;

    private String name;
    private Date limiteDate;
    private Duration duration;
    private State currentState;
    private PriorityId priority;
    private LocationId location;

    public Template(TemplateId id, String name) {
        this.templateId = id;
        this.name = name;
        this.currentState = State.TODO;
    }

    public void setlimiteDate(Date date) {
        limiteDate = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void priority(PriorityId priority) {
        this.priority = priority;
    }

    /**
     * @return the id of the task
     */
    public TemplateId templateId() {
        return templateId;
    }

    /**
     * @return the name of the task
     */
    public String name() {
        return name;
    }

    /**
     * @return the duration of the task
     */
    public Duration duration() {
        return duration;
    }

    /**
     * @return the current state of the task
     */
    public State state(){
        return currentState;
    }

    /**
     * @return the id of the priority of the task
     */
    public PriorityId priority() {
        return priority;
    }

    /**
     * @return the id of the location where to do the task
     */
    public LocationId location() {
        return location;
    }

    public void setLocation(LocationId location) {
        this.location = location;
    }
}
