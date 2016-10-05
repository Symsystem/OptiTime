package com.symsystem.optitime.application.task;

import com.symsystem.optitime.application.task.Command.AddLimitDate;
import com.symsystem.optitime.application.task.Command.CreateTask;
import com.symsystem.optitime.domain.task.Date;
import com.symsystem.optitime.domain.task.Task;
import com.symsystem.optitime.domain.task.TaskId;
import com.symsystem.optitime.repository.TaskRepository;

import java.util.Calendar;

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

        return task.id().id();
    }

    public void addLimitDate(AddLimitDate command) {

        Task task = taskRepository.find(new TaskId(command.getTaskId()));

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(command.getDate());
        task.setlimiteDate(new Date(cal));
    }
}
