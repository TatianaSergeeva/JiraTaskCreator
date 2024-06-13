package com.project.petProject.constants;

public enum Path {

    PATH_PROPERTY("src/main/resources/config.properties");

    private String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}