package com.symsystem.optitime.application.application.location;


import com.symsystem.optitime.application.location.Command;
import com.symsystem.optitime.domain.location.Location;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.repository.LocationRepository;

/**
 * @author sym
 * @author pierrot ^^
 */

public class LocationApplicationService {

    private final LocationRepository locationRepository;

    public LocationApplicationService() {
        this.locationRepository = LocationRepository.getInstance();
    }


    /**
     * @effects Creates a new template
     * @return the id of the newly
     */
    public String createLocation(Command.CreateLocation command) {
        Location location = new Location( new LocationId(
        locationRepository.nextIdentity()),command.getName());
        locationRepository.save(location);

        return location.locationId().id();
    }

    public void changeName( Command.ChangeName command) {
        Location location = locationRepository.find(
                new LocationId(command.getLocationId())
        );
        location.changeName(command.getName());
        locationRepository.save(location);


    }


    }
