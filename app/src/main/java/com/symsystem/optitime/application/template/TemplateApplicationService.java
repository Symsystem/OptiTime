package com.symsystem.optitime.application.template;


import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.domain.task.Duration;
import com.symsystem.optitime.domain.template.Template;
import com.symsystem.optitime.domain.template.TemplateId;
import com.symsystem.optitime.repository.TemplateRepository;

/**
 * @author sym
 * @author pierrot ^^
 */

public class TemplateApplicationService {

    private final TemplateRepository templateRepository;

    public TemplateApplicationService() {
        this.templateRepository = TemplateRepository.getInstance();
    }


    /**
     * @effects Creates a new template
     * @return the id of the newly
     */
    public String createTemplate(Command.CreateTemplate command) {
        Template template = new Template( new TemplateId(
        templateRepository.nextIdentity()),command.getName());
        templateRepository.save(template);

        return template.templateId().id();
    }

    public void changeName( Command.ChangeName command) {
        Template template = templateRepository.find(
                new TemplateId(command.getTemplateId())
        );

        template.setName(command.getName());
        templateRepository.save(template);


    }


    public void  setDuration(Command.SetDuration command){
        Template template = templateRepository.find(
                new TemplateId(command.getTemplateId())
        );
        template.setDuration(new Duration((int)command.getMins(),
                (int)command.getHours()));

        templateRepository.save(template);

    }

    public void addPriority(Command.AddPriority command){

        Template template = templateRepository.find(new TemplateId(
                command.getTemplateId()
        ));
        template.priority(new PriorityId(command.getPriorityId()));

        templateRepository.save(template);
    }

    public void addLocation(Command.AddLocation command){
        Template template = templateRepository.find(new TemplateId(
                command.getTemplateId()
        ));
        template.setLocation(new LocationId(command.getLocationId()));

        templateRepository.save(template);


    }



    }
