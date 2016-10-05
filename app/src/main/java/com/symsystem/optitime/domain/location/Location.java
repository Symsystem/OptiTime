package com.symsystem.optitime.domain.location;

import com.symsystem.optitime.domain.priority.PriorityId;

/**
 * A Location is a mutable object that represents the location where the task
 * should be performed
 *
 * @specfield id : TaskId        // The id of the task.
 * @specfield name : String      // The name that labels and describes the task.

 *
 * @invariant id not null
 * @invariant name not null and not empty String
 *
 * TODO : comprendre ce que fait la dernière méthode
 */

public class Location {

    private LocationId id;
    private String name;


    public void changeName(String name) {
        this.name = name;
    }
    /**
     * @return the name of the Location
     */
    public void Name(String name) {
        this.name = name;
    }

    public LocationId locationId(){

        return this.id;
    }

    public String getName() {
        return name;
    }
}
