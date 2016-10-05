package com.symsystem.optitime.domain.location;

import com.symsystem.optitime.domain.priority.PriorityId;

/**
 * A Location is a mutable object that represents the location where the task
 * should be performed
 *
 * @specfield id : LocationId    // The id of the location.
 * @specfield name : String      // The name of the location.

 *
 * @invariant id not null
 * @invariant name not null and not empty String
 */

public class Location {

    private final LocationId id;
    private String name;

    public Location(LocationId id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the name of the Location
     */
    public String name() {
        return name;
    }

    /**
     * @requires name not empty
     * @modifies this
     * @effects Sets this.name to name
     */
    public void changeName(String name) {
        this.name = name;
    }

    public LocationId locationId(){

        return this.id;
    }

    public String getName() {
        return name;
    }
}
