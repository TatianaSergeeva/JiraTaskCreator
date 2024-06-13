package com.project.petProject.POJOClasses.yaml;

import java.util.List;

public class YamlObject {

    private String title;
    private List<Task> taskList;

    public YamlObject() {
    }

    public YamlObject(String title) {
        this.title = title;
    }

    public YamlObject(String title, List<Task> taskList) {
        this(title);
        this.taskList = taskList;
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