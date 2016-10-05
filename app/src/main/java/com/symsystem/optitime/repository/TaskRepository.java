package com.symsystem.optitime.repository;

import com.symsystem.optitime.domain.task.Task;
import com.symsystem.optitime.domain.task.TaskId;

/**
 * @author sym
 */

public final class TaskRepository implements Repository<Task, TaskId> {

    private final DBHandler db;

    public TaskRepository() {
        this.db = DBHandler.getDBHandler();
    }

    @Override
    public void save(Task entity) {

    }

    @Override
    public boolean exists(TaskId entity) {
        return false;
    }

    @Override
    public Task find(TaskId id) {
        return null;
    }
}
