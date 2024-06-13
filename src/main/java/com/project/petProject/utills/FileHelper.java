package com.project.petProject.utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.project.petProject.constants.Error.NOT_FILE_ERROR;

public class FileHelper {

    public static String getParamFromProperties(String pathProperty, String param) {

        Properties property = new Properties();
        String paramFromProperties;
        FileInputStream fis;

        try {
            fis = new FileInputStream(pathProperty);
            property.load(fis);

            paramFromProperties = property.getProperty(param);
        } catch (IOException e) {
            throw new RuntimeException(NOT_FILE_ERROR.getError());
        }

        return paramFromProperties;
    }
}