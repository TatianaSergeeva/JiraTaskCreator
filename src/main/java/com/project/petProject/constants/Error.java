package com.project.petProject.constants;

public enum Error {

    NOT_FILE_ERROR("ОШИБКА: Файл свойств отсуствует!");

    private String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
