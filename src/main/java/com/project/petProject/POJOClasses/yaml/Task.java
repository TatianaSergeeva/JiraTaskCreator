package com.project.petProject.POJOClasses.yaml;

public class Task {

    private String nameTask;
    private String description;
    private String label;

    public Task() {
    }

    public Task(String nameTask) {
        this.nameTask = nameTask;
    }

    public Task(String nameTask, String description) {
        this(nameTask);
        this.description = description;
    }

    public Task(String nameTask, String description, String label) {
        this(nameTask, description);
        this.label = label;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}