package com.symsystem.optitime.domain.priority;

/**
 * A Priority is a mutable object that represents the priority of a task.
 *
 * @specfield id : PriorityId    // The id of the priority.
 * @specfield name : String      // The name that labels the priority.

 *
 * @invariant id not null
 * @invariant name not null and not empty String
 *
 */

public class Priority {

    private final PriorityId id;
    private String name;

    public Priority(PriorityId id, String name) {
        this.id = id;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public PriorityId id(){
        return id;
    }


}
