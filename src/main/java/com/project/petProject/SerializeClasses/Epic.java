package com.project.petProject.SerializeClasses;

import java.util.List;

public class Epic {
    private String title;
    private List<Task> taskList;

    public Epic(String title, List<Task> taskList) {
        this.title = title;
        this.taskList = taskList;
    }

    public Epic(String title) {
        this.title = title;
    }

    public Epic() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
