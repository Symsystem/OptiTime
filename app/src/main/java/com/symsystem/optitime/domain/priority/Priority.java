package com.symsystem.optitime.domain.priority;

/**
 * A Priority is a mutable object that represents the priority of a task to do
 *
 * @specfield id : TaskId        // The id of the task.
 * @specfield name : String      // The name that labels and describes the task.

 *
 * @invariant id not null
 * @invariant name not null and not empty String
 *
 * TODO : comprendre ce que fait la dernière méthode
 */

public class Priority {

    private PriorityId id;
    private int priority;


    public void changePriority(int priority) {
        this.priority = priority;
    }

    public PriorityId priorityid(){

        return this.id;
    }

    public int getPriority() {
        return this.priority;
    }
}
