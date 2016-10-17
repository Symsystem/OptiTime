package com.symsystem.optitime.application.priority;


import com.symsystem.optitime.application.priority.Command;
import com.symsystem.optitime.domain.priority.Priority;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.repository.PriorityRepository;


/**
 * @author sym
 * @author pierrot ^^
 */

public class PriorityApplicationService {

    private final PriorityRepository priorityRepository;

    public PriorityApplicationService() {
        this.priorityRepository = PriorityRepository.getInstance();
    }


    /**
     * @effects Creates a new template
     * @return the id of the newly
     */
    public String createPriority(Command.CreatePriority command) {
        Priority priority = new Priority( new PriorityId(
                priorityRepository.nextIdentity()),command.getName());
        priorityRepository.save(priority);

        return priority.id().id();
    }

    public void changeName( Command.ChangeName command) {
        Priority priority = priorityRepository.find(
                new PriorityId(command.getPriorityId())
        );

        priority.changeName(command.getName());
        priorityRepository.save(priority);


    }


    }
