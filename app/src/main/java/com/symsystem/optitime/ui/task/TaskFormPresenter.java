package com.symsystem.optitime.ui.task;

/**
 * @author sym
 */

public class TaskFormPresenter {

    private final TaskFormView view;
    private final TaskFormModel model;

    public TaskFormPresenter(TaskFormView view, TaskFormModel model) {
        this.view = view;
        this.model = model;

        addListener();
    }

    ///////////////////
    // HELPER METHOD //
    ///////////////////

    private void addListener() {

    }
}
