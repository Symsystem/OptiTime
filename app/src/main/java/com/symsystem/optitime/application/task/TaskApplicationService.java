package com.symsystem.optitime.application.task;

import com.symsystem.optitime.application.task.Command.CreateTask;
import com.symsystem.optitime.domain.task.Task;
import com.symsystem.optitime.domain.task.TaskId;
import com.symsystem.optitime.repository.TaskRepository;

/**
 * @author sym
 */

public class TaskApplicationService {

    private final TaskRepository taskRepository;

    public TaskApplicationService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(CreateTask command) {

        TaskId id = new TaskId(command.getTaskId());

        Task task = new Task(id, command.getName());

        return id.id();
    }
}
