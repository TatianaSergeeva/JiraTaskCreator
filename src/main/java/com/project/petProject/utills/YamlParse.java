package com.project.petProject.utills;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.project.petProject.POJOClasses.yaml.YamlObject;

import java.io.File;
import java.io.IOException;

public class YamlParse {

    public static YamlObject parseYamlToObject(String path) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        YamlObject test = null;
        try {
            test = mapper.readValue(new File(path), YamlObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return test;
    }
}