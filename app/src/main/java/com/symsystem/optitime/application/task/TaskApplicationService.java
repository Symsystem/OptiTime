package com.symsystem.optitime.application.task;

import com.symsystem.optitime.application.task.Command.ChangeLimitDate;
import com.symsystem.optitime.application.task.Command.CreateTask;
import com.symsystem.optitime.domain.State;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.domain.task.Date;
import com.symsystem.optitime.domain.task.Duration;
import com.symsystem.optitime.domain.task.Task;
import com.symsystem.optitime.domain.task.TaskId;
import com.symsystem.optitime.repository.TaskRepository;

import java.util.Calendar;

import static com.symsystem.optitime.application.task.Command.*;

/**
 * @author sym
 */

public class TaskApplicationService {

    private final TaskRepository taskRepository;

    public TaskApplicationService() {
        this.taskRepository = TaskRepository.getInstance();
    }


    /**
     * @effects Creates a new task
     * @return the id of the newly
     */
    public String createTask(CreateTask command) {

        Task task = new Task(new TaskId(taskRepository.nextIdentity()),
                command.getName());
        taskRepository.save(task);

        return task.id().id();
    }

    public void changeName( ChangeName command) {

        Task task = taskRepository.find(new TaskId(command.getTaskId()));
        task.setName(command.getName());
        taskRepository.save(task);
    }

    public void changeState(ChangeState command) {

        Task task = taskRepository.find(new TaskId(command.getTaskId()));
        task.setState(State.values()[(int)command.getState()-1]);
        taskRepository.save(task);
    }



    public void changeLimitDate(ChangeLimitDate command) {

        Task task = taskRepository.find(new TaskId(command.getTaskId()));

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(command.getDate());
        task.setlimiteDate(new Date(cal));
        taskRepository.save(task);
    }

    public void  setDuration(SetDuration command){
        Task task = taskRepository.find(new TaskId(command.getTaskId()));
        task.setDuration(new Duration((int)command.getMins(),
                (int)command.getHours()));
        taskRepository.save(task);

    }

    public void addPriority(AddPriority command){

        Task task = taskRepository.find(new TaskId(command.getTaskId()));
        task.setPriority(new PriorityId(command.getPriorityId()));
        taskRepository.save(task);
    }

    public void addLocation(AddLocation command){
        Task task = taskRepository.find(new TaskId(command.getTaskId()));
        task.setLocation(new LocationId(command.getLocationId()));
        taskRepository.save(task);
    }



    }
